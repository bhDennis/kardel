package multi.chapter7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UncaughtExceptionHandlerTest {

}

//�����嵥7-25 p.148 UncaughtExceptionHandler �ܼ���ĳ������δ������쳣���ս�����  �� ThreadPoolTest�ṩ������������������߳���ֹ �໥��ϣ�������Ч�ķ�ֹ�߳�й¶������
class UEHLogger implements Thread.UncaughtExceptionHandler{

	//���쳣д����־��UncaughtExceptionHandler
	@Override
	public void uncaughtException(Thread t, Throwable e) {
	  
		Logger logger = Logger.getAnonymousLogger();
		logger.log(Level.SEVERE,"Thread terminated with exception :"+t.getName(),e);
	}
	
}
