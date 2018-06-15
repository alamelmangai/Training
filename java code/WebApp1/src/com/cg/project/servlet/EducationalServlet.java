package com.cg.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EducationalServlet")
public class EducationalServlet extends HttpServlet {
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
			String sname = request.getParameter("schoolName");
			String perc = request.getParameter("percentage");
			String pic = request.getParameter("pic");
			String file = request.getParameter("file");
			String grade = request.getParameter("grade");
			String sname2 = request.getParameter("schoolName");
			String perc2 = request.getParameter("percentage2");
			String grade2 = request.getParameter("grade2");
			String qual3 = request.getParameter("qualification3");
			String sname3 = request.getParameter("instituteName3");
			String perc3 = request.getParameter("percentage3");
			String grade3 = request.getParameter("grade3");
			String qual4 = request.getParameter("qualification4");
			String sname4 = request.getParameter("instituteName4");
			String perc4 = request.getParameter("percentage4");
			String grade4 = request.getParameter("grade4");
			PrintWriter writer = response.getWriter();
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<body>");
			writer.println("<div >");
			writer.println("<p>FirstName is:"+fname+"</p>"); 
			writer.println("<p>LastName is:"+lname); 
			writer.println("<br />");
			writer.println("<p>Your 10th Details are");
			writer.println("<p>SchoolName is:"+sname+" Percentage is:"+perc+" Grade is:"+grade);
//			writer.println("<p>Percentage is:"+perc);
//			writer.println("<p>Grade is:"+grade); 
			writer.println("<br />");
			writer.println("<p>Your 12th Details are");
			writer.println("<p>SchoolName is:"+sname2);
			writer.println("<p>Percentage is:"+perc2);
			writer.println("<p>Grade is:"+grade2);
			writer.println("<br />");
			writer.println("<p>Your UG Details are");
			writer.println("<p>Qualification is:"+qual3);
			writer.println("<p>SchoolName is:"+sname3);
			writer.println("<p>Percentage is:"+perc3);
			writer.println("<p>Grade is:"+grade3); 
			writer.println("<br />");
			writer.println("<p>Your PG Details are");
			writer.println("<p>Qualification is:"+qual4);
			writer.println("<p>SchoolName is:"+sname4);
			writer.println("<p>Percentage is:"+perc4);
			writer.println("<p>Grade is:"+grade4); 
			writer.println("<br />");
			writer.println("<p>Check your uploaded image:"+pic);
			writer.println("<p>Check your uploaded Resume:"+file);
			writer.println(file);
			writer.println("</div>");
			writer.println("</body>");
			writer.println("</head>");
			writer.println("</html>");
		}
	}
