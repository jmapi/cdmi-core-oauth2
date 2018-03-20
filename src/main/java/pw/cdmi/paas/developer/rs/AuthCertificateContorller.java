package pw.cdmi.paas.developer.rs;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import pw.cdmi.paas.developer.rs.repsonse.AuthCertificateResponse;

public interface AuthCertificateContorller {
	/**
	 * 创建
	 * @param user
	 * @return
	 */
	public AuthCertificateResponse createAuthCertificate(Principal user);
	/**
	 * 查找该开发者所有凭证
	 * @param user
	 * @return
	 */
	public List<AuthCertificateResponse> listAuthCertificate(Principal user);
	/**
	 * 删除指定凭证
	 * @param id
	 */
	public void deleteAuthCertificate(String id);
	/**
	 * 更新密匙
	 * @param id
	 * @return
	 */
	public Map<String, String> updateAuthCertificate(String id);
}
