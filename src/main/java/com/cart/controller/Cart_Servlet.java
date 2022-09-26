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
import com.prod.model.Prod_Service;
import com.prod.model.Prod_VO;

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
			
			Integer prod_stock = Integer.valueOf(req.getParameter("prod_stock").trim()); 
			Prod_VO prodVO = new Prod_VO();
			prodVO.setProd_stock(prod_stock);

			/*************************** 2.開始新增資料 ***************************************/
			Cart_Service cartSvc = new Cart_Service();
			cartVO = cartSvc.addCart(mem_no, prod_no, prod_qty);
			
			Prod_Service prodSvc = new Prod_Service();
			prod_stock = prodSvc.stockMinus(prod_no);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			
			Integer url = Integer.valueOf(req.getParameter("url").trim());
			
			Integer prod_stock = Integer.valueOf(req.getParameter("prod_stock").trim()); 
			Prod_VO prodVO = new Prod_VO();
			prodVO.setProd_stock(prod_stock);

			/*************************** 2.開始新增資料 ***************************************/
			Cart_Service cartSvc = new Cart_Service();
			cartVO = cartSvc.addCart(mem_no, prod_no, prod_qty);
			
			Prod_Service prodSvc = new Prod_Service();
			prod_stock = prodSvc.stockMinus(prod_no);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String toUrl = "shopByType.jsp?" + url;		
			res.sendRedirect(toUrl);
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

			Integer prod_stock = Integer.valueOf(req.getParameter("prod_stock").trim()); 
			Prod_VO prodVO = new Prod_VO();
			prodVO.setProd_stock(prod_stock);

			/*************************** 2.開始新增資料 ***************************************/
			Cart_Service cartSvc = new Cart_Service();
			cartVO = cartSvc.addCart(mem_no, prod_no, prod_qty);
			
			Prod_Service prodSvc = new Prod_Service();
			prod_stock = prodSvc.stockMinus(prod_no);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url = "shop-detail.jsp?" + prod_no;		
			res.sendRedirect(url);
		}
		
		if ("cartPlus".equals(action)) {
			
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
			
			Integer prod_qty = Integer.valueOf(req.getParameter("prod_qty").trim());			

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

			Integer prod_stock = Integer.valueOf(req.getParameter("prod_stock").trim()); 
			Prod_VO prodVO = new Prod_VO();
			prodVO.setProd_stock(prod_stock);

			/*************************** 2.開始新增資料 ***************************************/
			Cart_Service cartSvc = new Cart_Service();
			cartVO = cartSvc.addCart(mem_no, prod_no, prod_qty);
			
			Prod_Service prodSvc = new Prod_Service();
			prod_stock = prodSvc.stockMinus(prod_no);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "cart.jsp";		
			res.sendRedirect(url);
		}
		
		if ("cartMinus".equals(action)) {
			
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
			
			Integer prod_qty = Integer.valueOf(req.getParameter("prod_qty").trim());			

			Cart_VO cartVO = new Cart_VO();			
			cartVO.setMem_no(mem_no);
			cartVO.setProd_no(prod_no);
			cartVO.setProd_qty(prod_qty);
			
			if (prod_qty == 1) {
				Integer prod_stock = Integer.valueOf(req.getParameter("prod_stock").trim()); 
				Prod_VO prodVO = new Prod_VO();
				prodVO.setProd_stock(prod_stock);
				Prod_Service prodSvc = new Prod_Service();
				prod_stock = prodSvc.stockPlus(prod_no);
				Cart_Service cartSvc = new Cart_Service();
				cartSvc.deleteCartByProd(prod_no);
			} else {
				Integer prod_stock = Integer.valueOf(req.getParameter("prod_stock").trim()); 
				Prod_VO prodVO = new Prod_VO();
				prodVO.setProd_stock(prod_stock);
				/*************************** 2.開始新增資料 ***************************************/
				Cart_Service cartSvc = new Cart_Service();
				cartVO = cartSvc.minusCart(mem_no, prod_no, prod_qty);
				Prod_Service prodSvc = new Prod_Service();
				prod_stock = prodSvc.stockPlus(prod_no);
				
			}

			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				req.setAttribute("cartVO", cartVO); // 含有輸入格式錯誤的empVO物件,也存入req
//				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/prod/shop.jsp");
//				failureView.forward(req, res);
//				return;
//			}
			
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "cart.jsp";		
			res.sendRedirect(url);
		}
		
		if ("checkoutPlus".equals(action)) {
			
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
			
			Integer prod_qty = Integer.valueOf(req.getParameter("prod_qty").trim());			

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

			Integer prod_stock = Integer.valueOf(req.getParameter("prod_stock").trim()); 
			Prod_VO prodVO = new Prod_VO();
			prodVO.setProd_stock(prod_stock);

			/*************************** 2.開始新增資料 ***************************************/
			Cart_Service cartSvc = new Cart_Service();
			cartVO = cartSvc.addCart(mem_no, prod_no, prod_qty);
			
			Prod_Service prodSvc = new Prod_Service();
			prod_stock = prodSvc.stockMinus(prod_no);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "checkout.jsp";		
			res.sendRedirect(url);
		}
		
		if ("checkoutMinus".equals(action)) {
			
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
			
			Integer prod_qty = Integer.valueOf(req.getParameter("prod_qty").trim());			

			Cart_VO cartVO = new Cart_VO();			
			cartVO.setMem_no(mem_no);
			cartVO.setProd_no(prod_no);
			cartVO.setProd_qty(prod_qty);
			
			if (prod_qty == 1) {
				Integer prod_stock = Integer.valueOf(req.getParameter("prod_stock").trim()); 
				Prod_VO prodVO = new Prod_VO();
				prodVO.setProd_stock(prod_stock);
				Prod_Service prodSvc = new Prod_Service();
				prod_stock = prodSvc.stockPlus(prod_no);
				Cart_Service cartSvc = new Cart_Service();
				cartSvc.deleteCartByProd(prod_no);
			} else {
				Integer prod_stock = Integer.valueOf(req.getParameter("prod_stock").trim()); 
				Prod_VO prodVO = new Prod_VO();
				prodVO.setProd_stock(prod_stock);
				/*************************** 2.開始新增資料 ***************************************/
				Cart_Service cartSvc = new Cart_Service();
				cartVO = cartSvc.minusCart(mem_no, prod_no, prod_qty);
				
				Prod_Service prodSvc = new Prod_Service();
				prod_stock = prodSvc.stockPlus(prod_no);
				
			}

//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				req.setAttribute("cartVO", cartVO); // 含有輸入格式錯誤的empVO物件,也存入req
//				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/prod/shop.jsp");
//				failureView.forward(req, res);
//				return;
//			}
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "checkout.jsp";		
			res.sendRedirect(url);
		}
		
		if ("deleteOne".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer prod_no = Integer.valueOf(req.getParameter("prod_no"));
				
				/***************************增加商品庫存***************************************/
				Integer prod_qty = Integer.valueOf(req.getParameter("prod_qty"));
				Integer prod_stock = Integer.valueOf(req.getParameter("prod_stock"));
				Prod_VO prodVO = new Prod_VO();
				Prod_Service prodSvc = new Prod_Service();
				prodVO = prodSvc.stockUpdateWhenCartClear(prod_no, prod_stock+prod_qty);
				prodVO.setProd_no(prod_no);
				prodVO.setProd_stock(prod_stock+prod_qty);
				System.out.println(prod_stock+prod_qty);
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
				
				/***************************清空購物車時把庫存加回***************************************/
				
				String prod_no = (req.getParameter("prod_no_int"));
				String[] prod_no_array = prod_no.split(",");
				int[] prod_no_Final = new int[prod_no_array.length];
				for(int i = 0;i<prod_no_array.length;i++){
					prod_no_Final[i] = Integer.parseInt(prod_no_array[i]);
					System.out.println("a"+prod_no_Final[i]);
				}
				String prod_qty = (req.getParameter("prod_qty_int"));
				String[] prod_qty_array = prod_qty.split(",");
				int[] prod_qty_Final = new int[prod_qty_array.length];
				for(int i = 0;i<prod_qty_array.length;i++){
					prod_qty_Final[i] = Integer.parseInt(prod_qty_array[i]);
					System.out.println("b"+prod_qty_Final[i]);
				}
				String prod_stock = (req.getParameter("prod_stock_int"));
				String[] prod_stock_array = prod_stock.split(",");
				int[] prod_stock_Final = new int[prod_stock_array.length];
				for(int i = 0;i<prod_stock_array.length;i++){
					prod_stock_Final[i] = Integer.parseInt(prod_stock_array[i]);
					System.out.println("c"+prod_stock_Final[i]);
				}
				Prod_Service prodSvc = new Prod_Service();
				for(int i = 0;i<prod_stock_array.length;i++){
				prodSvc.stockUpdateWhenCartClear(prod_no_Final[i], prod_stock_Final[i]+prod_qty_Final[i]);
				}
				
				/***************************2.開始刪除資料***************************************/
				Cart_Service cartSvc = new Cart_Service();
				cartSvc.deleteCartByMem(mem_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "cart.jsp";		
				res.sendRedirect(url);
		}
	}
}