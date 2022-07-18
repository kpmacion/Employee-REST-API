package com.example.emp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company
{
    @Id
    @GeneratedValue
    private long company_id;
    private String company_name;
    private String company_city;
    private String company_street;
    private String company_street_number;
    private String company_zip_code;

    public Company(String company_name, String company_city, String company_street, String company_street_number, String company_zip_code)
    {
        this.company_name = company_name;
        this.company_city = company_city;
        this.company_street = company_street;
        this.company_street_number = company_street_number;
        this.company_zip_code = company_zip_code;
    }

    public Company() {}

    public long getCompany_id()
    {
        return company_id;
    }

    public void setCompany_id(long company_id)
    {
        this.company_id = company_id;
    }

    public String getCompany_name()
    {
        return company_name;
    }

    public void setCompany_name(String company_name)
    {
        this.company_name = company_name;
    }

    public String getCompany_city()
    {
        return company_city;
    }

    public void setCompany_city(String company_city)
    {
        this.company_city = company_city;
    }

    public String getCompany_street()
    {
        return company_street;
    }

    public void setCompany_street(String company_street)
    {
        this.company_street = company_street;
    }

    public String getCompany_street_number()
    {
        return company_street_number;
    }

    public void setCompany_street_number(String company_street_number)
    {
        this.company_street_number = company_street_number;
    }

    public String getCompany_zip_code()
    {
        return company_zip_code;
    }

    public void setCompany_zip_code(String company_zip_code)
    {
        this.company_zip_code = company_zip_code;
    }
}