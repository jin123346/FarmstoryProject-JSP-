package com.farmstory.controller.market;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.community.PageGroupDTO;
import com.farmstory.dto.product.ProductDTO;
import com.farmstory.service.product.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/market/list.do")
public class ListController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private ProductService service = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pg = req.getParameter("pg");
		String cateName = req.getParameter("cateName");
		
		
		
		// 데이터 조회
		
		if(cateName == null){
			int currentPage = service.getCurrentPage(pg);
			
			if(currentPage < 1) {
				currentPage += 1;
			}
			logger.debug("current : " + currentPage);
			
			// 현제 페이지 그룹 구하기
			PageGroupDTO pageGroupP = service.getCurrentPageGroup(currentPage);
			
			// 전체 게시물 갯수 구하기
			int total = service.selectCountTotal();
			
			// 마지막 페이지 번호 구하기
			int lastPageNum = service.getLastPageNum(total);
			
			// 페이지 시작 번호 구하기
			int start = service.getStartNum(currentPage);
			
			logger.debug("start : "+start+"");

			if(lastPageNum <= 5 || pageGroupP.getEnd() > lastPageNum) {
				pageGroupP.setEnd(lastPageNum);
			}

			List<ProductDTO> productDto = service.selectProducts(start);
			req.setAttribute("productDto", productDto);
			req.setAttribute("lastPageNum", lastPageNum);
			req.setAttribute("pageGroupP", pageGroupP);
		}else if(cateName.equals("과일")){
			
			int currentPage = service.getCurrentPage(pg);
			logger.debug("current : " + currentPage);
			
			// 현제 페이지 그룹 구하기
			PageGroupDTO pageGroupP = service.getCurrentPageGroup(currentPage);
			
			// 전체 게시물 갯수 구하기
			int total = service.selectCountTotalA(cateName);
			
			// 마지막 페이지 번호 구하기
			int lastPageNum = service.getLastPageNum(total);
			
			// 페이지 시작 번호 구하기
			int start = service.getStartNum(currentPage);
			
			logger.debug("start : "+start+"");

			if(lastPageNum <= 5 || pageGroupP.getEnd() > lastPageNum) {
				pageGroupP.setEnd(lastPageNum);
			}
			
			List<ProductDTO> productDto = service.selectProductsA(start, cateName);
			req.setAttribute("productDto", productDto);
			req.setAttribute("lastPageNum", lastPageNum);
			req.setAttribute("pageGroupP", pageGroupP);
		}else if(cateName.equals("야채")){
			
			int currentPage = service.getCurrentPage(pg);
			logger.debug("current : " + currentPage);
			
			// 현제 페이지 그룹 구하기
			PageGroupDTO pageGroupP = service.getCurrentPageGroup(currentPage);
			
			// 전체 게시물 갯수 구하기
			int total = service.selectCountTotalA(cateName);
			
			// 마지막 페이지 번호 구하기
			int lastPageNum = service.getLastPageNum(total);
			
			// 페이지 시작 번호 구하기
			int start = service.getStartNum(currentPage);
			
			logger.debug("start : "+start+"");

			if(lastPageNum <= 5 || pageGroupP.getEnd() > lastPageNum) {
				pageGroupP.setEnd(lastPageNum);
			}
			
			List<ProductDTO> productDto = service.selectProductsA(start, cateName);
			req.setAttribute("productDto", productDto);
			req.setAttribute("lastPageNum", lastPageNum);
			req.setAttribute("pageGroupP", pageGroupP);
		}else if(cateName.equals("곡류")){
			
			int currentPage = service.getCurrentPage(pg);
			logger.debug("current : " + currentPage);
			
			// 현제 페이지 그룹 구하기
			PageGroupDTO pageGroupP = service.getCurrentPageGroup(currentPage);
			
			// 전체 게시물 갯수 구하기
			int total = service.selectCountTotalA(cateName);
			
			// 마지막 페이지 번호 구하기
			int lastPageNum = service.getLastPageNum(total);
			
			// 페이지 시작 번호 구하기
			int start = service.getStartNum(currentPage);
			
			logger.debug("start : "+start+"");

			if(lastPageNum <= 5 || pageGroupP.getEnd() > lastPageNum) {
				pageGroupP.setEnd(lastPageNum);
			}
			
			List<ProductDTO> productDto = service.selectProductsA(start, cateName);
			req.setAttribute("productDto", productDto);
			req.setAttribute("lastPageNum", lastPageNum);
			req.setAttribute("pageGroupP", pageGroupP);
		}
		
		// 공유 참조
		
		
		req.setAttribute("service", service);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/market/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}
