package com.prod_type.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prod.model.Prod_VO;
import com.prod_type.model.Prod_type_Service;
import com.prod_type.model.Prod_type_VO;

public class Prod_type_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Prod_type_Servlet() {
        super();
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
		
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
	if ("listProds_ByProd_type_no".equals(action)) {

		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer prod_type_no = Integer.valueOf(req.getParameter("prod_type_no"));

			/*************************** 2.開始查詢資料 ****************************************/
			Prod_type_Service prod_typeSvc = new Prod_type_Service();
			Set<Prod_VO> set = prod_typeSvc.getProdsByProd_type_no(prod_type_no);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("listProdsByProd_type_no", set);    // 資料庫取出的list物件,存入request

			String url = null;
			if ("listProds_ByProd_type_no".equals(action))
				url = "back-end/prod/listProds_ByProd_type.jsp";

			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
	}
		
		
		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer prod_type_no = Integer.valueOf(req.getParameter("prod_type_no"));
				
				/***************************2.開始查詢資料*****************************************/
				Prod_type_Service prod_typeSvc = new Prod_type_Service();
				Prod_type_VO prod_typeVO = prod_typeSvc.getOneProd_type(prod_type_no);
				if (prod_typeVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/prod_type/selectProd_type.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("prod_typeVO", prod_typeVO);
				String url = "/back-end/prod_type/listOneProd_type.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}		
		
		if ("getOne_For_Update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer prod_type_no = Integer.valueOf(req.getParameter("prod_type_no"));
				
				/***************************2.開始查詢資料****************************************/
				Prod_type_Service prod_typeSvc = new Prod_type_Service();
				Prod_type_VO prod_typeVO = prod_typeSvc.getOneProd_type(prod_type_no);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("prod_typeVO", prod_typeVO);
				String url = "/back-end/prod_type/updateProd_type.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer prod_type_no = Integer.valueOf(req.getParameter("prod_type_no").trim());
				
				String prod_type_name = req.getParameter("prod_type_name");
				String prod_type_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (prod_type_name == null ||prod_type_name.trim().length() == 0) {
					errorMsgs.add("商品類別名稱: 請勿空白");
				} else if(!prod_type_name.trim().matches(prod_type_nameReg)) {
					errorMsgs.add("商品類別名稱: 只能是中、英文字母、數字和底線, 且長度必需在2到10之間");
	            }
				
				Prod_type_VO prod_typeVO = new Prod_type_VO();
				prod_typeVO.setProd_type_no(prod_type_no);
				prod_typeVO.setProd_type_name(prod_type_name);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("prod_typeVO", prod_typeVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/prod_type/updateProd_type.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				Prod_type_Service prod_typeSvc = new Prod_type_Service();
				prod_typeVO = prod_typeSvc.updateProd_type(prod_type_no, prod_type_name);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("prod_typeVO", prod_typeVO);
				String url = "/back-end/prod_type/listAllProd_type.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}

        if ("insert".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

				String prod_type_name = req.getParameter("prod_type_name");
				String prod_type_nameReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (prod_type_name == null ||prod_type_name.trim().length() == 0) {
					errorMsgs.add("商品類別名稱: 請勿空白");
				} else if(!prod_type_name.trim().matches(prod_type_nameReg)) {
					errorMsgs.add("商品類別名稱: 只能是中、英文字母、數字和底線, 且長度必需在2到10之間");
				}

				Prod_type_VO prod_typeVO = new Prod_type_VO();						
				prod_typeVO.setProd_type_name(prod_type_name);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("prod_typeVO", prod_typeVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/prod_type/addProd_type.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				Prod_type_Service prod_typeSvc = new Prod_type_Service();
				prod_typeVO = prod_typeSvc.addProd_type(prod_type_name);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/prod_type/listAllProd_type.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
		}
        
		
		if ("delete".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer prod_type_no = Integer.valueOf(req.getParameter("prod_type_no"));
				
				/***************************2.開始刪除資料***************************************/
				Prod_type_Service prod_typeSvc = new Prod_type_Service();
				prod_typeSvc.deleteProd_type(prod_type_no);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/prod_type/listAllProd_type.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}