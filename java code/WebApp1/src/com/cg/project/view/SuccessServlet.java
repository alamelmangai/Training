package com.cg.project.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.project.beans.UserBean;

@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserBean userBean = (UserBean)request.getAttribute("userBean");
	
	PrintWriter out = response.getWriter();
	out.println("<html>");
	out.println("<body>");
	out.println("<div align='center'> <font color='green'><b> Welcome "+userBean.getUserName()+" to your login page");
	out.println("</div >");
	out.println("</body>");
	out.println("</html>");
	}

}
