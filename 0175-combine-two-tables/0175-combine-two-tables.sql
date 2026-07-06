# Write your MySQL query statement below
select firstName, lastName, city, state
from Person as p left join Address as ad
on p.personId=ad.personId;