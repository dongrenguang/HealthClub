package healthclub.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.naming.java.javaURLContextFactory;

import com.mysql.jdbc.authentication.MysqlClearPasswordPlugin;

import healthclub.manager.dao.ManagerDao;
import healthclub.manager.model.Line;
import healthclub.manager.model.Line2;
import healthclub.member.assist.Assist;
import healthclub.member.dao.DaoHelper;
import healthclub.member.dao.impl.DaoHelperImpl;
import healthclub.member.model.Activity;

public class ManagerDaoImpl implements ManagerDao {
	private static DaoHelper daoHelper = DaoHelperImpl.getBaseDaoInstance();
	private static ManagerDaoImpl managerDaoImpl = new ManagerDaoImpl();

	private ManagerDaoImpl() {

	}

	public static ManagerDaoImpl getInstance() {
		return managerDaoImpl;
	}

	@Override
	public int login(String username, String password) {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			stmt = con
					.prepareStatement("select * from managers where name=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			result = stmt.executeQuery();

			if (result.next()) {
				int id=result.getInt(1);
				return id;
			} else {
				return -1;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return -1;
	}

	@SuppressWarnings("resource")
	@Override
	public ArrayList<Line> getAgeList() {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {

			stmt = con
					.prepareStatement("select birthday from users u where u.type=? and u.birthday<>? union all select birthday from member m where m.birthday<>?");
			stmt.setString(1, "Personal");
			stmt.setString(2, "NULL");
			stmt.setString(3, "NULL");
			result = stmt.executeQuery();

			HashMap<String, Integer> ageMap = new HashMap<String, Integer>();
			while (result.next()) {
				java.sql.Date date = result.getDate(1);
				int ageInt = Assist.getAge(date);
				String age = "";
				if (ageInt >= 10) {
					age = "" + ageInt;
				} else {
					age = "0" + ageInt;
				}

				int cnt = 0;
				if (ageMap.containsKey(age)) {
					cnt = ageMap.get(age);
				}
				ageMap.put(age, cnt + 1);
			}

			// ����
			List<Map.Entry<String, Integer>> infoIds = Assist.lineSort(ageMap);
			ArrayList<Line> ageList = new ArrayList<Line>();
			int amount = getAmount();// ������
			for (int i = 0; i < infoIds.size(); i++) {
				String key = infoIds.get(i).getKey();
				int value = infoIds.get(i).getValue();
				float proportion = (float) value / (float) amount;
				Line line = new Line(key + "", value, proportion);
				ageList.add(line);
			}
			return ageList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return null;
	}

	@Override
	public ArrayList<Line> getAgeGroupList() {
		// TODO Auto-generated method stub
		ArrayList<Line> ageList = new ArrayList<Line>();
		ageList = getAgeList();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("0~09", 0);
		map.put("10~19", 0);
		map.put("20~29", 0);
		map.put("30~39", 0);
		map.put("40~49", 0);
		map.put("50~59", 0);
		map.put("60~69", 0);
		map.put("70~79", 0);
		map.put("80~89", 0);
		map.put("90~99", 0);
		map.put("above 100", 0);
		try {
			for (int i = 0; i < ageList.size(); i++) {
				Line line = ageList.get(i);
				int age = Integer.parseInt((line.getName()));
				int number = line.getNumber();
				if (age >= 0 && age < 9) {
					int cnt = map.get("0~09");
					map.put("0~09", cnt + number);
				} else if (age >= 10 && age < 19) {
					int cnt = map.get("10~19");
					map.put("10~19", cnt + number);
				} else if (age >= 20 && age < 29) {
					int cnt = map.get("20~29");
					map.put("20~29", cnt + number);
				} else if (age >= 30 && age < 39) {
					int cnt = map.get("30~39");
					map.put("30~39", cnt + number);
				} else if (age >= 40 && age < 49) {
					int cnt = map.get("40~49");
					map.put("40~49", cnt + number);
				} else if (age >= 50 && age < 59) {
					int cnt = map.get("50~59");
					map.put("50~59", cnt + number);
				} else if (age >= 60 && age < 69) {
					int cnt = map.get("60~69");
					map.put("60~69", cnt + number);
				} else if (age >= 70 && age < 79) {
					int cnt = map.get("70~79");
					map.put("70~79", cnt + number);
				} else if (age >= 80 && age < 89) {
					int cnt = map.get("80~89");
					map.put("80~89", cnt + number);
				} else if (age >= 90 && age < 99) {
					int cnt = map.get("90~99");
					map.put("90~99", cnt + number);
				} else {
					int cnt = map.get("above 100");
					map.put("above 100", cnt + number);
				}
			}// for
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		/*
		 * int amount=getAmount();// ������ Iterator iterator =
		 * map.entrySet().iterator(); ArrayList<Line> ageGroupList=new
		 * ArrayList<Line>(); while (iterator.hasNext()) { Entry entry = (Entry)
		 * iterator.next(); String key =(String) entry.getKey(); int value=
		 * (int) entry.getValue(); float proportion=(float)value/(float)amount;
		 * Line line=new Line(key, value, proportion); ageGroupList.add(line); }
		 */
		List<Map.Entry<String, Integer>> infoIds = Assist.lineSort(map);
		ArrayList<Line> ageGroupList = new ArrayList<Line>();
		int amount = getAmount();// ������
		for (int i = 0; i < infoIds.size(); i++) {
			String key = infoIds.get(i).getKey();
			int value = infoIds.get(i).getValue();
			float proportion = (float) value / (float) amount;
			Line line = new Line(key + "", value, proportion);
			ageGroupList.add(line);
		}
		return ageGroupList;

	}

	@Override
	public ArrayList<Line> getGenderList() {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {

			stmt = con
					.prepareStatement("select gender from users u where u.type=? and u.gender<>? union all select gender from member m where m.gender<>?");
			stmt.setString(1, "Personal");
			stmt.setString(2, "NULL");
			stmt.setString(3, "NULL");
			result = stmt.executeQuery();

			int amount=getAmount();
			return getLineList(result,amount);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return null;
	}

	@Override
	public ArrayList<Line> getAddressList() {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("select address from users u where u.address<>?");
			stmt.setString(1, "NULL");
			result = stmt.executeQuery();
			
			int amount=getAmountOfUsers();
			return getLineList(result,amount);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return null;
	}

	@Override
	public ArrayList<Line> getStateList() {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("select state from users ");
			result = stmt.executeQuery();
			int amount=getAmountOfUsers();
			ArrayList<Line> lineList= getLineList(result,amount);
			for(int i=0;i<lineList.size();i++){
				Line line=lineList.get(i);
				if(line.getName().equals("0")){
					line.setName("Unactivite");
				}else if(line.getName().equals("1")){
					line.setName("Pause");
				}else if(line.getName().equals("2")){
					line.setName("Normal");
				}else if(line.getName().equals("3")){
					line.setName("Stop");
				}else if(line.getName().equals("4")){
					line.setName("Cancel");
				}
				lineList.set(i, line);
			}
			return lineList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return null;
	}

	@SuppressWarnings("resource")
	@Override
	public ArrayList<Line> getCoachList() {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con.prepareStatement("select coach from session");
			result = stmt.executeQuery();
			
			int amount=getAmountOfSessions();
			ArrayList<Line> lineList=getLineList(result,amount);
			
			stmt = con.prepareStatement("select name from coach");
			result = stmt.executeQuery();
			ArrayList<Line> coachList=new ArrayList<Line>();
			while (result.next()) {
				String coach = result.getString(1);///////////////
				int number=0;
				float proportion=0;
				for(int i=0;i<lineList.size();i++){
					Line line=lineList.get(i);
					if(coach.equals(line.getName())){
						number=line.getNumber();
						proportion=line.getProportion();
						break;
					}
				}
				Line newLine=new Line(coach, number, proportion);
				coachList.add(newLine);
			}
			return coachList;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return null;
	}

	@SuppressWarnings("resource")
	@Override
	public ArrayList<Line> getSiteList() {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con.prepareStatement("select location from session");
			result = stmt.executeQuery();
			
			int amount=getAmountOfSessions();
			ArrayList<Line> lineList=getLineList(result,amount);
			
			stmt = con.prepareStatement("select name from location");
			result = stmt.executeQuery();
			ArrayList<Line> coachList=new ArrayList<Line>();
			while (result.next()) {
				String site = result.getString(1);///////////////
				int number=0;
				float proportion=0;
				for(int i=0;i<lineList.size();i++){
					Line line=lineList.get(i);
					if(site.equals(line.getName())){
						number=line.getNumber();
						proportion=line.getProportion();
						break;
					}
				}
				Line newLine=new Line(site, number, proportion);
				coachList.add(newLine);
			}
			return coachList;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return null;
	}

	@Override
	public ArrayList<Line2> getPersionnumber_monthList() {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con.prepareStatement("select s.time from joinin j,session s where j.sid=s.id");
			result = stmt.executeQuery();
			HashMap<String, Integer> map=new HashMap<String, Integer>();
			while(result.next()){
				String timeString=result.getString(1);
				String monthString=Assist.getMonth(timeString);
				int cnt = 0;
				if (map.containsKey(monthString)) {
					cnt = map.get(monthString);
				}
				map.put(monthString, cnt + 1);
			}
			
			//����
			List<Map.Entry<String, Integer>> infoIds = Assist.lineSort(map);
			ArrayList<Line2> lineList = new ArrayList<Line2>();
			for (int i = 0; i < infoIds.size(); i++) {
				String key = infoIds.get(i).getKey();
				int value = infoIds.get(i).getValue();
				Line2 line2 = new Line2(key, value);
				lineList.add(line2);
			}
			
			return lineList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return null;
	}

	@Override
	public ArrayList<Line2> getPersionnumber_dayList() {
		// TODO Auto-generated method stub
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con.prepareStatement("select s.time from joinin j,session s where j.sid=s.id");
			result = stmt.executeQuery();
			HashMap<String, Integer> map=new HashMap<String, Integer>();
			while(result.next()){
				String timeString=result.getString(1);
				String dayString=Assist.getCurrentMonthDay(timeString);
				if(dayString.equals("")){
					continue;
				}
				int cnt = 0;
				if (map.containsKey(dayString)) {
					cnt = map.get(dayString);
				}
				map.put(dayString, cnt + 1);
			}
			
			//����
			List<Map.Entry<String, Integer>> infoIds = Assist.daySort(map);
			ArrayList<Line2> lineList = new ArrayList<Line2>();
			for (int i = 0; i < infoIds.size(); i++) {
				String key = infoIds.get(i).getKey();
				int value = infoIds.get(i).getValue();
				Line2 line2 = new Line2(key, value);
				lineList.add(line2);
			}
			return lineList;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return null;
		
	}

	@SuppressWarnings("resource")
	private int getAmount() {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("select count(*) from users where type=?");
			stmt.setString(1, "Personal");
			result = stmt.executeQuery();
			int count_users = 0;
			if (result.next()) {
				count_users = result.getInt(1);
			}

			stmt = con.prepareStatement("select count(*) from member ");
			result = stmt.executeQuery();
			int count_member = 0;
			if (result.next()) {
				count_member = result.getInt(1);
			}

			int amount = count_member + count_users;// ������
			return amount;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return 0;
	}
	
	private int getAmountOfUsers() {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con
					.prepareStatement("select count(*) from users");
			result = stmt.executeQuery();
			int count_users = 0;
			if (result.next()) {
				count_users = result.getInt(1);
			}

			return count_users;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return 0;

	}
	
	private int getAmountOfSessions() {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = con.prepareStatement("select count(*) from session");
			result = stmt.executeQuery();
			int count_sessions = 0;
			if (result.next()) {
				count_sessions = result.getInt(1);
			}

			return count_sessions;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return 0;

	}
	
	private ArrayList<Line> getLineList(ResultSet result,int amount) throws SQLException{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		while (result.next()) {
			String gender = result.getString(1);///////////////
			int cnt = 0;
			if (map.containsKey(gender)) {
				cnt = map.get(gender);
			}
			map.put(gender, cnt + 1);
		}

		// ����
		List<Map.Entry<String, Integer>> infoIds = Assist.lineSort(map);
		ArrayList<Line> lineList = new ArrayList<Line>();
		for (int i = 0; i < infoIds.size(); i++) {
			String key = infoIds.get(i).getKey();
			int value = infoIds.get(i).getValue();
			float proportion = (float) value / (float) amount;
			Line line = new Line(key + "", value, proportion);
			lineList.add(line);
		}
		return lineList;
	}
	
	
	
}
