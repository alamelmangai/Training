package com.cg.project.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cg.project.beans.UserBean;

@WebServlet("/Detail2Servlet")
public class Detail2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {}

	public void destroy() {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		/*UserBean userBean =(UserBean) request.getAttribute("UserBean");
		userBean.setCity(request.getParameter("city"));
		userBean.setState(request.getParameter("state"));
		request.setAttribute("UserBean", userBean);*/
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<body>");
		writer.println("<div align='center'>");
		writer.println("<h2>Fill The Information Below</h2>");
		writer.println("<form name='LoginForm' action='Detail3Servlet' method='post'>");
		writer.println("<table>");
		writer.println("<tr>");
		writer.println("<td>PhoneNumber:</td>");
		writer.println("<td>");
		writer.println("<input type='text' name='phone'>");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>E-Mail:");
		writer.println("</td>");
		writer.println("<td><input type='text' name='email'>");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("<input type='hidden' name='firstName' value="+fname+">");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td><input type='hidden' name='lastName' value="+lname+">");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("<input type='hidden' name='city' value="+city+">");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("</td>");
		writer.println("<td><input type='hidden' name='state' value="+state+">");
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
