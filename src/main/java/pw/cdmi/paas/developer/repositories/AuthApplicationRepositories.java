package pw.cdmi.paas.developer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pw.cdmi.paas.developer.model.entities.AuthApplication;


public interface AuthApplicationRepositories extends JpaRepository<AuthApplication, String> {

	/**
	 * 查询
	 * @param developerId
	 * @return
	 */
	public List<AuthApplication> findByDeveloperId(String developerId);
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id);
	
}
