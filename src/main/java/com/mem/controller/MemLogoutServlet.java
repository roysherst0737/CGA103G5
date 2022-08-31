package com.mem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemLogoutServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String Logout = request.getParameter("Logout");
		HttpSession session = request.getSession();

		if ("Mem_Logout".equals(Logout)) {
			session.removeAttribute("user");
			String url = "/front-end/index.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(request, response);
		}
	}
}