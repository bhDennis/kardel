package multi.chapter5;

import java.math.BigInteger;

public class Factorizer implements Servlet{

	private final Computable<BigInteger,BigInteger[]> c = new Computable<BigInteger,BigInteger[]>(){
		public BigInteger[] compute(BigInteger arg){
			
			//return factor(arg);
		}
	};
	
	private final Computable<BigInteger,BigInteger[]> cache = new Memoizer4<BigInteger,BigInteger[]>(c);
	
	public void service(ServletRequest req,ServletResponse resp){
		try {
			BigInteger i  = extractFromRequest(req);
			encodeIntoResponse(req,cache.compute(i));
		} catch (Exception e) {
	        encodeError(resp,"factorization interrupted");
		}
	}
}

/**
 * 1.���еĲ������ⶼ���Թ���Ϊ���Э���Բ���״̬�ķ��ʡ��ɱ�״̬Խ�٣���Խ����ȷ���̰߳�ȫ�ԡ�
 * 2.����������������Ϊ final ���ͣ�������Ҫ�����ǿɱ��
 * 3.���ɱ����һ�����̰߳�ȫ��
 * 4.��װ�����ڹ�������
 * 5.������ͬһ�������������е����б���ʱ��Ҫʹ��ͬһ����
 * 6.ִ�и��ϲ����ڼ䣬Ҫ������
 */