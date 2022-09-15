package com.pub.controller;
import static com.util.CommonUtil.json2Pojo;
import static com.util.CommonUtil.writePojo2Json;
import static com.pub.service.PubConstants.SERVICE;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pub.entity.Pub;
@WebServlet("/pub/PubUpdate")
public class PubUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Pub pub = json2Pojo(request, Pub.class);
		if(pub==null) {
			pub = new Pub();
			pub.setMessage("無會員資訊");
			pub.setSuccessful(false);
			writePojo2Json(response, pub);
			return;
		}
		pub = SERVICE.update(pub);
		System.out.println(pub.getMessage());
		System.out.println(pub.getSuccessful());
		writePojo2Json(response, pub);
//		List<Pub> pubList = SERVICE.getAll();
//		pubList.removeIf(e->e.getPub_status()==false);
//		Set<String> pubAddress = new HashSet<String>() ;
//		pubList.forEach(e->{pubAddress.add(e.getPub_address().substring(0, 3));});
//		request.setAttribute("pubList", pubList);
//		request.setAttribute("pubAddress", pubAddress);
//		request.getRequestDispatcher("/front-end/pages/pub/pubStates.jsp").forward(request, response);
	}

}
