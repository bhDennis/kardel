package multi.chapter7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 程序清单 7-1 和 7-2
 * p.126
 * 线程安全的,使用volatile类型的域来保存取消状态
 * 素数生成器
 * @author ahs2
 *
 */
public class PrimeGeneratorTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(new PrimeGeneratorTest().aSecondOfPrimes());
	}

	/**
	 * 素数生成器允许1秒钟后取消,但通常并不会刚好在1秒钟后停止，因为在请求取消的时刻和run方法
	 * 中循环执行下一次检查之间可能存在延迟.
	 * cancel方法由finally块调用，从而确保即使在调用sleep时被中断也能取消素数生成器的执行
	 * 如果cancel没有被调用，那么搜索素数的线程将永远运行下去，不断消耗CPU的时钟周期，并使得JVM不能正常退出
	 * @return
	 * @throws InterruptedException
	 */
	public List<BigInteger> aSecondOfPrimes() throws InterruptedException{
		
		PrimeGenerator generator = new PrimeGenerator();
	
		new Thread(generator).start();
		try {
			Thread.sleep(1);
		} finally {
		    generator.cancel();
		}
		return generator.get();
	}
}

/**
 *
 * PrimeGenerator 使用了一种简单的取消策略：
 *    客户代码通过调用cancel来请求取消，PrimeGenerator在每次搜索素数前会首先检查是否存在取消请求，如果存在则退出.
 * 不足之处(p.132):
 *    如果PrimeGenerator抛出了一个未检查的异常，那么这个异常可能会被忽略，因为素数生成器在另一个独立的线程中运行，而这个线程不会显示地处理异常
 * 改进的方案代码见 p.132  7-8代码，使用了在指定时间内运行一个任意的Runnable示例，它在调用线程中运行任务，并安排了一个取消任务，在运行指定的时间间隔后中断它
 *
 */
  class PrimeGenerator implements Runnable{
	
		private final List<BigInteger> primes = new ArrayList<BigInteger>();
		
		private volatile boolean cancelled;
		
		@Override
		public void run() {
			
	        BigInteger p = BigInteger.ONE;
	        while(!cancelled){
	        	p = p.nextProbablePrime();
	        	synchronized(this){
	        		primes.add(p);
	        	}
	        }
		}
		
		public void cancel(){
			cancelled = true;
		}
		
		public synchronized List<BigInteger> get(){
			return new ArrayList<BigInteger>(primes);
		}
}
