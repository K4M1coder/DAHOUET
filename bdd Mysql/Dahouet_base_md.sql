-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.6.24 - MySQL Community Server (GPL)
-- SE du serveur:                Win32
-- HeidiSQL Version:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Export de la structure de la base pour dahouet
DROP DATABASE IF EXISTS `dahouet`;
CREATE DATABASE IF NOT EXISTS `dahouet` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci */;
USE `dahouet`;


-- Export de la structure de table dahouet. challenge
DROP TABLE IF EXISTS `challenge`;
CREATE TABLE IF NOT EXISTS `challenge` (
  `ID_CHALL` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_CHALL` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `DATE_DEBUT` date NOT NULL,
  `DATE_FIN` date NOT NULL,
  PRIMARY KEY (`ID_CHALL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. classe
DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `CLASSE` varchar(20) CHARACTER SET latin1 NOT NULL,
  `SERIE` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`CLASSE`),
  KEY `FK_classe_serie` (`SERIE`),
  CONSTRAINT `FK_classe_serie` FOREIGN KEY (`SERIE`) REFERENCES `serie` (`SERIE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. club
DROP TABLE IF EXISTS `club`;
CREATE TABLE IF NOT EXISTS `club` (
  `ID_CLUB` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_CLUB` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `ADRESSE_CLUB` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `TEL_CLUB` bigint(20) NOT NULL,
  `ID_PRESIDENT` int(11) NOT NULL,
  PRIMARY KEY (`ID_CLUB`),
  KEY `FK_club_personne` (`ID_PRESIDENT`),
  CONSTRAINT `FK_club_personne` FOREIGN KEY (`ID_PRESIDENT`) REFERENCES `personne` (`ID_PERS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. commissaires
DROP TABLE IF EXISTS `commissaires`;
CREATE TABLE IF NOT EXISTS `commissaires` (
  `ID_COMMISSAIRE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PERS` int(11) NOT NULL,
  `COM_REG` varchar(15) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID_COMMISSAIRE`),
  KEY `FK_commissaires_personne` (`ID_PERS`),
  CONSTRAINT `FK_commissaires_personne` FOREIGN KEY (`ID_PERS`) REFERENCES `personne` (`ID_PERS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. commission_de_course
DROP TABLE IF EXISTS `commission_de_course`;
CREATE TABLE IF NOT EXISTS `commission_de_course` (
  `ID_COM` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PRESIDENT` int(11) NOT NULL,
  PRIMARY KEY (`ID_COM`),
  KEY `FK_PRESIDE` (`ID_PRESIDENT`),
  CONSTRAINT `FK_PRESIDE` FOREIGN KEY (`ID_PRESIDENT`) REFERENCES `commissaires` (`ID_COMMISSAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de procédure dahouet. distmoyreg
DROP PROCEDURE IF EXISTS `distmoyreg`;
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


-- Export de la structure de procédure dahouet. lstequipvoilreg
DROP PROCEDURE IF EXISTS `lstequipvoilreg`;
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


-- Export de la structure de procédure dahouet. lstintercomchal
DROP PROCEDURE IF EXISTS `lstintercomchal`;
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


-- Export de la structure de table dahouet. marin
DROP TABLE IF EXISTS `marin`;
CREATE TABLE IF NOT EXISTS `marin` (
  `ID_MARIN` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PERS` int(11) NOT NULL,
  `NUM_LICENCE` bigint(20) NOT NULL,
  `DATE_LICENCE` int(11) NOT NULL,
  `PTSFFV` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_MARIN`),
  KEY `FK_marin_personne` (`ID_PERS`),
  CONSTRAINT `FK_marin_personne` FOREIGN KEY (`ID_PERS`) REFERENCES `personne` (`ID_PERS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. membre_de_commision
DROP TABLE IF EXISTS `membre_de_commision`;
CREATE TABLE IF NOT EXISTS `membre_de_commision` (
  `ID_COM` int(11) NOT NULL,
  `ID_COMMISSAIRE` int(11) NOT NULL,
  PRIMARY KEY (`ID_COM`,`ID_COMMISSAIRE`),
  KEY `FK_FAIT_PARTIE3` (`ID_COMMISSAIRE`),
  CONSTRAINT `FK_FAIT_PARTIE2` FOREIGN KEY (`ID_COM`) REFERENCES `commission_de_course` (`ID_COM`),
  CONSTRAINT `FK_FAIT_PARTIE3` FOREIGN KEY (`ID_COMMISSAIRE`) REFERENCES `commissaires` (`ID_COMMISSAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. participation
DROP TABLE IF EXISTS `participation`;
CREATE TABLE IF NOT EXISTS `participation` (
  `ID_PART` int(11) NOT NULL AUTO_INCREMENT,
  `ID_VOILIER` int(11) NOT NULL,
  `ID_REGATE` int(11) NOT NULL,
  `H_DEP` time NOT NULL,
  `STATUT_DEP` char(3) CHARACTER SET latin1 NOT NULL DEFAULT 'NA',
  `H_ARRIV` time NOT NULL,
  `STATUT_ARRIV` char(3) CHARACTER SET latin1 NOT NULL DEFAULT 'NA',
  `ID_SKIPER` int(11) NOT NULL,
  `PLACE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_PART`),
  KEY `FK_CORRESPOND` (`ID_REGATE`),
  KEY `FK_EST_INSCRIT` (`ID_VOILIER`),
  KEY `FK_EST_SKIPPER` (`ID_SKIPER`),
  KEY `FK_participation_status_de_depart` (`STATUT_DEP`),
  KEY `FK_participation_status_des_arrivees` (`STATUT_ARRIV`),
  CONSTRAINT `FK_CORRESPOND` FOREIGN KEY (`ID_REGATE`) REFERENCES `regate` (`ID_REGATE`),
  CONSTRAINT `FK_EST_INSCRIT` FOREIGN KEY (`ID_VOILIER`) REFERENCES `voilier` (`ID_VOILIER`),
  CONSTRAINT `FK_EST_SKIPPER` FOREIGN KEY (`ID_SKIPER`) REFERENCES `marin` (`ID_MARIN`),
  CONSTRAINT `FK_participation_status_de_depart` FOREIGN KEY (`STATUT_DEP`) REFERENCES `status_de_depart` (`STATUT_DEP`),
  CONSTRAINT `FK_participation_status_des_arrivees` FOREIGN KEY (`STATUT_ARRIV`) REFERENCES `status_des_arrivees` (`STATUT_ARRIV`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. participe
DROP TABLE IF EXISTS `participe`;
CREATE TABLE IF NOT EXISTS `participe` (
  `ID_PART` int(11) NOT NULL,
  `ID_MARIN` int(11) NOT NULL,
  PRIMARY KEY (`ID_PART`,`ID_MARIN`),
  KEY `FK_PARTICIPE2` (`ID_MARIN`),
  CONSTRAINT `FK_PARTICIPE` FOREIGN KEY (`ID_PART`) REFERENCES `participation` (`ID_PART`),
  CONSTRAINT `FK_PARTICIPE2` FOREIGN KEY (`ID_MARIN`) REFERENCES `marin` (`ID_MARIN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. personne
DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `ID_PERS` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `PRENOM` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `ADDRESSE` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `TELEPHONE` bigint(20) NOT NULL,
  `DATE_N` date NOT NULL,
  `MAIL` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_PERS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. proprietaire
DROP TABLE IF EXISTS `proprietaire`;
CREATE TABLE IF NOT EXISTS `proprietaire` (
  `ID_PROPR` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CLUB` int(11) NOT NULL,
  `ID_PERS` int(11) NOT NULL,
  PRIMARY KEY (`ID_PROPR`),
  KEY `FK_EST_MEMBRE` (`ID_CLUB`),
  KEY `FK_proprietaire_personne` (`ID_PERS`),
  CONSTRAINT `FK_EST_MEMBRE` FOREIGN KEY (`ID_CLUB`) REFERENCES `club` (`ID_CLUB`),
  CONSTRAINT `FK_proprietaire_personne` FOREIGN KEY (`ID_PERS`) REFERENCES `personne` (`ID_PERS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. regate
DROP TABLE IF EXISTS `regate`;
CREATE TABLE IF NOT EXISTS `regate` (
  `ID_REGATE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CHALL` int(11) NOT NULL,
  `ID_COM` int(11) NOT NULL,
  `NOM_REG` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `DATE_REGATE` date NOT NULL,
  `DISTANCE` decimal(6,3) NOT NULL,
  `D_VENT` varchar(3) COLLATE latin1_general_ci NOT NULL,
  `I_VENT` smallint(6) NOT NULL,
  `D_COURANT` varchar(3) COLLATE latin1_general_ci NOT NULL,
  `V_COURANT` smallint(6) NOT NULL,
  `ETAT_MER` varchar(10) COLLATE latin1_general_ci NOT NULL,
  `CAP` varchar(3) COLLATE latin1_general_ci NOT NULL,
  `L_BORD` decimal(6,3) NOT NULL,
  `COURUE` char(1) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID_REGATE`),
  KEY `FK_CONTIENS` (`ID_CHALL`),
  KEY `FK_SUPERVISE` (`ID_COM`),
  CONSTRAINT `FK_CONTIENS` FOREIGN KEY (`ID_CHALL`) REFERENCES `challenge` (`ID_CHALL`),
  CONSTRAINT `FK_SUPERVISE` FOREIGN KEY (`ID_COM`) REFERENCES `commission_de_course` (`ID_COM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. serie
DROP TABLE IF EXISTS `serie`;
CREATE TABLE IF NOT EXISTS `serie` (
  `SERIE` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`SERIE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. status_des_arrivees
DROP TABLE IF EXISTS `status_des_arrivees`;
CREATE TABLE IF NOT EXISTS `status_des_arrivees` (
  `STATUT_ARRIV` char(3) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`STATUT_ARRIV`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. status_de_depart
DROP TABLE IF EXISTS `status_de_depart`;
CREATE TABLE IF NOT EXISTS `status_de_depart` (
  `STATUT_DEP` char(3) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`STATUT_DEP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table dahouet. voilier
DROP TABLE IF EXISTS `voilier`;
CREATE TABLE IF NOT EXISTS `voilier` (
  `ID_VOILIER` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PROPR` int(11) NOT NULL,
  `COEFF` decimal(4,4) NOT NULL,
  `CLASSE` varchar(20) CHARACTER SET latin1 NOT NULL,
  `NOM_VOILIER` varchar(20) CHARACTER SET latin1 NOT NULL,
  `NUM_VOILE` int(11) NOT NULL,
  PRIMARY KEY (`ID_VOILIER`),
  KEY `FK_APPARTIENT` (`ID_PROPR`),
  KEY `FK_voilier_classe` (`CLASSE`),
  CONSTRAINT `FK_APPARTIENT` FOREIGN KEY (`ID_PROPR`) REFERENCES `proprietaire` (`ID_PROPR`),
  CONSTRAINT `FK_voilier_classe` FOREIGN KEY (`CLASSE`) REFERENCES `classe` (`CLASSE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de déclencheur dahouet. participation_before_update
DROP TRIGGER IF EXISTS `participation_before_update`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `participation_before_update` BEFORE UPDATE ON `participation` FOR EACH ROW BEGIN
declare nbpart int;
declare error condition for sqlstate '45001';


select count(old.ID_VOILIER) from participation
	where new.ID_REGATE=ID_REGATE
into nbpart;
if(new.PLACE>nbpart)
	then signal error
	set message_text =' il n y à pas autant de voiliers', mysql_errno=9002;
end if;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- Export de la structure de déclencheur dahouet. regate_before_delete
DROP TRIGGER IF EXISTS `regate_before_delete`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `regate_before_delete` BEFORE DELETE ON `regate` FOR EACH ROW BEGIN
declare over date;
declare error condition for sqlstate '45001';
select challenge.DATE_FIN from challenge where old.ID_CHALL=challenge.ID_CHALL into over;
if (curdate()<=over) then 
signal error
set message_text='Le challenge est pas terminé !',mysql_errno=9002;
end if;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- Export de la structure de déclencheur dahouet. regate_before_insert
DROP TRIGGER IF EXISTS `regate_before_insert`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `regate_before_insert` BEFORE INSERT ON `regate` FOR EACH ROW BEGIN
declare datedeb date;
declare datefin date;
declare error condition for sqlstate '45001';

select challenge.DATE_DEBUT into datedeb from challenge where 
new.ID_CHALL = challenge.ID_CHALL;
select challenge.DATE_FIN into datefin from challenge where 
new.ID_CHALL = challenge.ID_CHALL;
if( new.DATE_REGATE not BETWEEN datedeb and datefin)
then signal error
set message_text =' cette date est en dehors du challenge ... +?+(°o°)+?+ ', mysql_errno=9002;
end if; 
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
