package inner;

/**
 * http://www.cnblogs.com/activity-life/p/3622850.html
 * http://www.cnblogs.com/aademeng/articles/6192954.html
 * 静态内部类和普通内部类
 * @author ahs2
 *
 */
public class Entry {

	public static void main(String[] args) {
		
		ParcellA parcell = new ParcellA();
		ParcellA.Contentx contentTx = parcell.new Contentx();//��ͨ�ڲ���Ĵ���
		contentTx.value();
		
		ParcellA.Contentx2 context2 = new ParcellA.Contentx2();//��̬�ڲ���Ĵ���
		context2.myOut();
		
		ParcellA.Destination destination = new ParcellA().new Destination();//���Գ��԰�Entry�ඨ�嵽�������У����д���ᱨ��
	}
}
