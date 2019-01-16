package multi.chapter5;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

// http://xijunhu.iteye.com/blog/713433
public class CyclicBarrierTest {

	public static class ComponentThread implements Runnable{

		CyclicBarrier barrier;//计数器
		int id;//组件标识
		int[] array;//数据数组
		
		public ComponentThread(CyclicBarrier barrier,int[] array,int id){
			this.barrier = barrier;
			this.id = id;
			this.array = array;
		}
		@Override
		public void run() {
					
			try {
				array[id] = new Random().nextInt(100);
				System.out.println(id+"-Component generates-"+array[id]);

				//在这里等待Barrier
				System.out.println(id+"-Component sleep");
				barrier.await();

				//计算数据数组中的当前值和后续值
				System.out.println(id+"-Component awake");
				int result = (array[id] + array[id+1]);
				System.out.println(id+"-Component,result:"+result);

			} catch (Exception e) {
				
			} 
		}		
	}
	
	public static void testCyclicBarrier(){
		final int[] array = new int[3];
		CyclicBarrier barrier = new CyclicBarrier(2,new Runnable(){
			@Override
			public void run() {
			   System.out.println("优先执行barrierAction");
			   array[2] = array[0]+array[1];
			}			
		});	// barrier里的Runnable在CyclicBarrier的数目达到2时并且所有被CyclicBarrier.await()进入等待的线程被唤醒前执行
		
		new Thread(new ComponentThread(barrier,array,0)).start();
		new Thread(new ComponentThread(barrier,array,1)).start();
	}
	
	public static void main(String[] args){
		CyclicBarrierTest.testCyclicBarrier();
	}
}
