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

-- Export de la structure de procedure dahouet. distmoyreg
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `distmoyreg`(IN `numchallenge` INT)
BEGIN
select challenge.ID_CHALL,challenge.NOM_CHALL,
challenge.DATE_DEBUT,(sum(regate.DISTANCE)) /(count( regate.ID_CHALL)) as distance_moyenne
from challenge
inner join regate on challenge.ID_CHALL=regate.ID_CHALL
where regate.COURUE='y'
and challenge.ID_CHALL=numchallenge;
END//
DELIMITER ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
