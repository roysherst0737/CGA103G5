package com.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.HibernateUtil;

@WebFilter(urlPatterns = {"/back-end/prod/listAllProd.jsp"})
public class backFilter extends HttpFilter{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
			HttpSession session = req.getSession();
			String mng_account = (String) session.getAttribute("mng");
			System.out.println(mng_account);
			if (mng_account==null) {
				res.sendRedirect("/CGA103G5ALL/back-end/manager_login/mngLogin.jsp");
			}else {
				chain.doFilter(req, res);
			}
	}
}
