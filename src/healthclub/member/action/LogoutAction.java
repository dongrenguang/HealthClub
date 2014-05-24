package healthclub.member.action;

import javax.servlet.http.HttpSession;

import healthclub.member.service.UserService;

public class LogoutAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	public String execute(){
		HttpSession  session=request.getSession();
		session.invalidate();
		return "Login";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
