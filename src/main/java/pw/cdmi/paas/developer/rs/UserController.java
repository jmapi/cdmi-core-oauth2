package pw.cdmi.paas.developer.rs;

import pw.cdmi.paas.developer.rs.repsonse.UserResponse;
import pw.cdmi.paas.developer.rs.request.UserRequest;

public interface UserController {
	/**
	 * 登陆
	 * @param userRequest
	 * @return
	 */
	public UserResponse login(UserRequest userRequest);
	/**
	 * 查询
	 * @param openId
	 * @return
	 */
	public UserResponse OpenIdFindUserAccount(String openId);
	/**
	 * 注册
	 * @param userRequest
	 * @return
	 */
	public UserResponse register(UserRequest userRequest);
}
