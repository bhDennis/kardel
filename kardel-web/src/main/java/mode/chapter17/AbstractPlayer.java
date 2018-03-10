package mode.chapter17;

/**
 * Created by dennis on 2018/3/11.
 */
public abstract class AbstractPlayer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractPlayer(String name){
        this.name = name;
    }

    abstract void attack();

    abstract void defense();
}
