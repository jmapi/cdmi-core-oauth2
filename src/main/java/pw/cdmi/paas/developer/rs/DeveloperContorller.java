package pw.cdmi.paas.developer.rs;

import java.security.Principal;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pw.cdmi.paas.developer.rs.repsonse.DeveloperResponse;
import pw.cdmi.paas.developer.rs.request.DeveloperRequst;

public interface DeveloperContorller {
	@POST
	@Path("/paas/v3/developers/developer")
	public Map<String, String> createDeveloper(DeveloperRequst developerRequst,Principal user);
	
	@GET
	@Path("/paas/v3/developers/{developerid}")
	public DeveloperResponse findDeveloper(String developerId);
}
