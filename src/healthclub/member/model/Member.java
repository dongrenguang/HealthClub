package healthclub.member.model;

import java.sql.Date;

public class Member {
	private int id;
	private int uid;
	private String name;
	private String gender;
	private java.sql.Date birthday;
	private String identity;
	
	public Member(int id, int uid, String name, String gender, Date birthday,
			String identity) {
		super();
		this.id = id;
		this.uid = uid;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.identity = identity;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public java.sql.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	
	
	

}
