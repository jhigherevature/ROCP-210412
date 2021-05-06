package com.revature.servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.connectionutil.ConnectionUtility;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.LoginDAO;
import com.revature.model.Employee;
import com.revature.model.Login;

@WebServlet("/add-employee")
public class AddEmployeeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		 * The creation of a new Login Object should instead be
		 * placed in a service object, much like the authentication
		 * service. It is included within this servlet as an
		 * illustration of the steps required, but keep in mind
		 * this is NOT the best practice...
		 */
		
		/*
		 * The first step to add an employee is to create a 
		 * new Login object
		 */
		String loginName = request.getParameter("login_name");
		String loginPass = request.getParameter("login_pass");
		Login login = new Login(null, loginName, loginPass);
		
		/*
		 * We then insert that Login object to the DB. After
		 * we will immediately query the DB, so that we can
		 * obtain the automatically generated login_id (this
		 * occurs as a result of the sequence in our DB)
		 */
		LoginDAO ldao = ConnectionUtility.getLoginDAO();
		ldao.insertNewLogin(login);
		login = ldao.selectLoginByUserAndPass(login.getUser_name(), login.getUser_pass());
		
		/*
		 * Once we receive the login, we can create a new employee using
		 * the parameters from our html form
		 */
		String name = request.getParameter("emp_name");
		Double salary = Double.parseDouble(request.getParameter("emp_salary"));
		String title = request.getParameter("emp_title");
		Employee emp = new Employee(null, name, title, salary, login.getLogin_id());
		
		/*
		 * After creating an employee, we pass the request to our
		 * database using our employee dao.
		 */
		EmployeeDAO eDao = ConnectionUtility.getEmployeeDAO();
		eDao.insertIntoEmployees(emp, emp.getLogin_id());

		/*
		 * Here, we will reload the view-employees page, since
		 * we have just made a change to the database. This provides
		 * feedback to our user whether or not the actuall addition
		 * of new information took place...
		 */
		response.sendRedirect("view-employees");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
