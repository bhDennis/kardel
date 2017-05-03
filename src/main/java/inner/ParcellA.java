package inner;

public class ParcellA {

	private int pMember;//����һ��˽�г�Ա
	
	private static int pstMember;//����һ��˽�о�̬��Ա
	
	private final int pfMember = 9;//����ֵ
	
	private final static int pfsMember = 0;//������̬��Ա
	
	public void testA(){
		System.out.println("testA");
	}
	public static void testB(){
		System.out.println("testA");
	}
	public class Contentx{
		
		private int i = 11;
		
		public int value(){
             System.out.println(pMember);
             System.out.println(pstMember);
             System.out.println(pfMember);
             System.out.println(pfsMember);
             testA();//�����ⲿ��ͨ����
             testB();//�����ⲿ��̬����
             return i;
		}
	}
	
	//��̬�ڲ���
	public static class Contentx2{
		
		private int a = 0;
		private static int memberOfStatic;//���Զ��徲̬��Ա
		private static int out(){
//			 testA();//���ܷ����ⲿ��ͨ����
//			 System.out.println(pMember);//���ܷ����ⲿ�ķǾ�̬��Ա  ��Ϊ��̬���������ʱ�Ѿ���ʼ���ˣ����Ǿ�̬��Աֻ���ڴ��������ʱ��ų�ʼ���������ڴ�
			 System.out.println(pfsMember);
			 System.out.println(pstMember);
			 testB();
			 return memberOfStatic;
		}
		
		public void myOut(){
			out();
		}
	}
	
	//Ĭ�Ϸ���Ȩ��Ϊ������Ȩ�ޣ���������һ�����з���
	class Destination{
		
		
	}
}
