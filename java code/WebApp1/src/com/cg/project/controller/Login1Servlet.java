package com.cg.project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.cg.project.beans.UserBean;

@WebServlet("/Login1Servlet")
public class Login1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void init(ServletConfig config) throws ServletException {}
	
	public void destroy() {}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		RequestDispatcher dispatcher;
		 UserBean userBean = new UserBean(userName,password);
		 
		 if(userBean.getUserName().equals("alamel")&&userBean.getPassword().equals("Chinnu")){
			 dispatcher = request.getRequestDispatcher("SuccessServlet");
			 request.setAttribute("userBean",userBean);
			dispatcher.forward(request, response);
			/* response.setHeader("Content-Encoding", "gzip");
			 //response.setHeader("Content-Type", "pdf");
			 response.setHeader("Conte-Type", "application/pdf");
			// response.setContentType("application/pdf");
			 File file = new File("D:\\SCWCD.pdf");
			 FileInputStream src =new FileInputStream(file);
			 byte  [] buffer = new byte[(int)file.length()];
			 src.read(buffer);
			 ServletOutputStream out = response.getOutputStream();
			// out.write(buffer); 
*/		 }
		 else{
			 dispatcher = request.getRequestDispatcher("ErrorServlet");
			 request.setAttribute("errorMessage","UserName or Password mismatch please try again!!!");
			 dispatcher.forward(request, response);
			 
		 }
	}

}
