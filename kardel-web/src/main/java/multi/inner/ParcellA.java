package multi.inner;

public class ParcellA {

	private int pMember;//声明一个私有成员
	
	private static int pstMember;//声明一个私有静态成员
	
	private final int pfMember = 9;//常量值
	
	private final static int pfsMember = 0;//常量静态成员
	
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
             testA();//访问外部普通方法
             testB();//访问外部静态方法
             return i;
		}
	}
	
	//��̬�ڲ���
	public static class Contentx2{
		
		private int a = 0;
		private static int memberOfStatic;//可以定义静态成员
		private static int out(){
//			 testA();//不能访问外部普通方法
//			 System.out.println(pMember);//不能访问外部的非静态成员  因为静态类在类加载时已经初始化了，而非静态成员只有在创建对象的时候才初始化，分配内存
			 System.out.println(pfsMember);
			 System.out.println(pstMember);
			 testB();
			 return memberOfStatic;
		}
		
		public void myOut(){
			out();
		}
	}

	//默认访问权限为包访问权限，不能再另一个包中访问
	class Destination{
		
		
	}
}
