package pw.cdmi.paas.developer.rs.repsonse;

import lombok.Data;

@Data
public class AuthApplicationResponse {
	private String id;
	
	private String name;
	
	private String type;
	
	private String icon;
	
	private String create_time;
	
	private String update_time;
	
}
