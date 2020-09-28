package com.webwhatsapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webwhatsapp.entity.WhatsappUser;
import com.webwhatsapp.service.ServiceInterface;
import com.webwhatsapp.utility.ServiceFactory;

/**
 * Servlet implementation class LoginServletwhatsapp
 */
public class LoginServletwhatsapp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
			
		WhatsappUser fe=new WhatsappUser();
		fe.setName(name);
		fe.setPassword(password);
		
		
		ServiceInterface fs=ServiceFactory.createObject("adminservice");
		boolean i=fs.loginProfile(fe);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		if(i) {
			
			HttpSession ss=request.getSession(true);
			ss.setAttribute("userid", name);
			ss.setAttribute("pass", password);
			
			out.println("welcome "+name+" <a href=TimeLine>timeline</a>   <a href=FriendListwhatsapp>friendlist</a>");
	
		}
		else {
			out.println("Invalid id and password");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
		out.println("</body></html>");
	}

}
