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

-- Export de la structure de procedure dahouet. lstintercomchal
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `lstintercomchal`(IN `datedebut` DATE, IN `datefin` DATE, IN `chal` VARCHAR(20))
BEGIN
select  personne.NOM,
	commissaires.COM_REG,
	regate.DATE_REGATE,
	challenge.NOM_CHALL,
	voilier.NOM_VOILIER,
	participation.ID_PART,
	participation.STATUT_ARRIV
from personne
inner join commissaires on commissaires.ID_PERS=personne.ID_PERS
inner join membre_de_commision on commissaires.ID_COMMISSAIRE=membre_de_commision.ID_COMMISSAIRE
inner join regate on regate.ID_COM=membre_de_commision.ID_COM
inner join challenge on challenge.ID_CHALL=regate.ID_CHALL
inner join participation on participation.ID_REGATE=regate.ID_REGATE
inner join voilier on voilier.ID_VOILIER=participation.ID_VOILIER
where challenge.NOM_CHALL=chal
and 	regate.DATE_REGATE between datedebut and datefin;
END//
DELIMITER ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
