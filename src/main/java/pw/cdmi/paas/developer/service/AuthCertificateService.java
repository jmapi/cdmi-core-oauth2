package pw.cdmi.paas.developer.service;

import java.util.List;

import pw.cdmi.paas.developer.rs.repsonse.AuthCertificateResponse;

public interface AuthCertificateService {
	/**
	 * 查找
	 * @param developerId
	 * @return
	 */
	public List<AuthCertificateResponse> findAuthCertficate(String developerId);
	/**
	 * 保存
	 * @param developerId
	 * @return
	 */
	public AuthCertificateResponse authCertficateObject(String developerId);
	/**
	 * 删除
	 * @param id
	 */
	public void deleteAuthCertficate(String id);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public AuthCertificateResponse updateCertficateObject(String id);
	
}
