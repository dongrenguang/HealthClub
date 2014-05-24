package healthclub.member.action;

import javax.servlet.http.HttpSession;

import healthclub.member.assist.Result;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;

public class DeleteAccountAction extends BaseAction{
	private int id;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	public String execute(){
		try {
			HttpSession  session=request.getSession();
	   	    int sessionID=(int) session.getAttribute("id");
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		HttpSession  session=request.getSession();
   	    int id=(int) session.getAttribute("id");
   	    Users user=userService.getUser(id);
   	    user.setState(4);
   	    Result result=userService.modify(user);
   	    if(result==Result.SUCCESS){
   	    	session.invalidate();
   	   	    return "Login";
   	    }else{
   	    	return "input";
   	    }
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
	
	

}
