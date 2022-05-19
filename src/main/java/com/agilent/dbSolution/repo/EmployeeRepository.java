package com.agilent.dbSolution.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agilent.dbSolution.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
