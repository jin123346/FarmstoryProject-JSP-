package com.farmstory.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.community.BoardDTO;
import com.farmstory.service.community.BoardService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main.do")
public class MainController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private BoardService service = BoardService.INSTANCE;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String grade = req.getParameter("grade");
		req.setAttribute("grade", grade);
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		req.setAttribute("cate", cate);
		req.setAttribute("group", group);
		
		List<BoardDTO> garden = service.selectBoardsCateMain("b202");
		req.setAttribute("garden", garden);
		logger.debug("garden : "+garden);
		
		List<BoardDTO> returnfarm = service.selectBoardsCateMain("b203");
		req.setAttribute("returnfarm", returnfarm);
		logger.debug("returnfarm : "+returnfarm);
		
		List<BoardDTO> croptalk = service.selectBoardsCateMain("b201");
		req.setAttribute("croptalk", croptalk);
		logger.debug("croptalk : "+croptalk);
		
		List<BoardDTO> notice = service.selectBoardsCateMain("b101");
		req.setAttribute("notice", notice);
		logger.debug("notice : "+notice);
		
		
		String success = req.getParameter("success");		
		req.setAttribute("success", success);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
		logger.debug(dispatcher+"");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
	}

}
