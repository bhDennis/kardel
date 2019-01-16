package multi.chapter5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * http://www.cnblogs.com/liuling/p/2013-8-20-03.html
 * 单个信号量的Semaphore对象可以实现互斥锁的功能，并且可以是由一个线程获得了锁，再由
 * 另一个线程释放锁，这可以用于死锁恢复的场合
 * @author ahs2
 *
 */
public class LockTest {

	public static void main(String[] args) {
		
		final Business business = new Business();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for(int i = 0;i<3;i++){
			executor.execute(new Runnable(){
				@Override
				public void run() {
					business.service();			
				}
			});
		}
		executor.shutdown();
	}
	
	private static class Business{
		
		private int count;
		Lock lock = new ReentrantLock();
		Semaphore sp = new Semaphore(1);
		
		public void service(){
				
//			lock.lock();
			try {
				sp.acquire();//当前线程使用count便利的时候将其锁住，不允许其他线程访问
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			try {
				count++;	
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("count:"+count+"，线程名:"+Thread.currentThread().getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				sp.release();//释放锁
			}
		}
	}
}
