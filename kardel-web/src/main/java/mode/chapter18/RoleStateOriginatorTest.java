package mode.chapter18;

/**
 * Created by dennis on 2018/3/12.
 */
public class RoleStateOriginatorTest {

    public static void main(String[] args){

        //初始
        RoleStateOriginator roleStateOriginator = new RoleStateOriginator();
        roleStateOriginator.initState();
        System.out.println("初始状态:"+roleStateOriginator);


        // 保存进度
        RoleStateMemento roleStateMemento = roleStateOriginator.saveState();
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setRoleStateMemento(roleStateMemento);

        roleStateOriginator.fight();
        System.out.println("打完Boss后"+roleStateOriginator);

        roleStateOriginator.recoveryState(roleStateCaretaker.getRoleStateMemento());
        System.out.println("满血复活:"+roleStateOriginator);
    }
}
