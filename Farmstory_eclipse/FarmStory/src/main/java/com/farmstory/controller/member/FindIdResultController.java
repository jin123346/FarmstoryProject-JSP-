package com.farmstory.controller.member;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.user.UserDTO;
import com.farmstory.service.user.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/findIdResult.do")
public class FindIdResultController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/findIdresult.jsp");
	     dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		logger.debug("uid : "+uid);
		logger.debug("pass : "+pass);
		
		
		
		int result = service.updateUserPass(uid,pass);
	
		if(result>0) {
			resp.sendRedirect("/FarmStory/member/login.do");
		}else {
			resp.sendRedirect("/FarmStory/member/findpassResult.do?uid="+uid);
		}
		
		
		
		
		
		

	}
}
