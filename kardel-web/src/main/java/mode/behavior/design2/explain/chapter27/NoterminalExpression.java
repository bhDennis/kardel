package mode.behavior.design2.explain.chapter27;

/**
 * 非终结符表达式：为文法中的非终结符实现解释操作
 *
 * Created by dennis on 2018/4/10.
 */
public class NoterminalExpression  extends AbstractExpression{

    @Override
    void interpret(Context context) {

        System.out.println("非端解释器");
    }
}
