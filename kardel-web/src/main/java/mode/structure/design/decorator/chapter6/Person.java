package mode.structure.design.decorator.chapter6;

public class Person {

    public Person(){

    }

    private String name;

    public Person(String name){
        this.name = name;
    }

    public void show(){

        System.out.println("装饰,姓名:"+name);
    }

}
