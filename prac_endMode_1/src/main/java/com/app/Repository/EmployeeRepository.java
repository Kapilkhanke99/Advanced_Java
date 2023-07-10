package com.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long > {

	Optional<Employee> getByEmailAndPassWord(String email, String password);
}
