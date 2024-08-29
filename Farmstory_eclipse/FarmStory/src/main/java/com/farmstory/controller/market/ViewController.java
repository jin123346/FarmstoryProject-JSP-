package com.farmstory.controller.market;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.product.ProductDTO;
import com.farmstory.service.market.CartService;
import com.farmstory.service.product.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/market/view.do")
public class ViewController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String pNo = req.getParameter("pNo");
		
		ProductDTO productDto = service.selectProduct(pNo);
		
		req.setAttribute("productDto", productDto);
				
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/market/view.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	
}
