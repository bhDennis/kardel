package mode.structure.design.bridge.chapter22;

/**
 * Created by dennis on 2018/3/21.
 */
public class AppMobileBrand extends AbstractMobileBrand {

    @Override
    protected void run() {
        abstractMobileSoftware.run();
    }
}
