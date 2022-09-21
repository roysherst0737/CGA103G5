package com.order.controller;

import java.io.IOException;
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
	}
}
