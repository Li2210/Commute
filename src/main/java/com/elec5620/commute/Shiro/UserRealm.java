package com.elec5620.commute.Shiro;

import cn.hutool.core.bean.BeanUtil;
import com.elec5620.commute.Service.UserService;
import com.elec5620.commute.Utils.JwtUtils;
import com.elec5620.commute.pojo.User;
import com.elec5620.commute.pojo.returnUtils.UserProfile;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author lishen
 * @Date 13/11/20 02:54
 **/
@Slf4j
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;
        log.info("jwt----------------->{}", jwtToken);
        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();
        User user = userService.getUserById(Integer.parseInt(userId));

        if(user == null) {
            throw new UnknownAccountException("Account can not find ");
        }

        UserProfile userProfile = new UserProfile();
        BeanUtil.copyProperties(user, userProfile);
        log.info("profile----------------->{}", userProfile.toString());
        return new SimpleAuthenticationInfo(userProfile, jwtToken.getCredentials(), getName());
    }


}
