package chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * p.109 ���߳���Ȼ���ϵؽ���ִ��"�����ⲿ����"��"�ַ�����"
 * ����ÿ�����ӣ���ѭ����������һ�����߳����������󣬶���������ѭ���н��д���
 * 
 * 
 * @author ahs2
 *
 */
public class ThreadPerTaskWebServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket socket = new ServerSocket(80);
		while(true){
			final Socket connnection = socket.accept();
			Runnable task = new Runnable(){

				@Override
				public void run() {
					//handleRequest(connection);					
				}	
			};
			
			new Thread(task).start();
		}
	}
}
