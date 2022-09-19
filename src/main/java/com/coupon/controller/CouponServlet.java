package com.coupon.controller;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.coupon.model.Coupon_Service;
import com.coupon.model.Coupon_VO;


public class CouponServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");		
		
//		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//				String str = req.getParameter("empno");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("請輸入員工編號");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
//				
//				Integer empno = null;
//				try {
//					empno = Integer.valueOf(str);
//				} catch (Exception e) {
//					errorMsgs.add("員工編號格式不正確");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
//				
//				/***************************2.開始查詢資料*****************************************/
//				EmpService empSvc = new EmpService();
//				EmpVO empVO = empSvc.getOneEmp(empno);
//				if (empVO == null) {
//					errorMsgs.add("查無資料");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
//				
//				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
//				req.setAttribute("empVO", empVO); // 資料庫取出的empVO物件,存入req
//				String url = "/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//				successView.forward(req, res);
//		}
//		
//		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer coupon_no = Integer.valueOf(req.getParameter("coupon_no"));
				
				/***************************2.開始查詢資料****************************************/
				Coupon_Service couponSvc = new Coupon_Service();
				Coupon_VO couponVO = couponSvc.getOneCoupon(coupon_no);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("couponVO", couponVO);         // 資料庫取出的empVO物件,存入req
				String url = "/back-end/coupon/update_coupon_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
			
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer coupon_no = Integer.valueOf(req.getParameter("coupon_no").trim());
				
				String coupon_name = req.getParameter("coupon_name");
				String cnameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (coupon_name == null || coupon_name.trim().length() == 0) {
					errorMsgs.add("優惠券名稱: 請勿空白");
				} else if(!coupon_name.trim().matches(cnameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("優惠券名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
						
				String coupon_code = req.getParameter("coupon_code").trim();
				String ccodeReg = "^[(a-zA-Z0-9)]{2,10}$";
				if (coupon_code == null || coupon_code.trim().length() == 0) {
					errorMsgs.add("優惠券代碼: 請勿空白");
				}else if(!coupon_code.trim().matches(ccodeReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("優惠券代碼: 只能是英文字母、數字 , 且長度必需在2到10之間");
	            }
				
				String coupon_content = req.getParameter("coupon_content").trim();
				if (coupon_content == null || coupon_content.trim().length() == 0) {
					errorMsgs.add("優惠券內容請勿空白");
				}	
				
				Double coupon_discount = null;
				try {
					coupon_discount = Double.valueOf(req.getParameter("coupon_discount").trim());
				} catch (NumberFormatException e) {
					coupon_discount = 0.0;
					errorMsgs.add("優惠券折扣請填數字.");
				}
				
				Integer coupon_amount = null;
				try {
					coupon_amount = Integer.valueOf(req.getParameter("coupon_amount").trim());
				} catch (NumberFormatException e) {
					coupon_amount = 0;
					errorMsgs.add("優惠券發放數量請填數字.");
				}
				
				java.sql.Timestamp launch_time = null;

				System.out.println(req.getParameter("launch_time").trim());
				try {
					launch_time = java.sql.Timestamp.valueOf(req.getParameter("launch_time").trim().replace("T", " ")+":00");					
					
				} catch (IllegalArgumentException e) {
					launch_time=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				
				java.sql.Timestamp off_time = null;
				try {
					off_time = java.sql.Timestamp.valueOf(req.getParameter("off_time").trim().replace("T", " ")+":00");
					
				} catch (IllegalArgumentException e) {
					off_time=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				
				Integer status = null;
				try {
					status = Integer.valueOf(req.getParameter("status").trim());
				} catch (NumberFormatException e) {
					status = 0;
					if (status != 0 || status != 1) {
						errorMsgs.add("優惠券狀態請填0或1");
					}
					
				}

				Coupon_VO couponVO = new Coupon_VO();
				couponVO.setCoupon_name(coupon_name);
				couponVO.setCoupon_code(coupon_code);
				couponVO.setCoupon_content(coupon_content);
				couponVO.setCoupon_discount(coupon_discount);
				couponVO.setCoupon_amount(coupon_amount);
				couponVO.setLaunch_time(launch_time);
				couponVO.setOff_time(off_time);
				couponVO.setStatus(status);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("couponVO", couponVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/coupon/update_coupon_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				Coupon_Service couponSvc = new Coupon_Service();
				couponSvc.updateCoupon(coupon_name, coupon_code,  coupon_content
						, coupon_discount, coupon_amount ,  launch_time , off_time 
						, status, coupon_no);				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("couponVO", couponVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/back-end/coupon/listAllCoupon.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}
//
//        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//				String ename = req.getParameter("ename");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (ename == null || ename.trim().length() == 0) {
//					errorMsgs.add("員工姓名: 請勿空白");
//				} else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }
//				
//				String job = req.getParameter("job").trim();
//				if (job == null || job.trim().length() == 0) {
//					errorMsgs.add("職位請勿空白");
//				}
//				
//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}
//				
//				Double sal = null;
//				try {
//					sal = Double.valueOf(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("薪水請填數字.");
//				}
//				
//				Double comm = null;
//				try {
//					comm = Double.valueOf(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("獎金請填數字.");
//				}
//				
//				Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());
//
//				EmpVO empVO = new EmpVO();
//				empVO.setEname(ename);
//				empVO.setJob(job);
//				empVO.setHiredate(hiredate);
//				empVO.setSal(sal);
//				empVO.setComm(comm);
//				empVO.setDeptno(deptno);
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("empVO", empVO); // 含有輸入格式錯誤的empVO物件,也存入req
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/addEmp.jsp");
//					failureView.forward(req, res);
//					return;
//				}
//				
//				/***************************2.開始新增資料***************************************/
//				EmpService empSvc = new EmpService();
//				empVO = empSvc.addEmp(ename, job, hiredate, sal, comm, deptno);
//				
//				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				String url = "/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//				successView.forward(req, res);				
//		}
		
		
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer coupon_no = Integer.valueOf(req.getParameter("coupon_no"));
				
				/***************************2.開始刪除資料***************************************/
				Coupon_Service couponSvc = new Coupon_Service();
				couponSvc.deleteCoupon(coupon_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/coupon/listAllCoupon.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}
