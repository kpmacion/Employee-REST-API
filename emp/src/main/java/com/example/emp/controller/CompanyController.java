package com.example.emp.controller;

import com.example.emp.model.Company;
import com.example.emp.model.dto.CompanyDto;
import com.example.emp.service.CompanyService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/companies")
public class CompanyController
{
    private static CompanyService companyService = new CompanyService();

    @GetMapping
    public List<Company> getCompanies()
    {
        return companyService.getCompanies();
    }

    @GetMapping(value = "/{company_id}")
    public Company getCompany(@PathVariable long company_id)
    {
        return companyService.getCompany(company_id);
    }

    @PostMapping
    public Company addCompany(@RequestBody CompanyDto companyDto)
    {
        return companyService.addCompany(companyDto);
    }


    @PutMapping(value = "/{company_id}")
    public Company modifyCompany(@PathVariable long company_id, @RequestBody CompanyDto companyDto)
    {
        return companyService.modifyCompany(company_id, companyDto);
    }

    @DeleteMapping(value = "/{company_id}")
    public Company deleteCompany(@PathVariable long company_id)
    {
        return companyService.deleteCompany(company_id);
    }
}
