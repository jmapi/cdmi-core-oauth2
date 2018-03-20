package pw.cdmi.paas.developer.rs.repsonse;

import lombok.Data;

@Data
public class AuthCertificateResponse {
	private String Id;
	
	private String appkey;
	
	private String secretkey;
	
	private String developerId;
	
	private String create_time;
	
	private String update_time;
}
