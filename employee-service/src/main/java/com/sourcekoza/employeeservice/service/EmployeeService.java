package com.sourcekoza.employeeservice.service;

import com.sourcekoza.employeeservice.entity.Employee;

public interface EmployeeService {

    Employee getEmployeeById(Long id);
    Employee createEmployee(Employee employee);
}