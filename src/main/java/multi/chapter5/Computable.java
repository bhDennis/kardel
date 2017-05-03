package multi.chapter5;

// p.100 ʹ��HashMap��ͬ����������ʼ������
public interface Computable<A,V> {

	V compute(A args) throws  Exception;
}
