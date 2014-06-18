package healthclub.waiter.action;

import javax.servlet.http.HttpSession;

import healthclub.member.action.BaseAction;
import healthclub.member.assist.Assist;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;

public class W_BeforeModifyAction extends BaseAction{
	private UserService userService;
    private String reg_username;
    private String reg_password;
    private String reg_email;
    private String reg_gender;
    private String reg_birthday;
    private String reg_address;
    
    private String old_username;
	
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    String sessionUsername=(String) session.getAttribute("username_waiter");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		int id=-1;
		try {
			HttpSession  session=request.getSession();
		    id=(int) session.getAttribute("waiter_memberID");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		Users user=userService.getUser(id);
		reg_username=user.getUsername();
		old_username=user.getUsername();
		reg_email=user.getEmail();
		reg_gender=user.getGender();
		reg_birthday=Assist.transform(user.getBirthday().toString());//////////////?
		reg_address=user.getAddress();
		
		System.out.println("beforeMOdify:birthday "+reg_birthday);
		return "Modify";
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


	public String getReg_gender() {
		return reg_gender;
	}


	public void setReg_gender(String reg_gender) {
		this.reg_gender = reg_gender;
	}


	public String getReg_birthday() {
		return reg_birthday;
	}


	public void setReg_birthday(String reg_birthday) {
		this.reg_birthday = reg_birthday;
	}


	public String getReg_address() {
		return reg_address;
	}


	public void setReg_address(String reg_address) {
		this.reg_address = reg_address;
	}


	public String getOld_username() {
		return old_username;
	}


	public void setOld_username(String old_username) {
		this.old_username = old_username;
	}
	

}
