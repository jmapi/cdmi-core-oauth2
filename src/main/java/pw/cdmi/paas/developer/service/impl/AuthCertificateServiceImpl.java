package pw.cdmi.paas.developer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pw.cdmi.paas.developer.model.entities.AuthCertificate;
import pw.cdmi.paas.developer.repositories.AuthCertificateRepositories;
import pw.cdmi.paas.developer.rs.repsonse.AuthCertificateResponse;
import pw.cdmi.paas.developer.rs.repsonse.DeveloperResponse;
import pw.cdmi.paas.developer.service.AuthCertificateService;
import pw.cdmi.paas.developer.service.DeveloperService;
@Component
@Transactional
public class AuthCertificateServiceImpl implements AuthCertificateService {
	@Autowired
	private AuthCertificateRepositories authCertificateRepositories; 
	@Autowired
	private DeveloperService developerService;
	@Override
	public List<AuthCertificateResponse> findAuthCertficate(String developerId) {
		// TODO Auto-generated method stub
		List<AuthCertificateResponse> listAuthCertificateResponce = new ArrayList<AuthCertificateResponse>();
		List<AuthCertificate> listAuthCertificate=null;
		try {
			listAuthCertificate=authCertificateRepositories.findByDeveloperId(developerId);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		Iterator<AuthCertificate> it = listAuthCertificate.iterator();
		while(it.hasNext()){
			listAuthCertificateResponce.add(toAuthCertficateResponce((AuthCertificate)it.next()));
		}
		
		return listAuthCertificateResponce;
	}

	@Override
	public AuthCertificateResponse authCertficateObject(String developerId) {
		// TODO Auto-generated method stub
		AuthCertificate authCertificate = new AuthCertificate();
		DeveloperResponse developerResponce=null;
		try {
			developerResponce=developerService.idFindDeveloper(developerId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		authCertificate.setCreateTime(new Date());	
		authCertificate.setAccessKey(UUID.randomUUID().toString().replaceAll("-", ""));
		authCertificate.setSecretKey(UUID.randomUUID().toString().replaceAll("-", ""));
		authCertificate.setDeveloperId(developerId);
		authCertificate.setManagerId(developerResponce.getManager().getId());
		try {
			authCertificate = authCertificateRepositories.save(authCertificate);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return toAuthCertficateResponce(authCertificate);
	}

	@Override
	public void deleteAuthCertficate(String id) {
		// TODO Auto-generated method stub
		try {
			authCertificateRepositories.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Override
	public AuthCertificateResponse updateCertficateObject(String id) {
		// TODO Auto-generated method stub
		AuthCertificate authCertificate=null;
		try {
			authCertificate = authCertificateRepositories.findById(id);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		authCertificate.setSecretKey(UUID.randomUUID().toString().replaceAll("-", ""));
		AuthCertificate save = authCertificateRepositories.save(authCertificate);
		return toAuthCertficateResponce(save);
	}
	private AuthCertificateResponse toAuthCertficateResponce(AuthCertificate authCertificate){
		if(authCertificate==null)
			throw new NullPointerException("AuthCertificate is null");
		AuthCertificateResponse authCertficateResponce = new AuthCertificateResponse();
		authCertficateResponce.setId(authCertificate.getId());
		authCertficateResponce.setDeveloperId(authCertificate.getDeveloperId());
		authCertficateResponce.setAppkey(authCertificate.getAccessKey());
		authCertficateResponce.setSecretkey(authCertificate.getSecretKey());
		authCertficateResponce.setCreate_time(authCertificate.getUpDateTime()==null?null:authCertificate.getUpDateTime().toString());
		authCertficateResponce.setUpdate_time(authCertificate.getUpDateTime()==null?null:authCertificate.getUpDateTime().toString());
		
		return authCertficateResponce;
		
	}

	
	
	
	
}
