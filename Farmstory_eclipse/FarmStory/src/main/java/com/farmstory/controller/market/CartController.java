package com.farmstory.controller.market;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.market.CartDTO;
import com.farmstory.dto.product.ProductCartDTO;
import com.farmstory.service.market.CartService;
import com.google.gson.JsonObject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/market/cart.do")
public class CartController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CartService service = CartService.INSTANCE;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		
		
		
		List<ProductCartDTO> prodCartDto = service.selectCarts(uid);
		
		req.setAttribute("prodCartDto", prodCartDto);
		req.setAttribute("service", service);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/market/cart.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		JsonObject json = new JsonObject();
		int result = 0;
		if("insert".equals(action)) {
			String uid = req.getParameter("uid");
			String prodNo = req.getParameter("prodNo");
			String qty = req.getParameter("qty");
			
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			
			CartDTO dto = new CartDTO();
			
			
			
			logger.debug(uid);
			logger.debug(qty);
			logger.debug(prodNo);
			
			
			dto.setC_uid(uid);
			dto.setProdNo(Integer.parseInt(prodNo));
			dto.setCartProdQty(Integer.parseInt(qty));
			
			result = service.insertCart(dto);
			json.addProperty("result", result);
		} else if("delete".equals(action)) {
			// 여 기 에 delete 작 업 
			String[] pk = req.getParameterValues("pk"); // 이 런 식 으 로 꺼 내 면 배 열 로 나 옴 
			
				result = service.deleteCart(pk);
		}
			
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		
	}

}
