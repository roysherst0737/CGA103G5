package com.pub_booking.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.Mem_Service;
import com.mem.model.Mem_VO;
import com.pub.entity.Pub;
import com.pub_booking.entity.Pub_Booking;

import static com.pub_booking.service.Pub_BookingConstants.SERVICE;
import static com.util.CommonUtil.json2Pojo;
@WebServlet("/lookbooking")
public class lookBookingGetServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Pub pub = new Pub();
		pub.setPub_no(Integer.parseInt(request.getParameter("pub_no")));
		pub = com.pub.service.PubConstants.SERVICE.findByPrimaryKey(pub);
		request.setAttribute("pub", pub);
		request.getRequestDispatcher("/front-end/pages/pub/lookbooking.jsp").forward(request, response);
//		response.sendRedirect("front-end/pages/pub/lookbooking.jsp");
		return;
	}

}
