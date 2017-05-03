package multi.chapter7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * �����嵥 7-1 �� 7-2
 * p.126
 * �̰߳�ȫ��,ʹ��volatile���͵���������ȡ��״̬
 * ����������
 * @author ahs2
 *
 */
public class PrimeGeneratorTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(new PrimeGeneratorTest().aSecondOfPrimes());
	}
	
	/**
	 * ��������������1���Ӻ�ȡ��,��ͨ��������պ���1���Ӻ�ֹͣ����Ϊ������ȡ����ʱ�̺�run����
	 * ��ѭ��ִ����һ�μ��֮����ܴ����ӳ�.
	 * cancel������finally����ã��Ӷ�ȷ����ʹ�ڵ���sleepʱ���ж�Ҳ��ȡ��������������ִ��
	 * ���cancelû�б����ã���ô�����������߳̽���Զ������ȥ����������CPU��ʱ�����ڣ���ʹ��JVM���������˳�
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
	 * PrimeGenerator ʹ����һ�ּ򵥵�ȡ�����ԣ�
	 *    �ͻ�����ͨ������cancel������ȡ����PrimeGenerator��ÿ����������ǰ�����ȼ���Ƿ����ȡ����������������˳�.
	 * ����֮��(p.132):
	 *    ���PrimeGenerator�׳���һ��δ�����쳣����ô����쳣���ܻᱻ���ԣ���Ϊ��������������һ���������߳������У�������̲߳�����ʾ�ش����쳣
	 * �Ľ��ķ�������� p.132  7-8���룬ʹ������ָ��ʱ��������һ�������Runnableʾ�������ڵ����߳����������񣬲�������һ��ȡ������������ָ����ʱ�������ж���
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
