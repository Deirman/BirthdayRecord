package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.FriendsInfo;
import entity.UserInfo;
import util.JdbcUtil;

public class FriendsDao {
	


public Boolean addFriend(FriendsInfo friendsInfo){
	boolean results = false;
	try{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into friends_info_table (friend_name,friend_sex,friend_birthday,friend_appellation,friend_phone,friend_address) values (?,?,?,?,?,?)");
		pstmt.setString(1,friendsInfo.getFriend_name());
		pstmt.setString(2,friendsInfo.getFriend_sex());
		pstmt.setDate(3,java.sql.Date.valueOf(friendsInfo.getFriend_birthday()));
		pstmt.setString(4,friendsInfo.getFriend_appellation());
		pstmt.setString(5,friendsInfo.getFriend_phone());
		pstmt.setString(6,friendsInfo.getFriend_address());
		int value = pstmt.executeUpdate();
		JdbcUtil.close(pstmt,conn);
		if(value>0){
			results = true;
		}else{
			results = false;
		}
	}catch(SQLException e){
	    e.printStackTrace();
		throw new RuntimeException(e);
	}
	return results;
}

public List<FriendsInfo> findAllFriendsInfo(){
	List<FriendsInfo> list = new ArrayList<FriendsInfo>();
	try{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from friends_info_table");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			FriendsInfo friendsInfo = new FriendsInfo();
			friendsInfo.setFriend_name(rs.getString(2));
			friendsInfo.setFriend_sex(rs.getString(3));
			friendsInfo.setFriend_birthday(rs.getString(4));
			friendsInfo.setFriend_appellation(rs.getString(5));
			friendsInfo.setFriend_phone(rs.getString(6));
			friendsInfo.setFriend_address(rs.getString(7));
		   list.add(friendsInfo);
		}
     
		JdbcUtil.close(pstmt,conn); 
	}catch(SQLException e){
	    e.printStackTrace();
		throw new RuntimeException(e);
	}

	return list;
}

}
