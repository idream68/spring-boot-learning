package com.java.learning.shiro.base.real;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomerMd5Real extends AuthorizingRealm {

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("=========");
        String primaryPrincipal = principals.getPrimaryPrincipal().toString();
        System.out.println("身份信息： " + primaryPrincipal);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("admin");
        simpleAuthorizationInfo.addStringPermission("user:*:01");
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = token.getPrincipal().toString();  // user name
        if (principal.equals("test")) {
            String credentials = "dc45aa56cf82d23c954a646178c6499759f7d44f";  // password
//          return new SimpleAccount(principal, credentials, getName());
            return new SimpleAuthenticationInfo(principal, credentials, ByteSource.Util.bytes("abcde"), getName());
        } else {
            return null;
        }
    }
}
