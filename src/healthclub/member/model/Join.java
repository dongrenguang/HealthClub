package healthclub.member.model;

public class Join {
	private int uid;//user id
	private int sid;
	private int type;

	public Join(int uid, int sid, int type) {
		super();
		this.uid = uid;
		this.sid = sid;
		this.type = type;
	}
	public Join() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	
	
}
