package healthclub.member.action.js;

import healthclub.member.action.BaseAction;
import healthclub.member.service.UserService;

public class ToDeleteAction extends BaseAction{
	private UserService userService;
	
	public String execute(){
		return "Delete";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

}
