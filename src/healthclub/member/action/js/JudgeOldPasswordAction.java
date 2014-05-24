package healthclub.member.action.js;


import java.io.IOException;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;

public class JudgeOldPasswordAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
    private String old_password;
    
    public String execute() throws IOException{
    	System.out.println("jj");
		HttpSession  session=request.getSession();
		int id=(int) session.getAttribute("id");
		System.out.println("jjj");
		Users user=userService.getUser(id);
		
		String pwString=user.getPassword();
		if(old_password.equals(pwString)){
			response.getWriter().print("Y");
		}else{
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

	public String getOld_password() {
		return old_password;
	}

	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}


}
