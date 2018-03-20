package pw.cdmi.paas.developer.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pw.cdmi.paas.developer.model.entities.MobileUser;
import pw.cdmi.paas.developer.repositories.MobileUserRepositories;
import pw.cdmi.paas.developer.service.MobileUserService;
@Component
@Transactional
public class MobileUserServiceImpl implements MobileUserService {
	@Autowired
	private MobileUserRepositories mobileUserRepositories;
	@Override
	public MobileUser mobileUserObject(MobileUser mobileUser) {
		// TODO 补充异常处理
		MobileUser mobileUser2=null;
		try {
			mobileUserRepositories.save(mobileUser);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return mobileUser2;
	}

	@Override
	public MobileUser findMobileUser(String peopleId) {
		// TODO 补充异常处理
		MobileUser mobileUser = null;
		try {
			mobileUser =mobileUserRepositories.findByPeopleId(peopleId);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mobileUser;
	}

}
