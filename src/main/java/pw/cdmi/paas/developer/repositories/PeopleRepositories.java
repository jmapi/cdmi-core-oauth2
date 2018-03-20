package pw.cdmi.paas.developer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pw.cdmi.paas.developer.model.entities.People;

public interface PeopleRepositories extends JpaRepository<People, String> {
	//TODO 实现
	/**
	 * 查找
	 * @return
	 */
	public People findByOpenId(String openId);
	
	public People findById(String id);

}
