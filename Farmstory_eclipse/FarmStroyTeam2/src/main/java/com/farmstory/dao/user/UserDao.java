package com.farmstory.dao.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.user.UserDTO;
import com.farmstory.util.DBHelper;
import com.farmstory.util.SQL;

public class UserDAO extends DBHelper{
	private static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	private UserDAO () {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertUser(UserDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_USER);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getNick());
			psmt.setString(5, dto.getEmail());
			psmt.setString(6, dto.getHp());
			psmt.setString(7, dto.getZip());
			psmt.setString(8, dto.getAddr1());
			psmt.setString(9, dto.getAddr2());
			psmt.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			closeAll();
		}
	}
	
	public UserDTO selectUser(String uid) {
		
		try {
			conn = getConnection();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			closeAll();
		}
		
		return null;
	}
	
	public List<UserDTO> selectUsers() {
		
		try {
			conn = getConnection();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			closeAll();
		}
		
		return null;
	}
	
	public void updateUser(UserDTO dto) {
		
		try {
			conn = getConnection();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			closeAll();
		}
		
	}
	
	public void deleteUser(String uid) {
		
		try {
			conn = getConnection();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			closeAll();
		}
		
	}
	
}
