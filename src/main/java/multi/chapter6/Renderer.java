package multi.chapter6;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import me.aihuishou.multi.chapter6.FutureRenderer.ImageData;
import me.aihuishou.multi.chapter6.FutureRenderer.ImageInfo;

/**
 * p.121 
 * 
 * �����FutureRenderer.java 
 *    1.Ϊÿһ��ͼ������ض�����һ���������񣬲����̳߳���ִ�����ǣ��Ӷ�����������ת��Ϊ�������أ����������������ͼ�����ʱ��
 *    2.ͨ��CompletionService�л�ȡ����Լ�ʹÿ��ͼƬ��������ɺ�������ʾ��������ʹ�û����һ�����Ӷ�̬�͸�����Ӧ�Ե��û�����
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
		
		List<ImageInfo> info = scanForImageInfo(source);
		CompletionService<ImageData> completionService = new ExecutorCompletionService<ImageData>(executor);
		for(final ImageInfo imageInfo:info){
			
			//�ύ����ͼ�������
			completionService.submit(new Callable<ImageData>(){
				@Override
				public ImageData call() throws Exception {
				   return imageInfo.downloadImage();
				}			
			});
			renderText(source);
			
			//��Ⱦͼ��
			try {
				for(int t = 0;t<info.size();t++){
					Future<ImageData> f = completionService.take();
					ImageData imageData = f.get();
					renderImage(imageData);
				}
			} catch (ExecutionException e) {
				throw e;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	private void renderImage(ImageData imageData) {
		
	}

	private void renderText(CharSequence source) {
		
	}

	private List<ImageInfo> scanForImageInfo(CharSequence source) {
		return null;
	}
}


