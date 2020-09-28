package com.webwhatsapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webwhatsapp.entity.WhatsappUser;
import com.webwhatsapp.service.ServiceInterface;
import com.webwhatsapp.utility.ServiceFactory;

/**
 * Servlet implementation class RegisterationServletwhatsapp
 */
public class RegisterationServletwhatsapp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n1 = request.getParameter("name");
		String n2 = request.getParameter("password");
		String n3 = request.getParameter("email");
		String n4 = request.getParameter("address");
	
		ServiceInterface rs=ServiceFactory.createObject("adminservice");
		
		WhatsappUser fu=new WhatsappUser();
		fu.setName(n1);
		fu.setPassword(n2);
		fu.setEmail(n3);
		fu.setAddress(n4);
		
		
		int i=rs.createProfileService(fu);
		response.setContentType("text/html");   //text will show in html format
		PrintWriter out=response.getWriter();    //return response on browser
		out.println("<html><body>");
		if(i>0) {
			
			
			out.println("Registration successful   <a href=loginwhatsapp.html>Continue...</a>");
			   out.println("Name is : " + fu.getName());
			   out.println("<br>Password is :" + fu.getPassword());
			   out.println("<br>Email is :" + fu.getEmail());
			   out.println("<br>Address is :" + fu.getAddress());
			 
		}
		else {
			
			out.print("Not Created Profile");
			
		}
	
		out.println("</body></html>");  
	}

}
