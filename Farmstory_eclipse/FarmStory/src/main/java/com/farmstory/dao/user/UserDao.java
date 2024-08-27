package com.farmstory.dao.user;

import java.sql.SQLException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.user.UserDTO;
import com.farmstory.util.DBHelper;
import com.farmstory.util.SQL;
import com.farmstory.util.USERSQL;

public class UserDao extends DBHelper{
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	private UserDao () {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public int selectCountUser(String type,String value) {

		
		int result = 0;

		StringBuilder sql = new StringBuilder(USERSQL.SELECT_COUNT_USER);
		
		if(type.equals("uid")) {
			sql.append(USERSQL.WHERE_UID);
		}else if(type.equals("nick")){
			sql.append(USERSQL.WHERE_NICK);
		}else if(type.equals("email")) {
			sql.append(USERSQL.WHERE_EMAIL);
		}else if(type.equals("hp")) {
			sql.append(USERSQL.WHERE_HP);
		}
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, value);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			closeAll();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	public void insertUser(UserDTO dto) {
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(USERSQL.INSERT_USER);
			pstmt.setString(1, dto.getUid());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getNick());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getHp());
			pstmt.setString(7, dto.getZip());
			pstmt.setString(8, dto.getAddr1());
			pstmt.setString(9, dto.getAddr2());
			pstmt.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public UserDTO selectUser(String uid,String pass) {
		
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
		
		try {
			conn = getConnection();
			
			
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
		
		return null;
	}
	
	public void updateUser(UserDTO dto) {
		
		try {
			conn = getConnection();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
		
	}
	
	public void deleteUser(String uid) {
		
		try {
			conn = getConnection();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
		
	}
	
}
