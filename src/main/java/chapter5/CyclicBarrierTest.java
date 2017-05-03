package chapter5;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

// http://xijunhu.iteye.com/blog/713433
public class CyclicBarrierTest {

	public static class ComponentThread implements Runnable{

		CyclicBarrier barrier;//������
		int id;//�����ʶ
		int[] array;//��������
		
		public ComponentThread(CyclicBarrier barrier,int[] array,int id){
			this.barrier = barrier;
			this.id = id;
			this.array = array;
		}
		@Override
		public void run() {
					
			try {
				array[id] = new Random().nextInt(100);
				System.out.println("Component "+id+" generates"+array[id]);
				
				//������ȴ�Barrier
				System.out.println("Component "+id+" sleep");
				barrier.await();
				System.out.println("Component "+id+" awaked");
				
				//�������������еĵ�ǰֵ�ͺ���ֵ
				int result = array[id] + array[id+1];
				System.out.println("Component "+id+" result:"+result);
				
			} catch (Exception e) {
				
			} 
		}		
	}
	
	public static void testCyclicBarrier(){
		final int[] array = new int[3];
		CyclicBarrier barrier = new CyclicBarrier(2,new Runnable(){
			@Override
			public void run() {
			   System.out.println("testCyclicBarrier run");
			   array[2] = array[0]+array[1];
			}			
		});
		
		new Thread(new ComponentThread(barrier,array,0)).start();
		new Thread(new ComponentThread(barrier,array,1)).start();
	}
	
	public static void main(String[] args){
		CyclicBarrierTest.testCyclicBarrier();
	}
}
