package com.example.codeclan.employeelab.repositories;

import com.example.codeclan.employeelab.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {



}
