package multi.chapter3;

public class Holder {

	private int n;
	
	public Holder(int n){
		this.n = n;
	}
	
	public void assertSanity(){
		if(n!=n)
			System.out.println("不相等");
	}
}
