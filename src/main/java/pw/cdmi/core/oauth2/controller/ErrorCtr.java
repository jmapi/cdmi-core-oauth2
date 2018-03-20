/* 
 * 版权声明(Copyright Notice)：
 *     Copyright(C) 2017-2017 聚数科技成都有限公司。保留所有权利。
 *     Copyright(C) 2017-2017 www.cdmi.pw Inc. All rights reserved. 
 * 
 *     警告：本内容仅限于聚数科技成都有限公司内部传阅，禁止外泄以及用于其他的商业目
 */ 
package pw.cdmi.core.oauth2.controller;

import java.security.Principal;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import pw.cdmi.paas.developer.model.entities.AuthCertificate;
import pw.cdmi.paas.developer.model.entities.UserAccount;
import pw.cdmi.paas.developer.repositories.AuthCertificateRepositories;
import pw.cdmi.paas.developer.repositories.UserAccountRepositories;

//import pw.cdmi.core.oauth2.entitiys.AuthCertificate;
//import pw.cdmi.core.oauth2.entitiys.AuthCertificateRepositories;
//import pw.cdmi.core.oauth2.entitiys.User;
//import pw.cdmi.core.oauth2.entitiys.UserRepository;

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
@Controller
@SessionAttributes("authorizationRequest")
public class ErrorCtr{
    private static final Logger log = LoggerFactory.getLogger(ErrorCtr.class);
    @Autowired
    private  ClientDetailsService clientDetailsService;
    @Autowired
    private AuthCertificateRepositories authCertificateRepositories;
    @Autowired
    private UserAccountRepositories userRepository;
    @RequestMapping("/oauth/error")
    public String error(@RequestParam Map<String, String> parameters) {
        String uri = parameters.get("redirect_uri");
        log.info("重定向: {}", uri);

        return "redirect:" + uri + "?error=1";
    }
    /*
    @RequestMapping("/oauth/confirm_access")
	public @ResponseBody String getAccessConfirmation(Map<String, Object> model, Principal principal) throws AccessDeniedException {
		AuthorizationRequest clientAuth = (AuthorizationRequest) model.remove("authorizationRequest");
		
		System.out.println("safsdf");
		
		return "/user_grant_scope";
		
	}
	*/
    
    @RequestMapping("/test")
    public  @ResponseBody String asdf(Principal principal){
 //   	WebAuthenticationDetails
    	return principal.toString();
    }
    /*
    @RequestMapping("/oauth/authorize")
	public @ResponseBody String getAccessConfirmation(@RequestParam Map<String, String> model) throws AccessDeniedException {
    	DefaultOAuth2RequestFactory defaultOAuth2RequestFactory = new DefaultOAuth2RequestFactory(clientDetailsService);
    	OAuth2Request authorizationRequest = defaultOAuth2RequestFactory.createOAuth2Request(defaultOAuth2RequestFactory.createAuthorizationRequest(model));
    	String clientId = authorizationRequest.getClientId();
    	AuthCertificate certificate = authCertificateRepositories.findByAccessKey(clientId);
    	
    	UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,password);
    	InMemoryAuthorizationCodeServices authorizationCodeServices = new InMemoryAuthorizationCodeServices();
    	
    	OAuth2Authentication combinedAuth = new OAuth2Authentication(authorizationRequest, usernamePasswordAuthenticationToken);
    	UsernamePasswordAuthenticationToken AuthenticationToken = new UsernamePasswordAuthenticationToken(clientId,authorizationRequest.getGrantType());
    	SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    //	SecurityContextHolder.getContext().setAuthentication(AuthenticationToken);
    	String code=authorizationCodeServices.createAuthorizationCode(combinedAuth);
		System.out.println(model.toString());
		
		
		return code;
	}
	*/
    
    
}
