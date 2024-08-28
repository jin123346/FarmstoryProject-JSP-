package com.farmstory.controller.community.notice;

import java.io.IOException;
import java.util.List;

import com.farmstory.dto.community.BoardDTO;
import com.farmstory.dto.community.PageGroupDTO;
import com.farmstory.service.community.BoardService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/community/notice/list.do")
public class ListController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private BoardService service = BoardService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pg = req.getParameter("pg");
		
		// 현재 페이지 번호 구하기
		int currentPage = service.getCurrentPage(pg); 
		
		// 전체 게시물 갯수 구하기
		int total = service.selectCountTotal();
				
		// 마지막 페이지 번호 구하기
		int lastPageNum = service.getLastPageNum(total);
				
		// 현재 페이지 그룹 구하기
		PageGroupDTO pageGroup = service.getCurrentPageGroup(currentPage, lastPageNum);
		
		// Limit용 시작 번호 구하기
		int start = service.getStartNum(currentPage);
		 
		// 페이지 시작 번호 구하기(목록에서 순서번호로 활용)
		int pageStartNum = service.getPageStartNum(total, currentPage);
		
		// 데이터 조회하기
		List<BoardDTO> boards = service.selectBoards(start);
		
		
		// 데이터 공유 참조(View에서 데이터 출력)
		req.setAttribute("boards", boards);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroup", pageGroup);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("currentPage", currentPage);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/community/notice/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
