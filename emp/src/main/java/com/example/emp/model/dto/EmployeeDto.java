package com.example.emp.model.dto;

public class EmployeeDto
{
    public String employee_name;
    public String employee_surname;

    public EmployeeDto(String employee_name, String employee_surname)
    {
        this.employee_name = employee_name;
        this.employee_surname = employee_surname;
    }
}
