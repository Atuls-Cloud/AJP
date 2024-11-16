use ajp;
create table Customer(customer_id int primary key,first_name varchar(20),Last_name varchar(30));
create table Orders(order_id int primary key,order_date date,Total_amount int,customer_id int,foreign key(customer_id) references Customer(customer_id));
SELECT customer.first_name, customer.last_name, orders.order_date, orders.total_amount
FROM customer
INNER JOIN orders ON customer.customer_id = orders.customer_id;

create table Department(department_id int primary key,department_name varchar(30));
Create table Employees(employee_id int primary key,first_name varchar(30),last_name varchar(30),department_id int,foreign key(department_id) references Department(department_id));
SELECT department.department_name, employees.first_name, employees.last_name
FROM department
LEFT JOIN employees ON department.department_id = employees.department_id;

alter table department add(location varchar(100));
alter table department add(salary int);
select * from department;

create table Client_Master(ClientNo varchar(6)Primary Key, Name varchar(20)not null,Address1 varchar(30)not null,Address2 varchar(30) not null, City varchar(15) not null, Pincode int not null, State varchar(15) not null,BalDue varchar(20) not null);
select name from Client_Master;
Insert into Client_Master values(101,'Rahul','Shastri Park','Mall Road','Ghaziabad',201715,'Uttar Pradesh',800);
select name from Client_Master;
select * from Client_Master;
select name,city,state from Client_Master;
drop table Client_Master;

