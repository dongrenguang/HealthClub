package healthclub.waiter.action;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.member.assist.Assist;
import healthclub.member.model.Activity;
import healthclub.member.model.Session1;
import healthclub.waiter.service.WaiterService;

public class AddActivityAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WaiterService waiterService;
	private String act_theme;
	
	private File act_picture;
    private String act_pictureContentType;//image/pngµÈ
    private String act_pictureFileName;//igoo.png
    private final String savePath="member/images/activity";
    
    private ArrayList<String> act_time;
    private ArrayList<String> act_location;
    private ArrayList<String> act_coach;
	
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    String sessionUsername=(String) session.getAttribute("username_waiter");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		String picture="waiter/images/activity/default.jpg";
		System.out.println("begin addactivity!");
		int aid=waiterService.addActivity(act_theme, picture);
		if(aid<0){
			System.out.println("aid= "+aid);
			return "input";
		}
		
		ArrayList<Session1> sessionList=new ArrayList<Session1>();
		for(int i=0;i<act_coach.size();i++){
			String time=act_time.get(i);
			String location=act_location.get(i);
			String coach=act_coach.get(i);
			Session1 s=new Session1(-1, aid, time, location, coach, act_theme);
			sessionList.add(s);
		}
		boolean res=waiterService.saveSessions(sessionList);
		if(!res){
			System.out.println("save sessions error!");
			return "input";
		}
		
		if(act_pictureFileName!=null && act_picture!=null){
        	picture=Assist.savePicture(savePath, ""+aid, act_pictureFileName, act_picture);
        }
		
		Activity activity=new Activity(aid, act_theme, picture);
		boolean res2=waiterService.saveActivity(activity);
		if(!res2){
			System.out.println("\nsave picture error");
			return "input";
		}
		
		
		
		return "Activity";
		
	}

	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}

	public String getAct_theme() {
		return act_theme;
	}

	public void setAct_theme(String act_theme) {
		this.act_theme = act_theme;
	}

	public File getAct_picture() {
		return act_picture;
	}

	public void setAct_picture(File act_picture) {
		this.act_picture = act_picture;
	}

	public String getAct_pictureContentType() {
		return act_pictureContentType;
	}

	public void setAct_pictureContentType(String act_pictureContentType) {
		this.act_pictureContentType = act_pictureContentType;
	}

	public String getAct_pictureFileName() {
		return act_pictureFileName;
	}

	public void setAct_pictureFileName(String act_pictureFileName) {
		this.act_pictureFileName = act_pictureFileName;
	}

	public ArrayList<String> getAct_time() {
		return act_time;
	}

	public void setAct_time(ArrayList<String> act_time) {
		this.act_time = act_time;
	}

	public ArrayList<String> getAct_location() {
		return act_location;
	}

	public void setAct_location(ArrayList<String> act_location) {
		this.act_location = act_location;
	}

	public ArrayList<String> getAct_coach() {
		return act_coach;
	}

	public void setAct_coach(ArrayList<String> act_coach) {
		this.act_coach = act_coach;
	}
	
	

}
