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
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
public class ErrorCtr {
    private static final Logger log = LoggerFactory.getLogger(ErrorCtr.class);

    @RequestMapping("/oauth/error")
    public String error(@RequestParam Map<String, String> parameters) {
        String uri = parameters.get("redirect_uri");
        log.info("重定向: {}", uri);

        return "redirect:" + uri + "?error=1";
    }
    /*
    @RequestMapping("/oauth/confirm_access")
	public String getAccessConfirmation(Map<String, Object> model, Principal principal) throws AccessDeniedException {
		AuthorizationRequest clientAuth = (AuthorizationRequest) model.remove("authorizationRequest");
		System.out.println("safsdf");
		if(true)
		throw new AccessDeniedException("无法进行授权！");
		
		return "/user_grant_scope";
	}
	
    */
}
