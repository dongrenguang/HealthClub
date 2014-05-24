package healthclub.waiter.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.member.model.Activity;
import healthclub.member.model.Session1;
import healthclub.waiter.service.WaiterService;

public class ModifyActAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WaiterService waiterService;
	private int aid;
	private String act_picture;
    private String act_theme;	
    
    private ArrayList<Session1> sessionList=new ArrayList<Session1>();
	
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    String sessionUsername=(String) session.getAttribute("username_waiter");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		Activity activity=waiterService.getActivity(aid);
		act_theme=activity.getTheme();
		act_picture=activity.getPicture();
		sessionList=waiterService.getSessionList(aid);
		
		return "Activity_modify";
	}

	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAct_theme() {
		return act_theme;
	}

	public void setAct_theme(String act_theme) {
		this.act_theme = act_theme;
	}

	public ArrayList<Session1> getSessionList() {
		return sessionList;
	}

	public void setSessionList(ArrayList<Session1> sessionList) {
		this.sessionList = sessionList;
	}

	public String getAct_picture() {
		return act_picture;
	}

	public void setAct_picture(String act_picture) {
		this.act_picture = act_picture;
	}
	

}
