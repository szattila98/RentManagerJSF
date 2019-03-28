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
CREATE DATABASE IF NOT EXISTS `rentmanager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rentmanager`;

-- Dumping structure for tábla rentmanager.deposits
CREATE TABLE IF NOT EXISTS `deposits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT current_timestamp(),
  `amount` int(11) NOT NULL DEFAULT 0,
  `tenant` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK__tenants` (`tenant`),
  CONSTRAINT `FK__tenants` FOREIGN KEY (`tenant`) REFERENCES `tenants` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table rentmanager.deposits: ~0 rows (approximately)
/*!40000 ALTER TABLE `deposits` DISABLE KEYS */;
/*!40000 ALTER TABLE `deposits` ENABLE KEYS */;

-- Dumping structure for tábla rentmanager.expenses
CREATE TABLE IF NOT EXISTS `expenses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT current_timestamp(),
  `amount` int(11) NOT NULL DEFAULT 0,
  `description` text NOT NULL DEFAULT 'default',
  `tenant` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK_expense_tenants` (`tenant`),
  CONSTRAINT `FK_expense_tenants` FOREIGN KEY (`tenant`) REFERENCES `tenants` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table rentmanager.expenses: ~0 rows (approximately)
/*!40000 ALTER TABLE `expenses` DISABLE KEYS */;
/*!40000 ALTER TABLE `expenses` ENABLE KEYS */;

-- Dumping structure for tábla rentmanager.flats
CREATE TABLE IF NOT EXISTS `flats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `floor` int(11) NOT NULL DEFAULT 0,
  `door` int(11) NOT NULL DEFAULT 0,
  `floorSpace` int(11) NOT NULL DEFAULT 0,
  `airSpace` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table rentmanager.flats: ~12 rows (approximately)
/*!40000 ALTER TABLE `flats` DISABLE KEYS */;
INSERT INTO `flats` (`id`, `floor`, `door`, `floorSpace`, `airSpace`) VALUES
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
CREATE TABLE IF NOT EXISTS `tenants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL DEFAULT 'empty',
  `balance` int(11) NOT NULL DEFAULT 0,
  `flatnum` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK__flats` (`flatnum`),
  CONSTRAINT `FK__flats` FOREIGN KEY (`flatnum`) REFERENCES `flats` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table rentmanager.tenants: ~12 rows (approximately)
/*!40000 ALTER TABLE `tenants` DISABLE KEYS */;
INSERT INTO `tenants` (`id`, `name`, `balance`, `flatnum`) VALUES
	(1, 'empty', 0, 1),
	(2, 'empty', 0, 2),
	(3, 'empty', 0, 3),
	(4, 'empty', 0, 4),
	(5, 'empty', 0, 5),
	(6, 'empty', 0, 6),
	(7, 'empty', 0, 7),
	(8, 'empty', 0, 8),
	(9, 'empty', 0, 9),
	(10, 'empty', 0, 10),
	(11, 'empty', 0, 11),
	(12, 'empty', 0, 12);
/*!40000 ALTER TABLE `tenants` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
