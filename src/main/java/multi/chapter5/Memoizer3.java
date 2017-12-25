package multi.chapter5;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Memoizer3<A, V> implements Computable<A, V> {

	private final Map<A,Future<V>> cache = new ConcurrentHashMap<A,Future<V>>();
	private final Computable<A,V> c;
	
	public Memoizer3(Computable<A, V> c) {
		this.c = c;
	}
	
	@Override
	public V compute(A args) throws Exception {
		
		Future<V> f = cache.get(args);
		if(f == null){       //非原子  先检查后执行
			Callable<V> eval = new Callable<V>(){
				@Override
				public V call() throws Exception {					
					return c.compute(args);
				}		
			};
			
			FutureTask<V> ft = new FutureTask<V>(eval);
			f = ft;
			cache.put(args, ft);
			ft.run();//在这里调用c.compute()
		}
		try {
			return f.get();
		} catch (Exception e) {
			throw e;
		}
	}

}
