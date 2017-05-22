package chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * p.119 使用Future等待图像下载
 * 本示例中：当多有的图像下载完成后，才会显示到页面上
 * 渲染文本：CPU密集型
 * 渲染图片：I/O密集型
 * @author ahs2
 *
 */
public class FutureRenderer {

	private final ExecutorService executor = Executors.newFixedThreadPool(100);
	
	public void renderPage(CharSequence source) throws ExecutionException{
		
		final List<ImageInfo> imageInfos = scanForImageInfo(source);
		Callable<List<ImageData>> task = new Callable<List<ImageData>>(){

			@Override
			public List<ImageData> call() throws Exception {
				
				List<ImageData> result = new ArrayList<ImageData>();
				for(ImageInfo imageInfo:imageInfos){
					result.add(imageInfo.downloadImage());
				}
				return result;
			}		
		};
		
		Future<List<ImageData>> future = executor.submit(task);
		renderText(source);
		
		try {
			List<ImageData> imageData = future.get();
			for(ImageData data : imageData){
				renderImage(data);
			}
		} catch (InterruptedException e) {
			//重新设置线程的中断状态
			Thread.currentThread().interrupt();
			//由于不需要结果，因此取消任务
			future.cancel(true);
		} catch (ExecutionException e) {
			throw e;
		}
	}

	//图片渲染
	private void renderImage(ImageData data) {
			
	}

	//文本渲染
	private void renderText(CharSequence source) {
			
	}

	//解析出的图片地址信息
	class ImageInfo{

		//根据地址从网络上下载图片
		public ImageData downloadImage(){
			return null;
		}
	}

	//具体图片信息
	class ImageData{
		
	}
	
	private List<ImageInfo> scanForImageInfo(CharSequence source){
		return new ArrayList<ImageInfo>(0);
	}
}
