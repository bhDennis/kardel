package multi.chapter7;

public class ArgPassTest {  
    
	public static class MyObject { //此行用public没有报错
        public int value = 0;  
        public MyObject(int a) {  
            value = a;  
        }  
    }  
      
    public static void test(MyObject obj) {  
        obj.value = 20;  
        obj = new MyObject(30); //报错    修改成  obj = new ArgPassTest().new MyObject(30);
    }  
      
    public static void main(String[] args) {  
        MyObject A = new MyObject(10); //报错  修改成  MyObject A = = new ArgPassTest().new MyObject(10);
        test(A);  
        System.out.println(A.value);  
    }  
}