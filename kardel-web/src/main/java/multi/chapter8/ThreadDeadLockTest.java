package multi.chapter8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//程序清单8-1  线程会发生死锁
public class ThreadDeadLockTest {

	
	public static void main(String[] args) throws Exception {

		RenderPageTask task = new ThreadDeadLockTest().new RenderPageTask();
		String result = task.call();
		System.out.println(result);
		
//		int N_CPUS = Runtime.getRuntime().availableProcessors();
//		System.out.println(N_CPUS);
	}
	
	ExecutorService exec = Executors.newSingleThreadExecutor();
	
	public class RenderPageTask implements Callable<String>{
		@Override
		public String call() throws Exception {
			Future<String> header,footer;
			header = exec.submit(new LoadFileTask("header.html"));//获取页眉
			footer = exec.submit(new LoadFileTask("footer.html"));//获取页脚
			String page = renderBody();//渲染页面
			//将发生死锁 - 由于任务在等待子任务的处理结果
			return header.get() + page + footer.get();
		}

		private String renderBody() {
			return "body";
		}		
	}
	
	class LoadFileTask implements Callable<String>{

		String webUrl = null;
		public LoadFileTask(String webUrl){
			this.webUrl = webUrl;
		}
		@Override
		public String call() throws Exception {
			return webUrl +" handle";
		}
	}
}
