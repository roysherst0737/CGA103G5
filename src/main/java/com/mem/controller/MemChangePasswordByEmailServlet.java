package com.mem.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.mem.model.Mem_Service;
import com.mem.model.Mem_VO;

@WebServlet(urlPatterns = {"/front-end/mem/MemChangePasswordByEmailServlet"})
public class MemChangePasswordByEmailServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");		
		
		if ("change_password_by_email".equals(action)) { // 來自update_emp_input.jsp的請求
		
		HttpSession session =req.getSession(false);

		
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);

			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			
			
			String mem_email = req.getParameter("mem_email");
			
			String newPassword = req.getParameter("newPassword");
			String npasswordReg = "^[(a-zA-Z0-9_)]{2,10}$";
			if (newPassword == null || newPassword.trim().length() == 0) {
				errorMsgs.add("新密碼: 請勿空白");
			} else if(!newPassword.trim().matches(npasswordReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("新密碼: 只能是英文字母、數字和_ , 且長度必需在2到10之間");
			}
			
			String checkNewPassword = req.getParameter("checkNewPassword");
			String cnpasswordReg = "^[(a-zA-Z0-9_)]{2,10}$";
			if (checkNewPassword == null || checkNewPassword.trim().length() == 0) {
				errorMsgs.add("重新輸入密碼: 請勿空白");
			} else if(!checkNewPassword.trim().matches(cnpasswordReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("重新輸入密碼: 只能是英文字母、數字和_ , 且長度必需在2到10之間");
			}
			
			if(!newPassword.equals(checkNewPassword)) {
				errorMsgs.add("新密碼與重新輸入密碼不一致");
			}


			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
//				req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/mem/Email_Success.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始修改資料*****************************************/
			Mem_Service memSvc = new Mem_Service();
			memSvc.update_password_by_email(mem_email,newPassword);
			
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
//			req.setAttribute("memVO", memVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "http://localhost:8081/CGA103G5ALL/front-end/index.jsp";
			res.sendRedirect(url);
		}
	}
}
