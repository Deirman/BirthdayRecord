package service;

import java.util.List;
import entity.UserInfo;

public interface UserInfoService {
	public List<UserInfo> getAllUserInfo();//查询用户信息
	public UserInfo login(String username,String password);//登录接口
	public Boolean registered(UserInfo userInfo);//注册接口
}
