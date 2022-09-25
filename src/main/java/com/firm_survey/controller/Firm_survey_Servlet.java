package com.firm_survey.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firm_survey.model.Firm_survey_Service;
import com.firm_survey.model.Firm_survey_VO;

@WebServlet("/back-end/firm_survey/firm_survey.do")
public class Firm_survey_Servlet extends HttpServlet {

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
			String str = req.getParameter("firm_survey_no");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入廠商問卷編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/firm_survey/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer firm_survey_no = null;
			try {
				firm_survey_no = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("廠商問卷編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/firm_survey/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			Firm_survey_Service firm_surveySvc = new Firm_survey_Service();
			Firm_survey_VO firm_surveyVO = firm_surveySvc.getOneFirm_survey(firm_survey_no);
			if (firm_surveyVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/firm_survey/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("firm_surveyVO", firm_surveyVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/firm_survey/listOneFirm_survey.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer firm_survey_no = Integer.valueOf(req.getParameter("firm_survey_no"));

			/*************************** 2.開始查詢資料 ****************************************/
			Firm_survey_Service firm_surveySvc = new Firm_survey_Service();
			Firm_survey_VO firm_surveyVO = firm_surveySvc.getOneFirm_survey(firm_survey_no);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("firm_surveyVO", firm_surveyVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/firm_survey/update_firm_survey_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer firm_survey_no = Integer.valueOf(req.getParameter("firm_survey_no").trim());

			Integer act_no = null;
			try {
				act_no = Integer.valueOf(req.getParameter("act_no").trim());
			} catch (NumberFormatException e) {
				act_no = 0;
				errorMsgs.add("活動編號請填數字");
			}

			java.sql.Timestamp survey_build_time = java.sql.Timestamp
					.valueOf(req.getParameter("survey_build_time").trim());

			java.sql.Timestamp survey_revise_time = new java.sql.Timestamp(System.currentTimeMillis());

			Firm_survey_VO firm_surveyVO = new Firm_survey_VO();
			firm_surveyVO.setFirm_survey_no(firm_survey_no);
			firm_surveyVO.setAct_no(act_no);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("firm_surveyVO", firm_surveyVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/firm_survey/update_firm_survey_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			Firm_survey_Service firm_surveySvc = new Firm_survey_Service();
			firm_surveyVO = firm_surveySvc.updateFirm_survey(act_no, firm_survey_no);

			firm_surveyVO.setSurvey_build_time(survey_build_time);
			firm_surveyVO.setSurvey_revise_time(survey_revise_time);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("firm_surveyVO", firm_surveyVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/firm_survey/listOneFirm_survey.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			Integer act_no = null;
			try {
				act_no = Integer.valueOf(req.getParameter("act_no").trim());
			} catch (NumberFormatException e) {
				act_no = 0;
				errorMsgs.add("活動編號請填數字");
			}

			Firm_survey_VO firm_surveyVO = new Firm_survey_VO();
			firm_surveyVO.setAct_no(act_no);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("firm_surveyVO", firm_surveyVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/firm_survey/addFirm_survey.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/

			Firm_survey_Service firm_surveySvc = new Firm_survey_Service();
			firm_surveyVO = firm_surveySvc.addFirm_survey(act_no);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/firm_survey/listAllFirm_survey.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer firm_survey_no = Integer.valueOf(req.getParameter("firm_survey_no"));

			/*************************** 2.開始刪除資料 ***************************************/
			Firm_survey_Service firm_surveySvc = new Firm_survey_Service();
			firm_surveySvc.deleteFirm_survey(firm_survey_no);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/firm_survey/listAllFirm_survey.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}

}
