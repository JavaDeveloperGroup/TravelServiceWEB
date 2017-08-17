DROP DATABASE IF EXISTS `travelservice`;
CREATE DATABASE IF NOT EXISTS `travelservice`;
USE `travelservice`;

DROP TABLE IF EXISTS `city`;
CREATE TABLE IF NOT EXISTS `city` (
  `id_city` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_city`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

DELETE FROM `city`;

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id_role` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DELETE FROM `role`;

DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `id_room` smallint(6) NOT NULL AUTO_INCREMENT,
  `tv` enum('Yes','No') NOT NULL DEFAULT 'Yes',
  `balcony` enum('Yes','No') NOT NULL DEFAULT 'No',
  `conditioner` enum('Yes','No') NOT NULL DEFAULT 'No',
  PRIMARY KEY (`id_room`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

DELETE FROM `room`;

DROP TABLE IF EXISTS `salon`;
CREATE TABLE IF NOT EXISTS `salon` (
  `id_salon` smallint(6) NOT NULL AUTO_INCREMENT,
  `id_city` smallint(6) NOT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY (`id_salon`),
  KEY `FK_salon_city` (`id_city`),
  CONSTRAINT `FK_salon_city` FOREIGN KEY (`id_city`) REFERENCES `city` (`id_city`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DELETE FROM `salon`;

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` tinyint(4) NOT NULL AUTO_INCREMENT,
  `login` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `id_role` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_admin`),
  KEY `FK_admin_role` (`id_role`),
  CONSTRAINT `FK_admin_role` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

DELETE FROM `admin`;

DROP TABLE IF EXISTS `bus`;
CREATE TABLE IF NOT EXISTS `bus` (
  `id_bus` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `capacity` tinyint(3) NOT NULL,
  `registration_number` varchar(50) NOT NULL,
  PRIMARY KEY (`id_bus`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

DELETE FROM `bus`;

DROP TABLE IF EXISTS `hotel`;
CREATE TABLE IF NOT EXISTS `hotel` (
  `id_hotel` smallint(6) NOT NULL AUTO_INCREMENT,
  `id_city` smallint(6) NOT NULL,
  `title` varchar(100) NOT NULL,
  `stars` enum('3','4','5') NOT NULL,
  `address` varchar(200) NOT NULL,
  PRIMARY KEY (`id_hotel`),
  KEY `FK_hotel_city` (`id_city`),
  CONSTRAINT `FK_hotel_city` FOREIGN KEY (`id_city`) REFERENCES `city` (`id_city`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

DELETE FROM `hotel`;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `gender` enum('MALE','FEMALE') NOT NULL,
  `birthday` date NOT NULL,
  `passport` varchar(9) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `driver_license` enum('Yes','No') NOT NULL DEFAULT 'No',
  `id_role` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_customer`),
  KEY `FK_customer_role` (`id_role`),
  CONSTRAINT `FK_customer_role` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

DELETE FROM `customer`;

DROP TABLE IF EXISTS `auto`;
CREATE TABLE IF NOT EXISTS `auto` (
  `id_auto` mediumint(9) NOT NULL AUTO_INCREMENT,
  `id_brand` tinyint(4) NOT NULL,
  `model` varchar(10) NOT NULL,
  `year` year(4) NOT NULL,
  `transmition` enum('AUTO','MANUAL') NOT NULL DEFAULT 'AUTO',
  `wheel_drive` enum('REAR','FRONT','FULL') NOT NULL DEFAULT 'REAR',
  `fuil_type` enum('PETROL','DIESEL','GAS','ELECTRO') NOT NULL DEFAULT 'PETROL',
  `id_color` tinyint(4) NOT NULL,
  `id_body_type` tinyint(4) NOT NULL,
  `image` varchar(400) NOT NULL,
  PRIMARY KEY (`id_auto`),
  KEY `FK_auto_brand` (`id_brand`),
  KEY `FK_auto_color` (`id_color`),
  KEY `FK_auto_body_type` (`id_body_type`),
  CONSTRAINT `FK_auto_body_type` FOREIGN KEY (`id_body_type`) REFERENCES `body_type` (`id_body_type`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_auto_brand` FOREIGN KEY (`id_brand`) REFERENCES `brand` (`id_brand`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_auto_color` FOREIGN KEY (`id_color`) REFERENCES `color` (`id_color`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

DELETE FROM `auto`;

DROP TABLE IF EXISTS `rent_auto`;
CREATE TABLE IF NOT EXISTS `rent_auto` (
  `id_rent_auto` int(11) NOT NULL AUTO_INCREMENT,
  `id_auto` mediumint(9) NOT NULL,
  `id_salon_start` smallint(6) NOT NULL,
  `status` enum('FREE','OCCU','BROKEN') NOT NULL DEFAULT 'FREE',
  `price` double(7,2) NOT NULL,
  PRIMARY KEY (`id_rent_auto`),
  KEY `FK_rent_auto_auto` (`id_auto`),
  KEY `FK_rent_auto_salon` (`id_salon_start`),
  CONSTRAINT `FK_rent_auto_auto` FOREIGN KEY (`id_auto`) REFERENCES `auto` (`id_auto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_rent_auto_salon` FOREIGN KEY (`id_salon_start`) REFERENCES `salon` (`id_salon`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

DELETE FROM `rent_auto`;

DROP TABLE IF EXISTS `apartment`;
CREATE TABLE IF NOT EXISTS `apartment` (
  `id_apartment` int(11) NOT NULL AUTO_INCREMENT,
  `id_hotel` smallint(6) NOT NULL,
  `id_room` smallint(6) NOT NULL DEFAULT '1',
  `room_capacity` tinyint(2) NOT NULL DEFAULT '1',
  `price` double(7,2) NOT NULL,
  `status` enum('FREE','OCCU') NOT NULL DEFAULT 'FREE',
  `image` varchar(400) NOT NULL,
  PRIMARY KEY (`id_apartment`),
  KEY `FK_apartment_hotel` (`id_hotel`),
  KEY `FK_apartment_room` (`id_room`),
  CONSTRAINT `FK_apartment_hotel` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_apartment_room` FOREIGN KEY (`id_room`) REFERENCES `room` (`id_room`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

DELETE FROM `apartment`;

DROP TABLE IF EXISTS `tour`;
CREATE TABLE IF NOT EXISTS `tour` (
  `id_tour` int(11) NOT NULL AUTO_INCREMENT,
  `destination` varchar(500) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` enum('REST','TRIP','SHOP') NOT NULL,
  `description` text NOT NULL,
  `image` varchar(400) NOT NULL,
  PRIMARY KEY (`id_tour`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

DELETE FROM `tour`;

DROP TABLE IF EXISTS `tour_offer`;
CREATE TABLE IF NOT EXISTS `tour_offer` (
  `id_tour_offer` int(11) NOT NULL AUTO_INCREMENT,
  `id_tour` int(11) NOT NULL,
  `id_bus` smallint(6) NOT NULL,
  `date_start` date NOT NULL,
  `date_end` date NOT NULL,
  `passengers_per_order` tinyint(4) NOT NULL,
  `price` double(7,2) NOT NULL,
  `hot` enum('YES','NO') NOT NULL DEFAULT 'NO',
  PRIMARY KEY (`id_tour_offer`),
  KEY `FK_tour_offer_tour` (`id_tour`),
  KEY `FK_tour_offer_bus` (`id_bus`),
  CONSTRAINT `FK_tour_offer_bus` FOREIGN KEY (`id_bus`) REFERENCES `bus` (`id_bus`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tour_offer_tour` FOREIGN KEY (`id_tour`) REFERENCES `tour` (`id_tour`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

DELETE FROM `tour_offer`;

DROP TABLE IF EXISTS `auto_order`;
CREATE TABLE IF NOT EXISTS `auto_order` (
  `id_auto_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_rent_auto` int(11) NOT NULL,
  `id_salon_end` smallint(6) NOT NULL,
  `date_start` date NOT NULL,
  `date_end` date NOT NULL,
  `order_price` double(7,2) NOT NULL,
  PRIMARY KEY (`id_auto_order`),
  KEY `FK_auto_order_rent_auto` (`id_rent_auto`),
  KEY `FK_auto_order_salon` (`id_salon_end`),
  CONSTRAINT `FK_auto_order_rent_auto` FOREIGN KEY (`id_rent_auto`) REFERENCES `rent_auto` (`id_rent_auto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_auto_order_salon` FOREIGN KEY (`id_salon_end`) REFERENCES `salon` (`id_salon`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `auto_order`;

DROP TABLE IF EXISTS `hotel_order`;
CREATE TABLE IF NOT EXISTS `hotel_order` (
  `id_hotel_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_apartment` int(11) NOT NULL,
  `data_start` date NOT NULL,
  `data_end` date NOT NULL,
  `order_price` double(7,2) NOT NULL,
  PRIMARY KEY (`id_hotel_order`),
  KEY `FK_hotel_order_apartment` (`id_apartment`),
  CONSTRAINT `FK_hotel_order_apartment` FOREIGN KEY (`id_apartment`) REFERENCES `apartment` (`id_apartment`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `hotel_order`;

DROP TABLE IF EXISTS `tour_order`;
CREATE TABLE IF NOT EXISTS `tour_order` (
  `id_tour_order` int(4) NOT NULL AUTO_INCREMENT,
  `id_tour_offer` int(4) NOT NULL,
  `person_number` tinyint(3) NOT NULL DEFAULT '1',
  `order_price` double(7,2) NOT NULL,
  PRIMARY KEY (`id_tour_order`),
  KEY `FK_tour_order_tour_offer` (`id_tour_offer`),
  CONSTRAINT `FK_tour_order_tour_offer` FOREIGN KEY (`id_tour_offer`) REFERENCES `tour_offer` (`id_tour_offer`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `tour_order`;

DROP TABLE IF EXISTS `total_order`;
CREATE TABLE IF NOT EXISTS `total_order` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_customer` int(11) NOT NULL,
  `id_tour_order` int(11) NOT NULL,
  `id_hotel_order` int(11) NOT NULL,
  `id_auto_order` int(11) NOT NULL,
  `total_price` double(7,2) NOT NULL,
  PRIMARY KEY (`id_order`),
  UNIQUE KEY `FK_total_order_tour_order` (`id_tour_order`),
  UNIQUE KEY `FK_total_order_hotel_order` (`id_hotel_order`),
  UNIQUE KEY `FK_total_order_auto_order` (`id_auto_order`),
  KEY `FK_total_order_customer` (`id_customer`),
  CONSTRAINT `FK_total_order_auto_order` FOREIGN KEY (`id_auto_order`) REFERENCES `auto_order` (`id_auto_order`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_total_order_customer` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_total_order_hotel_order` FOREIGN KEY (`id_hotel_order`) REFERENCES `hotel_order` (`id_hotel_order`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_total_order_tour_order` FOREIGN KEY (`id_tour_order`) REFERENCES `tour_order` (`id_tour_order`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM `total_order`;