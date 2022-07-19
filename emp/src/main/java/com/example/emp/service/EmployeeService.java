package com.example.emp.service;

import com.example.emp.HibernateUtil;
import com.example.emp.model.Company;
import com.example.emp.model.Employee;
import com.example.emp.model.dto.CompanyDto;
import com.example.emp.model.dto.EmployeeDto;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.List;

public class EmployeeService
{
    public List<Employee> getEmployees()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Employee> employees = session.createQuery("from Employee").list();

        session.getTransaction().commit();
        session.close();

        return employees;
    }

    public Employee getEmployee(long employee_id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Employee where employee_id=:employee_id");
        query.setParameter("employee_id", employee_id);

        Employee employees = (Employee) query.getSingleResult();

        session.getTransaction().commit();
        session.close();

        return employees;
    }

    public Employee addEmployee(EmployeeDto employeeDto)
    {
        Employee employee = new Employee(
                employeeDto.employee_name,
                employeeDto.employee_surname
        );

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(employee);

        session.getTransaction().commit();
        session.close();

        return employee;
    }

    public Employee modifyEmployee(long employee_id, EmployeeDto employeeDto)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Employee where employee_id =:employee_id");
        query.setParameter("employee_id", employee_id);
        Employee employee = (Employee) query.getSingleResult();

        employee.setEmployee_name(employeeDto.employee_name);
        employee.setEmployee_surname(employeeDto.employee_surname);

        session.update(employee);

        session.getTransaction().commit();
        session.close();

        return employee;
    }

    public Employee modifyEmployeeCompany(long employee_id, long company_id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Employee employee = getEmployee(employee_id);
        Company company = new CompanyService().getCompany(company_id);
        CompanyDto companyDto = new CompanyDto(
                company.getCompany_name(),
                company.getCompany_city(),
                company.getCompany_street(),
                company.getCompany_street_number(),
                company.getCompany_zip_code()
        );
        employee.setEmployee_company(companyDto);

        session.update(employee);

        session.getTransaction().commit();
        session.close();

        return employee;
    }

    public Employee deleteEmployeeCompany(long employee_id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Employee employee = getEmployee(employee_id);
        employee.setEmployee_company(null);

        session.update(employee);

        session.getTransaction().commit();
        session.close();

        return employee;
    }

    public Employee deleteEmployee(long employee_id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Employee where employee_id=:employee_id");
        query.setParameter("employee_id", employee_id);

        Employee employee = (Employee) query.getSingleResult();

        session.delete(employee);

        session.getTransaction().commit();
        session.close();

        return employee;
    }
}
