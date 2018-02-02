package multi.chapter9;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

//p.172 ʹ��Executor��ʵ��SwingUtilities
public class SwingUtilities {

	private static final ExecutorService exec = Executors.newSingleThreadExecutor(new SwingThreadFactory());
	
	private static volatile Thread swingThread;
	
	private static class SwingThreadFactory implements ThreadFactory{

		@Override
		public Thread newThread(Runnable arg0) {
			swingThread = new Thread(arg0);
			return swingThread;
		}	
	}
	
	public static boolean isEventDispatchThread(){
		return Thread.currentThread() == swingThread;
	}
	
	public static void invokeLater(Runnable task){
		exec.execute(task);
	}
	
	public static void invokeAndWait(Runnable task){
		Future f  = exec.submit(task);
		try {
			f.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}	
}
