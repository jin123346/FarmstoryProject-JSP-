package com.farmstory.controller.admin.product;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.admin.FileDTO;
import com.farmstory.dto.admin.ProductDTO;
import com.farmstory.service.admin.FileService;
import com.farmstory.service.admin.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/product/register.do")
public class RegisterController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	FileService fileservice = FileService.INSTANCE;
	ProductService productservice = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/product/register.jsp");
		dispatcher.forward(req, resp);
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
		String pDesc = req.getParameter("pDesc");
		
		
		/*
		 * String pList_fNo = req.getParameter("product_list_image"); String pBasic_fNo
		 * = req.getParameter("basic_info_image"); String pDesc_fNo =
		 * req.getParameter("product_description_image");
		 */
		
		List<FileDTO> files = fileservice.fileUpload(req);
		int pList_fNo=0;
		int pDesc_fNo=0;
		int pBasic_fNo=0;
		for(FileDTO filedto : files) {
			if(filedto.getFieldName().equals("product_list_image")) {
				pList_fNo=filedto.getFno();
				
			}else if(filedto.getFieldName().equals("product_description_image")) {
				pDesc_fNo=filedto.getFno();
				
			}else if(filedto.getFieldName().equals("basic_info_image")) {
				pBasic_fNo=filedto.getFno();
	
			}
		}
		ProductDTO product = new ProductDTO();
		product.setpName(pName);
		product.setPrice(price);
		product.setProdCateNo(prodCateNo);
		product.setStock(stock);
		product.setPoint(point);
		product.setDiscount(discount);
		product.setDelivery(delivery);
		product.setpDesc(pDesc);
		product.setpList_fNo(pList_fNo);
		product.setpBasic_fNo(pBasic_fNo);
		product.setpDesc_fNo(pDesc_fNo);
		
		int pno = productservice.insertProduct(product);
		
		for(FileDTO filedto : files) {
			
			filedto.setpNo(pno);
			fileservice.insertFile(filedto);
		
		}
		
		
		
		resp.sendRedirect("/FarmStory/admin/product/list.do");
		
	
	}
	

}
