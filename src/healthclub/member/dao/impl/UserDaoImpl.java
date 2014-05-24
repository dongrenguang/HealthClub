package healthclub.member.dao.impl;

import java.sql.Date;

import healthclub.member.assist.Assist;
import healthclub.member.assist.Result;
import healthclub.member.dao.DaoHelper;
import healthclub.member.dao.UserDao;
import healthclub.member.model.Activity;
import healthclub.member.model.Member;
import healthclub.member.model.Pay;
import healthclub.member.model.Session1;
import healthclub.member.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.naming.java.javaURLContextFactory;

public class UserDaoImpl implements UserDao {

	private static DaoHelper daoHelper = DaoHelperImpl.getBaseDaoInstance();
	private static UserDaoImpl UserDaoImpl = new UserDaoImpl();

	private UserDaoImpl() {

	}

	public static UserDaoImpl getInstance() {
		if (UserDaoImpl == null) {
			UserDaoImpl = new UserDaoImpl();
		}
		return UserDaoImpl;
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

	public Users getUserByUsername(String username) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			stmt = con.prepareStatement("select * from users where username=?");
			stmt.setString(1, username);
			result = stmt.executeQuery();

			if (result.next()) {
				Users user = new Users(result.getInt(1), result.getString(2),
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

	@SuppressWarnings("resource")
	public int add(String username, String password, String email,
			String gender, Date birthday, String address, String picture,
			String type, Date register_time, int state) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null, stmt2 = null;
		ResultSet result = null;
		try {
			stmt = con
					.prepareStatement("insert into users(username,password,email,gender,"
							+ "birthday, address,picture,type, register_time, state) "
							+ "values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, email);
			stmt.setString(4, gender);
			stmt.setDate(5, birthday);
			stmt.setString(6, address);
			stmt.setString(7, picture);
			stmt.setString(8, type);
			stmt.setDate(9, register_time);
			stmt.setInt(10, state);
			stmt.executeUpdate();

			stmt2 = con.prepareStatement("select max(id) from users");
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

	public Result modify(Users user) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con
					.prepareStatement("update users set username=?,password=?,"
							+ "email=?,gender=?,birthday=?,address=?,picture=?,state=? where id=?");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getGender());
			stmt.setDate(5, user.getBirthday());
			stmt.setString(6, user.getAddress());
			stmt.setString(7, user.getPicture());
			stmt.setInt(8, user.getState());
			stmt.setInt(9, user.getId());

			stmt.executeUpdate();
			return Result.SUCCESS;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return Result.FAIL;
	}

	public ArrayList<Activity> getActivityList() {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con.prepareStatement("select * from activity");
			result = stmt.executeQuery();

			ArrayList<Activity> activityList = new ArrayList<Activity>();
			while (result.next()) {
				Activity activity = new Activity(result.getInt(1),
						result.getString(2), result.getString(3));
				activityList.add(activity);
			}
			return activityList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return null;
	}

	public Activity getActivity(int id) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			stmt = con.prepareStatement("select * from activity where id=?");
			stmt.setInt(1, id);
			result = stmt.executeQuery();

			if (result.next()) {
				Activity activity = new Activity(result.getInt(1),
						result.getString(2), result.getString(3));
				return activity;
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

	public ArrayList<Session1> getSessionList(int aid) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con.prepareStatement("select * from session where aid=?");
			stmt.setInt(1, aid);
			result = stmt.executeQuery();

			ArrayList<Session1> sessionList = new ArrayList<Session1>();
			while (result.next()) {
				Session1 session = new Session1(result.getInt(1), aid,
						result.getString(3), result.getString(4),
						result.getString(5), result.getString(6));
				sessionList.add(session);
			}
			return sessionList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return null;
	}

	public Result order(int uid, int sid) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;

		ResultSet result = null;
		try {
			stmt = con
					.prepareStatement("select * from joinin where uid=? and sid=?");
			stmt.setInt(1, uid);
			stmt.setInt(2, sid);
			result = stmt.executeQuery();
			if (result.next()) {
				return Result.FAIL;
			} else {
				PreparedStatement stmt2 = null;
				stmt2 = con.prepareStatement("insert into joinin(uid,sid,type)"
						+ " values(?,?,?)");
				stmt2.setInt(1, uid);
				stmt2.setInt(2, sid);
				stmt2.setInt(3, 0);
				stmt2.executeUpdate();
				return Result.SUCCESS;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return Result.FAIL;

	}

	public ArrayList<Session1> getHasJoinedAct(int uid) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("select * from session s where exists(select * from joinin j where j.uid=? and j.sid=s.id and j.type=?)");
			stmt.setInt(1, uid);
			stmt.setInt(2, 1);

			result = stmt.executeQuery();

			ArrayList<Session1> hasOrderedAct = new ArrayList<Session1>();
			while (result.next()) {
				Session1 session1 = new Session1(result.getInt(1),
						result.getInt(2), result.getString(3),
						result.getString(4), result.getString(5),
						result.getString(6));
				hasOrderedAct.add(session1);
			}
			return hasOrderedAct;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
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
						result.getString(6));
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

	public boolean cancelOrder(int uid, int sid) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			stmt = con
					.prepareStatement("delete from joinin where uid=? and sid=? and type=?");
			stmt.setInt(1, uid);
			stmt.setInt(2, sid);
			stmt.setInt(3, 0);
			result = stmt.execute();
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

	public ArrayList<Pay> GetPaymentList(int uid) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("select * from pay where uid=? and type<>?");
			stmt.setInt(1, uid);
			stmt.setInt(2, 0);

			result = stmt.executeQuery();

			ArrayList<Pay> pays = new ArrayList<Pay>();
			while (result.next()) {
				Pay pay = new Pay(result.getInt(1), uid, result.getString(3),
						result.getInt(4), result.getString(5));
				pays.add(pay);
			}
			return pays;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return null;
	}

	public boolean judgeSameUsername(String username) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			stmt = con.prepareStatement("select * from users where username=?");
			stmt.setString(1, username);
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

	public Result addMember(int uid, String name, String gender, Date birthday,
			String identity) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		// ResultSet result=null;
		try {
			stmt = con
					.prepareStatement("insert into member(uid,name,gender,birthday, identity) "
							+ "values(?,?,?,?,?)");
			stmt.setInt(1, uid);
			stmt.setString(2, name);
			stmt.setString(3, gender);
			stmt.setDate(4, birthday);
			stmt.setString(5, identity);
			stmt.executeUpdate();

			return Result.SUCCESS;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return Result.FAIL;
	}

	public ArrayList<Member> getMembers(int uid) {

		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con.prepareStatement("select * from member where uid=?");
			stmt.setInt(1, uid);

			result = stmt.executeQuery();

			ArrayList<Member> members = new ArrayList<Member>();
			while (result.next()) {
				Member member = new Member(result.getInt(1), result.getInt(2),
						result.getString(3), result.getString(4),
						result.getDate(5), result.getString(6));
				members.add(member);
			}
			return members;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return null;
	}

	public boolean ClearMembers(int uid) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			stmt = con.prepareStatement("delete from member where uid=?");
			stmt.setInt(1, uid);
			result = stmt.execute();
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

	public boolean activate(int uid) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("update users set state=? where id=?");
			stmt.setInt(1, 1);
			stmt.setInt(2, uid);
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

	public boolean pay(int pid) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("update pay set type=?,paytime=? where id=?");
			stmt.setInt(1, 2);
			stmt.setString(2, Assist.getNowDateTime());
			stmt.setInt(3, pid);
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
	
	@SuppressWarnings("resource")
	public boolean judgeUserState(int uid){
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con.prepareStatement("select count(*) from pay where uid=? and type=?");
			stmt.setInt(1, uid);
			stmt.setInt(2, 1);
			result = stmt.executeQuery();
			if(result.next()) {
				int count=result.getInt(1);
				if(count==0){
					//正常，state设为2
					stmt = con.prepareStatement("update users set state=? where id=?");
					stmt.setInt(1, 2);
					stmt.setInt(2, uid);
					stmt.executeUpdate();
				}
				else if(count>=1 && count<=6){
					//欠费少于6个月,state设为1
					stmt = con.prepareStatement("update users set state=? where id=?");
					stmt.setInt(1, 1);
					stmt.setInt(2, uid);
					stmt.executeUpdate();
				}else{
					//欠费大于6个月，state设为3
					stmt = con.prepareStatement("update users set state=? where id=?");
					stmt.setInt(1, 3);
					stmt.setInt(2, uid);
					stmt.executeUpdate();
				}
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

}
