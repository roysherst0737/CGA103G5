package com.manager.controller;

import static com.util.CommonUtil.writePojo2Json;

import java.io.*;
import java.sql.*;
import java.util.Base64;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.manager.model.Manager_VO;
@WebServlet("*.ManagerImage2")
public class ManagerImage2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Manager_VO mng_vo = (Manager_VO) session.getAttribute("manager_VO");
		MyVO myVO= new MyVO();
		if(mng_vo!=null) {
			myVO.setMng_name(mng_vo.getMng_name());
			System.out.println(mng_vo.getMng_no());
			myVO.setBase64("data:image/jpeg;base64,"+Base64.getEncoder().encodeToString( mng_vo.getMng_pic()));
		}else {
			myVO.setBase64(null);
			myVO.setMng_name(null);
		}
		writePojo2Json(response, myVO);
	}
}
class MyVO extends Manager_VO{
	String base64;

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}
	
}