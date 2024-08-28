package com.farmstory.controller.admin.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.admin.ProductDTO;
import com.farmstory.service.admin.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/product/list.do")
public class ListController extends HttpServlet{

	private static final long serialVersionUID = 6631159828897563568L;
	private ProductService service = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청 파라미터 추출
		String prodCateNo = req.getParameter("prodCateNo");
		
		
		// 페이지 그룹 계산
		
		
		// 데이터 조회
		List<ProductDTO> products = null;
		try {
			products = service.selectProducts(prodCateNo);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 공유 참조 
		req.setAttribute("products", products);
		
		// 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/product/list.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	

	
	
	

	
	
	
}
