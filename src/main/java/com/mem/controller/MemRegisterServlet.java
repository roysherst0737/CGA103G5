package com.mem.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.Mem_Service;
import com.mem.model.Mem_VO;

@WebServlet("/MemRegisterServlet")
public class MemRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Register = request.getParameter("Register");

		if ("Mem_Register".equals(Register)) {
			

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			request.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String mem_account = request.getParameter("mem_account");
			String mem_password = request.getParameter("mem_password");
			String mem_gender = request.getParameter("gender");
			System.out.println(mem_gender);
			String mem_last_name = request.getParameter("mem_last_name");
			String mem_first_name = request.getParameter("mem_first_name");
			String mem_nickname = request.getParameter("mem_nickname");
			String mem_tel_no = request.getParameter("mem_tel_no");
			String mem_cel_no = request.getParameter("mem_cel_no");
			String mem_email = request.getParameter("mem_email");
			String mem_id = request.getParameter("mem_id");
			String mem_birth = request.getParameter("mem_birth");
			String mem_addr = request.getParameter("mem_addr");
			String mem_permission = request.getParameter("permission");
			System.out.println(mem_permission);
			if (mem_account == null || (mem_account.trim()).length() == 0) {
				errorMsgs.put("mem_account","請輸入會員帳號");
			}
			if (mem_password == null || (mem_password.trim()).length() == 0) {
				errorMsgs.put("mem_password","請輸入會員密碼");
			}
			Integer gender = null;
			if (mem_gender == null || (mem_gender.trim()).length() == 0) {
				errorMsgs.put("mem_gender","請輸入會員性別");
			}else {
				 gender = Integer.valueOf(request.getParameter("gender").trim());
			}
	
			if (mem_last_name == null || (mem_last_name.trim()).length() == 0) {
				errorMsgs.put("mem_last_name","請輸入會員姓氏");
			}
			if (mem_first_name == null || (mem_first_name.trim()).length() == 0) {
				errorMsgs.put("mem_first_name","請輸入會員名字");
			}
			if (mem_tel_no == null || (mem_tel_no.trim()).length() == 0) {
				errorMsgs.put("mem_tel_no","請輸入會員連絡電話");
			}
			if (mem_cel_no == null || (mem_cel_no.trim()).length() == 0) {
				errorMsgs.put("mem_cel_no","請輸入會員手機號碼");
			}
			if (mem_email == null || (mem_email.trim()).length() == 0) {
				errorMsgs.put("mem_email","請輸入會員電子郵件");
			}
			if (mem_id == null || (mem_id.trim()).length() == 0) {
				errorMsgs.put("mem_id","請輸入會員身分證字號");
			}
			Date birthdate = null;
			if (mem_birth == null || (mem_birth.trim()).length() == 0) {
				errorMsgs.put("mem_birth","請輸入會員生日");
			}else {
				
				birthdate = Date.valueOf(mem_birth.trim());
			}
			
			
			if (mem_addr == null || (mem_addr.trim()).length() == 0) {
				errorMsgs.put("mem_addr","請輸入會員地址");
			}
			Integer permission = null;
			if (mem_permission == null || (mem_permission.trim()).length() == 0) {
				errorMsgs.put("mem_permission","請輸入會員權限");
			}else {
				 permission = Integer.valueOf(request.getParameter("permission").trim());
			}
			

			// Send the use back to the form, if there were errors
			Mem_VO memVO = new Mem_VO();
			memVO.setMem_account(mem_account);
			memVO.setMem_password(mem_password);
			memVO.setMem_gender(gender);
			memVO.setMem_last_name(mem_last_name);
			memVO.setMem_first_name(mem_first_name);
			memVO.setMem_nickname(mem_nickname);
			memVO.setMem_tel_no(mem_tel_no);
			memVO.setMem_cel_no(mem_cel_no);
			memVO.setMem_email(mem_email);
			memVO.setMem_id(mem_id);
			memVO.setMem_birth(birthdate);
			memVO.setMem_addr(mem_addr);
			memVO.setMem_permission(permission);

			if (!errorMsgs.isEmpty()) {
				request.setAttribute("memVO", memVO); 
				
				RequestDispatcher failureView = request
						.getRequestDispatcher("/front-end/mem/register.jsp");
				failureView.forward(request, response);
				return;//程式中斷
				
			}
			/***************************2.開始查詢資料*****************************************/
			Mem_Service memSvc = new Mem_Service();
			List<Mem_VO> memVOlist = memSvc.getAll();
			for(int i = 0; i<memVOlist.size();i++) {
				if(memVOlist.get(i).getMem_account().equals(mem_account)) {
					errorMsgs.put("mem_account","會員帳號已重複");
				}
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/front-end/mem/register.jsp");
				failureView.forward(request, response);
				return;//程式中斷
			}
			/***************************3.開始新增資料***************************************/
			 memSvc.addMem( mem_account, mem_password, gender, mem_last_name,
					 mem_first_name, mem_nickname, mem_tel_no, mem_cel_no, mem_email,
					 mem_id, birthdate, mem_addr, permission);
			
			/***************************4.新增完成,準備轉交(Send the Success view)***********/
			response.sendRedirect("/CGA103G5ALL/front-end/index.jsp");	
		}
	}

}
