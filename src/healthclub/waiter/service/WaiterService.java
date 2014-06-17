package healthclub.waiter.service;

import java.util.ArrayList;

import healthclub.member.model.Activity;
import healthclub.member.model.Member;
import healthclub.member.model.Pay;
import healthclub.member.model.Session1;
import healthclub.member.model.Users;

public interface WaiterService {
	public boolean login(String username,String password);
	public Users getUser(int id);
	public ArrayList<Session1> getOrderedAct(int uid);
	public ArrayList<Session1> getHasJoinedAct(int uid);
	public ArrayList<Pay> GetPaymentList(int uid);
	public boolean Join(int uid,int sid);
	public boolean DeleteAct(int uid,int sid);
	public int addActivity(String theme,String picture);
	public boolean saveSessions(ArrayList<Session1> session1s);
	public boolean saveActivity(Activity activity);
	public ArrayList<Activity> getActivityList();
	public Activity getActivity(int id);
	public ArrayList<Session1> getSessionList(int aid);  
	public boolean modifySession(ArrayList<Session1> sessionList);
	public ArrayList<Member> getMembers(int uid);
	public boolean createAccount();
    public ArrayList<Users> getUserList();

}
