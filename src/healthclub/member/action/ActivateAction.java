package healthclub.member.action;

import javax.servlet.http.HttpSession;

import healthclub.member.service.UserService;

public class ActivateAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    int sessionID=(int) session.getAttribute("id");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		HttpSession  session=request.getSession();
		int uid=(int) session.getAttribute("id");
		boolean re=userService.activate(uid);
		
		if(re){
			System.out.println("Has activate!!!!!!!!!!!");
			return "Payment";
		}else{
			return "input";
		}
		
		
		
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
