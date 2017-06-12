-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.18-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for travelservice
DROP DATABASE IF EXISTS `travelservice`;
CREATE DATABASE IF NOT EXISTS `travelservice` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `travelservice`;

-- Dumping structure for table travelservice.admin
DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `id_role` int(11) NOT NULL,
  PRIMARY KEY (`id_admin`),
  UNIQUE KEY `pk_admin_0` (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.admin: ~3 rows (approximately)
DELETE FROM `admin`;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id_admin`, `login`, `password`, `id_role`) VALUES
	(1, 'tour', 'tour', 2),
	(2, 'hotel', 'hotel', 3),
	(3, 'auto', 'auto', 4);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Dumping structure for table travelservice.apartment
DROP TABLE IF EXISTS `apartment`;
CREATE TABLE IF NOT EXISTS `apartment` (
  `id_apartment` int(4) NOT NULL AUTO_INCREMENT,
  `id_hotel` int(4) NOT NULL,
  `id_room` int(4) NOT NULL,
  `price` double(7,2) NOT NULL,
  `status` enum('FREE','OCCU') NOT NULL DEFAULT 'FREE',
  `image` varchar(300) NOT NULL,
  PRIMARY KEY (`id_apartment`),
  UNIQUE KEY `pk_apartment_0` (`id_room`),
  UNIQUE KEY `pk_apartment_1` (`id_hotel`),
  CONSTRAINT `fk_apartment` FOREIGN KEY (`id_apartment`) REFERENCES `hotel_order` (`id_apartment`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.apartment: ~0 rows (approximately)
DELETE FROM `apartment`;
/*!40000 ALTER TABLE `apartment` DISABLE KEYS */;
/*!40000 ALTER TABLE `apartment` ENABLE KEYS */;

-- Dumping structure for table travelservice.auto
DROP TABLE IF EXISTS `auto`;
CREATE TABLE IF NOT EXISTS `auto` (
  `id_auto` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(40) NOT NULL,
  `model` varchar(40) NOT NULL,
  `year` year(4) NOT NULL,
  `transmition` enum('AUTO','MANUAL') NOT NULL DEFAULT 'AUTO',
  `wheel_drive` enum('REAR','FRONT','FULL') NOT NULL DEFAULT 'REAR',
  `fuil_type` enum('PETROL','DIESEL','GAS','ELECTRO') NOT NULL,
  `id_color` int(11) NOT NULL,
  `id_body_type` int(11) NOT NULL,
  `image` varchar(50) NOT NULL,
  PRIMARY KEY (`id_auto`),
  UNIQUE KEY `pk_auto_0` (`id_body_type`),
  UNIQUE KEY `pk_auto_1` (`id_color`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.auto: ~0 rows (approximately)
DELETE FROM `auto`;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` (`id_auto`, `title`, `model`, `year`, `transmition`, `wheel_drive`, `fuil_type`, `id_color`, `id_body_type`, `image`) VALUES
	(1, 'asd', 'asd', '2017', 'AUTO', 'REAR', 'PETROL', 1, 1, '');
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;

-- Dumping structure for table travelservice.auto_order
DROP TABLE IF EXISTS `auto_order`;
CREATE TABLE IF NOT EXISTS `auto_order` (
  `id_auto_order` int(4) NOT NULL AUTO_INCREMENT,
  `id_rent_auto` int(4) NOT NULL,
  `id_salon_end` int(4) NOT NULL,
  `date_start` date NOT NULL,
  `date_end` date NOT NULL,
  `order_price` double(7,2) NOT NULL,
  PRIMARY KEY (`id_auto_order`),
  UNIQUE KEY `pk_auto_order_0` (`id_rent_auto`),
  UNIQUE KEY `pk_auto_order_1` (`id_salon_end`),
  CONSTRAINT `fk_auto_order` FOREIGN KEY (`id_auto_order`) REFERENCES `total_order` (`id_auto_order`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.auto_order: ~0 rows (approximately)
DELETE FROM `auto_order`;
/*!40000 ALTER TABLE `auto_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `auto_order` ENABLE KEYS */;

-- Dumping structure for table travelservice.body_type
DROP TABLE IF EXISTS `body_type`;
CREATE TABLE IF NOT EXISTS `body_type` (
  `id_body_type` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_body_type`),
  CONSTRAINT `fk_body_type` FOREIGN KEY (`id_body_type`) REFERENCES `auto` (`id_body_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.body_type: ~0 rows (approximately)
DELETE FROM `body_type`;
/*!40000 ALTER TABLE `body_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `body_type` ENABLE KEYS */;

-- Dumping structure for table travelservice.bus
DROP TABLE IF EXISTS `bus`;
CREATE TABLE IF NOT EXISTS `bus` (
  `id_bus` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `capacity` int(4) NOT NULL,
  `registration_number` varchar(50) NOT NULL,
  PRIMARY KEY (`id_bus`),
  CONSTRAINT `fk_bus` FOREIGN KEY (`id_bus`) REFERENCES `tour_offer` (`id_bus`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.bus: ~0 rows (approximately)
DELETE FROM `bus`;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;

-- Dumping structure for table travelservice.color
DROP TABLE IF EXISTS `color`;
CREATE TABLE IF NOT EXISTS `color` (
  `id_color` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_color`),
  CONSTRAINT `fk_color` FOREIGN KEY (`id_color`) REFERENCES `auto` (`id_color`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.color: ~0 rows (approximately)
DELETE FROM `color`;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
/*!40000 ALTER TABLE `color` ENABLE KEYS */;

-- Dumping structure for table travelservice.customer
DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `gender` enum('MALE','FEMALE') NOT NULL,
  `birthday` date NOT NULL,
  `passport` varchar(9) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `driver_license` enum('Yes','No') NOT NULL DEFAULT 'No',
  `id_role` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.customer: ~2 rows (approximately)
DELETE FROM `customer`;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id_customer`, `login`, `password`, `name`, `surname`, `gender`, `birthday`, `passport`, `email`, `phone_number`, `driver_license`, `id_role`) VALUES
	(1, 'user0', 'user0', 'Tsovak', 'Palakian', 'MALE', '2017-06-05', 'sdf', 'tsovak@gmail.com', '+375257018079', 'No', 1),
	(2, 'user1', 'user1', 'Zhenya', 'Popovich', 'MALE', '2017-06-05', 'ds', 'zhenya@gmail.com', '+375297261647', 'Yes', 1),
	(3, 'user2', 'user2', 'Dasha', 'Bortnik', 'FEMALE', '2017-06-11', 'df', 'dasha@gmail.com', '+37529', 'No', 1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table travelservice.hotel
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE IF NOT EXISTS `hotel` (
  `id_hotel` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `stars` enum('3','4','5') NOT NULL,
  `address` varchar(200) NOT NULL,
  PRIMARY KEY (`id_hotel`),
  CONSTRAINT `fk_hotel` FOREIGN KEY (`id_hotel`) REFERENCES `apartment` (`id_hotel`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.hotel: ~0 rows (approximately)
DELETE FROM `hotel`;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;

-- Dumping structure for table travelservice.hotel_order
DROP TABLE IF EXISTS `hotel_order`;
CREATE TABLE IF NOT EXISTS `hotel_order` (
  `id_hotel_order` int(4) NOT NULL AUTO_INCREMENT,
  `id_apartment` int(4) NOT NULL,
  `data_start` date NOT NULL,
  `data_end` date NOT NULL,
  `order_price` double(7,2) NOT NULL,
  PRIMARY KEY (`id_hotel_order`),
  UNIQUE KEY `pk_hotel_order_0` (`id_apartment`),
  CONSTRAINT `fk_hotel_order` FOREIGN KEY (`id_hotel_order`) REFERENCES `total_order` (`id_hotel_order`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.hotel_order: ~0 rows (approximately)
DELETE FROM `hotel_order`;
/*!40000 ALTER TABLE `hotel_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel_order` ENABLE KEYS */;

-- Dumping structure for table travelservice.rent_auto
DROP TABLE IF EXISTS `rent_auto`;
CREATE TABLE IF NOT EXISTS `rent_auto` (
  `id_rent_auto` int(11) NOT NULL AUTO_INCREMENT,
  `id_auto` int(11) NOT NULL,
  `id_salon_start` int(11) NOT NULL,
  `status` enum('FREE','OCCU','BROKEN') NOT NULL DEFAULT 'FREE',
  `price` double(7,2) NOT NULL,
  PRIMARY KEY (`id_rent_auto`),
  UNIQUE KEY `pk_rent_auto_1` (`id_salon_start`),
  UNIQUE KEY `pk_rent_auto_0` (`id_auto`),
  CONSTRAINT `fk_rent_auto` FOREIGN KEY (`id_rent_auto`) REFERENCES `auto_order` (`id_rent_auto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.rent_auto: ~0 rows (approximately)
DELETE FROM `rent_auto`;
/*!40000 ALTER TABLE `rent_auto` DISABLE KEYS */;
/*!40000 ALTER TABLE `rent_auto` ENABLE KEYS */;

-- Dumping structure for table travelservice.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.role: ~4 rows (approximately)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id_role`, `name`) VALUES
	(1, 'customer'),
	(2, 'admin_tour'),
	(3, 'admin_hotel'),
	(4, 'admin_auto'),
	(5, 'vip_customer');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table travelservice.room
DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `id_room` int(11) NOT NULL AUTO_INCREMENT,
  `capacity` int(2) NOT NULL,
  `tv` enum('Yes','No') NOT NULL DEFAULT 'Yes',
  `balcony` enum('Yes','No') NOT NULL DEFAULT 'No',
  `conditioner` enum('Yes','No') NOT NULL DEFAULT 'No',
  PRIMARY KEY (`id_room`),
  CONSTRAINT `fk_room` FOREIGN KEY (`id_room`) REFERENCES `apartment` (`id_room`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.room: ~0 rows (approximately)
DELETE FROM `room`;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
/*!40000 ALTER TABLE `room` ENABLE KEYS */;

-- Dumping structure for table travelservice.salon
DROP TABLE IF EXISTS `salon`;
CREATE TABLE IF NOT EXISTS `salon` (
  `id_salon` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY (`id_salon`),
  CONSTRAINT `fk_salon` FOREIGN KEY (`id_salon`) REFERENCES `rent_auto` (`id_salon_start`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_salon_0` FOREIGN KEY (`id_salon`) REFERENCES `auto_order` (`id_salon_end`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.salon: ~0 rows (approximately)
DELETE FROM `salon`;
/*!40000 ALTER TABLE `salon` DISABLE KEYS */;
/*!40000 ALTER TABLE `salon` ENABLE KEYS */;

-- Dumping structure for table travelservice.total_order
DROP TABLE IF EXISTS `total_order`;
CREATE TABLE IF NOT EXISTS `total_order` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_customer` int(11) NOT NULL,
  `id_tour_order` int(11) DEFAULT NULL,
  `id_hotel_order` int(11) DEFAULT NULL,
  `id_auto_order` int(11) DEFAULT NULL,
  `total_price` double(7,2) NOT NULL,
  PRIMARY KEY (`id_order`),
  UNIQUE KEY `pk_total_order_0` (`id_customer`),
  UNIQUE KEY `pk_total_order_1` (`id_auto_order`),
  UNIQUE KEY `pk_total_order_2` (`id_hotel_order`),
  UNIQUE KEY `pk_total_order_3` (`id_tour_order`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.total_order: ~0 rows (approximately)
DELETE FROM `total_order`;
/*!40000 ALTER TABLE `total_order` DISABLE KEYS */;
INSERT INTO `total_order` (`id_order`, `id_customer`, `id_tour_order`, `id_hotel_order`, `id_auto_order`, `total_price`) VALUES
	(1, 0, 1, 1, 1, 125.00);
/*!40000 ALTER TABLE `total_order` ENABLE KEYS */;

-- Dumping structure for table travelservice.tour
DROP TABLE IF EXISTS `tour`;
CREATE TABLE IF NOT EXISTS `tour` (
  `id_tour` int(11) NOT NULL AUTO_INCREMENT,
  `destination` varchar(500) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` enum('REST','TRIP','SHOP') NOT NULL,
  `description` text NOT NULL,
  `image` varchar(300) NOT NULL,
  PRIMARY KEY (`id_tour`),
  CONSTRAINT `fk_tour` FOREIGN KEY (`id_tour`) REFERENCES `tour_offer` (`id_tour`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.tour: ~0 rows (approximately)
DELETE FROM `tour`;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;

-- Dumping structure for table travelservice.tour_offer
DROP TABLE IF EXISTS `tour_offer`;
CREATE TABLE IF NOT EXISTS `tour_offer` (
  `id_offer` int(11) NOT NULL AUTO_INCREMENT,
  `id_tour` int(11) NOT NULL,
  `id_bus` int(11) NOT NULL,
  `date_start` date NOT NULL,
  `date_end` date NOT NULL,
  `passengers_per_order` int(4) NOT NULL,
  `price` double(7,2) NOT NULL,
  `hot` enum('YES','NO') NOT NULL DEFAULT 'NO',
  PRIMARY KEY (`id_offer`),
  UNIQUE KEY `pk_tour_offer_0` (`id_bus`),
  UNIQUE KEY `pk_tour_offer_1` (`id_tour`),
  CONSTRAINT `fk_tour_offer` FOREIGN KEY (`id_offer`) REFERENCES `tour_order` (`id_offer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.tour_offer: ~0 rows (approximately)
DELETE FROM `tour_offer`;
/*!40000 ALTER TABLE `tour_offer` DISABLE KEYS */;
INSERT INTO `tour_offer` (`id_offer`, `id_tour`, `id_bus`, `date_start`, `date_end`, `passengers_per_order`, `price`, `hot`) VALUES
	(1, 1, 1, '2017-05-31', '2017-05-31', 23, 125.00, 'NO');
/*!40000 ALTER TABLE `tour_offer` ENABLE KEYS */;

-- Dumping structure for table travelservice.tour_order
DROP TABLE IF EXISTS `tour_order`;
CREATE TABLE IF NOT EXISTS `tour_order` (
  `id_tour_order` int(4) NOT NULL AUTO_INCREMENT,
  `id_offer` int(4) NOT NULL,
  `person_number` int(3) NOT NULL DEFAULT '1',
  `order_price` double(7,2) NOT NULL,
  PRIMARY KEY (`id_tour_order`),
  UNIQUE KEY `pk_tour_order_0` (`id_offer`),
  CONSTRAINT `fk_tour_order` FOREIGN KEY (`id_tour_order`) REFERENCES `total_order` (`id_tour_order`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table travelservice.tour_order: ~0 rows (approximately)
DELETE FROM `tour_order`;
/*!40000 ALTER TABLE `tour_order` DISABLE KEYS */;
INSERT INTO `tour_order` (`id_tour_order`, `id_offer`, `person_number`, `order_price`) VALUES
	(1, 1, 1, 12.00);
/*!40000 ALTER TABLE `tour_order` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
