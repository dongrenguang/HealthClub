package healthclub.manager.model;

public class Line {
	private String name;
	private int number;
	private float proportion;
	
	public Line(String name, int number, float proportion) {
		super();
		this.name = name;
		this.number = number;
		this.proportion = proportion;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getProportion() {
		return proportion;
	}
	public void setProportion(float proportion) {
		this.proportion = proportion;
	}
	

}
