package com.farmstory.controller.admin.order;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dao.admin.OrderDAO;
import com.farmstory.dto.admin.OrderItemDTO;
import com.farmstory.dto.community.BoardDTO;
import com.farmstory.dto.community.PageGroupDTO;
import com.farmstory.service.OrderService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/order/list.do")
public class ListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	OrderService orderservice = OrderService.INSTACNE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pg = req.getParameter("pg");
		
		// 현재 페이지 번호 구하기
		int currentPage = orderservice.getCurrentPage(pg); 
		
		// 전체 게시물 갯수 구하기
		int total = orderservice.selectOrderItemCountTotal();
				
		// 마지막 페이지 번호 구하기
		int lastPageNum = orderservice.getLastPageNum(total);
				
		// 현재 페이지 그룹 구하기
		PageGroupDTO pageGroup = orderservice.getCurrentPageGroup(currentPage, lastPageNum);
		
		// Limit용 시작 번호 구하기
		int start = orderservice.getStartNum(currentPage);
		
		// 페이지 시작 번호 구하기(목록에서 순서번호로 활용)
		int pageStartNum = orderservice.getPageStartNum(total, currentPage);
		
		// 데이터 조회하기
		List<OrderItemDTO> orderitems = orderservice.selectOrderItems(currentPage);
		logger.debug("orderitems : "+orderitems.toString());
		
		// 데이터 공유 참조(View에서 데이터 출력)
		req.setAttribute("orderitems", orderitems);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroup", pageGroup);
		req.setAttribute("pageStartNum", pageStartNum);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/order/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	
	

}
