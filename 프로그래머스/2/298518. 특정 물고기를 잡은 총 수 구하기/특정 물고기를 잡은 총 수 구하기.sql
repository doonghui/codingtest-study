select count(fish.FISH_TYPE) as FISH_COUNT  from FISH_INFO fish left join  FISH_NAME_INFO name on fish.FISH_TYPE = name.FISH_TYPE
where name.FISH_NAME in ('BASS','SNAPPER')