-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: rs_tutorials
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.04.2

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_authorities_1_idx` (`username`),
  CONSTRAINT `fk_authorities_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,'dev','ROLE_ADMIN'),(2,'kalpana','ROLE_USER'),(5,'rahul','ROLE_ADMIN');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_calendar`
--

DROP TABLE IF EXISTS `base_calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_calendar` (
  `base_calendar_id` int(11) NOT NULL,
  `month` varchar(45) NOT NULL,
  `day` varchar(45) NOT NULL,
  `year` varchar(45) NOT NULL,
  `holiday_name` varchar(45) NOT NULL,
  `holiday_description` varchar(45) NOT NULL,
  PRIMARY KEY (`base_calendar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_calendar`
--

LOCK TABLES `base_calendar` WRITE;
/*!40000 ALTER TABLE `base_calendar` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_calendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `board_id` int(11) NOT NULL AUTO_INCREMENT,
  `board_name` varchar(45) NOT NULL,
  PRIMARY KEY (`board_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'SSC'),(2,'CBSE'),(3,'ICSE');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chapter`
--

DROP TABLE IF EXISTS `chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chapter` (
  `chapter_id` int(11) NOT NULL,
  `chapter_number` varchar(45) NOT NULL,
  `chapter_name` varchar(45) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `start_date` date DEFAULT NULL,
  `finish_date` date DEFAULT NULL,
  `time_taken` int(11) DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  `taken_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`chapter_id`),
  KEY `fk_chapter_subjects_idx` (`subject_id`),
  KEY `fk_chapter_teacher_id_idx` (`taken_by`),
  CONSTRAINT `FK1ud8idx7x6ut5lmxuoy8dl3yh` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `FK4auh2qsus6g45pvorun4c9o5p` FOREIGN KEY (`taken_by`) REFERENCES `users` (`username`),
  CONSTRAINT `FK625ean2i3gwopuaojiecxitlu` FOREIGN KEY (`taken_by`) REFERENCES `users` (`username`),
  CONSTRAINT `fk_chapter_subjects` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_chapter_teacher_id` FOREIGN KEY (`taken_by`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chapter`
--

