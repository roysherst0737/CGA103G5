package com.mem.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemRegisterServlest")
public class MemRegisterServlest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Register = request.getParameter("Register");
		System.out.println(123);
		if ("Mem_Register".equals(Register)) {
			System.out.println(456);
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			request.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String mem_account = request.getParameter("mem_account");
			String mem_password = request.getParameter("mem_password");
			String mem_gender = request.getParameter("mem_gender");
			String mem_last_name = request.getParameter("mem_last_name");
			String mem_first_name = request.getParameter("mem_first_name");
			String mem_tel_no = request.getParameter("mem_tel_no");
			String mem_cel_no = request.getParameter("mem_cel_no");
			String mem_email = request.getParameter("mem_email");
			String mem_id = request.getParameter("mem_id");
			String mem_birth = request.getParameter("mem_birth");
			String mem_addr = request.getParameter("mem_addr");
			String mem_permission = request.getParameter("mem_permission");
			if (mem_account == null || (mem_account.trim()).length() == 0) {
				errorMsgs.put("mem_account","請輸入會員帳號");
			}
			if (mem_password == null || (mem_password.trim()).length() == 0) {
				errorMsgs.put("mem_password","請輸入會員密碼");
			}
			if (mem_gender == null || (mem_gender.trim()).length() == 0) {
				errorMsgs.put("mem_gender","請輸入會員帳號");
			}
			if (mem_last_name == null || (mem_last_name.trim()).length() == 0) {
				errorMsgs.put("mem_last_name","請輸入會員密碼");
			}
			if (mem_first_name == null || (mem_first_name.trim()).length() == 0) {
				errorMsgs.put("mem_first_name","請輸入會員帳號");
			}
			if (mem_tel_no == null || (mem_tel_no.trim()).length() == 0) {
				errorMsgs.put("mem_tel_no","請輸入會員密碼");
			}
			if (mem_cel_no == null || (mem_cel_no.trim()).length() == 0) {
				errorMsgs.put("mem_cel_no","請輸入會員帳號");
			}
			if (mem_email == null || (mem_email.trim()).length() == 0) {
				errorMsgs.put("mem_email","請輸入會員密碼");
			}
			if (mem_id == null || (mem_id.trim()).length() == 0) {
				errorMsgs.put("mem_id","請輸入會員帳號");
			}
			if (mem_birth == null || (mem_birth.trim()).length() == 0) {
				errorMsgs.put("mem_birth","請輸入會員密碼");
			}
			if (mem_addr == null || (mem_addr.trim()).length() == 0) {
				errorMsgs.put("mem_addr","請輸入會員帳號");
			}
			if (mem_permission == null || (mem_permission.trim()).length() == 0) {
				errorMsgs.put("mem_permission","請輸入會員密碼");
			}

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/front-template/sign-up.jsp");
				failureView.forward(request, response);
				return;//程式中斷
				
			}
		}
	}

}
