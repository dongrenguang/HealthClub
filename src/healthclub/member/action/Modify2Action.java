package healthclub.member.action;

import healthclub.member.assist.Assist;
import healthclub.member.assist.Result;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class Modify2Action extends BaseAction {
    private UserService userService;
    private String reg_username;
    private String new_password;
    private String reg_email;
    private String reg_address;
    
    private File upload;
    private String uploadContentType;//image/pngµÈ
    private String uploadFileName;//igoo.png
    private final String savePath="member/images/picture";
    
    private List<String> mem_name = new ArrayList<String>();
    private List<String> mem_gender = new ArrayList<String>();
    private List<String> mem_birthday = new ArrayList<String>();
    private List<String> mem_identity = new ArrayList<String>();
    
    private String waiter;

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
		
		user.setUsername(reg_username);
		user.setEmail(reg_email);
		user.setAddress(reg_address);
		if(new_password!=null && !((new_password.trim()).equals(""))){
			user.setPassword(new_password);
		}
		if(upload!=null){
			String picture=Assist.savePicture(savePath, reg_username, uploadFileName, upload);
			user.setPicture(picture);
		}
		
		boolean re=userService.ClearMembers(id);
		if(!re){
			return "input";
		}
        for(int i=0;i<mem_gender.size();i++){
        	String name=mem_name.get(i);
        	String gender=mem_gender.get(i);
        	java.sql.Date birthday=Assist.getBirthday(mem_birthday.get(i));
        	String identity=mem_identity.get(i);
        	Result result=userService.addMember(id, name, gender, birthday, identity);
        	if(result==Result.FAIL)
        		return "input";
        }
		
		Result result=userService.modify(user);
		if(result==Result.SUCCESS){
			try {
				if(waiter.equals("waiter")){
					return "Member2";
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			session.setAttribute("username", reg_username);
    	    return "Profile2Action";
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

	public String getReg_address() {
		return reg_address;
	}

	public void setReg_address(String reg_address) {
		this.reg_address = reg_address;
	}

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

	public List<String> getMem_name() {
		return mem_name;
	}

	public void setMem_name(List<String> mem_name) {
		this.mem_name = mem_name;
	}

	public List<String> getMem_gender() {
		return mem_gender;
	}

	public void setMem_gender(List<String> mem_gender) {
		this.mem_gender = mem_gender;
	}

	public List<String> getMem_birthday() {
		return mem_birthday;
	}

	public void setMem_birthday(List<String> mem_birthday) {
		this.mem_birthday = mem_birthday;
	}

	public List<String> getMem_identity() {
		return mem_identity;
	}

	public void setMem_identity(List<String> mem_identity) {
		this.mem_identity = mem_identity;
	}

	public String getWaiter() {
		return waiter;
	}

	public void setWaiter(String waiter) {
		this.waiter = waiter;
	}
	
	


}
