package healthclub.member.service.impl;

import java.sql.Date;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import healthclub.member.assist.Result;
import healthclub.member.dao.UserDao;
import healthclub.member.model.Activity;
import healthclub.member.model.Member;
import healthclub.member.model.Pay;
import healthclub.member.model.Session1;
import healthclub.member.model.Users;
import healthclub.member.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Users getUser(int id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}
	
	public Users getUserByUsername(String username){
		return userDao.getUserByUsername(username);
	}

	public int add(String username, String password, String email,
			String gender, Date birthday, String address, String picture,
			String type, Date register_time, int state) {
		// TODO Auto-generated method stub
		return userDao.add(username, password, email, gender, birthday, address, picture, type, register_time, state);
	}

	public Result modify(Users user) {
		// TODO Auto-generated method stub
		return userDao.modify(user);
	}
	
	public ArrayList<Activity> getActivityList(){
		return userDao.getActivityList();
	}
	
	public Activity getActivity(int id){
		return userDao.getActivity(id);
	}
	public ArrayList<Session1> getSessionList(int aid){
		return userDao.getSessionList(aid);
	}
	
    public Result order(int uid,int sid){
    	return userDao.order(uid, sid);
    }
    public ArrayList<Session1> getHasJoinedAct(int uid){
    	return userDao.getHasJoinedAct(uid);
    }
    public ArrayList<Session1> getOrderedAct(int uid){
    	return userDao.getOrderedAct(uid);
    }
	public boolean cancelOrder(int uid,int sid){
		return userDao.cancelOrder(uid, sid);
	}
	public ArrayList<Pay> GetPaymentList(int uid){
		return userDao.GetPaymentList(uid);
	}
	public boolean judgeSameUsername(String username){
		return userDao.judgeSameUsername(username);
	}
	public Result addMember(int uid, String name, String gender, Date birthday,
			String identity){
		return userDao.addMember(uid, name, gender, birthday, identity);
	}
	public ArrayList<Member> getMembers(int uid){
		return userDao.getMembers(uid);
	}
	
	public boolean ClearMembers(int uid){
		return userDao.ClearMembers(uid);
	}
	
	public boolean activate(int uid){
		return userDao.activate(uid);
	}
	public boolean pay(int pid){
		return userDao.pay(pid);
	}
	
	public boolean judgeUserState(int uid){
		return userDao.judgeUserState(uid);
	}


}
