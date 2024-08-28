package com.farmstory.controller.admin.product;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.admin.ProductDTO;
import com.farmstory.service.admin.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/admin/product/list.do")
public class ListController extends HttpServlet{

	private static final long serialVersionUID = 6631159828897563568L;
	private ProductService service = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 데이터 조회
		List<ProductDTO> products = service.selectProducts();
		
		
		
		
		// 업로드된 이미지 파일을 저장할 경로 지정
		String thumbs = getServletContext().getRealPath("/thumbs") + File.separator + "thumbs";
		logger.debug("thumbs1 :", thumbs);
		
		File uploadDir = new File(thumbs);
		if (!uploadDir.exists()) {
		    uploadDir.mkdirs(); // 필요한 디렉토리들을 모두 생성
		}
		
		logger.debug("thumbs2 :", thumbs);
		
		
		
		// 요청 파라미터 추출
		String prodCateNo = req.getParameter("prodCateNo");
		
		logger.debug("prodCateNo :", prodCateNo);
		
		
		
		logger.debug("products :", products);
		
		
		
		
		
		
		// 공유 참조 
		req.setAttribute("products", products);
		
		// 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/product/list.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	

	
	
	

	
	
	
}
