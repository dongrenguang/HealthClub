package healthclub.member.action;

import healthclub.member.assist.Assist;
import healthclub.member.assist.Result;
import healthclub.member.model.Activity;
import healthclub.member.service.UserService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class RegisterAction2 extends BaseAction {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private String reg_username2;
	private String reg_password2;
	private String reg_email2;
	private String reg_address2;
	private String reg_type2;

	private File reg_picture2;
	private String reg_picture2ContentType;// image/pngµÈ
	private String reg_picture2FileName;// igoo.png
	private String savePath = "member/images/picture";

	private List<String> mem_name = new ArrayList<String>();
	private List<String> mem_gender = new ArrayList<String>();
	private List<String> mem_birthday = new ArrayList<String>();
	private List<String> mem_identity = new ArrayList<String>();

	private ArrayList<Activity> activityList = new ArrayList<Activity>();

	public String execute() {
		java.sql.Date register_time = Assist.getNowDate();
		int state = 0;
		String picture = "member/images/logo.png";

		if (reg_picture2FileName != null && reg_picture2 != null) {
			picture = Assist.savePicture(savePath, reg_username2,
					reg_picture2FileName, reg_picture2);
			System.out.println("register2:picture_"+picture);
		}

		int id = userService.add(reg_username2, reg_password2, reg_email2, "0",
				register_time, reg_address2, picture, reg_type2, register_time,
				state);
		if (id < 0) {
			return "Error";
		}

		for (int i = 0; i < mem_gender.size(); i++) {
			// System.out.println("mem_name "+i+" : "+mem_name.get(i));
			// System.out.println("mem_gender "+i+" : "+mem_gender.get(i));
			// System.out.println("mem_birthday "+i+" : "+mem_birthday.get(i));
			// System.out.println("mem_identity "+i+" : "+mem_identity.get(i));
			String name = mem_name.get(i);
			String gender = mem_gender.get(i);
			java.sql.Date birthday = Assist.getBirthday(mem_birthday.get(i));
			String identity = mem_identity.get(i);
			Result result = userService.addMember(id, name, gender, birthday,
					identity);
			if (result == Result.FAIL)
				return "Error";
		}

		HttpSession session = request.getSession();
		session.setAttribute("username", reg_username2);
		session.setAttribute("id", id);
		activityList = userService.getActivityList();
		return "Homepage";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getReg_username2() {
		return reg_username2;
	}

	public void setReg_username2(String reg_username2) {
		this.reg_username2 = reg_username2;
	}

	public String getReg_password2() {
		return reg_password2;
	}

	public void setReg_password2(String reg_password2) {
		this.reg_password2 = reg_password2;
	}

	public String getReg_email2() {
		return reg_email2;
	}

	public void setReg_email2(String reg_email2) {
		this.reg_email2 = reg_email2;
	}

	public String getReg_address2() {
		return reg_address2;
	}

	public void setReg_address2(String reg_address2) {
		this.reg_address2 = reg_address2;
	}

	public String getReg_type2() {
		return reg_type2;
	}

	public void setReg_type2(String reg_type2) {
		this.reg_type2 = reg_type2;
	}

	public File getReg_picture2() {
		return reg_picture2;
	}

	public void setReg_picture2(File reg_picture2) {
		this.reg_picture2 = reg_picture2;
	}

	public String getReg_picture2ContentType() {
		return reg_picture2ContentType;
	}

	public void setReg_picture2ContentType(String reg_picture2ContentType) {
		this.reg_picture2ContentType = reg_picture2ContentType;
	}

	public String getReg_picture2FileName() {
		return reg_picture2FileName;
	}

	public void setReg_picture2FileName(String reg_picture2FileName) {
		this.reg_picture2FileName = reg_picture2FileName;
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

	public ArrayList<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(ArrayList<Activity> activityList) {
		this.activityList = activityList;
	}

}
