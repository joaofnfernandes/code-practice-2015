-- select the emails that have count > 1
select distinct email
from person p
where
	(select count(1) email
	from person
	where email = p.email
	group by email) > 1;


-- left join emails that have same address but different id
-- the ones with null on the right are unique
-- all others are duplicate
select distinct p1.email
from person p1 left join person p2 on
	p1.email = p2.email and
	p1.id <> p2.id
where p2.id not null;