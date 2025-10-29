# Write your MySQL query statement below
Select s.user_id, 
CASE
    WHEN count(c.action) = 0 THEN 0.00
    ELSE ROUND((SUM(CASE WHEN c.action = 'confirmed' THEN 1 ELSE 0 END)/count(c.action)), 2) 
END
    as confirmation_rate
from Signups as s
left join Confirmations as c ON s.user_id = c.user_id
GROUP BY s.user_id