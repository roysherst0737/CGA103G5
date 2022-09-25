package com.mem.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.mem.model.Mem_Service;
import com.mem.model.Mem_VO;


public class MemChangePasswordServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");		
		
		if ("change_password".equals(action)) { // 來自update_emp_input.jsp的請求
		
		HttpSession session =req.getSession(false);
		Mem_VO user = (Mem_VO) session.getAttribute("user");
		
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
	System.out.println(req.getParameter("mem_no"));
	System.out.println(user.getMem_password());
	System.out.println(req.getParameter("oldPassword"));
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer mem_no = Integer.valueOf(req.getParameter("mem_no"));
			
			String oldPassword = req.getParameter("oldPassword");
			String opasswordReg = "^[(a-zA-Z0-9_)]{2,10}$";
			if (oldPassword == null || oldPassword.trim().length() == 0) {
				errorMsgs.add("舊密碼: 請勿空白");
			} else if(!oldPassword.trim().matches(opasswordReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("舊密碼: 只能是英文字母、數字和_ , 且長度必需在2到10之間");
            }else if(!oldPassword.equals(user.getMem_password())) {
				errorMsgs.add("舊密碼:輸入的舊密碼有誤");
			}
			
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

			Mem_VO memVO = new Mem_VO();
			memVO.setMem_password(newPassword);
			memVO.setMem_no(mem_no);


			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/mem/change_password.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始修改資料*****************************************/
			Mem_Service memSvc = new Mem_Service();
			memVO = memSvc.updatePassword(newPassword, mem_no);
			
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			req.setAttribute("memVO", memVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/front-end/mem/memApplication.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}
	}
}
