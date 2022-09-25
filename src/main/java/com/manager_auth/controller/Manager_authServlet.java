package com.manager_auth.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.manager.model.Manager_Service;
import com.manager.model.Manager_VO;
import com.manager_auth.model.Manager_auth_Service;
import com.manager_auth.model.Manager_auth_VO;
import com.manager_authfunc.model.Manager_authfunc_Service;
import com.manager_authfunc.model.Manager_authfunc_VO;


@WebServlet("/Manager_authServlet")
@MultipartConfig
public class Manager_authServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		req.setCharacterEncoding("UTF-8");
		List<String> errorMsgs = new LinkedList<String>();
		
		if("getOne_For_Display".equals(action)) {
		// 從input hidden 取得
				Integer mng_no = Integer.valueOf(req.getParameter("mng_no"));
				String mng_name = String.valueOf(req.getParameter("mng_name"));

				// 資料庫中目前mng_no有的權限清單
				Manager_auth_Service manager_authSvc = new Manager_auth_Service();
				Manager_Service manager_Svc = new Manager_Service();
				Manager_VO manager_VO = manager_Svc.getOneManager(mng_no);

				List<Manager_auth_VO> list = manager_authSvc.getAuthfunc(mng_no);

				// 刪除所有mng_no的權限
//				manager_authSvc.deleteOneManager_authfunc(mng_no);
				
				// 從checkbox取得勾選的list
				String[] manager_authNos = req.getParameterValues("mng_authfunc_name");
				
				// 查詢現在有沒有
//				for(String manager_auth:manager_authNos) {
//					manager_authSvc.addManager_auth(mng_no, Integer.valueOf(manager_auth));
//				}
				req.setAttribute("manager_VO", manager_VO);
				String url = "/back-end/manager_auth/listAllMngAuth.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交
				successView.forward(req, res);
		}
			
				// 用管理員編號查
				if("getOne_By_Mng_no".equals(action)){
					req.setAttribute("errorMsgs", errorMsgs);
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
					String str = req.getParameter("mng_no");
					if (str == null || (str.trim()).length() == 0) {
						errorMsgs.add("請輸入管理員編號");
					}
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req
								.getRequestDispatcher("/back-end/manager_auth/listOneMngAuth.jsp");
						failureView.forward(req, res);
						return;//程式中斷
					}
					
					Integer mng_no = null;
					try {
						mng_no = Integer.valueOf(str);
					} catch (Exception e) {
						errorMsgs.add("管理員編號格式不正確");
					}
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req
								.getRequestDispatcher("/back-end/manager/listAllMng.jsp");
						failureView.forward(req, res);
						return;//程式中斷
					}
					/*************************** 2.開始查資料 *****************************************/
					Manager_auth_Service manager_authSvc = new Manager_auth_Service();
					Manager_auth_VO manager_auth_VO = manager_authSvc.getOneManager_auth(mng_no);
					if (manager_auth_VO == null) {
						errorMsgs.add("查無資料");
					}
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req
								.getRequestDispatcher("/back-end/manager_auth/listAllMngAuth.jsp");
						failureView.forward(req, res);
						return;//程式中斷
					}
					/*************************** 3.完成,準備轉交(Send the Success view) *************/
					req.setAttribute("manager_auth_VO", manager_auth_VO);
					errorMsgs.clear();
					String url = "/back-end/manager_auth/listOneMngAuth.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功後,轉交
					successView.forward(req, res);
				}	
				
				if ("insert".equals(action)) { // 來自updateMng.jsp的請求
				
						/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
						Integer mng_no = Integer.valueOf(req.getParameter("mng_no").trim());
						Integer mng_authfunc_no = Integer.valueOf(req.getParameter("mng_authfunc_no").trim());
						
						Manager_auth_VO manager_auth_VO = new Manager_auth_VO();

						manager_auth_VO.setMng_no(mng_no);
						manager_auth_VO.setMng_authfunc_no(mng_authfunc_no);
						/***************************2.開始修改資料*****************************************/
						Manager_auth_Service manager_authSvc = new Manager_auth_Service();
						manager_auth_VO = manager_authSvc.updateManager_auth(mng_no, mng_authfunc_no);
						
						/***************************3.修改完成,準備轉交(Send the Success view)*************/
						req.setAttribute("manager_auth_VO", manager_auth_VO); // 資料庫update成功後,正確的的manager_VO物件,存入req
						String url = "/back-end/manager_auth/listAllMngAuth.jsp";
						System.out.println(mng_no);
						System.out.println(mng_authfunc_no);
						RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listAllMng.jsp
						successView.forward(req, res);
				}
				
				if ("delete".equals(action)) { // 來自listAllMng.jsp

					// Store this set in the request scope, in case we need to
					// send the ErrorPage view.
					req.setAttribute("errorMsgs", errorMsgs);
			
						/***************************1.接收請求參數***************************************/
						Integer mng_no = Integer.valueOf(req.getParameter("mng_no"));

						Integer mng_authfunc_no = Integer.valueOf(req.getParameter("mng_authfunc_no"));

						/***************************2.開始刪除資料***************************************/
						Manager_auth_Service manager_authSvc = new Manager_auth_Service();
						manager_authSvc.deleteManager_auth(mng_no, mng_authfunc_no);
						
						/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
						String url = "/back-end/manager_auth/listAllMngAuth.jsp";
						RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
						successView.forward(req, res);
				}
