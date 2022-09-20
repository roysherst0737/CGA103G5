package com.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.HibernateUtil;

@WebFilter("/pub/pub_check")
public class backFilter extends HttpFilter{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
			System.out.println("back");
			String mng_account = req.getParameter("mng");
			System.out.println(mng_account);
			if (mng_account==null) {
				res.sendRedirect("/CGA103G5ALL/back-end/manager_login/mngLogin.jsp");
			}
			chain.doFilter(req, res);
	}
}
