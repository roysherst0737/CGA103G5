package com.pub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pub_booking.entity.Pub_Booking;

import static com.pub_booking.service.Pub_BookingConstants.SERVICE;
@WebServlet("/pub/getlist")
public class PubGetAllServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Pub> pubList = SERVICE.getAll();
		List<Pub_Booking> bookList=SERVICE.getAll();
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/back-end/pages/pub/pub_list.jsp").forward(request, response);
	}

}
