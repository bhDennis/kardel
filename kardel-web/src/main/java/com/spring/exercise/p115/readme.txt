1.使用动态代理模块化横切关注点

  该方式代码很低层次，且对开发者来讲过于苛刻
  示例中使用的代理类是 CalculatorLoggingHandler，CalculatorValidationHandler
  代理类要实现 InvocationHandler 接口。

