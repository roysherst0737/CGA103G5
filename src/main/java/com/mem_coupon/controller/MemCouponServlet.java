package com.mem_coupon.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.mem.model.Mem_VO;
import com.mem_coupon.model.Mem_Coupon_Service;


@WebServlet(urlPatterns = {"/front-end/memcoupon/MemCouponServlet"})
public class MemCouponServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");		
		

		if ("getcoupon".equals(action)) { // 來自listAllEmp.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer coupon_no = Integer.valueOf(req.getParameter("coupon_no"));
				HttpSession session =  req.getSession();
				Mem_VO user = (Mem_VO)session.getAttribute("user");
				/***************************2.開始查詢資料****************************************/
				Mem_Coupon_Service mCouponSvc = new Mem_Coupon_Service();
				mCouponSvc.addCoupon( coupon_no, user.getMem_no(), 1);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				String url = "/CGA103G5ALL/front-end/coupon/couponlist.jsp";
				res.sendRedirect(url);
		}		
	}
}
