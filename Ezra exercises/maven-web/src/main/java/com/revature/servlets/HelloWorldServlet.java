package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String str ="This is the str variable in HelloWorldServlet doGet";
		
		request.setAttribute("helloMessage", str);
//		need to use this if sending additional information for example adding a string or etc
		request.getRequestDispatcher("hello.jsp").forward(request, response); //send user data and any additional data
	//Send redirect is useful when just having another thing do something.
		//		response.sendRedirect("hello.jsp");   //sending data without including any user data
		
	}
}
