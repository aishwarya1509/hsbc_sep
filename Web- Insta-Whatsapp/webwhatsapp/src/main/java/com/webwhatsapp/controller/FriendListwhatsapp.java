package com.webwhatsapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webwhatsapp.entity.WhatsappUser;
import com.webwhatsapp.service.ServiceInterface;
import com.webwhatsapp.utility.ServiceFactory;

/**
 * Servlet implementation class FriendListwhatsapp
 */
public class FriendListwhatsapp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		String name=ss.getAttribute("userid").toString();
		
		//System.out.println(name);
		
		WhatsappUser fe=new WhatsappUser();
		fe.setName(name);
		
		ServiceInterface fs=ServiceFactory.createObject("adminservice");
		List<WhatsappUser> i=fs.friendProfile(fe);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		if(i.size()>0) {
			for(WhatsappUser ff:i) {
				out.println(ff.getName());
				out.println(ff.getAddress());
			}
		}
		else {
			out.println("no friend found");
		}
		
		out.println("</body></html>");
	}

}


