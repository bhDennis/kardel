package multi.chapter7;

//程序清单 7-26
public class JVMTest {

	final class LogService{		
		public void stop(){	}
	}
	//通过注册一个关闭钩子来停止日志服务
	public void start(){
		Runtime.getRuntime().addShutdownHook(new Thread(){
			
			public void run(){
				try {
					new LogService().stop();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
