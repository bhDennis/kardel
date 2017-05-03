package multi.chapter5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// p.101  ʹ��ConcurrentHashMap���ȱ����˲��������������߳�ͬʱ���õ�ʱ�򣬿��ܻᵼ�¼���õ���ͬ��ֵ
public class Memoizer2<A, V> implements Computable<A, V> {

	private final Map<A,V> cache = new ConcurrentHashMap<A,V>();
	private final Computable<A,V> c;
	
	public Memoizer2(Computable<A, V> c){
		this.c = c;
	}
	@Override
	public V compute(A args) throws Exception {
		
		V result = cache.get(args);
		if(result == null){
			result = c.compute(args);
			 cache.put(args, result);
		}
		return result;
	}

}
