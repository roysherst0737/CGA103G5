package com.pub_rank.controller;
import static com.pub_rank.service.PubRankConstants.SERVICE;
import static com.util.CommonUtil.json2Pojo;
import static com.util.CommonUtil.writePojo2Json;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.Mem_VO;
import com.pub_rank.entity.Pub_Rank;
@WebServlet("/PubRate")
public class PubInserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Pub_Rank pub_Rank = json2Pojo(request, Pub_Rank.class);
		if(pub_Rank==null) {
			pub_Rank = new Pub_Rank();
			pub_Rank.setMessage("上傳評分錯誤");
			pub_Rank.setSuccessful(false);
			writePojo2Json(response, pub_Rank);
			return;
		}
		pub_Rank.setMem_no((Integer)((Mem_VO) request.getSession().getAttribute("user")).getMem_no());
		pub_Rank = SERVICE.setRate(pub_Rank);
		System.out.println(pub_Rank.getMessage());
		System.out.println(pub_Rank.getSuccessful());
		writePojo2Json(response, pub_Rank);
		return;
	}

}
