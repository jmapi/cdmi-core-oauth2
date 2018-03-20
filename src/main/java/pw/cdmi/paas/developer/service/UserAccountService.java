package pw.cdmi.paas.developer.service;

import pw.cdmi.paas.developer.rs.repsonse.UserResponse;
import pw.cdmi.paas.developer.rs.request.UserRequest;

public interface UserAccountService {
	/**
	 * 保存user Account Object
	 * @param userRequest
	 */
	public UserResponse userAccountObject(UserRequest userRequest);
	/**
	 * 以openId查找user account 返回user responce
	 * @param openId
	 * @return
	 */
	public UserResponse findUserAccount(String openId);
	/**
	 * 判断该账号是否存在,存在返回true，不存在返回false
	 * @param openId
	 * @return
	 */
	public boolean isUserAccount(String openId);
	/**
	 * 登陆
	 * @param userRequest
	 * @return
	 */
	public UserResponse login(UserRequest userRequest);

}
