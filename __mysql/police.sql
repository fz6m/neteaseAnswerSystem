/*
Navicat MySQL Data Transfer

Source Server         : localMYsql
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : police

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-03-23 08:18:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `user_id` int NOT NULL,
  `id` int NOT NULL,
  `suggest` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `singer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `awesome` int DEFAULT '0',
  `attitude` int NOT NULL,
  `attitude_delete` int DEFAULT '0',
  `delete` int NOT NULL,
  `raw_answer` int NOT NULL,
  `answer` int DEFAULT NULL,
  `reply` int NOT NULL DEFAULT '0',
  `reply_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('200', '1', '维持原样', '小半  (Live)', '周锐 / 郑锐彬 / 灵超 / 钱正昊', '全时股东钱正昊💗，天赐密嗓钱正昊💗，儿子加油冲！💗', '8', '1', '0', '0', '1', '1', '0', null);
INSERT INTO `answer` VALUES ('200', '7', '维持原样', '成全', '林宥嘉', '2018年7月18日，我的爱人，方侨，虽然异地，但是生日快乐，谢谢你参与我的过去现在及往后余生，这是第九条评论。 ', '2', '1', '0', '0', '2', '2', '0', null);
INSERT INTO `answer` VALUES ('200', '8', '维持原样', '东京铁塔下', '有耳非文', '怎么会有这么好听的歌  每次听开心得都要转圈圈了', '0', '1', '0', '0', '1', '1', '1', '你好可爱');
INSERT INTO `answer` VALUES ('200', '4', '维持原样', '贝加尔湖畔', '李健', '何慧。我爱你。我等你回来。希望她能看见这条评论回我，我一定不放手', '3', '1', '0', '0', '2', '2', '0', null);
INSERT INTO `answer` VALUES ('200', '5', '取消热评', '曇のち雨', 'なゆごろう', '我是一个在校学生，今天早上醒来发现嘴里有双袜子，中午到现在一直余味绕梁睡不着，如果晚上睡觉前有44个赞我就把袜子塞回凶手嘴里，如果有444个赞我就让他明天一整天继续翘课', '110', '1', '0', '0', '1', '1', '1', '陈独秀坐下');
INSERT INTO `answer` VALUES ('200', '6', '求赞求粉', '化身孤岛的鲸', '不才', '别傻了，梵高割耳朵是因为他的朋友，扶我上去🌝', '2', '1', '1', '0', '1', '1', '1', '梵高的爱人是一个妓女  他把所有的钱都用在画画和妓女身上 有一天妓女说想要梵高的耳朵 于是梵高真的把耳朵割下来 有了著名的梵高的自画像  但是当梵高把耳朵给了妓女的时候妓女吓的落荒而逃了 你看 为什么我把你想要的给了你 你还是走了');
INSERT INTO `answer` VALUES ('200', '2', null, 'Aspiration', 'Teminite', '那天我开我的五菱宏光上高速单曲循环这首歌，飙到210，交警和我并驾齐驱。交警拿着扩音器对我喊，我不抓你也不扣你分，你就告诉我这是什么歌。', '2', '0', '0', '1', '18', '18', '0', null);
INSERT INTO `answer` VALUES ('200', '3', null, 'Purple  Passion', 'Diana  Boncheva', '\"我有了一个惊人的发现\n刘备的两个儿子:刘封，刘禅\n连起来就是封禅，说明他有帝王之心。\n孙坚的两个儿子:孙权，孙策\n连起来是权策，说明他善于权策。\n再来看看老曹家:曹操，曹仁，曹真，曹爽\n曹家祖宗真是个传奇人物\"', '24', '0', '0', '0', '3', '3', '0', null);
INSERT INTO `answer` VALUES ('200', '9', null, '祝英台', '谢安琪', '这首歌写的就是63版的梁山伯与祝英台，剧中讲的是两个“男同性恋”的故事，而饰演者却是两个女艺人（乐蒂，凌波）反串。用“女同性恋”演绎“男同性恋”，表现世间直教人生死相许的男女之爱。经典，绝世！', '2', '0', '0', '1', '14', '2', '1', '就没人把我顶上去让更多人看到那部经典的电影吗？李安说他的奥斯卡获奖作《卧虎藏龙》就是借鉴了这部电影啊');
INSERT INTO `answer` VALUES ('200', '10', null, '四驱兄弟4MaticBros  2018 Cypher', ' 四驱兄弟4MaticBros  / 3Bangz / 未来星B3Rich / Gucci D', '狠毒男孩微博找到了  @徐圣恩', '0', '0', '0', '1', '17', '17', '1', '去你妈吧弟中弟练习生死🐴');

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `id` int NOT NULL,
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('200', '0', '000000', '10', '0', '0', '0');
