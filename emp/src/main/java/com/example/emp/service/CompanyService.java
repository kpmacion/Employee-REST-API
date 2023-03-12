package com.example.emp.service;

import com.example.emp.HibernateUtil;
import com.example.emp.model.Company;
import com.example.emp.model.dto.CompanyDto;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.List;

public class CompanyService
{
    public boolean companyExists(long company_id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Company where company_id =:company_id");
        query.setParameter("company_id", company_id);

        List companies = query.getResultList();

        session.getTransaction().commit();
        session.close();

        return !companies.isEmpty();
    }

    public List<Company> getCompanies()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Company> queryResult = session.createQuery("from Company").getResultList();

        session.getTransaction().commit();
        session.close();

        return queryResult;
    }

    public Company getCompany(long company_id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Company where company_id =:company_id");
        query.setParameter("company_id", company_id);
        Company company = (Company) query.getSingleResult();

        session.getTransaction().commit();
        session.close();

        return company;
    }

    public Company addCompany(CompanyDto companyDto)
    {
        Company company = new Company(
                companyDto.company_name,
                companyDto.company_city,
                companyDto.company_street,
                companyDto.company_street_number,
                companyDto.company_zip_code
        );

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(company);

        session.getTransaction().commit();
        session.close();

        return company;
    }

    public Company modifyCompany(long company_id, CompanyDto companyDto)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Company where company_id =:company_id");
        query.setParameter("company_id", company_id);
        Company company = (Company) query.getSingleResult();

        company.setCompany_name(companyDto.company_name);
        company.setCompany_city(companyDto.company_city);
        company.setCompany_street(companyDto.company_street);
        company.setCompany_street_number(companyDto.company_street_number);
        company.setCompany_zip_code(companyDto.company_zip_code);

        session.update(company);

        session.getTransaction().commit();
        session.close();

        return company;
    }

    public Company deleteCompany(long company_id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Company where company_id =:company_id");
        query.setParameter("company_id", company_id);

        Company company = (Company) query.getSingleResult();

        company.getEmployees().forEach((employee -> employee.setEmployee_company(null)));
        session.delete(company);

        session.getTransaction().commit();
        session.close();

        return company;
    }
}
