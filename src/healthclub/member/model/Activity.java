package healthclub.member.model;

public class Activity {
	private int id;
	private String picture;
	private String theme;
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
	
	
	
	
}


