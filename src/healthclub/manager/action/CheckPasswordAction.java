package healthclub.manager.action;

import healthclub.manager.service.ManagerService;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;
import healthclub.waiter.service.WaiterService;

import java.io.IOException;

import org.apache.catalina.tribes.MembershipService;

public class CheckPasswordAction extends BaseAction{
	private String username;
	private String password;
	private ManagerService managerService;
	private UserService userService;
	private WaiterService waiterService;
	
	public String execute() throws IOException {
			int id=managerService.login(username, password);
	
		if(id<0){
			response.getWriter().print("N");
		}else{
			response.getWriter().print("Y");
		}
		
		return null;
	}
	
	public String member() throws IOException{
		Users user=userService.getUserByUsername(username);
	    if(user==null || (!(user.getPassword().equals(password))) || user.getState()==4) {
	    	response.getWriter().print("N");
		}else{
			response.getWriter().print("Y");
		}
		return null;
	}
	
	public String waiter() throws IOException{
		if(waiterService.login(username, password)){
			response.getWriter().print("Y");
		}else{
			response.getWriter().print("N");
		}
		return null;
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

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}

}
