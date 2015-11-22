delete from person
where id in (
	select p1.id
	from person p1 inner join person p2
		on p1.email=p2.email and p1.id>p2.id
);