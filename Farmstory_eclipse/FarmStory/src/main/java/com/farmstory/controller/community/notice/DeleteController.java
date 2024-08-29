package com.farmstory.controller.community.notice;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.community.BoardDTO;
import com.farmstory.dto.community.BoardFileDTO;
import com.farmstory.service.community.BoardFileService;
import com.farmstory.service.community.BoardService;
import com.farmstory.service.community.CommentService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/community/notice/delete.do")
public class DeleteController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private BoardService boardService = BoardService.INSTANCE;
	private BoardFileService fileService = BoardFileService.INSTANCE;
	private CommentService commentService = CommentService.INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String boardNo = req.getParameter("boardNo");
		
		// 데이터 조회
		BoardDTO boardDTO = boardService.selectBoard(boardNo);
		
		// 공유 참조
		req.setAttribute("boardDTO", boardDTO);
		
		// 파일 삭제
		fileService.deleteBoardFiles(boardNo);
		
		// 댓글 삭제
		commentService.deleteComments(boardNo);
		
		// 게시물 삭제 
		boardService.deleteBoard(boardNo);
		
		
		resp.sendRedirect("/FarmStory/community/notice/list.do");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
	}
	
}
