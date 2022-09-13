package com.manager.controller;

import java.io.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import javax.servlet.ServletException;

import com.manager.model.*;

@WebServlet("/login")
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Manager_DAO manager_dao;

	public void init() {
		manager_dao = new Manager_DAO();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
        if ("login".equals(action)) { // 來自mngLogin.jsp的請求  
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String mng_account = req.getParameter("mng_account");
				String mng_accountReg = "^[(a-zA-Z0-9_)]{2,8}$";
				if (mng_account == null || mng_account.trim().length() == 0) {
					errorMsgs.add("管理員帳號: 請勿空白");
				} else if (!mng_account.trim().matches(mng_accountReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("管理員帳號: 只能是英文字母、數字和_ , 且長度必需在2到8之間");
				}
	
				String mng_password = req.getParameter("mng_password");
				String mng_passwordReg = "^[(a-zA-Z0-9_)]{2,8}$";
				if (mng_password == null || mng_password.trim().length() == 0) {
					errorMsgs.add("管理員密碼: 請勿空白");
				} else if (!mng_password.trim().matches(mng_passwordReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("管理員密碼: 只能是英文字母、數字和_ , 且長度必需在2到8之間");
				}
				
				Manager_VO manager_VO = new Manager_VO();
				manager_VO.setMng_account(mng_account);
				manager_VO.setMng_password(mng_password);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("manager_VO", manager_VO); // 含有輸入格式錯誤的manager_VO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/manager_login/login.jsp");
					failureView.forward(req, res);
					return;
				}
				if (manager_dao.mngLogin(manager_VO)) {
					//HttpSession session = request.getSession();
					// session.setAttribute("username",username);
					res.sendRedirect("back-end/manager_login/loginsuccess.jsp");
				} else {
					HttpSession session = req.getSession();
					//session.setAttribute("user", username);
					res.sendRedirect("back-end/manager_login/login.jsp");
				}
				
				/***************************2.開始新增資料***************************************/
//				Manager_Service manager_Svc = new Manager_Service();
//				manager_VO = manager_Svc.mngLogin(mng_account, mng_password);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				String url = "/manager/listAllManager.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllManager.jsp
//				successView.forward(req, res);				
		}
	}
}