package com.farmstory.controller.market;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.market.CartDTO;
import com.farmstory.dto.product.ProductDTO;
import com.farmstory.service.market.CartService;
import com.farmstory.service.product.ProductService;
import com.google.gson.JsonObject;

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
	private CartService cartService = CartService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String pNo = req.getParameter("pNo");
		
		ProductDTO productDto = service.selectProduct(pNo);
		
		req.setAttribute("productDto", productDto);
				
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/market/view.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CartDTO dto = new CartDTO();
		
		int result = 0;
		
		String uid = req.getParameter("uid");
		String prodNo = req.getParameter("prodNo");
		String cartProdQty = req.getParameter("cartProdQty");

		int prodNo1 = Integer.parseInt(prodNo);
		int cartProdQty1 = Integer.parseInt(cartProdQty);
		
		logger.debug(cartProdQty);
		logger.debug(prodNo);
		
		dto.setC_uid(uid);
		dto.setProdNo(Integer.parseInt(prodNo));
		dto.setCartProdQty(Integer.parseInt(cartProdQty));
		
		result = cartService.insertCart(dto);
			
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		
	}
	
}
