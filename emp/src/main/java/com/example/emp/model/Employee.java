package com.example.emp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
public class Employee
{
    @Id
    @GeneratedValue(generator = "employee")
    @GenericGenerator(name = "employee", strategy = "increment")
    private long employee_id;
    private String employee_name;
    private String employee_surname;
    @ManyToOne
    @JsonManagedReference
    private Company employee_company;

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

    public Company getEmployee_company()
    {
        return employee_company;
    }

    public void setEmployee_company(Company company)
    {
        if(this.employee_company != company)
        {
            this.employee_company = company;
            if(company != null)
            {
                company.addEmployees(this);
            }
        }
    }
}
