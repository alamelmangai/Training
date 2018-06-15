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

@WebServlet("/Detail3Servlet")
public class Detail3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServletContext context;
	public void init() throws ServletException {
		context = getServletContext();
	}
	public void destroy() {}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		/*UserBean userBean =(UserBean) context.getAttribute("UserBean");
		userBean.setEmail(request.getParameter("email"));
		userBean.setPhone(request.getParameter("phone"));
		context.setAttribute("UserBean", userBean);*/
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<body>");
		writer.println("<div align='center'>");
		writer.println("<h2>YourDetails</h2>");
		writer.println("<table>");
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
