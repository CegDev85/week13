package com.example.codeclan.employeelab;

import com.example.codeclan.employeelab.models.Employee;
import com.example.codeclan.employeelab.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeelabApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmplyee(){
		Employee employee = new Employee("John Johnson",45,"JJ@outlook.com",19985);
		employeeRepository.save(employee);
	}

}
