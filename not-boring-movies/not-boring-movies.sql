# Write your MySQL query statement below
Select id,movie, description, rating from cinema where id %2 = 1 AND description != 'boring' Order by rating desc