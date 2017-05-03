package multi.chapter5;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * �����ߴӶ�����ȡ���ļ����Ʋ������ǽ�������
 * @author ahs2
 *
 */
public class Indexer implements Runnable {

	private final BlockingQueue<File> queue;
	
	public Indexer(BlockingQueue<File> queue){
		
		this.queue = queue;
	}
	
	@Override
	public void run() {
	
		try {
			while(true){
				indexFile(queue.take());
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	private void indexFile(File take) {
		// TODO Auto-generated method stub
		
	}

}