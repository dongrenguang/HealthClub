package healthclub.member.action;

import javax.servlet.http.HttpSession;

import healthclub.member.service.UserService;

public class PayAction extends BaseAction{
	
	private UserService userService;
	private int pid;
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    int sessionID=(int) session.getAttribute("id");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		boolean re=userService.pay(pid);
		if(!re){
			return "input";
		}
		
		HttpSession  session=request.getSession();
		int uid=(int) session.getAttribute("id");
		boolean re2=userService.judgeUserState(uid);
		if(!re2){
			return "input";
		}
		System.out.println("Has pay!!!!"+pid);
		return "Payment";
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	

}
