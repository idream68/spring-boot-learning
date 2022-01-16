代码	说明
- @Null	被注解的元素必须为null
- @NotNull	被注解的元素必须不为null
- @AssertTrue	被注解的元素必须为true
- @AssertFalse	被注解的元素必须为false
- @Min(value)	被注解的元素必须为数字，其值必须大于等于最小值
- @Max(value)	被注解的元素必须为数字，其值必须小于等于最小值
- @Size(max,min)	被注解的元素的大小必须在指定范围内
- @Past	被注解的元素必须为过去的一个时间
- @Future	被注解的元素必须为未来的一个时间
- @Pattern	被注解的元素必须符合指定的正则表达式

使用ControllerAdvice相应报错信息