package pw.cdmi.paas.developer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pw.cdmi.paas.developer.model.entities.UserAccount;

public interface UserAccountRepositories extends JpaRepository<UserAccount, String> {
	//TODO 实现
	/**
	 * 查找
	 * @param openId
	 * @return
	 */
	public UserAccount findByOpenId(String openId);
	/**
	 * 返回openid数量
	 * @param openId
	 * @return
	 */
	public long countByOpenId(String openId);
	/**
	 * login
	 * @param openId
	 * @param PassWord
	 * @return
	 */
	public UserAccount findByOpenIdAndPassword(String openId,String Password);
	

}
