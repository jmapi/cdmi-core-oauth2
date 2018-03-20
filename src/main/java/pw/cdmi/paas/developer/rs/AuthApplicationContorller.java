package pw.cdmi.paas.developer.rs;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import pw.cdmi.paas.developer.rs.repsonse.AuthApplicationResponse;
import pw.cdmi.paas.developer.rs.request.AuthApplicationRequest;

public interface AuthApplicationContorller {
	/**
	 * 创建接入app
	 * @param applicationRequest
	 * @return
	 */
	@POST
	@Path("/paas/v3/apps/app")
	public Map<String, String> createAuthApplication(AuthApplicationRequest applicationRequest,Principal user);
	/**
	 * 查询该开发者使用接入app
	 * @param developerId
	 * @return
	 */
	@GET
	@Path("/paas/v3/apps")
	public List<AuthApplicationResponse> listAuthApplication(Principal user);
	/**
	 * 删除指定接入app
	 * @param id
	 */
	@GET
	@Path("/paas/v3/apps/{appId}")
	public void deleteAuthApplication(String id);
}
