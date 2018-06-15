package com.cg.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig config)");
		}

		
		public void destroy() {
			System.out.println("destroy()");
		}
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("service()");
			PrintWriter writer = response.getWriter();
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<body>");
			writer.println("<div  align='center'>");
			writer.println("<h1 style='color:olive'> HELLO WORLD FROM HELLO SERVLET"); 
			writer.println("</h1>");
			writer.println("</div>");
			writer.println("</body>");
			writer.println("</head>");
			writer.println("</html>");
		}
	}
