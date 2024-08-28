package com.farmstory.dao.community;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.community.CommentDTO;
import com.farmstory.util.BOARDSQL;
import com.farmstory.util.DBHelper;

public class CommentDAO extends DBHelper {

	private static CommentDAO instance = new CommentDAO();
	public static CommentDAO getInstance() {
		return instance;
	}
	
	private CommentDAO() {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public int insertComment(CommentDTO dto) {
		
		int pk = 0;
		
		try {
				conn = getConnection();
				pstmt = conn.prepareStatement(BOARDSQL.INSERT_COMMENT, Statement.RETURN_GENERATED_KEYS); // INSERT 실행 후 자동 생성되는 pk값을 리턴하는 옵션 
				pstmt.setInt(1, dto.getCom_parent());
				pstmt.setString(2, dto.getCom_content());
				pstmt.setString(3, dto.getCom_writer());
				pstmt.setString(4, dto.getCom_regip());
				pstmt.executeUpdate();
				
				rs = pstmt.getGeneratedKeys(); // 우리가 설정한 pk값을 가져올 수 있음
				if(rs.next()) {
					pk = rs.getInt(1);
				}
			
				
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return pk;
	}
	
	public CommentDTO selectComment(int comNo) {
		CommentDTO dto = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARDSQL.SELECT_COMMENTS_NO);
			pstmt.setInt(1, comNo);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new CommentDTO();
				dto.setComNo(rs.getInt(1));
				dto.setCom_parent(rs.getInt(2));
				dto.setCom_content(rs.getString(3));
				dto.setCom_writer(rs.getString(4));
				dto.setCom_regip(rs.getString(5));
				dto.setCom_rdate(rs.getString(6));
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public List<CommentDTO> selectComments(int com_parent){

		List<CommentDTO> comments = new ArrayList<>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARDSQL.SELECT_COMMENTS);
			pstmt.setInt(1, com_parent);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setComNo(rs.getInt(1));
				dto.setCom_parent(rs.getInt(2));
				dto.setCom_content(rs.getString(3));
				dto.setCom_writer(rs.getString(4));
				dto.setCom_regip(rs.getString(5));
				dto.setCom_rdateSubstring(rs.getString(6));
				dto.setNick(rs.getString(7));
				comments.add(dto);
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
		
		return comments;
	}
	
	public int updateComment(CommentDTO dto) {
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARDSQL.UPDATE_COMMENT);
			pstmt.setString(1, dto.getCom_content());
			pstmt.setInt(2, dto.getComNo());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int deleteComment(String comNo) {
		 
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARDSQL.DELETE_COMMENT);
			pstmt.setString(1, comNo);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	// 게시글 삭제시 댓글 삭제 
	public void deleteComments(String boardNo) {
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARDSQL.DELETE_COMMENTS);
			pstmt.setString(1, boardNo);
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
	
	
	
}
