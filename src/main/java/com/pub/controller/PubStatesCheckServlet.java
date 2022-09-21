package com.pub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.Mem_VO;
import com.pub.entity.Pub;

import static com.pub.service.PubConstants.SERVICE;
import static com.util.CommonUtil.writePojo2Json;
@WebServlet(urlPatterns = { "/PubStatesCheck","/front-end/PubStatesCheck","*.PubStatesCheck"})
public class PubStatesCheckServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mem_VO mem_VO=(Mem_VO)request.getSession().getAttribute("user");
		Integer mem_no=0;
		if(mem_VO!=null) {
			mem_no=(Integer)((Mem_VO) request.getSession().getAttribute("user")).getMem_no();
		}
		List<Pub> pubList = SERVICE.getMemALL(mem_no);
		Pub pub=new Pub();
		if(pubList.size()>0) {
			pub.setSuccessful(true);
		}else {
			pub.setSuccessful(false);
		}
		writePojo2Json(response, pub);
		return;
	}
}
