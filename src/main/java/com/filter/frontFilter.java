package com.filter;

import static com.util.CommonUtil.writePojo2Json;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mem.model.Mem_VO;
import com.pub.entity.Pub;

@WebFilter(urlPatterns = { "/PubApplication", "/PubBooking", "/PubRate", "/PubStates", "/front-end/mem/my-account.jsp",
		"/front-end/mem/memApplication.jsp", "/front-end/prod/orderHistory.jsp", "/MemBookingGet",
		"/front-end/act/my_sign_up.jsp", "/front-end/act/survey.jsp", "/front-end/act/writesurvey.jsp" })

public class frontFilter extends HttpFilter {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = req.getSession();

		Mem_VO user_account = (Mem_VO) session.getAttribute("user");

		if (user_account == null) {

			Mem_VO mem_account = (Mem_VO) session.getAttribute("user");

			if (mem_account == null) {
				// 針對鎖定畫面功能做特殊處理(rate)
				if (req.getServletPath().endsWith("PubRate")) {
					Pub pub = new Pub();
					pub.setSuccessful(false);
					writePojo2Json(res, pub);
					return;
				}
				res.sendRedirect("/CGA103G5ALL/front-end/mem/login.jsp");
			} else {
				chain.doFilter(req, res);
			}
		} else {
			chain.doFilter(req, res);
		}
	}
}
