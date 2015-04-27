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
-- Export de données de la table dahouet.challenge: ~2 rows (environ)
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
REPLACE INTO `challenge` (`ID_CHALL`, `NOM_CHALL`, `DATE_DEBUT`, `DATE_FIN`) VALUES
	(1, 'été', '2014-05-01', '2014-09-01'),
	(2, 'hivers', '2014-10-01', '2015-04-01');
/*!40000 ALTER TABLE `challenge` ENABLE KEYS */;

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

-- Export de données de la table dahouet.club: ~3 rows (environ)
/*!40000 ALTER TABLE `club` DISABLE KEYS */;
REPLACE INTO `club` (`ID_CLUB`, `NOM_CLUB`, `ADRESSE_CLUB`, `TEL_CLUB`, `ID_PRESIDENT`) VALUES
	(1, 'club SM', '3 boulevard de la pine', 33611111111, 10),
	(2, 'club échangiste', '69 avenue des roustons', 33655555555, 22),
	(3, 'club  strip tease', '38 rue des boobs', 33699999999, 20);
/*!40000 ALTER TABLE `club` ENABLE KEYS */;

-- Export de données de la table dahouet.commissaires: ~3 rows (environ)
/*!40000 ALTER TABLE `commissaires` DISABLE KEYS */;
REPLACE INTO `commissaires` (`ID_COMMISSAIRE`, `ID_PERS`, `COM_REG`) VALUES
	(1, 3, 'Avalanche\r'),
	(2, 1, 'Spira\r'),
	(3, 2, 'Gaia\r');
/*!40000 ALTER TABLE `commissaires` ENABLE KEYS */;

-- Export de données de la table dahouet.commission_de_course: ~2 rows (environ)
/*!40000 ALTER TABLE `commission_de_course` DISABLE KEYS */;
REPLACE INTO `commission_de_course` (`ID_COM`, `ID_PRESIDENT`) VALUES
	(1, 1),
	(2, 3);
/*!40000 ALTER TABLE `commission_de_course` ENABLE KEYS */;

-- Export de données de la table dahouet.marin: ~15 rows (environ)
/*!40000 ALTER TABLE `marin` DISABLE KEYS */;
REPLACE INTO `marin` (`ID_MARIN`, `ID_PERS`, `NUM_LICENCE`, `DATE_LICENCE`) VALUES
	(1, 4, 111111, '2016-01-01'),
	(2, 5, 123456, '2016-01-02'),
	(3, 6, 234567, '2016-01-03'),
	(4, 7, 345678, '2016-01-04'),
	(5, 8, 456789, '2016-01-01'),
	(6, 9, 222222, '2016-01-02'),
	(7, 19, 333333, '2016-01-03'),
	(8, 11, 444444, '2016-01-04'),
	(9, 12, 555555, '2016-01-05'),
	(10, 13, 666666, '2016-01-06'),
	(11, 14, 777777, '2016-01-07'),
	(12, 15, 888888, '2016-01-08'),
	(13, 16, 999999, '2016-01-09'),
	(14, 17, 987654, '2016-01-10'),
	(15, 18, 654321, '2016-01-08');
/*!40000 ALTER TABLE `marin` ENABLE KEYS */;

-- Export de données de la table dahouet.membre_de_commision: ~3 rows (environ)
/*!40000 ALTER TABLE `membre_de_commision` DISABLE KEYS */;
REPLACE INTO `membre_de_commision` (`ID_COM`, `ID_COMMISSAIRE`) VALUES
	(1, 1),
	(1, 2),
	(2, 3);
/*!40000 ALTER TABLE `membre_de_commision` ENABLE KEYS */;

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

