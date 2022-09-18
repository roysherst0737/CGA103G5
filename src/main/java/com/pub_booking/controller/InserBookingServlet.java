package com.pub_booking.controller;
import static com.pub_booking.service.Pub_BookingConstants.SERVICE;
import static com.util.CommonUtil.writePojo2Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pub_booking.entity.Pub_Booking;
@WebServlet("/Booking")
public class InserBookingServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		 BufferedReader rd = new BufferedReader(
			        new InputStreamReader(request.getInputStream(), "UTF-8")
			    );
			    String line = null;
			    String message = new String();
			    while ((line = rd.readLine()) != null) {
			        // buffer.append(line);
			        message += line;
			    }
			    //字串處理
			   message= message.replace("{", "");
			   message= message.replace("}", "");
			   message= message.replace("\"", "");
			   Pub_Booking booking=new Pub_Booking();
		Integer mem_no=Integer.parseInt(message.split(",")[0].split(":")[1]);
		Integer pub_no=Integer.parseInt(message.split(",")[1].split(":")[1]);
		Long pub_booking_date=Long.parseLong(message.split(",")[2].split(":")[1]);
		Date date = new Date(pub_booking_date);
		String pub_booking_time=message.split(",")[3].split(":")[1];
		booking.setMem_no(mem_no);
		booking.setPub_no(pub_no);
		booking.setPub_booking_status(1);//1:訂位2:取消
		booking.setPub_booking_time(pub_booking_time);
		booking.setPub_booking_date(date);
		Integer type = SERVICE.InserBooking(booking);
		if(type<1) {
			booking.setMessage("訂位資訊");
			booking.setSuccessful(false);
		}else {
			booking.setMessage("成功");
			booking.setSuccessful(true);
		}
		writePojo2Json(response, booking);
		return;
	}

}
