package healthclub.manager.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.manager.model.Line;
import healthclub.manager.model.Line2;
import healthclub.manager.service.ManagerService;
import healthclub.manager.action.BaseAction;

public class ManagerAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManagerService managerService;
	private ArrayList<Line> ageList=new ArrayList<Line>();
	private ArrayList<Line> ageGroupList=new ArrayList<Line>();
	private ArrayList<Line> genderList=new ArrayList<Line>();
	private ArrayList<Line> addressList=new ArrayList<Line>();
	private ArrayList<Line> stateList=new ArrayList<Line>();
	private ArrayList<Line> coachList=new ArrayList<Line>();
	private ArrayList<Line> siteList=new ArrayList<Line>();
	private ArrayList<Line2> persionnumber_monthList=new ArrayList<Line2>();
	private ArrayList<Line2> persionnumber_dayList=new ArrayList<Line2>();
	
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    int sessionID=(int) session.getAttribute("id_manager");
	   	    System.out.println("Session is true");
	   	    System.out.println(sessionID);
		} catch (Exception e) {
			// TODO: handle exception
			 System.out.println("Session is wrong");
			return "input";
		}
		
		ageList=managerService.getAgeList();
		if(ageList==null){
			System.out.println("ageList Error!");
			return "input";
		}
		
		ageGroupList=managerService.getAgeGroupList();
		if(ageGroupList==null){
			System.out.println("ageGroupList Error!");
			return "input";
		}
		
		genderList=managerService.getGenderList();
		if(genderList==null){
			System.out.println("genderList Error!");
			return "input";
		}
		
		addressList=managerService.getAddressList();
		if(addressList==null){
			System.out.println("addressList Error!");
			return "input";
		}
		
		stateList=managerService.getStateList();
		if(stateList==null){
			System.out.println("stateList Error!");
			return "input";
		}
		
		coachList=managerService.getCoachList();
		if(coachList==null){
			System.out.println("coachList Error!");
			return "input";
		}
		
		siteList=managerService.getSiteList();
		if(siteList==null){
			System.out.println("siteList Error!");
			return "input";
		}
		
		persionnumber_monthList=managerService.getPersionnumber_monthList();
		if(persionnumber_monthList==null){
			System.out.println("persionnumber_monthList Error!");
			return "input";
		}
		
		persionnumber_dayList=managerService.getPersionnumber_dayList();
		if(persionnumber_dayList==null){
			System.out.println("persionnumber_dayList Error!");
			return "input";
		}
		
		System.out.println("Everything is ok!");
		
		return "Manager";
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public ArrayList<Line> getAgeList() {
		return ageList;
	}

	public void setAgeList(ArrayList<Line> ageList) {
		this.ageList = ageList;
	}

	public ArrayList<Line> getAgeGroupList() {
		return ageGroupList;
	}

	public void setAgeGroupList(ArrayList<Line> ageGroupList) {
		this.ageGroupList = ageGroupList;
	}

	public ArrayList<Line> getGenderList() {
		return genderList;
	}

	public void setGenderList(ArrayList<Line> genderList) {
		this.genderList = genderList;
	}

	public ArrayList<Line> getAddressList() {
		return addressList;
	}

	public void setAddressList(ArrayList<Line> addressList) {
		this.addressList = addressList;
	}

	public ArrayList<Line> getStateList() {
		return stateList;
	}

	public void setStateList(ArrayList<Line> stateList) {
		this.stateList = stateList;
	}

	public ArrayList<Line> getCoachList() {
		return coachList;
	}

	public void setCoachList(ArrayList<Line> coachList) {
		this.coachList = coachList;
	}

	public ArrayList<Line> getSiteList() {
		return siteList;
	}

	public void setSiteList(ArrayList<Line> siteList) {
		this.siteList = siteList;
	}

	public ArrayList<Line2> getPersionnumber_monthList() {
		return persionnumber_monthList;
	}

	public void setPersionnumber_monthList(ArrayList<Line2> persionnumber_monthList) {
		this.persionnumber_monthList = persionnumber_monthList;
	}

	public ArrayList<Line2> getPersionnumber_dayList() {
		return persionnumber_dayList;
	}

	public void setPersionnumber_dayList(ArrayList<Line2> persionnumber_dayList) {
		this.persionnumber_dayList = persionnumber_dayList;
	}
	
	

}
