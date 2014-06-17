package healthclub.waiter.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import healthclub.member.assist.Assist;
import healthclub.member.assist.Result;
import healthclub.member.dao.DaoHelper;
import healthclub.member.dao.impl.DaoHelperImpl;
import healthclub.member.dao.impl.UserDaoImpl;
import healthclub.member.model.Activity;
import healthclub.member.model.Member;
import healthclub.member.model.Pay;
import healthclub.member.model.Session1;
import healthclub.member.model.Users;
import healthclub.waiter.dao.WaiterDao;

public class WaiterDaoImpl implements WaiterDao {
	private static DaoHelper daoHelper = DaoHelperImpl.getBaseDaoInstance();
	private static WaiterDaoImpl waiterDaoImpl = new WaiterDaoImpl();
	private static UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();

	private WaiterDaoImpl() {

	}

	public static WaiterDaoImpl getInstance() {
		return waiterDaoImpl;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			stmt = con
					.prepareStatement("select * from waiters where name=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			result = stmt.executeQuery();

			if (result.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return false;
	}

	public Users getUser(int id) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			stmt = con.prepareStatement("select * from users where id=?");
			stmt.setInt(1, id);
			result = stmt.executeQuery();

			if (result.next()) {
				Users user = new Users(id, result.getString(2),
						result.getString(3), result.getString(4),
						result.getString(5), result.getDate(6),
						result.getString(7), result.getString(8),
						result.getString(9), result.getDate(10),
						result.getInt(11));
				return user;
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return null;
	}

	public ArrayList<Session1> getOrderedAct(int uid) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("select * from session s where exists(select * from joinin j where j.uid=? and j.sid=s.id and j.type=?)");
			stmt.setInt(1, uid);
			stmt.setInt(2, 0);
			result = stmt.executeQuery();
			ArrayList<Session1> joinedAct = new ArrayList<Session1>();
			while (result.next()) {
				Session1 session1 = new Session1(result.getInt(1),
						result.getInt(2), result.getString(3),
						result.getString(4), result.getString(5),
						result.getString(6), false);
				joinedAct.add(session1);
			}
			return joinedAct;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return null;

	}

	public ArrayList<Session1> getHasJoinedAct(int uid) {
		return userDaoImpl.getHasJoinedAct(uid);
	}

	public ArrayList<Pay> GetPaymentList(int uid) {
		return userDaoImpl.GetPaymentList(uid);
	}

	public boolean Join(int uid, int sid) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con
					.prepareStatement("update joinin set type=? where uid=? and sid=?");
			stmt.setInt(1, 1);
			stmt.setInt(2, uid);
			stmt.setInt(3, sid);

			stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return false;
	}

	public boolean DeleteAct(int uid, int sid) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			stmt = con
					.prepareStatement("delete from joinin where uid=? and sid=? and type=?");
			stmt.setInt(1, uid);
			stmt.setInt(2, sid);
			stmt.setInt(3, 1);
			result = stmt.execute();
			System.out.println(uid + "," + sid);
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return false;
	}

	public int addActivity(String theme, String picture) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null, stmt2 = null;
		ResultSet result = null;
		try {
			stmt = con.prepareStatement("insert into activity(theme,picture)"
					+ "values(?,?)");
			stmt.setString(1, theme);
			stmt.setString(2, picture);
			stmt.executeUpdate();

			stmt2 = con.prepareStatement("select max(id) from activity");
			result = stmt2.executeQuery();

			if (result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return -1;

	}

	public boolean saveSessions(ArrayList<Session1> session1s) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null, stmt2 = null;
		ResultSet result = null;
		try {
			for (int i = 0; i < session1s.size(); i++) {
				Session1 s = session1s.get(i);
				stmt = con
						.prepareStatement("insert into session(aid,time,location,coach,theme)"
								+ "values(?,?,?,?,?)");
				stmt.setInt(1, s.getAid());
				stmt.setString(2, s.getTime());
				stmt.setString(3, s.getLocation());
				stmt.setString(4, s.getCoach());
				stmt.setString(5, s.getTheme());

				stmt.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}

		return false;
	}

	public boolean saveActivity(Activity activity) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con
					.prepareStatement("update activity set theme=?,picture=? where id=?");
			stmt.setString(1, activity.getTheme());
			stmt.setString(2, activity.getPicture());
			stmt.setInt(3, activity.getId());

			stmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return false;
	}

	public ArrayList<Activity> getActivityList() {
		return userDaoImpl.getActivityList();
	}

	public Activity getActivity(int id) {
		return userDaoImpl.getActivity(id);
	}

	public ArrayList<Session1> getSessionList(int aid) {
		return userDaoImpl.getSessionList(aid);
	}

	public boolean modifySession(ArrayList<Session1> sessionList) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;

		try {
			for (int i = 0; i < sessionList.size(); i++) {
				Session1 s = sessionList.get(i);
				stmt = con
						.prepareStatement("update session set time=?,location=?,coach=?,theme=? where id=?");
				stmt.setString(1, s.getTime());
				stmt.setString(2, s.getLocation());
				stmt.setString(3, s.getCoach());
				stmt.setString(4, s.getTheme());
				stmt.setInt(5, s.getId());
				stmt.executeUpdate();
			}
			return true;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return false;
	}

	public ArrayList<Member> getMembers(int uid) {
		return userDaoImpl.getMembers(uid);
	}

	public boolean createAccount() {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		System.out.println("waiterservice create account");
		try {
			stmt = con.prepareStatement("select id from users");
			result = stmt.executeQuery();

			ArrayList<Integer> userIdList = new ArrayList<Integer>();
			while (result.next()) {
				int uid = result.getInt(1);
				userIdList.add(uid);
			}

			String nowMonth = Assist.getNowMonth();
			for (int i = 0; i < userIdList.size(); i++) {
				stmt = con.prepareStatement("insert into pay(uid,month,type)"
						+ "values(?,?,?)");
				stmt.setInt(1, userIdList.get(i));
				stmt.setString(2, nowMonth);
				stmt.setInt(3, 1);
				stmt.executeUpdate();
			}
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return false;
	}
	
	public ArrayList<Users> getUserList(){
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Users> userList = new ArrayList<Users>();
		try {
			stmt = con.prepareStatement("select id, username from users");
			result = stmt.executeQuery();
			while (result.next()) {
				Users user=new Users(result.getInt(1), result.getString(2));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return userList;
	}

}
