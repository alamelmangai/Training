package com.cg.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig config)");
		}

		
		public void destroy() {
			System.out.println("destroy()");
		}
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("service()");
			String fname = request.getParameter("firstName");
			String lname = request.getParameter("lastName");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String username = request.getParameter("userName");
			String password = request.getParameter("password");
			String rpassword = request.getParameter("rPassword");
			String gradu = request.getParameter("graduation");
			String []cmode = request.getParameterValues("communicationMode");
			String descrip = request.getParameter("description");
			PrintWriter writer = response.getWriter();
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<body>");
			writer.println("<div >");
			writer.println("<p>FirstName is:"+fname+"</p>"); 
			writer.println("<p>LastName is:"+lname); 
			writer.println("<p>Gender is:"+gender);
			writer.println("<p>Address is:"+address);
			writer.println("<p>UserName is:"+username); 
			writer.println("<p>Password is is:"+password);
			writer.println("<p>Re-Entered Password is is:"+rpassword);
			writer.println("<p>Graduation is:"+gradu);
			writer.println("<p>About Yourself :"+descrip);
			writer.println("<p>Mode Of Communication is:"); 
			for(int i=0;i<cmode.length;i++)
			writer.println(" "+cmode[i]);
			writer.println("</div>");
			writer.println("</body>");
			writer.println("</head>");
			writer.println("</html>");
		}
	}
