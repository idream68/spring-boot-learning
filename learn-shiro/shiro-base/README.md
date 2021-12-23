认证：
- 执行用户名比较(认证)：
  - 默认使用 SimpleAccountRealm#doGetAuthenticationInfo
  - 自定义： 继承AuthenticatingRealm并重写doGetAuthenticationInfo
- 执行密码比较(授权)：
  - 默认使用 AuthenticatingRealm#assertCredentialsMatch
  - 自定义： 继承AuthorizingRealm并重写doGetAuthorizationInfo
  

[认证+授权完整例子（假造数据）](./src/main/java/com/java/learning/shiro/base/TestCustomerMd5AuthorizingReal.java)