package com.webinsta.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webinsta.entity.InstaUser;
import com.webinsta.service.ServiceInterface;
import com.webinsta.utility.ServiceFactory;

/**
 * Servlet implementation class FriendList
 */
public class FriendList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		String name=ss.getAttribute("userid").toString();
		
		//System.out.println(name);
		
		InstaUser fe=new InstaUser();
		fe.setName(name);
		
		ServiceInterface fs=ServiceFactory.createObject("adminservice");
		List<InstaUser> i=fs.friendProfile(fe);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		if(i.size()>0) {
			for(InstaUser ff:i) {
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


