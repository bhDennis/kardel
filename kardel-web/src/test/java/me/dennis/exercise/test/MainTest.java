package me.dennis.exercise.test;

/**
 * Created by Dennis on 2018/4/23.
 */
public class MainTest {

    public static void main(String[] args){

        TestA testA = new TestB();

        System.out.println(testA);

        TestB testB = (TestB) testA;
        System.out.println(testB);

//        TestC testC = (TestC) testA;
        System.out.println((testA instanceof TestB)+","+!(testA instanceof TestC));
    }
}


class TestA{

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

class TestB extends TestA{

    private String idB;

    public String getIdB() {
        return idB;
    }

    public void setIdB(String idB) {
        this.idB = idB;
    }
}

class TestC extends TestA{

    private Integer idC;

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }
}