package com.app.Entity;
import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "passWord")
public class Employee extends BaseEntity{
	@Column(name = "first_name",length = 20)
	private String firstName;
	@Column(name = "last_name",length = 20)
	private String lastName;
	@Column(length = 50,unique = true)
	private String email;
	@Column(length = 20,nullable = false)
	private String passWord;
	@Column(name = "join_Date",length = 30)
	private LocalDate joinDate;
	@Column(length = 50)
	private String location;
	@Column(length = 30)
	private String department;

}
