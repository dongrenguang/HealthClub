package healthclub.member.action;

import healthclub.member.model.Member;
import healthclub.member.model.MemberVO;
import healthclub.member.model.Session1;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class ProfileAction2 extends BaseAction {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private int id;
	private String username;
	private String email;
	private String address;
	private String picture;
	private String type;
	private int state;
	
//	private ArrayList<String> name=new ArrayList<String>();
//	private ArrayList<String> identity=new ArrayList<String>();
//	private ArrayList<String> gender=new ArrayList<String>();
//	private ArrayList<String> birthday=new ArrayList<String>();
	private ArrayList<MemberVO> members=new ArrayList<MemberVO>();
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
		
    	members.clear();
    	HttpSession  session=request.getSession();
   	    id=(int) session.getAttribute("id");
   	    Users user=userService.getUser(id);
   	    type=user.getType();
   	    username=user.getUsername();
	    email=user.getEmail();
	    address=user.getAddress();
	    picture=user.getPicture();
	    state=user.getState();
	    
	    orderedAct=userService.getOrderedAct(id);
   	    hasJoinedAct=userService.getHasJoinedAct(id); 
   	    
   	    ArrayList<Member> m=new ArrayList<Member>();
   	    m=userService.getMembers(id);
   	    for(int i=0;i<m.size();i++){
   	    	MemberVO memberVO=new MemberVO(m.get(i));
   	    	members.add(memberVO);
   	    }
   	    
    	return "Profile2";
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

	public ArrayList<MemberVO> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<MemberVO> members) {
		this.members = members;
	}
    


    
    
}
