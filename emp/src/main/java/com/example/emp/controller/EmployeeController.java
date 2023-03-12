package com.example.emp.controller;

import com.example.emp.model.Employee;
import com.example.emp.model.EmployeeInfo;
import com.example.emp.model.dto.EmployeeDto;
import com.example.emp.service.CompanyService;
import com.example.emp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController
{
    private static final EmployeeService employeeService = new EmployeeService();
    private static final CompanyService companyService = new CompanyService();

    @RequestMapping(method = RequestMethod.OPTIONS)
    public EmployeeInfo getEmployeeInfo()
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
        if(!employeeService.employeeExists(employee_id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with ID: " + employee_id + " does not exist");
        }
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
        if(!employeeService.employeeExists(employee_id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with ID: " + employee_id + " does not exist");
        }
        return employeeService.modifyEmployee(employee_id, employeeDto);
    }

    @DeleteMapping(value = "/{employee_id}")
    public Employee deleteEmployee(@PathVariable long employee_id)
    {
        if(!employeeService.employeeExists(employee_id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with ID: " + employee_id + " does not exist");
        }
        return employeeService.deleteEmployee(employee_id);
    }

    @PutMapping(value = "/{employee_id}/companies/{company_id}")
    public Employee modifyEmployeeCompany(@PathVariable long employee_id, @PathVariable long company_id)
    {
        if(!employeeService.employeeExists(employee_id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with ID: " + employee_id + " does not exist");
        }
        if(!companyService.companyExists(company_id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company with ID: " + company_id + " does not exist");
        }
        return employeeService.modifyEmployeeCompany(employee_id, company_id);
    }

    @DeleteMapping(value = "/{employee_id}/companies")
    public Employee deleteEmployeeCompany(@PathVariable long employee_id)
    {
        if(!employeeService.employeeExists(employee_id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with ID: " + employee_id + " does not exist");
        }
        return employeeService.deleteEmployeeCompany(employee_id);
    }
}
