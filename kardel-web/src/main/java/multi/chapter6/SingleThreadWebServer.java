package multi.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// p.108 串行的Web服务器  每次只能处理一个请求
public class SingleThreadWebServer {

	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(80);
		while(true){
			Socket connention = socket.accept();
			//TODO handleRequest(connection)	
		}
	}
}
