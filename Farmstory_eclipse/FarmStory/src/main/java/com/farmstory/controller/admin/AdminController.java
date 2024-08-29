package com.farmstory.controller.admin;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.admin.OrderItemDTO;
import com.farmstory.dto.admin.ProductDTO;
import com.farmstory.dto.user.UserDTO;
import com.farmstory.service.OrderService;
import com.farmstory.service.admin.ProductService;
import com.farmstory.service.user.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/index.do")
public class AdminController  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ProductService Pservice = ProductService.INSTANCE;
	private OrderService orderservice = OrderService.INSTACNE;
	private UserService Uservice = UserService.INSTANCE;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<UserDTO> userDto = Uservice.selectUsers();
		req.setAttribute("userDto", userDto);
		
		List<OrderItemDTO> orderitems = orderservice.selectOrderItems();
		req.setAttribute("orderitems", orderitems);

		
		List<ProductDTO> products  = Pservice.selectProducts();
		req.setAttribute("products", products);

		
		RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/admin/index.jsp");
		dispacher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}


}
