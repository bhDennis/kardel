package multi.chapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// �޸���Memoizer3�и��ϲ�������û�������)������
public class Memoizer4<A,V> implements Computable<A,V> {

	private final ConcurrentMap<A,Future<V>> cache = new ConcurrentHashMap<A,Future<V>>();
	private final Computable<A,V> c;
	
	public Memoizer4(Computable<A,V> c){
		this.c = c;
	}
	
	@Override
	public V compute(A args) throws Exception {
	
		while(true){
			Future<V> f = cache.get(args);
			if(f == null){
				Callable<V> eval = new Callable<V>(){

					@Override
					public V call() throws Exception {						
						return c.compute(args);
					}					
				};
				FutureTask<V> ft = new FutureTask<V>(eval);
				f = cache.putIfAbsent(args, ft);
				if(f==null){
					f = ft;
					ft.run();
				}
			}
			
			try {
				return f.get();
			} catch (CancellationException e) {
				cache.remove(args, f);
			}
		}
	}
}
