package pom.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String passWord;
	
	private LocalDate joinDate;
	
	private String location;
	
	private String department;
}
