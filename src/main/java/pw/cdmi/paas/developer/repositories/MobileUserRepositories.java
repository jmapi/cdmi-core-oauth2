package pw.cdmi.paas.developer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pw.cdmi.paas.developer.model.entities.MobileUser;

public interface MobileUserRepositories extends JpaRepository<MobileUser, String> {

	//TODO 实现
	/**
	 * 查询
	 * @param peopleId
	 * @return
	 */
	public MobileUser findByPeopleId(String peopleId);
}
