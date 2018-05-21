package mode.creational.design.factory.simple.chapter1;

public class OperationFactory {

    public static Operation createOperation(String operate){

        switch (operate){

            case "+":
                return new OperationAdd();
            case "-":
                return new OperationSub();
        }
        return null;
    }
}
