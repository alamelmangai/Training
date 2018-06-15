package com.cg.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Page4Servlet")
public class Page4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {}

	public void destroy() {}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		request.setAttribute("email",email);
		request.setAttribute("phone",phone);
		Cookie [] cookies = request.getCookies();
		String firstName ="" , lastName="" , city="" , state="" ;
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("firstName"))
				firstName =cookie.getValue();
			else if(cookie.getName().equals("lastName"))
				lastName=cookie.getValue();
			else if(cookie.getName().equals("city"))
				city=cookie.getValue();
			else if(cookie.getName().equals("state"))
				state=cookie.getValue();
		}
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<body>");
		writer.println("<div align='center'>");
		writer.println("<h2>YourDetails</h2>");
		writer.println("<table>");
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("<p>FirstName is:  "+firstName+"</p>"); 
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("<p>LastName is:   "+lastName+"</p>"); 
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("<p>City is:  "+city+"</p>"); 
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("<p>State is:   "+state+"</p>"); 
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("<p>PhoneNumber is:  "+phone+"</p>"); 
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("<p>EmailId is:   "+email+"</p>"); 
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("</table>");
		writer.println("</div>");
		writer.println("</body>");
		writer.println("</head>");
		writer.println("</html>");
	}
}
