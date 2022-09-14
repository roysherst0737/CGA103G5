package com.manager.controller;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

import com.manager.model.*;

@MultipartConfig
@WebServlet("/register")
public class ManagerRegister extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		 if ("register".equals(action)) { // 來自addManager.jsp的請求  
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
				
				
					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
					String mng_account = req.getParameter("mng_account");
					String mng_accountReg = "^[(a-zA-Z0-9_)]{2,8}$";
					List<Manager_VO> list = new Manager_Service().getAllManager();
					for(Manager_VO vo : list) {
						if(vo.getMng_account().equals(mng_account)) {
							errorMsgs.add("管理員帳號: 請勿重複");
						}
					}
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
		
					String mng_name = req.getParameter("mng_name");
					String mng_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
					if (mng_name == null || mng_name.trim().length() == 0) {
						errorMsgs.add("管理員姓名: 請勿空白");
					} else if (!mng_name.trim().matches(mng_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("管理員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
					}
					
					byte[] mng_pic = req.getPart("mng_pic").getInputStream().readAllBytes();
					if(mng_pic.length==0) {
						mng_pic=null;
					}
		
					// ------------------------------------------------------------
		
					String mng_phone = req.getParameter("mng_phone");
					String mng_phoneReg = "^[(0-9)]{10}$";
					if (mng_phone == null || mng_phone.trim().length() == 0) {
						errorMsgs.add("管理員手機: 請勿空白");
					} else if (!mng_phone.trim().matches(mng_phoneReg)) { // 以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("管理員手機: 只能是數字和, 且長度必需在10");
					}
		
					Integer mng_status = null;
					try {
						mng_status = Integer.valueOf(req.getParameter("mng_status").trim());
					} catch (NumberFormatException e) {
						errorMsgs.add("請選擇管理員狀態");
					}

					Manager_VO manager_VO = new Manager_VO();
					manager_VO.setMng_account(mng_account);
					manager_VO.setMng_password(mng_password);
					manager_VO.setMng_name(mng_name);
					manager_VO.setMng_phone(mng_phone);
					manager_VO.setMng_pic(mng_pic);
					manager_VO.setMng_status(mng_status);

					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						req.setAttribute("manager_VO", manager_VO); // 含有輸入格式錯誤的manager_VO物件,也存入req
						RequestDispatcher failureView = req
								.getRequestDispatcher("/manager/addManager.jsp");
						failureView.forward(req, res);
						return;
					}
					
					/***************************2.開始新增資料***************************************/
					Manager_Service manager_Svc = new Manager_Service();
					manager_VO = manager_Svc.addManager(mng_account, mng_password, mng_name, mng_phone, mng_pic, mng_status);
					
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					String url = "/manager/listAllManager.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllManager.jsp
					successView.forward(req, res);				
			}
		 
	}
}
