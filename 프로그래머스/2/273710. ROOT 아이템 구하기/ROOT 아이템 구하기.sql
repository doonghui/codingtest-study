select info.ITEM_ID,info.ITEM_NAME from ITEM_INFO as info join ITEM_TREE as tree on info.ITEM_ID = tree.ITEM_ID
where tree.PARENT_ITEM_ID IS  NULL order by info.ITEM_ID;