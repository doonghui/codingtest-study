select count(fi.FISH_TYPE) as FISH_COUNT, FISH_NAME_INFO.FISH_NAME from FISH_INFO as fi join FISH_NAME_INFO on fi.FISH_TYPE =  FISH_NAME_INFO.FISH_TYPE group by FISH_NAME
order by FISH_COUNT desc;



