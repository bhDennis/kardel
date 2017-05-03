package multi.chapter7;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WebCrawlerTest {

}

// 7-22 p.145 ʹ��TrackingExecutorSerivce������δ��ɵ������Ա�����ִ��
 abstract class WebCrawler{
	
	private volatile TrackingExecutor exec;
	
	private final Set<URL> urlsToCrawl = new HashSet<URL>();
    private final long TIMEOUT = 5;
    private final TimeUnit UNIT = TimeUnit.SECONDS;
	
	public synchronized void start(){
		exec = new TrackingExecutor(Executors.newCachedThreadPool());
		for(URL url : urlsToCrawl){
			submitCrawlTask(url);
		}
		urlsToCrawl.clear();
	}
	
	public synchronized void stop(){  //�ر�ʱ����¼��Щ ��δ��ʼ������ + ��ȡ���������URL
		try {
			saveUncrawled(exec.shutdownNow());
			if(exec.awaitTermination(TIMEOUT, UNIT)){
				saveUncrawled(exec.getCancelledTasks());
			}
		} catch (InterruptedException e) {
			exec = null;
		}
	}
	
	protected abstract List<URL> processPage(URL url);
	
	private void saveUncrawled(List<Runnable> uncrawled){
		for(Runnable task : uncrawled){
			urlsToCrawl.add(((CrawTask)task).getPage());
		}
	}

	private void submitCrawlTask(URL url) {
		exec.execute(new CrawTask(url));
	}
	
	private class CrawTask implements Runnable{

		private final URL url;
		
		public CrawTask(URL url){
			this.url = url;
		}
		@Override
		public void run() {
			
			for(URL link :processPage(url)){
				if(Thread.currentThread().isInterrupted()){
					return;
				}
				submitCrawlTask(link);
			}
		}	
		public URL getPage(){
			return url;
		}
	}
}

// 7-21 ��ExecutorService�и����ڹر�֮��ȡ��������
class TrackingExecutor extends AbstractExecutorService{

	private final ExecutorService exec;
	private final Set<Runnable> tasksCancelledAtShutdown = Collections.synchronizedSet(new HashSet<>());
	
	public TrackingExecutor(ExecutorService exec){
		this.exec  = exec;
	}
	public List<Runnable> getCancelledTasks(){
		
		if(!exec.isTerminated()){
			throw new IllegalStateException("�쳣");
		}
		return new ArrayList<Runnable>(tasksCancelledAtShutdown);
	}
	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		return false;
	}

	@Override
	public boolean isShutdown() {
		return false;
	}

	@Override
	public boolean isTerminated() {
		return false;
	}

	@Override
	public void shutdown() {
		
	}

	@Override
	public List<Runnable> shutdownNow() {  //����ֵ��������Щ��δ��ʼִ�е�����
		return null;
	}

	@Override
	public void execute(Runnable command) {
		exec.execute(new Runnable(){
			@Override
			public void run() {				
				try {
					command.run();
				} catch (Exception e) {       //���������ҳ���Щ�Ѿ���ʼ����û��������ɵ�����
				    if(isShutdown() && Thread.currentThread().isInterrupted()){
				    	tasksCancelledAtShutdown.add(command);
				    }
				}		
			}		
		});		
	}	
}