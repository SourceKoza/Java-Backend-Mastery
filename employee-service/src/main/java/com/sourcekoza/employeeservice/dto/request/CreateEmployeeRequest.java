package com.sourcekoza.employeeservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CreateEmployeeRequest {
    @NotBlank(message = "Employee name is required")
    private String name;
    @Positive(message = "Salary must be greater than zero")
    private Double salary;

    public CreateEmployeeRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}