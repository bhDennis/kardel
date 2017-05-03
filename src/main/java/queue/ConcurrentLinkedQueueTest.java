package queue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://www.cnblogs.com/linjiqin/archive/2013/05/30/3108188.html
 * ��������ConcurrentLinkedQueue ʵ����Queue  ��FIFO���򣬲���CAS��������֤һ����
 * @author ahs2
 *
 */
public class ConcurrentLinkedQueueTest {

	private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	private static int count = 2;//�̸߳���
	
	private static CountDownLatch latch = new CountDownLatch(count);
	
	public static void main(String[] args) throws InterruptedException{
		
		long timeStart = System.currentTimeMillis();
		ExecutorService exec = Executors.newFixedThreadPool(4);
		ConcurrentLinkedQueueTest.offer();
		
		for(int i=0;i<count;i++){
			exec.submit(new Poll());
		}
		latch.await();
		System.out.println("cost time"+(System.currentTimeMillis()-timeStart)+"ms");
		exec.shutdown();
	}
	
	//����
	public static void offer(){
		for(int i=0;i<100000;i++){
			queue.offer(i);
		}
	}
	
	//����
	static class Poll implements Runnable{
		@Override
		public void run() {
			while(!queue.isEmpty()){ //�ĳ� queue.size()>0  cost time 6226ms�����ܴ� size()��Ҫ����һ�鼯�ϵ�
				System.out.println(queue.poll());
			}
			latch.countDown();
		}
	}
}
