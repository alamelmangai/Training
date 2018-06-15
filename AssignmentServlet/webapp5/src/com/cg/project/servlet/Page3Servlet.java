package com.cg.project.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Page3Servlet")
public class Page3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;   
	
	public void init() throws ServletException {
		context = getServletContext();
	}

	public void destroy() {}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		request.setAttribute("city",city);
		request.setAttribute("state",state);
		Cookie c1 = new  Cookie("city",city);
		Cookie c2 = new Cookie("state" ,state);
		response.addCookie(c1);
		response.addCookie(c2);
		Cookie [] cookies = request.getCookies();
		String firstName ="" , lastName="";
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("firstName"))
				firstName =cookie.getValue();
			else if(cookie.getName().equals("lastName"))
				lastName=cookie.getValue();
		}
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<body>");
		writer.println("<div align='center'>");
		writer.println("<h2>Fill The Information Below</h2>");
		writer.println("<form name='LoginForm' action='Page4Servlet' method='post'>");
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
