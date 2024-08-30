package com.farmstory.controller.market;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.market.OrderDTO;
import com.farmstory.dto.product.ProductCartDTO;
import com.farmstory.dto.product.ProductDTO;
import com.farmstory.dto.user.UserDTO;
import com.farmstory.service.market.CartService;
import com.farmstory.service.product.ProductService;
import com.farmstory.service.user.UserService;
import com.google.gson.JsonObject;

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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		JsonObject json = new JsonObject();
		
		int result = 0;
			String uid = req.getParameter("uid");
			String recepit = req.getParameter("recepit");
			String recHp = req.getParameter("recHp");
			String recZip = req.getParameter("recZip");
			String recAddr1 = req.getParameter("recAddr1");
			String recAddr2 = req.getParameter("recAddr2");
			String payment = req.getParameter("payment");
			String orderDesc = req.getParameter("orderDesc");
			
			logger.debug(uid);
			logger.debug(recHp);
			logger.debug(recZip);
			logger.debug(recAddr1);
			logger.debug(recepit);
			logger.debug(payment);
			logger.debug(orderDesc);
			
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			
			OrderDTO dto = new OrderDTO();
			
			dto.setO_uid(uid);
			dto.setReceipt(recepit);
			dto.setRecHp(recHp);
			dto.setRecZip(recZip);
			dto.setRecAddr1(recAddr1);
			dto.setRecAddr2(recAddr2);
			dto.setPayment(Integer.parseInt(payment));
			dto.setOrderDate(orderDesc);
			
			result = service.insertOrder(dto);
			json.addProperty("result", result);
			
			
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		
	}
	
	
	}
	
