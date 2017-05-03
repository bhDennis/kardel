package multi.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 *  p.114 ֧�ֹرղ�����web������
 *  ExecutorService ��չ��Executor�ӿڣ������һЩ�����������ڹ���ķ���
 *  shutdown������ִ��ƽ���Ĺرչ��̣����ٽ����µ�����ͬʱ�ȴ��Ѿ��ύ������ִ����ɣ�����Щ��δ��ʼִ�е�����
 *  shutdownNow������ִ�дֱ��Ĺرչ��̣�������ȡ�����������е����񣬲��Ҷ�����������δ��ʼִ�е�����
 *  isTerminated�����Ե��ø÷�������ѯExecutorService�Ƿ��Ѿ���ֹ
 *  awaitTermination�����ø÷������ȴ�ExecutorService������ֹ״̬��ͨ���ڵ����˸÷����������ִ��shutdown���Ӷ�����ͬ���عر�ExecutorService��Ч��
 *  @author ahs2
 *
 */
public class LifecycleWebServer {

	private final ExecutorService exec = Executors.newFixedThreadPool(100);
	
	public void start() throws IOException{
		ServerSocket socket = new ServerSocket(80);
		while(!exec.isShutdown()){
			try {
				final Socket conn = socket.accept();
				exec.execute(new Runnable(){

					@Override
					public void run() {
						
						//handleRequest(conn);
					}
					
				});
			} catch (RejectedExecutionException e) {
			
				if(!exec.isShutdown()){
					// log("task submission rejected",e);	
				}
			}
		}
	}
	
	public void stop(){
		exec.shutdown();
	}
	
}
