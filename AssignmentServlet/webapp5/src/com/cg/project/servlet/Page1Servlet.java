package com.cg.project.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Page1Servlet")
public class Page1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {}

	public void destroy() {}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<body>");
		writer.println("<div align='center'>");
		writer.println("<h2>LoginPage</h2>");
		writer.println("<form name='LoginForm' action='Page2Servlet' method='post'>");
		writer.println("<table>");
		writer.println("<tr>");
		writer.println("<td>FirstName:</td>");
		writer.println("<td>");
		writer.println("<input type='text' name='firstName'>");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>LastName:");
		writer.println("</td>");
		writer.println("<td><input type='text' name='lastName'>");
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
