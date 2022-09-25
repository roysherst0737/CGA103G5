package com.forum.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.forum.model.*;

@WebServlet("/back-end/forum/forum1.do")
public class Forum1_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer frm_no = Integer.valueOf(req.getParameter("frm_no").trim());
				
			String frm_name_no = req.getParameter("frm_name_no");
				String frm_name_noReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (frm_name_no == null || frm_name_no.trim().length() == 0) {
					errorMsgs.add("討論區名稱: 請勿空白");
				} else if(!frm_name_no.trim().matches(frm_name_noReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("討論區名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
			Integer frm_status = Integer.valueOf(req.getParameter("frm_status").trim());
			
//			byte[] frm_img = req.getPart("frm_img").getInputStream().readAllBytes();      
//			if(frm_img.length==0) {
//				frm_img = null;
//			}	
			
				Forum_VO forum_VO = new Forum_VO();
				forum_VO.setFrm_no(frm_no);
				forum_VO.setFrm_name_no(frm_name_no);
				forum_VO.setFrm_status(frm_status);
//				forum_VO.setFrm_img(frm_img);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("forum_VO", forum_VO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/forum/update_forum_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				Forum_Service forum_Svc = new Forum_Service();
				forum_VO = forum_Svc.updateForum(frm_no, frm_name_no, frm_status);	
				System.out.println(forum_VO);
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("forum_VO", forum_VO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/back-end/forum/listOneForum.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}

	}
}
