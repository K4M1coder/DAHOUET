-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           5.6.17 - MySQL Community Server (GPL)
-- Serveur OS:                   Win64
-- HeidiSQL Version:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Export de la structure de procedure dahouet. lstequipvoilreg
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `lstequipvoilreg`(IN `reg` INT, IN `voil` VARCHAR(20))
BEGIN
select personne.NOM, regate.ID_REGATE, regate.DATE_REGATE
from personne
inner join marin on marin.ID_PERS=personne.ID_PERS
inner join participe on marin.ID_MARIN=participe.ID_MARIN
inner join participation on participe.ID_PART=participation.ID_PART
inner join regate on participation.ID_REGATE = regate.ID_REGATE
inner join voilier on participation.ID_VOILIER = voilier.ID_VOILIER
where regate.ID_REGATE = reg
and voilier.NOM_VOILIER = voil
order by personne.NOM asc;
END//
DELIMITER ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
