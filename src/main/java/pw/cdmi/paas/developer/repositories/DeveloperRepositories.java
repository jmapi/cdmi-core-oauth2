package pw.cdmi.paas.developer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pw.cdmi.paas.developer.model.entities.Developer;

public interface DeveloperRepositories extends JpaRepository<Developer, String> {
	//TODO 实现
	/**
	 * 查找
	 * @param accountId
	 * @return
	 */
	public Developer findByOpenId(String openId);
	
	public Developer findById(String id);
}
