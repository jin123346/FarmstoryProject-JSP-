package com.farmstory.controller.market;

import java.io.IOException;

import com.farmstory.dto.product.ProductDTO;
import com.farmstory.service.product.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/market/order.do")
public class OrderController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String pNo = req.getParameter("pNo");
		
		ProductDTO productDto = service.selectProduct(pNo);
		
		req.setAttribute("productDto", productDto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/market/order.jsp");
		dispatcher.forward(req, resp);
	}
	
}
