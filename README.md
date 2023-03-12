# Employee-REST-API
REST API written in Java Spring Boot supporting basic HTTP methods. Embedded database and Hibernate ORM were used to store data.

## HTTP GET 
* #### /api/employees - return all employees 
<img src="https://github.com/kpmacion/Employee-REST-API/blob/master/images/employees_get.png" width="500"/>

* #### /api/employees/<employee_id> - return the employee with the given id 
<img src="https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_get.png" width="500"/>

* #### /api/companies - return all companies 
<img src="https://github.com/kpmacion/Employee-REST-API/blob/master/images/companies_get.png" width="500"/>

* #### /api/companies/<company_id> - return the company with the given id 
<img src="https://github.com/kpmacion/Employee-REST-API/blob/master/images/company_get.png" width="500"/>

## HTTP OPTIONS
* #### /api/employees - return information about employees endpoint
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_options.jpg)

* #### /api/companies - return information about companies endpoint 
![Employee-REST-API](https://github.com/kpmacion/Employee-REST-API/blob/master/images/company_options.jpg)

## HTTP POST 
* #### /api/employees - add a new employee
<img src="https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_add.png" width="500"/>

* #### /api/companies - add a new company
<img src="https://github.com/kpmacion/Employee-REST-API/blob/master/images/company_add.png" width="500"/>

## HTTP PUT 
* #### /api/employees/<employee_id>/companies/<company_id> - modify company in the selected employee
<img src="https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_modify_company.png" width="500"/>

* #### /api/employees/<employee_id> - modify the selected employee
<img src="https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_modify.png" width="500"/>

* #### /api/companies/<company_id> - modify the selected company
<img src="https://github.com/kpmacion/Employee-REST-API/blob/master/images/company_modify.png" width="500"/>

## HTTP DELETE
* #### /api/employees/<employee_id>/companies - delete company in the selected employee
<img src="https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_delete_company.png" width="500"/>

* #### /api/employees/<employee_id> - delete the selected employee
<img src="https://github.com/kpmacion/Employee-REST-API/blob/master/images/employee_delete.png" width="500"/>

* #### /api/companies/<company_id> - delete the selected company
<img src="https://github.com/kpmacion/Employee-REST-API/blob/master/images/company_delete.png" width="500"/>
