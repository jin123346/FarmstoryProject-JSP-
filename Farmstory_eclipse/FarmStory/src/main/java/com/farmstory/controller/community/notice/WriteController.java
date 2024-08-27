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

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/community/notice/write.do")
public class WriteController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private BoardService boardService = BoardService.INSTANCE;
	private BoardFileService boardFileService = BoardFileService.INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/community/notice/write.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		String title = req.getParameter("title");
		String b_contents = req.getParameter("b_contents");
		String b_writer = req.getParameter("b_writer"); // session 값 hidden
		String b_regip = req.getRemoteAddr();
		
		// 파일 업로드
		List<BoardFileDTO> boardFiles = boardFileService.boardFileUpload(req);
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setB_contents(b_contents);
		dto.setB_fNo(boardFiles.size());
		dto.setB_writer(b_writer);
		dto.setB_regip(b_regip);
		
		logger.debug("dto : " + dto);
		
		// 글 등록(글 등록 후, 등록된 글번호를 저장)
		int no = boardService.insertBoard(dto);
		
		for(BoardFileDTO boardFileDTO : boardFiles) {
			boardFileDTO.setB_pNo(no);
			boardFileService.insertBoardFile(boardFileDTO);
		}
		
		
		resp.sendRedirect("/FarmStory/community/notice/list.do");

	}
	
}
