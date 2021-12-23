package com.java.learning.shiro.base.real;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomerReal extends AuthorizingRealm {
    /**
     * 认证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 授权
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = token.getPrincipal().toString();  // user name
        if (principal.equals("test")) {
            String credentials = "123";  // password
//          return new SimpleAccount(principal, credentials, getName());
            return new SimpleAuthenticationInfo(principal, credentials, getName());
        } else {
            return null;
        }
    }
}
