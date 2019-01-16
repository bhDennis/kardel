package multi.chapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//p.95 使用FutureTask来提前加载稍后需要的数据
public class Proloader {

	private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>(){
		
		public ProductInfo call(){
			return loadProductInfo();
		}

		private ProductInfo loadProductInfo() {
			return null;
		}
	});
	
	private final Thread thread = new Thread(future);
	public void start(){
		thread.start();
	}
	
	public ProductInfo get() throws Exception{
		try {
			return future.get();
		} catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if(cause instanceof DataLoadException){
            	throw (DataLoadException) cause;
            }else{
            	throw launderThrowable(cause);
            }
		}
	}

	private static RuntimeException launderThrowable(Throwable cause) {
		
		if(cause instanceof RuntimeException)
			 return (RuntimeException)cause;
		else if(cause instanceof Error)
			throw (Error) cause;
		else
			throw new IllegalStateException("Not unchecked",cause);
	}
	
}
