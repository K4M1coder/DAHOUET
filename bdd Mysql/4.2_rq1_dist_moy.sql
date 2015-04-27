select challenge.ID_CHALL,challenge.NOM_CHALL,
challenge.DATE_DEBUT,(sum(regate.DISTANCE)) /(count( regate.ID_CHALL)) as distance_moyenne
from challenge
inner join regate on challenge.ID_CHALL=regate.ID_CHALL
where regate.COURUE='y'
group by challenge.ID_CHALL;