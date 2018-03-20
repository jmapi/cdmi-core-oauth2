package pw.cdmi.paas.developer.service;

import pw.cdmi.paas.developer.model.entities.EmailUser;

public interface EmailUserService {
	/**
	 * 保存
	 * @param <emailUserObject>
	 * @param emailUser
	 */
	public EmailUser emailUserObject(EmailUser emailUser);
	/**
	 * 查询
	 * @param peopleId
	 * @return
	 */
	public EmailUser findEmailUser(String peopleId);
}
