package healthclub.waiter.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.waiter.service.WaiterService;

public class W_logoutAction extends BaseAction {

	private WaiterService waiterService;
	public String execute(){
		HttpSession  session=request.getSession();
		session.invalidate();
		return "Login";
		
	}
	public WaiterService getWaiterService() {
		return waiterService;
	}
	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}
	


}
