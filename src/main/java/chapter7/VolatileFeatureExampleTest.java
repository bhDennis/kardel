package chapter7;

public class VolatileFeatureExampleTest {

	public static void main(String[] args) {
		
		VolatileFeaturesExample ve = new VolatileFeaturesExample();
		ve.set(1l);
		new Thread(new Runnable(){
			@Override
			public void run() {
			  ve.getAndIncrement();	
			}		
		});
//		new Thread(new Runnable(){
//			@Override
//			public void run() {
//			  ve.getAndIncrement();	
//			}
//			
//		});
//		new Thread(new Runnable(){
//			@Override
//			public void run() {
//			  ve.getAndIncrement();	
//			}			
//		});
//		new Thread(new Runnable(){
//			@Override
//			public void run() {
//			  ve.getAndIncrement();	
//			}			
//		});
//		new Thread(new Runnable(){
//			@Override
//			public void run() {
//			  ve.getAndIncrement();	
//			}		
//		});
		System.out.println(ve.get());		
	}
}
class VolatileFeaturesExample {

	volatile long vl = 0L;	//ʹ��volatile����64λ��long�ͱ���
	
	public void set(long l) {
	    vl = l;   //����volatile������д
	}
	public void getAndIncrement () {
	    vl++;    //���ϣ������volatile�����Ķ�/д
	    System.out.println(vl);
	}
	public long get() {
	    return vl;   //����volatile�����Ķ�
	}
}