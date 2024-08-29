package com.farmstory.service.community;

import java.sql.SQLException;
import java.util.List;

import com.farmstory.dao.community.BoardDAO;
import com.farmstory.dto.community.BoardDTO;
import com.farmstory.dto.community.PageGroupDTO;
import com.farmstory.util.BOARDSQL;

public enum BoardService {

	INSTANCE;
	
	private BoardDAO dao = BoardDAO.getInstance();
	

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
		
		if(pg != null ) {
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

	
	public int selectCountTotal() {
		return dao.selectCountTotal();
	}
	
	
//	전체 게시물 카테고리별 갯수 구하기
	public int selectCountTotalCate(String b_cateNo) {
		return dao.selectCountTotalCate(b_cateNo);
	}
	
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
	
	// 카테고리별 글 목록 
	public List<BoardDTO> selectBoardsCate(int start, String cate) {
		return dao.selectBoardsCate(start, cate);
	}
	
	// 메인페이지 카테고리별 글 목록
	public List<BoardDTO> selectBoardsCateMain(String cate) {
		return dao.selectBoardsCateMain(cate);
	}
	
	
	
	// 글 수정
	public void updateBoard(BoardDTO dto) {
		dao.updateBoard(dto);
	}
	
	// 글 삭제
	public void deleteBoard(String boardNo) {
		dao.deleteBoard(boardNo);
	}
	
	// 글 목록 조회수 증가
	public void update_board_hit(String boardNo) {
		dao.update_board_hit(boardNo);
	}
	
	
}
