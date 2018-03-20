package pw.cdmi.core.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import pw.cdmi.paas.developer.model.entities.AuthCertificate;
import pw.cdmi.paas.developer.repositories.AuthCertificateRepositories;

public class OAuth2ClientDetailsService implements ClientDetailsService {
	@Autowired
	private AuthCertificateRepositories authCertificateService;
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		// TODO Auto-generated method stub
		AuthCertificate authCertificate=null;
			
		authCertificate = authCertificateService.findByAccessKey(clientId);
			
		if(authCertificate==null) 
			throw new SecurityException("没有找到该凭证");
		
		BaseClientDetails clientDetail=new BaseClientDetails(authCertificate.getAccessKey(),"service_oauth2" , "app", "authorization_code", null);
		clientDetail.setClientSecret(authCertificate.getSecretKey());
		return clientDetail;
	}

}
