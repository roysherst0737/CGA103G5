package com.mem.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mem.model.Mem_Service;
import com.mem.model.Mem_VO;

@WebServlet("/front-end/mem/MemUpdateServlet")
public class MemUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Update = request.getParameter("Update");

		if ("Mem_Update".equals(Update)) {
			

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);
			Integer mem_no = Integer.valueOf(request.getParameter("mem_no"));
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/		
			String mem_account = request.getParameter("mem_account");

			if (mem_account == null || (mem_account.trim()).length() == 0) {
				errorMsgs.add("請輸入會員帳號");
			}
			
			Integer mem_gender = null;

			try {
				mem_gender = Integer.valueOf(request.getParameter("mem_gender").trim());

			} catch (NumberFormatException e) {
				mem_gender = 0;
				if (mem_gender != 0 || mem_gender != 1 || mem_gender != 2 ) {
					errorMsgs.add("請選擇性別");
				}
				
			}
			
			String mem_last_name = request.getParameter("mem_last_name");
			if (mem_last_name == null || (mem_last_name.trim()).length() == 0) {
				errorMsgs.add("請輸入會員姓氏");
			}
			String mem_first_name = request.getParameter("mem_first_name");
			if (mem_first_name == null || (mem_first_name.trim()).length() == 0) {
				errorMsgs.add("請輸入會員名稱");
			}
			String mem_nickname = request.getParameter("mem_nickname");
			if (mem_nickname == null || (mem_nickname.trim()).length() == 0) {
				errorMsgs.add("請輸入會員暱稱");
			}
			String mem_tel_no = request.getParameter("mem_tel_no");
			if (mem_tel_no == null || (mem_tel_no.trim()).length() == 0) {
				errorMsgs.add("請輸入會員電話");
			}
			String mem_cel_no = request.getParameter("mem_cel_no");
			if (mem_cel_no == null || (mem_cel_no.trim()).length() == 0) {
				errorMsgs.add("請輸入會員手機號碼");
			}
			String mem_email = request.getParameter("mem_email");
			if (mem_email == null || (mem_email.trim()).length() == 0) {
				errorMsgs.add("請輸入會員電子信箱");
			}
			String mem_id = request.getParameter("mem_id");
			if (mem_id == null || (mem_id.trim()).length() == 0) {
				errorMsgs.add("請輸入會員身分證");
			}
			
			java.sql.Date mem_birth = null;
			try {
				mem_birth = java.sql.Date.valueOf(request.getParameter("mem_birth"));					
				
			} catch (IllegalArgumentException e) {
				mem_birth=new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			
			String mem_addr = request.getParameter("mem_addr");
			if (mem_addr == null || (mem_addr.trim()).length() == 0) {
				errorMsgs.add("請輸入會員住址");
			}
			
			Integer mem_permission = Integer.valueOf(request.getParameter("mem_permission"));
			
			Integer status = Integer.valueOf(request.getParameter("status"));
			
			Integer mem_cert_status = Integer.valueOf(request.getParameter("mem_cert_status"));

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/front-end/mem/memApplication.jsp");
				failureView.forward(request, response);
				return;//程式中斷				
			}
			/***************************2.開始更新資料*****************************************/
			Mem_Service memSvc = new Mem_Service();
			 memSvc.updateMem( mem_account, mem_gender, mem_last_name,
					 mem_first_name, mem_nickname, mem_tel_no, mem_cel_no, mem_email,
					 mem_id, mem_birth, mem_addr, mem_permission,status,mem_cert_status,mem_no);		
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			HttpSession session = request.getSession();
			session.removeAttribute("user");
	
			response.sendRedirect("memApplication.jsp");
		}
	}

}
