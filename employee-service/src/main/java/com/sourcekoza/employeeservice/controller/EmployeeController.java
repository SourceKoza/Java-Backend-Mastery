package com.sourcekoza.employeeservice.controller;

import com.sourcekoza.employeeservice.dto.request.CreateEmployeeRequest;
import com.sourcekoza.employeeservice.dto.response.EmployeeResponse;
import com.sourcekoza.employeeservice.entity.Employee;
import com.sourcekoza.employeeservice.mapper.EmployeeMapper;
import com.sourcekoza.employeeservice.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private  final EmployeeMapper employeeMapper;
    public EmployeeController(EmployeeService employeeService,EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper=employeeMapper;
    }

    @PostMapping
    public EmployeeResponse save(@RequestBody CreateEmployeeRequest request) {
        Employee employee = employeeMapper.toEntity(request);
        Employee savedEmployee = employeeService.save(employee);
        return employeeMapper.toResponse(savedEmployee);
    }
}