package com.cg.project.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.project.beans.UserBean;

@WebServlet("/Detail1Servlet")
public class Detail1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init() throws ServletException {}

	public void destroy() {}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<div align='center'>");
		out.println("<h2>Fill The Information Below</h2>");
		out.println("<form name='LoginForm' action='Detail2Servlet' method='post'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>City:</td>");
		out.println("<td>");
		out.println("<input type='text' name='city'>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>State:");
		out.println("</td>");
		out.println("<td><input type='text' name='state'>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<input type='hidden' name='firstName' value="+firstName+">");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><input type='hidden' name='lastName' value="+lastName+">");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<p>FirstName is:  "+firstName+"</p>"); 
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<p>LastName is:   "+lastName+"</p>"); 
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<table>");
		out.println("<input type='submit' value='SUBMIT'>");
		out.println("</table>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}
}
