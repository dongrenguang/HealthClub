package healthclub.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.member.assist.Assist;
import healthclub.member.model.Session1;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;

public class ProfileAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private int id;
	private String username;
	private String email;
	private String gender;
	private String birthday;
	private String address;
	private String picture;
	private String type;
	private int state;
	private ArrayList<Session1> orderedAct=new ArrayList<Session1>();
	private ArrayList<Session1> hasJoinedAct=new ArrayList<Session1>();

	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    int sessionID=(int) session.getAttribute("id");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		HttpSession  session=request.getSession();
   	    id=(int) session.getAttribute("id");
   	    Users user=userService.getUser(id);
   	    type=user.getType();
   	    if(type.equals("Family")){
   	    	System.out.println("ProfileAction to Profile2Action");
   	    	return "Profile2";
   	    }
   	    username=user.getUsername();
   	    email=user.getEmail();
   	    gender=user.getGender();
   	    birthday=Assist.transform(user.getBirthday().toString());
   	    address=user.getAddress();
   	    picture=user.getPicture();
   	    System.out.println("picture:"+picture);
   	    
   	    state=user.getState();
   	    orderedAct=userService.getOrderedAct(id);
   	    hasJoinedAct=userService.getHasJoinedAct(id);  	    
		
		return "Profile";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ArrayList<Session1> getHasJoinedAct() {
		return hasJoinedAct;
	}

	public void setHasJoinedAct(ArrayList<Session1> hasJoinedAct) {
		this.hasJoinedAct = hasJoinedAct;
	}

	public ArrayList<Session1> getOrderedAct() {
		return orderedAct;
	}

	public void setOrderedAct(ArrayList<Session1> orderedAct) {
		this.orderedAct = orderedAct;
	}
	

}
