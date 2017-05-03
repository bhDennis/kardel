package chapter5;

import java.util.HashMap;
import java.util.Map;

//p.100 ʹ��HashMap��ͬ����������ʼ������
public class Memoizer1<A, V> implements Computable<A, V> {

	private final Map<A,V> cache = new HashMap<A,V>();
	private final Computable<A,V> c;
	
	public Memoizer1(Computable<A, V> c){
		this.c = c;
	}
	@Override
	public  synchronized V compute(A args) throws Exception {
		V result = cache.get(args);
		if(result == null){
			result = c.compute(args);
			cache.put(args, result);
		}
		return result;
	}

}
