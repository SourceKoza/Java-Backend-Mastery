package com.sourcekoza.employeeservice.service;

import com.sourcekoza.employeeservice.dto.response.EmployeeResponse;
import com.sourcekoza.employeeservice.entity.Employee;
import com.sourcekoza.employeeservice.exception.EmployeeNotFoundException;
import com.sourcekoza.employeeservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

   public Employee getEmployeeById(Long id){
       return employeeRepository.findById(id)
               .orElseThrow(() ->
                       new EmployeeNotFoundException(
                               "Employee with id " + id + " not found"));
   }

}