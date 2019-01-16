package multi.chapter8;

import java.util.concurrent.ThreadFactory;

//p.160 8-5 自定义的线程工厂
public class MyThreadFactory implements ThreadFactory {

	private final String poolName;
	
	public MyThreadFactory(String poolName){
		this.poolName = poolName;
	}
	@Override
	public Thread newThread(Runnable arg0) {		
		return new MyAppThread(arg0,poolName);
	}
}
