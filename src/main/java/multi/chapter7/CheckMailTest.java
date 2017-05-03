package multi.chapter7;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// 7-20  p.143  ����һ�������ҵ��������񶼴�����ɺ�ŷ���
public class CheckMailTest {

	// ʹ��˽�е�Executor������ԓExecutro���������������ڷ����{��
	boolean checkMail(Set<String> hosts,long timeout,TimeUnit unit) throws InterruptedException{
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		/**
		 * ����AtomicBoolean���volatile���͵�boolean������Ϊ�ܴ��ڲ���Runnable��
		 * ����hasNewMail��ʶ�������������final�������ⱻ�޸�
		 * �������Ϊ volatile boolean hasNewMail = false;  ���ڴ˴����ڲ��࣬�ڲ�����Ҫ���ʷ����Ĳ����������ж���ı�������Щ���������
		 * ǰ��һ��Ҫ����һ��final�ؼ���(�� http://blog.csdn.net/liushuai_ly/article/details/8197564);
		 * ���ǲ��ɱ�ľֲ��������ܱ���ֵ����Ϊ���Ѿ���������һ�����������,���ǿ��Զ������������ϣ�
		 * ����final��volatile�ֲ���ͬʱ����(http://blog.csdn.net/lovewaterman/article/details/40342669)
		 * 
		 * �˴�hasNewMail�ֶε�Ŀ�ģ����ڲ���ʹ��
		 */
		final AtomicBoolean hasNewMail = new AtomicBoolean(false);
		try {
			for(final String host :hosts){
				exec.execute(new Runnable(){
					@Override
					public void run() {
			             if(checkMail(host)){
			            	 hasNewMail.set(true);
			             }					
					}
				});
			}
		} finally {
			exec.shutdown();
			exec.awaitTermination(timeout, unit);
		}
		return hasNewMail.get();
	}
	
	private boolean checkMail(String host) {
		return false;
	}
}
