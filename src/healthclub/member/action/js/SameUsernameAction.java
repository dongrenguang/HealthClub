package healthclub.member.action.js;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;

public class SameUsernameAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private String reg_username;
	
	public String execute() throws IOException{
//		HttpSession  session=request.getSession();
//		int id=(int) session.getAttribute("id");
//		System.out.println("same:"+id);
//		if(id!=null){
//			Users user=userService.getUser(id);
//		}
		
		
		boolean hasSameUsername=userService.judgeSameUsername(reg_username);
		System.out.println(reg_username);
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

	public String getReg_username() {
		return reg_username;
	}

	public void setReg_username(String reg_username) {
		this.reg_username = reg_username;
	}
	
	

}
