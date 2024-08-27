package com.farmstory.controller.community.notice;

import java.io.IOException;

import com.farmstory.dto.community.BoardFileDTO;
import com.farmstory.service.community.BoardFileService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/community/notice/BoardFileDownload.do")
public class BoardFileDownloadController extends HttpServlet {

	private static final long serialVersionUID = -7413301626613453350L;
	private BoardFileService service = BoardFileService.INSTANCE;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String b_fNo = req.getParameter("b_fNo");
	
		// 파일 조회
		BoardFileDTO boardFileDTO = service.selectBoardFile(b_fNo);
		
		// 공유 참조(service -> fileDownload 메서드에서 getAttribute로 가져감)
		req.setAttribute("boardFileDTO", boardFileDTO);
		
		// 파일 다운로드 카운트 업데이트
		service.updateBoardFileDownloadCount(b_fNo);
		
		// 파일 다운로드
		service.boardFileDownload(req, resp);
		
		
	
	}
	
	
	
	
	
}
