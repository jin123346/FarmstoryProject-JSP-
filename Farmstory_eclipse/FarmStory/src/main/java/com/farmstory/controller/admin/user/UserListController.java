package com.farmstory.controller.admin.user;

import java.io.IOException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dao.user.UserDao;
import com.farmstory.dto.user.UserDTO;
import com.farmstory.service.user.UserService;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/user/list.do")
public class UserListController extends HttpServlet{

	private static final long serialVersionUID = 2416957066166705819L;
	private UserService service = UserService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		List<UserDTO> userDto = service.selectUsers();
		
		req.setAttribute("userDto", userDto);
		
		// 데이터 수신
		String uid = req.getParameter("uid");
		
		// 데이터 삭제 
		service.deleteUser(uid);
		
		
		RequestDispatcher  dispatcher = req.getRequestDispatcher("/WEB-INF/admin/user/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	}





