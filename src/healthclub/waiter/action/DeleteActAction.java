package healthclub.waiter.action;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.waiter.service.WaiterService;

public class DeleteActAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WaiterService waiterService;
	private int uid;
	private int sid;
	
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    String sessionUsername=(String) session.getAttribute("username_waiter");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		boolean res=waiterService.DeleteAct(uid, sid);
		System.out.println("has delete!");
		if(res){
			return "Member";
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
	

}
