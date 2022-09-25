package com.act_sign_up.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.act_sign_up.model.Act_sign_up_Service;
import com.act_sign_up.model.Act_sign_up_VO;

@WebServlet("/front-end/act/my_sign_up.do")
public class Act_sign_up_front_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");



		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer sign_up_no = Integer.valueOf(req.getParameter("sign_up_no"));

			/*************************** 2.開始查詢資料 ****************************************/
			Act_sign_up_Service act_sign_upSvc = new Act_sign_up_Service();
			Act_sign_up_VO act_sign_upVO = act_sign_upSvc.getOneAct_sign_up(sign_up_no);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("act_sign_upVO", act_sign_upVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/act_sign_up/update_act_sign_up_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer sign_up_no = Integer.valueOf(req.getParameter("sign_up_no").trim());

			Integer act_no = null;
			try {
				act_no = Integer.valueOf(req.getParameter("act_no").trim());
			} catch (NumberFormatException e) {
				act_no = 0;
				errorMsgs.add("活動編號請填數字");
			}

			Integer mem_no = null;
			try {
				mem_no = Integer.valueOf(req.getParameter("mem_no").trim());
			} catch (NumberFormatException e) {
				mem_no = 0;
				errorMsgs.add("會員編號請填數字");
			}

			Integer accompany_count = null;
			try {
				accompany_count = Integer.valueOf(req.getParameter("accompany_count").trim());
			} catch (NumberFormatException e) {
				accompany_count = 0;
				errorMsgs.add("攜伴人數請填數字");
			}



			Act_sign_up_VO act_sign_upVO = new Act_sign_up_VO();
			act_sign_upVO.setSign_up_no(sign_up_no);
			act_sign_upVO.setAct_no(act_no);
			act_sign_upVO.setMem_no(mem_no);
			act_sign_upVO.setAccompany_count(accompany_count);


			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("act_sign_upVO", act_sign_upVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/act_sign_up/update_act_sign_up_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			Act_sign_up_Service act_sign_upSvc = new Act_sign_up_Service();
			act_sign_upVO = act_sign_upSvc.updateAct_sign_up(act_no, mem_no, accompany_count, 
					sign_up_no);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("act_sign_upVO", act_sign_upVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/act_sign_up/listOneAct_sign_up.jsp";
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

			Integer mem_no = null;
			try {
				mem_no = Integer.valueOf(req.getParameter("mem_no").trim());
			} catch (NumberFormatException e) {
				mem_no = 0;
				errorMsgs.add("會員編號請填數字");
			}

			Integer accompany_count = null;
			try {
				accompany_count = Integer.valueOf(req.getParameter("accompany_count").trim());
			} catch (NumberFormatException e) {
				accompany_count = 0;
				errorMsgs.add("攜伴人數請填數字");
			}

			Act_sign_up_VO act_sign_upVO = new Act_sign_up_VO();
			act_sign_upVO.setAct_no(act_no);
			act_sign_upVO.setMem_no(mem_no);
			act_sign_upVO.setAccompany_count(accompany_count);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("act_sign_upVO", act_sign_upVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/act_sign_up/addAct_sign_up.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			Act_sign_up_Service act_sign_upSvc = new Act_sign_up_Service();
			act_sign_upVO = act_sign_upSvc.addAct_sign_up(act_no, mem_no, accompany_count);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "act-detail.jsp?" + act_no;		
			res.sendRedirect(url);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer sign_up_no = Integer.valueOf(req.getParameter("sign_up_no"));

			/*************************** 2.開始刪除資料 ***************************************/
			Act_sign_up_Service act_sign_upSvc = new Act_sign_up_Service();
			act_sign_upSvc.deleteAct_sign_up(sign_up_no);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "my_sign_up.jsp";
			res.sendRedirect(url);
		}
	}

}
