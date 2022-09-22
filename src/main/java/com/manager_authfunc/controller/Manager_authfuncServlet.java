package com.manager_authfunc.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.manager.model.Manager_Service;
import com.manager.model.Manager_VO;
import com.manager_authfunc.model.*;

@WebServlet("/mngAuthFuncServlet")
@MultipartConfig
public class Manager_authfuncServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
//		res.setContentType("image/gif");
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("mng_authfunc_no");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入權限編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/manager_auth/listAllMngAuth.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer mng_authfunc_no = null;
				try {
					mng_authfunc_no = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("權限編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/manager_auth/listAllMngAuth.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				Manager_authfunc_Service manager_authfunc_Svc = new Manager_authfunc_Service();
				Manager_authfunc_VO manager_authfunc_VO = manager_authfunc_Svc.getOneManager_authfunc(mng_authfunc_no);
				if (manager_authfunc_VO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/manager_auth/listAllMngAuth.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("manager_authfunc_VO", manager_authfunc_VO); // 資料庫取出的manager_VO物件,存入req
				String url = "//back-end/manager_auth/listAllMngAuth.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneManager.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllManager.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer mng_authfunc_no = Integer.valueOf(req.getParameter("mng_authfunc_no"));
				
				/***************************2.開始查詢資料****************************************/
				Manager_authfunc_Service manager_authfunc_Svc = new Manager_authfunc_Service();
				Manager_authfunc_VO manager_authfunc_VO = manager_authfunc_Svc.getOneManager_authfunc(mng_authfunc_no);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("manager_authfunc_VO", manager_authfunc_VO);         // 資料庫取出的manager_VO物件,存入req
				String url = "//back-end/manager_auth/listAllMngAuth.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_manager_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_manager_input.jsp的請求
			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html ; charset=UTF-8");
			PrintWriter out = res.getWriter();
			Manager_authfunc_Service manager_authfuncSvc =new Manager_authfunc_Service();
			
			Gson gson = new Gson();
			String json = gson.toJson(manager_authfuncSvc.getAllManager_authfunc());
			out.print(json);
			System.out.println(json);
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer mng_authfunc_no = Integer.valueOf(req.getParameter("mng_authfunc_no").trim());
				
				String mng_authfunc_name = req.getParameter("mng_authfunc_name");
				String mng_authfunc_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (mng_authfunc_name == null || mng_authfunc_name.trim().length() == 0) {
					errorMsgs.add("管理員姓名: 請勿空白");
				} else if(!mng_authfunc_name.trim().matches(mng_authfunc_nameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("管理員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }

				Manager_authfunc_VO manager_authfunc_VO = new Manager_authfunc_VO();
				manager_authfunc_VO.setMng_authfunc_no(mng_authfunc_no);
				manager_authfunc_VO.setMng_authfunc_name(mng_authfunc_name);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("manager_authfunc_VO", manager_authfunc_VO); // 含有輸入格式錯誤的manager_VO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/manager_auth/listAllMngAuth.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				Manager_authfunc_Service manager_authfunc_Svc = new Manager_authfunc_Service();
				manager_authfunc_VO = manager_authfunc_Svc.updateManager_authfunc(mng_authfunc_no,  mng_authfunc_name);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("manager_authfunc_VO", manager_authfunc_VO); // 資料庫update成功後,正確的的manager_VO物件,存入req
				String url = "/back-end/manager_auth/listAllMngAuth.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneManager.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // 來自addManager.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String mng_authfunc_name = req.getParameter("mng_authfunc_name");
				String mng_authfunc_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (mng_authfunc_name == null || mng_authfunc_name.trim().length() == 0) {
					errorMsgs.add("權限名稱: 請勿空白");
				} else if (!mng_authfunc_name.trim().matches(mng_authfunc_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("權限名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}
				List<Manager_authfunc_VO> list = new Manager_authfunc_Service().getAllManager_authfunc();
				for(Manager_authfunc_VO manager_authfunc_VO : list) {
					if(manager_authfunc_VO.getMng_authfunc_name().equals(mng_authfunc_name)) {
						errorMsgs.add("權限名稱: 請勿重複");
					}
				}

				Manager_authfunc_VO manager_authfunc_VO = new Manager_authfunc_VO();
				manager_authfunc_VO.setMng_authfunc_name(mng_authfunc_name);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("manager_authfunc_VO", manager_authfunc_VO); // 含有輸入格式錯誤的manager_VO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/manager_auth/listAllMngAuth.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				Manager_authfunc_Service manager_authfunc_Svc = new Manager_authfunc_Service();
				manager_authfunc_VO = manager_authfunc_Svc.addManager_authfunc(mng_authfunc_name);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/manager_auth/listAllMngAuth.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllManager.jsp
				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { // 來自listAllManager.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer mng_authfunc_no = Integer.valueOf(req.getParameter("mng_authfunc_no"));
				
				/***************************2.開始刪除資料***************************************/
				Manager_authfunc_Service manager_authfunc_Svc = new Manager_authfunc_Service();
				manager_authfunc_Svc.deleteManager_authfunc(mng_authfunc_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/manager_auth/listAllMngAuth.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
	
}
