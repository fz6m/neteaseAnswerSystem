/*
Navicat MySQL Data Transfer

Source Server         : localMYsql
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : police

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-03-23 01:23:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `user_id` int NOT NULL,
  `id` int NOT NULL,
  `suggest` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `singer` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `awesome` int DEFAULT '0',
  `attitude` int NOT NULL,
  `attitude_delete` int DEFAULT '0',
  `delete` int NOT NULL,
  `raw_answer` int NOT NULL,
  `answer` int DEFAULT NULL,
  `reply` int NOT NULL DEFAULT '0',
  `reply_content` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `id` int NOT NULL,
  `token` varchar(255) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `count` int unsigned NOT NULL DEFAULT '0',
  `answering_id` int(6) unsigned zerofill NOT NULL DEFAULT '000000',
  `max` int NOT NULL,
  `start` int NOT NULL DEFAULT '0',
  `end` int NOT NULL DEFAULT '0',
  `individual_topics` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
