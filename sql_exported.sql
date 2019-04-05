-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.11-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Verzió:              10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for rentmanager
DROP DATABASE IF EXISTS `rentmanager`;
CREATE DATABASE IF NOT EXISTS `rentmanager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rentmanager`;

-- Dumping structure for tábla rentmanager.charges
DROP TABLE IF EXISTS `charges`;
CREATE TABLE IF NOT EXISTS `charges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `sum` int(11) NOT NULL DEFAULT 0,
  `balance_after` int(11) NOT NULL DEFAULT 0,
  `description` mediumtext NOT NULL DEFAULT 'default',
  `tenant` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK_expense_tenants` (`tenant`),
  CONSTRAINT `FK_expense_tenants` FOREIGN KEY (`tenant`) REFERENCES `tenants` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf16;

-- Dumping data for table rentmanager.charges: ~55 rows (approximately)
/*!40000 ALTER TABLE `charges` DISABLE KEYS */;
REPLACE INTO `charges` (`id`, `date`, `sum`, `balance_after`, `description`, `tenant`) VALUES
	(1, '2019-03-05', -29250, -29250, 'Garázsok vétele', 1),
	(2, '2019-03-05', -29250, -29250, 'Garázsok vétele', 2),
	(3, '2019-03-05', -29250, -29250, 'Garázsok vétele', 3),
	(4, '2019-03-05', -26000, -26000, 'Garázsok vétele', 4),
	(5, '2019-03-05', -26000, -26000, 'Garázsok vétele', 5),
	(6, '2019-03-05', -26000, -26000, 'Garázsok vétele', 6),
	(7, '2019-03-05', -22750, -22750, 'Garázsok vétele', 7),
	(8, '2019-03-05', -22750, -22750, 'Garázsok vétele', 8),
	(9, '2019-03-05', -22750, -22750, 'Garázsok vétele', 9),
	(10, '2019-03-05', -19500, -19500, 'Garázsok vétele', 10),
	(11, '2019-03-05', -19500, -19500, 'Garázsok vétele', 11),
	(12, '2019-03-05', -19500, -19500, 'Garázsok vétele', 12),
	(13, '2019-04-05', -29970, -59220, 'Lepcsohaz', 1),
	(14, '2019-04-05', -29970, -59220, 'Lepcsohaz', 2),
	(15, '2019-04-05', -29970, -59220, 'Lepcsohaz', 3),
	(16, '2019-04-05', -26640, -52640, 'Lepcsohaz', 4),
	(17, '2019-04-05', -26640, -52640, 'Lepcsohaz', 5),
	(18, '2019-04-05', -26640, -52640, 'Lepcsohaz', 6),
	(19, '2019-04-05', -23310, -46060, 'Lepcsohaz', 7),
	(20, '2019-04-05', -23310, -46060, 'Lepcsohaz', 8),
	(21, '2019-04-05', -23310, -46060, 'Lepcsohaz', 9),
	(22, '2019-04-05', -19980, -39480, 'Lepcsohaz', 10),
	(23, '2019-04-05', -19980, -39480, 'Lepcsohaz', 11),
	(24, '2019-04-05', -19980, -39480, 'Lepcsohaz', 12),
	(25, '2019-04-05', -4500, -63720, 'Lépcsoház', 1),
	(26, '2019-04-05', -4500, -63720, 'Lépcsoház', 2),
	(27, '2019-04-05', -4500, -63720, 'Lépcsoház', 3),
	(28, '2019-04-05', -4000, -56640, 'Lépcsoház', 4),
	(29, '2019-04-05', -4000, -56640, 'Lépcsoház', 5),
	(30, '2019-04-05', -4000, -56640, 'Lépcsoház', 6),
	(31, '2019-04-05', -3500, -49560, 'Lépcsoház', 7),
	(32, '2019-04-05', -3500, -49560, 'Lépcsoház', 8),
	(33, '2019-04-05', -3500, -49560, 'Lépcsoház', 9),
	(34, '2019-04-05', -3000, -42480, 'Lépcsoház', 10),
	(35, '2019-04-05', -3000, -42480, 'Lépcsoház', 11),
	(36, '2019-04-05', -3000, -42480, 'Lépcsoház', 12),
	(37, '2019-06-05', -90, -63810, 'Őrtorony', 1),
	(38, '2019-06-05', -90, -63810, 'Őrtorony', 2),
	(39, '2019-06-05', -90, -63810, 'Őrtorony', 3),
	(40, '2019-06-05', -80, -56720, 'Őrtorony', 4),
	(41, '2019-06-05', -80, -56720, 'Őrtorony', 5),
	(42, '2019-06-05', -80, -56720, 'Őrtorony', 6),
	(43, '2019-06-05', -70, -49630, 'Őrtorony', 7),
	(44, '2019-06-05', -70, -49630, 'Őrtorony', 8),
	(45, '2019-06-05', -70, -49630, 'Őrtorony', 9),
	(46, '2019-06-05', -60, -42540, 'Őrtorony', 10),
	(47, '2019-06-05', -60, -42540, 'Őrtorony', 11),
	(48, '2019-06-05', -60, -42540, 'Őrtorony', 12),
	(49, '2019-04-05', -20700, -34510, 'Kávé mindenkinek!', 1),
	(50, '2019-04-05', -18400, -42435, 'Kávé mindenkinek!', 4),
	(51, '2019-04-05', -18400, -73670, 'Kávé mindenkinek!', 5),
	(52, '2019-04-05', -18400, -51462, 'Kávé mindenkinek!', 6),
	(53, '2019-04-05', -16100, -50941, 'Kávé mindenkinek!', 8),
	(54, '2019-04-05', -13800, -56340, 'Kávé mindenkinek!', 10),
	(55, '2019-04-05', -13800, -32674, 'Kávé mindenkinek!', 12);
