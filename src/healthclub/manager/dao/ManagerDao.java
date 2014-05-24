package healthclub.manager.dao;

import healthclub.manager.model.Line;
import healthclub.manager.model.Line2;

import java.util.ArrayList;

public interface ManagerDao {
	public int login(String username,String password);
	public ArrayList<Line> getAgeList();
	public ArrayList<Line> getAgeGroupList();
	public ArrayList<Line> getGenderList();
	public ArrayList<Line> getAddressList();
	public ArrayList<Line> getStateList();
	public ArrayList<Line> getCoachList();
	public ArrayList<Line> getSiteList();
	public ArrayList<Line2> getPersionnumber_monthList();
	public ArrayList<Line2> getPersionnumber_dayList();

}
