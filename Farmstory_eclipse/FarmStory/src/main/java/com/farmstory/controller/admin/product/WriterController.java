package com.farmstory.controller.admin.product;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/product/writer.do")
public class WriterController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pName =req.getParameter("prodName");
		String price =req.getParameter("price");
		String prodCateNo= req.getParameter("prodType"); 
		String stock = req.getParameter("stock");
		String point = req.getParameter("point");
		String discount = req.getParameter("discount");
		String delivery = req.getParameter("deliverfee");
		String pList_fNo = req.getParameter("product_list_image");
		String pBasic_fNo = req.getParameter("basic_info_image");
		String pDesc_fNo = req.getParameter("product_description_image");
		
		String pDesc = req.getParameter("pDesc");
		
		
		
		
		
		
		
		
		
	}

}
