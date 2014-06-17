package healthclub.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.member.model.Activity;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;

public class HomepageAction extends BaseAction{
	private UserService userService;
	private ArrayList<Activity> activityList=new ArrayList<Activity>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute(){
		HttpSession session = null;
		try {
			session=request.getSession();
	   	    int sessionID=(int) session.getAttribute("id");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		try {
			session=request.getSession();
	   	    int sessionID=(int) session.getAttribute("id");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		int activityPageCount = userService.getActivityPageCount();
    	ArrayList<Integer> pageList = new ArrayList<Integer>();
    	for(int i=1;i<=activityPageCount;i++){
    		pageList.add(i);
    	}
    	
    	session.setAttribute("pageList", pageList);
    	session.setAttribute("currentPage", 1);
   	 	activityList=userService.getActivityList(1);
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
	
	

}
