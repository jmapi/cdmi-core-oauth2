package pw.cdmi.paas.developer.rs.v3;


import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pw.cdmi.paas.developer.rs.UserController;
import pw.cdmi.paas.developer.rs.repsonse.UserResponse;
import pw.cdmi.paas.developer.rs.request.UserRequest;
import pw.cdmi.paas.developer.service.UserAccountService;

@RestController
@RequestMapping(value="pass/v3")
public class UserContorllerImpl implements UserController {

	@Autowired
	private UserAccountService userAccountService;
	@Override
	@RequestMapping(value="/users/login",method=RequestMethod.POST)
	public @ResponseBody UserResponse login(@RequestBody UserRequest userRequest) {
		// TODO 参数合法性检查
		
		if(userRequest.getOpenId()==null||userRequest.getPassword()==null){
			throw new SecurityException("账号或密码不能为空");
		}
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		auths.add( new GrantedAuthority(){
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				// TODO Auto-generated method stub
				return "ROLE_USER";
			}
		});
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userRequest.getOpenId(),userRequest.getPassword(),auths);
		UserResponse login = userAccountService.login(userRequest);
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		
		return login;
	}

	@Override
	public @ResponseBody UserResponse OpenIdFindUserAccount(@RequestParam("openId") String openId) {
		// TODO 参数合法性
		if(openId==null)
			throw new SecurityException("openId is null");
		
		return userAccountService.findUserAccount(openId);
	}

	@Override
	@RequestMapping(value="/users/user",method=RequestMethod.POST)
	public @ResponseBody UserResponse register(@RequestBody UserRequest userRequest) {
		// TODO 参数合法性检查
		if(userRequest.getOpenId()==null||userRequest.getPassword()==null){
			throw new SecurityException("账号或密码不能为空");
		}
			
		return userAccountService.userAccountObject(userRequest);
	}

}
