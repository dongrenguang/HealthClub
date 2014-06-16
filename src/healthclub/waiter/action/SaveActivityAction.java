package healthclub.waiter.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.member.model.Activity;
import healthclub.member.model.Session1;
import healthclub.waiter.service.WaiterService;

public class SaveActivityAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WaiterService waiterService;
	private int aid;
	private String act_theme;
	
	private ArrayList<Integer> act_id=new ArrayList<Integer>();
	private ArrayList<String> act_location=new ArrayList<String>();
	private ArrayList<String> act_time=new ArrayList<String>();
	private ArrayList<String> act_coach=new ArrayList<String>();
	
	
	
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    String sessionUsername=(String) session.getAttribute("username_waiter");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		Activity activity=waiterService.getActivity(aid);
		if(!(act_theme.equals(activity.getTheme()))){
			activity.setTheme(act_theme);
			boolean r=waiterService.saveActivity(activity);
		}
		
		ArrayList<Session1> sessionList=new ArrayList<Session1>();
		for(int i=0;i<act_id.size();i++){
			int id=act_id.get(i);
			String time=act_time.get(i);
			String location=act_location.get(i);
			String coach=act_coach.get(i);
			Session1 s=new Session1(id, aid, time, location, coach, act_theme,false);
			sessionList.add(s);
		}
		 boolean res=waiterService.modifySession(sessionList);
		 if(!res){
			 return "input";
		 }
		
		return "W_Homepage";
		
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



	public ArrayList<Integer> getAct_id() {
		return act_id;
	}



	public void setAct_id(ArrayList<Integer> act_id) {
		this.act_id = act_id;
	}



	public ArrayList<String> getAct_location() {
		return act_location;
	}



	public void setAct_location(ArrayList<String> act_location) {
		this.act_location = act_location;
	}



	public ArrayList<String> getAct_time() {
		return act_time;
	}



	public void setAct_time(ArrayList<String> act_time) {
		this.act_time = act_time;
	}



	public ArrayList<String> getAct_coach() {
		return act_coach;
	}



	public void setAct_coach(ArrayList<String> act_coach) {
		this.act_coach = act_coach;
	}





}
