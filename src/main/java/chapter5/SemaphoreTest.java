package chapter5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * http://blog.csdn.net/shihuacai/article/details/8856526
 * Semaphore��һ���߳�ͬ���ĸ����࣬����ά����ǰ����������̸߳��������ṩ��ͬ������
 * ���Կ���ͬʱ������Դ���̸߳��������磺ʵ��һ���ļ�����Ĳ���������
 * @author ahs2
 *
 */
public class SemaphoreTest {

	public static void main(String[] args) {
		
		//�̳߳�
		ExecutorService exec = Executors.newCachedThreadPool();
		
		//ֻ��5���߳�ͬʱ����
		final Semaphore semp = new Semaphore(5);
		
		//ģ��20���ͻ��˷���
		for(int index = 0;index<20;index++){
			
			final int NO = index;
			Runnable run = new Runnable(){
				@Override
				public void run() {
					
			      try {
					 semp.acquire();
					 System.out.println("Accessing:"+NO);
					 Thread.sleep((long) (Math.random()) * 10000);
					 
					 //��������ͷţ������������䣬���ڿ���ֻ̨�ܴ�ӡ��5����¼��֮���߳�һֱ����
					 semp.release();
				     } catch (InterruptedException e) {}			
				}
			};
//			System.out.println("���ش��ź����е�ǰ���������:"+semp.availablePermits());
//			System.out.println("�Ƿ����߳����ڵȴ���ȡ:"+semp.hasQueuedThreads());
			exec.execute(run);
		}
		//�˳��̳߳�
		exec.shutdown();
	}
}
