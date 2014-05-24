package healthclub.manager.service.impl;

import java.util.ArrayList;

import healthclub.manager.dao.ManagerDao;
import healthclub.manager.model.Line;
import healthclub.manager.model.Line2;
import healthclub.manager.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	@Override
	public int login(String username, String password) {
		// TODO Auto-generated method stub
		return managerDao.login(username, password);
	}

	@Override
	public ArrayList<Line> getAgeList() {
		// TODO Auto-generated method stub
		return managerDao.getAgeList();
	}

	@Override
	public ArrayList<Line> getAgeGroupList() {
		// TODO Auto-generated method stub
		return managerDao.getAgeGroupList();
	}

	@Override
	public ArrayList<Line> getGenderList() {
		// TODO Auto-generated method stub
		return managerDao.getGenderList();
	}

	@Override
	public ArrayList<Line> getAddressList() {
		// TODO Auto-generated method stub
		return managerDao.getAddressList();
	}

	@Override
	public ArrayList<Line> getStateList() {
		// TODO Auto-generated method stub
		return managerDao.getStateList();
	}

	@Override
	public ArrayList<Line> getCoachList() {
		// TODO Auto-generated method stub
		return managerDao.getCoachList();
	}

	@Override
	public ArrayList<Line> getSiteList() {
		// TODO Auto-generated method stub
		return managerDao.getSiteList();
	}

	@Override
	public ArrayList<Line2> getPersionnumber_monthList() {
		// TODO Auto-generated method stub
		return managerDao.getPersionnumber_monthList();
	}

	@Override
	public ArrayList<Line2> getPersionnumber_dayList() {
		// TODO Auto-generated method stub
		return managerDao.getPersionnumber_dayList();
	}

}
