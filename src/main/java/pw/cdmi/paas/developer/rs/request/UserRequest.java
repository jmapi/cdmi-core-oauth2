package pw.cdmi.paas.developer.rs.request;

import lombok.Data;

@Data
public class UserRequest {
	//TODO openid、password
	private String openId; //账号
	private String password;//密码
	
}
