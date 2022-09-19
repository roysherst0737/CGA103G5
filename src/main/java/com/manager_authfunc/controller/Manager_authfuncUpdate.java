package com.manager_authfunc.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.manager_authfunc.model.*;

@WebServlet("/mngAuthFuncUpdate")
@MultipartConfig
public class Manager_authfuncUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接資料
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Manager_authfunc_Service manager_authfuncSvc = new Manager_authfunc_Service();
		
		Gson gson = new Gson();
		String json = gson.toJson(manager_authfuncSvc.getAllManager_authfunc());
		out.print(json);
		System.out.println(json);
		
		//
		
		List<String> errorMsgs = new LinkedList<String>();
		// 存放錯誤訊息 以防我們需要丟出錯誤訊息到頁面
		request.setAttribute("errorMsgs", errorMsgs);

		try {
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			//種類編號
			Integer mng_authfunc_no = null;
			try {
				mng_authfunc_no = Integer.valueOf(request.getParameter("mng_authfunc_no").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("編號需為數字");
			}
			// 種類名稱
			Manager_authfunc_VO manager_authfunc_VO = new Manager_authfunc_VO();
			String mng_authfunc_name = request.getParameter("mng_authfunc_name");
			String mng_authfunc_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_:)(\\-\\)]{1,30}$";
			if (mng_authfunc_name == null || mng_authfunc_name.trim().length() == 0) {
				errorMsgs.add("名稱: 請勿空白");
			} else if (!mng_authfunc_name.trim().matches(mng_authfunc_nameReg)) {
				errorMsgs.add("名稱: 只能包含中文、英文大小寫、數字和底線及冒號 , 且長度須在1到30之間");
			}
			System.out.println(mng_authfunc_name);

			// 將取得資料裝入 bidProductVO 物件
			manager_authfunc_VO.setMng_authfunc_no(mng_authfunc_no);
			manager_authfunc_VO.setMng_authfunc_name(mng_authfunc_name);

			// 回傳錯誤訊息
			if (!errorMsgs.isEmpty()) {
				request.setAttribute("manager_authfunc_VO", manager_authfunc_VO);
				RequestDispatcher failureView = request.getRequestDispatcher("/back-end/manager_authfunc/updateMngAuthfunc.jsp");
				failureView.forward(request, response);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			Manager_authfunc_Service manager_authfunc_Service2 =new Manager_authfunc_Service();
			manager_authfunc_Service2.updateManager_authfunc(mng_authfunc_no, mng_authfunc_name);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			request.setAttribute("manager_authfunc_VO", manager_authfunc_VO); // 資料庫update成功後,正確的的bidProductVO物件,存入request
			String url = "/back-end/manager_authfunc/getAllMngAuthfuc.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url); // 修改成功後,轉交listOneBid.jsp
			successView.forward(request, response);

			/*************************** 其他可能的錯誤處理 *************************************/
		} catch (Exception e) {
			e.printStackTrace();
			errorMsgs.add("修改資料失敗:" + e.getMessage());
			RequestDispatcher failureView = request.getRequestDispatcher("/back-end/manager_authfunc/updateMngAuthfunc.jsp");
			failureView.forward(request, response);
		}
		

	}

}
