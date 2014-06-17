package healthclub.member.service;

import healthclub.member.assist.Result;
import healthclub.member.model.Activity;
import healthclub.member.model.Member;
import healthclub.member.model.Pay;
import healthclub.member.model.Session1;
import healthclub.member.model.Users;

import java.sql.Date;
import java.util.ArrayList;

public interface UserService {
	public Users getUser(int id);
	public Users getUserByUsername(String username);
	public int add(String username, String password, String email,
			String gender, Date birthday, String address, String picture,
			String type, Date register_time, int state);
	public Result modify(Users user);
	
	public int getActivityPageCount();
	public ArrayList<Activity> getActivityList(int page);
	public Activity getActivity(int id);
	public ArrayList<Session1> getSessionList(int aid);
    public Result order(int uid,int sid);
    public ArrayList<Session1> getHasJoinedAct(int uid);
    public ArrayList<Session1> getOrderedAct(int uid);
	public boolean cancelOrder(int uid,int sid);
	public ArrayList<Pay> GetPaymentList(int uid);
	public boolean judgeSameUsername(String username);
	public Result addMember(int uid, String name, String gender, Date birthday,
			String identity);
	public ArrayList<Member> getMembers(int uid);
	public boolean ClearMembers(int uid);
	public boolean activate(int uid);
	public boolean pay(int pid);
	public boolean judgeUserState(int uid);
	public boolean hasOrderedSession(int uid,int sid);
	

}
