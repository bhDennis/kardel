package me.dennis.exercise.test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Dennis on 2018/7/18.
 */
public class ClassPersonTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, IntrospectionException {

        Person person = new Person("luoxn28",23);
        Class clazz = person.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field :fields){
            String key = field.getName();
            PropertyDescriptor descriptor = new PropertyDescriptor(key,clazz);
            Method method = descriptor.getReadMethod();
            Object value = method.invoke(person);
            System.out.println(key+","+value);
        }
    }
}

class Person {

    private String name;

    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
