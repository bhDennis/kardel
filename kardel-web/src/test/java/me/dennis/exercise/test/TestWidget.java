package me.dennis.exercise.test;

/**
 * synchronized锁的可重入性
 * https://blog.csdn.net/huangzebiao007/article/details/23497043
 * Created by Dennis on 2018/7/5.
 */
public class TestWidget {

        public static void main(String[] args) throws InterruptedException {

            final LoggingWidget loggingWidget = new LoggingWidget();
            Thread thread1 = new Thread("thread1") {
                @Override
                public void run() {
                    System.out.println(super.getName() + ":start");
                    loggingWidget.doSomeThing();
                }
            };

            Thread thread2 = new Thread("thread2") {
                @Override
                public void run() {

                    System.out.println(super.getName() + ":start");

                    loggingWidget.doAnotherThing();    //为了说明子类复写父类方法后，调用时也持有父类锁

                    //loggingWidget.doNothing();      //证明了内置锁对那些没有加synchronized修饰符的方法是不起作用的

                    //loggingWidget.doMyLike();     //为了说明子类复写父类方法后，调用时也持有父类锁，也持有自己本类的锁

                    //loggingWidget.doSomeThing(); //这是两个线程，这是需要等待的，并不是继承的关系，不是重入，重入是发生在一个线程中的
                }
            };

            thread1.start();
//            Thread.sleep(1000);
            thread2.start();
        }
    }

    class Widget {
        public synchronized void doSomeThing() {
            System.out.println("widget ... do something...");
        }

        public synchronized void doAnotherThing() {
            System.out.println("widget... do another thing...");
        }

        public void doNothing() {
            System.out.println("widget... do Nothing...");
        }
    }

    class LoggingWidget extends Widget {

        @Override
        public synchronized void doSomeThing() {
            try {
                System.out.println("LoggingWidget do something...");
                Thread.sleep(4000);
                System.out.println("end LoggingWidget do something...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            super.doSomeThing();  //如果注释掉该行代码，则执行的时候就不会获取父类该方法的锁
        }

        public synchronized void doMyLike() {
            System.out.println("LoggingWidget do my like...");
        }
}


