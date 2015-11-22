select name
from customers
where id not in (
	select customerId
	from orders
);

select name
from customers
where not exists (
	select customerId
	from orders
	where customers.id=orders.customerId
)