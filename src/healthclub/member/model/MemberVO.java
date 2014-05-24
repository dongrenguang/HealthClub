package healthclub.member.model;

import healthclub.member.assist.Assist;

public class MemberVO {
	private int id;
	private int uid;
	private String name;
	private String gender;
	private String birthday;//把Member中birthday转化成String 
	private String identity;
	public MemberVO(Member member){
		super();
		this.id = member.getId();
		this.uid = member.getUid();
		this.name = member.getName();
		this.gender = member.getGender();
		if(member.getBirthday()!=null){
			this.birthday = Assist.transform(member.getBirthday().toString());
		}else{
			this.birthday=null;
		}
		this.identity = member.getIdentity();
	}
	
	
	public MemberVO(int id, int uid, String name, String gender,
			String birthday, String identity) {
		super();
		this.id = id;
		this.uid = uid;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.identity = identity;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	

}
