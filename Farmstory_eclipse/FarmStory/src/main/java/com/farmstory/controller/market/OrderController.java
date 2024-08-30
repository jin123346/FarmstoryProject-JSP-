package com.farmstory.controller.market;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.product.ProductCartDTO;
import com.farmstory.dto.product.ProductDTO;
import com.farmstory.dto.user.UserDTO;
import com.farmstory.service.market.CartService;
import com.farmstory.service.product.ProductService;
import com.farmstory.service.user.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/market/order.do")
public class OrderController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ProductService prodService = ProductService.INSTANCE;
	private UserService userService = UserService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CartService service = CartService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String pNo = req.getParameter("pNo");
		String uid = req.getParameter("uid");
		
		logger.debug("no : " +pNo);
		logger.debug("uid : "+uid);
		
		
		
		List<ProductCartDTO> prodCartDto = service.selectCarts(uid);
		
		req.setAttribute("prodCartDto", prodCartDto);
		req.setAttribute("service", service);
		
		
		ProductDTO productDto = prodService.selectProduct(pNo);
		UserDTO userDto = userService.selectUserCart(uid);
		
		req.setAttribute("userDto", userDto);
		req.setAttribute("productDto", productDto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/market/order.jsp");
		dispatcher.forward(req, resp);
	}
	
}
