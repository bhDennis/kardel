package multi.chapter7;

public class ArgPassTest {  
    
	public class MyObject { //������publicû�б���  
        public int value = 0;  
        public MyObject(int a) {  
            value = a;  
        }  
    }  
      
    public static void test(MyObject obj) {  
        obj.value = 20;  
        obj = new MyObject(30); //����    �޸ĳ�  obj = new ArgPassTest().new MyObject(30); 
    }  
      
    public static void main(String[] args) {  
        MyObject A = new MyObject(10); //����  �޸ĳ�  MyObject A = = new ArgPassTest().new MyObject(10); 
        test(A);  
        System.out.println(A.value);  
    }  
}