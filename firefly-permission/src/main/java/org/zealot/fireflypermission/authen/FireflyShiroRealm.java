package org.zealot.fireflypermission.authen;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zealot.fireflybase.entity.permission.Permission;
import org.zealot.fireflybase.entity.permission.Role;
import org.zealot.fireflybase.entity.permission.User;
import org.zealot.fireflypermission.user.UserHandler;

import javax.annotation.Resource;

/**
 * 身份校验核心类
 */
public class FireflyShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(FireflyShiroRealm.class);

    @Resource
    private UserHandler userHandler;

    /**
     * 认证信息(身份验证) Authentication 是用来验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.debug("[START]FireflyShiroRealm.doGetAuthenticationInfo()");
        // 获取用户的输入帐号
        String loginName = (String) token.getPrincipal();
        logger.debug("[doGetAuthenticationInfo]loginName is {}", loginName);
        // 通过username从数据库中查找 User对象。
        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userHandler.findUserByLoginName(loginName);
        logger.debug("----->>userInfo={}", user);
        if (user == null) {
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, // 用户名
                user.getPassword(), // 密码
                ByteSource.Util.bytes(user.getCredentialsSalt()), // salt=loginName + salt
                getName() // realm name
        );
        return authenticationInfo;
    }

    /**
     * 权限控制
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // TODO Auto-generated method stub
        logger.debug("[START]权限配置-->FireflyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principals.getPrimaryPrincipal();
        for(Role role : user.getRoleList()){
            authorizationInfo.addRole(role.getRoleName());
            logger.debug("permissionList is {}", role.getPermissionList());
            for(Permission p : role.getPermissionList()){
                System.out.println(p);
                authorizationInfo.addStringPermission(p.getPermissionName());
            }
        }
        return authorizationInfo;
    }

}
