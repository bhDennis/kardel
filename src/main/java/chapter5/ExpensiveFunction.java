package chapter5;

import java.math.BigInteger;

//p.100 ʹ��HashMap��ͬ����������ʼ������
public class ExpensiveFunction implements Computable<String, BigInteger> {

	@Override
	public BigInteger compute(String args) throws InterruptedException {
		
		// �ھ�����ʱ��ļ����
		return new BigInteger(args);
	}

}
