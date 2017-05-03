package chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * p.119 ʹ��Future�ȴ�ͼ������  
 * ��ʾ���У������е�ͼ��������ɺ󣬲Ż���ʾ��ҳ����
 * ��Ⱦ�ı���CPU�ܼ���
 * ��ȾͼƬ��I/O�ܼ���
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
			//���������̵߳��ж�״̬
			Thread.currentThread().interrupt();
			//���ڲ���Ҫ��������ȡ������
			future.cancel(true);
		} catch (ExecutionException e) {
			throw e;
		}
	}
	
	//ͼƬ��Ⱦ
	private void renderImage(ImageData data) {
			
	}

	//�ı���Ⱦ
	private void renderText(CharSequence source) {
			
	}

	//��������ͼƬ��ַ��Ϣ
	class ImageInfo{
		
		//���ݵ�ַ������������ͼƬ
		public ImageData downloadImage(){
			return null;
		}
	}
	
	//����ͼƬ��Ϣ
	class ImageData{
		
	}
	
	private List<ImageInfo> scanForImageInfo(CharSequence source){
		return new ArrayList<ImageInfo>(0);
	}
}
