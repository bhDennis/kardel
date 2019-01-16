package mode.behavior.design2.vistor.chapter28;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构类，用于对比 男人和女人
 *
 * Created by dennis on 2018/4/11.
 */
public class ObjectStructure {

    private List<Person> persons = new ArrayList<>();

    public void add(Person person){

        persons.add(person);
    }

    public void disPlay(Action action){

        persons.stream().forEach(person ->{

            person.accept(action);
        });
    }
}
