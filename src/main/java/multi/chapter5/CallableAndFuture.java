package multi.chapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// http://www.cnblogs.com/whgw/archive/2011/09/28/2194760.html
public class CallableAndFuture {

	public static class MyCallable implements Callable{
	
		private int flag = 0;
		public MyCallable(int flag){
			this.flag = flag;
		}
		
		public String call() throws Exception{
			if(this.flag == 0){
				return "flag == 0";
			}
			if(this.flag == 1){
				try {
					while(true){
						System.out.println("looping.");
						Thread.sleep(2000);
					}
				} catch (InterruptedException e) {
			       System.out.println("Interrupted");
				}
				return "false";
			}else{
				throw new Exception("Bad flag value");
			}
		}
	}
	
	public static void main(String[] args){
		
		MyCallable task1 = new MyCallable(0);
		MyCallable task2 = new MyCallable(1);
		MyCallable task3 = new MyCallable(2);
		
		//����һ��ִ������ķ���
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		try {
			//�ύ��ִ��������������ʱ������һ��Future��������õ�����ִ�еĽ���������쳣�ɶ����Future������в���
//			Future future1 = es.submit(task1);	
//			System.out.println("task1:"+future1.get());
//			
//			//��ȡ������������������Ϊִ�е���������������쳣
//			Future future3 = es.submit(task3);
//			System.out.println("task3:"+future3.get());
//			
//			//�ȴ�5s����ִ�еڶ���������Ϊ�ڶ���������е�������ѭ��
//			Future future2 = es.submit(task2);
//			Thread.sleep(5000);
//			System.out.println("task2:"+future2.get());
			
			// ��ʽ1��p.118 ������ʹ��FutureTask��װ���ύ��ExecutorService��ִ��
			FutureTask futureTask = new FutureTask(task1);
			Future future4 = es.submit(futureTask);
			System.out.println("future4:"+futureTask.get());
			
			// ��ʽ2��ֱ�ӵ���FutureTask��run������ִ��
			futureTask.run();
			System.out.println("futureTask:"+futureTask.get());
			
		} catch (Exception e) {
			System.out.println("�쳣message:"+e.getMessage());
		}
		
		//ֹͣ����ִ�з���
		es.shutdown();
	}
}
