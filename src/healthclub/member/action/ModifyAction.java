package healthclub.member.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import healthclub.member.assist.Assist;
import healthclub.member.assist.Result;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;

public class ModifyAction extends BaseAction{
    private UserService userService;
    private String reg_username;
    private String new_password;
    private String reg_email;
    private String reg_gender;
    private String reg_birthday;
    private String reg_address;
    private String waiter;
    //private String reg_type;
    
    private File upload;
    private String uploadContentType;//image/pngµÈ
    private String uploadFileName;//igoo.png
    
    private final String savePath="member/images/picture";
    
    public String execute(){
    	try {
			HttpSession  session=request.getSession();
			System.out.println("modify,waiter="+waiter);
			if(waiter==null){
				int sessionID=(int) session.getAttribute("id");
			}else if(waiter.equals("waiter")){
				int sessionID=(int) session.getAttribute("waiter_memberID");
			}else{
				return "input";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		HttpSession  session=request.getSession();
		int id=0;
		if(waiter==null){
			id=(int) session.getAttribute("id");
		}else if(waiter.equals("waiter")){
			id=(int) session.getAttribute("waiter_memberID");
		}
		
		Users user=userService.getUser(id);
		
		user.setUsername(reg_username);
		user.setEmail(reg_email);
		if(new_password!=null && !((new_password.trim()).equals(""))){
			user.setPassword(new_password);
		}
		user.setGender(reg_gender);
		user.setBirthday(Assist.getBirthday(reg_birthday));
		user.setAddress(reg_address);
		if(upload!=null){
			String picture=Assist.savePicture(savePath, reg_username, uploadFileName, upload);
			user.setPicture(picture);
		}
		
		Result result=userService.modify(user);
		if(result==Result.SUCCESS){
			try {
				if(waiter.equals("waiter")){
					return "Member";
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			session.setAttribute("username", reg_username);
    	    return "ProfileAction";
		}else {
			return "input";
		}
    	
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

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
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

	public String getReg_address() {
		return reg_address;
	}

	public void setReg_address(String reg_address) {
		this.reg_address = reg_address;
	}

//	public String getReg_type() {
//		return reg_type;
//	}
//
//	public void setReg_type(String reg_type) {
//		this.reg_type = reg_type;
//	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getReg_birthday() {
		return reg_birthday;
	}

	public void setReg_birthday(String reg_birthday) {
		this.reg_birthday = reg_birthday;
	}

	public String getWaiter() {
		return waiter;
	}

	public void setWaiter(String waiter) {
		this.waiter = waiter;
	}
	
	

}
