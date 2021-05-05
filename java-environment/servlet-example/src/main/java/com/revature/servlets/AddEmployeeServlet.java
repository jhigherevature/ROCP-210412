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
		String loginName = request.getParameter("login_name");
		String loginPass = request.getParameter("login_pass");
		Login login = new Login(null, loginName, loginPass);
		
		LoginDAO ldao = ConnectionUtility.getLoginDAO();
		ldao.insertNewLogin(login);
		login = ldao.selectLoginByUserAndPass(login.getUser_name(), login.getUser_pass());
		
		String name = request.getParameter("emp_name");
		Double salary = Double.parseDouble(request.getParameter("emp_salary"));
		String title = request.getParameter("emp_title");
		
		EmployeeDAO eDao = ConnectionUtility.getEmployeeDAO();
		
		Employee emp = new Employee(null, name, title, salary, login.getLogin_id());
		eDao.insertIntoEmployees(emp, emp.getLogin_id());
		
		List<Employee> employees = eDao.selectAllEmployees();
		
		/*
		 * After creating a new login and a new employee, the list of
		 * employees are retrieved once more, and the view-employees
		 * page is opened once again to show the updated list... 
		 */
		request.setAttribute("employees", employees);
		request.getRequestDispatcher("view-employees.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
