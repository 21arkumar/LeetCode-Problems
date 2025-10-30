# Write your MySQL query statement below
Select p1.product_id, round(IFNULL(sum(p1.price*u1.units)/sum(u1.units), 0), 2) as average_price
from Prices as p1
left join UnitsSold as u1
on p1.product_id = u1.product_id and u1.purchase_date between p1.start_date and p1.end_date
group by p1.product_id