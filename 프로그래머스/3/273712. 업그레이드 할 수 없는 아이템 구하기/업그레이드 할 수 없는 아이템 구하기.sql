select i.ITEM_ID,i.ITEM_NAME,i.RARITY from ITEM_INFO as i join ITEM_TREE as t on i.ITEM_ID = t.ITEM_ID where not Exists (select PARENT_ITEM_ID from ITEM_TREE where PARENT_ITEM_ID = t.ITEM_ID) order by i.ITEM_ID desc;



# SELECT  A.ITEM_ID
#         ,B.ITEM_NAME
#         ,B.RARITY
#   FROM  ITEM_TREE AS A
#   JOIN  ITEM_INFO AS B
#     ON  A.ITEM_ID = B.ITEM_ID
#  WHERE  NOT EXISTS(
#          SELECT 1
#            FROM ITEM_TREE
#           WHERE PARENT_ITEM_ID = A.ITEM_ID)
#  ORDER
#     BY  A.ITEM_ID DESC     
# ;