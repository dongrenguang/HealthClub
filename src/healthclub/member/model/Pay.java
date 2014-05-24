package healthclub.member.model;

import java.sql.Date;

import org.apache.naming.java.javaURLContextFactory;

public class Pay {
	private int id;
	private int uid;
	private String month;
	private int type;
	private  String paytime;
	public Pay(int id,int uid, String month, int type,String paytime) {
		super();
		this.id=id;
		this.uid = uid;
		this.month = month;
		this.type = type;
		this.paytime=paytime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pay() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public String getPaytime() {
		return paytime;
	}

	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}
	
	

}
