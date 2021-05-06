package com.revature.servlets;

import static com.revature.services.AuthenticationService.getAuthenticationSingleton;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Employee;

@WebServlet("/login")
public class AuthenticationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login_name = request.getParameter("login_name");
		String login_pass = request.getParameter("login_pass");
		Employee emp = getAuthenticationSingleton().authenticateEmployee(login_name, login_pass);
		if (emp != null) {
			/*
			 * An HttpSession provides a way to track users across
			 * multiple pages on a website. By setting attributes 
			 * on the session, we can provide values that can be used
			 * across different calls to servlets (this can be used
			 * to verify the user who is logged in, or pass information
			 * to other servlets as needed).
			 */
			HttpSession session = request.getSession(true);
			session.setAttribute("loginId", emp.getLogin_id());
			response.sendRedirect("view-employees");
		} else {
			response.sendRedirect("failed-login.jsp");
		}
	}
}