//				if ("insert".equals(action)) {
//				try {
//					/*************************** 1.接收參數 **********************/
//					Integer mng_no = Integer.valueOf(req.getParameter("mng_no"));
//					
//					// 2.開始查詢資料
//					Manager_Service manager_Svc = new Manager_Service();
//					Manager_VO manager_VO = manager_Svc.getOneManager(mng_no);
//
//					// 全部的
//					Manager_authfunc_Service manager_authfuncSvc = new Manager_authfunc_Service();
//					List<Manager_authfunc_VO> auList = manager_authfuncSvc.getAllManager_authfunc();
//					// System.out.println(auList.size());
//					// 會員有的
//					Manager_auth_Service manager_authSvc = new Manager_auth_Service();
//					List<Manager_auth_VO> managerList = manager_authSvc.getAuthfunc(mng_no);
//					// System.out.println(managerList.size());
//
//					Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
//
//					// 會員跑回圈
//					  for (int j = 0; j < managerList.size(); j++) {
//					//   System.out.println(managerAuthVO.getManagerAuthrizationFunctionNo());
//					   // 全部的迴圈
//					   for (int i = 0; i < auList.size(); i++) {
//					    if (managerList.get(j).getMng_authfunc_no()
//					      + 0 == auList.get(i).getMng_authfunc_no() + 0) {
//					     map.put(auList.get(i).getMng_authfunc_no(), 1);
//					    }
//
//					   }
//
//					  }
//					  System.out.println(map);
//					  // 補 0 進去
//					  for (int i = 0; i < auList.size(); i++) {
//					   if (map.get(auList.get(i).getMng_authfunc_no()) == null) {
//					    map.put(auList.get(i).getMng_authfunc_no(), 0);
//					   }
//
//					  }
//					 
//					
//					
//					HttpSession session = req.getSession();
//					req.setAttribute("manager_VO", manager_VO);
//					session.setAttribute("map", map);
//					String url = "/back-end/manager_auth/listAllMngAuth.jsp";
//					// 成功轉交 authManager.jsp
//					RequestDispatcher successView = req.getRequestDispatcher(url);
//					successView.forward(req, res);

					/*************************** 其他可能的錯誤處理 *************************************/
//				} catch (Exception e) {
//					e.printStackTrace();
//					errorMsgs.add("修改資料失敗:" + e.getMessage());
//					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/manager/listAllMng.jsp");
//					failureView.forward(req, res);
//				}
//	}
	}
	
}
