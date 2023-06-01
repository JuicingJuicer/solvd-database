CREATE DATABASE  IF NOT EXISTS `building` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `building`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: building
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Dumping data for table `building_type`
--

LOCK TABLES `building_type` WRITE;
/*!40000 ALTER TABLE `building_type` DISABLE KEYS */;
INSERT INTO `building_type` VALUES (1,'High school','EDUCATIONAL',NULL),(2,'Office','BUSINESS',NULL),(3,'Retail','BUSINESS',NULL),(4,'House','RESIDENTIAL',NULL),(5,'Hotel','BUSINESS',NULL),(6,'Warehouse','STORAGE',NULL),(7,'Garage','STORAGE',NULL),(8,'Distribution center','INDUSTRIAL',NULL),(9,'Call center','INDUSTRIAL',NULL),(10,'Cottage','RESIDENTIAL',NULL);
/*!40000 ALTER TABLE `building_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'San Jose',5),(2,'Phoenix',3),(3,'Miami',9),(4,'Montgomery',1),(5,'Atlanta',10);
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `client_projects`
--

LOCK TABLES `client_projects` WRITE;
/*!40000 ALTER TABLE `client_projects` DISABLE KEYS */;
INSERT INTO `client_projects` VALUES (1,4,1);
/*!40000 ALTER TABLE `client_projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Rahal','Struttman','rstruttman0@ebay.co.uk','8935655135',NULL),(2,'Cecily','Fullun','cfullun1@weibo.com','5553929469',NULL),(3,'Sibilla','Busain','sbusain2@netscape.com','4755039856','City of San Jose'),(4,'Hannah','Broadist','hbroadist3@blogger.com','4019929521',NULL),(5,'Woodie','Abdy','wabdy4@webmd.com','2072049337',NULL);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `emp_teams`
--

LOCK TABLES `emp_teams` WRITE;
/*!40000 ALTER TABLE `emp_teams` DISABLE KEYS */;
INSERT INTO `emp_teams` VALUES (1,1,1),(3,3,1),(5,5,1),(7,7,1),(10,10,1),(12,12,1),(2,2,2),(4,4,2),(6,6,2),(8,8,2),(9,9,2),(11,11,2);
/*!40000 ALTER TABLE `emp_teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Gene','Bassett',33,'gbassett0@myspace.com','8802432507',1),(2,'Chaddy','McGoldrick',52,'cmcgoldrick1@goodreads.com','6999921215',2),(3,'Kania','Cardinale',49,'kcardinale2@washington.edu','5359031892',3),(4,'Dru','O\'Cahill',23,'docahill3@usatoday.com','3796320272',4),(5,'Minna','Dobbinson',45,'mdobbinson4@newyorker.com','5179114054',5),(6,'Tarra','Djurevic',47,'tdjurevic5@goo.ne.jp','6602731862',6),(7,'Marlee','Rewcastle',48,'mrewcastle6@over-blog.com','8948614274',2),(8,'Sal','Cadge',51,'scadge7@slideshare.net','7908153083',5),(9,'Buckie','Lesek',57,'blesek8@hp.com','9782814433',3),(10,'Noll','Reuter',45,'nreuter9@fc2.com','1896454790',6),(11,'Michael','Vu',31,'mvu3@yahoo.com','9548312423',1),(12,'Jason','Leonard',28,'jleonard2@gmail.com','2092813451',4);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (1,'Construction Manager'),(2,'Civil Engineer'),(3,'Cost Estimator'),(4,'Safety Manager'),(5,'Construction Laborer'),(6,'Equipment Operator');
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` VALUES (1,'Wood','1 cord of wood',500),(2,'Granite','per cubic year',80),(3,'Glass','per square foot',25),(4,'Concrete','per cubic yard',120),(5,'Brick','per square foot',7),(6,'Steel','per square foot',15);
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `package_details`
--

LOCK TABLES `package_details` WRITE;
/*!40000 ALTER TABLE `package_details` DISABLE KEYS */;
INSERT INTO `package_details` VALUES (1,1,1,15),(2,1,3,300),(3,1,4,9),(4,1,5,200),(5,1,6,70);
/*!40000 ALTER TABLE `package_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `packages`
--

LOCK TABLES `packages` WRITE;
/*!40000 ALTER TABLE `packages` DISABLE KEYS */;
INSERT INTO `packages` VALUES (1,'2023-05-29','Invoiced',1);
/*!40000 ALTER TABLE `packages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `phases`
--

LOCK TABLES `phases` WRITE;
/*!40000 ALTER TABLE `phases` DISABLE KEYS */;
INSERT INTO `phases` VALUES (1,'Initiation'),(2,'Pre-Construction'),(3,'Procurement'),(4,'Construction'),(5,'Closeout');
/*!40000 ALTER TABLE `phases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'Homeland',4,1,'2023-05-29',NULL,1,1),(2,'Project Z',2,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `site`
--

LOCK TABLES `site` WRITE;
/*!40000 ALTER TABLE `site` DISABLE KEYS */;
INSERT INTO `site` VALUES (1,'1100 e northern ave',2,85020);
/*!40000 ALTER TABLE `site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` VALUES (1,'Alabama'),(2,'Alaska'),(3,'Arizona'),(4,'Arkansas'),(5,'California'),(6,'Colorado'),(7,'Connecticut'),(8,'Delaware'),(9,'Florida'),(10,'Georgia'),(11,'Hawaii'),(12,'Idaho'),(13,'Illinois'),(14,'Indiana'),(15,'Iowa'),(16,'Kansas'),(17,'Kentucky'),(18,'Louisiana'),(19,'Maine'),(20,'Maryland'),(21,'Massachusetts'),(22,'Michigan'),(23,'Minnesota'),(24,'Mississippi'),(25,'Missouri');
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'Team A',NULL),(2,'Team B',NULL),(3,'Team C',NULL);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-01  4:37:31
