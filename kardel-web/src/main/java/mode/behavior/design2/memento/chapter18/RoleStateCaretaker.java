package mode.behavior.design2.memento.chapter18;

/**
 * 管理者类
 * Created by dennis on 2018/3/12.
 */
public class RoleStateCaretaker {

    private RoleStateMemento roleStateMemento;

    public RoleStateMemento getRoleStateMemento() {
        return roleStateMemento;
    }

    public void setRoleStateMemento(RoleStateMemento roleStateMemento) {
        this.roleStateMemento = roleStateMemento;
    }
}
