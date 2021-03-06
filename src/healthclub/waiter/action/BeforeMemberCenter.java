package healthclub.waiter.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.member.model.Users;
import healthclub.waiter.service.WaiterService;

public class BeforeMemberCenter extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WaiterService waiterService;
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    String sessionUsername=(String) session.getAttribute("username_waiter");
	   	    ArrayList<Users> userList = waiterService.getUserList();
	   	    session.setAttribute("userList", userList);
	   	   // System.out.println("!!!!!!!!!!!");
	   	    System.out.println(sessionUsername);
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		return "MemberCenter";
	}
	public WaiterService getWaiterService() {
		return waiterService;
	}
	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}
	
	

}
