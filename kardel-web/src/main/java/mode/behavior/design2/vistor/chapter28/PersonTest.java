package mode.behavior.design2.vistor.chapter28;

/**
 * Created by dennis on 2018/4/11.
 */
public class PersonTest {

    public static void main(String[] args){

        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new Man());
        objectStructure.add(new Women());

        objectStructure.disPlay(new Success());
        objectStructure.disPlay(new Fail());
    }
}
