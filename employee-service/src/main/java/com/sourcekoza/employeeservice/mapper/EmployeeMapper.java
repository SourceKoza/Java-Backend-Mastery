package  com.sourcekoza.employeeservice.mapper;

import com.sourcekoza.employeeservice.dto.request.CreateEmployeeRequest;



import com.sourcekoza.employeeservice.dto.response.EmployeeResponse;
import com.sourcekoza.employeeservice.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEntity(CreateEmployeeRequest request) {

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setSalary(request.getSalary());

        return employee;


    }

    public EmployeeResponse toResponse(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();
        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setSalary(employee.getSalary());

        return response;
    }
}