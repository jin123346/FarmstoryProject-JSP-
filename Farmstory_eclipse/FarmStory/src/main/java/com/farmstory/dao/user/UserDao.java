package com.farmstory.dao.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.community.PageGroupDTO;
import com.farmstory.dto.user.UserDTO;
import com.farmstory.util.BOARDSQL;
import com.farmstory.util.DBHelper;
import com.farmstory.util.PRODUCTSQL;
import com.farmstory.util.SQL;
import com.farmstory.util.USERSQL;

public class UserDao extends DBHelper{
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	private UserDao () {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public UserDTO selectNameEmail(String name, String email) {
		UserDTO user =null;
		try {
			conn =getConnection();
			pstmt=conn.prepareStatement(USERSQL.SELECT_USER_NAME_EMAIL);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserDTO();
				user.setUid(rs.getString(1));
				user.setPass(rs.getString(2));
				user.setName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setHp(rs.getString(5));
				user.setRegDate(rs.getString(6));
				user.setGradeNo(rs.getString(7));
				
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
		
		
		return user ;
	}
	
	public int updateUserPass(String uid, String pass) {
		int result=0;
		try {
			conn= getConnection();
			pstmt= conn.prepareStatement(USERSQL.UPDATE_USER_PASS);
			pstmt.setString(1, pass);
			pstmt.setString(2, uid);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				logger.error(e.getMessage());

			}
		}
		
		
		return result;
		
	}
	
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
				e.printStackTrace();
			}
		}
	}
	
	
	//	전체 게시물 갯수 구하기
	public int selectCountTotal() {
		
		int total = 0;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(USERSQL.SELECT_COUNT_USER);
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return total;
	}
	
	public UserDTO selectUser(String uid,String pass) {
			UserDTO user = null;
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
		List<UserDTO> users = new ArrayList<UserDTO>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(USERSQL.SELECT_USERS);
			
			while(rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setUid(rs.getString(1));
				System.out.println(rs.getString(3));
				dto.setName(rs.getString(3));
				dto.setNick(rs.getString(4));
				dto.setEmail(rs.getString(5));
				dto.setHp(rs.getString(6));
				dto.setRegDate(rs.getString(10));
				dto.setGradeNo(rs.getString(11));
				users.add(dto);
			}
			
			closeAll();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return users;
	}
	
	
	
	// 전체 게시물 갯수에서 마지막 페이지 번호 구하기 
		public int getLastPageNum(int total) {
			
			int lastPageNum = 0;
			
			if(total % 10 == 0) {
				lastPageNum = total / 10;
			}else {
				lastPageNum = total / 10 + 1;
			}
			return lastPageNum;
		}
		
		// 페이지 시작번호(limit용)
		public int getStartNum(int currentPage) {
			return (currentPage - 1) * 10;
		}
		
		// 현재 페이지번호 구하기
		public int getCurrentPage(String pg) {
			
			int currentPage = 1; // 처음 들어왔을때 파라미터 pg가 null이라서 첫페이지가 조회됨
			
			if(pg != null) {
				currentPage = Integer.parseInt(pg);
			}
			
			return currentPage;
		}
		
		// 현재 페이지 그룹 구하기 
		public PageGroupDTO getCurrentPageGroup(int currentPage, int lastPageNum) {
			
		 	int currentPageGroup = (int) Math.ceil(currentPage / 10.0); // 현재 그룹 번호
			int pageGroupStart = (currentPageGroup - 1) * 10 + 1; // 그룹 시작 번호 
		 	int pageGroupEnd = currentPageGroup * 10; // 그룹 마지막 번호 
		 			
		 	if(pageGroupEnd > lastPageNum){
				pageGroupEnd = lastPageNum;
			}
		 	
			return new PageGroupDTO(pageGroupStart, pageGroupEnd);
		}
		
		// 페이지 시작번호
		public int getPageStartNum(int total, int currentPage) {
			int start = (currentPage - 1) * 10;
			return total - start;
		}
		
		
	
	
	
	
	public List<UserDTO> selectUsers(int start) {
		List<UserDTO> users = new ArrayList<UserDTO>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(USERSQL.SELECT_COUNT_USERS);
			pstmt.setInt(1, start);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(3));
				dto.setNick(rs.getString(4));
				dto.setEmail(rs.getString(5));
				dto.setHp(rs.getString(6));
				dto.setRegDate(rs.getString(10));
				dto.setGradeNo(rs.getString(11));
				users.add(dto);
			}
			
		
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				logger.error(e.getMessage());
			}
		}
		
		return users;
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
				e.printStackTrace();
			}		}
	}
	
	public void deleteUser(String uid) {
		
		try {
			
			
			conn = getConnection();
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(USERSQL.DELETE_USER);
			pstmt.setString(1, uid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}		}
		
	}
	
}
