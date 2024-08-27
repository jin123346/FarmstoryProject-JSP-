package com.farmstory.controller.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.service.user.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/member/checkUser.do")
public class CheckUserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		String value = req.getParameter("value");
		
		int result = service.selectCountUser(type, value);
		
		if(type.equals("email") && result == 0) {
			// 이메일 인증번호 발송하기
			String code = service.sendEmailCode(value);
			
			// 세션 저장
			HttpSession session = req.getSession();
			session.setAttribute("authCode", code);
		}
		
		// json 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		// json 출력
		
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// JSON 문자열 스트림 처리
		BufferedReader reader = req.getReader();
		StringBuilder requestBody = new StringBuilder();
		
		String line;
		while((line = reader.readLine()) != null){
			requestBody.append(line);
		}
		reader.close();
		
		// JSON parsing
		Gson gson = new Gson();
		Properties prop = gson.fromJson(requestBody.toString(), Properties.class);
		String code = prop.getProperty("code");
		logger.debug(code);
		
		// 인증코드 일치 여부 확인
		HttpSession session = req.getSession();
		String authCode = (String) session.getAttribute("authCode");
		
		JsonObject json = new JsonObject();
		
		if(authCode.equals(code)) {
			// json 생성&출력
			json.addProperty("result", 1);
		}else {
			json.addProperty("result", 0);
		}
		
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		
	}
}
