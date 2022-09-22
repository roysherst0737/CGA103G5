package com.mem.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mem.model.Mem_Service;
import com.mem.model.Mem_VO;

public class MemLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Login = request.getParameter("Login");
		HttpSession session = request.getSession();
		if ("Mem_Login".equals(Login)) { // 來自select_page.jsp的請求

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			request.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String mem_account = request.getParameter("mem_account");
				String mem_password = request.getParameter("mem_password");
				if (mem_account == null || (mem_account.trim()).length() == 0) {
					errorMsgs.put("mem_account","請輸入會員帳號");
				}
				if (mem_password == null || (mem_password.trim()).length() == 0) {
					errorMsgs.put("mem_password","請輸入會員密碼");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request
							.getRequestDispatcher("/front-end/mem/login.jsp");
					failureView.forward(request, response);
					return;//程式中斷
				}
				
				
				/***************************2.開始查詢資料*****************************************/
				Mem_Service memSvc = new Mem_Service();
				Mem_VO user = memSvc.loginMem(mem_account, mem_password);
				if (user == null ) {
					errorMsgs.put("mem_no","查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request
							.getRequestDispatcher("/front-end/mem/login.jsp");
					failureView.forward(request, response);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				session.setAttribute("user",user );

				String previous_page = (String) session.getAttribute("previous_page");

				response.sendRedirect(previous_page);

		}
	}
}
