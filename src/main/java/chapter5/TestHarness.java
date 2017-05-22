package chapter5;

import java.util.concurrent.CountDownLatch;

// p.94 测试n个线程并发执行某个任务时需要的时间
public class TestHarness {

	public long timeTasks(int nThreads,final Runnable task) throws InterruptedException{
		
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		
		for(int i=0;i<nThreads;i++){
			Thread t = new Thread(){  // 即将 每个task放到一个线程中去执行
				@Override
				public void run() {
				   try {
					   startGate.await();
					   try {
						  task.run();
					   } finally {
						  endGate.countDown();
					   }
				   } catch (InterruptedException e) {

				   }
				}
			};
			t.start();
		}
		
		long start = System.currentTimeMillis();
		startGate.countDown();
		endGate.await();
		long end = System.currentTimeMillis();
		
		return end -start;
	}
	
//	public long timeTasks(int nThreads,final Runnable task) throws InterruptedException{
//		
//		final CountDownLatch startGate = new CountDownLatch(1);
//		final CountDownLatch endGate = new CountDownLatch(nThreads);
//		
//		for(int i = 0;i<nThreads;i++){
//			ExecuteThread exec = new ExecuteThread(task,startGate,endGate);
//			Thread t = new Thread(exec);
//			t.start();
//		}
//		
//		long start = System.currentTimeMillis();
//		startGate.countDown();
//		endGate.await();
//		long end = System.currentTimeMillis();
//		return end -start;
//	}
//	
//	class ExecuteThread implements Runnable{
//
//		private final Runnable task;
//		private CountDownLatch startGate;
//		private CountDownLatch endGate;
//		public ExecuteThread(final Runnable task,CountDownLatch startGate,CountDownLatch endGate){
//			this.task = task;
//			this.startGate = startGate;
//			this.endGate = endGate;
//		}
//		@Override
//		public void run() {
//		   try {
//			   startGate.await();
//			   try {
//				  task.run();
//			   } finally {
//				  endGate.countDown();
//			   }
//		   } catch (InterruptedException e) {
//			   
//		   }
//		}
//		
//	}

}
