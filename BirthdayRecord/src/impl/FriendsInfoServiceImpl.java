package impl;

import dao.FriendsDao;
import entity.FriendsInfo;

public class FriendsInfoServiceImpl {
	FriendsDao friendsDao = new FriendsDao();
	public Boolean addFriend(FriendsInfo friendsInfo) {
		return friendsDao.addFriend(friendsInfo); 
	}
}
