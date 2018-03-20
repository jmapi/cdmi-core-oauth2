package pw.cdmi.paas.developer.rs.v3;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pw.cdmi.paas.developer.model.DeveloperType;
import pw.cdmi.paas.developer.rs.DeveloperContorller;
import pw.cdmi.paas.developer.rs.repsonse.DeveloperResponse;
import pw.cdmi.paas.developer.rs.request.DeveloperRequst;
import pw.cdmi.paas.developer.service.DeveloperService;
@RestController
@RequestMapping("/paas/v3")
public class DeveloperContorllerImpl implements DeveloperContorller{
	@Autowired
	private DeveloperService developerService;
	@Override
	@RequestMapping(value="/developers/developer",method=RequestMethod.POST)
	public @ResponseBody Map<String, String> createDeveloper(@RequestBody DeveloperRequst developerRequst,Principal user) {
		// TODO 检查user
		if(user==null)
			throw new SecurityException("user is null");
		if(developerRequst.getManager().getEmail()==null||developerRequst.getManager().getMobile()==null||developerRequst.getManager().getName()==null)
			throw new SecurityException("manager  is null");
		if(developerRequst.getName()==null)
			throw new SecurityException("developerName is null");
		DeveloperType fromName = DeveloperType.fromName(developerRequst.getType());
		if(fromName==null)
			throw new SecurityException("Incorrect type");
		DeveloperResponse developerObject = developerService.developerObject(developerRequst, user.getName());
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", developerObject.getId());
		return map;
	}

	@Override
	@RequestMapping(value="/developers/{developerId}",method=RequestMethod.GET)
	public @ResponseBody DeveloperResponse findDeveloper(@PathVariable("developerId")String developerId) {
		// TODO 检查参数
		if(developerId==null)
			throw new SecurityException("developerId is null");
		
		return developerService.idFindDeveloper(developerId);
	}

}
