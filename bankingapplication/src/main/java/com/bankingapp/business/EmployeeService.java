package com.bankingapp.business;

import com.bankingapp.entities.*;

public interface EmployeeService {
	Employee findEmployee(String userName, String password) throws BusinessException;
}
