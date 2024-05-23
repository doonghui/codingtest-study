-- 코드를 입력하세요
# SELECT CAR_ID,case when sum (case when '2022-10-16' between start_date and end_date then 1
#              else 0 end) = 1 then '대여중'
#              else '대여가능'end as AVAILABILITY FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY group by CAR_ID
# order by CAR_ID DESC






-- 코드를 입력하세요
SELECT car_id,
case when 
sum(case when '2022-10-16' between start_date and end_date then 1
else 0 end) =1 then '대여중'
else '대여 가능'
end availability
from car_rental_company_rental_history
group by 1
order by 1 desc;