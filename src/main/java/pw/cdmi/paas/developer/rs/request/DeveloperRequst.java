package pw.cdmi.paas.developer.rs.request;

import lombok.Data;

@Data
public class DeveloperRequst {
	
	private ManagerRequest manager;
	
	private String name;
	
	private String type;
	
}