/*!40000 ALTER TABLE `charges` ENABLE KEYS */;

-- Dumping structure for tábla rentmanager.deposits
DROP TABLE IF EXISTS `deposits`;
CREATE TABLE IF NOT EXISTS `deposits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `sum` int(11) NOT NULL DEFAULT 0,
  `balance_after` int(11) NOT NULL DEFAULT 0,
  `tenant` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK__tenants` (`tenant`),
  CONSTRAINT `FK__tenants` FOREIGN KEY (`tenant`) REFERENCES `tenants` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf16;

-- Dumping data for table rentmanager.deposits: ~12 rows (approximately)
/*!40000 ALTER TABLE `deposits` DISABLE KEYS */;
REPLACE INTO `deposits` (`id`, `date`, `sum`, `balance_after`, `tenant`) VALUES
	(1, '2019-03-05', 50000, -13810, 1),
	(2, '2019-03-05', 32685, -24035, 4),
	(3, '2019-03-05', 1450, -55270, 5),
	(4, '2019-03-05', 23658, -33062, 6),
	(5, '2019-03-05', 14789, -34841, 8),
	(6, '2019-04-05', 23666, -18874, 12),
	(7, '2019-04-05', 1200, -33310, 1),
	(8, '2019-04-05', 1400, -41035, 4),
	(9, '2019-06-05', 1500, -72170, 5),
	(10, '2019-06-05', 1322, -50140, 6),
	(11, '2019-06-05', 10000, -40941, 8),
	(12, '2019-06-05', 1044, -31630, 12);
/*!40000 ALTER TABLE `deposits` ENABLE KEYS */;

-- Dumping structure for tábla rentmanager.flats
DROP TABLE IF EXISTS `flats`;
CREATE TABLE IF NOT EXISTS `flats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `floor` int(11) NOT NULL DEFAULT 0,
  `door` int(11) NOT NULL DEFAULT 0,
  `floorSpace` int(11) NOT NULL DEFAULT 0,
  `airSpace` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf16;

-- Dumping data for table rentmanager.flats: ~12 rows (approximately)
/*!40000 ALTER TABLE `flats` DISABLE KEYS */;
REPLACE INTO `flats` (`id`, `floor`, `door`, `floorSpace`, `airSpace`) VALUES
	(1, 1, 1, 90, 70),
	(2, 1, 2, 90, 70),
	(3, 1, 3, 90, 70),
	(4, 2, 1, 80, 60),
	(5, 2, 2, 80, 60),
	(6, 2, 3, 80, 60),
	(7, 3, 1, 70, 50),
	(8, 3, 2, 70, 50),
	(9, 3, 3, 70, 50),
	(10, 4, 1, 60, 45),
	(11, 4, 2, 60, 45),
	(12, 4, 3, 60, 45);
/*!40000 ALTER TABLE `flats` ENABLE KEYS */;

-- Dumping structure for tábla rentmanager.tenants
DROP TABLE IF EXISTS `tenants`;
CREATE TABLE IF NOT EXISTS `tenants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` mediumtext DEFAULT NULL,
  `balance` int(11) NOT NULL DEFAULT 0,
  `flatnum` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK__flats` (`flatnum`),
  CONSTRAINT `FK__flats` FOREIGN KEY (`flatnum`) REFERENCES `flats` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf16;

-- Dumping data for table rentmanager.tenants: ~12 rows (approximately)
/*!40000 ALTER TABLE `tenants` DISABLE KEYS */;
REPLACE INTO `tenants` (`id`, `name`, `balance`, `flatnum`) VALUES
	(1, 'Berentei Parcifál', -33310, 1),
	(2, NULL, -63810, 2),
	(3, NULL, -63810, 3),
	(4, 'Nyokkai Takszi', -41035, 4),
	(5, 'RotoDaster 2000', -72170, 5),
	(6, 'Petri Csésze', -50140, 6),
	(7, NULL, -49630, 7),
	(8, 'Dexterovics Titusz', -40941, 8),
	(9, NULL, -49630, 9),
	(10, 'Skeletor', -56340, 10),
	(11, NULL, -42540, 11),
	(12, 'Lakatos Ramszesz', -31630, 12);
/*!40000 ALTER TABLE `tenants` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
