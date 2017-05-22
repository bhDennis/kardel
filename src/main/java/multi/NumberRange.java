package multi;

import java.util.concurrent.atomic.AtomicInteger;

//p.71 非线程安全的 没有维持对下界和上界对进行约束的不变形条件
public class NumberRange {

	private final AtomicInteger lower = new AtomicInteger(0);
	private final AtomicInteger upper = new AtomicInteger(0);
	
	public void setLower(int i){ //先检查后执行
		if(i > upper.get()){
			throw new IllegalArgumentException("cannot set lower to "+i+">upper");
		}
		lower.set(i);
	}
	
	public void setUpper(int i){  //先检查后执行
		if(i < lower.get()){
			throw new IllegalArgumentException("cannot set uppper to"+i+"<lower");
		}
		upper.set(i);
	}
	
	public boolean isInRange(int i){
		return (i>=lower.get() && i<=upper.get());
	}
}
