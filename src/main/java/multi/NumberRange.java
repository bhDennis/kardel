package multi;

import java.util.concurrent.atomic.AtomicInteger;

//p.71 ���̰߳�ȫ�� û��ά�ֶ��½���Ͻ�Խ���Լ���Ĳ���������
public class NumberRange {

	private final AtomicInteger lower = new AtomicInteger(0);
	private final AtomicInteger upper = new AtomicInteger(0);
	
	public void setLower(int i){  //�ȼ���ִ��
		if(i > upper.get()){
			throw new IllegalArgumentException("cannot set lower to "+i+">upper");
		}
		lower.set(i);
	}
	
	public void setUpper(int i){  //�ȼ���ִ��
		if(i < lower.get()){
			throw new IllegalArgumentException("cannot set uppper to"+i+"<lower");
		}
		upper.set(i);
	}
	
	public boolean isInRange(int i){
		return (i>=lower.get() && i<=upper.get());
	}
}
