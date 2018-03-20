package pw.cdmi.paas.developer.service;

import pw.cdmi.paas.developer.rs.repsonse.DeveloperResponse;
import pw.cdmi.paas.developer.rs.request.DeveloperRequst;

public interface DeveloperService {
	/**
	 * 保存
	 * @param developerRequst
	 */
	public DeveloperResponse developerObject(DeveloperRequst developerRequst,String openId);
	/**
	 * 账号查询
	 * @param openId
	 * @return
	 */
	public DeveloperResponse openIdFindDeveloper(String openId);
	/**
	 * id查询
	 * @param id
	 * @return
	 */
	public DeveloperResponse idFindDeveloper(String id);
	
}
