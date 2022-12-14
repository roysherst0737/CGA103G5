package com.forum_article.controller;

import java.io.*;

import java.sql.Timestamp;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.forum_article.model.*;
import com.forum.model.Forum_VO;

@MultipartConfig
public class Forum_article_Servlet_front extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("frm_art_no");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入文章編號");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/forum_article/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			Integer frm_art_no = null;
			try {
				frm_art_no = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("文章編號格式不正確");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/forum_article/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始查詢資料 *****************************************/
			Forum_article_Service forum_article_Svc = new Forum_article_Service();
			Forum_article_VO forum_article_VO = forum_article_Svc.getOneForum_article(frm_art_no);
			if (forum_article_VO == null) {
				errorMsgs.add("查無資料");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/forum_article/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("forum_article_VO", forum_article_VO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/forum_article/listOneForum_article.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer frm_art_no = Integer.valueOf(req.getParameter("frm_art_no"));

			/*************************** 2.開始查詢資料 ****************************************/
			Forum_article_Service forum_article_Svc = new Forum_article_Service();
			Forum_article_VO forum_article_VO = forum_article_Svc.getOneForum_article(frm_art_no);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("forum_article_VO", forum_article_VO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/forum_article/update_forum_article_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer frm_art_no = Integer.valueOf(req.getParameter("frm_art_no").trim());

			Integer frm_no = Integer.valueOf(req.getParameter("frm_no").trim());

			Integer mem_no = Integer.valueOf(req.getParameter("mem_no").trim());

			java.sql.Timestamp art_time = new Timestamp(System.currentTimeMillis());

			String art_title = req.getParameter("art_title");
//			if (art_title == null || art_title.trim().length() == 0) {
//				errorMsgs.add("文章主旨: 請勿空白");
//			}

			String art_content = req.getParameter("art_content");
//			if (art_content == null || art_content.trim().length() == 0) {
//				errorMsgs.add("文章內容: 請勿空白");
//			}

			byte[] art_img = req.getPart("art_img").getInputStream().readAllBytes();
			if (art_img.length == 0) {
				art_img = null;
			}

			Integer art_status = Integer.valueOf(req.getParameter("art_status").trim());

			Forum_article_VO forum_article_VO = new Forum_article_VO();
			forum_article_VO.setFrm_art_no(frm_art_no);
			forum_article_VO.setFrm_no(frm_no);
			forum_article_VO.setMem_no(mem_no);
			forum_article_VO.setArt_time(art_time);
			forum_article_VO.setArt_title(art_title);
			forum_article_VO.setArt_content(art_content);
			forum_article_VO.setArt_img(art_img);
			forum_article_VO.setArt_status(art_status);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("forum_article_VO", forum_article_VO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/forum_article/update_forum_article_input.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始修改資料 *****************************************/
			Forum_article_Service forum_article_Svc = new Forum_article_Service();
			forum_article_VO = forum_article_Svc.updateForum_article(frm_art_no, frm_no, mem_no, art_time, art_title,
					art_content, art_img, art_status);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("forum_article_VO", forum_article_VO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/forum_article/listOneForum_article.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer frm_no = Integer.valueOf(req.getParameter("frm_no").trim());

			Integer mem_no = Integer.valueOf(req.getParameter("mem_no").trim());

			String art_title = req.getParameter("art_title");

			String art_content = req.getParameter("art_content");

			Forum_article_VO forum_article_VO = new Forum_article_VO();
			forum_article_VO.setFrm_no(frm_no);
			forum_article_VO.setMem_no(mem_no);
			forum_article_VO.setArt_title(art_title);
			forum_article_VO.setArt_content(art_content);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("forum_article_VO", forum_article_VO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/forum_article/new_frm_art.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			Forum_article_Service forum_article_Svc = new Forum_article_Service();
			forum_article_VO = forum_article_Svc.addForum_article(frm_no, mem_no, art_title, art_content);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/CGA103G5ALL/front-end/forum/forum-list.jsp?" + frm_no;
			res.sendRedirect(url);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer frm_art_no = Integer.valueOf(req.getParameter("frm_art_no"));

			/*************************** 2.開始刪除資料 ***************************************/
			Forum_article_Service forum_article_Svc = new Forum_article_Service();
			forum_article_Svc.deleteForum_article(frm_art_no);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/forum_article/listAllForum_article.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
	}
}
