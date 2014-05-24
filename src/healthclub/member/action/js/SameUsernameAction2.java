package healthclub.member.action.js;

import java.io.IOException;

import healthclub.member.action.BaseAction;
import healthclub.member.service.UserService;

public class SameUsernameAction2 extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private String reg_username2;
	
	public String execute() throws IOException{
		boolean hasSameUsername=userService.judgeSameUsername(reg_username2);
		System.out.println(reg_username2);
		System.out.println(hasSameUsername);
		if (hasSameUsername){
			response.getWriter().print("Y");
		}			
		else {
			response.getWriter().print("N");
		}	
		
		return null;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getReg_username2() {
		return reg_username2;
	}

	public void setReg_username2(String reg_username2) {
		this.reg_username2 = reg_username2;
	}


	

}
