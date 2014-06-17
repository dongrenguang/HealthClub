package healthclub.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.member.model.Activity;
import healthclub.member.service.UserService;

public class PageAction extends BaseAction {
	private UserService userService;
	private int gotoPage;
	private ArrayList<Activity> activityList=new ArrayList<Activity>();
	
	public String execute(){
		HttpSession  session=request.getSession();
		
		int activityPageCount = userService.getActivityPageCount();
    	ArrayList<Integer> pageList = new ArrayList<Integer>();
    	for(int i=1;i<=activityPageCount;i++){
    		pageList.add(i);
    	}
    	
    	session.setAttribute("pageList", pageList);
    	activityList=userService.getActivityList(gotoPage);
    	session.setAttribute("currentPage", gotoPage);
    	return "Homepage";
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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
