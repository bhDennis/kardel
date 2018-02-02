package multi.chapter7;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// 7-20  p.143  处理一批任务并且等所有任务都处理完成后才返回
public class CheckMailTest {

	// 使用私有的Executor，并且該Executro的生命周期受限于方法調用
	boolean checkMail(Set<String> hosts,long timeout,TimeUnit unit) throws InterruptedException{
		
		ExecutorService exec = Executors.newCachedThreadPool();

		/**
		 * 采用AtomicBoolean替代volatile类型的boolean，是因为能从内部的Runnable中
		 * 访问hasNewMail标识，因此它必须是final类型以免被修改
		 * 如果定义为 volatile boolean hasNewMail = false;  由于此处是内部类，内部类想要访问方法的参数货方法中定义的变量，这些参数或变量
		 * 前面一定要增加一个final关键字(见 http://blog.csdn.net/liushuai_ly/article/details/8197564);
		 * 但是不可变的局部变量不能被赋值，因为它已经被定义在一个封闭类型中,但是可以定义成数组货集合，
		 * 但是final和volatile又不能同时存在(http://blog.csdn.net/lovewaterman/article/details/40342669)
		 *
		 * 此处hasNewMail字段的目的：被内部类使用
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
