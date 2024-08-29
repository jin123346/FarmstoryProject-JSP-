package com.farmstory.controller.comment;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.community.CommentDTO;
import com.farmstory.service.community.CommentService;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/comment/write.do")
public class WriteController extends HttpServlet{

	private static final long serialVersionUID = 2121393994491204720L;
	private CommentService service = CommentService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 폼 데이터 수신
		String com_parent = req.getParameter("com_parent");
		String comment = req.getParameter("comment");
		String com_writer = req.getParameter("com_writer");
		String com_regip = req.getRemoteAddr();
		
		// DTO 생성
		CommentDTO dto = new CommentDTO();
		dto.setCom_parent(com_parent);
		dto.setCom_content(comment);
		dto.setCom_writer(com_writer);
		dto.setCom_regip(com_regip);
		logger.debug(dto.toString());
		
		// 댓글 등록
		int pk = service.insertComment(dto);
		
		// 방금 등록한 댓글 조회
		CommentDTO commentDTO = service.selectComment(pk);
		logger.debug(commentDTO.toString());
		
		// JSON 생성 및 출력
		Gson gson = new Gson();
		String json = gson.toJson(commentDTO);
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(json);
		
		
	}
	
	
	
	
}
