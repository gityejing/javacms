package com.idceye.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	private String filterPatten;
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp; 
		
		if(request.getSession().getAttribute("USER_NAME") != null){
			
		}
		
		System.out.println(request.getRequestURI());
		chain.doFilter(request, response);

	}

	public void init(FilterConfig config) throws ServletException {

		filterPatten = (String) config.getInitParameter("filterPatten");

	}

}
