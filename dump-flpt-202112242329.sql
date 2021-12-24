-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: flpt
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `noticetable`
--

DROP TABLE IF EXISTS `noticetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `noticetable` (
  `notice_id` int NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `ntitle` varchar(100) NOT NULL COMMENT '标题',
  `ncontent` varchar(500) DEFAULT NULL COMMENT '内容',
  `ntime` varchar(100) NOT NULL COMMENT '发布时间',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticetable`
--

LOCK TABLES `noticetable` WRITE;
/*!40000 ALTER TABLE `noticetable` DISABLE KEYS */;
INSERT INTO `noticetable` VALUES (5,'1123','123123213sdasdasd','2021-09-17 17:57:12'),(6,'test','内容','2021-10-18 18:43:39');
/*!40000 ALTER TABLE `noticetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testtable`
--

DROP TABLE IF EXISTS `testtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testtable` (
  `test_id` int NOT NULL AUTO_INCREMENT COMMENT '考试id',
  `tname` varchar(100) NOT NULL COMMENT '考试名',
  `tsubject` varchar(100) NOT NULL COMMENT '考试科目',
  `torganizer` varchar(100) NOT NULL COMMENT '主考单位',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态（是否已发布）',
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testtable`
--

LOCK TABLES `testtable` WRITE;
/*!40000 ALTER TABLE `testtable` DISABLE KEYS */;
INSERT INTO `testtable` VALUES (40,'大学英语四级考试（CET-4）','英语','国家教育部高等教育司',1),(41,'大学英语六级考试（CET-6）','英语','国家教育部高等教育司',1),(42,'英语专业四级考试（TEM-4）','英语','高等学校外语专业教学指导委员会',0),(43,'英语专业八级考试（TEM-8）','英语','高等学校外语专业教学指导委员会',0),(44,'中级口译','英语','上海市紧缺人才培训工程',0),(45,'剑桥商务英语（BEC）','英语','上海市紧缺人才培训工程',0),(46,'全国翻译专业资格考试-英语（CATTI）','英语','中国外文出版发行事业局',0),(47,'剑桥商务英语-初级（BEC）','英语','教育部考试中心和英国剑桥大学考试委员会',0),(48,'剑桥商务英语-中级（BEC）','英语','教育部考试中心和英国剑桥大学考试委员会',0),(49,'剑桥商务英语-高级（BEC）','英语','教育部考试中心和英国剑桥大学考试委员会',0),(50,'国际交流英语考试-托业（ETS）','英语','美国教育考试服务中心',0),(51,'日本语能力测试N5（JLPT-5）','日语','日本国际交流基金会和日本国际教育支援协会',0),(52,'日本语能力测试N4（JLPT-4）','日语','日本国际交流基金会和日本国际教育支援协会',0),(53,'日本语能力测试N3（JLPT-3）','日语','日本国际交流基金会和日本国际教育支援协会',0),(54,'日本语能力测试N2（JLPT-2）','日语','日本国际交流基金会和日本国际教育支援协会',1),(55,'日本语能力测试N1（JLPT-1）','日语','日本国际交流基金会和日本国际教育支援协会',1),(56,'实用日本语鉴定考试（J.TEST）','日语','日语鉴定协会・J.TEST事务局',0),(57,'商务日语能力考试（BJT）','日语','日本贸易振兴机构',0),(58,'大学日语四级考试（CJT-4）','日语','国家教育部高等教育司',0),(59,'大学日语六级考试（CJT-6）','日语','国家教育部高等教育司',0),(60,'日语专业四级考试（NSS-4）','日语','高等学校外语专业教学指导委员会',0),(61,'日语专业八级考试（NSS-8）','日语','高等学校外语专业教学指导委员会',0),(62,'全国翻译专业资格考试-日语（CATTI）','日语','中国外文出版发行事业局',0),(63,'法语专业四级（TFS-4）','法语','高等学校外语专业教学指导委员会',0),(64,'法语专业八级（TFS-8）','法语','高等学校外语专业教学指导委员会',0),(65,'全国翻译专业资格考试-法语（CATTI）','法语','中国外文出版发行事业局',0),(66,'法语水平考试（TEF/TCF）','法语','法国工商会和法国法语联盟',0),(67,'法语学习文凭考试（DELF）','法语','DELF/DALF国家委员会',0),(68,'俄语专业四级考试（ТРЯ4）','俄语','高等学校外语专业教学指导委员会',0),(69,'俄语专业八级考试（ТРЯ8）','俄语','高等学校外语专业教学指导委员会',0),(70,'俄罗斯联邦对外俄语等级考试（ТРКИ）','俄语','俄语国家水平考试中心',0),(71,'全国翻译专业资格考试-俄语（CATTI）','俄语','中国外文出版发行事业局',0),(72,'德语专业四级考试（PGG）','德语','高等学校外语专业教学指导委员会',0),(73,'德语专业八级考试（PGH）','德语','高等学校外语专业教学指导委员会',0),(74,'全国翻译专业资格考试-德语（CATTI）','德语','中国外文出版发行事业局',0),(75,'德语语言考试-德福（TestDaF）','德语','教育部考试中心和TestDaF考试院',0),(89,'123','123','123',0);
/*!40000 ALTER TABLE `testtable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testinfotable`
--

DROP TABLE IF EXISTS `testinfotable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testinfotable` (
  `testinfo_id` int NOT NULL AUTO_INCREMENT COMMENT '已发布考试id',
  `test_id` int NOT NULL COMMENT '考试id',
  `test_time` datetime NOT NULL COMMENT '考试时间',
  `regist_start_time` datetime NOT NULL COMMENT '报名开始时间',
  `regist_end_time` datetime NOT NULL COMMENT '报名截止时间',
  `tprice` double NOT NULL COMMENT '报名费用',
  PRIMARY KEY (`testinfo_id`),
  KEY `testinfotable_FK` (`test_id`),
  CONSTRAINT `testinfotable_FK` FOREIGN KEY (`test_id`) REFERENCES `testtable` (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testinfotable`
--

LOCK TABLES `testinfotable` WRITE;
/*!40000 ALTER TABLE `testinfotable` DISABLE KEYS */;
INSERT INTO `testinfotable` VALUES (30,40,'2022-04-01 09:00:00','2022-01-01 00:00:00','2022-02-01 00:00:00',30),(31,41,'2022-04-01 15:00:00','2022-01-01 00:00:00','2022-02-01 00:00:00',30),(32,55,'2022-06-01 08:00:00','2021-11-01 00:00:00','2022-05-01 00:00:00',121),(35,54,'2022-06-01 08:00:00','2021-11-01 00:00:00','2022-02-01 00:00:00',450);
/*!40000 ALTER TABLE `testinfotable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ausertable`
--

DROP TABLE IF EXISTS `ausertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ausertable` (
  `aname` varchar(100) NOT NULL,
  `apwd` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ausertable`
--

LOCK TABLES `ausertable` WRITE;
/*!40000 ALTER TABLE `ausertable` DISABLE KEYS */;
INSERT INTO `ausertable` VALUES ('admin','admin');
/*!40000 ALTER TABLE `ausertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testinfo__room`
--

DROP TABLE IF EXISTS `testinfo__room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testinfo__room` (
  `testinfo__room_id` int NOT NULL AUTO_INCREMENT COMMENT '关联id',
  `testinfo_id` int NOT NULL COMMENT '已发布考试id',
  `room_id` int NOT NULL COMMENT '考场id',
  `rquota` int NOT NULL COMMENT '考试名额',
  PRIMARY KEY (`testinfo__room_id`),
  KEY `testinfo__room_FK` (`testinfo_id`),
  KEY `testinfo__room_FK_1` (`room_id`),
  CONSTRAINT `testinfo__room_FK` FOREIGN KEY (`testinfo_id`) REFERENCES `testinfotable` (`testinfo_id`),
  CONSTRAINT `testinfo__room_FK_1` FOREIGN KEY (`room_id`) REFERENCES `roomtable` (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=227 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testinfo__room`
--

LOCK TABLES `testinfo__room` WRITE;
/*!40000 ALTER TABLE `testinfo__room` DISABLE KEYS */;
INSERT INTO `testinfo__room` VALUES (127,30,65,500),(128,30,66,500),(129,30,67,500),(130,30,68,500),(131,30,69,500),(132,30,122,500),(133,30,123,500),(135,31,70,500),(136,31,71,500),(137,31,72,500),(138,31,73,500),(139,31,74,500),(140,31,75,500),(141,31,76,500),(142,31,77,500),(143,31,78,500),(144,31,79,500),(145,32,65,500),(146,32,66,500),(147,32,67,500),(148,32,68,500),(149,32,69,500),(150,32,70,500),(151,32,71,500),(152,32,72,500),(153,32,73,500),(154,32,74,0),(155,32,75,0),(156,32,76,0),(157,32,77,0),(158,32,78,0),(159,32,79,500),(160,32,80,500),(161,32,81,500),(162,32,82,500),(163,32,83,500),(164,32,84,500),(165,32,85,500),(166,32,86,500),(167,32,87,500),(168,32,88,500),(169,32,89,500),(170,32,90,500),(171,32,91,500),(172,32,92,500),(173,32,93,500),(174,32,94,500),(175,32,95,500),(176,32,96,500),(177,32,97,500),(178,32,98,500),(179,32,99,500),(180,32,100,500),(181,32,101,500),(182,32,102,500),(183,32,103,500),(184,32,104,500),(185,32,105,500),(186,32,106,500),(187,32,107,500),(188,32,108,500),(189,32,109,500),(190,32,110,500),(191,32,111,500),(192,32,112,500),(193,32,113,500),(194,32,114,500),(195,32,115,500),(196,32,116,500),(197,32,117,500),(198,32,118,500),(199,32,119,500),(200,32,120,500),(201,32,121,500),(202,32,122,500),(203,32,123,500),(204,32,124,500),(205,32,125,500),(206,30,100,501),(213,31,65,666),(214,31,66,666),(215,31,81,666),(220,35,65,666),(221,35,66,666),(222,35,67,665),(223,35,68,666),(224,35,69,666),(225,35,70,666),(226,35,71,666);
/*!40000 ALTER TABLE `testinfo__room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reginfotable`
--

DROP TABLE IF EXISTS `reginfotable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reginfotable` (
  `reginfo_id` int NOT NULL AUTO_INCREMENT COMMENT '报名信息id',
  `user_id` int NOT NULL COMMENT '用户id',
  `testinfo__room_id` int NOT NULL COMMENT '关联表id',
  `ticketnum` varchar(12) NOT NULL COMMENT '准考证号',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态（0为未支付，1为已支付，2为考生主动取消，3为支付超时取消）',
  `submit_time` datetime NOT NULL COMMENT '提交时间',
  PRIMARY KEY (`reginfo_id`),
  KEY `tickettable_FK` (`user_id`),
  KEY `reginfotable_FK` (`testinfo__room_id`),
  CONSTRAINT `reginfotable_FK` FOREIGN KEY (`testinfo__room_id`) REFERENCES `testinfo__room` (`testinfo__room_id`),
  CONSTRAINT `tickettable_FK` FOREIGN KEY (`user_id`) REFERENCES `busertable` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reginfotable`
--

LOCK TABLES `reginfotable` WRITE;
/*!40000 ALTER TABLE `reginfotable` DISABLE KEYS */;
INSERT INTO `reginfotable` VALUES (35,33,154,'223265339340',1,'2021-11-08 15:01:06'),(36,33,222,'223566333523',1,'2021-11-08 15:07:54');
/*!40000 ALTER TABLE `reginfotable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomtable`
--

DROP TABLE IF EXISTS `roomtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roomtable` (
  `room_id` int NOT NULL AUTO_INCREMENT COMMENT '考场id',
  `rname` varchar(100) NOT NULL COMMENT '考场名',
  `raddress` varchar(100) NOT NULL COMMENT '考场地址',
  `rtelnum` varchar(100) NOT NULL COMMENT '考场联系电话',
  `rpostcode` varchar(100) NOT NULL COMMENT '邮编',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomtable`
--

LOCK TABLES `roomtable` WRITE;
/*!40000 ALTER TABLE `roomtable` DISABLE KEYS */;
INSERT INTO `roomtable` VALUES (65,'北京外国语大学','北京外国语大学','010-88817840','100089'),(66,'北京语言大学','北京市海淀区学院路15号北京语言大学','010-82303550','100083'),(67,'北京第二外国语学院','北京市朝阳区定福庄南里1号','010-65778435','100024'),(68,'北京大学','北京大学三教，二教','010-62751581','100871'),(69,'华东师范大学','上海闵行区','021-34756652,34756154','200062'),(70,'上海大学','上海市宝山区上大路99号上海大学新校区','021-66132028','200444'),(71,'上海师范大学徐汇校区','上海桂林路100号','021-64320641','200234'),(72,'东华大学外语学院','上海市延安西路1882号东华大学（延安校区）','021-62373740,67792243','200051'),(73,'吉林大学','吉林大学','0431-85151636','130023'),(74,'大连外国语大学','大连外国语大学旅顺校区(大连市旅顺南路西段6号)','0411-86115161,','116044'),(75,'大连理工大学','大连市甘井子区凌工路2号大连理工大学外国语学院','0411-84707329','116024'),(76,'大连大学','大连市经济技术开发区学府大街10号大连大学','0411-87403639','116622'),(77,'辽宁大学','沈阳市皇姑区崇山中路66号崇山校区蕙星楼、东配楼','024-62202260','110036'),(78,'沈阳师范大学外国语学院','沈阳市皇姑区黄河北大街253号','024-86592534','110034'),(79,'广东外语外贸大学北校区','广州市白云区白云大道北2号广外北校区','020-36207153/7580','510420'),(80,'中山大学','广东省广州市海珠区新港西路135号中山大学外国语学院','020-84110970,84113240','510275'),(81,'深圳职业技术学院','深圳市西丽镇留仙大道(西校区)','0755-26019721','518055'),(82,'广州商学院','广州市黄埔区九龙大道206号康大教育园广州商学院','020-32975019','511363'),(83,'天津外国语大学','天津外国语大学逸夫教学楼','022-23243358;','300204'),(84,'南开大学','天津市南开大学第二主教学楼','022-23503696','300071'),(85,'黑龙江大学','黑龙江省哈尔滨市南岗区学府路74号黑龙江大学','0451-86608579','150080'),(86,'西安交通大学外国语学院','西安市咸宁西路28号','029-82668115','710049'),(87,'西安外国语大学（长安校区）','西安郭杜教育技术产业开发区文苑南路','029-85309384','710128'),(88,'西北工业大学','陕西省西安市友谊西路127号西北工业大学诚字楼','029-88494524','710072'),(89,'重庆市四川外语大学','重庆沙坪坝区烈士墓壮志路33号四川外语大学','023-65385440,65385298','400031'),(90,'济南山东师范大学千佛山校区','济南市文化东路山东师范大学','0531-86180084/85','250014'),(91,'山东科技职业学院','山东省潍坊市西环路6388号山东科技职业学院','0536-8187747','261053'),(92,'济南山东师范大学长清湖校区','济南市长清区大学路山东师范大学长清校区','0531-86180084/85','250315'),(93,'山东大学（威海）教务处','山东省威海市文化西路180号山东大学（威海）','0631-5672870','264209'),(94,'山东大学','山东大学洪家楼校区公教楼','0531-88377517','250100'),(95,'浙江大学（西溪校区）','杭州市天目山路148号浙江大学西溪校区田家炳书院','0571-88273293','310028'),(96,'浙江工商大学（下沙校区）','杭州市下沙高教园区学正街18号，浙江工商大学下沙校区','0571-88066397','310012'),(97,'浙江教育考试院服务中心','绍兴市柯桥区越州大道958号浙江工业大学之江学院考场','0571-96399','310012'),(98,'宁波大学','宁波市风华路818号宁波大学教学楼','0574-87600022,','315211'),(99,'浙江越秀外国语学院','绍兴市会稽路428号F幢教学楼','0575-89114355','312000'),(100,'内蒙古中日友好语言培训中心','内蒙古大学','0471-3462789','010080'),(101,'苏州大学','苏州大学校本部、苏州大学东校区(本部和东校区有桥相连)','0512-65112104','215006'),(102,'苏州科技大学','江苏省苏州市新区滨河路1701号','0512-69379107','215011'),(103,'东南大学外国语学院','南京四牌楼2号（四牌楼校区）','025-83792254','210096'),(104,'南京师范大学外国语学院','南京师范大学：随园校区(宁海路122号)','025-83732062,025-83598582','210097'),(105,'江南大学外国语学院','无锡江南大学第一教学楼','0510-85919985','214122'),(106,'扬州大学','江苏省扬州市华扬西路196号扬州大学扬子津校区','0514-87971664','225127'),(107,'无锡科技职业学院','无锡市新区新锡路8号教学区内','0510-85342501','214028'),(108,'南通大学','江苏省南通市啬园路9号南通大学主校区方肇周楼群','0513-85015963','226007'),(109,'湖南大学','湖南长沙湖南大学南校区','0731-88822147','410082'),(110,'中南林业科技大学','湖南省长沙市天心区韶山南路498号','0731-85623122','410004'),(111,'四川大学','成都市武侯区科华北路133号','028-85464311','610065'),(112,'成都信息工程大学外国语学院','成都信息工程大学（航空港校区）第四教学楼','028-85966493','610225'),(113,'南昌大学外国语学院','南昌大学前湖校区','0791-83969477','330031'),(114,'河北师范大学外国语学院','石家庄河北师大新校区公共教学楼C座','0311-80788519','050024'),(115,'保定市剑桥英语学校','保定市莲池区七一东路未来像素1号楼803室(考点办公室地址)','0312-3150005/5958753','071000'),(116,'山西大学','山西大学外国语学院','0351-7011732','030006'),(117,'贵州大学外国语学院','贵州省贵阳市贵州大学花溪区北校区','0851-8290245','550025'),(118,'广西大学','广西大学西校园第一教学楼','0771-3237226,','530004'),(119,'云南师范大学','云南省昆明市呈贡区雨花片区1号云南师范大学外国语学院','0871-65911774','650500'),(120,'海南大学','海南大学十号教学楼','0898-66279168','570228'),(121,'兰州大学','甘肃省兰州市城关区东岗西路199号兰州大学医学校区杏林楼','0931-8912115','730000'),(122,'福建省教育考试院考试服务中心','福建省教育考试院考试服务中心（福州通湖路后槽13号）','0591-87668908,87668905','350001'),(123,'信阳涉外职业技术学院','河南省信阳市新县产业集聚区发展大道1号教学楼、2号教学楼','0376-2793397','465500'),(124,'郑州大学','郑州市大学北路75号郑州大学南校区','0371-67763503;','450000'),(125,'安徽三联学院','安徽省合肥市经济技术开发区合安路47号','0551-63830750','230601');
/*!40000 ALTER TABLE `roomtable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busertable`
--

DROP TABLE IF EXISTS `busertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `busertable` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '考生id',
  `uidnum` varchar(100) NOT NULL COMMENT '身份证号码',
  `upwd` varchar(100) NOT NULL COMMENT '密码',
  `uname` varchar(100) NOT NULL COMMENT '考生姓名',
  `uidphoto` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '证件照片',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=557 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busertable`
--

LOCK TABLES `busertable` WRITE;
/*!40000 ALTER TABLE `busertable` DISABLE KEYS */;
INSERT INTO `busertable` VALUES (33,'21010320000311061X','123456','邓淞文','1'),(34,'510182199907053823','123456','边晓璐','1');
/*!40000 ALTER TABLE `busertable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-24 23:29:22
