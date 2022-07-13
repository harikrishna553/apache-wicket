package com.sample.app.util;

import java.util.HashMap;
import java.util.Map;

import com.sample.app.dto.Employee;

public class EmployeeUtil {

	private static final Map<Integer, Employee> EMPLOYEE_MAP = new HashMap<>();
	private static final Employee NO_EMPLOYEE = new Employee(-1, "Employee with give id is not exists");

	static {
		EMPLOYEE_MAP.put(1, new Employee(1, "Ram"));
		EMPLOYEE_MAP.put(2, new Employee(2, "Sailu"));
		EMPLOYEE_MAP.put(3, new Employee(3, "Gopi"));
	}

	public static Employee byId(Integer id) {

		Employee emp = EMPLOYEE_MAP.get(id);

		if (emp == null) {
			return NO_EMPLOYEE;
		}

		return emp;
	}

}
