package com.pub_booking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.Mem_VO;
import com.pub.entity.Pub;
import com.pub_booking.entity.Pub_Booking;

import static com.pub.service.PubConstants.SERVICE;
@WebServlet("/MemBookingGet")
public class MemBookingGetServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Pub> pubList = SERVICE.getAll();
		List<Pub_Booking> bookList = com.pub_booking.service.Pub_BookingConstants.SERVICE.getMemALL((Integer)((Mem_VO) request.getSession().getAttribute("user")).getMem_no());
		List<String> nameList = new ArrayList<String>();
		Map<Integer, String> namemap = 
				pubList.stream().collect(Collectors.toMap(pub->pub.getPub_no(), pub -> pub.getPub_name()));
		bookList.forEach(e->{
			nameList.add( namemap.get(e.getPub_no()));
		});
		
		request.removeAttribute("pubList");
		request.setAttribute("pubList", pubList);
		request.setAttribute("bookList", bookList);
		request.setAttribute("namemap", namemap);
		request.getRequestDispatcher("/front-end/pages/pub/pubBookCheck.jsp").forward(request, response);
	}

}