-- Export de données de la table dahouet.personne: ~22 rows (environ)
/*!40000 ALTER TABLE `personne` DISABLE KEYS */;
REPLACE INTO `personne` (`ID_PERS`, `NOM`, `ADDRESSE`, `TELEPHONE`, `DATE_N`) VALUES
	(1, 'Auron', '31 bvd de sin 22180 zanarkand', 33296111111, '1981-04-27'),
	(2, 'Steiner', '12 Avenue Terra 64320 Alexandria', 33559666666, '1980-05-26'),
	(3, 'Cid', '22 rue du Hauvent 62580 Midgar', 33321510669, '1979-03-15'),
	(4, 'LUFFY', '1 rue gomu gomu GRANDLINE', 33333333333, '1987-01-13'),
	(5, 'NAMI', '3 avenue des tornades COCOYASHI', 33333333333, '1987-01-14'),
	(6, 'CHOPPER', '18 allée des cerisiers DRUM', 33333333333, '1987-01-15'),
	(7, 'BARBE BLANCHE', '19 allée des cerisiers DRUM', 33333333333, '1987-01-16'),
	(8, 'ACE', '20 allée des cerisiers DRUM', 33333333333, '1987-01-17'),
	(9, 'MARCO', '21 allée des cerisiers DRUM', 33333333333, '1987-01-18'),
	(10, 'BERNARD TAPIE', '25 rue Bomettes MARSEILLE', 33198765432, '1943-01-26'),
	(11, 'XBOX', '23 allée des cerisiers DRUM', 33333333333, '1987-01-20'),
	(12, 'KINNECT', '24 allée des cerisiers DRUM', 33333333333, '1987-01-21'),
	(13, 'SHANKS', '25 allée des cerisiers DRUM', 33333333333, '1987-01-22'),
	(14, 'YASSOP', '26 allée des cerisiers DRUM', 33333333333, '1987-01-23'),
	(15, 'BEN BECKMAN', '27 allée des cerisiers DRUM', 33333333333, '1987-01-24'),
	(16, 'DAVY JONES', '28 allée des cerisiers DRUM', 33333333333, '1987-01-25'),
	(17, 'VAN DER DECKEN', '29 allée des cerisiers DRUM', 33333333333, '1987-01-26'),
	(18, 'ARLONG', '30 allée des cerisiers DRUM', 33333333333, '1987-01-27'),
	(19, 'BILL GATES', '12 rue des velux LOS ANGELES', 33321510669, '1955-10-28'),
	(20, 'STEEVE JOBS', '22 avenue des escrocs ENFER', 33612345678, '1955-02-24'),
	(21, 'MARK ZUCKERBERG', '4 boulevard de la pub NEW YORK', 33559626715, '1984-05-14'),
	(22, 'INGRID BETANCOURT', '45 impasse alzheimer PARIS', 33229666666, '1961-12-25');
/*!40000 ALTER TABLE `personne` ENABLE KEYS */;

-- Export de données de la table dahouet.proprietaire: ~5 rows (environ)
/*!40000 ALTER TABLE `proprietaire` DISABLE KEYS */;
REPLACE INTO `proprietaire` (`ID_PROPR`, `ID_CLUB`, `ID_PERS`) VALUES
	(1, 2, 19),
	(2, 3, 20),
	(3, 1, 21),
	(4, 1, 22),
	(5, 3, 10);
/*!40000 ALTER TABLE `proprietaire` ENABLE KEYS */;

-- Export de données de la table dahouet.regate: ~4 rows (environ)
/*!40000 ALTER TABLE `regate` DISABLE KEYS */;
REPLACE INTO `regate` (`ID_REGATE`, `ID_CHALL`, `ID_COM`, `NOM_REG`, `DATE_REGATE`, `DISTANCE`, `D_VENT`, `I_VENT`, `D_COURANT`, `V_COURANT`, `ETAT_MER`, `CAP`, `L_BORD`, `COURUE`) VALUES
	(1, 1, 1, 'ST BRIEUC ', '2014-07-12', 10.500, 'S', 15, 'E', 12, 'calme', 'NE', 3.100, 'y'),
	(2, 1, 2, 'BREST', '2014-05-13', 12.200, 'N', 17, 'SE', 14, 'houleuse', 'S', 2.500, 'y'),
	(3, 2, 1, 'ST BRIEUC ', '2014-11-14', 11.600, 'NO', 29, 'ONO', 13, 'agitée', 'SO', 3.200, 'n'),
	(4, 2, 1, 'ST BRIEUC ', '2014-12-15', 13.100, 'SSE', 22, 'ESE', 16, 'houleuse', 'NNO', 1.200, 'n');
/*!40000 ALTER TABLE `regate` ENABLE KEYS */;

-- Export de données de la table dahouet.serie: ~2 rows (environ)
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
REPLACE INTO `serie` (`SERIE`) VALUES
	('Habitables'),
	('Quillards de sport');
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;

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

-- Export de données de la table dahouet.voilier: ~5 rows (environ)
/*!40000 ALTER TABLE `voilier` DISABLE KEYS */;
REPLACE INTO `voilier` (`ID_VOILIER`, `ID_PROPR`, `COEFF`, `CLASSE`, `NOM_VOILIER`) VALUES
	(1, 5, 0.0000, 'Corsaire', 'RED FORCE'),
	(2, 4, 0.0000, 'Corsaire', 'MOBY DICK'),
	(3, 3, 0.0000, 'Star', 'FLYING DUTCHMAN'),
	(4, 2, 0.0000, 'Star', 'SUNNY-GO'),
	(5, 1, 0.0000, 'Star', 'MILLENIUM');
/*!40000 ALTER TABLE `voilier` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
