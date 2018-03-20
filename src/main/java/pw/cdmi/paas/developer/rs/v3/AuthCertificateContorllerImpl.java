package pw.cdmi.paas.developer.rs.v3;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pw.cdmi.paas.developer.rs.AuthCertificateContorller;
import pw.cdmi.paas.developer.rs.repsonse.AuthCertificateResponse;
import pw.cdmi.paas.developer.rs.repsonse.DeveloperResponse;
import pw.cdmi.paas.developer.service.AuthCertificateService;
import pw.cdmi.paas.developer.service.DeveloperService;

@RestController
@RequestMapping("/paas/v3")
public class AuthCertificateContorllerImpl implements AuthCertificateContorller {
	@Autowired
	private AuthCertificateService authCertificateService;
	@Autowired
	private DeveloperService developerService;
	@Override
	@RequestMapping(value="/certificates/certificate",method=RequestMethod.POST)
	public @ResponseBody AuthCertificateResponse createAuthCertificate(Principal user) {
		// TODO Auto-generated method stub
		if(user==null)
			throw new SecurityException("user is null");
		DeveloperResponse developer = developerService.openIdFindDeveloper(user.getName());
		
		return authCertificateService.authCertficateObject(developer.getId());
	}

	@Override
	@RequestMapping(value="/certificates",method=RequestMethod.GET)
	public @ResponseBody List<AuthCertificateResponse> listAuthCertificate(Principal user) {
		// TODO Auto-generated method stub
		if(user==null)
			throw new SecurityException("user is null");
		DeveloperResponse developer = developerService.openIdFindDeveloper(user.getName());
		return authCertificateService.findAuthCertficate(developer.getId());
	}

	@Override
	@RequestMapping(value="/certificates/{certificateid}",method=RequestMethod.DELETE)
	public @ResponseBody  void deleteAuthCertificate(@PathVariable("certificateid")String id) {
		// TODO Auto-generated method stub
		if(id==null)
			throw new SecurityException("id is null");
		authCertificateService.deleteAuthCertficate(id);
	}

	@Override
	@RequestMapping(value="/certificates/{certificateid}/secretkey",method=RequestMethod.PUT)
	public @ResponseBody Map<String, String> updateAuthCertificate(@PathVariable("certificateid")String id) {
		// TODO Auto-generated method stub
		if(id==null)
			throw new SecurityException("id is null");
		AuthCertificateResponse authCertificate = authCertificateService.updateCertficateObject(id);
		authCertificate.getSecretkey();
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("secretkey", authCertificate.getSecretkey());
		return hashMap;
	}

}
