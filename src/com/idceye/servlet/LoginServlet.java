package com.idceye.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idceye.utils.DBUtil;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String safecode = request.getParameter("safecode");
		
		System.out.println("LoginServlet..."+ username + ", " + password + ", "+ safecode);	
		
		if(!safecode.equalsIgnoreCase( (String)request.getSession().getAttribute("SAFE_CODE") )){
			request.setAttribute("error", "Safe Code is incorrect");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		
		String sql = "select * from users where username = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				//�ж������Ƿ���ȷ
				String pass = rs.getString("password");
				if(!password.equals(pass)){
					//forward��long.jsp��������ʾ���û����벻��ȷ��
					request.setAttribute("error", "�û���"+username+"�������벻��ȷ��������");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					return;
				}
			}else{
				//forward��long.jsp��������ʾ���û��������ڡ�
				request.setAttribute("error", "�û���"+username+"��������");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}		
		
		
		response.sendRedirect(request.getContextPath() + "/main.jsp");
		
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
