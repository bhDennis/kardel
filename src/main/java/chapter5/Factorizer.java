package chapter5;

import javax.servlet.*;
import java.math.BigInteger;

public class Factorizer implements Servlet {

	private final Computable<BigInteger,BigInteger[]> c = new Computable<BigInteger,BigInteger[]>(){
		public BigInteger[] compute(BigInteger arg){
			
			return factor(arg);
		}

		private BigInteger[] factor(BigInteger arg) {
			return new BigInteger[0];
		}
	};

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	private final Computable<BigInteger,BigInteger[]> cache = new Memoizer4<BigInteger,BigInteger[]>(c);
	
	public void service(ServletRequest req, ServletResponse resp){
		try {
			BigInteger i  = extractFromRequest(req);
			encodeIntoResponse(req,cache.compute(i));
		} catch (Exception e) {
	        encodeError(resp,"factorization interrupted");
		}
	}

	private void encodeError(ServletResponse resp, String s) {

	}

	private void encodeIntoResponse(ServletRequest req, BigInteger[] compute) {

	}

	private BigInteger extractFromRequest(ServletRequest req) {
		return null;
	}
}

/**
 * 1.所有的并发问题都可以归纳为如何协调对并发状态的访问。可变状态越少，就越容易确保线程安全性。
 * 2.尽量将域类型声明为 final 类型，除非需要它们是可变的
 * 3.不可变对象一定是线程安全的
 * 4.封装有助于管理复杂性
 * 5.当保护同一个不变性条件中的所有变量时，要使用同一个锁
 * 6.执行复合操作期间，要持有锁
 */