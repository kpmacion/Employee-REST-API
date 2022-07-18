package com.example.emp.model.dto;

public class CompanyDto
{
    public String company_name;
    public String company_city;
    public String company_street;
    public String company_street_number;
    public String company_zip_code;

    public CompanyDto(String company_name, String company_city, String company_street, String company_street_number, String company_zip_code)
    {
        this.company_name = company_name;
        this.company_city = company_city;
        this.company_street = company_street;
        this.company_street_number = company_street_number;
        this.company_zip_code = company_zip_code;
    }
}