package chapter5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * http://www.cnblogs.com/liuling/p/2013-8-20-03.html
 * �����ź�����Semaphore�������ʵ�ֻ������Ĺ��ܣ����ҿ�������һ���̻߳������������
 * ��һ���߳��ͷ�������������������ָ��ĳ���
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
				sp.acquire();//��ǰ�߳�ʹ��count������ʱ������ס�������������̷߳���
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
				System.out.println("count:"+count+"���߳���:"+Thread.currentThread().getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				sp.release();//�ͷ���
			}
		}
	}
}
