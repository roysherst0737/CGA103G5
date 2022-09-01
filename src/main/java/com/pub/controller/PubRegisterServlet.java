package com.pub.controller;
import static com.util.CommonUtil.json2Pojo;
import static com.util.CommonUtil.writePojo2Json;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pub.model.Pub;
@WebServlet("/PubRegister")
public class PubRegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pub pub = json2Pojo(request, Pub.class);
		if(pub==null) {
			pub = new Pub();
			pub.setMessage("無會員資訊");
			pub.setSuccessful(false);
			writePojo2Json(response, pub);
			return;
		}
//		List<Pub> pubList = SERVICE.getAll();
//		pubList.removeIf(e->e.getPub_status()==false);
//		Set<String> pubAddress = new HashSet<String>() ;
//		pubList.forEach(e->{pubAddress.add(e.getPub_address().substring(0, 3));});
//		request.setAttribute("pubList", pubList);
//		request.setAttribute("pubAddress", pubAddress);
		request.getRequestDispatcher("/front-end/pages/pub/pubStates.jsp").forward(request, response);
	}

}
