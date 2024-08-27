package com.farmstory.service.community;

import java.util.List;

import com.farmstory.dao.community.BoardDAO;
import com.farmstory.dto.community.BoardDTO;

public enum BoardService {

	INSTANCE;
	
	private BoardDAO dao = BoardDAO.getInstance();
	
	
	// 글 등록
	public int insertBoard(BoardDTO dto) {
		return dao.insertBoard(dto);
	}
	
	// 글 조회
	public BoardDTO selectBoard(String boardNo) {
		return dao.selectBoard(boardNo);
	}
	
	// 글 목록
	public List<BoardDTO> selectBoards(int start) {
		return dao.selectBoards(start);
	}
	
	// 글 수정
	public void updateBoard(BoardDTO dto) {
		dao.updateBoard(dto);
	}
	
	// 글 삭제
	public void deleteBoard(int boardNo) {
		dao.deleteBoard(boardNo);
	}
	
	
	
	
	
}
