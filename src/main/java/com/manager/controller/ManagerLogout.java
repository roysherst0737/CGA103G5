package com.manager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.model.Manager_VO;

@WebServlet("/back-end/ManagerLogout")
@MultipartConfig
public class ManagerLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(111);
		request.getSession().removeAttribute("manager_VO");
//		request.getSession().removeAttribute("manager_VO0");
//		request.getSession().removeAttribute("mng1");
//		request.getSession().removeAttribute("manager_VO1");
		String url = "/back-end/index_back.html";
		response.sendRedirect("index_back.html");	
	}

}