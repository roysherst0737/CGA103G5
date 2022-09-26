package com.article_message_report.controller;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.article_message_report.model.*;

public class Article_message_report_Servlet extends HttpServlet {

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
				String str = req.getParameter("art_msg_rpt");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入留言檢舉編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/article_message_report/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer art_msg_rpt = null;
				try {
					art_msg_rpt = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("留言檢舉編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/article_message_report/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				/***************************2.開始查詢資料*****************************************/
				Article_message_report_Service article_message_report_Svc = new Article_message_report_Service();
				Article_message_report_VO article_message_report_VO = article_message_report_Svc.getOneArticle_message_report(art_msg_rpt);
				if (article_message_report_VO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/article_message_report/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("article_message_report_VO", article_message_report_VO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/article_message_report/listOneArticle_message_report.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer art_msg_rpt = Integer.valueOf(req.getParameter("art_msg_rpt"));
				
				/***************************2.開始查詢資料****************************************/
				Article_message_report_Service article_message_report_Svc = new Article_message_report_Service();
				Article_message_report_VO article_message_report_VO = article_message_report_Svc.getOneArticle_message_report(art_msg_rpt);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("article_message_report_VO", article_message_report_VO);         // 資料庫取出的empVO物件,存入req
				String url = "/back-end/article_message_report/update_article_message_report_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer art_msg_rpt = Integer.valueOf(req.getParameter("art_msg_rpt").trim());
			
			java.sql.Timestamp msg_done_time = new Timestamp(System.currentTimeMillis());
			
			Integer msg_result = Integer.valueOf(req.getParameter("msg_result"));

			String msg_note = req.getParameter("msg_note").trim();
				
				

				Article_message_report_VO article_message_report_VO = new Article_message_report_VO();
				article_message_report_VO.setArt_msg_rpt(art_msg_rpt);
				article_message_report_VO.setMng_no(1);
				article_message_report_VO.setMsg_done_time(msg_done_time);
				article_message_report_VO.setMsg_status(0);
				article_message_report_VO.setMsg_result(msg_result);
				article_message_report_VO.setMsg_note(msg_note);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("article_message_report_VO", article_message_report_VO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/article_message_report/update_article_message_report_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				Article_message_report_Service article_message_report_Svc = new Article_message_report_Service();
				article_message_report_Svc.checkArticle_message_report(article_message_report_VO);
//				article_message_report_VO = article_message_report_Svc.updateArticle_message_report(art_msg_rpt, mem_no, art_msg_no, rpt_time, rpt_msg_content,mng_no, msg_done_time, msg_states, msg_result, msg_note);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				article_message_report_VO = article_message_report_Svc.getOneArticle_message_report(art_msg_rpt);
				req.setAttribute("article_message_report_VO", article_message_report_VO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/back-end/article_message_report/listOneArticle_message_report.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}
		
        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
		System.out.println("789");	
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			Integer mem_no = Integer.valueOf(req.getParameter("mem_no").trim());
			
			Integer url = Integer.valueOf(req.getParameter("url").trim());
			
			Integer art_msg_no = Integer.valueOf(req.getParameter("art_msg_no").trim());
			
			java.sql.Timestamp rpt_time = null;
			try {
				rpt_time = java.sql.Timestamp.valueOf(req.getParameter("rpt_time").trim());
			} catch (IllegalArgumentException e) {
				rpt_time=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}
			
			String rpt_msg_content = req.getParameter("rpt_msg_content").trim();
				if (rpt_msg_content == null || rpt_msg_content.trim().length() == 0) {
					errorMsgs.add("檢舉留言內容請勿空白");
				}	
			

				






				Article_message_report_VO article_message_report_VO = new Article_message_report_VO();
				article_message_report_VO.setMem_no(mem_no);
				article_message_report_VO.setArt_msg_no(art_msg_no);
				article_message_report_VO.setRpt_time(rpt_time);
				article_message_report_VO.setRpt_msg_content(rpt_msg_content);


				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("article_message_report_VO", article_message_report_VO); // 含有輸入格式錯誤的empVO物件,也存入req
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/back-end/article_message_report/addArticle_message_report.jsp");
//					failureView.forward(req, res);
//					return;
//				}
				System.out.println("456");
				/***************************2.開始新增資料***************************************/
				Article_message_report_Service article_message_report_Svc = new Article_message_report_Service();
//				forum_article_report_Svc.checkForum_article_report(forum_article_report_VO);
				article_message_report_VO = article_message_report_Svc.addArticle_message_report(mem_no, art_msg_no, rpt_time, rpt_msg_content);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url1 = "/CGA103G5ALL/front-end/forum_article/show_frm_art.jsp?" + url;
				res.sendRedirect(url1);
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer art_msg_rpt = Integer.valueOf(req.getParameter("art_msg_rpt"));
				
				/***************************2.開始刪除資料***************************************/
				Article_message_report_Service article_message_report_Svc = new Article_message_report_Service();
				article_message_report_Svc.deleteArticle_message_report(art_msg_rpt);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/article_message_report/listAllArticle_message_report.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}
