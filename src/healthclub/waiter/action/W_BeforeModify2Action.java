package healthclub.waiter.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.member.assist.Assist;
import healthclub.member.model.Member;
import healthclub.member.model.MemberVO;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;

public class W_BeforeModify2Action extends BaseAction {
	private UserService userService;
    private String reg_username;
    private String reg_password;
    private String reg_email;
    private String reg_address;
    private ArrayList<MemberVO> members=new ArrayList<MemberVO>();
    
    private String old_username;
    
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    String sessionUsername=(String) session.getAttribute("username_waiter");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		HttpSession  session=request.getSession();
		int id=(int) session.getAttribute("id");
		
		Users user=userService.getUser(id);
		reg_username=user.getUsername();
		old_username=user.getUsername();
		reg_password=user.getPassword();
		reg_email=user.getEmail();
		reg_address=user.getAddress();
		
		members.clear();
   	    ArrayList<Member> m=new ArrayList<Member>();
   	    m=userService.getMembers(id);
   	    members.clear();
   	    for(int i=0;i<m.size();i++){
   	    	MemberVO memberVO=new MemberVO(m.get(i));
   	    	members.add(memberVO);
   	    }
		
		
		return "Modify2";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getReg_username() {
		return reg_username;
	}

	public void setReg_username(String reg_username) {
		this.reg_username = reg_username;
	}

	public String getReg_password() {
		return reg_password;
	}

	public void setReg_password(String reg_password) {
		this.reg_password = reg_password;
	}

	public String getReg_email() {
		return reg_email;
	}

	public void setReg_email(String reg_email) {
		this.reg_email = reg_email;
	}

	public String getReg_address() {
		return reg_address;
	}

	public void setReg_address(String reg_address) {
		this.reg_address = reg_address;
	}

   

	public ArrayList<MemberVO> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<MemberVO> members) {
		this.members = members;
	}

	public String getOld_username() {
		return old_username;
	}

	public void setOld_username(String old_username) {
		this.old_username = old_username;
	}
	
	
}
