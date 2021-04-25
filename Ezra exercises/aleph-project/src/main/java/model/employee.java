package model;


import java.io.Serializable;

public class Employee implements Serializable {
	private Integer emp_id;
		private String first_name;
		private String last_name;
		private String emp_title;
		private String emp_pw;

		public Employee() {

		}

		public Employee(Integer emp_id, String first_name, String last_name, String emp_title, String emp_ps) {
			this.emp_id = emp_id;
			this.first_name = first_name;
			this.last_name = last_name;
			this.emp_title = emp_title;
			this.emp_pw = emp_pw;
		}
}
