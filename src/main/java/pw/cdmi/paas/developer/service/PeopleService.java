package pw.cdmi.paas.developer.service;

import pw.cdmi.paas.developer.rs.repsonse.ManagerResponse;
import pw.cdmi.paas.developer.rs.request.ManagerRequest;

public interface PeopleService {
	/**
	 * 保存
	 * @param managerRequest
	 */
	public ManagerResponse peopleObjact(ManagerRequest managerRequest,String openId);
	/**
	 * 查询
	 * @param openId
	 * @return
	 */
	public ManagerResponse openIdFindPeople(String openId);
	
	public ManagerResponse idFindPeople(String id);
}
