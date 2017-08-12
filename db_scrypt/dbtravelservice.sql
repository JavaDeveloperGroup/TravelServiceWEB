-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: travelservice
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id_admin` tinyint(4) NOT NULL AUTO_INCREMENT,
  `login` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `id_role` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_admin`),
  KEY `FK_admin_role` (`id_role`),
  CONSTRAINT `FK_admin_role` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'tour1','ÚØ¹×ºq',2),(2,'hotel1','ÎØ¸ÊØ ¦Ú',3),(3,'auto1','ÇÞ¸Ôºq',4);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apartment`
--

DROP TABLE IF EXISTS `apartment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apartment` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartment`
--

LOCK TABLES `apartment` WRITE;
/*!40000 ALTER TABLE `apartment` DISABLE KEYS */;
INSERT INTO `apartment` VALUES (1,4,2,2,30.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805539/hotel/2noall_ibf5vm.jpg'),(2,4,3,2,40.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805537/hotel/tv3_mrc5n1.jpg'),(3,4,2,1,25.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/11.jpg'),(4,8,3,1,20.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/1.jpg'),(5,8,3,2,35.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805537/hotel/tv3_mrc5n1.jpg'),(6,9,2,1,21.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/1.jpg'),(7,9,3,2,37.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805534/hotel/2notv2_d1z64u.jpg'),(8,9,3,2,37.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805534/hotel/2notv2_d1z64u.jpg'),(9,1,4,2,50.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/1baltv.jpg'),(10,1,8,2,48.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/2all3.jpg'),(11,1,4,1,45.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/11111.jpg'),(12,5,8,2,50.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805539/hotel/tv4_vkohcp.jpg'),(13,5,8,2,50.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805539/hotel/tv4_vkohcp.jpg'),(14,10,4,1,51.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/111.jpg'),(15,10,4,1,51.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497853428/hotel/111.jpg'),(16,10,4,2,60.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805533/hotel/2notv_ildeop.jpg'),(17,2,4,3,90.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805535/hotel/balc_wlaq7r.jpg'),(18,2,8,1,75.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497853429/hotel/1111.jpg'),(19,3,4,2,80.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805539/hotel/tv4_vkohcp.jpg'),(20,3,4,1,70.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497853427/hotel/1all.jpg'),(21,6,8,2,80.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805535/hotel/tv1_bkvotw.jpg'),(22,6,8,2,80.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805535/hotel/tv1_bkvotw.jpg'),(23,7,8,2,83.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805534/hotel/all_dje6yq.jpg'),(24,7,8,2,83.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497805534/hotel/all_dje6yq.jpg'),(25,7,4,1,75.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497853429/hotel/1111.jpg'),(26,5,4,1,45.00,'FREE','http://res.cloudinary.com/javadevgroup/image/upload/v1497853427/hotel/1tvcon.jpg');
/*!40000 ALTER TABLE `apartment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auto` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES (1,3,'Mustang',1969,'MANUAL','FULL','PETROL',3,2,'http://res.cloudinary.com/javadevgroup/image/upload/v1497805554/auto/1969-Mustang-Pro-Street_tfthgb.jpg'),(2,1,'X5',2011,'MANUAL','FRONT','PETROL',1,1,'http://res.cloudinary.com/javadevgroup/image/upload/v1497805travelservice525/auto/bmw-x5-suv_gqaopv.jpg'),(3,2,'C300',2010,'AUTO','FULL','DIESEL',5,2,'http://res.cloudinary.com/javadevgroup/image/upload/v1497805529/auto/2015_mercedes-benz_c-class_sedan_c300_xbc5ol.jpg'),(4,3,'Mustang',1975,'MANUAL','REAR','PETROL',3,2,'http://res.cloudinary.com/javadevgroup/image/upload/v1497805531/auto/Lovely-Ford-Mustang_ploeiz.jpg'),(5,3,'Flex',2012,'AUTO','FULL','GAS',4,1,'http://res.cloudinary.com/javadevgroup/image/upload/v1497805525/auto/Ford-Flex-suv_rlhzej.jpg'),(6,2,'AMG',2015,'MANUAL','REAR','ELECTRO',3,4,'http://res.cloudinary.com/javadevgroup/image/upload/v1497805525/auto/Mercedes-AMG-C63S-Coupe_wqxpnc.jpg');
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto_order`
--

DROP TABLE IF EXISTS `auto_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auto_order` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto_order`
--

LOCK TABLES `auto_order` WRITE;
/*!40000 ALTER TABLE `auto_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `auto_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `body_type`
--

DROP TABLE IF EXISTS `body_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `body_type` (
  `id_body_type` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_body_type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `body_type`
--

LOCK TABLES `body_type` WRITE;
/*!40000 ALTER TABLE `body_type` DISABLE KEYS */;
INSERT INTO `body_type` VALUES (1,'SUV'),(2,'Sedan'),(3,'Minivan'),(4,'Coupe');
/*!40000 ALTER TABLE `body_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brand` (
  `id_brand` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_brand`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'BMW'),(2,'Mercedes'),(3,'Ford');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bus` (
  `id_bus` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `capacity` tinyint(3) NOT NULL,
  `registration_number` varchar(50) NOT NULL,
  PRIMARY KEY (`id_bus`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus`
--

LOCK TABLES `bus` WRITE;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT INTO `bus` VALUES (1,'MAZ 256170',24,'AH 6637-7'),(6,'Iveco',22,'AH 6347-7'),(7,'Mercedes Sprinter',8,'AH 6897-7'),(8,'Scania',30,'AH 6027-7');
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id_city` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_city`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Minsk'),(2,'Mogilev'),(3,'Brest'),(4,'Vitebsk');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `color` (
  `id_color` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_color`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (1,'black'),(2,'white'),(3,'blue'),(4,'red'),(5,'silver');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `gender` enum('Male','Female') NOT NULL,
  `birthday` date NOT NULL,
  `passport` varchar(9) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `driver_licence` enum('Yes','No') NOT NULL DEFAULT 'No',
  `id_role` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_customer`),
  UNIQUE KEY `passport` (`passport`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_number` (`phone_number`),
  KEY `FK_customer_role` (`id_role`),
  CONSTRAINT `FK_customer_role` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'user0','ÛÜ©×ºq','Tsovak','Palakian','Male','1990-06-05','AA1111111','tsovak@gmail.com','+375257018079','No',1),(2,'user1','ÛÜ©×ºq','Zhenya','Popovich','Male','1990-06-05','AA2222222','popo@gmail.com','+375297261647','Yes',1),(3,'user2','ÛÜ©×ºq','Dasha','Bortnik','Female','1990-06-11','AA3333333','dasha@gmail.com','+375299218769','Yes',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `id_hotel` smallint(6) NOT NULL AUTO_INCREMENT,
  `id_city` smallint(6) NOT NULL,
  `title` varchar(100) NOT NULL,
  `stars` enum('3','4','5') NOT NULL,
  `address` varchar(200) NOT NULL,
  PRIMARY KEY (`id_hotel`),
  KEY `FK_hotel_city` (`id_city`),
  CONSTRAINT `FK_hotel_city` FOREIGN KEY (`id_city`) REFERENCES `city` (`id_city`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,1,'\"Minsk\"','4','11 Nezavisimocti Ave.'),(2,1,'\"Renaissance\"','5','1E Dzerzhinskogo Ave.'),(3,1,'\"President\"','5','18 Kirova Str.'),(4,1,'\"Tourist\"','3','81 Partizanskiy Ave.'),(5,1,'\"Victoria Olimp\"','4','103 Pobediteley Ave.'),(6,1,'\"Beijing\"','5','36 Krasnoarmeiskaya Str.'),(7,1,'\"Marriott\"','5','20 Pobediteley Ave.'),(8,1,'\"Planeta\"','3','31 Pobediteley Ave'),(9,1,'\"Belarus\"','3','15 Storozhevskaya Str.'),(10,1,'\"Victoria\"','4','59 Pobediteley Ave.');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_order`
--

DROP TABLE IF EXISTS `hotel_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel_order` (
  `id_hotel_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_apartment` int(11) NOT NULL,
  `data_start` date NOT NULL,
  `data_end` date NOT NULL,
  `order_price` double(7,2) NOT NULL,
  PRIMARY KEY (`id_hotel_order`),
  KEY `FK_hotel_order_apartment` (`id_apartment`),
  CONSTRAINT `FK_hotel_order_apartment` FOREIGN KEY (`id_apartment`) REFERENCES `apartment` (`id_apartment`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_order`
--

LOCK TABLES `hotel_order` WRITE;
/*!40000 ALTER TABLE `hotel_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent_auto`
--

DROP TABLE IF EXISTS `rent_auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rent_auto` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_auto`
--

LOCK TABLES `rent_auto` WRITE;
/*!40000 ALTER TABLE `rent_auto` DISABLE KEYS */;
INSERT INTO `rent_auto` VALUES (1,1,1,'FREE',30.00),(2,2,1,'FREE',25.00),(3,3,2,'FREE',35.00),(4,4,1,'FREE',30.00),(5,6,3,'FREE',25.00),(6,5,1,'FREE',35.00);
/*!40000 ALTER TABLE `rent_auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id_role` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'customer'),(2,'admin_tour'),(3,'admin_hotel'),(4,'admin_auto'),(5,'vip_customer');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `id_room` smallint(6) NOT NULL AUTO_INCREMENT,
  `tv` enum('Yes','No') NOT NULL DEFAULT 'Yes',
  `balcony` enum('Yes','No') NOT NULL DEFAULT 'No',
  `conditioner` enum('Yes','No') NOT NULL DEFAULT 'No',
  PRIMARY KEY (`id_room`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'No','No','No'),(2,'Yes','No','No'),(3,'Yes','Yes','No'),(4,'Yes','Yes','Yes'),(5,'No','Yes','Yes'),(6,'No','No','Yes'),(7,'No','Yes','No'),(8,'Yes','No','Yes');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salon`
--

DROP TABLE IF EXISTS `salon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salon` (
  `id_salon` smallint(6) NOT NULL AUTO_INCREMENT,
  `id_city` smallint(6) NOT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY (`id_salon`),
  KEY `FK_salon_city` (`id_city`),
  CONSTRAINT `FK_salon_city` FOREIGN KEY (`id_city`) REFERENCES `city` (`id_city`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salon`
--

LOCK TABLES `salon` WRITE;
/*!40000 ALTER TABLE `salon` DISABLE KEYS */;
INSERT INTO `salon` VALUES (1,1,'2 Vsnetsova Str.'),(2,1,'14 Pushkina Str.'),(3,2,'13 Lermontov Str.'),(4,3,'25A Gogol Str. '),(5,4,'17 Mayakovsky Str.');
/*!40000 ALTER TABLE `salon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `total_order`
--

DROP TABLE IF EXISTS `total_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `total_order` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `total_order`
--

LOCK TABLES `total_order` WRITE;
/*!40000 ALTER TABLE `total_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `total_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tour` (
  `id_tour` int(11) NOT NULL AUTO_INCREMENT,
  `destination` varchar(500) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` enum('REST','TRIP','SHOP') NOT NULL,
  `description` text NOT NULL,
  `image` varchar(400) NOT NULL,
  PRIMARY KEY (`id_tour`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES (1,'Stankovo','Miracles of Stankovo Forest','REST','New Year\'s atmosphere lives here!','http://res.cloudinary.com/javadevgroup/image/upload/v1497429711/tourpics/stankovo_dtzzvp.jpg'),(5,'Belovezhskaya Puscha','National Park Belovezhskaya Puscha','TRIP','Belovezhskaya Puscha is included in the UNESCO World Heritage List.','http://res.cloudinary.com/javadevgroup/image/upload/v1497429704/tourpics/belobezhskaya_puscha_ecsm5n.jpg'),(6,'Naroch Land','Naroch Lakes','TRIP','The land of magnificent landscapes.','http://res.cloudinary.com/javadevgroup/image/upload/v1497429705/tourpics/narochansky_n460g1.jpg'),(7,'Postavy','Holiday in Solovyinaya Roscha (Postavy)','TRIP','Agroecotourist complex Solovyinaya Roscha looks like in a fairytale.','http://res.cloudinary.com/javadevgroup/image/upload/v1497429709/tourpics/pastavy_pficyz.jpg'),(8,'Berezinsky Biosphere Reserve','Berezinsky Biosphere Reserve','TRIP','Berezinsky Biosphere Reserve is a reserve, which is situated in the North of Belarus.','http://res.cloudinary.com/javadevgroup/image/upload/v1497429703/tourpics/berezinsky_rymh3u.jpg'),(9,'Novogrudok','Architectural memorials of Novogrudok','TRIP','Novogrudok is a city with a long history, the first capital of the Grand Duchy of Lithuania.','http://res.cloudinary.com/javadevgroup/image/upload/v1497429707/tourpics/novogrudok_bfioqa.jpg'),(10,'Mir','Architectural memorials of Mir','TRIP','In Mir you\'ll get to know the miracle ofbelarusian architecture — Mir castle.','http://res.cloudinary.com/javadevgroup/image/upload/v1497429706/tourpics/mirzamok_xlebe9.jpg'),(11,'Grodno','Shopping tour in Grodno','SHOP','Yuzhny market is considered to be the cheapest.','http://res.cloudinary.com/javadevgroup/image/upload/v1497429703/tourpics/grodno_ecgyw3.jpg'),(12,'Moscow','Shopping tour in Moscow','SHOP','Shopping complex Lyublino is the first multifunctional complex.','http://res.cloudinary.com/javadevgroup/image/upload/v1497429707/tourpics/moscow_x5jfxd.jpg'),(13,'Byalostok','Shopping tour in Byalostok','SHOP','Byalostok is assotiated with city-market, where each person finds something suitable for himself.','http://res.cloudinary.com/javadevgroup/image/upload/v1497429701/tourpics/bialystok_vzkpmo.jpg'),(14,'Vilnius','Shopping tour in Vilnius','SHOP','Garyunai market consists of two equal parts, the market is one of the largest markets in Eastern Europe.','http://res.cloudinary.com/javadevgroup/image/upload/v1497429711/tourpics/vilnius_mtto0b.jpg'),(15,'Red Pinewood','Rest in Red Pinewood','REST','Stay in a luxurious apartments in Red Pinewood, dinner in an elegant restaurant facing the lake, use finnish sauna and gym without limits.','http://res.cloudinary.com/javadevgroup/image/upload/v1497429719/tourpics/krasnybor_ywoeag.jpg'),(16,'Borovoe Sanatorium','Holiday in Borovoe Sanatoruim','REST','Belorussian sanatorium Borovoe is situated far from large cities and heavy traffic. ','http://res.cloudinary.com/javadevgroup/image/upload/v1497429709/tourpics/borovoe_kqwqoh.jpg'),(17,'Naroch','Priozerny Sanatorium','REST','Unique landsape and natural resources of Naroch has always attrached lots of tourists.','http://res.cloudinary.com/javadevgroup/image/upload/v1497429708/tourpics/priozerny_zpukgu.jpg'),(18,'Sosny','Sosny Sanatorium','REST','Sosny is one of the best belausian sanatoriums with 40-years experience in  resort therapy.','http://res.cloudinary.com/javadevgroup/image/upload/v1497429713/tourpics/sosny_v9ielg.jpg');
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour_offer`
--

DROP TABLE IF EXISTS `tour_offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tour_offer` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour_offer`
--

LOCK TABLES `tour_offer` WRITE;
/*!40000 ALTER TABLE `tour_offer` DISABLE KEYS */;
INSERT INTO `tour_offer` VALUES (1,1,1,'2017-12-20','2017-12-21',24,55.00,'NO'),(10,5,8,'2017-06-27','2017-06-28',30,40.00,'NO'),(11,6,6,'2017-07-03','2017-07-05',22,76.00,'NO'),(14,7,1,'2017-06-28','2017-07-03',24,89.00,'NO'),(15,8,6,'2017-06-18','2017-06-19',22,45.00,'NO'),(16,9,7,'2017-06-20','2017-06-21',8,62.00,'NO'),(17,10,8,'2017-06-20','2017-06-21',30,58.00,'NO'),(18,11,8,'2017-06-18','2017-06-19',30,54.00,'NO'),(19,12,1,'2017-06-19','2017-06-21',24,35.00,'NO'),(20,13,6,'2017-07-08','2017-07-11',22,40.00,'NO'),(21,14,8,'2017-07-22','2017-07-24',30,51.00,'NO'),(22,15,7,'2017-07-12','2017-07-20',8,157.00,'NO'),(23,16,6,'2017-07-13','2017-07-26',22,116.00,'NO'),(24,17,1,'2017-07-08','2017-07-18',24,140.00,'NO'),(25,18,1,'2017-07-21','2017-06-28',24,95.00,'NO');
/*!40000 ALTER TABLE `tour_offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour_order`
--

DROP TABLE IF EXISTS `tour_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tour_order` (
  `id_tour_order` int(4) NOT NULL AUTO_INCREMENT,
  `id_tour_offer` int(4) NOT NULL,
  `person_number` tinyint(3) NOT NULL DEFAULT '1',
  `order_price` double(7,2) NOT NULL,
  PRIMARY KEY (`id_tour_order`),
  KEY `FK_tour_order_tour_offer` (`id_tour_offer`),
  CONSTRAINT `FK_tour_order_tour_offer` FOREIGN KEY (`id_tour_offer`) REFERENCES `tour_offer` (`id_tour_offer`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour_order`
--

LOCK TABLES `tour_order` WRITE;
/*!40000 ALTER TABLE `tour_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `tour_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-05 16:43:49
