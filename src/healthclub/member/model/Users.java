package healthclub.member.model;

import java.sql.Date;

public class Users {
	private int id;
	private String username;
	private String password;
	private String email;
	private String gender;
	private Date birthday;
	private String address;
	private String picture;
	private String type;
	private Date register_time;
	private int state;

	public Users(int id, String username, String password, String email,
			String gender, Date birthday, String address, String picture,
			String type, Date register_time, int state) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.picture = picture;
		this.type = type;
		this.register_time = register_time;
		this.state = state;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int id,String username){
		this.id=id;
		this.username=username;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
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
	public Date getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	

}
