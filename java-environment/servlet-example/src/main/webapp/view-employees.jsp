<jsp:include page="header.jsp" />

<title>Insert title here</title>
</head>
<body>
<title>Employees</title>

<!-- THIS TAG LIBRARY IS REQUIRED TO USE JSTL (JSP Standard Tag Library)
	It is also known as Jakarta Standard Tag Library, or Java Standard 
	Tag Library depending on the tags used.
	
	JSTL will allow us to include java-like programming functionality on our
	webpage 
	-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>

<body>
	<a href="http://localhost:8080/servlet-example">
	<button>Back To Main Page</button>
	</a>
	<h2>All Employees:</h2>

	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>SALARY</th>
			<th>TITLE</th>
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr>
			<!-- Although it may seem like we are trying to access the
				fields directly here, we are actually relying on conventions.
				When you say object.field, the JSP will look at the object
				as a Java Bean, and attempt to retrieve the information
				using normal conventions. i.e. it will invoke the getter
				method for the field. 
				
				In the examples below emp.emp_id invokes the getEmp_id() 
				method on the underlying employee object. Note that it does
				not look at the actual field, rather it only looks for a 
				matching getter method.	
				
				This is an instance where following naming conventions is 
				important!
			 -->
				<td><c:out value="${emp.emp_id}"></c:out></td>
				<td><c:out value="${emp.emp_name}"></c:out></td>
				<td><c:out value="${emp.emp_salary}"></c:out></td>
				<td><c:out value="${emp.emp_title}"></c:out></td>
				<td><c:out value="${emp.empText}"></c:out></td>
			</tr>
		</c:forEach>
	</table>

	<h2>Add New Employee:</h2>
	<form action="add-employee" method="GET">
		Login Name: <input type="text" name="login_name" required><br>
		Login password: <input type="text" name="login_pass" required><br>
	
		Name: <input type="text" name="emp_name"><br> 
		Salary: <input type="number" name="emp_salary"><br> 
		<!-- The select element allows you to provide specific options with associated
			values. The value attribute is what will be passed to the servlet as the 
			information associated with the parameter. 
			
			Remember that parameters are established using the name attribute. -->
		
		Title: <select name="emp_title">
			<option value="teller">Entry Level</option>
			<option value="manager">Big Boss</option>
			<option value="developer">The Real Big Boss</option>
		</select> <br> 
		
		<input type="submit">

	</form>
</body>
</html>