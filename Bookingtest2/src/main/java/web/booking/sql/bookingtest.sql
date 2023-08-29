CREATE DATABASE  IF NOT EXISTS `head` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `head`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: head
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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `ARTICLE_NO` int NOT NULL AUTO_INCREMENT,
  `MEM_NO` int NOT NULL,
  `ARTICLE_TITLE` varchar(120) DEFAULT NULL,
  `ARTICLE_CONTENT` text NOT NULL,
  `ARTICLE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ARTICLE_STATE` tinyint NOT NULL COMMENT '0:不顯示 1:顯示',
  PRIMARY KEY (`ARTICLE_NO`),
  KEY `MEM_NO` (`MEM_NO`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`MEM_NO`) REFERENCES `member` (`MEM_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,1002,'【情報】有人對Dice Throne（骰權王座）有興趣嗎？','最近被這個募資打到，用骰子對戰這點滿適合我這個策略苦手的\n有人也對這款有興趣嗎？想聽聽大家意見','2023-08-02 21:25:30',1),(2,1002,'【心得】緊張刺激的紐約黑幫私酒爭奪戰！---黑手黨：紐約對決(MOB)','整體心得：\n整個遊戲流程玩下來其實不到一小時，因為遊戲只有三輪，時長不會拉太長，個人玩下來體感約30分鐘左右。玩家的互動性很夠。推薦！','2023-08-02 21:25:30',1),(3,1001,'【問題】求推薦至少五人以上桌遊','目前有Bang／13道線索／風聲／阿瓦隆。想找個幾款派對或陣營類補充下，平常大概5或6人玩偶爾會到8~9個!','2023-08-02 21:25:30',1),(4,1003,'【其他】6/10宜蘭桌遊團','主題：6/10宜蘭桌遊團，時間：6/10（六）13:00～18:00，地點：捌咖啡，260宜蘭縣宜蘭市崇聖街23號2樓，費用：低消飲料，\n陣營遊戲：阿瓦隆，亞瑟傳奇留言或私訊報名','2023-08-02 21:25:30',1);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_favorites`
--

DROP TABLE IF EXISTS `article_favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_favorites` (
  `ARTICLE_NO` int NOT NULL,
  `MEM_NO` int NOT NULL,
  PRIMARY KEY (`ARTICLE_NO`,`MEM_NO`),
  CONSTRAINT `article_favorites_ibfk_1` FOREIGN KEY (`ARTICLE_NO`) REFERENCES `article` (`ARTICLE_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_favorites`
--

LOCK TABLES `article_favorites` WRITE;
/*!40000 ALTER TABLE `article_favorites` DISABLE KEYS */;
INSERT INTO `article_favorites` VALUES (1,1001),(2,1002),(3,1003),(4,1002);
/*!40000 ALTER TABLE `article_favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_report`
--

DROP TABLE IF EXISTS `article_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_report` (
  `ARTICLE_REPORT_NO` int NOT NULL AUTO_INCREMENT,
  `ARTICLE_NO` int NOT NULL,
  `MEM_NO` int NOT NULL,
  `REP_WHY` varchar(120) DEFAULT NULL,
  `REP_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `REP_STATE` tinyint NOT NULL DEFAULT '0' COMMENT '0:未處理 1:處理成功 2:處理失敗',
  `REP_DONETIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ARTICLE_REPORT_NO`),
  KEY `MEM_NO` (`MEM_NO`),
  KEY `ARTICLE_NO` (`ARTICLE_NO`),
  CONSTRAINT `article_report_ibfk_1` FOREIGN KEY (`MEM_NO`) REFERENCES `member` (`MEM_NO`),
  CONSTRAINT `article_report_ibfk_2` FOREIGN KEY (`ARTICLE_NO`) REFERENCES `article` (`ARTICLE_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_report`
--

LOCK TABLES `article_report` WRITE;
/*!40000 ALTER TABLE `article_report` DISABLE KEYS */;
INSERT INTO `article_report` VALUES (1,1,1001,'髒話連篇!','2023-08-02 21:31:35',2,'2023-08-02 21:31:35'),(2,1,1002,'散撥色情','2023-08-02 21:31:35',1,'2023-08-02 21:31:35'),(3,2,1003,'有18禁圖片','2023-08-02 21:31:35',1,'2023-08-02 21:31:35'),(4,3,1002,'有暴力傾向','2023-08-02 21:31:35',0,'2023-08-02 21:31:35');
/*!40000 ALTER TABLE `article_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authority` (
  `EMP_NO` int NOT NULL,
  `FUNC_NO` varchar(10) NOT NULL,
  PRIMARY KEY (`EMP_NO`,`FUNC_NO`),
  KEY `FUNC_NO` (`FUNC_NO`),
  CONSTRAINT `authority_ibfk_1` FOREIGN KEY (`EMP_NO`) REFERENCES `employee` (`EMP_NO`),
  CONSTRAINT `authority_ibfk_2` FOREIGN KEY (`FUNC_NO`) REFERENCES `function` (`FUNC_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'F001'),(1,'F002'),(3,'F002'),(5,'F002'),(2,'F003'),(3,'F003'),(4,'F003'),(4,'F004'),(5,'F004'),(6,'F005'),(2,'F006'),(6,'F006'),(7,'F007'),(8,'F007'),(2,'F008'),(6,'F008');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bid_item`
--

DROP TABLE IF EXISTS `bid_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bid_item` (
  `BID_ITEM_NO` int NOT NULL,
  `ITEM_CLASS_NO` int NOT NULL,
  `BIDDING_STATE` tinyint NOT NULL COMMENT '0:尚未開始競標 1:競標中 2:已結標 3:已流標 4:取消 ',
  `BID_ITEM_NAME` varchar(20) NOT NULL,
  `BID_ITEM_DEPICTION` text,
  `BID_ITEM_PIC` blob,
  `BID_STARTING_PRICE` int NOT NULL,
  `BID_ITEM_DIRECT_PRICE` int NOT NULL,
  `ITEM_MINIMUM_BID` int NOT NULL,
  `BID_START_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `BID_END_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`BID_ITEM_NO`),
  KEY `ITEM_CLASS_NO` (`ITEM_CLASS_NO`),
  CONSTRAINT `bid_item_ibfk_1` FOREIGN KEY (`ITEM_CLASS_NO`) REFERENCES `item_class` (`ITEM_CLASS_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bid_item`
--

LOCK TABLES `bid_item` WRITE;
/*!40000 ALTER TABLE `bid_item` DISABLE KEYS */;
INSERT INTO `bid_item` VALUES (101,1,1,'商品1','這是商品1的描述',_binary ' ',100,500,50,'2023-08-01 08:00:00','2023-08-03 20:00:00'),(102,2,0,'商品2','這是商品2的描述',_binary '4\ ',200,600,60,'2023-08-02 10:00:00','2023-08-04 18:00:00'),(103,3,2,'商品3','這是商品3的描述',_binary 'V\ ',300,700,70,'2023-08-03 12:00:00','2023-08-05 22:00:00');
/*!40000 ALTER TABLE `bid_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bid_item_bid`
--

DROP TABLE IF EXISTS `bid_item_bid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bid_item_bid` (
  `BID_BID_NO` int NOT NULL,
  `MEM_NO` int NOT NULL,
  `BID_ITEM_NO` int NOT NULL,
  `BID_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `BID_PRICE` int NOT NULL,
  `BID_STATE` tinyint NOT NULL COMMENT '0:出價成功  1:出價失敗',
  PRIMARY KEY (`BID_BID_NO`),
  KEY `MEM_NO` (`MEM_NO`),
  KEY `BID_ITEM_NO` (`BID_ITEM_NO`),
  CONSTRAINT `bid_item_bid_ibfk_1` FOREIGN KEY (`MEM_NO`) REFERENCES `member` (`MEM_NO`),
  CONSTRAINT `bid_item_bid_ibfk_2` FOREIGN KEY (`BID_ITEM_NO`) REFERENCES `bid_item` (`BID_ITEM_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bid_item_bid`
--

LOCK TABLES `bid_item_bid` WRITE;
/*!40000 ALTER TABLE `bid_item_bid` DISABLE KEYS */;
INSERT INTO `bid_item_bid` VALUES (1,1001,101,'2023-08-01 09:30:00',120,0),(2,1002,101,'2023-08-01 10:15:00',200,0),(3,1003,101,'2023-08-01 11:00:00',320,0);
/*!40000 ALTER TABLE `bid_item_bid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bid_order`
--

DROP TABLE IF EXISTS `bid_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bid_order` (
  `BID_ORDER_NO` int NOT NULL,
  `MEM_NO` int NOT NULL,
  `BID_ITEM_NO` int NOT NULL,
  `BID_FINAL_PRICE` int NOT NULL,
  `BID_WINNING_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `RECEIVER_NAME` varchar(10) NOT NULL,
  `RECEIVER_ADDRESS` varchar(80) NOT NULL,
  `RECEIVER_METHOD` tinyint DEFAULT NULL COMMENT '0:超商 1:宅急便 2:郵局',
  `MEM_PH` varchar(10) NOT NULL,
  PRIMARY KEY (`BID_ORDER_NO`),
  KEY `MEM_NO` (`MEM_NO`),
  KEY `BID_ITEM_NO` (`BID_ITEM_NO`),
  CONSTRAINT `bid_order_ibfk_1` FOREIGN KEY (`MEM_NO`) REFERENCES `member` (`MEM_NO`),
  CONSTRAINT `bid_order_ibfk_2` FOREIGN KEY (`BID_ITEM_NO`) REFERENCES `bid_item` (`BID_ITEM_NO`),
  CONSTRAINT `bid_order_ibfk_3` FOREIGN KEY (`MEM_NO`) REFERENCES `member` (`MEM_NO`),
  CONSTRAINT `bid_order_ibfk_4` FOREIGN KEY (`BID_ITEM_NO`) REFERENCES `bid_item` (`BID_ITEM_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bid_order`
--

LOCK TABLES `bid_order` WRITE;
/*!40000 ALTER TABLE `bid_order` DISABLE KEYS */;
INSERT INTO `bid_order` VALUES (1,1001,101,520,'2023-08-01 13:41:18','張三','台北市中正區',1,'0912345678'),(2,1002,102,800,'2023-08-01 13:41:18','李四','新北市永和區',0,'0923456789'),(3,1003,103,650,'2023-08-01 13:41:18','王五','台中市南區',2,'0934567890');
/*!40000 ALTER TABLE `bid_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `BOOKING_NO` int NOT NULL COMMENT '預約單號',
  `MEM_NO` int NOT NULL COMMENT '會員編號',
  `BOOKING_STATE` tinyint DEFAULT NULL COMMENT '預約訂單狀態 0:已成立/1:已取消',
  `BOOKING_DATE` date DEFAULT NULL COMMENT '預約日期',
  PRIMARY KEY (`BOOKING_NO`),
  KEY `MEM_NO` (`MEM_NO`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`MEM_NO`) REFERENCES `member` (`MEM_NO`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`MEM_NO`) REFERENCES `member` (`MEM_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (123456,1001,0,'2023-07-28');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookinglist`
--

DROP TABLE IF EXISTS `bookinglist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookinglist` (
  `BOOKING_NO` int NOT NULL COMMENT '預約單號',
  `TABLE_NO` int NOT NULL COMMENT '桌號',
  `BOOKING_CHECK_STATE` tinyint DEFAULT NULL COMMENT '報到狀態 0:已報到/1:未報到/2:待報到',
  `NOTE_OTHER` varchar(30) DEFAULT NULL COMMENT '備註',
  `PERIOD_TIME` tinyint DEFAULT NULL COMMENT '預約時段 0:上午(9-12) / 1:下午(1-4)/ 2:晚上(6-8)',
  PRIMARY KEY (`BOOKING_NO`),
  KEY `TABLE_NO` (`TABLE_NO`),
  CONSTRAINT `bookinglist_ibfk_1` FOREIGN KEY (`TABLE_NO`) REFERENCES `gametable` (`TABLE_NO`),
  CONSTRAINT `bookinglist_ibfk_2` FOREIGN KEY (`BOOKING_NO`) REFERENCES `booking` (`BOOKING_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookinglist`
--

LOCK TABLES `bookinglist` WRITE;
/*!40000 ALTER TABLE `bookinglist` DISABLE KEYS */;
INSERT INTO `bookinglist` VALUES (123456,1,2,'想要長桌',2);
/*!40000 ALTER TABLE `bookinglist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `EMP_NO` int NOT NULL,
  `EMP_NAME` varchar(10) DEFAULT NULL,
  `EMP_GENDER` tinyint DEFAULT NULL COMMENT '0:女 1:男',
  `EMP_EMAIL` varchar(30) DEFAULT NULL,
  `EMP_PWD` varchar(20) DEFAULT NULL,
  `EMP_PH` varchar(15) DEFAULT NULL,
  `EMP_PIC` blob,
  `EMP_STATE` tinyint DEFAULT NULL COMMENT '0:離職 1:在職中 2:停職',
  PRIMARY KEY (`EMP_NO`),
  UNIQUE KEY `EMP_EMAIL` (`EMP_EMAIL`),
  UNIQUE KEY `EMP_PWD` (`EMP_PWD`),
  UNIQUE KEY `EMP_PH` (`EMP_PH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'楊澈',1,'che43700@gmail.com','cha102java017','0973-748-593',NULL,1),(2,'江鈞',1,'a129538753@gmail.com','cha102java002','0994-850-385',NULL,1),(3,'李信隆',1,'johnnesteacena@gmail.com','cha102java013','0939-450-395',NULL,1),(4,'蔡宗錡',1,'qwerrr2153@gmail.com','cha102java011','0984-388-493',NULL,1),(5,'陳昱均',1,'a9155371@gmail.com','cha102java040','0947-474-838',NULL,1),(6,'林郁凱',1,'summerboyyy24@gmail.com','cha102java037','0973-827-485',NULL,1),(7,'李庭萱',0,'404401761@s04.tku.edu.tw','cha102java031','0903-857-852',NULL,1),(8,' 王椀俞',0,'ps66391@gmail.com','cha102java052','0939-587-845',NULL,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `function`
--

DROP TABLE IF EXISTS `function`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `function` (
  `FUNC_NO` varchar(10) NOT NULL,
  `FUNC_NAME` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FUNC_NO`),
  UNIQUE KEY `FUNC_NAME` (`FUNC_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `function`
--

LOCK TABLES `function` WRITE;
/*!40000 ALTER TABLE `function` DISABLE KEYS */;
INSERT INTO `function` VALUES ('F003','商城管理'),('F006','客服管理'),('F001','後台管理'),('F002','會員管理'),('F004','競標管理'),('F008','討論區管理'),('F005','貨品管理'),('F007','預約管理');
/*!40000 ALTER TABLE `function` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gametable`
--

DROP TABLE IF EXISTS `gametable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gametable` (
  `TABLE_NO` int NOT NULL COMMENT '桌號',
  `TABLE_TYPE` tinyint DEFAULT NULL COMMENT '桌子型態 0:方桌/1:長桌',
  PRIMARY KEY (`TABLE_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gametable`
--

LOCK TABLES `gametable` WRITE;
/*!40000 ALTER TABLE `gametable` DISABLE KEYS */;
INSERT INTO `gametable` VALUES (1,0),(2,1),(3,1),(4,0),(5,1),(6,0),(7,0),(8,1);
/*!40000 ALTER TABLE `gametable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hot_item_recom`
--

DROP TABLE IF EXISTS `hot_item_recom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hot_item_recom` (
  `HOT_PJ_NO` int NOT NULL AUTO_INCREMENT,
  `ITEM_NO` int NOT NULL,
  PRIMARY KEY (`HOT_PJ_NO`),
  KEY `ITEM_NO` (`ITEM_NO`),
  CONSTRAINT `hot_item_recom_ibfk_1` FOREIGN KEY (`ITEM_NO`) REFERENCES `item` (`ITEM_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hot_item_recom`
--

LOCK TABLES `hot_item_recom` WRITE;
/*!40000 ALTER TABLE `hot_item_recom` DISABLE KEYS */;
INSERT INTO `hot_item_recom` VALUES (1,101),(2,102),(3,103);
/*!40000 ALTER TABLE `hot_item_recom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `ITEM_NO` int NOT NULL AUTO_INCREMENT,
  `ITEM_CLASS_NO` int NOT NULL,
  `ITEM_NAME` varchar(20) NOT NULL,
  `ITEM_PRICE` int DEFAULT NULL,
  `ITEM_STATE` tinyint NOT NULL,
  `ITEM_QTY` int NOT NULL,
  `PLAYER` int NOT NULL,
  `GAMETIME` int NOT NULL,
  `ITEM_PROD_DESCRIPTION` text,
  PRIMARY KEY (`ITEM_NO`),
  KEY `ITEM_CLASS_NO` (`ITEM_CLASS_NO`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`ITEM_CLASS_NO`) REFERENCES `item_class` (`ITEM_CLASS_NO`),
  CONSTRAINT `item_chk_1` CHECK ((`ITEM_PRICE` > 0)),
  CONSTRAINT `item_chk_2` CHECK ((`ITEM_STATE` in (0,1,2))),
  CONSTRAINT `item_chk_3` CHECK ((`PLAYER` >= 1)),
  CONSTRAINT `item_chk_4` CHECK ((`GAMETIME` in (10,30,45,60,90,120,121)))
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (101,1,'遊戲A',500,1,100,4,60,'這是一個有趣的桌遊，適合4人遊玩。'),(102,1,'遊戲B',800,1,50,2,30,'這是一款策略桌遊，適合2人進行對戰。'),(103,2,'遊戲C',350,1,80,6,90,'這款桌遊適合6人或以上的大團體遊玩。'),(104,1,'遊戲D',1200,1,30,3,120,'這是一個冒險類桌遊，適合3人一同冒險。'),(105,1,'遊戲E',600,1,60,4,60,'這是一個有策略性的桌遊，適合4人進行對戰。'),(106,3,'遊戲F',280,0,0,4,60,'此商品暫未上架。'),(107,3,'遊戲G',420,1,20,2,45,'這是一個適合2人遊玩的桌遊，適合情侶或好友。'),(108,4,'遊戲H',950,1,40,5,90,'這是一款高度合作的桌遊，適合5人一同完成任務。'),(109,4,'遊戲I',720,1,25,3,60,'這款桌遊適合3人遊玩，需要有一定的策略眼光。'),(110,1,'遊戲J',380,1,70,8,120,'這是一個適合大型團體遊玩的桌遊，可容納8人以上參與。');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_class`
--

DROP TABLE IF EXISTS `item_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_class` (
  `ITEM_CLASS_NO` int NOT NULL AUTO_INCREMENT,
  `ITEM_CLASS_NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`ITEM_CLASS_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_class`
--

LOCK TABLES `item_class` WRITE;
/*!40000 ALTER TABLE `item_class` DISABLE KEYS */;
INSERT INTO `item_class` VALUES (1,'策略'),(2,'派對'),(3,'親子'),(4,'合作'),(5,'陣營'),(6,'派對');
/*!40000 ALTER TABLE `item_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_image`
--

DROP TABLE IF EXISTS `item_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_image` (
  `ITEM_IMGNO` int NOT NULL AUTO_INCREMENT,
  `ITEM_NO` int NOT NULL,
  `ITEM_IMG` blob,
  `ITEM_IMGNAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ITEM_IMGNO`),
  KEY `ITEM_NO` (`ITEM_NO`),
  CONSTRAINT `item_image_ibfk_1` FOREIGN KEY (`ITEM_NO`) REFERENCES `item` (`ITEM_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_image`
--

LOCK TABLES `item_image` WRITE;
/*!40000 ALTER TABLE `item_image` DISABLE KEYS */;
INSERT INTO `item_image` VALUES (1,101,_binary '遊戲A的圖片內容','遊戲A圖片名稱'),(2,102,_binary '遊戲B的圖片內容','遊戲B圖片名稱'),(3,103,_binary '遊戲C的圖片內容','遊戲C圖片名稱'),(4,104,_binary '遊戲D的圖片內容','遊戲D圖片名稱'),(5,105,_binary '遊戲E的圖片內容','遊戲E圖片名稱'),(6,106,_binary '遊戲F的圖片內容','遊戲F圖片名稱'),(7,107,_binary '遊戲G的圖片內容','遊戲G圖片名稱'),(8,108,_binary '遊戲H的圖片內容','遊戲H圖片名稱'),(9,109,_binary '遊戲I的圖片內容','遊戲I圖片名稱'),(10,110,_binary '遊戲J的圖片內容','遊戲J圖片名稱');
/*!40000 ALTER TABLE `item_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_order`
--

DROP TABLE IF EXISTS `item_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_order` (
  `ORDER_NO` int NOT NULL AUTO_INCREMENT,
  `MEM_NO` int NOT NULL,
  `TRAN_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ORDER_TOTAL` int DEFAULT NULL,
  `ORDER_STATE` tinyint NOT NULL COMMENT '0: 未出貨, 1:已出貨, 2:已收貨, 3:退貨 , 4:退貨',
  `RECEIVER_NAME` varchar(10) NOT NULL,
  `RECEIVER_ADDRESS` varchar(100) NOT NULL,
  `RECEIVER_PHONE` varchar(10) NOT NULL,
  `RECEIVER_METHOD` tinyint DEFAULT NULL COMMENT '0:超商 / 1:宅急便 / 2:郵局',
  PRIMARY KEY (`ORDER_NO`),
  CONSTRAINT `item_order_chk_1` CHECK ((`ORDER_TOTAL` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_order`
--

LOCK TABLES `item_order` WRITE;
/*!40000 ALTER TABLE `item_order` DISABLE KEYS */;
INSERT INTO `item_order` VALUES (1,1001,'2023-08-01 13:48:00',3200,1,'李小潘','復興路46號','0901234567',0),(2,1002,'2023-08-01 13:48:00',35000,3,'江小鈞','長沙路46號','0912345678',1),(3,1003,'2023-08-01 13:48:00',300,2,'李小萱','安泰路60號','0934567890',2),(4,1004,'2023-08-01 13:48:00',2200,3,'陳小均','中央東路600號','0923456789',1),(5,1005,'2023-08-01 13:48:00',5800,1,'蔡小錡','中正路53號','0945678901',2),(6,1006,'2023-08-01 13:48:00',1280,0,'楊小澈','延平路32號','0956789012',1),(7,1007,'2023-08-01 13:48:00',8800,2,'王小榆','忠孝東路三段88號','0967890123',0),(8,1008,'2023-08-01 13:48:00',330,0,'林小凱','環中東路99號','0978901234',1),(9,1001,'2023-08-01 13:48:23',3200,1,'李小潘','復興路46號','0901234567',0),(10,1002,'2023-08-01 13:48:23',35000,3,'江小鈞','長沙路46號','0912345678',1),(11,1003,'2023-08-01 13:48:23',300,2,'李小萱','安泰路60號','0934567890',2),(12,1004,'2023-08-01 13:48:23',2200,3,'陳小均','中央東路600號','0923456789',1),(13,1005,'2023-08-01 13:48:23',5800,1,'蔡小錡','中正路53號','0945678901',2),(14,1006,'2023-08-01 13:48:23',1280,0,'楊小澈','延平路32號','0956789012',1),(15,1007,'2023-08-01 13:48:23',8800,2,'王小榆','忠孝東路三段88號','0967890123',0),(16,1008,'2023-08-01 13:48:23',330,0,'林小凱','環中東路99號','0978901234',1);
/*!40000 ALTER TABLE `item_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_return`
--

DROP TABLE IF EXISTS `item_return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_return` (
  `RE_ORDER_NO` int NOT NULL AUTO_INCREMENT,
  `ORDER_NO` int NOT NULL,
  `MEM_NO` int DEFAULT NULL,
  `TRAN_DATE` datetime DEFAULT NULL,
  `RE_STATE` tinyint DEFAULT NULL,
  `RECEIVER_ADDRESS` varchar(100) DEFAULT NULL,
  `RE_TOTAL` int DEFAULT NULL,
  PRIMARY KEY (`RE_ORDER_NO`),
  KEY `ORDER_NO` (`ORDER_NO`),
  KEY `MEM_NO` (`MEM_NO`),
  CONSTRAINT `item_return_ibfk_1` FOREIGN KEY (`ORDER_NO`) REFERENCES `item_order` (`ORDER_NO`),
  CONSTRAINT `item_return_ibfk_2` FOREIGN KEY (`MEM_NO`) REFERENCES `member` (`MEM_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_return`
--

LOCK TABLES `item_return` WRITE;
/*!40000 ALTER TABLE `item_return` DISABLE KEYS */;
INSERT INTO `item_return` VALUES (1,1,1001,'2023-07-28 21:11:55',0,'No. 123, Main Street, City A',4215),(2,2,1001,'2023-07-28 21:11:55',1,'No. 456, Park Avenue, City B',1212),(3,3,1001,'2023-07-28 21:11:55',0,'No. 789, Central Road, City C',1212),(4,4,1002,'2023-07-28 21:11:55',0,'No. 987, South Avenue, City D',1333),(5,5,1002,'2023-07-28 21:11:55',1,'No. 246, East Street, City E',1244),(6,6,1002,'2023-07-28 21:11:55',1,'No. 543, West Road, City F',1220),(7,7,1003,'2023-07-28 21:11:55',0,'No. 135, North Avenue, City G',200),(8,8,1003,'2023-07-28 21:11:55',0,'No. 567, Main Street, City H',1300);
/*!40000 ALTER TABLE `item_return` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_returndetail`
--

DROP TABLE IF EXISTS `item_returndetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_returndetail` (
  `RE_ORDER_NO` int NOT NULL,
  `ITEM_NO` int NOT NULL,
  `ITEM_PRICE` int DEFAULT NULL,
  `ITEM_SALES` int DEFAULT NULL,
  PRIMARY KEY (`RE_ORDER_NO`,`ITEM_NO`),
  KEY `ITEM_NO` (`ITEM_NO`),
  CONSTRAINT `item_returndetail_ibfk_1` FOREIGN KEY (`RE_ORDER_NO`) REFERENCES `item_return` (`RE_ORDER_NO`),
  CONSTRAINT `item_returndetail_ibfk_2` FOREIGN KEY (`ITEM_NO`) REFERENCES `item` (`ITEM_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_returndetail`
--

LOCK TABLES `item_returndetail` WRITE;
/*!40000 ALTER TABLE `item_returndetail` DISABLE KEYS */;
INSERT INTO `item_returndetail` VALUES (1,101,500,2),(2,102,800,1),(3,103,350,3),(4,104,450,1),(5,105,600,2),(6,106,700,1),(7,107,250,2),(8,108,900,3);
/*!40000 ALTER TABLE `item_returndetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_trace`
--

DROP TABLE IF EXISTS `item_trace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_trace` (
  `MEM_NO` int NOT NULL,
  `ITEM_NO` int NOT NULL,
  PRIMARY KEY (`MEM_NO`,`ITEM_NO`),
  KEY `ITEM_NO` (`ITEM_NO`),
  CONSTRAINT `item_trace_ibfk_1` FOREIGN KEY (`MEM_NO`) REFERENCES `member` (`MEM_NO`),
  CONSTRAINT `item_trace_ibfk_2` FOREIGN KEY (`ITEM_NO`) REFERENCES `item` (`ITEM_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_trace`
--

LOCK TABLES `item_trace` WRITE;
/*!40000 ALTER TABLE `item_trace` DISABLE KEYS */;
INSERT INTO `item_trace` VALUES (1001,101),(1001,102),(1002,102),(1002,103),(1003,104),(1003,105),(1003,107),(1003,108),(1002,109);
/*!40000 ALTER TABLE `item_trace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `latest_news`
--

DROP TABLE IF EXISTS `latest_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `latest_news` (
  `PJ_NO` int NOT NULL AUTO_INCREMENT,
  `MESSAGE_CON` text NOT NULL,
  `RELEASE_TIME` date NOT NULL,
  PRIMARY KEY (`PJ_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `latest_news`
--

LOCK TABLES `latest_news` WRITE;
/*!40000 ALTER TABLE `latest_news` DISABLE KEYS */;
INSERT INTO `latest_news` VALUES (1,'慶開業來店遊玩贈送飲料一杯','2023-07-17'),(2,'準備好跟朋友來一場驚心動魄的賽駱駝了嗎','2023-07-18'),(3,'神秘的礦坑下居住著一群勤奮的矮人，你會是其中的鬧事者嗎?','2023-07-19');
/*!40000 ALTER TABLE `latest_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `MEM_NO` int NOT NULL,
  `MEM_NAME` varchar(10) DEFAULT NULL,
  `MEM_PID` char(10) NOT NULL,
  `MEM_GENDER` tinyint DEFAULT NULL COMMENT '0:女 1:男',
  `MEM_PIC` blob,
  `MEM_EMAIL` varchar(30) DEFAULT NULL,
  `MEM_PWD` varchar(20) DEFAULT NULL,
  `MEM_PH` varchar(15) DEFAULT NULL,
  `MEM_ADDRS` varchar(100) DEFAULT NULL,
  `MEM_BIRTH` date DEFAULT NULL,
  `MEM_AUTH` tinyint DEFAULT '0' COMMENT '0: 普通 1: 黑名單',
  `MEM_VIO` tinyint DEFAULT '0',
  PRIMARY KEY (`MEM_NO`),
  UNIQUE KEY `MEM_PID` (`MEM_PID`),
  UNIQUE KEY `MEM_EMAIL` (`MEM_EMAIL`),
  UNIQUE KEY `MEM_PWD` (`MEM_PWD`),
  CONSTRAINT `member_chk_1` CHECK ((`MEM_VIO` <= 3))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1001,'李小潘','G293847637',1,NULL,'jfkda@gmail.com','dkhfaafad3343','0983748394','Taipei, Xinyi','1997-01-01',0,2),(1002,'吳小紅','H133847649',0,NULL,'elaa@gmail.com','fkhfalkdjfie99','0949584900','New Taipei, Xindian','1996-12-11',1,3),(1003,'張大鈞','k188392842',1,NULL,'daiek@gmail.com','oaafad3383','0903293748','Taoyuan, Zhongli','1974-09-18',0,1);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `new_item_recom`
--

DROP TABLE IF EXISTS `new_item_recom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `new_item_recom` (
  `NEW_PJ_NO` int NOT NULL AUTO_INCREMENT,
  `ITEM_NO` int NOT NULL,
  PRIMARY KEY (`NEW_PJ_NO`),
  KEY `ITEM_NO` (`ITEM_NO`),
  CONSTRAINT `new_item_recom_ibfk_1` FOREIGN KEY (`ITEM_NO`) REFERENCES `item` (`ITEM_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new_item_recom`
--

LOCK TABLES `new_item_recom` WRITE;
/*!40000 ALTER TABLE `new_item_recom` DISABLE KEYS */;
INSERT INTO `new_item_recom` VALUES (1,101),(2,102),(3,103);
/*!40000 ALTER TABLE `new_item_recom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `ORDER_NO` int NOT NULL,
  `ITEM_NO` int NOT NULL,
  `ITEM_SALES` int DEFAULT NULL,
  `ITEM_PRICE` int DEFAULT NULL,
  PRIMARY KEY (`ORDER_NO`,`ITEM_NO`),
  KEY `ITEM_NO` (`ITEM_NO`),
  CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`ORDER_NO`) REFERENCES `item_order` (`ORDER_NO`),
  CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`ITEM_NO`) REFERENCES `item` (`ITEM_NO`),
  CONSTRAINT `order_detail_ibfk_3` FOREIGN KEY (`ITEM_NO`) REFERENCES `item` (`ITEM_NO`),
  CONSTRAINT `order_detail_chk_1` CHECK ((`ITEM_SALES` > 0)),
  CONSTRAINT `order_detail_chk_2` CHECK ((`ITEM_PRICE` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,101,4,600),(1,102,4,2600),(2,101,100,15000),(2,102,30,19500),(3,101,2,300),(4,103,1,1000),(4,104,1,1200),(5,105,1,5800),(6,106,1,1280),(7,107,1,8800),(8,108,1,330);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `QUESTION_NO` int NOT NULL AUTO_INCREMENT,
  `QUESTION_CFT` varchar(30) NOT NULL,
  `QUESTION_CONT` text NOT NULL,
  PRIMARY KEY (`QUESTION_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'商品須知','Q1.XXXXXXXX'),(2,'預約須知','Q2.XXXXXXXX'),(3,'競標須知','Q3.XXXXXXXX'),(4,'付款須知','Q4.XXXXXXXX'),(5,'退換貨辦法','Q5.XXXXXXXX');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `REPLY_NO` int NOT NULL AUTO_INCREMENT,
  `ARTICLE_NO` int NOT NULL,
  `MEM_NO` int NOT NULL,
  `REPLY_CONTENT` text,
  `REPLY_STATE` tinyint NOT NULL COMMENT '0:未處理 1:處理成功 2:處理失敗',
  `REPLY_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`REPLY_NO`,`MEM_NO`),
  KEY `ARTICLE_NO` (`ARTICLE_NO`),
  KEY `MEM_NO` (`MEM_NO`),
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`ARTICLE_NO`) REFERENCES `article` (`ARTICLE_NO`),
  CONSTRAINT `reply_ibfk_2` FOREIGN KEY (`MEM_NO`) REFERENCES `member` (`MEM_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (1,1,1001,'讚啦!',2,'2023-08-02 21:23:43'),(2,1,1002,'推推~~~',1,'2023-08-02 21:23:43'),(3,2,1001,'我覺得他講得有道理',1,'2023-08-02 21:23:43'),(4,3,1003,'這我給過拉!!',0,'2023-08-02 21:23:43');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply_report`
--

DROP TABLE IF EXISTS `reply_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply_report` (
  `REPLY_REPORT_NO` int NOT NULL AUTO_INCREMENT,
  `REPLY_NO` int NOT NULL,
  `MEM_NO` int NOT NULL,
  `REP_WHY` varchar(120) DEFAULT NULL,
  `REP_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `REP_STATE` tinyint NOT NULL DEFAULT '0' COMMENT '0:未處理 1:處理成功 2:處理失敗',
  `REP_DONETIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`REPLY_REPORT_NO`),
  KEY `REPLY_NO` (`REPLY_NO`),
  KEY `MEM_NO` (`MEM_NO`),
  CONSTRAINT `reply_report_ibfk_1` FOREIGN KEY (`REPLY_NO`) REFERENCES `reply` (`REPLY_NO`),
  CONSTRAINT `reply_report_ibfk_2` FOREIGN KEY (`MEM_NO`) REFERENCES `member` (`MEM_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply_report`
--

LOCK TABLES `reply_report` WRITE;
/*!40000 ALTER TABLE `reply_report` DISABLE KEYS */;
INSERT INTO `reply_report` VALUES (1,1,1001,'髒話連篇!','2023-08-02 21:28:43',2,'2023-08-02 21:28:43'),(2,1,1002,'散撥色情','2023-08-02 21:28:43',1,'2023-08-02 21:28:43'),(3,2,1002,'有18禁圖片','2023-08-02 21:28:43',1,'2023-08-02 21:28:43'),(4,3,1002,'有暴力傾向','2023-08-02 21:28:43',0,'2023-08-02 21:28:43');
/*!40000 ALTER TABLE `reply_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tablebooking`
--

DROP TABLE IF EXISTS `tablebooking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tablebooking` (
  `TABLE_BOOK_NO` varchar(30) NOT NULL COMMENT '遊戲桌預定編號',
  `TABLE_DATE` date NOT NULL COMMENT '日期',
  `TABLE_NO` int NOT NULL COMMENT '桌號',
  `TABLE_MOR` tinyint NOT NULL COMMENT '上午時段 0:可預約/1:已預訂/2:不開放',
  `TABLE_EVE` tinyint NOT NULL COMMENT '下午時段 0:可預約/1:已預訂/2:不開放',
  `TABLE_NIGHT` tinyint NOT NULL COMMENT '晚上時段 0:可預約/1:已預訂/2:不開放',
  PRIMARY KEY (`TABLE_BOOK_NO`),
  KEY `TABLE_NO` (`TABLE_NO`),
  CONSTRAINT `tablebooking_ibfk_1` FOREIGN KEY (`TABLE_NO`) REFERENCES `gametable` (`TABLE_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tablebooking`
--

LOCK TABLES `tablebooking` WRITE;
/*!40000 ALTER TABLE `tablebooking` DISABLE KEYS */;
INSERT INTO `tablebooking` VALUES ('77777','2023-07-28',2,1,2,0);
/*!40000 ALTER TABLE `tablebooking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wallet` (
  `WALLET_HISTORY_NO` int NOT NULL,
  `MEM_NO` int DEFAULT NULL,
  `TRANS_TYPE` tinyint DEFAULT NULL COMMENT '0: 提領 1: 儲值 2: 付款',
  `TRANS_DATE` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `TRANS_NOTE` tinyint DEFAULT NULL COMMENT '0:商城 1:競標 2:預約',
  `TRANS_AMOUNT` int DEFAULT NULL,
  PRIMARY KEY (`WALLET_HISTORY_NO`),
  KEY `MEM_NO` (`MEM_NO`),
  CONSTRAINT `wallet_ibfk_1` FOREIGN KEY (`MEM_NO`) REFERENCES `member` (`MEM_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet`
--

LOCK TABLES `wallet` WRITE;
/*!40000 ALTER TABLE `wallet` DISABLE KEYS */;
INSERT INTO `wallet` VALUES (1,1001,2,'2023-08-02 20:51:11',0,1970),(2,1002,1,'2023-08-02 20:51:11',NULL,3000),(3,1002,2,'2023-08-02 20:51:11',2,5600),(4,1001,0,'2023-08-02 20:51:11',NULL,3400),(5,1003,1,'2023-08-02 20:51:11',NULL,3000);
/*!40000 ALTER TABLE `wallet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-05 14:48:26
