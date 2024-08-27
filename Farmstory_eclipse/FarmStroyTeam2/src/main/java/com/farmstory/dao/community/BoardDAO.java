package com.farmstory.dao.community;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.community.BoardDTO;
import com.farmstory.util.DBHelper;
import com.farmstory.util.SQL;

public class BoardDAO extends DBHelper {

	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private BoardDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 글 등록
	public int insertBoard(BoardDTO dto) {
		
		int no = 0;
		
		try {
			
			conn = getConnection();
			conn.setAutoCommit(false); // 데이터베이스 연결 객체 conn의 자동 커밋 기능을 비활성화하는 역할(트랜잭션)
			
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(SQL.INSERT_BOARD);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getB_contents());
			pstmt.setInt(3, dto.getB_fNo());
			pstmt.setString(4, dto.getB_regip());
			pstmt.setString(5, dto.getB_writer());
			pstmt.executeUpdate();
			
			rs = stmt.executeQuery(SQL.SELECT_MAX_BOARD_NO);  // no의 auto-increment를 이용하여 가장 최신글은 no값이 가장 큰 것을 이용해서 글 번호를 가져옴
			
			if(rs.next()) {
				no = rs.getInt(1);
			}
			conn.commit();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			
			try {
				conn.rollback();
			} catch (Exception e1) {
				logger.error(e1.getMessage());
			}
			
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return no;
	}
	
	// 글 조회
	public BoardDTO selectBoard(String boardNo) {
		return null;
	}
	
	// 글 목록
	public List<BoardDTO> selectBoards(int start) {
		return null;
	}
	
	// 글 수정
	public void updateBoard(BoardDTO dto) {
		
	}
	
	// 글 삭제
	public int deleteBoard(int boardNo) {
		return 0;
	}
	
	
	
	
}
