drop table if exists employee;
create table employee (
	id integer unique,
	name varchar(255),
	salary int,
	managerId int
	);

insert into employee values(1, "Joe", 70000, null);
insert into employee values(2, "Henry", 80000, null);
insert into employee values(3, "Sam", 60000, null);
insert into employee values(4, "Max", 90000, null);