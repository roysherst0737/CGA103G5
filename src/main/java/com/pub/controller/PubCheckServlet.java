package com.pub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.pub.service.PubConstants.SERVICE;
import static com.util.Constants.PREFIX_WEB_INF;
import com.pub.model.Pub;
@WebServlet("/pub/pub_check")
public class PubCheckServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Integer integer = request.getAttribute("check")!=null? Integer.parseInt((String) request.getAttribute("check")):0;
		List<Pub> pubList = SERVICE.getAll();
		request.setAttribute("pubList", pubList);
		request.getRequestDispatcher("/back-end/pages/pub/Pub_Check_List.jsp").forward(request, response);
	}

}
