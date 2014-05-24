package healthclub.manager.action;

import javax.servlet.http.HttpSession;

import healthclub.manager.service.ManagerService;
import healthclub.manager.action.BaseAction;

public class Manager_LogoutAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManagerService managerService;
	public String execute(){
		System.out.println("logout!!!!!!!!!!!!!!!!!!!!!!!!!!");
		HttpSession  session=request.getSession();
		session.invalidate();
		
		return "Login";
	}
	public ManagerService getManagerService() {
		return managerService;
	}
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
}
