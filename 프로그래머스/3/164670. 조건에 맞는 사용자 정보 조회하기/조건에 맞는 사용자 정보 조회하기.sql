-- 코드를 입력하세요
SELECT u.USER_ID,u.NICKNAME,CONCAT(u.CITY,' ',u.STREET_ADDRESS1,' ',u.STREET_ADDRESS2) as '전체주소'
,CONCAT(SUBSTRING(u.TLNO,1,3),'-',SUBSTRING(u.TLNO,4,4),'-',SUBSTRING(TLNO,8,11)) as '전화번호'  
from USED_GOODS_USER as u join  USED_GOODS_BOARD as b on u.USER_ID = b.WRITER_ID
GROUP BY u.USER_ID
HAVING COUNT(u.USER_ID) >= 3
order by u.USER_ID desc;