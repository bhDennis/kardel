package multi.chapter8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//�����嵥8-1  �̻߳ᷢ������
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
			header = exec.submit(new LoadFileTask("header.html"));//��ȡҳü
			footer = exec.submit(new LoadFileTask("footer.html"));//��ȡҳ��
			String page = renderBody();//��Ⱦҳ��
			//���������� - ���������ڵȴ�������Ĵ�����
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
