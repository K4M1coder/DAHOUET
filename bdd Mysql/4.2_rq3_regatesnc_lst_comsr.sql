select distinct regate.NOM_REG as regate, regate.DATE_REGATE as date, personne.NOM as commissaire, commissaires.COM_REG as comité from
regate inner join commission_de_course on regate.ID_COM = commission_de_course.ID_COM
inner join membre_de_commision on commission_de_course.ID_COM = membre_de_commision.ID_COM
inner join commissaires on membre_de_commision.ID_COMMISSAIRE = commissaires.ID_COMMISSAIRE
inner join personne on personne.ID_PERS = commissaires.ID_PERS
inner join participation on regate.ID_REGATE = participation.ID_REGATE
where regate.DATE_REGATE < curdate()
and regate.COURUE = "n"
order by regate.DATE_REGATE asc;