package mode.behavior.design2.iterator.chapter20;

/**
 * Created by dennis on 2018/3/14.
 */
public class AbstractIteratorTest {

    public static void main(String[] args){

        AbstractAggregate<String> abstractAggregate = new ConcreteAggregate<>();
        abstractAggregate.add("大鸟");
        abstractAggregate.add("小菜");
        abstractAggregate.add("大叔");
        abstractAggregate.add("阿姨");
        abstractAggregate.add("姑娘");

        AbstractIterator<String> abstractIterator = abstractAggregate.createAbstractIterator();

        while (!abstractIterator.isDone()){

            System.out.println(abstractIterator.currentItem());
            abstractIterator.next();
        }
    }
}
