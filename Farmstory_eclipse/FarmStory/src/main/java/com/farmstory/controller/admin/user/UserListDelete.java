package com.farmstory.controller.admin.user;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.service.user.UserService;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserListDelete {
	
	@WebServlet("/user/delete.do")
	public class DeleteController extends HttpServlet{private static final long serialVersionUID = 1L;

		Logger logger = LoggerFactory.getLogger(this.getClass());
		UserService service = UserService.INSTANCE;
		@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			
			String no = req.getParameter("no");
			
			String user = service.deleteUser();
			
			
			
			
			JsonObject json = new JsonObject();
			json.addProperty("result", result);
			
			PrintWriter printwriter = resp.getWriter();
			printwriter.print(json);
			
			
			
			
			
		}
	
	}
}
