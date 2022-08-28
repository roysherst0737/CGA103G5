package com.prod.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prod.model.Prod_Service;
import com.prod.model.Prod_VO;

@WebServlet("/Prod_Servlet")
@MultipartConfig
public class Prod_Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("prod_no");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入商品編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/prod/selectProd.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer prod_no = null;
				try {
					prod_no = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("商品編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/prod/selectProd.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				Prod_Service prodSvc = new Prod_Service();
				Prod_VO prodVO = prodSvc.getOneProd(prod_no);
				if (prodVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/prod/selectProd.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("prodVO", prodVO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/prod/listOneProd.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}		
		
		if ("getOne_For_Update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer prod_no = Integer.valueOf(req.getParameter("prod_no"));
				
				/***************************2.開始查詢資料****************************************/
				Prod_Service prodSvc = new Prod_Service();
				Prod_VO prodVO = prodSvc.getOneProd(prod_no);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("prodVO", prodVO);         // 資料庫取出的prod_picVO物件,存入req
				String url = "/back-end/prod/updateProd.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_prod_pic_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_prod_pic_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer prod_pic_no = Integer.valueOf(req.getParameter("prod_no").trim());
				
				Integer prod_no = null;
				try {
					prod_no = Integer.valueOf(req.getParameter("prod_no").trim());
				} catch (NumberFormatException e) {
					prod_no = 0;
					errorMsgs.add("商品編號請填數字");
				}	
						
				String prod_name = req.getParameter("prod_pic_name");
				String prod_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (prod_name == null ||prod_name.trim().length() == 0) {
					errorMsgs.add("商品照片名稱: 請勿空白");
				} else if(!prod_name.trim().matches(prod_nameReg)) {
					errorMsgs.add("商品照片名稱: 只能是中、英文字母、數字和底線, 且長度必需在2到10之間");
	            }

				Prod_VO prodVO = new Prod_VO();
				prodVO.setProd_no(prod_pic_no);
				prodVO.setProd_name(prod_no);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("prodVO", prodVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/prod_pic/updateProd.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				ProdService prodSvc = new Prod_Service();
				prodVO = prodSvc.updateProd(prod_no, prod_no, prod_pic, prod_pic_name);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("prod_picVO", prod_picVO);
				String url = "/back-end/prod_pic/listAllProd_pic.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}

        if ("insert".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				Integer prod_no = 1;
				if (prod_no == 0) {
					errorMsgs.add("商品照片編號最小為1");
				} else {
					try {
						prod_no = Integer.valueOf(req.getParameter("prod_no").trim());
					} catch (NumberFormatException e) {
						prod_no = 1;
						errorMsgs.add("商品編號請填數字");
					}
				}
						        		
				byte[] prod_pic = null;      
				try {
					prod_pic = req.getPart("prod_pic").getInputStream().readAllBytes();
				} catch (Exception e) {
					errorMsgs.add("請上傳正確格式的檔案");
					System.out.println(prod_pic);
				}

				String prod_pic_name = req.getParameter("prod_pic_name");
				String prod_pic_nameReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (prod_pic_name == null ||prod_pic_name.trim().length() == 0) {
					errorMsgs.add("商品照片名稱: 請勿空白");
				} else if(!prod_pic_name.trim().matches(prod_pic_nameReg)) {
					errorMsgs.add("商品照片名稱: 只能是中、英文字母、數字和底線, 且長度必需在2到10之間");
				}

				Prod_pic_VO prod_picVO = new Prod_pic_VO();
				prod_picVO.setProd_no(prod_no);				
				prod_picVO.setProd_pic(prod_pic);						
				prod_picVO.setProd_pic_name(prod_pic_name);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("prod_picVO", prod_picVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/prod_pic/addProd_pic.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				Prod_pic_Service prod_picSvc = new Prod_pic_Service();
				prod_picVO = prod_picSvc.addProd_pic(prod_no, prod_pic, prod_pic_name);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/prod_pic/listAllProd_pic.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}
        
		
		if ("delete".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer prod_pic_no = Integer.valueOf(req.getParameter("prod_pic_no"));
				
				/***************************2.開始刪除資料***************************************/
				Prod_pic_Service prod_picSvc = new Prod_pic_Service();
				prod_picSvc.deleteProd_pic(prod_pic_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/prod_pic/listAllProd_pic.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}