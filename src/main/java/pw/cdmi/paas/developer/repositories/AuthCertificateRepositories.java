package pw.cdmi.paas.developer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pw.cdmi.paas.developer.model.entities.AuthCertificate;

public interface AuthCertificateRepositories extends JpaRepository<AuthCertificate, String> {
	//TODO 实现
	/**
	 * 查找
	 * @param developerId
	 * @return
	 */
	public List<AuthCertificate> findByDeveloperId(String developerId);
	public AuthCertificate findById(String id);
	public AuthCertificate findByAccessKey(String accesskey);
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id);
}
