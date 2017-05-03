package chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// p.108 ���е�Web������  ÿ��ֻ�ܴ���һ������
public class SingleThreadWebServer {

	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(80);
		while(true){
			Socket connention = socket.accept();
			//TODO handleRequest(connection)	
		}
	}
}
