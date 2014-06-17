package healthclub.waiter.service.impl;

import java.util.ArrayList;

import healthclub.member.dao.UserDao;
import healthclub.member.model.Activity;
import healthclub.member.model.Member;
import healthclub.member.model.Pay;
import healthclub.member.model.Session1;
import healthclub.member.model.Users;
import healthclub.waiter.dao.WaiterDao;
import healthclub.waiter.service.WaiterService;

public class WaiterServiceImpl implements WaiterService {
	private WaiterDao waiterDao;
	private static WaiterServiceImpl waiterServiceImpl=new WaiterServiceImpl();
	
	private WaiterServiceImpl(){
		
	}
	
	public static WaiterServiceImpl getInstance(){
		if(waiterServiceImpl==null){
			waiterServiceImpl=new WaiterServiceImpl();
		}
		return waiterServiceImpl;
	}
	
	public WaiterDao getWaiterDao() {
		return waiterDao;
	}

	public void setWaiterDao(WaiterDao waiterDao) {
		this.waiterDao = waiterDao;
	}

	public boolean login(String username,String password){
		return waiterDao.login(username, password);
	}
	
	public Users getUser(int id){
		return waiterDao.getUser(id);
	}
	
	public ArrayList<Session1> getOrderedAct(int uid){
		return waiterDao.getOrderedAct(uid);
	}
	
	public ArrayList<Session1> getHasJoinedAct(int uid){
		return waiterDao.getHasJoinedAct(uid);
	}
	public ArrayList<Pay> GetPaymentList(int uid){
		return waiterDao.GetPaymentList(uid);
	}
	
	public boolean Join(int uid,int sid){
		return waiterDao.Join(uid, sid);
	}
	
	public boolean DeleteAct(int uid,int sid){
		return waiterDao.DeleteAct(uid, sid);
	}
	
	public int addActivity(String theme,String picture){
		return waiterDao.addActivity(theme, picture);
	}
	
	public boolean saveSessions(ArrayList<Session1> session1s){
		return waiterDao.saveSessions(session1s);
	}
	
	public boolean saveActivity(Activity activity){
		return waiterDao.saveActivity(activity);
	}
	
	public ArrayList<Activity> getActivityList(){
		return waiterDao.getActivityList();
	}
	
	public Activity getActivity(int id){
		return waiterDao.getActivity(id);
	}
	
	public ArrayList<Session1> getSessionList(int aid){
		return waiterDao.getSessionList(aid);
	}
	
	public boolean modifySession(ArrayList<Session1> sessionList){
		return waiterDao.modifySession(sessionList);
	}
	
	public ArrayList<Member> getMembers(int uid){
		return waiterDao.getMembers(uid);
	}
	public boolean createAccount(){
		return waiterDao.createAccount();
	}
	public ArrayList<Users> getUserList(){
		return waiterDao.getUserList();
	}

}
