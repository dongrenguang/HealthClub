package healthclub.waiter.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import sun.net.www.content.audio.wav;
import healthclub.member.action.BaseAction;
import healthclub.member.model.Activity;
import healthclub.waiter.service.WaiterService;

public class W_HomepageAction extends BaseAction {

	private WaiterService waiterService;
	private ArrayList<Activity> activityList=new ArrayList<Activity>();
	
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    String sessionUsername=(String) session.getAttribute("username_waiter");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		activityList=waiterService.getActivityList();
		return "W_Homepage";
		
	}

	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}

	public ArrayList<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(ArrayList<Activity> activityList) {
		this.activityList = activityList;
	}
	

	
}
