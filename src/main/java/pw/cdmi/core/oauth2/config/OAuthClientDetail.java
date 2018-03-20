package pw.cdmi.core.oauth2.config;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import lombok.Data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
@Data
public class OAuthClientDetail implements ClientDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String clientId;
	private String ClientSecret;
	
	private Set<String> scope;
	@Override
	public Set<String> getResourceIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSecretRequired() {
		// TODO Auto-generated method stub
		return false;
	}	

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isScoped() {
		// TODO Auto-generated method stub
		return false;
	}


}
