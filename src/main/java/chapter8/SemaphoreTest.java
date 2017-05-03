package chapter8;

import java.util.concurrent.Semaphore;

/**
 * һ�������ź���
 * http://blog.csdn.net/zzy7075/article/details/52095773
 * @author ahs2
 *
 */
public class SemaphoreTest {

	public static void main(String[] args) {
		
		int N = 8;//��������
		
		Semaphore semaphore = new Semaphore(5);//������Ŀ
		
		for(int i=0;i<N;i++){
			new Worker(i,semaphore).start();
		}
	}
	
	static class Worker extends Thread{
		private int num;
		private Semaphore semaphore;
		public Worker(int num,Semaphore semaphore){
			this.num = num;
			this.semaphore = semaphore;
		}
		
		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("����"+this.num+"ռ��һ������������");
				Thread.sleep(2000);
				System.out.println("����"+this.num+"�ͷŻ���");
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
