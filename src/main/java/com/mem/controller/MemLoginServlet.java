package com.mem.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mem.model.Mem_Service;
import com.mem.model.Mem_VO;

public class MemLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Login = request.getParameter("Login");
		HttpSession session = request.getSession();
		if ("Mem_Login".equals(Login)) { // 來自select_page.jsp的請求

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			request.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String mem_account = request.getParameter("mem_account");
				String mem_password = request.getParameter("mem_password");
				if (mem_account == null || (mem_account.trim()).length() == 0) {
					errorMsgs.put("mem_account","請輸入會員帳號");
				}
				if (mem_password == null || (mem_password.trim()).length() == 0) {
					errorMsgs.put("mem_password","請輸入會員密碼");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request
							.getRequestDispatcher("/front-end/mem/login.jsp");
					failureView.forward(request, response);
					return;//程式中斷
				}
				
				
				/***************************2.開始查詢資料*****************************************/
				Mem_Service memSvc = new Mem_Service();
//				Mem_VO memVO = memSvc.getOneMem(mem_no);
				Mem_VO user = memSvc.loginMem(mem_account, mem_password);
				if (user == null ) {
					errorMsgs.put("mem_no","查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request
							.getRequestDispatcher("/front-end/mem/login.jsp");
					failureView.forward(request, response);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				session.setAttribute("user",user );
				String url = (String) session.getAttribute("url");
				response.sendRedirect(url);

		}
	}
}

////FindByNameServlet
//public class FindByNameServlet extends HttpServlet {
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String name = request.getParameter("name");
//
//		UserService userService = new UserServiceImpl();
//		User user = userService.findByName(name);
//
////將查詢結果放入request作用域
//		request.setAttribute("userInfo", user);
//		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
//	}
//}
//
////LoginServlet
//public class LoginServlet extends HttpServlet {
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
////1 獲取
//		String userName = request.getParameter("userName");
//		String password = request.getParameter("password");
//
////2 service呼叫dao對資料庫操作
//		UserService userService = new UserServiceImpl();
//		int result = userService.login(userName, password);
//
////3 成功跳轉到查詢頁面，失敗跳轉到失敗頁面
//		if (result > 0) {
//			response.sendRedirect("/jsp/index.jsp");
//		} else {
//			response.sendRedirect("/login_error.html");
//		}
//	}
//}
//
////RegisterServlet
//public class RegisterServlet extends HttpServlet {
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		UserService userService = new UserServiceImpl();
//		User user = null;
//		int result = 0;
////1【呼叫請求物件】讀取【請求頭】引數資訊，得到使用者註冊資訊
//		String userName, password, age;
//		userName = request.getParameter("userName");
//		password = request.getParameter("password");
//		age = request.getParameter("age");
//		user = new User(userName, password, Integer.valueOf(age));
////2 呼叫userService——>userDao
//// 先查詢使用者是否存在
//		User byName = userService.findByName(userName);
//		if (byName != null) {
//			request.setAttribute("info", "使用者已存在！");
//			request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
//		}
//// 註冊
//		result = userService.register(user);
//
////3 設定編碼格式，防止亂碼
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//
////註冊成功：——>跳轉至登入頁面進行登入
////註冊失敗：——>註冊頁面提示：註冊失敗
//		if (result == 1) {
//			response.sendRedirect("/login.html");
//		} else {
//			request.setAttribute("info", "註冊失敗！");
//			request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
//		}
//	}
//}