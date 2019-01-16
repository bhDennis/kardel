package multi.chapter7;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * p.127 程序7-3
 * 不可靠的取消操作将把生产者置于阻塞的操作中
 * 如果生产者的速度超过了消费者处理速度，队列将被填满，
 * put方法也会阻塞，如果此时消费者希望通过调用
 * cancel方法来设置cancelled标识，但生产者
 * 却永远也不能检查这个标识，因为它无法从阻塞的put方法中恢复过来
 *
 * 使用中断可以来取消，见 程序清单 7-5 (p.129)，即在寻找素数任务之前检查中断
 * @author ahs2
 *
 */
public class BrokenPrimeTest {

	//生产者线程生成素数并放入一个阻塞队列
	class BrokenPrimeProducer extends Thread {
		
		private final BlockingQueue<BigInteger> queue;
		
		private volatile boolean cancelled = false;
		
		BrokenPrimeProducer(BlockingQueue<BigInteger> queue){
			this.queue = queue;
		}
		
		public void run(){
			
			try {
				BigInteger p = BigInteger.ONE;
				while(!cancelled){  // !Thread.currentThread().isInterrupted() 可以解决由于生产者阻塞的问题，因为它是在启动寻找素数任务之前检查中断的
					queue.put(p = p.nextProbablePrime());
				}
			} catch (InterruptedException e) {
				//允许线程退出
			}
		}
		
		public void cancel(){
			cancelled = true;
		}
	}
	
	public void concumePrimes() throws InterruptedException{
		
		BlockingQueue<BigInteger> primers = new ArrayBlockingQueue<BigInteger>(6);
		BrokenPrimeProducer producer = new BrokenPrimeProducer(primers);
		producer.start();
		try {
			while(needMorePrimers()){
				consume(primers.take());
			}
		} finally {
			producer.cancel();
		} 
	}

	private boolean needMorePrimers() {
		return false;
	}

	private void consume(BigInteger take) {	}
}
