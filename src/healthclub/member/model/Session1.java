package healthclub.member.model;

//�����
public class Session1 {
	private int id;
	private int aid;
	private  String time;
	private String location;
	private String coach;
	private String theme;
	private boolean hasOrdered;

	
	public Session1(int id, int aid, String time, String location,
			String coach, String theme,boolean hasOrdered) {
		super();
		this.id = id;
		this.aid = aid;
		this.time = time;
		this.location = location;
		this.coach = coach;
		this.theme = theme;
		this.setHasOrdered(hasOrdered);
	}
	
	public Session1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public  String getTime() {
		return time;
	}
	public void setTime( String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}

	public boolean getHasOrdered() {
		return hasOrdered;
	}

	public void setHasOrdered(boolean hasOrdered) {
		this.hasOrdered = hasOrdered;
	}
	
	

}
