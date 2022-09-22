package com.pub_booking.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.mem.model.Mem_Service;
import com.mem.model.Mem_VO;
import com.pub.entity.Pub;
import com.pub_booking.entity.Pub_Booking;

import static com.pub_booking.service.Pub_BookingConstants.SERVICE;
import static com.util.CommonUtil.json2Pojo;
import static com.util.CommonUtil.writePojo2Json;
@WebServlet(urlPatterns = {"/getNameByMem","/front-end/pages/pub/getNameByMem"})
public class MemByNameServlet extends HttpServlet{
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
		    Set<String> set = new HashSet<String>();
		    List<String> list= Arrays.asList(message.split(","));
		    set.addAll(list);
		    System.out.println(set);
		    Mem_Service mem_svc = new Mem_Service();
		    List<String> nameList=new ArrayList<String>();
		    set.forEach(e->{
		    	Mem_VO vo= mem_svc.getOneMem(Integer.parseInt(e));
		    	nameList.add(vo.getMem_no()+"-"+vo.getMem_last_name()+vo.getMem_first_name());
		    	});
//		Map<Integer,String> nameList = null;
		writePojo2Json(response, nameList);
		return;
	}

}

