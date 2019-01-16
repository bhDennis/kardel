package jvm.chapter10.namecheck;

/**
 * 测试类（p.284） 包含了多处不规范命名的样例
 *
 * 运行与测试见 p.284
 *
 * 命令行执行过程：
 *
 *  D:\  javac NameCheckProcessor
 *
 *  D:\  javac NameChecker
 *
 *  D:\  javac -processor NameCheckProcessor  EADLY_NAMED_CODE.java
 */
public class EADLY_NAMED_CODE {

    enum colors {
        red,blue,green;
    }

    static final int _FORTY_TWO = 42;

    public static int NOT_A_CONSTANT = _FORTY_TWO;

    protected void BADLY_NAMED_CODE(){
      return;
    }

    public void NOTcamelCASEmethodName(){
      return;
    }
}
