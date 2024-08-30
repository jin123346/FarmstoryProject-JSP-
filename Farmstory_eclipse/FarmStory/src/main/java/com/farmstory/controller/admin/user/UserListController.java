package com.farmstory.controller.admin.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dao.user.UserDao;
import com.farmstory.dto.admin.OrderItemDTO;
import com.farmstory.dto.community.PageGroupDTO;
import com.farmstory.dto.market.CartDTO;
import com.farmstory.dto.user.UserDTO;
import com.farmstory.service.Pagegroupservice;
import com.farmstory.service.user.UserService;
import com.google.gson.JsonObject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/user/list.do")
public class UserListController extends HttpServlet{

	private static final long serialVersionUID = 2416957066166705819L;
	private Pagegroupservice pageservice = Pagegroupservice.INSTANCE;
	private UserService service = UserService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<UserDTO> userDto = service.selectUsers();

		req.setAttribute("userDto", userDto);


		String pg = req.getParameter("pg");

		// 현재 페이지 번호 구하기
		int currentPage = service.getCurrentPage(pg);
		logger.debug("currentPage : " + currentPage);

		// 전체 게시물 갯수 구하기
		int total = service.selectUserCountTotal();
		logger.debug("total : " + total);

		// 마지막 페이지 번호 구하기
		int lastPageNum = service.getLastPageNum(total);
		logger.debug("lastPageNum : " + lastPageNum);

		// 현재 페이지 그룹 구하기
		PageGroupDTO pageGroup = service.getCurrentPageGroup(currentPage, lastPageNum);
		logger.debug("pageGroup : " + pageGroup);


		// Limit용 시작 번호 구하기
		int start = service.getStartNum(currentPage);
		logger.debug("start : " + start);


		// 페이지 시작 번호 구하기(목록에서 순서번호로 활용)
		int pageStartNum = service.getPageStartNum(total, currentPage);
		logger.debug("pageStartNum : " + pageStartNum);


		// 데이터 조회하기
		List<UserDTO> users = service.selectUsers(start);

		req.setAttribute("users", users);
		logger.debug("users : " + users);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroup", pageGroup);
		req.setAttribute("pageStartNum", pageStartNum);



		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/user/list.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



	}



}


