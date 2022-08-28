package com.forum.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.forum.model.*;

public class Forum_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("frm_no");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入討論區編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/forum/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer frm_no = null;
				try {
					frm_no = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("討論區編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/forum/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				Forum_Service forum_Svc = new Forum_Service();
				Forum_VO forum_VO = forum_Svc.getOneForum(frm_no);
				if (forum_VO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/forum/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("forum_VO", forum_VO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/forum/listOneForum.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer frm_no = Integer.valueOf(req.getParameter("frm_no"));
				
				/***************************2.開始查詢資料****************************************/
				Forum_Service forum_Svc = new Forum_Service();
				Forum_VO forum_VO = forum_Svc.getOneForum(frm_no);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("forum_VO", forum_VO);         // 資料庫取出的empVO物件,存入req
				String url = "/back-end/forum/update_forum_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer frm_no = Integer.valueOf(req.getParameter("frm_no").trim());
				
			String frm_name_no = req.getParameter("frm_name_no");
				String frm_name_noReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (frm_name_no == null || frm_name_no.trim().length() == 0) {
					errorMsgs.add("討論區名稱: 請勿空白");
				} else if(!frm_name_no.trim().matches(frm_name_noReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("討論區名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
			//這裡放討論區狀態


				Forum_VO forum_VO = new Forum_VO();
				forum_VO.setFrm_no(frm_no);
				forum_VO.setFrm_name_no(frm_name_no);
				forum_VO.setFrm_status(frm_status);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("forum_VO", forum_VO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/emp/update_emp_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				Forum_Service forum_Svc = new Forum_Service();
				forum_VO = forum_Svc.updateEmp(frm_no, frm_name_no, frm_status);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("forum_VO", forum_VO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/back-end/forum/listOneForum.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			
			String frm_name_no = req.getParameter("frm_name_no");
			String frm_name_noReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (frm_name_no == null || frm_name_no.trim().length() == 0) {
				errorMsgs.add("討論區名稱: 請勿空白");
			} else if(!frm_name_no.trim().matches(frm_name_noReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("討論區名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }
			
			//這裡放討論區狀態


				Forum_VO forum_VO = new Forum_VO();
				forum_VO.setFrm_name_no(frm_name_no);
				forum_VO.setFrm_status(frm_status);
			
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("forum_VO", forum_VO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/forum/addEmp.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				Forum_Service forum_Svc = new Forum_Service();
				forum_VO = forum_Svc.addForum(frm_name_no, frm_status);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/forum/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer frm_no = Integer.valueOf(req.getParameter("frm_no"));
				
				/***************************2.開始刪除資料***************************************/
				Forum_Service forum_Svc = new Forum_Service();
				forum_Svc.deleteForum(frm_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/forum/listAllForum.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}
