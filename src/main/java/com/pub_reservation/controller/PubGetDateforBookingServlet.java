package com.pub_reservation.controller;
import static com.pub_reservation.service.Pub_ReservationConstants.SERVICE;
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

import com.pub_reservation.entity.Pub_Reservation;
@WebServlet("/PubGetDateforBooking")
public class PubGetDateforBookingServlet extends HttpServlet{
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
		Long LongDay = Long.parseLong(message.split(",")[1].split(":")[1]);
		Date day = new Date(LongDay);
		Integer pub_no=Integer.parseInt(message.split(",")[0].split(":")[1]);
		Pub_Reservation pub_Reservation=SERVICE.getReservation(pub_no, day);
		
		pub_Reservation.setMessage("ok");
		pub_Reservation.setSuccessful(true);
		writePojo2Json(response, pub_Reservation);
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
		
		
//		Pub_Reservation_Service reservationService = com.pub_reservation.service.Pub_ReservationConstants.SERVICE; 
//		List<Pub_Reservation> list = reservationService.getListByPubNo(pub.getPub_no());
//		Long LongDay = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
//		Date today = new Date(LongDay);
//		request.setAttribute("pub", pub);
//		request.setAttribute("today", today);
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("/front-end/pages/pub/pubbooking.jsp").forward(request, response);
		return;
	}

}
