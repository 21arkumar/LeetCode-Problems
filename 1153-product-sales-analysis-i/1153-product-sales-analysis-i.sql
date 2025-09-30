# Write your MySQL query statement below
SELECT Product_name, year, price
FROM Sales S
INNER JOIN Product P ON S.product_id = P.product_id;