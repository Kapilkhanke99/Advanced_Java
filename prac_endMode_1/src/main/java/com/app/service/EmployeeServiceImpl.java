   package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import com.app.Entity.Employee;
import com.app.Repository.EmployeeRepository;
import com.app.exception.ResourceNotFoundException;

import pom.app.dto.EmployeeDto;
import pom.app.dto.signInReqDto;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	public EmployeeServiceImpl() {
		System.out.println("IN service constructor");
	}
	
	@Autowired  //dependency injection
	private EmployeeRepository empRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Employee> getAllEmps() {
		
		return empRepo.findAll();
	}

	@Override
	public EmployeeDto insertEmp(EmployeeDto dto) {
		Employee emp = mapper.map(dto, Employee.class);
		return mapper.map(empRepo.save(emp), EmployeeDto.class);
	}

	@Override
	public String deleteEmp(long empId) {
		String msg = "Emp not deleted";
		if(empRepo.existsById(empId))
		{
		empRepo.deleteById(empId);
		msg = "Employee deleted with empid"+empId;
		}
		return msg;
	}

	@Override
	public EmployeeDto getEmpById(long empId) {
		Employee emp = empRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("Invalid Exception"));
		return mapper.map(emp, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmp(Employee emp) {
		
		return mapper.map(empRepo.save(emp),EmployeeDto.class);
	}

	@Override
	public EmployeeDto signIn(signInReqDto dto) {
		Employee emp = empRepo.getByEmailAndPassWord(dto.getEmail(), dto.getPassword()).orElseThrow(()->new ResourceNotFoundException("Wrong email or password"));
		return mapper.map(emp, EmployeeDto.class);
	}
	

}
