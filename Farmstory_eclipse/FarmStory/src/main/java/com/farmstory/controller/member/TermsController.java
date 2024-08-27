package com.farmstory.controller.member;

import java.io.IOException;

import com.farmstory.dto.user.TermsDTO;
import com.farmstory.service.user.TermsService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/terms.do")
public class TermsController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private TermsService service = TermsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TermsDTO termsDto = service.selectTerms();
		
		req.setAttribute("termsDto", termsDto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/terms.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}
