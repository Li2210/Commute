package com.elec5620.commute.Shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Description TODO
 * @Author lishen
 * @Date 13/11/20 03:13
 **/
public class JwtToken implements AuthenticationToken {

    private String JwtToken;

    public JwtToken(String jwtToken){
        this.JwtToken = jwtToken;
    }

    @Override
    public Object getPrincipal() {
        return JwtToken;
    }
    @Override
    public Object getCredentials() {
        return JwtToken;
    }

}
