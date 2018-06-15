package com.cg.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig config)");
	}


	public void destroy() {
		System.out.println("destroy()");
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service()");
		String userName = request.getParameter("userName");
		String Password = request.getParameter("password");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<body>");
		writer.println("<div  align='center'>");
		writer.println("<p>UserName is:"+userName); 
		writer.println("<p>Password is:"+Password); 
		/*if(userName.equals("sasasasa")&&Password.equals("helloworld")){
			writer.println("<h1 style='color:green'>"); 
			writer.println("WELCOME "+userName+"to your page");	
			writer.println("</h1>");
		}
		else{
			writer.println("<h1 style='color:red'>"); 
			writer.println("incorrect ucerName or Password"+userName);	
			writer.println("</h1>");
		}*/
		writer.println("</div>");
		writer.println("</body>");
		writer.println("</head>");
		writer.println("</html>");
	}
}
