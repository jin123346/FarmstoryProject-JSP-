package com.farmstory.controller.community.notice;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.community.BoardDTO;
import com.farmstory.dto.community.BoardFileDTO;
import com.farmstory.dto.community.CommentDTO;
import com.farmstory.service.community.BoardFileService;
import com.farmstory.service.community.BoardService;
import com.farmstory.service.community.CommentService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/community/notice/view.do")
public class ViewController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private BoardService boardService = BoardService.INSTANCE;
	private CommentService commentService = CommentService.INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String boardNo = req.getParameter("boardNo");
		String pg = req.getParameter("pg");
		
		// 조회수 증가 
		boardService.update_board_hit(boardNo);
		
		// 데이터 조회
		BoardDTO boardDTO = boardService.selectBoard(boardNo);
		
		// 댓글 조회
		List<CommentDTO> comments = commentService.selectComments(Integer.parseInt(boardNo));
				
		// 공유 참조
		req.setAttribute("boardDTO", boardDTO);
		req.setAttribute("pg",pg );
		req.setAttribute("comments", comments);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/community/notice/view.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

	}
	
}
