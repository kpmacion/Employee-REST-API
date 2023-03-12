package com.example.emp.controller;

import com.example.emp.model.Company;
import com.example.emp.model.CompanyInfo;
import com.example.emp.model.dto.CompanyDto;
import com.example.emp.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/companies")
public class CompanyController
{
    private static final CompanyService companyService = new CompanyService();

    @RequestMapping(method = RequestMethod.OPTIONS)
    public CompanyInfo getCompanyInfo()
    {
        return new CompanyInfo();
    }

    @GetMapping
    public List<Company> getCompanies()
    {
        return companyService.getCompanies();
    }

    @GetMapping(value = "/{company_id}")
    public Company getCompany(@PathVariable long company_id)
    {
        if(!companyService.companyExists(company_id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company with ID: " + company_id + " does not exist");
        }
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
        if(!companyService.companyExists(company_id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company with ID: " + company_id + " does not exist");
        }
        return companyService.modifyCompany(company_id, companyDto);
    }

    @DeleteMapping(value = "/{company_id}")
    public Company deleteCompany(@PathVariable long company_id)
    {
        if(!companyService.companyExists(company_id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company with ID: " + company_id + " does not exist");
        }
        return companyService.deleteCompany(company_id);
    }
}
