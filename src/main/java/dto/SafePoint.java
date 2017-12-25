package dto;

//线程安全的  可变类
public class SafePoint {

	private int x,y;
	
	private SafePoint(int[] a){
		this(a[0],a[1]);
	}
	
	public SafePoint(SafePoint p){
		this(p.get()); // 如果为 this(p.x,p.y) 将产生竞态条件   p.72底
	}
	
	public SafePoint(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public synchronized int[] get(){
		return new int[]{x,y};
	}
	
	public synchronized void set(int x,int y){
		this.x = x;
		this.y = y;
	}
	
}
