package mode.chapter17;

/**
 * Created by dennis on 2018/3/11.
 */
public class AbstractPlayerTest {

    public static void main(String[] args){

        AbstractPlayer abstractPlayer = new Forward("巴蒂尔");
        abstractPlayer.attack();

        abstractPlayer = new Guard("麦迪");
        abstractPlayer.attack();

        abstractPlayer = new Translator("姚明");
        abstractPlayer.defense();
    }
}
