package com.farmstory.controller.member;

import java.io.IOException;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.service.user.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/findPass.do")
public class FindPassController extends HttpServlet{

	private static final long serialVersionUID = 7337016982052304037L;
	UserService service = UserService.INSTANCE;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/findPass.jsp");
	     dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid= req.getParameter("uid");
		logger.debug("uid : "+uid);
		req.setAttribute("uid", uid);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/findPassResult.jsp");
	     dispatcher.forward(req, resp);
	
	}
	
	
	
}
