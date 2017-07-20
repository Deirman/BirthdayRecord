package impl;

import java.util.List;

import dao.UserInfoDao;
import entity.UserInfo;
import service.UserInfoService;


public class UserInfoServiceImpl implements UserInfoService{
	private UserInfoDao userInfoDao = new UserInfoDao();
	
	public List<UserInfo> getAllUserInfo() {
		return userInfoDao.findAll();
	}
}