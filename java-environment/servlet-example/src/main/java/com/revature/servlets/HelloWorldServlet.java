package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String str = "This is a String value from our HelloWorldServlet!";
		
		request.setAttribute("helloMessage", str);
		/*
		 * Make sure to use RequestDispatcher and the forward method
		 * if you need to send data with your response...
		 * 
		 * If you do not need information from the previous request
		 * or if you do not provide more data with the response via
		 * setAttribute the sendRedirect is a more efficient way
		 * to send the response to the client
		 */
//		response.sendRedirect("hello.jsp");
		request.getRequestDispatcher("hello.jsp").forward(request, response);
	}
}
