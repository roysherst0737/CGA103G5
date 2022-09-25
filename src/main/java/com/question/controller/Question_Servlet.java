package com.question.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.question.model.Question_Service;
import com.question.model.Question_VO;

@WebServlet("/back-end/question/question.do")
public class Question_Servlet extends HttpServlet {

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
			String str = req.getParameter("question_no");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入題目編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/question/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer question_no = null;
			try {
				question_no = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("題目編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/question/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			Question_Service questionSvc = new Question_Service();
			Question_VO questionVO = questionSvc.getOneQuestion(question_no);
			if (questionVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/question/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("questionVO", questionVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/question/listOneQuestion.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer question_no = Integer.valueOf(req.getParameter("question_no"));

			/*************************** 2.開始查詢資料 ****************************************/
			Question_Service questionSvc = new Question_Service();
			Question_VO questionVO = questionSvc.getOneQuestion(question_no);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("questionVO", questionVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/question/update_question_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer question_no = Integer.valueOf(req.getParameter("question_no").trim());

			String que = req.getParameter("que").trim();
			if (que == null || que.trim().length() == 0) {
				errorMsgs.add("問題請勿空白");
			}

			Question_VO questionVO = new Question_VO();
			questionVO.setQuestion_no(question_no);
			questionVO.setQue(que);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("questionVO", questionVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/question/update_question_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			Question_Service questionSvc = new Question_Service();
			questionVO = questionSvc.updateQuestion(que, question_no);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("questionVO", questionVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/question/listOneQuestion.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			String que = req.getParameter("que").trim();
			if (que == null || que.trim().length() == 0) {
				errorMsgs.add("問題請勿空白");
			}

			Question_VO questionVO = new Question_VO();
			questionVO.setQue(que);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("questionVO", questionVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/question/addQuestion.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			Question_Service questionSvc = new Question_Service();
			questionVO = questionSvc.addQuestion(que);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/question/listAllQuestion.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer question_no = Integer.valueOf(req.getParameter("question_no"));

			/*************************** 2.開始刪除資料 ***************************************/
			Question_Service questionSvc = new Question_Service();
			questionSvc.deleteQuestion(question_no);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/question/listAllQuestion.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}

}
