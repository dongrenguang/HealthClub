package healthclub.waiter.action;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.waiter.service.WaiterService;

public class BeforeMakeActivity extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WaiterService waiterService;
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    String sessionUsername=(String) session.getAttribute("username_waiter");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		return "MakeActivity";
	}
	public WaiterService getWaiterService() {
		return waiterService;
	}
	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}
	
	

}
