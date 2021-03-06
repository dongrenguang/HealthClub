package healthclub.waiter.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.member.assist.Assist;
import healthclub.member.model.Pay;
import healthclub.member.model.Session1;
import healthclub.member.model.Users;
import healthclub.waiter.service.WaiterService;

public class SearchAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WaiterService waiterService;
	private int uid;
	private String username;
	private String email;
	private String gender;
	private String birthday;
	private String address;
	private String picture;
	private String type;
	
	private ArrayList<Session1> orderedAct=new ArrayList<Session1>();
	private ArrayList<Session1> hasJoinedAct=new ArrayList<Session1>();
	private ArrayList<Pay> paymentList=new ArrayList<Pay>();
	
	public String execute(){
		/*System.out.println("???????");
		System.out.println(uid);*/
		try {
			HttpSession  session=request.getSession();
	   	    String sessionUsername=(String) session.getAttribute("username_waiter");
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("error", "goes wrong!");
			return "input";
		}
		
		Users user=waiterService.getUser(uid);
		if(user == null){
			request.setAttribute("error", "user not found");
			return "input";
		}
   	    type=user.getType();
   	    if(type.equals("Family")){
   	    	System.out.println("SearchAction to Search2Action");
   	    	return "Search2Action";
   	    }
   	    username=user.getUsername();
   	    email=user.getEmail();
   	    gender=user.getGender();
   	    birthday=Assist.transform(user.getBirthday().toString());
   	    address=user.getAddress();
   	    picture=user.getPicture();
   	    
   	    orderedAct=waiterService.getOrderedAct(uid);
   	    hasJoinedAct=waiterService.getHasJoinedAct(uid);
   	    paymentList=waiterService.GetPaymentList(uid);
   	    
		 HttpSession  session=request.getSession();
		 session.removeAttribute("waiter_memberID");
		 session.setAttribute("waiter_memberID", uid);
		
		return "Member";
	}
	
	public String editToMember(){
		HttpSession  session=request.getSession();
		uid=(int) session.getAttribute("waiter_memberID");
		return execute();
	}

	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Session1> getOrderedAct() {
		return orderedAct;
	}

	public void setOrderedAct(ArrayList<Session1> orderedAct) {
		this.orderedAct = orderedAct;
	}

	public ArrayList<Session1> getHasJoinedAct() {
		return hasJoinedAct;
	}

	public void setHasJoinedAct(ArrayList<Session1> hasJoinedAct) {
		this.hasJoinedAct = hasJoinedAct;
	}

	public ArrayList<Pay> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(ArrayList<Pay> paymentList) {
		this.paymentList = paymentList;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	



}
