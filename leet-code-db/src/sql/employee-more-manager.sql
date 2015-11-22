select e1.name as name
from employee e1 inner join employee e2 on 
	e1.managerId = e2.id
where e1.salary > e2.salary;