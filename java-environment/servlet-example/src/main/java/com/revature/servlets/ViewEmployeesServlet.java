package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.connectionutil.ConnectionUtility;
import com.revature.dao.EmployeeDAO;
import com.revature.model.Employee;

@WebServlet("/view-employees")
public class ViewEmployeesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeDAO eDao = ConnectionUtility.getEmployeeDAO();
		List<Employee> employees = eDao.selectAllEmployees();

		request.setAttribute("employees", employees);
		request.getRequestDispatcher("view-employees.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
