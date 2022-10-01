-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: ticket_booking_task
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movies` (
  `movie_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(45) DEFAULT NULL,
  `movie_language` varchar(45) DEFAULT NULL,
  `movie_hour` varchar(45) DEFAULT NULL,
  `movie_type` varchar(45) DEFAULT NULL,
  `movie_date` datetime DEFAULT NULL,
  `movie_status` varchar(45) DEFAULT NULL,
  `datecreated` datetime DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Blood Sisters','English','3hrs','ENGLISH','2022-11-05 00:00:00','Movie_Available','2022-10-01 05:59:39'),(3,'The man for the job','English','2hrs','ENGLISH','2022-02-11 00:00:00','Movie_Available','2022-09-28 22:04:59'),(4,'Woman King','English','1hrs','ENGLISH','2022-10-01 00:00:00','Movie_Available','2022-10-01 05:46:20'),(5,'Thirteen Lives','English','2hrs','ENGLISH','2022-10-05 00:00:00','Movie_Available','2022-10-01 06:08:05'),(6,'Spider Man','English','3hrs','ENGLISH','2022-11-05 00:00:00','Movie_Available','2022-10-01 06:31:01');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `customer` bigint(20) DEFAULT NULL,
  `ticket` bigint(20) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `datecreated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user12_idx` (`customer`),
  KEY `fk_tbb_idx` (`ticket`),
  CONSTRAINT `fk_tbb` FOREIGN KEY (`ticket`) REFERENCES `tbooking` (`tbooking_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user12` FOREIGN KEY (`customer`) REFERENCES `users` (`users_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (2,500,1,2,'PAID','2022-09-29 16:44:35'),(18,5000,3,4,'PAID','2022-09-29 21:30:59'),(24,5000,3,2,'PAID','2022-09-29 22:04:15'),(26,5000,3,1,'PAID','2022-09-29 22:25:07'),(28,1000,3,4,'PAID','2022-10-01 06:59:07'),(29,1000,3,4,'PAID','2022-10-01 07:01:12'),(30,1000,3,4,'PAID','2022-10-01 07:03:47'),(31,1000,3,4,'PAID','2022-10-01 07:06:41'),(32,1000,3,4,'PAID','2022-10-01 07:07:02'),(33,1000,3,4,'PAID','2022-10-01 07:07:28'),(34,1000,3,4,'PAID','2022-10-01 07:08:55'),(35,1000,3,4,'PAID','2022-10-01 07:09:22'),(36,1000,1,4,'PAID','2022-10-01 07:09:42'),(37,1000,1,4,'PAID','2022-10-01 07:11:15'),(38,1000,1,4,'PAID','2022-10-01 07:13:23'),(39,1000,4,6,'PAID','2022-10-01 07:15:30');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbooking`
--

DROP TABLE IF EXISTS `tbooking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbooking` (
  `tbooking_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tbooking_user` bigint(20) DEFAULT NULL,
  `tbooking_movie` bigint(20) DEFAULT NULL,
  `tbooking_booked_date` datetime DEFAULT NULL,
  `tbooking_movie_timing` datetime DEFAULT NULL,
  `datecreated` datetime DEFAULT NULL,
  `ticket_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tbooking_id`),
  KEY `fk_user_idx` (`tbooking_user`),
  KEY `fk_movie_idx` (`tbooking_movie`),
  CONSTRAINT `fk_movie` FOREIGN KEY (`tbooking_movie`) REFERENCES `movies` (`movie_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user` FOREIGN KEY (`tbooking_user`) REFERENCES `users` (`users_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbooking`
--

LOCK TABLES `tbooking` WRITE;
/*!40000 ALTER TABLE `tbooking` DISABLE KEYS */;
INSERT INTO `tbooking` VALUES (1,1,1,'2022-01-10 00:00:00','2022-01-11 00:00:00','2022-09-28 22:28:16','AAO'),(2,1,1,'2022-01-10 00:00:00','2022-01-12 00:00:00','2022-09-28 22:30:25','AA1'),(4,3,1,'2022-01-23 00:00:00','2022-01-25 00:00:00','2022-09-28 22:42:43','ACA'),(5,3,1,'2022-01-23 00:00:00','2022-01-25 00:00:00','2022-09-28 22:47:31','ARA'),(6,4,6,'2022-01-23 00:00:00','2022-01-25 00:00:00','2022-10-01 06:37:53','AHS');
/*!40000 ALTER TABLE `tbooking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `users_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `users_name` varchar(45) DEFAULT NULL,
  `users_mobile_no` varchar(45) DEFAULT NULL,
  `users_email` varchar(45) DEFAULT NULL,
  `users_address` text,
  `password` varchar(45) DEFAULT NULL,
  `datecreated` datetime DEFAULT NULL,
  PRIMARY KEY (`users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Atobatele Sunkanmi','08137489526','balo@gmail.com','Ibadan','balomoneys','2022-09-28 12:45:28'),(3,'Adwale Dada','07033215343','atobateleolasunkanmi@yahoo.com','Lagos','sunkanmi','2022-09-28 12:35:21'),(4,'Balogun Funmbi','08142868888','balo@gmail.com','Abeokuta','balomoney','2022-09-28 12:36:55'),(6,'Onabanjo Oreoluwa Aanu','09092303462','ore@termii.com','Lagos','ore1234','2022-10-01 05:37:26');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-01  8:31:56
