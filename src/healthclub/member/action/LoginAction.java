package healthclub.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import healthclub.member.model.Activity;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;

public class LoginAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private String username;
	private String password;
	
	private ArrayList<Activity> activityList=new ArrayList<Activity>();

	public String execute(){
		Users user=userService.getUserByUsername(username);
	    if(user!=null && user.getPassword().equals(password)){
	    	int state=user.getState();
	    	if(state==4){//该会员已经注销
	    		return "input";
	    	}
	    	
	    	 HttpSession  session=request.getSession();
	    	 session.setAttribute("username", username);
	    	 session.setAttribute("id", user.getId());
	    	 activityList=userService.getActivityList();
	    	return "Homepage";
	    }else{
	    	return "input";
	    }
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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
	public ArrayList<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(ArrayList<Activity> activityList) {
		this.activityList = activityList;
	}

	
}
