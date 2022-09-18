package com.cart.controller;

import java.io.IOException;
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
		
		// 刪除購物車中的商品
//		if (action.equals("DELETE")) {
//			String del = req.getParameter("del");
//			int d = Integer.parseInt(del);
//			cartlist.remove(d);
//		}
		// 新增商品至購物車中
		if (action.equals("ADD")) {
			// 取得後來新增的商品
//			Integer mem_no = Integer.valueOf(req.getParameter("mem_no").trim());
//			Integer prod_no = Integer.valueOf(req.getParameter("prod_no").trim());
//			Integer prod_qty = Integer.valueOf(req.getParameter("prod_qty").trim());
			
			Cart_VO cartVO = new Cart_VO();			
			cartVO.setMem_no(2);
			cartVO.setProd_no(2);
			cartVO.setProd_qty(2);
			
			Cart_Service cartSvc = new Cart_Service();
			cartVO = cartSvc.addCart(2, 2, 2);
//			if (cartlist == null) {
//				cartlist = new Vector<Cart_VO>();
//				cartlist.add(cartVO);
//			} else {
//				if (cartlist.contains(cartVO)) {
//					Cart_VO innerProd = cartlist.get(cartlist.indexOf(cartVO));
//					innerProd.setProd_qty(innerProd.getProd_qty() + cartVO.getProd_qty());
//				} else {
//					cartlist.add(cartVO);
//				}
//			}
		}

//		req.setAttribute("cart", cartlist);
		String url = "/front-end/prod/shop.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, res);
	}
}