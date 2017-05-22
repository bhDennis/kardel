package multi.chapter5;

import java.math.BigInteger;

//p.100 使用HashMap和同步机制来初始化缓存
public class ExpensiveFunction implements Computable<String, BigInteger> {

	@Override
	public BigInteger compute(String args) throws InterruptedException {

		// 在经过长时间的计算后
		return new BigInteger(args);
	}

}
