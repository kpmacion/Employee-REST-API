package com.example.emp.controller;

import com.example.emp.model.Employee;
import com.example.emp.model.EmployeeInfo;
import com.example.emp.model.dto.EmployeeDto;
import com.example.emp.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController
{
    private static final EmployeeService employeeService = new EmployeeService();

    @RequestMapping(method = RequestMethod.OPTIONS)
    public EmployeeInfo getCompanyInfo()
    {
        return new EmployeeInfo();
    }

    @GetMapping
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
    }

    @GetMapping(value = "/{employee_id}")
    public Employee getEmployees(@PathVariable long employee_id)
    {
        return employeeService.getEmployee(employee_id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto)
    {
        return employeeService.addEmployee(employeeDto);
    }

    @PutMapping(value = "/{employee_id}")
    public Employee modifyEmployee(@PathVariable long employee_id, @RequestBody EmployeeDto employeeDto)
    {
        return employeeService.modifyEmployee(employee_id, employeeDto);
    }

    @DeleteMapping(value = "/{employee_id}")
    public Employee deleteEmployee(@PathVariable long employee_id)
    {
        return employeeService.deleteEmployee(employee_id);
    }

    @PutMapping(value = "/{employee_id}/companies/{company_id}")
    public Employee modifyEmployeeCompany(@PathVariable long employee_id, @PathVariable long company_id)
    {
        return employeeService.modifyEmployeeCompany(employee_id, company_id);
    }

    @DeleteMapping(value = "/{employee_id}/companies")
    public Employee deleteEmployeeCompany(@PathVariable long employee_id)
    {
        return employeeService.deleteEmployeeCompany(employee_id);
    }
}
