-- CREATE TABLE harbor (
--   id bigint(20) NOT NULL AUTO_INCREMENT,
--   latitude DOUBLE NOT NULL,
--   longitude DOUBLE NOT NULL,
--   name VARCHAR(255) NOT NULL,
--   PRIMARY KEY (id)
-- );
--
-- CREATE TABLE mooring_ball (
--   id bigint(20) NOT NULL AUTO_INCREMENT,
--   latitude DOUBLE NOT NULL,
--   longitude DOUBLE NOT NULL,
--   name VARCHAR(255) NOT NULL,
--   harbor_id  bigint(20) NOT NULL,
--   reserved BOOLEAN NOT NULL,
--   owner VARCHAR(255) NOT NULL,
--   price VARCHAR(255) NOT NULL,
--   FOREIGN KEY (harbor_id) REFERENCES harbor (id),
--   PRIMARY KEY (id)
-- );
--
-- CREATE TABLE app_role (
--   id bigint(20) NOT NULL AUTO_INCREMENT,
--   description varchar(255) DEFAULT NULL,
--   role_name varchar(255) DEFAULT NULL,
--   PRIMARY KEY (id)
-- );
--
--
-- CREATE TABLE app_user (
--   id bigint(20) NOT NULL AUTO_INCREMENT,
--   first_name varchar(255) NOT NULL,
--   last_name varchar(255) NOT NULL,
--   password varchar(255) NOT NULL,
--   username varchar(255) NOT NULL,
--   PRIMARY KEY (id)
-- );
--
--
-- CREATE TABLE user_role (
--   user_id bigint(20) NOT NULL,
--   role_id bigint(20) NOT NULL,
--   CONSTRAINT FK859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES app_user (id),
--   CONSTRAINT FKa68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES app_role (id)
-- );


DROP TABLE IF EXISTS `app_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_role`
--

LOCK TABLES `app_role` WRITE;
/*!40000 ALTER TABLE `app_role` DISABLE KEYS */;
INSERT INTO `app_role` VALUES (1,'admin','ADMIN_USER');
/*!40000 ALTER TABLE `app_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES (1,'Mary','Lukyanova','1234','user');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `harbor`
--

DROP TABLE IF EXISTS `harbor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `harbor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `harbor`
--

LOCK TABLES `harbor` WRITE;
/*!40000 ALTER TABLE `harbor` DISABLE KEYS */;
/*!40000 ALTER TABLE `harbor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mooring_ball`
--

DROP TABLE IF EXISTS `mooring_ball`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mooring_ball` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `name` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL,
  `reseved` bit(1) NOT NULL,
  `harbor_id` bigint(20) NOT NULL,
  `reserved` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `harbor_id_idx` (`harbor_id`),
  CONSTRAINT `FK16kdjo7r0b0g7y363x87cudci` FOREIGN KEY (`harbor_id`) REFERENCES `harbor` (`id`),
  CONSTRAINT `harbor_id` FOREIGN KEY (`harbor_id`) REFERENCES `harbor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mooring_ball`
--

LOCK TABLES `mooring_ball` WRITE;
/*!40000 ALTER TABLE `mooring_ball` DISABLE KEYS */;
/*!40000 ALTER TABLE `mooring_ball` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKp6m37g6n6c288s096400uw8fw` (`role_id`),
  KEY `FKg7fr1r7o0fkk41nfhnjdyqn7b` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `app_role` (`id`),
  CONSTRAINT `FKg7fr1r7o0fkk41nfhnjdyqn7b` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FKp6m37g6n6c288s096400uw8fw` FOREIGN KEY (`role_id`) REFERENCES `app_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;