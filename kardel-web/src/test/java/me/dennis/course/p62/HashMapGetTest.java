package me.dennis.course.p62;

import java.util.HashMap;

/**
 * JDK8 HashMap源码
 * line 571：对getNode方法
 *  (key != null && key.equals(k)))代码疑惑，采用下面方式验证
 *  该行代码表示对于形如String的类重写了equals方法，并将其作为key的情形
 *  此处举例UserMap类作为反例验证。
 *
 *  debug可以查看other和this在进入canEqual方法前后的取值对比：
 *     进入canEqual方法前，this指向的是map1中的对象，进入后，this指向的是传入的o对象
 *
 */
public class HashMapGetTest {

    public static void main(String[] args){

        HashMap<UserMap,UserMap> map1 = new HashMap<>(2);
        map1.put(new UserMap("a",1),new UserMap("hzx",11));
        map1.put(new UserMap("b",2),new UserMap("hxl",19));

        HashMap<UserMap,UserMap> map2 = new HashMap<>(2);
        map2.put(new UserMap("a",1),new UserMap("hzx",11));
        map2.put(new UserMap("b",2),new UserMap("hxl",19));

        for(UserMap map1Key : map1.keySet()){
            UserMap map2Key = map2.keySet().iterator().next();
            System.out.println(map1Key);
            System.out.println(map2Key);
            System.out.println(map1Key.equals(map2Key));
        }
    }
}

class UserMap{

    private String name;
    private Integer age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public UserMap(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserMap[name="+this.name+",age="+this.age+"]";
    }


    public Integer getAge() {
        return age;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserMap))
            return false;
        UserMap other = (UserMap) o;
        if (!other.canEqual(this))
            return false;
        Object this$name = getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        Object this$age = getAge();
        Object other$age = other.getAge();
        return this$age == null ? other$age == null : this$age.equals(other$age);
    }

    public boolean canEqual(Object other) {
        return other instanceof UserMap;
    }
}