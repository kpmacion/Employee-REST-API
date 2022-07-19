package com.example.emp.model;

import com.example.emp.model.dto.CompanyDto;
import javax.persistence.*;

@Entity
public class Employee
{
    @Id
    @GeneratedValue
    private long employee_id;
    private String employee_name;
    private String employee_surname;
    @Embedded
    private CompanyDto employee_company;

    public Employee(String employee_name, String employee_surname)
    {
        this.employee_name = employee_name;
        this.employee_surname = employee_surname;
    }

    public Employee() {}

    public long getEmployee_id()
    {
        return employee_id;
    }

    public void setEmployee_id(long employee_id)
    {
        this.employee_id = employee_id;
    }

    public String getEmployee_name()
    {
        return employee_name;
    }

    public void setEmployee_name(String employee_name)
    {
        this.employee_name = employee_name;
    }

    public String getEmployee_surname()
    {
        return employee_surname;
    }

    public void setEmployee_surname(String employee_surname)
    {
        this.employee_surname = employee_surname;
    }

    public CompanyDto getEmployee_company()
    {
        return employee_company;
    }

    public void setEmployee_company(CompanyDto employee_company)
    {
        this.employee_company = employee_company;
    }
}
