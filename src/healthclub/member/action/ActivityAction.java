package healthclub.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.member.model.Activity;
import healthclub.member.model.Session1;
import healthclub.member.service.UserService;

public class ActivityAction extends BaseAction{
	private int aid;
	private String theme;
	private String picture;
	private UserService userService;
	private ArrayList<Session1> sessionList=new ArrayList<Session1>();
	
	
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    int sessionID=(int) session.getAttribute("id");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		Activity activity=userService.getActivity(aid);
		theme=activity.getTheme();
		picture=activity.getPicture();
		
		sessionList=userService.getSessionList(aid);
		return "Activity";
	}


	public int getAid() {
		return aid;
	}


	public void setAid(int aid) {
		this.aid = aid;
	}


	public String getTheme() {
		return theme;
	}


	public void setTheme(String theme) {
		this.theme = theme;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public ArrayList<Session1> getSessionList() {
		return sessionList;
	}


	public void setSessionList(ArrayList<Session1> sessionList) {
		this.sessionList = sessionList;
	}

}
