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

-- Export de la structure de la base pour dahouet
CREATE DATABASE IF NOT EXISTS `dahouet` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci */;
USE `dahouet`;


-- Export de la structure de table dahouet. challenge
CREATE TABLE IF NOT EXISTS `challenge` (
  `ID_CHALL` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_CHALL` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `DATE_DEBUT` date NOT NULL,
  `DATE_FIN` date NOT NULL,
  PRIMARY KEY (`ID_CHALL`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.challenge: ~2 rows (environ)
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
REPLACE INTO `challenge` (`ID_CHALL`, `NOM_CHALL`, `DATE_DEBUT`, `DATE_FIN`) VALUES
	(1, 'été', '2014-05-01', '2014-09-01'),
	(2, 'hivers', '2014-10-01', '2015-04-01');
/*!40000 ALTER TABLE `challenge` ENABLE KEYS */;


-- Export de la structure de table dahouet. classe
CREATE TABLE IF NOT EXISTS `classe` (
  `CLASSE` varchar(20) CHARACTER SET latin1 NOT NULL,
  `SERIE` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`CLASSE`),
  KEY `FK_classe_serie` (`SERIE`),
  CONSTRAINT `FK_classe_serie` FOREIGN KEY (`SERIE`) REFERENCES `serie` (`SERIE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.classe: ~11 rows (environ)
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
REPLACE INTO `classe` (`CLASSE`, `SERIE`) VALUES
	('8 metres', 'Habitables'),
	('Corsaire', 'Habitables'),
	('Figaro', 'Habitables'),
	('Maraudeur', 'Habitables'),
	('Surprise', 'Habitables'),
	('5.5', 'Quillards de sport'),
	('Flying Fifteen', 'Quillards de sport'),
	('Soling', 'Quillards de sport'),
	('Star', 'Quillards de sport'),
	('Tempest', 'Quillards de sport'),
	('Yngling', 'Quillards de sport');
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;


-- Export de la structure de table dahouet. club
CREATE TABLE IF NOT EXISTS `club` (
  `ID_CLUB` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_CLUB` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `ADRESSE_CLUB` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `TEL_CLUB` bigint(20) NOT NULL,
  `ID_PRESIDENT` int(11) NOT NULL,
  PRIMARY KEY (`ID_CLUB`),
  KEY `FK_club_personne` (`ID_PRESIDENT`),
  CONSTRAINT `FK_club_personne` FOREIGN KEY (`ID_PRESIDENT`) REFERENCES `personne` (`ID_PERS`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.club: ~3 rows (environ)
/*!40000 ALTER TABLE `club` DISABLE KEYS */;
REPLACE INTO `club` (`ID_CLUB`, `NOM_CLUB`, `ADRESSE_CLUB`, `TEL_CLUB`, `ID_PRESIDENT`) VALUES
	(1, 'club SM', '3 boulevard de la pine', 33611111111, 10),
	(2, 'club échangiste', '69 avenue des roustons', 33655555555, 22),
	(3, 'club  strip tease', '38 rue des boobs', 33699999999, 20);
/*!40000 ALTER TABLE `club` ENABLE KEYS */;


-- Export de la structure de table dahouet. commissaires
CREATE TABLE IF NOT EXISTS `commissaires` (
  `ID_COMMISSAIRE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PERS` int(11) NOT NULL,
  `COM_REG` varchar(15) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID_COMMISSAIRE`),
  KEY `FK_commissaires_personne` (`ID_PERS`),
  CONSTRAINT `FK_commissaires_personne` FOREIGN KEY (`ID_PERS`) REFERENCES `personne` (`ID_PERS`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.commissaires: ~3 rows (environ)
/*!40000 ALTER TABLE `commissaires` DISABLE KEYS */;
REPLACE INTO `commissaires` (`ID_COMMISSAIRE`, `ID_PERS`, `COM_REG`) VALUES
	(1, 3, 'Avalanche\r'),
	(2, 1, 'Spira\r'),
	(3, 2, 'Gaia\r');
/*!40000 ALTER TABLE `commissaires` ENABLE KEYS */;


-- Export de la structure de table dahouet. commission_de_course
CREATE TABLE IF NOT EXISTS `commission_de_course` (
  `ID_COM` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PRESIDENT` int(11) NOT NULL,
  PRIMARY KEY (`ID_COM`),
  KEY `FK_PRESIDE` (`ID_PRESIDENT`),
  CONSTRAINT `FK_PRESIDE` FOREIGN KEY (`ID_PRESIDENT`) REFERENCES `commissaires` (`ID_COMMISSAIRE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.commission_de_course: ~2 rows (environ)
/*!40000 ALTER TABLE `commission_de_course` DISABLE KEYS */;
REPLACE INTO `commission_de_course` (`ID_COM`, `ID_PRESIDENT`) VALUES
	(1, 1),
	(2, 3);
/*!40000 ALTER TABLE `commission_de_course` ENABLE KEYS */;


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


-- Export de la structure de table dahouet. marin
CREATE TABLE IF NOT EXISTS `marin` (
  `ID_MARIN` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PERS` int(11) NOT NULL,
  `NUM_LICENCE` bigint(20) NOT NULL,
  `DATE_LICENCE` int(11) NOT NULL,
  `PTSFFV` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_MARIN`),
  KEY `FK_marin_personne` (`ID_PERS`),
  CONSTRAINT `FK_marin_personne` FOREIGN KEY (`ID_PERS`) REFERENCES `personne` (`ID_PERS`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.marin: ~7 rows (environ)
/*!40000 ALTER TABLE `marin` DISABLE KEYS */;
REPLACE INTO `marin` (`ID_MARIN`, `ID_PERS`, `NUM_LICENCE`, `DATE_LICENCE`, `PTSFFV`) VALUES
	(1, 4, 111111, 20160101, NULL),
	(2, 5, 123456, 20160102, NULL),
	(3, 6, 234567, 20160103, NULL),
	(4, 7, 345678, 20160104, NULL),
	(5, 8, 456789, 20160101, NULL),
	(6, 9, 222222, 20160102, NULL),
	(7, 19, 333333, 20160103, NULL),
	(8, 11, 444444, 20160104, NULL),
	(9, 12, 555555, 20160105, NULL),
	(10, 13, 666666, 20160106, NULL),
	(11, 14, 777777, 20160107, NULL),
	(12, 15, 888888, 20160108, NULL),
	(13, 16, 999999, 20160109, NULL),
	(14, 17, 987654, 20160110, NULL),
	(15, 18, 654321, 20160108, NULL);
/*!40000 ALTER TABLE `marin` ENABLE KEYS */;


-- Export de la structure de table dahouet. membre_de_commision
CREATE TABLE IF NOT EXISTS `membre_de_commision` (
  `ID_COM` int(11) NOT NULL,
  `ID_COMMISSAIRE` int(11) NOT NULL,
  PRIMARY KEY (`ID_COM`,`ID_COMMISSAIRE`),
  KEY `FK_FAIT_PARTIE3` (`ID_COMMISSAIRE`),
  CONSTRAINT `FK_FAIT_PARTIE2` FOREIGN KEY (`ID_COM`) REFERENCES `commission_de_course` (`ID_COM`),
  CONSTRAINT `FK_FAIT_PARTIE3` FOREIGN KEY (`ID_COMMISSAIRE`) REFERENCES `commissaires` (`ID_COMMISSAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.membre_de_commision: ~3 rows (environ)
/*!40000 ALTER TABLE `membre_de_commision` DISABLE KEYS */;
REPLACE INTO `membre_de_commision` (`ID_COM`, `ID_COMMISSAIRE`) VALUES
	(1, 1),
	(1, 2),
	(2, 3);
/*!40000 ALTER TABLE `membre_de_commision` ENABLE KEYS */;


-- Export de la structure de table dahouet. participation
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
  CONSTRAINT `FK_participation_status_des_arrivees` FOREIGN KEY (`STATUT_ARRIV`) REFERENCES `status_des_arrivees` (`STATUT_ARRIV`),
  CONSTRAINT `FK_CORRESPOND` FOREIGN KEY (`ID_REGATE`) REFERENCES `regate` (`ID_REGATE`),
  CONSTRAINT `FK_EST_INSCRIT` FOREIGN KEY (`ID_VOILIER`) REFERENCES `voilier` (`ID_VOILIER`),
  CONSTRAINT `FK_EST_SKIPPER` FOREIGN KEY (`ID_SKIPER`) REFERENCES `marin` (`ID_MARIN`),
  CONSTRAINT `FK_participation_status_de_depart` FOREIGN KEY (`STATUT_DEP`) REFERENCES `status_de_depart` (`STATUT_DEP`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.participation: ~20 rows (environ)
/*!40000 ALTER TABLE `participation` DISABLE KEYS */;
REPLACE INTO `participation` (`ID_PART`, `ID_VOILIER`, `ID_REGATE`, `H_DEP`, `STATUT_DEP`, `H_ARRIV`, `STATUT_ARRIV`, `ID_SKIPER`, `PLACE`) VALUES
	(1, 4, 1, '11:00:00', 'OK', '15:00:00', 'OK', 1, NULL),
	(2, 2, 1, '12:00:00', 'OK', '16:00:00', 'OK', 4, NULL),
	(3, 5, 1, '13:00:00', 'OK', '17:00:00', 'OK', 7, NULL),
	(4, 1, 1, '14:00:00', 'OK', '18:00:00', 'OK', 10, NULL),
	(5, 3, 1, '15:00:00', 'OK', '19:00:00', 'DSQ', 13, NULL),
	(6, 4, 2, '16:00:00', 'OCS', '20:00:00', 'OK', 1, NULL),
	(7, 2, 2, '17:00:00', 'OK', '21:00:00', 'DNF', 4, NULL),
	(8, 5, 2, '18:00:00', 'DNS', '22:00:00', 'OK', 7, NULL),
	(9, 1, 2, '19:00:00', 'OK', '23:00:00', 'OK', 10, NULL),
	(10, 3, 2, '20:00:00', 'OK', '00:00:00', 'OK', 13, NULL),
	(11, 4, 3, '21:00:00', 'NA', '01:00:00', 'NA', 1, NULL),
	(12, 2, 3, '22:00:00', 'NA', '02:00:00', 'NA', 4, NULL),
	(13, 5, 3, '23:00:00', 'NA', '03:00:00', 'NA', 7, NULL),
	(14, 1, 3, '00:00:00', 'NA', '04:00:00', 'NA', 10, NULL),
	(15, 3, 3, '01:00:00', 'NA', '05:00:00', 'NA', 13, NULL),
	(16, 4, 4, '02:00:00', 'NA', '06:00:00', 'NA', 1, NULL),
	(17, 2, 4, '03:00:00', 'NA', '07:00:00', 'NA', 4, NULL),
	(18, 5, 4, '04:00:00', 'NA', '08:00:00', 'NA', 7, NULL),
	(19, 1, 4, '05:00:00', 'NA', '09:00:00', 'NA', 10, NULL),
	(20, 3, 4, '06:00:00', 'NA', '10:00:00', 'NA', 13, NULL);
/*!40000 ALTER TABLE `participation` ENABLE KEYS */;


-- Export de la structure de table dahouet. participe
CREATE TABLE IF NOT EXISTS `participe` (
  `ID_PART` int(11) NOT NULL,
  `ID_MARIN` int(11) NOT NULL,
  PRIMARY KEY (`ID_PART`,`ID_MARIN`),
  KEY `FK_PARTICIPE2` (`ID_MARIN`),
  CONSTRAINT `FK_PARTICIPE` FOREIGN KEY (`ID_PART`) REFERENCES `participation` (`ID_PART`),
  CONSTRAINT `FK_PARTICIPE2` FOREIGN KEY (`ID_MARIN`) REFERENCES `marin` (`ID_MARIN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.participe: ~60 rows (environ)
/*!40000 ALTER TABLE `participe` DISABLE KEYS */;
REPLACE INTO `participe` (`ID_PART`, `ID_MARIN`) VALUES
	(1, 1),
	(6, 1),
	(11, 1),
	(16, 1),
	(1, 2),
	(6, 2),
	(11, 2),
	(16, 2),
	(1, 3),
	(6, 3),
	(11, 3),
	(16, 3),
	(2, 4),
	(7, 4),
	(12, 4),
	(17, 4),
	(2, 5),
	(7, 5),
	(12, 5),
	(17, 5),
	(2, 6),
	(7, 6),
	(12, 6),
	(17, 6),
	(3, 7),
	(8, 7),
	(13, 7),
	(18, 7),
	(3, 8),
	(8, 8),
	(13, 8),
	(18, 8),
	(3, 9),
	(8, 9),
	(13, 9),
	(18, 9),
	(4, 10),
	(9, 10),
	(14, 10),
	(19, 10),
	(4, 11),
	(9, 11),
	(14, 11),
	(19, 11),
	(4, 12),
	(9, 12),
	(14, 12),
	(19, 12),
	(5, 13),
	(10, 13),
	(15, 13),
	(20, 13),
	(5, 14),
	(10, 14),
	(15, 14),
	(20, 14),
	(5, 15),
	(10, 15),
	(15, 15),
	(20, 15);
/*!40000 ALTER TABLE `participe` ENABLE KEYS */;


-- Export de la structure de table dahouet. personne
CREATE TABLE IF NOT EXISTS `personne` (
  `ID_PERS` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `PRENOM` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `ADDRESSE` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `TELEPHONE` bigint(20) NOT NULL,
  `DATE_N` date NOT NULL,
  `MAIL` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_PERS`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.personne: ~22 rows (environ)
/*!40000 ALTER TABLE `personne` DISABLE KEYS */;
REPLACE INTO `personne` (`ID_PERS`, `NOM`, `PRENOM`, `ADDRESSE`, `TELEPHONE`, `DATE_N`, `MAIL`) VALUES
	(1, 'Auron', 'edd', '31 bvd de sin 22180 zanarkand', 33296111111, '1981-04-27', 'Auron@dahouet.bzh'),
	(2, 'Steiner', 'thomas', '12 Avenue Terra 64320 Alexandria', 33559666666, '1980-05-26', 'Steiner@dahouet.bzh'),
	(3, 'Cid', 're', '22 rue du Hauvent 62580 Midgar', 33321510669, '1979-03-15', 'Cid@dahouet.bzh'),
	(4, 'pirrate', 'luffy', '1 rue gomu gomu GRANDLINE', 33333333333, '1987-01-13', 'Luffy@dahouet.bzh'),
	(5, 'simon', 'phillipe', '3 avenue des tornades COCOYASHI', 33333333333, '1987-01-14', 'Nami@dahouet.bzh'),
	(6, 'CHOPPER', 'sandra', '18 allée des cerisiers DRUM', 33333333333, '1987-01-15', 'Chopper@dahouet.bzh'),
	(7, 'blanche', 'barbe', '19 allée des cerisiers DRUM', 33333333333, '1987-01-16', 'Barbe@blanche.dahouet'),
	(8, 'ACE', 'quentin', '20 allée des cerisiers DRUM', 33333333333, '1987-01-17', 'Ace@dahouet.bzh'),
	(9, 'MARCO', 'julio', '21 allée des cerisiers DRUM', 33333333333, '1987-01-18', 'Marco@dahouet.bzh'),
	(10, ' TAPIE', 'Bernard', '25 rue Bomettes MARSEILLE', 33198765432, '1943-01-26', 'Bernard@Tapie.dahouet'),
	(11, 'XBOX', '360', '23 allée des cerisiers DRUM', 33333333333, '1987-01-20', 'XBOX@dahouet.bzh'),
	(12, 'KINNECT', 'sensor', '24 allée des cerisiers DRUM', 33333333333, '1987-01-21', 'Kinnect@dahouet.bzh'),
	(13, 'SHANKS', 'travis', '25 allée des cerisiers DRUM', 33333333333, '1987-01-22', 'Shanks@dahouet.bzh'),
	(14, 'YASSOP', 'lino', '26 allée des cerisiers DRUM', 33333333333, '1987-01-23', 'Yassop@dahouet.bzh'),
	(15, 'BECKMAN', 'Ben', '27 allée des cerisiers DRUM', 33333333333, '1987-01-24', 'Ben@Beckman.dahouet'),
	(16, 'JONES', 'Davy', '28 allée des cerisiers DRUM', 33333333333, '1987-01-25', 'Davy@Jones.dahouet'),
	(17, 'VAN DER DECKEN', 'heirmack', '29 allée des cerisiers DRUM', 33333333333, '1987-01-26', 'Van@Der.decken'),
	(18, 'ross', 'tim', '30 allée des cerisiers DRUM', 33333333333, '1987-01-27', 'Arlong@dahouet.bzh'),
	(19, 'GATES', 'Bill', '12 rue des velux LOS ANGELES', 33321510669, '1955-10-28', 'Bill@Gattes.dahouet'),
	(20, 'JOBS', 'Steeve', '22 avenue des escrocs ENFER', 33612345678, '1955-02-24', 'Steeve@Jobs.dahouet'),
	(21, 'ZUCKERBERG', 'Mark', '4 boulevard de la pub NEW YORK', 33559626715, '1984-05-14', 'Mark@Zuckerberg.dahouet'),
	(22, ' BETANCOURT', 'Ingrid', '45 impasse alzheimer PARIS', 33229666666, '1961-12-25', 'Ingrid@betancourt.dahouet');
/*!40000 ALTER TABLE `personne` ENABLE KEYS */;


-- Export de la structure de table dahouet. proprietaire
CREATE TABLE IF NOT EXISTS `proprietaire` (
  `ID_PROPR` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CLUB` int(11) NOT NULL,
  `ID_PERS` int(11) NOT NULL,
  PRIMARY KEY (`ID_PROPR`),
  KEY `FK_EST_MEMBRE` (`ID_CLUB`),
  KEY `FK_proprietaire_personne` (`ID_PERS`),
  CONSTRAINT `FK_proprietaire_personne` FOREIGN KEY (`ID_PERS`) REFERENCES `personne` (`ID_PERS`),
  CONSTRAINT `FK_EST_MEMBRE` FOREIGN KEY (`ID_CLUB`) REFERENCES `club` (`ID_CLUB`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.proprietaire: ~5 rows (environ)
/*!40000 ALTER TABLE `proprietaire` DISABLE KEYS */;
REPLACE INTO `proprietaire` (`ID_PROPR`, `ID_CLUB`, `ID_PERS`) VALUES
	(1, 2, 19),
	(2, 3, 20),
	(3, 1, 21),
	(4, 1, 22),
	(5, 3, 10);
/*!40000 ALTER TABLE `proprietaire` ENABLE KEYS */;


-- Export de la structure de table dahouet. regate
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.regate: ~4 rows (environ)
/*!40000 ALTER TABLE `regate` DISABLE KEYS */;
REPLACE INTO `regate` (`ID_REGATE`, `ID_CHALL`, `ID_COM`, `NOM_REG`, `DATE_REGATE`, `DISTANCE`, `D_VENT`, `I_VENT`, `D_COURANT`, `V_COURANT`, `ETAT_MER`, `CAP`, `L_BORD`, `COURUE`) VALUES
	(1, 1, 1, 'ST BRIEUC ', '2014-07-12', 10.500, 'S', 15, 'E', 12, 'calme', 'NE', 3.100, 'y'),
	(2, 1, 2, 'BREST', '2014-05-13', 12.200, 'N', 17, 'SE', 14, 'houleuse', 'S', 2.500, 'y'),
	(3, 2, 1, 'ST BRIEUC ', '2014-11-14', 11.600, 'NO', 29, 'ONO', 13, 'agitée', 'SO', 3.200, 'n'),
	(4, 2, 1, 'ST BRIEUC ', '2014-12-15', 13.100, 'SSE', 22, 'ESE', 16, 'houleuse', 'NNO', 1.200, 'n');
/*!40000 ALTER TABLE `regate` ENABLE KEYS */;


-- Export de la structure de table dahouet. serie
CREATE TABLE IF NOT EXISTS `serie` (
  `SERIE` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`SERIE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.serie: ~2 rows (environ)
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
REPLACE INTO `serie` (`SERIE`) VALUES
	('Habitables'),
	('Quillards de sport');
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;


-- Export de la structure de table dahouet. status_des_arrivees
CREATE TABLE IF NOT EXISTS `status_des_arrivees` (
  `STATUT_ARRIV` char(3) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`STATUT_ARRIV`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.status_des_arrivees: ~7 rows (environ)
/*!40000 ALTER TABLE `status_des_arrivees` DISABLE KEYS */;
REPLACE INTO `status_des_arrivees` (`STATUT_ARRIV`) VALUES
	('DGM'),
	('DNE'),
	('DNF'),
	('DSQ'),
	('NA'),
	('OK'),
	('RAF');
/*!40000 ALTER TABLE `status_des_arrivees` ENABLE KEYS */;


-- Export de la structure de table dahouet. status_de_depart
CREATE TABLE IF NOT EXISTS `status_de_depart` (
  `STATUT_DEP` char(3) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`STATUT_DEP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.status_de_depart: ~7 rows (environ)
/*!40000 ALTER TABLE `status_de_depart` DISABLE KEYS */;
REPLACE INTO `status_de_depart` (`STATUT_DEP`) VALUES
	('BFD'),
	('DNC'),
	('DNS'),
	('NA'),
	('OCS'),
	('OK'),
	('ZFP');
/*!40000 ALTER TABLE `status_de_depart` ENABLE KEYS */;


-- Export de la structure de table dahouet. voilier
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Export de données de la table dahouet.voilier: ~5 rows (environ)
/*!40000 ALTER TABLE `voilier` DISABLE KEYS */;
REPLACE INTO `voilier` (`ID_VOILIER`, `ID_PROPR`, `COEFF`, `CLASSE`, `NOM_VOILIER`, `NUM_VOILE`) VALUES
	(1, 5, 0.0000, 'Corsaire', 'RED FORCE', 10),
	(2, 4, 0.0000, 'Corsaire', 'MOBY DICK', 25),
	(3, 3, 0.0000, 'Star', 'FLYING DUTCHMAN', 30),
	(4, 2, 0.0000, 'Star', 'SUNNY-GO', 11),
	(5, 1, 0.0000, 'Star', 'MILLENIUM', 115);
/*!40000 ALTER TABLE `voilier` ENABLE KEYS */;


-- Export de la structure de déclancheur dahouet. participation_before_update
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


-- Export de la structure de déclancheur dahouet. regate_before_delete
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


-- Export de la structure de déclancheur dahouet. regate_before_insert
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
