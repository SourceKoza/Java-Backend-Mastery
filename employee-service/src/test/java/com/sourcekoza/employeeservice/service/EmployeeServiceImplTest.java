package com.sourcekoza.employeeservice.service;

import com.sourcekoza.employeeservice.entity.Employee;
import com.sourcekoza.employeeservice.exception.EmployeeNotFoundException;
import com.sourcekoza.employeeservice.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private com.sourcekoza.employeeservice.service.EmployeeServiceImpl employeeService;

    @Test
    void shouldReturnEmployeeWhenEmployeeExists() {

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Ramesh");

        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));

        Employee result = employeeService.getEmployeeById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Ramesh", result.getName());
    }

    @Test
    void shouldThrowExceptionWhenEmployeeDoesNotExist() {

        when(employeeRepository.findById(5L))
                .thenReturn(Optional.empty());

        EmployeeNotFoundException exception =
                assertThrows(EmployeeNotFoundException.class,
                        () -> employeeService.getEmployeeById(5L));

        assertEquals("Employee with id 5 not found", exception.getMessage());
    }
}