package chapter7;

public class VolatileFeatureExampleTest {

	public static void main(String[] args) {
		
		final  VolatileFeaturesExample ve = new VolatileFeaturesExample();
		ve.set(1l);
		new Thread(new Runnable(){
			@Override
			public void run() {
			  ve.getAndIncrement();	
			}		
		});
		System.out.println(ve.get());		
	}
}
class VolatileFeaturesExample {

	volatile long vl = 0L;	//使用volatile声明64位的long型变量
	
	public void set(long l) {
		vl = l;   //单个volatile变量的写
	}
	public void getAndIncrement () {
	    vl++;   //复合（多个）volatile变量的读/写
	    System.out.println(vl);
	}
	public long get() {
	    return vl;  //单个volatile变量的读
	}
}