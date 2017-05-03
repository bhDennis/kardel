package multi.chapter7;

//�����嵥 7-26
public class JVMTest {

	final class LogService{		
		public void stop(){	}
	}
	
	//ͨ��ע��һ���رչ�����ֹͣ��־����
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
