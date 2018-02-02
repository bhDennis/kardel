package multi.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * 对<? super T>和 <? extends T>的分析
 * <? super T>：     包括T在内的任何T的父类
 * <? extends T>：包括T在内的任何T的子类
 *
 * http://www.importnew.com/17006.html
 * @author ahs2
 *
 */
public class GenericSuperExtends {

	//消费者使用super
	public void superMethod(){
		
		List<? super Integer> foo3 = new ArrayList<Integer>();
		
		List<? super Integer> foo4 = new ArrayList<Number>();
		
		List<? super Integer> foo5 = new ArrayList<Object>();
	}

	//生产者使用extends
	public void extendMethod(){
		
		List<? extends Number> foo3 = new ArrayList<Number>();
			
		List<? extends Number> foo4 = new ArrayList<Integer>();
		
		List<? extends Number> foo5 = new ArrayList<Double>();
	}
	
	public static void methodA(List<? super Number> emp){
		
	}
	
	public static void methodB(List<? extends Number> emp){
		
	}
	
	public static void main(String[] args) {
		
		List<Object> names = new ArrayList<Object>(0);		
		methodA(names);
		
		
		List<Integer> namess = new ArrayList<Integer>(0);		
		methodB(namess);
	}
}
