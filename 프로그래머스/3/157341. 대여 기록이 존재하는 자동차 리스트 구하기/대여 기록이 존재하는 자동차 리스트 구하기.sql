SELECT DISTINCT CAR_ID
from car_rental_company_rental_history 
where car_id in (select car_id from car_rental_company_car where car_type = '세단')
and (start_date between '2022-10-01' and '2022-10-31') 
order by car_id desc