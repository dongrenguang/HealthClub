package healthclub.member.model;

public class Activity {
	private int id;
	private String picture;
	private String theme;
	private String session1;
	private String session2;
	private String session3;
	private String session4;
	
	public Activity(int id, String picture, String theme, String session1,String session2,String session3,String session4) {
		super();
		this.id = id;
		this.picture = picture;
		this.theme = theme;
		this.session1 = session1;
		this.session2 = session2;
		this.session3 = session3;
		this.setSession4(session4);
	}
	public Activity(int id, String theme,String picture) {
		super();
		this.id = id;
		this.picture = picture;
		this.theme = theme;
	}
	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getSession1() {
		return session1;
	}
	public void setSession1(String session1) {
		this.session1 = session1;
	}
	public String getSession2() {
		return session2;
	}
	public void setSession2(String session2) {
		this.session2 = session2;
	}
	public String getSession3() {
		return session3;
	}
	public void setSession3(String session3) {
		this.session3 = session3;
	}
	public String getSession4() {
		return session4;
	}
	public void setSession4(String session4) {
		this.session4 = session4;
	}
	
	
	
	
}


