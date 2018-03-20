package pw.cdmi.paas.developer.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pw.cdmi.paas.developer.model.entities.Developer;
import pw.cdmi.paas.developer.repositories.DeveloperRepositories;
import pw.cdmi.paas.developer.rs.repsonse.DeveloperResponse;
import pw.cdmi.paas.developer.rs.repsonse.ManagerResponse;
import pw.cdmi.paas.developer.rs.request.DeveloperRequst;
import pw.cdmi.paas.developer.service.DeveloperService;
import pw.cdmi.paas.developer.service.PeopleService;
@Component
@Transactional
public class DeveloperServiceImpl implements DeveloperService {
	@Autowired
	private PeopleService peopleService;
	@Autowired
	private DeveloperRepositories DeveloperRepositories; 
	@Override
	public DeveloperResponse developerObject(DeveloperRequst developerRequst,String openId) {
		// TODO Auto-generated method stub
		Developer developer = new Developer();
		ManagerResponse peopleObjact = peopleService.peopleObjact(developerRequst.getManager(), openId);
		
		developer.setCreateTime(new Date());
		developer.setOpenId(openId);
		developer.setPeopleId(peopleObjact.getId());
		developer.setName(developerRequst.getName());
		developer.setType(developerRequst.getType());
		try {
			developer=DeveloperRepositories.save(developer);
			
		} catch (Exception e) {
			// TODO: 补充异常处理
		}
		DeveloperResponse developerResponce = new DeveloperResponse();
		developerResponce.setManager(peopleObjact);
		developerResponce.setId(developer.getId());
		developerResponce.setName(developer.getName());
		developerResponce.setType(developer.getType());
		return developerResponce;
	}

	@Override
	public DeveloperResponse openIdFindDeveloper(String openId) {
		// TODO Auto-generated method stub
		DeveloperResponse developerResponce = new DeveloperResponse();
		ManagerResponse managerResponce=null;
		Developer  developer=null;
		try {
			managerResponce=peopleService.openIdFindPeople(openId);
			developer=DeveloperRepositories.findByOpenId(openId);
		} catch (Exception e) {
			// TODO: 补充异常处理
		}
		developerResponce.setManager(managerResponce);
		developerResponce.setId(developer.getId());
		developerResponce.setName(developer.getName());
		developerResponce.setType(developer.getType());
		return developerResponce;
	}

	@Override
	public DeveloperResponse idFindDeveloper(String id) {
		// TODO Auto-generated method stub
		DeveloperResponse developerResponce = new DeveloperResponse();
		ManagerResponse managerResponce=null;
		Developer  developer=null;
		try {
			developer=DeveloperRepositories.findById(id);
			managerResponce=peopleService.idFindPeople(developer.getPeopleId());
		} catch (Exception e) {
			// TODO: 补充异常处理
		}
		developerResponce.setManager(managerResponce);
		developerResponce.setId(developer.getId());
		developerResponce.setName(developer.getName());
		developerResponce.setType(developer.getType());
		return developerResponce;
	}

}
