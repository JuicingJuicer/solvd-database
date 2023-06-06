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
-- Dumping data for table `building_types`
--

LOCK TABLES `building_types` WRITE;
/*!40000 ALTER TABLE `building_types` DISABLE KEYS */;
INSERT INTO `building_types` VALUES (1,'High school','EDUCATIONAL',NULL),(2,'Office','BUSINESS',NULL),(3,'Retail','BUSINESS',NULL),(4,'House','RESIDENTIAL',NULL),(5,'Hotel','BUSINESS',NULL),(6,'Warehouse','STORAGE',NULL),(7,'Garage','STORAGE',NULL),(8,'Distribution center','INDUSTRIAL',NULL),(9,'Call center','INDUSTRIAL',NULL),(10,'Cottage','RESIDENTIAL',NULL);
/*!40000 ALTER TABLE `building_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'San Jose',1),(2,'Phoenix',3),(3,'Miami',9),(4,'Montgomery',1),(5,'Atlanta',10),(6,'Kansas City',16),(7,'Minneapolis',23),(8,'Denver',6),(9,'Baltimore',20),(10,'Detroit',22);
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `client_projects`
--

LOCK TABLES `client_projects` WRITE;
/*!40000 ALTER TABLE `client_projects` DISABLE KEYS */;
INSERT INTO `client_projects` VALUES (1,4,1),(4,11,2),(9,12,2),(7,10,3),(6,2,4),(2,7,5),(5,4,6),(8,6,7),(3,9,8);
/*!40000 ALTER TABLE `client_projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Rahal','Struttman','rstruttman0@ebay.co.uk','8935655135',NULL),(2,'Cecily','Fullun','cfullun1@weibo.com','5553929469',NULL),(3,'Sibilla','Busain','sbusain2@netscape.com','4755039856','City of San Jose'),(4,'Hannah','Broadist','hbroadist3@blogger.com','4019929521',NULL),(5,'Woodie','Abdy','wabdy4@webmd.com','2072049337',NULL),(6,'Alli','Christofle','achristofle0@artisteer.com','7504316217',NULL),(7,'Florian','Darleston','fdarleston1@networksolutions.com','7011887357','Miami School District'),(8,'Lynne','Tunnadine','ltunnadine2@usnews.com','6128351678',NULL),(9,'Dillie','Mundy','dmundy3@zdnet.com','4026737270','Fedex'),(10,'Abe','Weiner','aweiner4@opera.com','2805627682',NULL),(11,'Kikelia','Overbury','koverbury5@hugedomains.com','3966478233',NULL),(12,'Ursa','Lamerton','ulamerton6@smh.com.au','8478491126',NULL);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `emp_teams`
--

LOCK TABLES `emp_teams` WRITE;
/*!40000 ALTER TABLE `emp_teams` DISABLE KEYS */;
INSERT INTO `emp_teams` VALUES (1,1,1),(3,3,1),(5,5,1),(7,7,1),(10,10,1),(12,12,1),(2,2,2),(4,4,2),(6,6,2),(8,8,2),(9,9,2),(11,11,2),(12,17,3),(13,25,3),(14,30,3),(17,20,4),(16,23,4),(15,26,4);
/*!40000 ALTER TABLE `emp_teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Gene','Bassett',33,'gbassett0@myspace.com','8802432507',1),(2,'Chaddy','McGoldrick',52,'cmcgoldrick1@goodreads.com','6999921215',2),(3,'Kania','Cardinale',49,'kcardinale2@washington.edu','5359031892',3),(4,'Dru','O\'Cahill',23,'docahill3@usatoday.com','3796320272',4),(5,'Minna','Dobbinson',45,'mdobbinson4@newyorker.com','5179114054',5),(6,'Tarra','Djurevic',47,'tdjurevic5@goo.ne.jp','6602731862',6),(7,'Marlee','Rewcastle',48,'mrewcastle6@over-blog.com','8948614274',2),(8,'Sal','Cadge',51,'scadge7@slideshare.net','7908153083',5),(9,'Buckie','Lesek',57,'blesek8@hp.com','9782814433',3),(10,'Noll','Reuter',45,'nreuter9@fc2.com','1896454790',6),(11,'Michael','Vu',31,'mvu3@yahoo.com','9548312423',1),(12,'Jason','Leonard',28,'jleonard2@gmail.com','2092813451',4),(13,'Debera','Guilaem',51,'dguilaem0@hibu.com','3499692275',3),(14,'Aubree','Highnam',47,'ahighnam1@cmu.edu','4702996946',6),(15,'Tiphani','Polson',35,'tpolson2@samsung.com','6284517108',4),(16,'Grove','Bannerman',51,'gbannerman3@spotify.com','7538712942',6),(17,'Germaine','Henmarsh',37,'ghenmarsh4@histats.com','6911289689',1),(18,'Aleksandr','Drogan',47,'adrogan5@quantcast.com','9876932656',5),(19,'Rey','Donnachie',58,'rdonnachie6@cpanel.net','5096856000',5),(20,'Courtenay','Hassell',19,'chassell7@huffingtonpost.com','7846042338',5),(21,'Jacklyn','Linnemann',44,'jlinnemann8@dagondesign.com','8265576674',6),(22,'Mannie','Quennell',25,'mquennell9@netvibes.com','5393393807',3),(23,'Nathanael','Sobtka',23,'nsobtkaa@ted.com','2178386207',2),(24,'Grantley','Merry',40,'gmerryb@qq.com','9498469976',5),(25,'Jamey','Gipp',52,'jgippc@mapquest.com','6765273268',2),(26,'Sissie','Sjostrom',42,'ssjostromd@dmoz.org','8265704126',1),(27,'Homere','Lideard',48,'hlidearde@sbwire.com','1713725913',4),(28,'Chancey','McLorinan',27,'cmclorinanf@sakura.ne.jp','8856301654',2),(29,'Aloisia','Goward',60,'agowardg@mayoclinic.com','4015366247',5),(30,'Margo','Skrzynski',55,'mskrzynskih@moonfruit.com','8418838576',6);
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
INSERT INTO `projects` VALUES (1,'Homeland',4,1,'2023-05-29',NULL,1,1),(2,'Project Z',2,NULL,NULL,NULL,NULL,NULL),(3,'Abe\'s Hotel',5,NULL,NULL,NULL,NULL,NULL),(4,'Speaker warehouse',6,NULL,NULL,NULL,NULL,1),(5,'Miami High school',1,NULL,NULL,NULL,NULL,NULL),(6,'Shoe store',3,NULL,NULL,NULL,NULL,NULL),(7,'Dream garage',7,NULL,NULL,NULL,NULL,NULL),(8,'Fedex center',8,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sites`
--

LOCK TABLES `sites` WRITE;
/*!40000 ALTER TABLE `sites` DISABLE KEYS */;
INSERT INTO `sites` VALUES (1,'1100 e northern ave',2,85020);
/*!40000 ALTER TABLE `sites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` VALUES (1,'Alabama'),(2,'Alaska'),(3,'Arizona'),(4,'Arkansas'),(5,'California'),(6,'Colorado'),(7,'Connecticut'),(8,'Delaware'),(9,'Florida'),(10,'Georgia'),(11,'Hawaii'),(12,'Idaho'),(13,'Illinois'),(14,'Indiana'),(15,'Iowa'),(16,'Kansas'),(17,'Kentucky'),(18,'Louisiana'),(19,'Maine'),(20,'Maryland'),(21,'Massachusetts'),(22,'Michigan'),(23,'Minnesota'),(24,'Mississippi'),(25,'Missouri'),(26,'Montana'),(27,'Nebraska'),(28,'Nevada'),(29,'New Hampshire'),(30,'New Jersey'),(31,'New Mexico'),(32,'New York'),(33,'North Carolina'),(34,'North Dakota'),(35,'Ohio'),(36,'Oklahoma'),(37,'Oregon'),(38,'Pennsylvania'),(39,'Rhode Island'),(40,'South Carolina'),(41,'South Dakota'),(42,'Tennessee'),(43,'Texas'),(44,'Utah'),(45,'Vermont'),(46,'Virginia'),(47,'Washington'),(48,'West Virginia'),(49,'Wisconsin'),(50,'Wyoming');
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'Team A',NULL),(2,'Team B',NULL),(3,'Team C',NULL),(4,'Team D',NULL),(5,'Team E',NULL),(6,'Team F',NULL),(7,'Team G',NULL),(8,'Team H',NULL);
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

-- Dump completed on 2023-06-06  8:40:46
