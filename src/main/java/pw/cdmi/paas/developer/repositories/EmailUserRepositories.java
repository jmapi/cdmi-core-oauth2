package pw.cdmi.paas.developer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pw.cdmi.paas.developer.model.entities.EmailUser;

public interface EmailUserRepositories extends JpaRepository<EmailUser, String> {

	//TODO 实现
	/**
	 * 查找
	 * @param peopleId
	 * @return
	 */
	public EmailUser findByPeopleId(String peopleId);
	
}
