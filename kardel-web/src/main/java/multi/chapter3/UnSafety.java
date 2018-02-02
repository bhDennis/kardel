package multi.chapter3;
/**
 * p.55 不安全的发布
 * 由于可见性问题，其他线程看到的Holer对象将处于不一致状态
 * @author ahs2
 *
 */
public class UnSafety {

	public Holder holder;
	
	public void initialize(){
		this.holder = new Holder(42);
	}
}
