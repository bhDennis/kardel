package queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * http://www.cnblogs.com/linjiqin/archive/2013/05/30/3108188.html
 * ��������LinkedBlockingQueue: �̰߳�ȫ  �Ƚ��ȳ�
 *    put�����ڶ�������ʱ�������ֱ���ж��г�Ա������
 *    take�����ڶ��пյ�ʱ���������ֱ���ж��г�Ա���Ž���
 * @author ahs2
 *
 */
public class BlockingQueueTest {

	//����װƻ��������
	class Basket{
		
		BlockingQueue<String> basket = new LinkedBlockingQueue<String>(3);//���ӣ�������3��ƻ��
		
		public void produce() throws InterruptedException{
			basket.put("An apple");
		}
		
		public String consume() throws InterruptedException{
			return basket.take();
		}
	}
	
	class Producer implements Runnable{
		
		private String instance;
		private Basket basket;
		
		public Producer(String instance,Basket basket){
			this.instance = instance;
			this.basket = basket;
		}
		@Override
		public void run() {
			try {
				while(true){
					System.out.println("������׼������ƻ��"+instance);
					basket.produce();
					System.out.println("����������ƻ�����"+instance);
					Thread.sleep(300);
				}
			} catch (InterruptedException e) {
				System.out.println("Producer Interrupted");
			}
		}
	}
	
	class Consumer implements Runnable{
		
		private String instance;
		private Basket basket;
		
		public Consumer(String instance,Basket basket){
			this.instance = instance;
			this.basket = basket;
		}	
		@Override
		public void run(){
			try {
				while(true){
					System.out.println("������׼������ƻ��"+instance);
					System.out.println(basket.consume());
					System.out.println("����������ƻ�����"+instance);				
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				System.out.println("Consumer Interrupted");
			}	
		}
	}
	
	public static void main(String[] args) {
		
		BlockingQueueTest test = new BlockingQueueTest();
		Basket basket = test.new Basket();//����һ��ƻ��������		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		//����������
		Producer producer = test.new Producer("������001",basket);
		Producer producer2 = test.new Producer("������002",basket);
		
		//һ��������
		Consumer consumer = test.new Consumer("������001",basket);
		
		//��������
		exec.submit(producer);
		exec.submit(producer2);
		exec.submit(consumer);
		
		//��������5s����������ֹͣ
		try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exec.shutdownNow();
	}
}
