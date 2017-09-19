package service;

import java.util.List;

import entity.FriendsInfo;

public interface FriendsInfoService {
	public Boolean addFriend(FriendsInfo friendsInfo);//添加好友
	public List<FriendsInfo> getAllFriendsInfo();//查询用户信息
}
