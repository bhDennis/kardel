package jvm.chapter7;

import java.io.IOException;
import java.io.InputStream;

/**
 * p.189
 *
 * 不同的类加载器对instanceof关键字运算符的影响
 *
 * Created by Dennis on 2017/12/6.
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                   throw new ClassNotFoundException(name);
                }
            }
        };

//        classLoader.loadClass("java.lang.Integer"); // p.193 底部

        Object object = classLoader.loadClass("jvm.chapter7.ClassLoaderTest").newInstance();

        System.out.println(object.getClass());

        /**
         * 结果：返回false
         *
         * 原因：虚拟机中存在两个ClassLoaderTest类，一个是由系统应用程序类加载器加载的，
         * 一个是由自定义类加载器加载的
         *
         */
        System.out.println(object instanceof jvm.chapter7.ClassLoaderTest);

        System.out.println(ClassLoaderTest.class.getClassLoader());
    }
}
