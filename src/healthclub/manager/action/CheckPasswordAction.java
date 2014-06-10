package healthclub.manager.action;

import healthclub.manager.service.ManagerService;

import java.io.IOException;

public class CheckPasswordAction extends BaseAction{
	private String username;
	private String password;
	private ManagerService managerService;
	
	public String execute() throws IOException {
		System.out.println(username+"    "+password);
		int id_manager=managerService.login(username, password);
		if(id_manager<0){
			response.getWriter().print("N");
		}else{
			response.getWriter().print("Y");
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
	
	
	

}
