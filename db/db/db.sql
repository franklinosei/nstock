CREATE DATABASE  IF NOT EXISTS `nstock` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `nstock`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: nstock
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authentication`
--

DROP TABLE IF EXISTS `authentication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authentication` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authentication`
--

LOCK TABLES `authentication` WRITE;
/*!40000 ALTER TABLE `authentication` DISABLE KEYS */;
INSERT INTO `authentication` VALUES (8,'kayibue@gmail.com','$2a$12$QUge3Zkv2tiJK1wst2uAROWQM/lfFA4ru2w2k3HwV1OQiXBw08p9u'),(9,'sirefrancklyn@gmail.com','$2a$12$mEEy0iMbabn8YJgHsEQwDOxy2O2Owl.FoGjD1/0A5LzYRzdyh.8hm');
/*!40000 ALTER TABLE `authentication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_types`
--

DROP TABLE IF EXISTS `item_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_types` (
  `typeID` int NOT NULL AUTO_INCREMENT,
  `typeName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`typeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_types`
--

LOCK TABLES `item_types` WRITE;
/*!40000 ALTER TABLE `item_types` DISABLE KEYS */;
INSERT INTO `item_types` VALUES (1,'Laptop'),(2,'Desktop');
/*!40000 ALTER TABLE `item_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `itemID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `faulty` tinyint DEFAULT '0',
  `typeID` int DEFAULT NULL,
  `photo` varchar(512) DEFAULT NULL,
  `serialNumber` varchar(45) DEFAULT NULL,
  `labID` int DEFAULT NULL,
  `managerID` int DEFAULT NULL,
  `specID` int DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`itemID`),
  KEY `FK_ITEM_LABS_idx` (`labID`),
  KEY `FK_ITEM_TYPE_idx` (`typeID`),
  KEY `FK_MANAGER_idx` (`managerID`),
  KEY `FK_SPEC_idx` (`specID`),
  CONSTRAINT `FK_ITEM_LABS` FOREIGN KEY (`labID`) REFERENCES `labs` (`labID`),
  CONSTRAINT `FK_ITEM_TYPE` FOREIGN KEY (`typeID`) REFERENCES `item_types` (`typeID`),
  CONSTRAINT `FK_MANAGER` FOREIGN KEY (`managerID`) REFERENCES `managers` (`managerID`),
  CONSTRAINT `FK_SPEC` FOREIGN KEY (`specID`) REFERENCES `specifications` (`specID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (7,'Thinkpad','The best thinkpad!',0,1,'https://unsplash.com/photos/OWabN5X6xOQ/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8OHx8YmxhY2slMjBtYW58ZW58MHwwfHx8MTY4NTg2ODI5OHww&force=true&w=640','dxfgvxgbdfzxcv1245',4,9,NULL,'2023-06-04 12:44:09','2023-06-04 12:44:09',0);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `labs`
--

DROP TABLE IF EXISTS `labs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `labs` (
  `labID` int NOT NULL AUTO_INCREMENT,
  `labName` varchar(256) DEFAULT NULL,
  `city` varchar(256) DEFAULT NULL,
  `region` varchar(128) DEFAULT NULL,
  `photo` varchar(512) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`labID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `labs`
--

LOCK TABLES `labs` WRITE;
/*!40000 ALTER TABLE `labs` DISABLE KEYS */;
INSERT INTO `labs` VALUES (4,'Nasco Accra','Accra','Greater Accra Region','https://unsplash.com/photos/SYTO3xs06fU/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8NXx8Y29tcHV0ZXIlMjBsYWJ8ZW58MHx8fHwxNjg1NTA4NDM0fDA&force=true&w=640','2023-05-31 16:09:39','2023-05-31 17:36:42',0);
/*!40000 ALTER TABLE `labs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managers`
--

DROP TABLE IF EXISTS `managers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `managers` (
  `managerID` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `gender` varchar(128) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `photo` varchar(512) DEFAULT NULL,
  `roleID` int DEFAULT NULL,
  `labID` int DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`managerID`),
  KEY `FK_ROLES_idx` (`roleID`),
  KEY `FK_LABS_idx` (`labID`),
  CONSTRAINT `FK_LABS` FOREIGN KEY (`labID`) REFERENCES `labs` (`labID`),
  CONSTRAINT `FK_ROLES` FOREIGN KEY (`roleID`) REFERENCES `roles` (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managers`
--

LOCK TABLES `managers` WRITE;
/*!40000 ALTER TABLE `managers` DISABLE KEYS */;
INSERT INTO `managers` VALUES (9,'Franklin','Osei','Male','+233542480050','kayibue@gmail.com','Madina','2023-06-01','https://unsplash.com/photos/OWabN5X6xOQ/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8OHx8YmxhY2slMjBtYW58ZW58MHwwfHx8MTY4NTg2ODI5OHww&force=true&w=640',1,4,'2023-06-04 12:31:35','2023-06-04 12:31:35',0),(10,'Sire','Francklyn','Male','0500148832','sirefrancklyn@gmail.com','University of Ghana','2023-06-01','https://unsplash.com/photos/SYTO3xs06fU/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8NXx8Y29tcHV0ZXIlMjBsYWJ8ZW58MHx8fHwxNjg1NTA4NDM0fDA&force=true&w=640',2,4,'2023-06-04 12:45:52','2023-06-04 12:45:52',0);
/*!40000 ALTER TABLE `managers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `roleID` int NOT NULL AUTO_INCREMENT,
  `roleName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Manager'),(2,'Technician');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specifications`
--

DROP TABLE IF EXISTS `specifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specifications` (
  `specID` int NOT NULL AUTO_INCREMENT,
  `ramSize` int DEFAULT NULL,
  `storageSize` int DEFAULT NULL,
  `screenSize` float DEFAULT NULL,
  PRIMARY KEY (`specID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specifications`
--

LOCK TABLES `specifications` WRITE;
/*!40000 ALTER TABLE `specifications` DISABLE KEYS */;
/*!40000 ALTER TABLE `specifications` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-04 12:49:11
