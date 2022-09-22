package com.order_detail.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order_detail.model.Order_detail_Service;
import com.order_detail.model.Order_detail_VO;

@WebServlet("/front-end/prod/detailFinal.do")
public class Order_detail_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("createDetail".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
								
//			Integer order_no = Integer.valueOf(req.getParameter("order_no").trim());
			Integer order_no = 4;
			Integer prod_no = Integer.valueOf(req.getParameter("prod_no").trim());
			Integer prod_qty = Integer.valueOf(req.getParameter("prod_qty").trim());
			Integer prod_price = Integer.valueOf(req.getParameter("prod_price").trim());
			Integer mem_no = Integer.valueOf(req.getParameter("mem_no").trim());

			Order_detail_VO order_detailVO = new Order_detail_VO();
			
			order_detailVO.setOrder_no(order_no);
			order_detailVO.setProd_no(prod_no);
			order_detailVO.setProd_qty(prod_qty);
			order_detailVO.setProd_price(prod_price);
			order_detailVO.setMem_no(mem_no);
				
			/***************************2.開始新增資料***************************************/
			Order_detail_Service order_detailSvc = new Order_detail_Service();
			order_detailVO = order_detailSvc.addOrder_detail(order_no, prod_no, prod_qty, prod_price, mem_no);
				
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url = "orderHistory.jsp";		
			res.sendRedirect(url);
			
			System.out.println(mem_no);
			System.out.println(order_no);
			System.out.println(prod_no);
			System.out.println(prod_qty);
			System.out.println(prod_price);
		}
	}	
}
