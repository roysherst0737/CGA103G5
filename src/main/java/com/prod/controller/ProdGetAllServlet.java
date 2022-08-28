package com.prod.controller;

import static com.prod.service.Prod_Constants.SERVICE;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prod.model.Prod;

@WebServlet("/prod/GetAll")
public class ProdGetAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Prod> prodList = SERVICE.getAll();
		req.setAttribute("prodList", prodList);
		req.getRequestDispatcher("/back-end/prod/listAllProd.jsp").forward(req, res);
	}

}
