package com.pub.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pub.entity.Pub;

import static com.pub.service.PubConstants.SERVICE;
@WebServlet("/PubMap")
public class PubGetAllServlet_Front extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pub> pubList = SERVICE.getAll();
		pubList.removeIf(e->e.getPub_status()==false);
		Set<String> pubAddress = new HashSet<String>() ;
		pubList.forEach(e->{pubAddress.add(e.getPub_address().substring(0, 3));});
		request.setAttribute("pubList", pubList);
		request.setAttribute("pubAddress", pubAddress);
		request.getRequestDispatcher("/front-end/pages/pub/pub_map.jsp").forward(request, response);
	}

}
