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
		logger.debug(dispatcher.toString());
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pName =req.getParameter("prodName");
		String price =req.getParameter("price");
		String prodCateNo= req.getParameter("prodType"); 
		
		String stock = req.getParameter("stock");
		String discount = req.getParameter("discount");
		String delivery = req.getParameter("deliverfee");
		String pDesc = req.getParameter("pDesc");
		logger.debug(pName);
		logger.debug("pname "+pName+"price"+price+"stock"+stock+"prodCateNo"+prodCateNo+"delivery"+delivery);
		int pList_fNo=0;
		int pDesc_fNo=0;
		int pBasic_fNo=0;
		
		List<FileDTO> files = fileservice.fileUpload(req);
		logger.debug(files.toString());
		
		
		
		int point = (int) Math.ceil(Double.parseDouble(price)*0.01);
		ProductDTO product = new ProductDTO();
		product.setpName(pName);
		product.setPrice(price);
		product.setProdCateNo(prodCateNo);
		product.setPoint(point);
		product.setStock(stock);
		product.setDiscount(discount);
		product.setDelivery(delivery);
		product.setpDesc(pDesc);
		product.setpList_fNo(pList_fNo);
		product.setpBasic_fNo(pBasic_fNo);
		product.setpDesc_fNo(pDesc_fNo);
		
		int pno = productservice.insertProduct(product);
		
		logger.debug("pno ; "+pno+"");
		
		for(FileDTO filedto : files) {
			
			filedto.setpNo(pno);
			fileservice.insertFile(filedto);
			logger.debug(filedto.toString());
			
		
		}
		pList_fNo = fileservice.selectListFile_fNo(pno);
		pDesc_fNo = fileservice.selectDescFile_fNo(pno);
		pBasic_fNo=fileservice.selectBasicFile_fNo(pno);
		logger.debug("pList_fNo : "+pList_fNo);
		logger.debug("pDesc_fNo : "+pDesc_fNo);
		logger.debug("pDesc_fNo : "+pDesc_fNo);

		
		
		
		productservice.updateProductFno(pList_fNo,pDesc_fNo,pBasic_fNo,pno);
		
		
		resp.sendRedirect("/FarmStory/admin/product/list.do");
		
	
	}
	

}
