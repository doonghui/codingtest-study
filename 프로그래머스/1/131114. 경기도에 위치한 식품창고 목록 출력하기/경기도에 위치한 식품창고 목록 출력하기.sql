-- 코드를 입력하세요
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS,  case FREEZER_YN when 'Y' then 'Y' else 'N' end  from FOOD_WAREHOUSE where WAREHOUSE_NAME  LIKE "%_경기%";