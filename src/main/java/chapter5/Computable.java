package chapter5;

// p.100 使用HashMap和同步机制来初始化缓存
public interface Computable<A,V> {

	V compute(A args) throws  Exception;
}
