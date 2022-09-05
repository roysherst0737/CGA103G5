package com.act_pic.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.act_pic.model.Act_pic_Service;
import com.act_pic.model.Act_pic_VO;

@WebServlet("/back-end/act_pic/act_pic.do")
public class Act_pic_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Act_pic_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//			Integer act_pic_no = Integer.valueOf(req.getParameter("act_pic_no"));
			String str = req.getParameter("act_pic_no");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入活動照片編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/act_pic/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer act_pic_no = null;
			try {
				act_pic_no = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("活動照片編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/act_pic/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			Act_pic_Service act_picSvc = new Act_pic_Service();
			Act_pic_VO act_picVO = act_picSvc.getOneAct_pic(act_pic_no);
			if (act_picVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/act_pic/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("act_picVO", act_picVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/act_pic/listOneAct_pic.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer act_pic_no = Integer.valueOf(req.getParameter("act_pic_no"));

			/*************************** 2.開始查詢資料 ****************************************/
			Act_pic_Service act_picSvc = new Act_pic_Service();
			Act_pic_VO act_picVO = act_picSvc.getOneAct_pic(act_pic_no);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("act_picVO", act_picVO); // 資料庫取出的act_picVO物件,存入req
			String url = "/back-end/act_pic/update_act_pic_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_act_pic_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_act_pic_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to send the ErrorPage
			// view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer act_pic_no = Integer.valueOf(req.getParameter("act_pic_no").trim());

			Integer act_no = null;
			try {
				act_no = Integer.valueOf(req.getParameter("act_no").trim());
			} catch (NumberFormatException e) {
				act_no = 0;
				errorMsgs.add("活動編號請填數字");
			}

			// 若要在修改時沒上傳圖片，可以保有原本的圖片，必須要查詢後給值
			Act_pic_Service act_picSvc2 = new Act_pic_Service();
			Act_pic_VO act_picVO2 = act_picSvc2.getOneAct_pic(act_pic_no);

			byte[] act_pic = req.getPart("act_pic").getInputStream().readAllBytes();
			if (act_pic.length == 0) {
				act_pic = act_picVO2.getAct_pic();
			}

			String act_pic_name = req.getParameter("act_pic_name");
			String act_pic_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (act_pic_name == null || act_pic_name.trim().length() == 0) {
				errorMsgs.add("活動照片名稱: 請勿空白");
			} else if (!act_pic_name.trim().matches(act_pic_nameReg)) {
				errorMsgs.add("活動照片名稱: 只能是中、英文字母、數字和底線, 且長度必需在2到10之間");
			}

			Act_pic_VO act_picVO = new Act_pic_VO();
			act_picVO.setAct_pic_no(act_pic_no);
			act_picVO.setAct_no(act_no);
			act_picVO.setAct_pic(act_pic);
			act_picVO.setAct_pic_name(act_pic_name);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("act_picVO", act_picVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/act_pic/update_act_pic_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			Act_pic_Service act_picSvc = new Act_pic_Service();
			act_picVO = act_picSvc.updateAct_pic(act_no, act_pic, act_pic_name, act_pic_no);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("act_picVO", act_picVO);
			String url = "/back-end/act_pic/listOneAct_pic.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("insert".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			Integer act_no = 1;
			if (act_no == 0) {
				errorMsgs.add("活動照片編號最小為1");
			} else {
				try {
					act_no = Integer.valueOf(req.getParameter("act_no").trim());
				} catch (NumberFormatException e) {
					act_no = 1;
					errorMsgs.add("活動編號請填數字");
				}
			}

			byte[] act_pic = req.getPart("act_pic").getInputStream().readAllBytes();
			if (act_pic.length == 0) {
				act_pic = null;
			}

			String act_pic_name = req.getParameter("act_pic_name");
			String act_pic_nameReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (act_pic_name == null || act_pic_name.trim().length() == 0) {
				errorMsgs.add("活動照片名稱: 請勿空白");
			} else if (!act_pic_name.trim().matches(act_pic_nameReg)) {
				errorMsgs.add("活動照片名稱: 只能是中、英文字母、數字和底線, 且長度必需在2到10之間");
			}

			Act_pic_VO act_picVO = new Act_pic_VO();
			act_picVO.setAct_no(act_no);
			act_picVO.setAct_pic(act_pic);
			act_picVO.setAct_pic_name(act_pic_name);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("act_picVO", act_picVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/act_pic/addAct_pic.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			Act_pic_Service act_picSvc = new Act_pic_Service();
			act_picVO = act_picSvc.addAct_pic(act_no, act_pic, act_pic_name);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/act_pic/listAllAct_pic.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("delete".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer act_pic_no = Integer.valueOf(req.getParameter("act_pic_no"));

			/*************************** 2.開始刪除資料 ***************************************/
			Act_pic_Service act_picSvc = new Act_pic_Service();
			act_picSvc.deleteAct_pic(act_pic_no);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/act_pic/listAllAct_pic.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}