package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.*;
import util.*;
public class UserInfoDao {
	public void add(UserInfo userInfo){
		
		try{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into user_infot_table (id_phone_number,name,phone,email,nickname,password) values (?,?,?,?,?,?)");
			pstmt.setLong(1,userInfo.getId_phone_number());
			pstmt.setString(2,userInfo.getName());
			pstmt.setString(3,userInfo.getPhone());
			pstmt.setString(4,userInfo.getEmail());
			pstmt.setString(5,userInfo.getNickname());
			pstmt.setString(6,userInfo.getPassword());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Boolean registered(UserInfo userInfo){
		boolean results = false;
		try{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into user_infot_table (id_phone_number,name,phone,email,nickname,password) values (?,?,?,?,?,?)");
			pstmt.setLong(1,userInfo.getId_phone_number());
			pstmt.setString(2,userInfo.getName());
			pstmt.setString(3,userInfo.getPhone());
			pstmt.setString(4,userInfo.getEmail());
			pstmt.setString(5,userInfo.getNickname());
			pstmt.setString(6,userInfo.getPassword());
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
	
	public List<UserInfo> findAll(){
		List<UserInfo> list = new ArrayList<UserInfo>();
		try{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from user_infot_table");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				UserInfo userInfo = new UserInfo();
				userInfo.setId_phone_number(rs.getLong(2));
				userInfo.setName(rs.getString(3));
				userInfo.setPhone(rs.getString(4));
				userInfo.setEmail(rs.getString(5));
				userInfo.setNickname(rs.getString(6));
				userInfo.setPassword(rs.getString(7));
			   list.add(userInfo);
			}

			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);
		}

		return list;
	}
	
	public UserInfo findById(Long id){
		UserInfo userInfo = new UserInfo();
		try{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from user_infot_table where id_phone_number="+id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				userInfo.setId_phone_number(rs.getLong(2));
				userInfo.setName(rs.getString(3));
				userInfo.setPhone(rs.getString(4));
				userInfo.setEmail(rs.getString(5));
				userInfo.setNickname(rs.getString(6));
				userInfo.setPassword(rs.getString(7));
			}
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);
		}

		return userInfo;
	}
	
	public UserInfo login(String username,String password){
		UserInfo userInfo = new UserInfo();
		try{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from user_infot_table where id_phone_number="+"'"+username+"'"+" and password="+"'"+password+"'");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				userInfo.setId_phone_number(rs.getLong(2));
				userInfo.setName(rs.getString(3));
				userInfo.setPhone(rs.getString(4));
				userInfo.setEmail(rs.getString(5));
				userInfo.setNickname(rs.getString(7));
				userInfo.setPassword(rs.getString(8));
			}
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);
		}
		return userInfo;
	}
	
	public void delete(Long id){
		try{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("delete from user_infot_table where id_phone_number =?");
			pstmt.setLong(1,id);
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void update(UserInfo userInfo){
		try{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update user_infot_table SET name=?,Phone=?,email=?,nickname=?,password=? where id_phone_number=?");
			pstmt.setLong(6,userInfo.getId_phone_number());
			pstmt.setString(1,userInfo.getName());
			pstmt.setString(2,userInfo.getPhone());
			pstmt.setString(3,userInfo.getEmail());
			pstmt.setString(4,userInfo.getNickname());
			pstmt.setString(5,userInfo.getPassword());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
}
