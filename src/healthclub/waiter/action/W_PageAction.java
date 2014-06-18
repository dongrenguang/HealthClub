package healthclub.waiter.action;

import healthclub.manager.action.BaseAction;
import healthclub.member.model.Activity;
import healthclub.member.service.UserService;
import healthclub.waiter.service.WaiterService;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class W_PageAction extends BaseAction{
	private WaiterService waiterService;
	private int gotoPage;
	private ArrayList<Activity> activityList=new ArrayList<Activity>();
	
	public String execute(){
		HttpSession  session=request.getSession();
		
		int activityPageCount = waiterService.getActivityPageCount();
    	ArrayList<Integer> pageList = new ArrayList<Integer>();
    	for(int i=1;i<=activityPageCount;i++){
    		pageList.add(i);
    	}
    	
    	session.setAttribute("pageList", pageList);
    	activityList=waiterService.getActivityList(gotoPage);
    	session.setAttribute("currentPage", gotoPage);
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

	public int getGotoPage() {
		return gotoPage;
	}

	public void setGotoPage(int gotoPage) {
		this.gotoPage = gotoPage;
	}

}
