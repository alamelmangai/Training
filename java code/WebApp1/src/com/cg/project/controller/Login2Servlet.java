package com.cg.project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.cg.project.beans.UserBean;

@WebServlet("/Login2Servlet")
public class Login2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con;
	public void init() {
		ServletContext servletContext = getServletContext();
		con=(Connection)servletContext.getAttribute("con");
	}
	
	public void destroy() {}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			RequestDispatcher dispatcher;
			UserBean userBean = new UserBean(userName,password);
			PreparedStatement pstmt = con.prepareStatement("select password from UserBean where userName=?"); 
			pstmt.setString(1, userBean.getUserName());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("password").equals(userBean.getPassword())){
					dispatcher = request.getRequestDispatcher("successPage.jsp");
					 request.setAttribute("userBean",userBean);
					dispatcher.forward(request, response);	
				}
				else{
					dispatcher = request.getRequestDispatcher("errorPage.jsp");
					request.setAttribute("errorMessage","password is wrong");
					dispatcher.forward(request, response);
				}
			
			}
			else{
				dispatcher = request.getRequestDispatcher("errorPage.jsp");
				request.setAttribute("errorMessage","password or userName is wrong try Later!!!");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
