/* 
 * 版权声明(Copyright Notice)：
 *     Copyright(C) 2017-2017 聚数科技成都有限公司。保留所有权利。
 *     Copyright(C) 2017-2017 www.cdmi.pw Inc. All rights reserved. 
 * 
 *     警告：本内容仅限于聚数科技成都有限公司内部传阅，禁止外泄以及用于其他的商业目
 */ 
package pw.cdmi.core.oauth2.security;

import java.util.Collections;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import pw.cdmi.core.oauth2.entitiys.User;
import pw.cdmi.core.oauth2.entitiys.UserRepository;

/************************************************************
 * @Description:
 * <pre>
 * TODO(对类的简要描述说明 – 必须).<br/>
 * TODO(对类的作用含义说明 – 可选).<br/>
 * TODO(对类的使用方法说明 – 可选).<br/>
 * </pre>
 * @author    伍伟
 * @version   3.0.1
 * @Project   Alpha CDMI Service Platform, cdmi-core-oauth2 Component. 2017年6月5日
 ************************************************************/
@Component
public class AlanSsoAuthProvider implements AuthenticationProvider {
    private static final Logger log = LoggerFactory.getLogger(AlanSsoAuthProvider.class);
    @Autowired
    private UserRepository userRepository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("自定义provider调用");
        UsernamePasswordAuthenticationToken usernameToken=(UsernamePasswordAuthenticationToken)authentication;
        User user = new User(); 
        user.setCreateDate(new Date());
        user.setUsername((String)usernameToken.getPrincipal());
        user.setPassword((String)usernameToken.getCredentials());
        
        // 返回一个Token对象表示登陆成功
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), Collections.<GrantedAuthority>emptyList());
        System.out.println("username:"+usernameToken.getPrincipal()+"    password:"+usernameToken.getCredentials().toString()+usernameToken);
        System.out.println(usernamePasswordAuthenticationToken.toString());
        return usernamePasswordAuthenticationToken;
    }
    
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
