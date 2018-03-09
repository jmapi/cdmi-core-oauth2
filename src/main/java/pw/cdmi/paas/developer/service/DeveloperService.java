package pw.cdmi.paas.developer.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pw.cdmi.paas.developer.model.entities.Developer;
import pw.cdmi.paas.developer.repositories.DeveloperRepositorie;
import pw.cdmi.paas.developer.rs.DeveloperRequest;


@Component
public class DeveloperService {
	@Autowired
	private DeveloperRepositorie developerRepositorie;
	/**
	 * 添加一个开发者
	 * @param develogerRequest
	 * @param userName
	 */
	public void developerObject(DeveloperRequest develogerRequest,String userName){
		Developer developer = new Developer();
		developer.setCreateTime(new Date());
		developer.setDeveloperName(develogerRequest.getName());
		developer.setDeveloperType(develogerRequest.getType());
		developer.setManagerEmail(develogerRequest.getManager().getEmail());
		developer.setManagerName(develogerRequest.getManager().getName());
		developer.setManagerPhone(develogerRequest.getManager().getMoblie());
		developerRepositorie.save(developer);
		
	}
	/**
	 * 根据id、username查询一个开发者
	 * @param id
	 * @param username
	 * @return
	 */
	public Developer findDeveloper(String id,String username){
		//TODO 检查参数合法
		if(id!=null||username!=null)
		{
			if(id!=null) return developerRepositorie.findById(id);
			else return developerRepositorie.findByDeveloperName(username);
		}
		return null;
	}
	
	public List<Developer> listDeveloper(String userUid){
		
		return developerRepositorie.findByUserUid(userUid);
	}
	
	public DeveloperService() {
		// TODO Auto-generated constructor stub
	}

}
