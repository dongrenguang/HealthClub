package healthclub.member.model;

public class Location {
	private int id;
	private String name;
	public Location(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
