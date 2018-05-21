package mode.behavior.design2.explain.chapter27;

/**
 * 终结符表达式：实现与终结符有关的解释操作
 *
 * Created by dennis on 2018/4/10.
 */
public class TerminalExpression extends AbstractExpression{

    @Override
    void interpret(Context context) {

        System.out.println("终端解释器");
    }
}
