drop table if exists person;
drop table if exists address;

create table person (
	personId int unique,
	firstName varchar(50),
	lastName varchar(50)
);

create table address (
	addressId int not null,
	personId int not null,
	city varchar(50),
	state varchar(50)
);

insert into person values(1, "john", "bar");
insert into person values(2, "jane", "bar");
insert into person values(3, "mary", "no");

insert into address values(1,1,"san francisco", "ca");
insert into address values(1,2,"san francisco", "ca");