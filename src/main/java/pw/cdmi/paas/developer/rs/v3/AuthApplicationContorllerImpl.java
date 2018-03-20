package pw.cdmi.paas.developer.rs.v3;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pw.cdmi.paas.developer.model.AuthApplicationType;
import pw.cdmi.paas.developer.rs.AuthApplicationContorller;
import pw.cdmi.paas.developer.rs.repsonse.AuthApplicationResponse;
import pw.cdmi.paas.developer.rs.repsonse.DeveloperResponse;
import pw.cdmi.paas.developer.rs.request.AuthApplicationRequest;
import pw.cdmi.paas.developer.service.AuthApplicationService;
import pw.cdmi.paas.developer.service.DeveloperService;
@RestController
@RequestMapping("/paas/v3")
public class AuthApplicationContorllerImpl implements AuthApplicationContorller {

	@Autowired
	private AuthApplicationService authApplicationService;
	@Autowired
	private DeveloperService developerService;
	@Override
	@RequestMapping(value="/apps/app",method=RequestMethod.POST)
	public @ResponseBody Map<String, String> createAuthApplication(
			@RequestBody AuthApplicationRequest applicationRequest,Principal user) {
		// TODO 检查参数合法性
		if(user==null)
			throw new SecurityException("user is null");
		
		if(applicationRequest.getName()==null)
			throw new SecurityException("name is null");
		
		AuthApplicationType fromName = AuthApplicationType.fromName(applicationRequest.getType());
		if(fromName==null)
			throw new SecurityException("developerId is null");
		
		DeveloperResponse developer = developerService.openIdFindDeveloper(user.getName());
		
		AuthApplicationResponse authApplicationResponse = authApplicationService.authApplicationObject(applicationRequest, developer.getId());
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("Id", authApplicationResponse.getId());
		return hashMap;
	}
	

	@Override
	@RequestMapping(value="/apps",method=RequestMethod.GET)
	public @ResponseBody List<AuthApplicationResponse> listAuthApplication(Principal user) {
		// TODO 检查参数合法性
		if(user==null)
			throw new SecurityException("user is null");
				
		DeveloperResponse developer = developerService.openIdFindDeveloper(user.getName());		
		
		return authApplicationService.findAuthApplicationObject(developer.getId());
	}


	@Override
	@RequestMapping(value="/apps/{appid}",method=RequestMethod.DELETE)
	public void deleteAuthApplication(@PathVariable("appid") String id) {
		// TODO 检查参数合法性
		if(id==null)
			throw new SecurityException("appId is null");
		authApplicationService.deleteAuthApplication(id);
	}

}
