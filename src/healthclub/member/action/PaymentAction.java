package healthclub.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import healthclub.member.model.Pay;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;

public class PaymentAction extends BaseAction {
	private UserService userService;
	private String username;
	private int uid;
	private String type;
	private int state;
	private String picture;
	private ArrayList<Pay> paymentList=new ArrayList<Pay>();
	
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    int sessionID=(int) session.getAttribute("id");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		HttpSession  session=request.getSession();
   	    uid=(int) session.getAttribute("id");
   	    Users user=userService.getUser(uid);
   	    username=user.getUsername();
   	    type=user.getType();
   	    state=user.getState();
   	    picture=user.getPicture();
   	    paymentList=userService.GetPaymentList(uid);
		
		return "Payment";
	}
		
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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
	

}
