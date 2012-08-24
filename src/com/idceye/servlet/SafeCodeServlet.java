package com.idceye.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SafeCodeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int size;
	private String codes;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		size = Integer.parseInt( this.getServletConfig().getInitParameter("size") );
		codes = this.getServletConfig().getInitParameter("codes");
		
		Random rd = new Random();
		String allCodes = "";
		for(int i = 0; i<size; i++){
			
			int index = rd.nextInt(codes.length());
			String currentCode = String.valueOf( codes.charAt(index) );
			allCodes += currentCode;
		}
		
		request.getSession().setAttribute("SAFE_CODE", allCodes);
		System.out.println("SafeCodeServlet..." + allCodes);
		out.print(allCodes);		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
