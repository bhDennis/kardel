package multi.chapter6;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


/**
 * p.121 
 *
 * 相比于FutureRenderer.java
 *    1.为每一幅图像的下载都创建一个独立任务，并在线程池中执行它们，从而将串行下载转换为并行下载，这减少了下载所有图像的总时间
 *    2.通过CompletionService中获取结果以及使每张图片在下载完成后立刻显示出来，能使用户获得一个更加动态和更高响应性的用户界面
 *
 * @author ahs2
 *
 */
public class Renderer {

	private final ExecutorService executor;
	
	Renderer(ExecutorService executor){
		this.executor = executor;
	}
	
	void renderPage(CharSequence source) throws ExecutionException{
		
		List<FutureRenderer.ImageInfo> info = scanForImageInfo(source);
		CompletionService<FutureRenderer.ImageData> completionService = new ExecutorCompletionService<FutureRenderer.ImageData>(executor);
		for(final FutureRenderer.ImageInfo imageInfo:info){

			//提交下载图像的任务
			completionService.submit(new Callable<FutureRenderer.ImageData>(){
				@Override
				public FutureRenderer.ImageData call() throws Exception {
				   return imageInfo.downloadImage();
				}			
			});
			renderText(source);

			//渲染图像
			try {
				for(int t = 0;t<info.size();t++){
					Future<FutureRenderer.ImageData> f = completionService.take();
					FutureRenderer.ImageData imageData = f.get();
					renderImage(imageData);
				}
			} catch (ExecutionException e) {
				throw e;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	private void renderImage(FutureRenderer.ImageData imageData) {
		
	}

	private void renderText(CharSequence source) {
		
	}

	private List<FutureRenderer.ImageInfo> scanForImageInfo(CharSequence source) {
		return null;
	}
}


