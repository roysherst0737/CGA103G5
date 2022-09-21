package com.mem.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.mem.model.Mem_Service;
import com.mem.model.Mem_VO;

@WebServlet(urlPatterns = {"/back-end/mem/changeMemStatus"})
public class changeMemStatus extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");		
		
		if ("enable_status".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer mem_no = Integer.valueOf(req.getParameter("mem_no"));
				
				/***************************2.開始刪除資料***************************************/
				Mem_Service memSvc = new Mem_Service();
				memSvc.enable_status(mem_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/mem/listAllMem.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
		
		
		if ("unable_status".equals(action)) { // 來自listAllEmp.jsp
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數***************************************/
			Integer mem_no = Integer.valueOf(req.getParameter("mem_no"));
			
			/***************************2.開始刪除資料***************************************/
			Mem_Service memSvc = new Mem_Service();
			memSvc.unable_status(mem_no);
			
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
			String url = "/back-end/mem/listAllMem.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
