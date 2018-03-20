package pw.cdmi.paas.developer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pw.cdmi.paas.developer.model.entities.AuthApplication;
import pw.cdmi.paas.developer.repositories.AuthApplicationRepositories;
import pw.cdmi.paas.developer.rs.repsonse.AuthApplicationResponse;
import pw.cdmi.paas.developer.rs.request.AuthApplicationRequest;
import pw.cdmi.paas.developer.service.AuthApplicationService;
@Component
@Transactional
public class AuthApplicationServiceImpl implements AuthApplicationService{
	@Autowired
	private AuthApplicationRepositories authApplicationRepositories;
	@Override
	public AuthApplicationResponse authApplicationObject(
			AuthApplicationRequest applicationRequest,String developerId) {
		// TODO 保存
		AuthApplication authApplication = new AuthApplication();
		AuthApplication authApplication2=null; //返回的信息源
		
		
		authApplication.setCreateTime(new Date());
		authApplication.setAppName(applicationRequest.getName());
		authApplication.setAppType(applicationRequest.getType());
		authApplication.setUrlIcon(applicationRequest.getIcon());
		try {
			authApplication2=authApplicationRepositories.save(authApplication);
		} catch (Exception e) {
			// TODO: 补充异常处理
		}
		
		
		return toAuthApplicationResponce(authApplication2);
	}

	@Override
	public List<AuthApplicationResponse> findAuthApplicationObject(
			String developerId) {
		// TODO Auto-generated method stub
		List<AuthApplicationResponse> listAuthApplicationResponce=new ArrayList<AuthApplicationResponse>();
		List<AuthApplication> listAuthApplication=null;
		try {
			listAuthApplication=authApplicationRepositories.findByDeveloperId(developerId);
		} catch (Exception e) {
			// TODO: 异常处理
		}
		Iterator<AuthApplication> it = listAuthApplication.iterator();
		while(it.hasNext()){
			listAuthApplicationResponce.add(toAuthApplicationResponce((AuthApplication)it.next()));
		}
		return listAuthApplicationResponce;
	}

	@Override
	public void deleteAuthApplication(String id) {
		// TODO Auto-generated method stub
		authApplicationRepositories.deleteById(id);
		
	}
	private AuthApplicationResponse toAuthApplicationResponce(AuthApplication application){
		
		AuthApplicationResponse authApplicationResponce = new AuthApplicationResponse();
		authApplicationResponce.setId(application.getId());
		authApplicationResponce.setName(application.getAppName());
		authApplicationResponce.setIcon(application.getUrlIcon());
		authApplicationResponce.setCreate_time(application.getCreateTime().toString());
		authApplicationResponce.setType(application.getAppType());
		authApplicationResponce.setUpdate_time(application.getUpdateTime().toString());
		return authApplicationResponce;
	}

}
