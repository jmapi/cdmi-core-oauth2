package pw.cdmi.paas.developer.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pw.cdmi.paas.developer.model.entities.UserAccount;
import pw.cdmi.paas.developer.repositories.UserAccountRepositories;
import pw.cdmi.paas.developer.rs.repsonse.UserResponse;
import pw.cdmi.paas.developer.rs.request.UserRequest;
import pw.cdmi.paas.developer.service.UserAccountService;
@Component
@Transactional
public class UserAccountServiceImpl implements UserAccountService {
	@Autowired
	private UserAccountRepositories userAccountRepositories;
	@Override
	public UserResponse userAccountObject(UserRequest userRequest) {
		// TODO Auto-generated method stub
		UserAccount userAccount = new UserAccount();
		//TODO 检查该账号是否注册
		/*
		if(!isUserAccount(userRequest.getOpenId())){
			throw new SecurityException("该账号已存在");
		}
		*/
		userAccount.setOpenId(userRequest.getOpenId());
		userAccount.setPassword(userRequest.getPassword());
		UserAccount save = userAccountRepositories.save(userAccount);
		
		UserResponse userResponce = new UserResponse();
		userResponce.setOpenId(save.getOpenId());
		userResponce.setId(save.getId());
		return userResponce;	
		
	}

	@Override
	public UserResponse findUserAccount(String openId) {
		
		
		// TODO responce待补充
		
		//TODO 检查参数合法性
		if(openId==null){
			throw new SecurityException("openId is null");
		}
		
		UserAccount userAccount = userAccountRepositories.findByOpenId(openId);
		UserResponse userResponce = new UserResponse();
		userResponce.setId(userAccount.getId());
		userResponce.setOpenId(userAccount.getOpenId());
		return userResponce;
	}

	@Override
	public boolean isUserAccount(String openId) {
		// TODO 检查参数合法性
		if(openId==null)
			return true;
		if(userAccountRepositories.countByOpenId(openId)>0){
			System.out.println(userAccountRepositories.countByOpenId(openId));
			return true;
		}
		return false;
	}

	@Override
	public UserResponse login(UserRequest userRequest) {
		// TODO Auto-generated method stub
		UserAccount userAccount=null;
		UserResponse userResponce = new UserResponse();
		try {
			userAccount=userAccountRepositories.findByOpenIdAndPassword(userRequest.getOpenId(), userRequest.getPassword());
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(userAccount==null)
			throw new SecurityException("验证失败");
		userResponce.setOpenId(userAccount.getOpenId());
		userResponce.setId(userAccount.getId());
		return null;
	}

}
