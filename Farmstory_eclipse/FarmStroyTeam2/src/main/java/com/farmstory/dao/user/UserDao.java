package com.farmstory.dao.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.user.UserDTO;
import com.farmstory.util.DBHelper;
import com.farmstory.util.SQL;

public class UserDao extends DBHelper{
	
	private static UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public void insertUser(UserDTO dto) {	}
	
	public UserDTO selectUser(String uid, String pass) {
		UserDTO user =null;
		try {
			
			conn=getConnection();
			pstmt = conn.prepareStatement(SQL.SELECT_USER);
			pstmt.setString(1, uid);
			pstmt.setString(2, pass);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				user= new UserDTO();
				
				user.setUid(rs.getString(1));
				user.setPass(rs.getString(2));
				user.setName(rs.getString(3));
				user.setNick(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setHp(rs.getString(6));
				user.setZip(rs.getString(7));
				user.setAddr1(rs.getString(8));
				user.setAddr2(rs.getString(9));
				user.setRegDate(rs.getString(10));
				user.setGradeNo(rs.getString(11));
				
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				logger.error(e.getMessage());

			}
		}
		
		
		return user;
	}
	public List<UserDTO> selectUsers() {	
		List<UserDTO> users = new ArrayList<>();
		return users;
	}
	public void updateUser(UserDTO dto) {	}
	public void deleteUser(String uid) {	}

}