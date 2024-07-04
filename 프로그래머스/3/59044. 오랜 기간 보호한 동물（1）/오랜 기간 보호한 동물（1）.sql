select A.NAME, A.DATETIME from ANIMAL_INS A
    left outer join ANIMAL_OUTS B
-- left outer join을 쓴 이유는 입양을 못간 동물을 출력하기 위해서.
    on A.ANIMAL_ID = B.ANIMAL_ID
    where B.ANIMAL_ID is null
    order by A.DATETIME
    limit 3;