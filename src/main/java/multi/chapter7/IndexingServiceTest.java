package multi.chapter7;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// 7-17 通过“毒丸”对象来关闭服务   无界队列中，“毒丸”对象才能可靠地工作
public class IndexingServiceTest {

	private static final File POISON = new File("");
	private final IndexerThread consumer = new IndexerThread();
	private final CrawlerThread producer = new CrawlerThread();
	private final BlockingQueue<File> queue;
	private final File root;

	private IndexingServiceTest(){
		queue = new LinkedBlockingQueue<File>(50); 
		root = new File("");
	}
	
	public void start(){
		producer.start();
		consumer.start();
	}
	public void stop(){
		producer.interrupt();
	}
	public void awaitTermination() throws InterruptedException{
		consumer.join();
	}

	//消费者线程
	class IndexerThread extends Thread{
		
		@Override
		public void run() {
           
			try {
				while(true){
					File file = queue.take();
					if(file == POISON){
						break;
					}else{
						indexFile(file);
					}
				}
			} catch (InterruptedException e) {
			}
		}
		private void indexFile(File file) {
			
			
		}
	}
	//生产者线程
	class CrawlerThread extends Thread{
		
		@Override
		public void run() {
            try {
				crawl(root);
			} catch (Exception e) {
				
			} finally {
				  try {
					while(true){
						queue.put(POISON);
						break;  
					  }
				} catch (InterruptedException e) {
			         // retry
				}
			}
		}

		private void crawl(File root) {
			
		}
	}
}
