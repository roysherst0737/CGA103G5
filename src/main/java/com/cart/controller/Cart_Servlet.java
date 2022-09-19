package com.cart.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.model.*;

public class Cart_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("insert".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			Integer mem_no = null;
			try {
				mem_no = Integer.valueOf(req.getParameter("mem_no").trim());
			} catch (NumberFormatException e) {
				mem_no = 0;
				errorMsgs.add("會員編號請填數字");
			}

			Integer prod_no = null;
			try {
				prod_no = Integer.valueOf(req.getParameter("prod_no").trim());
			} catch (NumberFormatException e) {
				prod_no = 0;
				errorMsgs.add("商品編號請填數字");
			}
			
			Integer prod_qty = 1;			

			Cart_VO cartVO = new Cart_VO();			
			cartVO.setMem_no(mem_no);
			cartVO.setProd_no(prod_no);
			cartVO.setProd_qty(prod_qty);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("cartVO", cartVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/prod/shop.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			Cart_Service cartSvc = new Cart_Service();
			cartVO = cartSvc.addCart(mem_no, prod_no, prod_qty);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "shop.jsp";		
			res.sendRedirect(url);
		}
		
		if ("insertByType".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			Integer mem_no = null;
			try {
				mem_no = Integer.valueOf(req.getParameter("mem_no").trim());
			} catch (NumberFormatException e) {
				mem_no = 0;
				errorMsgs.add("會員編號請填數字");
			}

			Integer prod_no = null;
			try {
				prod_no = Integer.valueOf(req.getParameter("prod_no").trim());
			} catch (NumberFormatException e) {
				prod_no = 0;
				errorMsgs.add("商品編號請填數字");
			}
			
			Integer prod_qty = 1;			

			Cart_VO cartVO = new Cart_VO();			
			cartVO.setMem_no(mem_no);
			cartVO.setProd_no(prod_no);
			cartVO.setProd_qty(prod_qty);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("cartVO", cartVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/prod/shop.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			Cart_Service cartSvc = new Cart_Service();
			cartVO = cartSvc.addCart(mem_no, prod_no, prod_qty);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "shopByType.jsp?" + 1;		
			res.sendRedirect(url);
		}
		
		if ("insertByDetail".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			Integer mem_no = null;
			try {
				mem_no = Integer.valueOf(req.getParameter("mem_no").trim());
			} catch (NumberFormatException e) {
				mem_no = 0;
				errorMsgs.add("會員編號請填數字");
			}

			Integer prod_no = null;
			try {
				prod_no = Integer.valueOf(req.getParameter("prod_no").trim());
			} catch (NumberFormatException e) {
				prod_no = 0;
				errorMsgs.add("商品編號請填數字");
			}
			
			Integer prod_qty = 1;			

			Cart_VO cartVO = new Cart_VO();			
			cartVO.setMem_no(mem_no);
			cartVO.setProd_no(prod_no);
			cartVO.setProd_qty(prod_qty);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("cartVO", cartVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/prod/shop.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			Cart_Service cartSvc = new Cart_Service();
			cartVO = cartSvc.addCart(mem_no, prod_no, prod_qty);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "shop-detail.jsp?" + prod_no;		
			res.sendRedirect(url);
		}
		
		if ("deleteOne".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer prod_no = Integer.valueOf(req.getParameter("prod_no"));
				
				/***************************2.開始刪除資料***************************************/
				Cart_Service cartSvc = new Cart_Service();
				cartSvc.deleteCartByProd(prod_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "cart.jsp";		
				res.sendRedirect(url);
		}
		
		if ("deleteOneWhenCheckout".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer prod_no = Integer.valueOf(req.getParameter("prod_no"));
				
				/***************************2.開始刪除資料***************************************/
				Cart_Service cartSvc = new Cart_Service();
				cartSvc.deleteCartByProd(prod_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "checkout.jsp";		
				res.sendRedirect(url);
		}
		
		if ("deleteAll".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer mem_no = Integer.valueOf(req.getParameter("mem_no"));
				
				/***************************2.開始刪除資料***************************************/
				Cart_Service cartSvc = new Cart_Service();
				cartSvc.deleteCartByMem(mem_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "cart.jsp";		
				res.sendRedirect(url);
		}
	}
}