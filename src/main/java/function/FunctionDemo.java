package function;

import java.util.function.Function;

/**
 * Function�ӿ�
 * http://ifeve.com/jjava-util-function-java8/
 * @author ahs2
 *
 */
public class FunctionDemo {

	public static void modifyTheValue(int valueToBeOperated,Function<Integer,Integer> function){
		
		int newValue = function.apply(valueToBeOperated);
		
		System.out.println(newValue);
	}
	
	public static void main(String[] args) {
		
		int incr = 20;
		int myNumber = 10;
		
		modifyTheValue(myNumber,val->val+incr);
		
		myNumber = 15;
		modifyTheValue(myNumber,val->val*10);
		
		modifyTheValue(myNumber,val->val - 100);
		
		modifyTheValue(myNumber,val->"somestring".length() + val-100);
	}
}
