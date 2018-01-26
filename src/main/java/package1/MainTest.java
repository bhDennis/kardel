package package1;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {

		// 实例化私有构造器的类
		try {
			try {
				Constructor<PrivateDetail> constructor = PrivateDetail.class.getDeclaredConstructor();
				ReflectionUtils.makeAccessible(constructor);
				PrivateDetail privateDetail = constructor.newInstance();
				System.out.println(privateDetail);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

//		try {
//			MainTest mainTest = new MainTest();
//			mainTest.a();
//			return;
//		}catch(Exception e){
//			System.out.println(e);
//			return;
//		} finally {
//			System.out.println("finally");
//		}
//
//		List<Integer> i = new ArrayList<Integer>();
//		i.add(1);
//		i.add(3);
//		i.add(2);
//
//
//		List<Integer> j = new ArrayList<Integer>();
//		j.add(1);
//		j.add(3);
//		j.add(2);
//		j.add(4);
//
//		System.out.println(i.getClass());
//		System.out.println(i.equals(j));
//		System.out.println(i.containsAll(j));
//		System.out.println(j.containsAll(i));
//		System.out.println(i.contains(5));
//
//
//        String[] str = new String[]{"a","b"};
//        String[] str1 = new String[]{"c","d"};
//        System.out.println(str);
//
//        String[][] str2 = new String[][]{str,str1};
//        System.out.println(str2);
	}
	
	public void a() throws Exception {
		throw new Exception("exception a");
	}
}
