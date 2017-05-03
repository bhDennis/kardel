package multi.chapter5;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * p.89
 * ��ĳ���ļ���νṹ����������������׼���ļ����������ǵ����Ʒ���
 * ��������
 * @author ahs2
 *
 */
public class FileCrawler implements Runnable {

	private final BlockingQueue<File> fileQueue;
	private final FileFilter fileFileter;
	private final File root;
	
	
	public FileCrawler(BlockingQueue<File> fileQueue, FileFilter fileFileter, File root) {
		super();
		this.fileQueue = fileQueue;
		this.fileFileter = fileFileter;
		this.root = root;
	}

	@Override
	public void run() {

		try {
			craw1(root);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	private void craw1(File root2) throws InterruptedException {
		
		File[] entries = root.listFiles(fileFileter);
		if(entries != null){
			for(File entry : entries){
				if(entry.isDirectory()){
					craw1(entry);
				}else if(!alreadyIndexed(entry)){
					fileQueue.put(entry);
				}
			}
		}
		
	}

	private boolean alreadyIndexed(File entry) {
		// TODO Auto-generated method stub
		return false;
	}

}
