package com.manager.controller;

import static com.util.CommonUtil.writePojo2Json;

import java.io.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

import com.manager.model.Manager_VO;
@WebServlet(urlPatterns = {"*.ManagerImage3","/ManagerImage3","/back-end/ManagerImage3"})
public class ManagerImage3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {


			HttpSession session = req.getSession();
			Manager_VO mng_vo = (Manager_VO) session.getAttribute("manager_VO");
			writePojo2Json(res, mng_vo);
}}