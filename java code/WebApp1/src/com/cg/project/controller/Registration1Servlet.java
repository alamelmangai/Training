package com.cg.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.project.beans.UserBean;


@WebServlet("/Registration1Servlet")
public class Registration1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	public void init(){
		ServletContext servletContext = getServletContext();
		con=(Connection)servletContext.getAttribute("con");
	}

	public void destroy() {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String graduation = request.getParameter("graduation");
		//String description = request.getParameter("description");
		RequestDispatcher dispatcher;	
		UserBean userBean = new UserBean(userName, password, firstName, lastName, address, gender, graduation);


		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt1 = con.prepareStatement("insert into userBean (userName, password, firstName, lastName, address, gender, graduation,description) value(?,?,?,?,?,?,?,?)"); 
			pstmt1.setString(1, userBean.getUserName());
			pstmt1.setString(2, userBean.getPassword());
			pstmt1.setString(3, userBean.getFirstName());
			pstmt1.setString(4, userBean.getLastName());
			pstmt1.setString(5, userBean.getAddress());
			pstmt1.setString(6, userBean.getGender());
			pstmt1.setString(7, userBean.getGraduation());
			//pstmt1.setString(8, userBean.getDescription());
			pstmt1.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}


		dispatcher = request.getRequestDispatcher("loginPage.html");
		request.setAttribute("userBean",userBean);
		dispatcher.forward(request, response);
		/*}
					else{
						dispatcher = request.getRequestDispatcher("errorPage.jsp");
						request.setAttribute("errorMessage","password is wrong");
						dispatcher.forward(request, response);
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
}

