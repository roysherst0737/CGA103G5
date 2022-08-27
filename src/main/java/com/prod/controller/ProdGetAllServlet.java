package com.prod.controller;

import static com.prod.service.ProdConstants.SERVICE;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prod.model.Prod;

@WebServlet("/prod/getlist")
public class ProdGetAllServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Prod> prodList = SERVICE.getAll();
		request.setAttribute("prodList", prodList);
		request.getRequestDispatcher("/back-end/pages/prod/prod_list.jsp").forward(request, response);
	}
}