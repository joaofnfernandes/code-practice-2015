select max(salary) as salary
from employee
where salary not in
	(select max(salary)
	from employee);