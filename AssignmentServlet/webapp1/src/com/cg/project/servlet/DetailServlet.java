package com.cg.project.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {}

	public void destroy() {}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<body>");
		writer.println("<div align='center'>");
		writer.println("<h2>Fill The Information Below</h2>");
		writer.println("<form name='LoginForm' action='Detail2Servlet' method='post'>");
		writer.println("<table>");
		writer.println("<tr>");
		writer.println("<td>City:</td>");
		writer.println("<td>");
		writer.println("<input type='text' name='city'>");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>State:");
		writer.println("</td>");
		writer.println("<td><input type='text' name='state'>");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("<p>FirstName is:  "+fname+"</p>"); 
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("<p>LastName is:   "+lname+"</p>"); 
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("</table>");
		writer.println("<table>");
		writer.println("<input type='submit' value='SUBMIT'>");
		writer.println("</table>");
		writer.println("</form>");
		writer.println("</div>");
		writer.println("</body>");
		writer.println("</head>");
		writer.println("</html>");
	}
}
