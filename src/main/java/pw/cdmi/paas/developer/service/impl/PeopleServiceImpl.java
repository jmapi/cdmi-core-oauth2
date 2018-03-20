package pw.cdmi.paas.developer.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pw.cdmi.paas.developer.model.entities.EmailUser;
import pw.cdmi.paas.developer.model.entities.MobileUser;
import pw.cdmi.paas.developer.model.entities.People;
import pw.cdmi.paas.developer.repositories.PeopleRepositories;
import pw.cdmi.paas.developer.rs.repsonse.ManagerResponse;
import pw.cdmi.paas.developer.rs.request.ManagerRequest;
import pw.cdmi.paas.developer.service.EmailUserService;
import pw.cdmi.paas.developer.service.MobileUserService;
import pw.cdmi.paas.developer.service.PeopleService;

@Component
@Transactional
public class PeopleServiceImpl implements PeopleService {
	@Autowired
	private PeopleRepositories peopleRepositories;
	@Autowired
	private MobileUserService mobileUserService;
	@Autowired
	private EmailUserService emailUserService;
	@Override
	public ManagerResponse peopleObjact(ManagerRequest managerRequest,String openId) {
		// TODO Auto-generated method stub
		EmailUser emailUser = new EmailUser();
		MobileUser mobileUser = new MobileUser();
		People people = new People();
		
		people.setTrueName(managerRequest.getName());
		people.setOpenId(openId);
		//TODO 异常处理
		People save =null;
		try {
			save = peopleRepositories.save(people);
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		mobileUser.setMobile(managerRequest.getMobile());
		mobileUser.setPeopleId(save.getId());
		
		emailUser.setEmail(managerRequest.getEmail());
		emailUser.setPeopleId(save.getId());
		
		try {
			emailUserService.emailUserObject(emailUser);
			mobileUserService.mobileUserObject(mobileUser);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		ManagerResponse managerResponce = new ManagerResponse();
		managerResponce.setName(save.getTrueName());
		managerResponce.setMobile(mobileUser.getMobile());
		managerResponce.setEmail(emailUser.getEmail());
		return managerResponce;
	}

	@Override
	public ManagerResponse openIdFindPeople(String openId) {
		// TODO Auto-generated method stub
		People people=null;
		MobileUser mobileUser=null;
		EmailUser emailUser=null;
		try {
			people=peopleRepositories.findByOpenId(openId);
			mobileUser=mobileUserService.findMobileUser(people.getId());
			emailUser=emailUserService.findEmailUser(people.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		ManagerResponse managerResponce = new ManagerResponse();
		managerResponce.setName(people.getTrueName());
		managerResponce.setEmail(emailUser.getEmail());
		managerResponce.setMobile(mobileUser.getMobile());
		return managerResponce;
	}

	
	@Override
	public ManagerResponse idFindPeople(String id) {
		// TODO Auto-generated method stub
		People people=null;
		MobileUser mobileUser=null;
		EmailUser emailUser=null;
		try {
			people=peopleRepositories.findById(id);
			mobileUser=mobileUserService.findMobileUser(people.getId());
			emailUser=emailUserService.findEmailUser(people.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		ManagerResponse managerResponce = new ManagerResponse();
		managerResponce.setName(people.getTrueName());
		managerResponce.setEmail(emailUser.getEmail());
		managerResponce.setMobile(mobileUser.getMobile());
		return managerResponce;
	}

}
