package me.reflect;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PrivateDetailTest {

	public static void main(String[] args) throws Exception {

		Constructor<PrivateDetail> constructor = PrivateDetail.class.getDeclaredConstructor();
		ReflectionUtils.makeAccessible(constructor);
		PrivateDetail privateDetail = constructor.newInstance();
		System.out.println(privateDetail);
	}
}
