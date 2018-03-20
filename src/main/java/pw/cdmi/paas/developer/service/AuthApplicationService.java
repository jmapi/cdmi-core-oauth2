package pw.cdmi.paas.developer.service;

import java.util.List;

import pw.cdmi.paas.developer.rs.repsonse.AuthApplicationResponse;
import pw.cdmi.paas.developer.rs.request.AuthApplicationRequest;

public interface AuthApplicationService {
	/**
	 * 保存
	 * @param applicationRequest
	 * @return
	 */
	public AuthApplicationResponse authApplicationObject(AuthApplicationRequest applicationRequest,String developerId);
	/**
	 * 查询
	 * @param developerId
	 * @return
	 */
	public List<AuthApplicationResponse> findAuthApplicationObject(String developerId);
	/**
	 * 删除
	 * @param id
	 */
	public void deleteAuthApplication(String id);
}
