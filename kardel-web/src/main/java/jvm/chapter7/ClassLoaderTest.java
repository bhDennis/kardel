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

        classLoader.loadClass("java.lang.Integer"); // p.193 底部

        Object object = classLoader.loadClass("jvm.chapter7.ClassLoaderTest").newInstance();

        System.out.println(object.getClass());

        System.out.println(object instanceof  jvm.chapter7.ClassLoaderTest);
    }
}
