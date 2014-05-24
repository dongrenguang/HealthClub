package healthclub.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.member.model.Activity;
import healthclub.member.service.UserService;

public class HomepageAction extends BaseAction{
	private UserService userService;
	private ArrayList<Activity> activityList=new ArrayList<Activity>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    int sessionID=(int) session.getAttribute("id");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		try {
			HttpSession  session=request.getSession();
	   	    int sessionID=(int) session.getAttribute("id");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		activityList=userService.getActivityList();
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
