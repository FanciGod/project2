-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: project
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Dumping data for table `abort`
--

LOCK TABLES `abort` WRITE;
/*!40000 ALTER TABLE `abort` DISABLE KEYS */;
/*!40000 ALTER TABLE `abort` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `abort_detail`
--

LOCK TABLES `abort_detail` WRITE;
/*!40000 ALTER TABLE `abort_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `abort_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (3,'admin','1',NULL,1,0),(4,'letien','123',NULL,2,0),(5,'tienle','123',NULL,2,0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bill_detail`
--

LOCK TABLES `bill_detail` WRITE;
/*!40000 ALTER TABLE `bill_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Smart Phone'),(2,'Laptop'),(3,'Desktop'),(5,'Headphone'),(6,'Earphone'),(7,'Charger'),(8,'Screen');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `inventory_detail`
--

LOCK TABLES `inventory_detail` WRITE;
/*!40000 ALTER TABLE `inventory_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'MSI Bravo15',15000000,10000000,12,2,NULL,2,NULL,0),(2,'Iphone Xr',10000000,8000000,10,1,NULL,4,NULL,0),(3,'VGA RTX 3060',30000000,25000000,12,3,NULL,1,NULL,0),(4,'Iphone 15',50000000,47000000,30,1,NULL,1,NULL,0),(8,'AirPod Pro',3000000,3200000,10,6,NULL,4,NULL,0),(13,'AirPod 3',3400000,3000000,100,6,NULL,4,NULL,0),(14,'Sony WH-CH520',1290000,1100000,30,5,NULL,1,NULL,0),(16,'Galaxy Z Flip5',14990000,12890000,30,1,NULL,5,NULL,0),(17,'Dell Vostro 15 V3520 i5',18000000,16000000,10,2,NULL,3,NULL,0),(18,'Iphone X',8000000,6000000,100,1,NULL,4,NULL,0),(19,'Iphone 8',6000000,5000000,10,1,NULL,4,NULL,0),(20,'Iphone Xs',10000000,8000000,100,1,NULL,4,NULL,0),(21,'Iphone 14',34000000,30000000,19,1,NULL,4,NULL,0),(22,'Iphone 13',29999000,25000000,10,1,NULL,4,NULL,0),(23,'Sony UCH20C',899000,700000,100,7,NULL,1,NULL,0),(24,'Samsung Galaxy Buds 2 Pro',4000000,3390000,13,6,NULL,5,NULL,0),(25,'Iphone 13 Promax',32000000,30000000,20,1,NULL,4,NULL,0),(26,'Iphone 14 Promax',38000000,35000000,20,1,NULL,4,NULL,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `purchase_detail`
--

LOCK TABLES `purchase_detail` WRITE;
/*!40000 ALTER TABLE `purchase_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `return_to_client`
--

LOCK TABLES `return_to_client` WRITE;
/*!40000 ALTER TABLE `return_to_client` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_to_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `return_to_client_detail`
--

LOCK TABLES `return_to_client_detail` WRITE;
/*!40000 ALTER TABLE `return_to_client_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_to_client_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `return_to_supplier`
--

LOCK TABLES `return_to_supplier` WRITE;
/*!40000 ALTER TABLE `return_to_supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_to_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `return_to_supplier_detail`
--

LOCK TABLES `return_to_supplier_detail` WRITE;
/*!40000 ALTER TABLE `return_to_supplier_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_to_supplier_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'employee');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'Sony','Korea','0948247756'),(2,'MSI','HN','0773567789'),(3,'Dell','HN','0341231245'),(4,'Apple','US','0112314142'),(5,'Samsung','Korea','0758446373'),(6,'Asus','taiwan','0948663545');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-30 17:05:17
