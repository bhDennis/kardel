package chapter5;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//启动桌面搜索
public class StartIndexMain {

	private static final Integer BOUND = 90;
	private static final Integer N_CONSUMERS = 5;
	public static void startIndexing(File[] roots){
		
		BlockingQueue<File> queue = new LinkedBlockingQueue<File>(BOUND);
		FileFilter filter = new FileFilter(){

			@Override
			public boolean accept(File arg0) {			
				return true;
			}		
		};
		
		for(File root : roots){
			new Thread(new FileCrawler(queue,filter,root)).start();
		}
		
		for(int i = 0;i<N_CONSUMERS;i++){
			new Thread(new Indexer(queue)).start();
		}
	}
}
