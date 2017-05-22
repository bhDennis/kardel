package multi.chapter6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * p.122 在指定的时间内获取广告信息
 * @author ahs2
 *
 */
public class AdRender {

	private final ExecutorService exec = Executors.newFixedThreadPool(100);
	private final long TIME_BUDGET = 10;
	private final Ad DEFAULT_AD = new Ad();
	
	public Page renderPageWithAd() throws InterruptedException{
		
		long endNanos = System.nanoTime()+TIME_BUDGET;
		Future<Ad> f = exec.submit(new FetchAdTask());
		Page page = renderPageBody();
		Ad ad;		
		try {
			//只等待指定时间长度
			long timeLeft = endNanos - System.nanoTime();
			ad = f.get(timeLeft,TimeUnit.NANOSECONDS);
		}catch (ExecutionException e) {
			ad = DEFAULT_AD;
		} catch (TimeoutException e) {
			ad = DEFAULT_AD;
			f.cancel(true);
		}
		page.setAd(ad);
		return page;
	}

	private Page renderPageBody() {
		// TODO Auto-generated method stub
		return null;
	}
}

class Page{
	
	void setAd(Ad ad){
		
	}
}

class Ad{
	
}

class FetchAdTask implements Callable<Ad>{

	@Override
	public Ad call() throws Exception {
		
		return null;
	}
	
}
