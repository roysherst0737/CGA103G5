//package com.filter;
//
//import static com.util.Constants.PREFIX_WEB_INF;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebFilter("/*")
//public class PageFilter extends HttpFilter {
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//		final String requestPath = request.getServletPath();
//		if (!requestPath.contains(PREFIX_WEB_INF)
//				&& (requestPath.endsWith(".html") || requestPath.endsWith(".css") || requestPath.endsWith(".js"))) {
//			request.getRequestDispatcher(PREFIX_WEB_INF + requestPath).forward(request, response);
//		} else {
//			chain.doFilter(request, response);
//		}
//	}
//}
