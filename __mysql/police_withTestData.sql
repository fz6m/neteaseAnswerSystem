/*
Navicat MySQL Data Transfer

Source Server         : localMYsql
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : police

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-03-23 01:25:37
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
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('200', '1', null, '我永远记得  (Live)', '周锐  / 尤长靖 / 韩沐伯 / 杨非同 / 王子异 / 毕雯珺 / 董又霖', '支持子异', '1', '0', '0', '1', '0', null, '0', '');
INSERT INTO `answer` VALUES ('200', '2', null, '扇子舞', '李常超  (Lao乾妈)', '感谢网易云，让我遇见了李常超', '8', '0', '0', '1', '1', null, '0', '');
INSERT INTO `answer` VALUES ('200', '3', '无意义内容', '曇のち雨', 'なゆごろう', '我是一个在校学生，今天早上醒来发现嘴里有双袜子，中午到现在一直余味绕梁睡不着，如果晚上睡觉前有44个赞我就把袜子塞回凶手嘴里，如果有444个赞我就让他明天一整天继续翘课', '110', '1', '200', '0', '1', null, '0', '');
INSERT INTO `answer` VALUES ('200', '4', '无意义内容', '曇のち雨', 'なゆごろう', '我是一个在校学生，今天早上醒来发现嘴里有双袜子，中午到现在一直余味绕梁睡不着，如果晚上睡觉前有44个赞我就把袜子塞回凶手嘴里，如果有444个赞我就让他明天一整天继续翘课', '110', '1', '1', '0', '1', null, '0', '');

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `id` int NOT NULL,
  `token` varchar(255) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of token
-- ----------------------------

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

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('200', '3', '000003', '3', '1', '1', '0');
