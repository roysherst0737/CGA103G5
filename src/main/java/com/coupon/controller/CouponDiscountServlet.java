package com.coupon.controller;

import static com.util.CommonUtil.json2Pojo;
import static com.util.CommonUtil.writePojo2Json;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.coupon.model.Coupon_Service;
import com.coupon.model.Coupon_VO;

@WebServlet(urlPatterns = {"/Discount","/front-end/prod/Discount"})
public class CouponDiscountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		Coupon_VO couponVO = new Coupon_VO();
		couponVO = json2Pojo(req, Coupon_VO.class);
		Coupon_Service couponSvc = new Coupon_Service();		
//		couponVO.setCoupon_code(req.getParameter("discount"));
		couponVO = couponSvc.getCouponDiscount(couponVO.getCoupon_code());
		writePojo2Json(res, couponVO);		
	}
}
