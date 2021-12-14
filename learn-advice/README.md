# RestControllerAdvice 基础

例子仅使用了全局异常捕获

可传入参数 basePackage 指定具体监控的基础包

有多个Advice同时监控一个包时，按照springboot加载的顺序优先使用先加载的Advice，若使用的Advice与自己所期望的不同，可使用@Order进行指定顺序，数字越小优先级越高

使用 @ExceptionHandler 注解的方法
- 可无参数
- 仅有Exception e 参数
- 有HttpServletRequest request, Exception e 两个参数
- 有HttpServletRequest request, Exception e, HttpServletResponse response 三个参数等。。。