LOCK TABLES `chapter` WRITE;
/*!40000 ALTER TABLE `chapter` DISABLE KEYS */;
/*!40000 ALTER TABLE `chapter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_calendar`
--

DROP TABLE IF EXISTS `class_calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_calendar` (
  `class_calendar_id` int(11) NOT NULL,
  `month` varchar(45) NOT NULL,
  `day` varchar(45) NOT NULL,
  `year` varchar(45) NOT NULL,
  `standard_id` int(11) NOT NULL,
  `event_name` varchar(45) NOT NULL,
  `event_description` varchar(45) NOT NULL,
  `event_type` varchar(45) NOT NULL,
  PRIMARY KEY (`class_calendar_id`),
  KEY `fk_class_level_type_id_idx` (`standard_id`),
  CONSTRAINT `FKoquabacm8nqi4932jgmde27qf` FOREIGN KEY (`standard_id`) REFERENCES `standard` (`standard_id`),
  CONSTRAINT `fk_calendar_class_level_type_id` FOREIGN KEY (`standard_id`) REFERENCES `standard` (`standard_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_calendar`
--

LOCK TABLES `class_calendar` WRITE;
/*!40000 ALTER TABLE `class_calendar` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_calendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL,
  `comments` varchar(45) DEFAULT NULL,
  `given_by` varchar(45) NOT NULL,
  `given_to` varchar(45) NOT NULL,
  `given_on` int(11) NOT NULL,
  `rating` varchar(45) NOT NULL,
  `feedback_type` varchar(45) NOT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `fk_feedback_given_to_idx` (`given_to`),
  KEY `fk_feedback_given_by_idx` (`given_by`),
  CONSTRAINT `fk_feedback_1` FOREIGN KEY (`given_by`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_feedback_2` FOREIGN KEY (`given_to`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecture_schedule`
--

DROP TABLE IF EXISTS `lecture_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lecture_schedule` (
  `lecture_schedule_id` int(11) NOT NULL,
  `class_level_type_id` int(11) DEFAULT NULL,
  `lecture_datetime` varchar(45) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `taken_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`lecture_schedule_id`),
  KEY `fk_ls_class_level_type_id_idx` (`class_level_type_id`),
  KEY `fk_ls_taken_by_idx` (`taken_by`),
  CONSTRAINT `FKpcs7v2nj8e2t2iq2t1er2jjuk` FOREIGN KEY (`class_level_type_id`) REFERENCES `standard` (`standard_id`),
  CONSTRAINT `FKra0a5dgtj09a86fsio2tr3l6i` FOREIGN KEY (`taken_by`) REFERENCES `users` (`username`),
  CONSTRAINT `fk_ls_class_level_type_id` FOREIGN KEY (`class_level_type_id`) REFERENCES `standard` (`standard_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ls_taken_by` FOREIGN KEY (`taken_by`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture_schedule`
--

LOCK TABLES `lecture_schedule` WRITE;
/*!40000 ALTER TABLE `lecture_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `lecture_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_papers`
--

DROP TABLE IF EXISTS `question_papers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_papers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `board_id` int(11) NOT NULL,
  `content` tinyblob NOT NULL,
  `created` date DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `paper_name` varchar(45) NOT NULL,
  `updated` date DEFAULT NULL,
  `standard_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhpu7f6flf00xmsgcn2bkta4jf` (`standard_id`),
  KEY `FKco5rgrmydtkr9ltg0ca6h39bb` (`subject_id`),
  KEY `fk_question_papers_1_idx` (`board_id`),
  CONSTRAINT `FKco5rgrmydtkr9ltg0ca6h39bb` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `FKhpu7f6flf00xmsgcn2bkta4jf` FOREIGN KEY (`standard_id`) REFERENCES `standard` (`standard_id`),
  CONSTRAINT `fk_question_papers_1` FOREIGN KEY (`board_id`) REFERENCES `board` (`board_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_papers`
--

LOCK TABLES `question_papers` WRITE;
/*!40000 ALTER TABLE `question_papers` DISABLE KEYS */;
/*!40000 ALTER TABLE `question_papers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `standard`
--

DROP TABLE IF EXISTS `standard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `standard` (
  `standard_id` int(11) NOT NULL,
  `board_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `language` varchar(45) NOT NULL,
  `fees` int(11) DEFAULT NULL,
  PRIMARY KEY (`standard_id`),
  KEY `fk_standard_1_idx` (`board_id`),
  CONSTRAINT `fk_standard_1` FOREIGN KEY (`board_id`) REFERENCES `board` (`board_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standard`
--

LOCK TABLES `standard` WRITE;
/*!40000 ALTER TABLE `standard` DISABLE KEYS */;
/*!40000 ALTER TABLE `standard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_standard`
--

DROP TABLE IF EXISTS `student_standard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_standard` (
  `student_detail_id` int(11) NOT NULL,
  `student_id` varchar(45) NOT NULL,
  `standard_id` int(11) NOT NULL,
  PRIMARY KEY (`student_detail_id`),
  KEY `fk_class_level_type_id_idx` (`standard_id`),
  KEY `fk_student_detail_student_id_idx` (`student_id`),
  CONSTRAINT `FK1a9aforw4q7956bs05tdqcymp` FOREIGN KEY (`student_id`) REFERENCES `users` (`username`),
  CONSTRAINT `FK6vql4e7f8bnqo6ehmi6gbhq2f` FOREIGN KEY (`standard_id`) REFERENCES `standard` (`standard_id`),
  CONSTRAINT `fk_class_level_type_id` FOREIGN KEY (`standard_id`) REFERENCES `standard` (`standard_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_detail_student_id` FOREIGN KEY (`student_id`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_standard`
--

LOCK TABLES `student_standard` WRITE;
/*!40000 ALTER TABLE `student_standard` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_standard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL,
  `subject_name` varchar(45) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `fk_sub_class_level_type_id_idx` (`class_id`),
  CONSTRAINT `FKdu36t2tvnik6uxe9ud2at2t03` FOREIGN KEY (`class_id`) REFERENCES `standard` (`standard_id`),
  CONSTRAINT `fk_sub_class_id` FOREIGN KEY (`class_id`) REFERENCES `standard` (`standard_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `take_up_defaulter_calendar`
--

DROP TABLE IF EXISTS `take_up_defaulter_calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `take_up_defaulter_calendar` (
  `defaulter_id` int(11) NOT NULL,
  `student_id` varchar(45) NOT NULL,
  `class_calendar_id` int(11) NOT NULL,
  PRIMARY KEY (`defaulter_id`),
  KEY `fk_defaulter_class_calendar_id_idx` (`class_calendar_id`),
  KEY `fk_defaulter_student_id_idx` (`student_id`),
  CONSTRAINT `FK4tdvqco4igke20dhu9uhcgf1w` FOREIGN KEY (`class_calendar_id`) REFERENCES `class_calendar` (`class_calendar_id`),
  CONSTRAINT `FKsnrib00pofeh30nhykkcj1xlw` FOREIGN KEY (`student_id`) REFERENCES `users` (`username`),
  CONSTRAINT `fk_defaulter_class_calendar_id` FOREIGN KEY (`class_calendar_id`) REFERENCES `class_calendar` (`class_calendar_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_defaulter_student_id` FOREIGN KEY (`student_id`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `take_up_defaulter_calendar`
--

LOCK TABLES `take_up_defaulter_calendar` WRITE;
/*!40000 ALTER TABLE `take_up_defaulter_calendar` DISABLE KEYS */;
/*!40000 ALTER TABLE `take_up_defaulter_calendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_result`
--

DROP TABLE IF EXISTS `test_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_result` (
  `test_result_id` int(11) NOT NULL,
  `student_id` varchar(45) DEFAULT NULL,
  `marks_obtained` int(11) DEFAULT NULL,
  `out_of` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `class_calendar_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`test_result_id`),
  KEY `fk_test_result_class_calendar_id_idx` (`class_calendar_id`),
  CONSTRAINT `FKjrn4epxg1o085y9nlic9ji12v` FOREIGN KEY (`class_calendar_id`) REFERENCES `class_calendar` (`class_calendar_id`),
  CONSTRAINT `fk_test_result_class_calendar_id` FOREIGN KEY (`class_calendar_id`) REFERENCES `class_calendar` (`class_calendar_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_result`
--

LOCK TABLES `test_result` WRITE;
/*!40000 ALTER TABLE `test_result` DISABLE KEYS */;
/*!40000 ALTER TABLE `test_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `email` varchar(75) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `address` varchar(150) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('dev','$2a$10$7VukYv1DmXXD94LXHgz2nOrhXLi8qETD2NS.qSOqDB.bGeCsfoxxi',1,'pandey.dev25@gmail.com',NULL,'brahmdev','pandey',NULL,'stockholm'),('kalpana','$2a$10$Rz2lIjnJnVvubjFqzSCvdeITJgML6OOU5ne/WnwXSFLFS0jDVnrvO',1,NULL,NULL,'kalpana','pandey',NULL,'stockholm'),('rahul','$2a$10$9jK0QWHIKcLeWThfFw2XaO3yGl41LPkhRjXEQAkLyoC5C6OFgSqgW',1,'',NULL,'rahul','singh',NULL,'mumbai');
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

-- Dump completed on 2019-03-03 19:38:25
