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
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.RequestContext;

import com.cg.project.beans.UserBean;

@WebServlet("/Detail1Servlet")
public class Detail1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
	}

	public void destroy() {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		UserBean userBean = new UserBean(fname, lname);
		HttpSession session = request.getSession();
		session.setAttribute("UserBean", userBean);
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
		out.println("<p>FirstName is:  "+userBean.getFirstName()+"</p>"); 
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<p>LastName is:   "+userBean.getLastName()+"</p>"); 
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
