# Employee-REST-API
REST API written in Java Spring supporting basic HTTP methods. Embedded database and Hibernate ORM were used to store data.

## HTTP GET 
* #### /api/employees - return all employees 
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/employees_get.jpg)

* #### /api/employees/<employee_id> - return the employee with the given id 
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_get.jpg)

* #### /api/companies - return all companies 
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/companies_get.jpg)

* #### /api/companies/<company_id> - return the company with the given id 
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/company_get.jpg)

## HTTP OPTIONS
* #### /api/employees - return information about employees endpoint
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_options.jpg)

* #### /api/companies - return information about companies endpoint 
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/company_options.jpg)

## HTTP POST 
* #### /api/employees - add a new employee
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_add.jpg)

* #### /api/companies - add a new company
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/company_add.jpg)

## HTTP PUT 
* #### /api/employees/<employee_id>/companies - modify company in the selected employee
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_modify_company.jpg)

* #### /api/employees/<employee_id> - modify the selected employee
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_modify.jpg)

* #### /api/company/<company_id> - modify the selected company
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/company_modify.jpg)

## HTTP DELETE
* #### /api/employees/<employee_id>/companies - delete company in the selected employee
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_delete_company.jpg)

* #### /api/employees/<employee_id> - delete the selected employee
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_delete.jpg)

* #### /api/company/<company_id> - delete the selected company
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/company_delete.jpg)
