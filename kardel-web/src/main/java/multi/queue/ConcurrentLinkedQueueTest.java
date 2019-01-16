package multi.queue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://www.cnblogs.com/linjiqin/archive/2013/05/30/3108188.html
 * 并发队列ConcurrentLinkedQueue 实现了Queue  按FIFO排序，采用CAS操作，保证一致性
 * @author ahs2
 *
 */
public class ConcurrentLinkedQueueTest {

	private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	private static int count = 2;//
	
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

	//生产
	public static void offer(){
		for(int i=0;i<100000;i++){
			queue.offer(i);
		}
	}

	//消费
	static class Poll implements Runnable{
		@Override
		public void run() {
			while(!queue.isEmpty()){ //改成 queue.size()>0  cost time 6226ms，相差很大 size()是要遍历一遍集合的
				System.out.println(queue.poll());
			}
			latch.countDown();
		}
	}
}
