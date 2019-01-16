package mode.structure.design.bridge.chapter22;

/**
 * Created by dennis on 2018/3/21.
 */
public abstract class AbstractMobileBrand {

    protected AbstractMobileSoftware abstractMobileSoftware;

    protected void setAbstractMobileSoftware(AbstractMobileSoftware abstractMobileSoftware){
        this.abstractMobileSoftware = abstractMobileSoftware;
    }

    protected abstract void run();

}
