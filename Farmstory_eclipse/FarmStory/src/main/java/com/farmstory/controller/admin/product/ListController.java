package com.farmstory.controller.admin.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.admin.FileListDTO;
import com.farmstory.dto.admin.ProductDTO;
import com.farmstory.dto.community.BoardDTO;
import com.farmstory.dto.community.PageGroupDTO;
import com.farmstory.dto.market.CartDTO;
import com.farmstory.service.Pagegroupservice;
import com.farmstory.service.admin.FileService;
import com.farmstory.service.admin.ProductService;
import com.google.gson.JsonObject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/admin/product/list.do")
public class ListController extends HttpServlet{

	private static final long serialVersionUID = 6631159828897563568L;
	private ProductService service = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private Pagegroupservice pservice = Pagegroupservice.INSTANCE;
	private FileService fservice= FileService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pg = req.getParameter("pg");
		
		// 현재 페이지 번호 구하기
		int currentPage = pservice.getCurrentPage(pg); 
		
		// 전체 게시물 갯수 구하기
		int total = service.selectCountTotal();
		logger.debug("total"+total);		
		// 마지막 페이지 번호 구하기
		int lastPageNum = pservice.getLastPageNum5(total);
		logger.debug("lastPageNum " +lastPageNum);
				
		// 현재 페이지 그룹 구하기
		PageGroupDTO pageGroup = pservice.getCurrentPageGroup5(currentPage, lastPageNum);
		
		// Limit용 시작 번호 구하기
		int start = pservice.getStartNum5(currentPage);
		 
		// 페이지 시작 번호 구하기(목록에서 순서번호로 활용)
		int pageStartNum = pservice.getPageStartNum5(total, currentPage);
		logger.debug("pageStartNum " +pageStartNum);
		// 데이터 조회하기
		List<ProductDTO> products  = service.selectProducts(start);
		logger.debug("products " +products);
		
	
		
		
		
		// 데이터 공유 참조(View에서 데이터 출력)
		req.setAttribute("products", products);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroup", pageGroup);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("currentPage", currentPage);
		
		
		
		
		
		// 데이터 조회
	


		// 요청 파라미터 추출
		//String prodCateNo = req.getParameter("prodCateNo");
		
		
	
		
		
		
		
		// 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/product/list.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		JsonObject json = new JsonObject();
		int result = 0;
		logger.debug("action : "+action);
		
		if("delete".equals(action)) {
			// 여 기 에 delete 작 업 
			String[] pk = req.getParameterValues("pk"); // 이 런 식 으 로 꺼 내 면 배 열 로 나 옴 
			
			for(String pk1 : pk) {

				result = service.deleteProduct(pk1);
				json.addProperty("result", result);
			}
		}
			
		PrintWriter writer = resp.getWriter();
		writer.print(json);
	
	}

	
	
	

	
	
	
}
