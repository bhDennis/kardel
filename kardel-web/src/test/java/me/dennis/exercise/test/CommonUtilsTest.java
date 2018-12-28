package me.dennis.exercise.test;

import me.dto.Bean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.CommonUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Constructor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class CommonUtilsTest {


    @Test
    public void accessibleConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

//      System.out.println(Bean.class.getConstructor(String.class,List.class)); // 如果将Bean的构造器定义为private，此处会抛出异常 java.lang.NoSuchMethodException: other.Bean.<init>(java.lang.String, java.Util.List)

//        Constructor<Bean> constructor = CommonUtils.accessibleConstructor(Bean.class,String.class,List.class); // accessibleConstructor作用是使Bean的构造器即使为private也让它变得可用
//        Bean bean = constructor.newInstance("hzx",new ArrayList<>());
//
//        System.out.println("constructor:"+constructor+",bean:"+bean);

          Class<?> documentReaderClass = A.class;

          A a = (A)BeanUtils.instantiateClass(documentReaderClass);
          C c = C.class.cast(a);
          System.out.println(a);
          System.out.println(c);
    }

    @Test
    public void instance(){
        AA aa = new AA(); //可知实例化AA的时候，其父类构造器也会被执行 ,且Abstract和AA类均有静态代码块时，均优先执行
    }
}
