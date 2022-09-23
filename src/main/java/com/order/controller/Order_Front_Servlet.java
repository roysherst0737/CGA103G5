package com.order.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cart.model.Cart_Service;
import com.order.model.Order_Service;
import com.order.model.Order_VO;
import com.order_detail.model.Order_detail_Service;
import com.order_detail.model.Order_detail_VO;

@WebServlet("/front-end/prod/detail.do")
public class Order_Front_Servlet extends HttpServlet {
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
			req.setAttribute("listFrontOrder_details", set); // 資料庫取出的list物件,存入request
			String url = "/front-end/prod/orderDetail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("createOrder".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			Integer mem_no = Integer.valueOf(req.getParameter("mem_no").trim());
			String receiver_name = req.getParameter("receiver_name");
			String receiver_phone = req.getParameter("receiver_phone");
			Integer pickup_method = Integer.valueOf(req.getParameter("pickup_method").trim());
			String receiver_address = req.getParameter("receiver_address");
			Integer payment_method = Integer.valueOf(req.getParameter("payment_method").trim());
			Integer order_price_total = Integer.valueOf(req.getParameter("order_price_total").trim());
			Integer dis_price_total = Integer.valueOf(req.getParameter("dis_price_total").trim());
			Integer shipping_fee = 0;

			Order_VO orderVO = new Order_VO();
			orderVO.setMem_no(mem_no);
			orderVO.setOrder_price_total(order_price_total);
			orderVO.setDis_price_total(dis_price_total);
			orderVO.setPayment_method(payment_method);
			orderVO.setPickup_method(pickup_method);
			orderVO.setShipping_fee(shipping_fee);
			orderVO.setReceiver_name(receiver_name);
			orderVO.setReceiver_address(receiver_address);
			orderVO.setReceiver_phone(receiver_phone);
			
			Integer prod_qty = null;
			try {
				prod_qty = Integer.valueOf(req.getParameter("prod_qty").trim());
			} catch (Exception e) {
				prod_qty = 0;
				errorMsgs.add("請先選購商品後再結帳");
			}			
			Integer prod_price = null;
			try {
				prod_price = Integer.valueOf(req.getParameter("prod_price").trim());
			} catch (Exception e) {
				prod_price = 0;
				errorMsgs.add("請先選購商品後再結帳");
			}
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("orderVO", orderVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/prod/checkout.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}

			/*************************** 2.開始新增資料 ***************************************/
			Order_Service orderSvc = new Order_Service();
			orderVO = orderSvc.addOrder(mem_no, order_price_total, dis_price_total, payment_method, pickup_method,
					shipping_fee, receiver_name, receiver_address, receiver_phone);

			Set<Integer> set = orderSvc.getCreateOrder(mem_no);
			

			int[] int2 = new int[set.size()];
			int i = 0;

			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				int2[i++] = (int) iter.next();
			}
			
			Arrays.sort(int2);
			

//			Integer prod_no = Integer.valueOf(req.getParameter("prod_no").trim());
			Integer prodAmount = (int)Integer.valueOf(req.getParameter("prodAmount").trim());
			
			int[] prod_no = new int[prodAmount];
			for (int j = 0; j < prodAmount; j++) {
				prod_no[j] = Integer.valueOf(req.getParameter("prod_no" + (j + 1)).trim());
			}
			

			Order_detail_Service order_detailSvc = new Order_detail_Service();
			
			for (int k = 0; k < prodAmount; k++) {
			order_detailSvc.addOrder_detail(int2[set.size() - 1], prod_no[k], prod_qty, prod_price, mem_no);
			}
			
			Cart_Service cartSvc = new Cart_Service();
			cartSvc.deleteCartByMem(mem_no);
			
			

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/

			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(payment_method == 1) {
				String url = "creditCardPay.jsp";
				res.sendRedirect(url);				
			} else {
				String url = "orderHistory.jsp";
				res.sendRedirect(url);				
			}
			
		}

		if ("cancelOrder".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to send the ErrorPage
			// view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer order_no = Integer.valueOf(req.getParameter("order_no").trim());

			Integer order_status = 3;

			Order_VO orderVO = new Order_VO();
			orderVO.setOrder_no(order_no);
			orderVO.setOrder_status(order_status);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("orderVO", orderVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/order/changeOrderStatus.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			Order_Service orderSvc = new Order_Service();
			orderVO = orderSvc.changeStatus(order_no, order_status);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("orderVO", orderVO);
			String url = "/front-end/prod/orderHistory.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
	}
}
