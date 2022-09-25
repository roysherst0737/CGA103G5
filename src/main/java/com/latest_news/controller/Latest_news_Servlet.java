package com.latest_news.controller;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.latest_news.model.*;

public class Latest_news_Servlet extends HttpServlet {

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
				String str = req.getParameter("latest_news_no");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入最新消息編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/latest_news/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer latest_news_no = null;
				try {
					latest_news_no = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("最新消息編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/latest_news/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				Latest_news_Service latest_news_Svc = new Latest_news_Service();
				Latest_news_VO latest_news_VO = latest_news_Svc.getOneLatest_news(latest_news_no);
				if (latest_news_VO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/latest_news/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("latest_news_VO", latest_news_VO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/latest_news/listOneLatest_news.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer latest_news_no = Integer.valueOf(req.getParameter("latest_news_no"));
				
				/***************************2.開始查詢資料****************************************/
				Latest_news_Service latest_news_Svc = new Latest_news_Service();
				Latest_news_VO latest_news_VO = latest_news_Svc.getOneLatest_news(latest_news_no);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("latest_news_VO", latest_news_VO);         // 資料庫取出的empVO物件,存入req
				String url = "/back-end/latest_news/update_latest_news_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer latest_news_no = Integer.valueOf(req.getParameter("latest_news_no").trim());
				
//			String news_content = req.getParameter("news_content");
//				String news_contentReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (news_content == null || news_content.trim().length() == 0) {
//					errorMsgs.add("消息內容: 請勿空白");
//				} else if(!news_content.trim().matches(news_contentReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("消息內容: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }
				
			String news_content = req.getParameter("news_content").trim();
				if (news_content == null || news_content.trim().length() == 0) {
					errorMsgs.add("消息內容請勿空白");
				}	
				
			Integer news_status = Integer.valueOf(req.getParameter("news_status").trim());
			//消息狀態  放這裡
			
			java.sql.Timestamp news_time = new Timestamp(System.currentTimeMillis());

				Latest_news_VO latest_news_VO = new Latest_news_VO();
				latest_news_VO.setLatest_news_no(latest_news_no);
				latest_news_VO.setNews_content(news_content);
				latest_news_VO.setNews_status(news_status);
				latest_news_VO.setNews_time(news_time);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("latest_news_VO", latest_news_VO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/latest_news/update_latest_news_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				Latest_news_Service latest_news_Svc = new Latest_news_Service();
				latest_news_VO = latest_news_Svc.updateLatest_news(latest_news_no, news_content, news_status,news_time);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("latest_news_VO", latest_news_VO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/back-end/latest_news/listOneLatest_news.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//			Integer latest_news_no = Integer.valueOf(req.getParameter("latest_news_no").trim());
			
			String news_content = req.getParameter("news_content").trim();
			if (news_content == null || news_content.trim().length() == 0) {
				errorMsgs.add("消息內容請勿空白");
			}	
			
			Integer news_status = Integer.valueOf(req.getParameter("news_status").trim());
		//消息狀態  放這裡
			
			java.sql.Timestamp news_time = new Timestamp(System.currentTimeMillis());

			Latest_news_VO latest_news_VO = new Latest_news_VO();
//			latest_news_VO.setLatest_news_no(latest_news_no);
			latest_news_VO.setNews_content(news_content);
			latest_news_VO.setNews_status(news_status);
			latest_news_VO.setNews_time(news_time);
			
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("latest_news_VO", latest_news_VO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/latest_news/addLatest_news.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				Latest_news_Service latest_news_Svc = new Latest_news_Service();
				latest_news_VO = latest_news_Svc.addLatest_news(news_content, news_status,news_time);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/latest_news/listAllLatest_news.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer latest_news_no = Integer.valueOf(req.getParameter("latest_news_no"));
				
				/***************************2.開始刪除資料***************************************/
				Latest_news_Service latest_news_Svc = new Latest_news_Service();
				latest_news_Svc.deleteLatest_news(latest_news_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/latest_news/listAllLatest_news.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}
