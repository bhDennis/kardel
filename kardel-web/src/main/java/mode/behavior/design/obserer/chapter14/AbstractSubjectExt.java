package mode.behavior.design.obserer.chapter14;

import java.lang.reflect.Method;

// 抽象通知者
public abstract class AbstractSubjectExt {

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    abstract void notifySomething(Method method,Object ... objs);
}
