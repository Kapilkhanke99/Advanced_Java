 package com.app.Controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entity.Employee;
import com.app.service.EmployeeService;

import pom.app.dto.EmployeeDto;
import pom.app.dto.ResponseDto;
import pom.app.dto.signInReqDto;

@RestController  //@controller+@responsebody(converts json to java)
@RequestMapping("/employees")//base url i.e all uri start from /employee
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	public EmployeeController() {
		System.out.println("Emp constructor started");//no need just to know
	}
	//http://localhost:8080/employees/
	//get all employees
	@GetMapping
	public List<Employee> listOfEmps()
	{
		return empService.getAllEmps();
	}
	//http://localhost:8080/employees/insert
	@PostMapping("/insert")
	public ResponseEntity<?> insertEmp(@RequestBody EmployeeDto dto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(empService.insertEmp(dto));
		
	}
	//http://localhost:8080/employees/{empId}
	@DeleteMapping("/{empId}")
	public ResponseDto deleteEmp(@PathVariable long empId) {
		//pathvariable to take parameter from uri
		return new ResponseDto(empService.deleteEmp(empId));
	}
	//http://localhost:8080/employees/10, method=GET
	//add a validation rule : empId :1 ---100
	@GetMapping("/{empId}")
	public EmployeeDto getEmpById(@PathVariable  @Valid @Min(value = 100,message="Enter id greater than 1")@Max(value = 1000,message="enter id less than 100")long empId)
	{
	     return empService.getEmpById(empId);	
	}
	@PutMapping
	public EmployeeDto updateEmp(@RequestBody Employee emp) {
		return empService.updateEmp(emp);
	}
	
	//http://localhost:8080/employees/signIn
	@PostMapping("/signin")
	public EmployeeDto signIn(@RequestBody signInReqDto  dto) {
		return empService.signIn(dto);
	}

}
