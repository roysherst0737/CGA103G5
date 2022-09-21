package com.order.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.model.Order_Service;
import com.order_detail.model.Order_detail_VO;
import com.prod.model.Prod_Service;
import com.prod.model.Prod_VO;

@WebServlet("/front-end/prod/detail.do")
public class Order_Front_Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("listFrontOrder_details".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

				/*************************** 1.接收請求參數 ****************************************/
				Integer order_no = Integer.valueOf(req.getParameter("order_no"));

				/*************************** 2.開始查詢資料 ****************************************/
				Order_Service orderSvc = new Order_Service();
				Set<Order_detail_VO> set = orderSvc.getOrder_detailsByOrder(order_no);

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("listFrontOrder_details", set);    // 資料庫取出的list物件,存入request
				String url = "/front-end/prod/orderDetail.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}
		
		if ("createOrder".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

			Integer prod_type_no = 1;
			if (prod_type_no == 0) {
				errorMsgs.add("商品類別編號最小為1");
			} else {
				try {
					prod_type_no = Integer.valueOf(req.getParameter("prod_type_no").trim());
				} catch (NumberFormatException e) {
					prod_type_no = 1;
					errorMsgs.add("商品類別編號請填數字");
				}
			}
					
			String prod_name = req.getParameter("prod_name");
			String prod_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (prod_name == null ||prod_name.trim().length() == 0) {
				errorMsgs.add("商品名稱: 請勿空白");
			} else if(!prod_name.trim().matches(prod_nameReg)) {
				errorMsgs.add("商品名稱: 只能是中、英文字母、數字和底線, 且長度必需在2到10之間");
            }
			
			Integer prod_price = null;
			try {
				prod_price = Integer.valueOf(req.getParameter("prod_price").trim());
			} catch (NumberFormatException e) {
				prod_price = 0;
				errorMsgs.add("商品單價請填數字.");
			}
			
			Integer prod_stock = null;
			try {
				prod_stock = Integer.valueOf(req.getParameter("prod_stock").trim());
			} catch (NumberFormatException e) {
				prod_stock = 0;
				errorMsgs.add("商品庫存請填數字.");
			}
			
			Timestamp off_time = null;
			try {
				off_time = java.sql.Timestamp.valueOf(req.getParameter("off_time").trim());
			} catch (IllegalArgumentException e) {
				off_time = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入下架時間.");
			}
			
			String prod_detail = req.getParameter("prod_detail");
			String prod_detailReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{10,200}$";
			if (prod_detail == null ||prod_detail.trim().length() == 0) {
				errorMsgs.add("商品敘述: 請勿空白");
			} else if(!prod_detail.trim().matches(prod_detailReg)) {
				errorMsgs.add("商品敘述: 只能是中、英文字母、數字和底線, 且長度必需在20到200之間");
            }

				Prod_VO prodVO = new Prod_VO();
				prodVO.setProd_type_no(prod_type_no);
				prodVO.setProd_name(prod_name);
				prodVO.setProd_price(prod_price);
				prodVO.setProd_stock(prod_stock);
				prodVO.setOff_time(off_time);
				prodVO.setProd_detail(prod_detail);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("prodVO", prodVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/prod/addProd.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				Prod_Service prodSvc = new Prod_Service();
				prodVO = prodSvc.addProd(prod_type_no, prod_name, prod_price, prod_stock, off_time, prod_detail);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/prod/listAllProd.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}
	}
}
