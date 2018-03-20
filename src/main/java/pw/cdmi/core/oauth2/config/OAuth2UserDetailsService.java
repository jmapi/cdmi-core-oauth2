package pw.cdmi.core.oauth2.config;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import pw.cdmi.paas.developer.model.entities.UserAccount;
import pw.cdmi.paas.developer.repositories.UserAccountRepositories;
@Component
public class OAuth2UserDetailsService implements UserDetailsService {

	@Autowired
	private UserAccountRepositories  userAccountRepositories;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		auths.add( new GrantedAuthority(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				// TODO Auto-generated method stub
				return "ROLE_USER";
			}
			
		});
		UserAccount findByOpenId = userAccountRepositories.findByOpenId(username);
		System.out.println(findByOpenId.toString());
		//FIXME 配置文件中password-encoder似乎没有生效
		return new org.springframework.security.core.userdetails.User(
				findByOpenId.getOpenId(), findByOpenId.getPassword(),
				 auths);
	}


}
