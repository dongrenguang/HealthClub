package healthclub.manager.action;

import javax.servlet.http.HttpSession;

import healthclub.manager.service.ManagerService;
import healthclub.manager.action.BaseAction;

public class Manager_LoginAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManagerService managerService;
	private String username;
	private String password;
	
	public String execute(){
		int id_manager=managerService.login(username, password);
		if(id_manager<0){
			return "input";
		}
		HttpSession  session=request.getSession();
		session.setAttribute("id_manager", id_manager);
   	    session.setAttribute("username_manager", username);
		return "ManagerAction";
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
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
