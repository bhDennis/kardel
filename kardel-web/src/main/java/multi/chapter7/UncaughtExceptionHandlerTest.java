package multi.chapter7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UncaughtExceptionHandlerTest {

}

//程序清单7-25 p.148 UncaughtExceptionHandler 能检测出某个由于未捕获的异常而终结的情况  和 ThreadPoolTest提供的主动处理非正常的线程终止 相互结合，可以有效的防止线程泄露的问题
class UEHLogger implements Thread.UncaughtExceptionHandler{

	//将异常写入日志的UncaughtExceptionHandler
	@Override
	public void uncaughtException(Thread t, Throwable e) {
	  
		Logger logger = Logger.getAnonymousLogger();
		logger.log(Level.SEVERE,"Thread terminated with exception :"+t.getName(),e);
	}
	
}
