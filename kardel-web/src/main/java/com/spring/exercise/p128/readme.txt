<使用经典的Spring通知来模块化横切关注点>

  在某个特定的执行点(即目标方法)所执行的横切动作被封装在通知里，例如，可以将日志和验证动作封装为一个或多个通知。

  步骤：

    1. 在IOC容器里声明要被代理的Bean（即arithmeticCalculator），以及通知的实例（loggingBeforeAdvice）

    2. 为每个要被代理的Bean创建一个代理以应用通知，此处代理的创建是通过ProxyFactoryBean工厂Bean创建的。


  注意：

    ProxyFactoryBean只为实现了任意接口的目标Bean创建JDK代理，如果目标Bean没有实现任何接口，那么ProxyFactoryBean

将创建CGLIB代理，CGLIB代理可以代理目标Bean类里声明的所有方法。
