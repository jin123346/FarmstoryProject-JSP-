package com.farmstory.dao.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.event.EventArticleDTO;
import com.farmstory.util.DBHelper;
import com.farmstory.util.SQL;

public class EventArticleDAO extends DBHelper{
	
	private static EventArticleDAO instance = new EventArticleDAO();
	public static EventArticleDAO getInstance() {
		return instance;
	}
	
	private EventArticleDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public int insertBoard(EventArticleDTO dto) {
		int no = 0;
		
		
		try {
			
			conn = getConnection();
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(SQL.INSERT_BOARD);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getB_contents());
			pstmt.setInt(3, dto.getB_fNo());
			pstmt.setString(4, dto.getB_writer());
			pstmt.setString(5, dto.getB_regip());
			pstmt.executeUpdate();
			
			closeAll();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			
		}
		return no;
	}
	
	
	

}
