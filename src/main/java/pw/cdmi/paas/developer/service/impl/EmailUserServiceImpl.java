package pw.cdmi.paas.developer.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pw.cdmi.paas.developer.model.entities.EmailUser;
import pw.cdmi.paas.developer.repositories.EmailUserRepositories;
import pw.cdmi.paas.developer.service.EmailUserService;
@Component
@Transactional
public class EmailUserServiceImpl implements EmailUserService{
	@Autowired
	private EmailUserRepositories emailUserRepositories;
	@Override
	public EmailUser emailUserObject(EmailUser emailUser) {
		// TODO 补充抛出异常
		EmailUser emailUser2=null;
		try {
			emailUser2=emailUserRepositories.save(emailUser);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return emailUser2;
	}

	@Override
	public EmailUser findEmailUser(String peopleId) {
		// TODO 补充抛出异常
		EmailUser emailUser=null;
		try {
			emailUser=emailUserRepositories.findByPeopleId(peopleId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return emailUser;
	}

}
