package com.farmstory.service.community;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dao.community.BoardFileDAO;
import com.farmstory.dto.community.BoardFileDTO;
import com.farmstory.util.SQL;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public enum BoardFileService {

	INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private BoardFileDAO dao = BoardFileDAO.getInstance();
	
	public void insertBoardFile(BoardFileDTO dto) {
		dao.insertBoardFile(dto);
	}
	
	public BoardFileDTO selectBoardFile(String b_fNo) { // b_fNo 파라미터가 string이라서 int > string으로 바꿈

		return dao.selectBoardFile(b_fNo);
	}
	
	public List<BoardFileDTO> selectBoardFiles() {
		return dao.selectBoardFiles();
	}
	
	public void updateBoardFile(String b_fNo) {
		dao.updateBoardFile(b_fNo);
	}
	
	public void deleteBoardFile(int b_fNo) {
		dao.deleteBoardFile(b_fNo);
	}

	public void updateBoardFileDownloadCount(String b_fNo) {
		
	}
	
	public void BoardFileDownload(HttpServletRequest req,HttpServletResponse resp) {
		
	}
	
	
	
	
}
