drop table if exists customers;
drop table if exists orders;

create table customers (
	id int unique not null,
	name varchar(50)
);

create table orders (
	id int unique not null,
	customerId int not null
);

insert into customers values (1, "joe");
insert into customers values (2, "john");
insert into customers values (3, "mary");

insert into orders values(1,1);
insert into orders values(2,1);
insert into orders values(3,1);
insert into orders values(4,2);