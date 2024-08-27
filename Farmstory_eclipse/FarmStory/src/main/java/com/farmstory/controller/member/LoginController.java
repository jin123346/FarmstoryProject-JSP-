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
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	UserService service = UserService.INSTANCE;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String success=req.getParameter("success");
		req.setAttribute("success", success);
		
		
		RequestDispatcher dispatch = req.getRequestDispatcher("/WEB-INF/user/login.jsp");
		dispatch.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid"); 
		String pass = req.getParameter("pass");
		
		logger.debug("uid : "+uid);
		logger.debug("pass : "+pass);
		
		UserDTO user  =service.selectUser(uid, pass);
		logger.debug("user : "+user);
		
		if(user !=null) {
			//회원이 맞을 경우 -> 세션처리 후 
			HttpSession session = req.getSession();
			session.setAttribute("sessUser", user);
			if(user.getGradeNo().equals("00")) {
				resp.sendRedirect("/FarmStory/main.do?grade=admin");
			}else {
				resp.sendRedirect("/FarmStory/main.do?grade=none");
			}
	
		}else {
			
			//회원이 아닐경우
			resp.sendRedirect("/FarmStory/member/login.do?success=100");
		}
		
		
		
	}
	
	
	
	
}
