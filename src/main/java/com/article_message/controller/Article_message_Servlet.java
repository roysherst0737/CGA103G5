package com.article_message.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.article_message.model.*;

public class Article_message_Servlet extends HttpServlet {

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
				String str = req.getParameter("art_msg_no");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入留言編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/article_message/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer art_msg_no = null;
				try {
					art_msg_no = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("留言編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/article_message/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				Article_message_Service article_message_Svc = new Article_message_Service();
				Article_message_VO article_message_VO = article_message_Svc.getOneArticle_message(art_msg_no);
				if (article_message_VO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/article_message/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("article_message_VO", article_message_VO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/article_message/listOneArticle_message.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer art_msg_no = Integer.valueOf(req.getParameter("art_msg_no"));
				
				/***************************2.開始查詢資料****************************************/
				Article_message_Service article_message_Svc = new Article_message_Service();
				Article_message_VO article_message_VO = article_message_Svc.getOneArticle_message(art_msg_no);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("article_message_VO", article_message_VO);         // 資料庫取出的empVO物件,存入req
				String url = "/back-end/article_message/update_article_message_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer art_msg_no = Integer.valueOf(req.getParameter("art_msg_no").trim());
			
			Integer mem_no = Integer.valueOf(req.getParameter("mem_no").trim());
			
			Integer frm_art_no = Integer.valueOf(req.getParameter("frm_art_no").trim());
			
			java.sql.Timestamp msg_time = null;
			try {
				msg_time = java.sql.Timestamp.valueOf(req.getParameter("msg_time").trim());
			} catch (IllegalArgumentException e) {
				msg_time=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}
					
			String msg_content = req.getParameter("msg_content").trim();
				if (msg_content == null || msg_content.trim().length() == 0) {
					errorMsgs.add("留言內容請勿空白");
				}	
				

				Article_message_VO article_message_VO = new Article_message_VO();
				article_message_VO.setArt_msg_no(art_msg_no);
				article_message_VO.setMem_no(mem_no);
				article_message_VO.setFrm_art_no(frm_art_no);
				article_message_VO.setMsg_time(msg_time);
				article_message_VO.setMsg_content(msg_content);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("article_message_VO", article_message_VO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/article_message/update_article_message_input.jsp");
					System.out.println(123);
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				Article_message_Service article_message_Svc = new Article_message_Service();
				article_message_VO = article_message_Svc.updateArticle_message(art_msg_no, mem_no, frm_art_no, msg_time, msg_content);
				System.out.println(123);
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("article_message_VO", article_message_VO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/back-end/article_message/listOneArticle_message.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
			
		}
				
        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

			
			Integer mem_no = Integer.valueOf(req.getParameter("mem_no").trim());
			
			Integer frm_art_no = Integer.valueOf(req.getParameter("frm_art_no").trim());
			
			java.sql.Timestamp msg_time = null;
			try {
				msg_time = java.sql.Timestamp.valueOf(req.getParameter("msg_time").trim());
			} catch (IllegalArgumentException e) {
				msg_time=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}
				
//String msg_content = req.getParameter("msg_content");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (ename == null || ename.trim().length() == 0) {
//					errorMsgs.add("留言內容: 請勿空白");
//				} else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("留言內容: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }
//				
			String msg_content = req.getParameter("msg_content").trim();
				if (msg_content == null || msg_content.trim().length() == 0) {
					errorMsgs.add("留言內容請勿空白");
				}	
				

				Article_message_VO article_message_VO = new Article_message_VO();
				article_message_VO.setMem_no(mem_no);
				article_message_VO.setFrm_art_no(frm_art_no);
				article_message_VO.setMsg_time(msg_time);
				article_message_VO.setMsg_content(msg_content);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("article_message_VO", article_message_VO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/article_message/addArticle_message.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				Article_message_Service article_message_Svc = new Article_message_Service();
				article_message_VO = article_message_Svc.addArticle_message(mem_no, frm_art_no, msg_time, msg_content);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/article_message/listAllArticle_message.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer art_msg_no = Integer.valueOf(req.getParameter("art_msg_no"));
				
				/***************************2.開始刪除資料***************************************/
				Article_message_Service article_message_Svc = new Article_message_Service();
				article_message_Svc.deleteArticle_message(art_msg_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/article_message/listAllArticle_message.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
		
	}
}
