drop table if exists employee;
create table employee (
	id integer unique,
	name varchar(255),
	salary int,
	managerId int
	);

insert into employee values(1, "Joe", 60000, 1);
insert into employee values(2, "Henry", 70000, 2);
insert into employee values(3, "Sam", 80000, 3);
insert into employee values(4, "Max", 90000, 4);