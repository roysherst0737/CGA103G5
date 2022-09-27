package com.act.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.act.model.Act_Service;
import com.act.model.Act_VO;

@WebServlet("/back-end/act/act.do")
public class Act_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("act_no");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入活動編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/act/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer act_no = null;
			try {
				act_no = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("活動編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/act/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			Act_Service actSvc = new Act_Service();
			Act_VO actVO = actSvc.getOneAct(act_no);
			if (actVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/act/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("actVO", actVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/act/listOneAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer act_no = Integer.valueOf(req.getParameter("act_no"));

			/*************************** 2.開始查詢資料 ****************************************/
			Act_Service actSvc = new Act_Service();
			Act_VO actVO = actSvc.getOneAct(act_no);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("actVO", actVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/act/update_act_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer act_no = Integer.valueOf(req.getParameter("act_no").trim());

			Integer pub_no = null;
			try {
				pub_no = Integer.valueOf(req.getParameter("pub_no").trim());
			} catch (NumberFormatException e) {
				pub_no = 0;
				errorMsgs.add("酒吧編號請填數字");
			}

			String act_name = req.getParameter("act_name").trim();
			if (act_name == null || act_name.trim().length() == 0) {
				errorMsgs.add("活動名稱請勿空白");
			}

			String act_detail = req.getParameter("act_detail").trim();
			if (act_detail == null || act_detail.trim().length() == 0) {
				errorMsgs.add("活動描述請勿空白");
			}

			String act_loc = req.getParameter("act_loc").trim();
			if (act_loc == null || act_loc.trim().length() == 0) {
				errorMsgs.add("活動地址請勿空白");
			}

			Timestamp act_launch_time;
			try {
				act_launch_time = java.sql.Timestamp.valueOf(req.getParameter("act_launch_time").trim());
			} catch (IllegalArgumentException e) {
				act_launch_time = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入上架時間!");
			}

			Timestamp act_off_time;
			try {
				act_off_time = java.sql.Timestamp.valueOf(req.getParameter("act_off_time").trim());
			} catch (IllegalArgumentException e) {
				act_off_time = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入下架時間!");
			}

			

			Integer max_count = null;
			try {
				max_count = Integer.valueOf(req.getParameter("max_count").trim());
			} catch (NumberFormatException e) {
				max_count = 0;
				errorMsgs.add("容納人數上限請填數字");
			}

			Integer min_count = null;
			try {
				min_count = Integer.valueOf(req.getParameter("min_count").trim());
			} catch (NumberFormatException e) {
				min_count = 0;
				errorMsgs.add("容納人數下限請填數字");
			}

			Timestamp sign_up_begin_time;
			try {
				sign_up_begin_time = java.sql.Timestamp.valueOf(req.getParameter("sign_up_begin_time").trim());
			} catch (IllegalArgumentException e) {
				sign_up_begin_time = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入報名開始時間!");
			}

			Timestamp sign_up_end_time;
			try {
				sign_up_end_time = java.sql.Timestamp.valueOf(req.getParameter("sign_up_end_time").trim());
			} catch (IllegalArgumentException e) {
				sign_up_end_time = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入報名結束時間!");
			}

			Timestamp act_start_time;
			try {
				act_start_time = java.sql.Timestamp.valueOf(req.getParameter("act_start_time").trim());
			} catch (IllegalArgumentException e) {
				act_start_time = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入活動開始時間!");
			}

			Timestamp act_end_time;
			try {
				act_end_time = java.sql.Timestamp.valueOf(req.getParameter("act_end_time").trim());
			} catch (IllegalArgumentException e) {
				act_end_time = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入活動結束時間!");
			}

			Integer act_status = null;
			try {
				act_status = Integer.valueOf(req.getParameter("act_status").trim());
			} catch (NumberFormatException e) {
				act_status = 0;
				errorMsgs.add("活動狀態請填數字");
			}

			java.sql.Timestamp revise_time = new java.sql.Timestamp(System.currentTimeMillis());
			

			Act_VO actVO = new Act_VO();
			actVO.setAct_no(act_no);
			actVO.setPub_no(pub_no);
			actVO.setAct_name(act_name);
			actVO.setAct_detail(act_detail);
			actVO.setAct_loc(act_loc);
			actVO.setAct_launch_time(act_launch_time);
			actVO.setAct_off_time(act_off_time);
			actVO.setMax_count(max_count);
			actVO.setMin_count(min_count);
			actVO.setSign_up_begin_time(sign_up_begin_time);
			actVO.setSign_up_end_time(sign_up_end_time);
			actVO.setAct_start_time(act_start_time);
			actVO.setAct_end_time(act_end_time);
			actVO.setAct_status(act_status);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("actVO", actVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/act/update_act_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			Act_Service actSvc = new Act_Service();
			actVO = actSvc.updateAct(pub_no, act_name, act_detail, act_loc, act_launch_time, act_off_time,
					 max_count, min_count, sign_up_begin_time, sign_up_end_time, act_start_time,
					act_end_time, act_status, act_no);

			actVO.setRevise_time(revise_time);		
			

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("actVO", actVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/act/listOneAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			Integer pub_no = null;
			try {
				pub_no = Integer.valueOf(req.getParameter("pub_no").trim());
			} catch (NumberFormatException e) {
				pub_no = 0;
				errorMsgs.add("酒吧編號請填數字");
			}

			String act_name = req.getParameter("act_name").trim();
			if (act_name == null || act_name.trim().length() == 0) {
				errorMsgs.add("活動名稱請勿空白");
			}

			String act_detail = req.getParameter("act_detail").trim();
			if (act_detail == null || act_detail.trim().length() == 0) {
				errorMsgs.add("活動描述請勿空白");
			}

			String act_loc = req.getParameter("act_loc").trim();
			if (act_loc == null || act_loc.trim().length() == 0) {
				errorMsgs.add("活動地址請勿空白");
			}

			Timestamp act_launch_time = null;
			try {
				act_launch_time = java.sql.Timestamp.valueOf(req.getParameter("act_launch_time").trim() + ":00");

			} catch (IllegalArgumentException e) {
				act_launch_time = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入上架時間!");
			}

			Timestamp act_off_time = null;
			try {
				act_off_time = java.sql.Timestamp.valueOf(req.getParameter("act_off_time").trim() + ":00");
			} catch (IllegalArgumentException e) {
				act_off_time = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入下架時間!");
			}



			Integer max_count = null;
			try {
				max_count = Integer.valueOf(req.getParameter("max_count").trim());
			} catch (NumberFormatException e) {
				max_count = 0;
				errorMsgs.add("容納人數上限請填數字");
			}

			Integer min_count = null;
			try {
				min_count = Integer.valueOf(req.getParameter("min_count").trim());
			} catch (NumberFormatException e) {
				min_count = 0;
				errorMsgs.add("容納人數下限請填數字");
			}

			Timestamp sign_up_begin_time = null;
			try {
				sign_up_begin_time = java.sql.Timestamp.valueOf(req.getParameter("sign_up_begin_time").trim() + ":00");
			} catch (IllegalArgumentException e) {
				sign_up_begin_time = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入報名開始時間!");
			}

			Timestamp sign_up_end_time = null;
			try {
				sign_up_end_time = java.sql.Timestamp.valueOf(req.getParameter("sign_up_end_time").trim() + ":00");
			} catch (IllegalArgumentException e) {
				sign_up_end_time = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入報名結束時間!");
			}

			Timestamp act_start_time = null;
			try {
				act_start_time = java.sql.Timestamp.valueOf(req.getParameter("act_start_time").trim() + ":00");
			} catch (IllegalArgumentException e) {
				act_start_time = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入活動開始時間!");
			}

			Timestamp act_end_time = null;
			try {
				act_end_time = java.sql.Timestamp.valueOf(req.getParameter("act_end_time").trim() + ":00");
			} catch (IllegalArgumentException e) {
				act_end_time = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入活動結束時間!");
			}

			Act_VO actVO = new Act_VO();
			actVO.setPub_no(pub_no);
			actVO.setAct_name(act_name);
			actVO.setAct_detail(act_detail);
			actVO.setAct_loc(act_loc);
			actVO.setAct_launch_time(act_launch_time);
			actVO.setAct_off_time(act_off_time);
			actVO.setMax_count(max_count);
			actVO.setMin_count(min_count);
			actVO.setSign_up_begin_time(sign_up_begin_time);
			actVO.setSign_up_end_time(sign_up_end_time);
			actVO.setAct_start_time(act_start_time);
			actVO.setAct_end_time(act_end_time);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("actVO", actVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/act/addAct.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			Act_Service actSvc = new Act_Service();
			actVO = actSvc.addAct(pub_no, act_name, act_detail, act_loc, act_launch_time, act_off_time,
					max_count, min_count, sign_up_begin_time, sign_up_end_time, act_start_time, act_end_time);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/act/listAllAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer act_no = Integer.valueOf(req.getParameter("act_no"));

			/*************************** 2.開始刪除資料 ***************************************/
			Act_Service actSvc = new Act_Service();
			actSvc.deleteAct(act_no);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/act/listAllAct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}

}
