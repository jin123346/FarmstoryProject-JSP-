package com.farmstory.controller.admin.user;

import java.io.IOException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dao.user.UserDao;
import com.farmstory.dto.community.BoardDTO;
import com.farmstory.dto.community.PageGroupDTO;
import com.farmstory.dto.user.UserDTO;
import com.farmstory.service.admin.AdminUserService;
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
	private AdminUserService service = AdminUserService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<UserDTO> userDto = service.selectUsers();

		req.setAttribute("userDto", userDto);


		String pg = req.getParameter("pg");


		// 현재 페이지 번호 구하기
		int currentPage = service.getCurrentPage(pg);

		// 전체 게시물 갯수 구하기
		int total = service.selectCountTotal();

		// 마지막 페이지 번호 구하기
		int lastPageNum = service.getLastPageNum(total);

		// 현재 페이지 그룹 구하기
		PageGroupDTO pageGroup = service.getCurrentPageGroup(currentPage, lastPageNum);

		// Limit용 시작 번호 구하기
		int start = service.getStartNum(currentPage);

		// 페이지 시작 번호 구하기(목록에서 순서번호로 활용)
		int pageStartNum = service.getPageStartNum5(total, currentPage);

		// 데이터 조회하기
		List<UserDTO> users = service.selectUsers(start);

		req.setAttribute("users", users);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pagegroup", pageGroup);
	
	

		RequestDispatcher  dispatcher = req.getRequestDispatcher("/WEB-INF/admin/user/list.jsp");
		dispatcher.forward(req, resp);
	}


}





