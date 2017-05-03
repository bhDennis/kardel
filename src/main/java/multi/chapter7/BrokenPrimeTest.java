package multi.chapter7;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * p.127 ����7-3
 * ���ɿ���ȡ�������������������������Ĳ�����
 * ��������ߵ��ٶȳ����������ߴ����ٶȣ����н���������
 * put����Ҳ�������������ʱ������ϣ��ͨ������
 * cancel����������cancelled��ʶ����������
 * ȴ��ԶҲ���ܼ�������ʶ����Ϊ���޷���������put�����лָ�����
 * 
 * ʹ���жϿ�����ȡ������ �����嵥 7-5 (p.129)������Ѱ����������֮ǰ����ж�
 * @author ahs2
 *
 */
public class BrokenPrimeTest {

	//�������߳���������������һ����������
	class BrokenPrimeProducer extends Thread {
		
		private final BlockingQueue<BigInteger> queue;
		
		private volatile boolean cancelled = false;
		
		BrokenPrimeProducer(BlockingQueue<BigInteger> queue){
			this.queue = queue;
		}
		
		public void run(){
			
			try {
				BigInteger p = BigInteger.ONE;
				while(!cancelled){  // !Thread.currentThread().isInterrupted() ���Խ���������������������⣬��Ϊ����������Ѱ����������֮ǰ����жϵ�
					queue.put(p = p.nextProbablePrime());
				}
			} catch (InterruptedException e) {
				//�����߳��˳�
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
