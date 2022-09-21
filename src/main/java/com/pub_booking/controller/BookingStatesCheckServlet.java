package com.pub_booking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.Mem_VO;
import com.pub.entity.Pub;

import static com.util.CommonUtil.writePojo2Json;
@WebServlet(urlPatterns = { "*.BookingStatesCheck"})
public class BookingStatesCheckServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mem_VO mem_VO=(Mem_VO)request.getSession().getAttribute("user");
		Pub pub=new Pub();
		if(mem_VO!=null) {
			pub.setSuccessful(true);
			
		}else {
			pub.setSuccessful(false);
			}
		writePojo2Json(response, pub);
		return;
	}
}
