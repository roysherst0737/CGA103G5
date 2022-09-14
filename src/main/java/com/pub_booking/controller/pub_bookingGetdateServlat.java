package com.pub_booking.controller;

import static com.util.CommonUtil.json2Pojo;
import static com.util.CommonUtil.writePojo2Json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.pub_booking.service.Pub_BookingConstants.SERVICE;
import com.pub.entity.Pub;
import com.pub_booking.entity.Pub_Booking;
@WebServlet("/getBookingDate")
public class pub_bookingGetdateServlat extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Pub pub = json2Pojo(request, Pub.class);
		if(pub==null) {
			pub = new Pub();
			pub.setPub_no(Integer.parseInt(request.getParameter("pub_no")));
			pub.setMem_no(Integer.parseInt(request.getParameter("mem_no")));
		}
		Pub_Booking booking= SERVICE.getBooking(pub.getMem_no(), pub.getPub_no());
		if(booking==null) {
			booking = new Pub_Booking();
				pub.setMessage("無定位資訊");
				pub.setSuccessful(true);
				writePojo2Json(response, pub);
				return;
		}
		writePojo2Json(response, booking);
		request.setAttribute("booking", booking);
		return;
	}
}
