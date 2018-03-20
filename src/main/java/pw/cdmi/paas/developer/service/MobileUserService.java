package pw.cdmi.paas.developer.service;

import pw.cdmi.paas.developer.model.entities.MobileUser;

public interface MobileUserService {
	/**
	 * 保存
	 * @param moblieUser
	 */
	public MobileUser mobileUserObject(MobileUser mobileUser);
	/**
	 * 查找
	 * @param peopleId
	 * @return
	 */
	public MobileUser findMobileUser(String peopleId);
	
}
