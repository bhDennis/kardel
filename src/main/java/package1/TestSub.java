package package1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ���Բ�����д
 * @author ahs2
 *
 */
public class TestSub extends TestSuper {

	protected int a=1;
	public static void main(String[] args) {
//		TestSub st = new TestSub();
//		System.out.println(st+","+st.a+","+test(st));
		
//		Map<String,String> map = new HashMap<String,String>();
//		System.out.println(map.get(null));
		
		Detail detail = new Detail();
		detail.setProductNo("20140710");
		detail.setReceiveDept("�ջ�����");
		
		Detail detail1 = new Detail();
		detail1.setProductNo("20140713");
		detail1.setReceiveDept("�������");
		
		Detail detail2 = new Detail();
		detail2.setProductNo("20140711");
		detail2.setReceiveDept("�˻�����");
		
		Detail detail3 = new Detail();
		detail3.setProductNo("20140711");
		detail3.setReceiveDept("�ִ�����");
		
		List<Detail> details = new ArrayList<Detail>();
		details.add(detail);
		details.add(detail1);
		details.add(detail2);
		details.add(detail3);
		
		Map<String,Detail> mapDetails = details.stream().collect(Collectors.toMap(t->t.getProductNo(), t->t));
		
		System.out.println("mapDetails��{}"+mapDetails);
	}
	
	public static int test(TestSuper b){
		System.out.println("test����,������������:"+b+","+b.a);
		return b.a;
//		return b instanceof TestSub ?((TestSub)b).a:
//			   b instanceof TestSub2?((TestSub2)b).a:
//			   b.a;
	}
}
