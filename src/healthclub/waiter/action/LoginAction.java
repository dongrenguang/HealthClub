package healthclub.waiter.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.waiter.service.WaiterService;

public class LoginAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WaiterService waiterService;
	private String username;
	private String password;
	
	public String execute(){
		
		if(waiterService.login(username, password)){
			HttpSession  session=request.getSession();
	    	session.setAttribute("username_waiter", username);
	    	
	    	
	    	int activityPageCount = waiterService.getActivityPageCount();
	    	ArrayList<Integer> pageList = new ArrayList<Integer>();
	    	for(int i=1;i<=activityPageCount;i++){
	    		pageList.add(i);
	    	}
	    	session.setAttribute("pageList", pageList);
	    	session.setAttribute("currentPage", 1);
			return "W_Homepage";
		}else{
			return "input";
		}
		
		
	}

	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
