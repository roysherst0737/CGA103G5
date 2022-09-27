package com.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.model.Manager_VO;

@WebFilter(urlPatterns = { "/back-end/index_back.html","/pub/getlist","/pub/pub_check", "/back-end/prod/listAllProd.jsp", "/back-end/act/listAllAct.jsp",
		"/back-end/act_pic/listAllAct_pic.jsp", "/back-end/act_sign_up/listAllAct_sign_up.jsp",
		"/back-end/firm_survey/listAllFirm_survey.jsp", "/back-end/question/listAllQuestion.jsp", "/back-end/prod/listAllProd.jsp"
		, "/back-end/prod/listAllProd_pic.jsp", "/back-end/prod/listAllProd_type.jsp", "/back-end/prod/listAllOrder.jsp", "/back-end/manager/listAllMng.jsp"
		, "/back-end/manager_auth/listAllMngAuth.jsp", "/back-end/mem/listAllMem.jsp", "/back-end/mem_coupon/mem_coupon_list.jsp", "/back-end/coupon/listAllCoupon.jsp", "/back-end/ans_list/listAllAns_list.jsp"})
public class backFilter extends HttpFilter {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		Manager_VO mng_account = (Manager_VO) session.getAttribute("manager_VO");
//		System.out.println((String) session.getAttribute("mng"));
		if (mng_account == null) {
			
			res.sendRedirect("/CGA103G5ALL/back-end/manager_login/mngLogin.jsp");
		} else {
			chain.doFilter(req, res);
		}
	}
}
