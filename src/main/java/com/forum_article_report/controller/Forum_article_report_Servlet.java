package com.forum_article_report.controller;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.forum_article.model.Forum_article_Service;
import com.forum_article.model.Forum_article_VO;
import com.forum_article_report.model.*;

public class Forum_article_report_Servlet extends HttpServlet {

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
				String str = req.getParameter("frm_art_rpt_no");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入文章檢舉編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/forum_article_report/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer frm_art_rpt_no = null;
				try {
					frm_art_rpt_no = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("文章檢舉編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/forum_article_report/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				Forum_article_report_Service forum_article_report_Svc = new Forum_article_report_Service();
				Forum_article_report_VO forum_article_report_VO = forum_article_report_Svc.getOneForum_article_report(frm_art_rpt_no);
				if (forum_article_report_VO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/forum_article_report/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("forum_article_report_VO", forum_article_report_VO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/forum_article_report/listOneForum_article_report.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer frm_art_rpt_no = Integer.valueOf(req.getParameter("frm_art_rpt_no"));
				
				/***************************2.開始查詢資料****************************************/
				Forum_article_report_Service forum_article_report_Svc = new Forum_article_report_Service();
				Forum_article_report_VO forum_article_report_VO = forum_article_report_Svc.getOneForum_article_report(frm_art_rpt_no);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("forum_article_report_VO", forum_article_report_VO);         // 資料庫取出的empVO物件,存入req
				String url = "/back-end/forum_article_report/update_forum_article_report_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer frm_art_rpt_no = Integer.valueOf(req.getParameter("frm_art_rpt_no").trim());
			

			java.sql.Timestamp rpt_done_time = new Timestamp(System.currentTimeMillis());
			

//			Integer rpt_status = Integer.valueOf(req.getParameter("rpt_status"));
		
			Integer rpt_result = Integer.valueOf(req.getParameter("rpt_result"));
		
			
			String rpt_note = req.getParameter("rpt_note").trim();
			
			


			Forum_article_report_VO forum_article_report_VO = new Forum_article_report_VO();
			forum_article_report_VO.setFrm_art_rpt_no(frm_art_rpt_no);
			forum_article_report_VO.setMng_no(1);
			forum_article_report_VO.setRpt_done_time(rpt_done_time);
			forum_article_report_VO.setRpt_status(0);
			forum_article_report_VO.setRpt_result(rpt_result);
			forum_article_report_VO.setRpt_note(rpt_note);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("forum_article_report_VO", forum_article_report_VO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/forum_article_report/update_forum_article_report_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				Integer frm_art_no = Integer.valueOf(req.getParameter("frm_art_no").trim());
				
				Integer art_status = Integer.valueOf(req.getParameter("art_status").trim());
				
				Forum_article_VO forum_article_VO = new Forum_article_VO();
				
				forum_article_VO.setArt_status(art_status);
				
				/***************************2.開始修改資料*****************************************/
				Forum_article_report_Service forum_article_report_Svc = new Forum_article_report_Service();
				forum_article_report_Svc.checkForum_article_report(forum_article_report_VO);
//				forum_article_report_VO = forum_article_report_Svc.updateForum_article_report(frm_art_rpt_no, mem_no, frm_art_no, rpt_time, rpt_content,mng_no, rpt_done_time, forum_article_report_VO.getRpt_status(), forum_article_report_VO.getRpt_result(), rpt_note);
				
				Forum_article_Service forum_article_Svc = new Forum_article_Service();
				art_status = forum_article_Svc.ChangeStatus(frm_art_no);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				forum_article_report_VO = forum_article_report_Svc.getOneForum_article_report(frm_art_rpt_no);
				req.setAttribute("forum_article_report_VO", forum_article_report_VO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/back-end/forum_article_report/listOneForum_article_report.jsp";
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
			
			Integer url = Integer.valueOf(req.getParameter("url").trim());
			
			Integer frm_art_no = Integer.valueOf(req.getParameter("frm_art_no").trim());
			
			java.sql.Timestamp rpt_time = null;
			try {
				rpt_time = java.sql.Timestamp.valueOf(req.getParameter("rpt_time").trim());
			} catch (IllegalArgumentException e) {
				rpt_time=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}
			
			String rpt_content = req.getParameter("rpt_content").trim();
			if (rpt_content == null || rpt_content.trim().length() == 0) {
				errorMsgs.add("檢舉文章內容請勿空白");
			}	
					
//			Integer mng_no = Integer.valueOf(req.getParameter("mng_no").trim());
			
//			java.sql.Timestamp rpt_done_time = null;
//			try {
//				rpt_done_time = java.sql.Timestamp.valueOf(req.getParameter("rpt_done_time").trim());
//			} catch (IllegalArgumentException e) {
//				rpt_done_time=new java.sql.Timestamp(System.currentTimeMillis());
//				errorMsgs.add("請輸入日期!");
//			}
//			Integer rpt_status = Integer.valueOf(req.getParameter("rpt_status"));
			
			//文章處理狀態 放這裡
//			Integer rpt_result = Integer.valueOf(req.getParameter("rpt_result"));
			
			//文章處理結果 放這裡
//			String rpt_note = req.getParameter("rpt_note").trim();
			
			
			
			Forum_article_report_VO forum_article_report_VO = new Forum_article_report_VO();
			forum_article_report_VO.setMem_no(mem_no);
			forum_article_report_VO.setFrm_art_no(frm_art_no);
			forum_article_report_VO.setRpt_time(rpt_time);
			forum_article_report_VO.setRpt_content(rpt_content);
//			forum_article_report_VO.setMng_no(mng_no);
//			forum_article_report_VO.setRpt_done_time(rpt_done_time);
//			forum_article_report_VO.setRpt_status(rpt_status);
//			forum_article_report_VO.setRpt_result(rpt_result);
//			forum_article_report_VO.setRpt_note(rpt_note);

				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("forum_article_report_VO", forum_article_report_VO); // 含有輸入格式錯誤的empVO物件,也存入req
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/back-end/forum_article_report/listOneForum_article_report.jsp");
//					failureView.forward(req, res);
//					return;
//				}

			
			
			
				/***************************2.開始新增資料***************************************/
				Forum_article_report_Service forum_article_report_Svc = new Forum_article_report_Service();
				forum_article_report_VO = forum_article_report_Svc.addForum_article_report(mem_no, frm_art_no, rpt_time, rpt_content);
				

				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url1 = "/CGA103G5ALL/front-end/forum_article/show_frm_art.jsp?" + frm_art_no;
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
				Integer frm_art_rpt_no = Integer.valueOf(req.getParameter("frm_art_rpt_no"));
				
				/***************************2.開始刪除資料***************************************/
				Forum_article_report_Service forum_article_report_Svc = new Forum_article_report_Service();
				forum_article_report_Svc.deleteForum_article_report(frm_art_rpt_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/forum_article_report/listAllForum_article_report.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}
