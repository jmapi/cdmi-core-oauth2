package pw.cdmi.paas.developer.rs.repsonse;

import lombok.Data;

@Data
public class DeveloperResponse {

	private ManagerResponse manager;
	
	private String name;
	
	private String type;
	
	private String id;
}
