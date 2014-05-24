package healthclub.member.action;

import java.util.ArrayList;

import healthclub.member.assist.Result;
import healthclub.member.model.Session1;
import healthclub.member.service.UserService;

import javax.servlet.http.HttpSession;

public class OrderAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sid;
	private UserService userService;
	private int aid;
	private String theme;
	private String picture;
	private ArrayList<Session1> sessionList=new ArrayList<Session1>();



	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    int sessionID=(int) session.getAttribute("id");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		HttpSession  session=request.getSession();
   	    int uid=(int) session.getAttribute("id");
   	    Result result=userService.order(uid, sid);
   	    if (result==Result.SUCCESS){
   			sessionList=userService.getSessionList(aid);
   	    	return "Activity";
   	    }else{
   	    	return "input";
   	    }
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

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
