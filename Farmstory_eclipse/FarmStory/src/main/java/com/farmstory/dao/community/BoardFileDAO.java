package com.farmstory.dao.community;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.community.BoardFileDTO;
import com.farmstory.util.DBHelper;
import com.farmstory.util.SQL;

public class BoardFileDAO extends DBHelper {

	private static BoardFileDAO instance = new BoardFileDAO();
	public static BoardFileDAO getInstance() {
		return instance;
	}
	
	private BoardFileDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public void insertBoardFile(BoardFileDTO dto) {
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL.INSERT_BOARD_FILE);
			pstmt.setInt(1, dto.getB_pNo());
			pstmt.setString(2, dto.getB_oName());
			pstmt.setString(3, dto.getB_sName());
			pstmt.executeUpdate();
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
	public BoardFileDTO selectBoardFile(String b_fNo) { // b_fNo 파라미터가 string이라서 int > string으로 바꿈

		BoardFileDTO boardFileDTO = null;
		
		try {

			conn = getConnection();
			pstmt = conn.prepareStatement(SQL.SELECT_BOARD_FILE);
			pstmt.setString(1, b_fNo);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardFileDTO = new BoardFileDTO();
				boardFileDTO.setB_fNo(rs.getInt(1));
				boardFileDTO.setB_pNo(rs.getInt(2));
				boardFileDTO.setB_oName(rs.getString(3));
				boardFileDTO.setB_sName(rs.getString(4));
				boardFileDTO.setB_rdate(rs.getString(5));
				boardFileDTO.setB_download(rs.getInt(6));
				
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
		
		return boardFileDTO;
	}
	
	public List<BoardFileDTO> selectBoardFiles() {
		return null;
	}
	
	public void updateBoardFile(String b_fNo) {
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL.UPDATE_BOARD_FILE_DOWNLOAD_COUNT);
			pstmt.setString(1, b_fNo);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
			}
		}
	}
	
	public void deleteBoardFile(int b_fNo) {
		
	}
	
	
	
}
