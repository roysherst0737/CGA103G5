package com.filter;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(filterName = "PageFilter", urlPatterns = "/*")
public class PageFilter extends HttpFilter {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		final String requestPath = request.getServletPath();
		System.out.println(requestPath);
		System.out.println(request.getContextPath());
		if (!requestPath.contains(request.getContextPath())
				&& (requestPath.endsWith(".html") || requestPath.endsWith(".css") || requestPath.endsWith(".js")|| requestPath.endsWith(".png")|| requestPath.endsWith(".jpg"))) {
			request.getRequestDispatcher(requestPath).forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}
}
