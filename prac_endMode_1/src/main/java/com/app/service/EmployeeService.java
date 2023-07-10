package com.app.service;

import java.util.List;

import com.app.Entity.Employee;

import pom.app.dto.EmployeeDto;
import pom.app.dto.signInReqDto;
import pom.app.dto.EmployeeDto;

public interface EmployeeService {
	List<Employee> getAllEmps();
	
	EmployeeDto insertEmp(EmployeeDto dto);
	
	String deleteEmp(long empId);
	
	EmployeeDto getEmpById(long empId);
	
	EmployeeDto updateEmp(Employee emp);
	
	EmployeeDto signIn(signInReqDto dto);
	
	
	}
