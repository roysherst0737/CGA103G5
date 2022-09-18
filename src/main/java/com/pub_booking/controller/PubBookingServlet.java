package com.pub_booking.controller;
import static com.pub.service.PubConstants.SERVICE;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pub.entity.Pub;
import com.pub_reservation.entity.Pub_Reservation;
import com.pub_reservation.service.Pub_Reservation_Service;
@WebServlet("/PubBooking")
public class PubBookingServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Pub pub = new Pub();
		pub.setPub_no(Integer.parseInt(request.getParameter("pub_no")));
		pub = SERVICE.findByPrimaryKey(pub);
		if(pub.getPub_name()==null) {
			pub.setMessage("無會員資訊");
			pub.setSuccessful(false);
		}else {
			pub.setMessage("成功");
			pub.setSuccessful(true);
		}
		
//		ExclusionStrategy strategy = new ExclusionStrategy() {
//		    @Override
//		    public boolean shouldSkipClass(Class<?> clazz) {
//		        return false;
//		    }
//		    @Override
//		    public boolean shouldSkipField(FieldAttributes field) {
//		        return field.getName().startsWith("pub_1");
//		    }
//
//		};
//		Gson gson = new GsonBuilder()
//				  .addSerializationExclusionStrategy(strategy)
//				  .create();
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType(JSON_MIME_TYPE);
//		try (PrintWriter pw = response.getWriter()) {
//			pw.print(gson.toJson(pub));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Pub_Reservation_Service reservationService = com.pub_reservation.service.Pub_ReservationConstants.SERVICE; 
		List<Pub_Reservation> list = reservationService.getListByPubNo(pub.getPub_no());
		Long LongDay = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
		Date today = new Date(LongDay);
		request.setAttribute("pub", pub);
		request.setAttribute("today", today);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/front-end/pages/pub/pubbooking.jsp").forward(request, response);
		return;
	}

}
