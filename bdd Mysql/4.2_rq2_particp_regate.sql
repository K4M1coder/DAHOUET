select personne.ID_PERS, personne.NOM,personne.PRENOM, marin.NUM_LICENCE,regate.NOM_REG,regate.DATE_REGATE,voilier.NOM_VOILIER,participation.ID_SKIPER
from marin inner join participe on marin.ID_MARIN=participe.ID_MARIN
inner join participation on participe.ID_PART=participation.ID_PART
inner join regate on participation.ID_REGATE = regate.ID_REGATE
inner join voilier on participation.ID_VOILIER = voilier.ID_VOILIER
inner join personne on personne.ID_PERS = marin.ID_PERS
where regate.ID_REGATE = 1
order by marin.ID_MARIN asc