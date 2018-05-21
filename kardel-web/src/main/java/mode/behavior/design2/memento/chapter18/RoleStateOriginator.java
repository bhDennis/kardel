package mode.behavior.design2.memento.chapter18;

/**
 * 发起人类
 * Created by dennis on 2018/3/12.
 */
public class RoleStateOriginator {

    private int vit;//生命力

    private int atk;//攻击力

    private int def;//防御力

    public RoleStateMemento saveState(){

        return new RoleStateMemento(vit,atk,def);
    }

    public void recoveryState(RoleStateMemento roleStateMemento){

        this.vit = roleStateMemento.getVit();
        this.atk = roleStateMemento.getAtk();
        this.def = roleStateMemento.getDef();
    }

    public void initState(){
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    public void fight(){
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    @Override
    public String toString() {
        return "RoleStateOriginator{" +
                "vit=" + vit +
                ", atk=" + atk +
                ", def=" + def +
                '}';
    }
}
