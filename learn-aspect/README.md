# AOP 基础

指定切点可使用两种方式，根据具体情况选择合适的方式
- 使用className作为切点（或许有误，不确定是不是只作用于类）
  @Pointcut("execution(public * com.springboot.learning.learnaspect.controller..*.*(..))")
- 使用注解作为切点
  @Pointcut("@annotation(com.springboot.learning.learnaspect.annotation.WebLog)")

1. @Around
   环绕切点运行
2. @Before
   在切点之前运行
3. @After
   在切点之后运行
   
@Around, @Before, @After 执行顺序：
@Around -> @Before -> press -> @After -> @Around

当一个方法由多个切点
则可使用@Order指定顺序优先级
例：
P1 优先级较高
P2 优先级较低
执行顺序
P1#Around -> P1#Before -> P2#Around -> P2#Before -> press -> P2#After -> P2#Around -> P1#After -> P1#Around
