package multi.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * p.109 主线程仍然不断地交替执行"接受外部连接"与"分发请求"
 * 对于每个连接，主循环都将创建一个新线程来处理请求，而不是在主循环中进行处理
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
