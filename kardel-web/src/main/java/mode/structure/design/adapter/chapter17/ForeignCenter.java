package mode.structure.design.adapter.chapter17;

/**
 * Created by dennis on 2018/3/11.
 */
public class ForeignCenter {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void attack() {
        System.out.println("中锋"+getName()+"进攻");
    }

    void defense() {
        System.out.println("中锋"+getName()+"防守");
    }
}
