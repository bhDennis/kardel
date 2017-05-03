package chapter8;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * p.159  �����嵥 8-4
 * ʹ��Semaphore������������ύ����  ǰ�᣺�޽����
 * http://blog.csdn.net/zzy7075/article/details/52095773
 * @author ahs2
 *
 */
public class BoundedExecutorTest {

	private final Executor exec;
	
	private final Semaphore semaphore;
	
	public BoundedExecutorTest(Executor exec,int bound){
		this.exec = exec;
		this.semaphore = new Semaphore(bound);//����bound��ʾ�����Ŀ����ͬʱ������������߳̽��з���
	}
	
	public void submitTask(final Runnable command) throws InterruptedException{
		semaphore.acquire();//��ȡһ�����
		try {
			exec.execute(new Runnable(){

				@Override
				public void run() {
					try {
						command.run();
					} catch (Exception e) {
						semaphore.release();//�ͷ�һ�����
					}		
				}		
			});
//			exec.execute(command);  ������д��ԭ������Ϊcommand��Ȼ��һ��ʵ��Runnable���߳��࣬����û�в���start��������
		} catch (RejectedExecutionException e) {
			semaphore.release();
		}
	}
}
