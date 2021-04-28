package model;


import java.io.Serializable;

public class Employee implements Serializable {
		private Integer emp_id;
		private String first_name;
		private String last_name;
		private String emp_title;
		private Integer id_userpass;

		public Employee() {
		}

		public Employee(Integer emp_id, String first_name, String last_name, String emp_title, Integer id_userpass) {
			this.emp_id = emp_id;
			this.first_name = first_name;
			this.last_name = last_name;
			this.emp_title = emp_title;
			this.id_userpass = id_userpass;
		}
		
		public Employee(String first_name, String last_name, String emp_title, Integer id_userpass) {
			this(null, first_name, last_name, emp_title, id_userpass);
		}
		
		public Employee(String first_name, String last_name, String emp_title) {
			this(null, first_name, last_name, emp_title, null);
		}

		/**
		 * @return the emp_id
		 */
		public Integer getEmp_id() {
			return emp_id;
		}

		/**
		 * @param emp_id the emp_id to set
		 */
		public void setEmp_id(Integer emp_id) {
			this.emp_id = emp_id;
		}

		/**
		 * @return the first_name
		 */
		public String getFirst_name() {
			return first_name;
		}

		/**
		 * @param first_name the first_name to set
		 */
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		/**
		 * @return the last_name
		 */
		public String getLast_name() {
			return last_name;
		}

		/**
		 * @param last_name the last_name to set
		 */
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		/**
		 * @return the emp_title
		 */
		public String getEmp_title() {
			return emp_title;
		}

		/**
		 * @param emp_title the emp_title to set
		 */
		public void setEmp_title(String emp_title) {
			this.emp_title = emp_title;
		}

		/**
		 * @return the emp_pw
		 */
//		public String getEmp_pw() {
//			return emp_pw;
//		}
		public Integer getId_userpass() {
			return id_userpass;
		}
		/**
		 * @param emp_pw the emp_pw to set
		 */
//		public void setEmp_pw(String emp_pw) {
//			this.emp_pw = emp_pw;
//		}
		public void setId_userpass(Integer id_userpass) {
			this.id_userpass = id_userpass;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((emp_id == null) ? 0 : emp_id.hashCode());
			result = prime * result + ((id_userpass == null) ? 0 : id_userpass.hashCode());
			result = prime * result + ((emp_title == null) ? 0 : emp_title.hashCode());
			result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
			result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (emp_id == null) {
				if (other.emp_id != null)
					return false;
			} else if (!emp_id.equals(other.emp_id))
				return false;
			if (id_userpass == null) {
				if (other.id_userpass != null)
					return false;
			} else if (!id_userpass.equals(other.id_userpass))
				return false;
			if (emp_title == null) {
				if (other.emp_title != null)
					return false;
			} else if (!emp_title.equals(other.emp_title))
				return false;
			if (first_name == null) {
				if (other.first_name != null)
					return false;
			} else if (!first_name.equals(other.first_name))
				return false;
			if (last_name == null) {
				if (other.last_name != null)
					return false;
			} else if (!last_name.equals(other.last_name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Employee [emp_id=" + emp_id + ", first_name=" + first_name + ", last_name=" + last_name
					+ ", emp_title=" + emp_title + ", id_userpass=" + id_userpass + "]";
		}


		
		
}
