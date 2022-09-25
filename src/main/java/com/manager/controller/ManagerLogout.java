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
		
		request.getSession().removeAttribute("managerVO");
		request.getSession().removeAttribute("manager_VO");
		request.getSession().removeAttribute("mng");
		request.getSession().removeAttribute("manager_VO");
		String url = "/back-end/index_back.html";
		RequestDispatcher successView = request.getRequestDispatcher(url);
		successView.forward(request, response);
	}

}