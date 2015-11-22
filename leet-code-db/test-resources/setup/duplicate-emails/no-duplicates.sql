drop table if exists person;
create table person (
	id integer unique,
	email varchar(250)
);

insert into person values (1, "a@z.com");
insert into person values (2, "b@z.com");
insert into person values (3, "c@z.com");
insert into person values (4, "d@z.com");
