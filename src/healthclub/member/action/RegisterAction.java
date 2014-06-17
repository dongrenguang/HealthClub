package healthclub.member.action;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import healthclub.member.assist.Assist;
import healthclub.member.model.Activity;
import healthclub.member.service.UserService;

public class RegisterAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private String reg_username;
	private String reg_password;
	private String reg_email;
	private String reg_gender;
	private String reg_birthday;
	private String reg_address;
	private String reg_type;

	private File reg_picture;
	private String reg_pictureContentType;// image/pngµÈ
	private String reg_pictureFileName;// igoo.png
	private String savePath = "member/images/picture";
	
	
	private ArrayList<Activity> activityList=new ArrayList<Activity>();

	@Override
	public String execute() throws Exception {
		java.sql.Date register_time = Assist.getNowDate();
		int state = 0;
		String picture = "member/images/logo.png";

		if (reg_pictureFileName != null && reg_picture != null) {
			picture = Assist.savePicture(savePath, reg_username,
					reg_pictureFileName, reg_picture);
		}
		java.sql.Date birthday = Assist.getBirthday(reg_birthday);
		int id = userService.add(reg_username, reg_password, reg_email,
				reg_gender, birthday, reg_address, picture, reg_type,
				register_time, state);

		if (id > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("username", reg_username);
			session.setAttribute("id", id);
		    activityList=userService.getActivityList();
			return "Homepage";
		} else {
			return "Error";
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

	public String getReg_address() {
		return reg_address;
	}

	public void setReg_address(String reg_address) {
		this.reg_address = reg_address;
	}

	public String getReg_type() {
		return reg_type;
	}

	public void setReg_type(String reg_type) {
		this.reg_type = reg_type;
	}

	public String getReg_birthday() {
		return reg_birthday;
	}

	public void setReg_birthday(String reg_birthday) {
		this.reg_birthday = reg_birthday;
	}

	public File getReg_picture() {
		return reg_picture;
	}

	public void setReg_picture(File reg_picture) {
		this.reg_picture = reg_picture;
	}

	public String getReg_pictureContentType() {
		return reg_pictureContentType;
	}

	public void setReg_pictureContentType(String reg_pictureContentType) {
		this.reg_pictureContentType = reg_pictureContentType;
	}

	public String getReg_pictureFileName() {
		return reg_pictureFileName;
	}

	public void setReg_pictureFileName(String reg_pictureFileName) {
		this.reg_pictureFileName = reg_pictureFileName;
	}

	public ArrayList<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(ArrayList<Activity> activityList) {
		this.activityList = activityList;
	}

}
