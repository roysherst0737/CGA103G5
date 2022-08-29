package com.article_message_report.controller;

import java.io.*;
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

		if ("getAll".equals(action)) {
			/***************************開始查詢資料 ****************************************/
			Article_message_report_DAO dao = new Article_message_report_DAO();
			List<Article_message_report_VO> list = dao.getAll();

			/***************************查詢完成,準備轉交(Send the Success view)*************/
			HttpSession session = req.getSession();
			session.setAttribute("list", list);     // 資料庫取出的list物件,存入session
			// Send the Success view
			String url = "/article_message_report/listAllArticle_message_report_getFromSession.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交listAllEmp2_getFromSession.jsp
			successView.forward(req, res);
			return;
		}


		if ("getOne_For_Display".equals(action)) { //來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("art_msg_rpt");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入留言編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/article_message_report/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer art_msg_rpt = null;
				try {
					art_msg_rpt = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("留言編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/article_message_report/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				Article_message_report_DAO dao = new Article_message_report_DAO();
				Article_message_report_VO article_message_report_VO = dao.findByPrimaryKey(art_msg_rpt);
				if (article_message_report_VO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/article_message_report/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("article_message_report_VO", article_message_report_VO);// 資料庫取出的empVO物件,存入req
				String url = "/article_message_report/listOneArticle_message_report.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
	}
}
