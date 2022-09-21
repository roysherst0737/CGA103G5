package com.filter;


import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "PageFilter", urlPatterns = "/*")
public class PageFilter extends HttpFilter {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//		let path = "http://";
//		let hostname = window.location.host;
//		let pathname = window.location.pathname.substring(0, window.location.pathname.indexOf('/', 2));
//		let script = document.createElement('script')
		final String requestPath = request.getServletPath();
		if (!requestPath.contains(request.getContextPath())
				&& (requestPath.endsWith(".html") || requestPath.endsWith(".css") || requestPath.endsWith(".js"))) {
			request.getRequestDispatcher(requestPath).forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}
}
