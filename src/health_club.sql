
/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : health_club

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2014-05-24 11:44:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(200) NOT NULL DEFAULT '0',
  `picture` varchar(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', 'Football', 'member/images/activity/football.jpg');
INSERT INTO `activity` VALUES ('2', 'Basketball', 'member/images/activity/basketball.jpg');
INSERT INTO `activity` VALUES ('3', 'long-distance race', 'member/images/activity/run.jpg');
INSERT INTO `activity` VALUES ('4', 'long-distance race', 'member/images/activity/4.jpg');
INSERT INTO `activity` VALUES ('5', 'badminton', 'member/images/activity/5.jpg');
INSERT INTO `activity` VALUES ('6', 'Taekwondo', 'member/images/activity/6.jpg');
INSERT INTO `activity` VALUES ('7', 'Pingpang', 'member/images/activity/7.jpg');
INSERT INTO `activity` VALUES ('8', 'box', 'member/images/activity/8.jpg');
INSERT INTO `activity` VALUES ('9', 'swim', 'member/images/activity/9.jpg');
INSERT INTO `activity` VALUES ('10', 'aaass', 'member/images/activity/10.jpg');

-- ----------------------------
-- Table structure for `coach`
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO `coach` VALUES ('1', 'Carrie');
INSERT INTO `coach` VALUES ('2', 'Bob');
INSERT INTO `coach` VALUES ('3', 'Adolf');
INSERT INTO `coach` VALUES ('4', 'Pandora');
INSERT INTO `coach` VALUES ('5', 'Samara');
INSERT INTO `coach` VALUES ('6', 'Boris');
INSERT INTO `coach` VALUES ('7', 'Angelia');
INSERT INTO `coach` VALUES ('8', 'Aimee');
INSERT INTO `coach` VALUES ('9', 'Boris');
INSERT INTO `coach` VALUES ('10', 'Joy');

-- ----------------------------
-- Table structure for `joinin`
-- ----------------------------
DROP TABLE IF EXISTS `joinin`;
CREATE TABLE `joinin` (
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `sid` int(11) DEFAULT NULL COMMENT 'session的id',
  `type` int(11) DEFAULT '0' COMMENT '0表示预定的活动；1表示已经参加的活动'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of joinin
-- ----------------------------
INSERT INTO `joinin` VALUES ('1000027', '1', '0');
INSERT INTO `joinin` VALUES ('1000041', '3', '0');
INSERT INTO `joinin` VALUES ('1000043', '1', '0');
INSERT INTO `joinin` VALUES ('1000043', '2', '0');
INSERT INTO `joinin` VALUES ('1000000', '1', '0');
INSERT INTO `joinin` VALUES ('1000000', '2', '0');
INSERT INTO `joinin` VALUES ('1000000', '3', '0');

-- ----------------------------
-- Table structure for `location`
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES ('1', 'Nanjing Olympic Sports Center field1');
INSERT INTO `location` VALUES ('2', 'Nanjing Olympic Sports Center field2');
INSERT INTO `location` VALUES ('3', 'Nanjing Olympic Sports Center field3');
INSERT INTO `location` VALUES ('4', 'Nanjing Olympic Sports Center field4');
INSERT INTO `location` VALUES ('5', 'Nanjing Olympic Sports Center field5');
INSERT INTO `location` VALUES ('6', 'Nanjing Olympic Sports Center field6');
INSERT INTO `location` VALUES ('7', 'Nanjing Olympic Sports Center field7');
INSERT INTO `location` VALUES ('8', 'Nanjing Olympic Sports Center field8');
INSERT INTO `location` VALUES ('9', 'Nanjing Olympic Sports Center field9');
INSERT INTO `location` VALUES ('10', 'Nanjing Olympic Sports Center field10');

-- ----------------------------
-- Table structure for `managers`
-- ----------------------------
DROP TABLE IF EXISTS `managers`;
CREATE TABLE `managers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '0',
  `password` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of managers
-- ----------------------------
INSERT INTO `managers` VALUES ('1', 'manager', '881');
INSERT INTO `managers` VALUES ('2', 'manager2', '881');

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) DEFAULT '0',
  `gender` varchar(20) DEFAULT 'woman',
  `birthday` date DEFAULT NULL,
  `identity` varchar(20) DEFAULT 'head' COMMENT 'head,spouse,child,father,mother,other',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('4', '1000028', 'a', 'Woman', '2014-03-13', 'Head');
INSERT INTO `member` VALUES ('5', '1000031', 'a', 'Man', '2014-03-21', 'Head');
INSERT INTO `member` VALUES ('6', '1000037', 'bob', 'Man', '2014-02-26', 'Head');
INSERT INTO `member` VALUES ('7', '1000037', 'anny', 'Woman', '2014-02-28', 'Mate');
INSERT INTO `member` VALUES ('8', '1000038', 'a', 'Man', '2014-02-15', 'Head');
INSERT INTO `member` VALUES ('9', '1000038', '', 'Woman', '1994-03-16', 'Head');
INSERT INTO `member` VALUES ('40', '1000027', 'bobbob', 'Man', '2014-03-13', 'Head');
INSERT INTO `member` VALUES ('41', '1000027', 'anny', 'Woman', '2010-02-02', 'Mate');
INSERT INTO `member` VALUES ('42', '1000027', 'simon', 'Man', '1991-02-06', 'Child');
INSERT INTO `member` VALUES ('43', '1000027', 'igoo', 'Man', '2014-03-26', 'Child');

-- ----------------------------
-- Table structure for `pay`
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT '1' COMMENT '1表示已激活，欠费;2表示已缴费',
  `paytime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay
-- ----------------------------
INSERT INTO `pay` VALUES ('1', '1000000', '2014-03', '2', '2014-05-17 09:39:05');
INSERT INTO `pay` VALUES ('2', '1000000', '2014-02', '2', '2014-05-17 10:26:57');
INSERT INTO `pay` VALUES ('3', '1000000', '2014-01', '1', '');
INSERT INTO `pay` VALUES ('4', '1000000', '2013-12', '1', '');
INSERT INTO `pay` VALUES ('5', '1000010', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('6', '1000000', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('7', '1000005', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('8', '1000006', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('9', '1000009', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('10', '1000010', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('11', '1000011', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('12', '1000012', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('13', '1000013', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('14', '1000016', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('15', '1000017', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('16', '1000025', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('17', '1000027', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('18', '1000028', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('19', '1000029', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('20', '1000030', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('21', '1000031', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('22', '1000032', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('23', '1000033', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('24', '1000034', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('25', '1000036', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('26', '1000037', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('27', '1000038', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('28', '1000039', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('29', '1000041', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('30', '1000042', '2014-3', '1', null);
INSERT INTO `pay` VALUES ('31', '1000043', '2014-3', '1', null);

-- ----------------------------
-- Table structure for `session`
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) NOT NULL DEFAULT '0',
  `time` varchar(50) DEFAULT NULL,
  `location` varchar(200) DEFAULT '0',
  `coach` varchar(50) DEFAULT '0',
  `theme` varchar(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of session
-- ----------------------------
INSERT INTO `session` VALUES ('1', '1', '01 January 2014 - 00:00', 'Nanjing Olympic Sports Center field2', 'Bob', 'Football');
INSERT INTO `session` VALUES ('2', '1', '05 February 2014 - 06:50', 'Nanjing Olympic Sports Center field1', 'Bob', 'Football');
INSERT INTO `session` VALUES ('3', '1', '21 March 2014 - 10:30', 'Nanjing Olympic Sports Center field1', 'Carrie', 'Football');
INSERT INTO `session` VALUES ('4', '3', '02 April 2014 - 10:50', 'Nanjing Olympic Sports Center field1', 'Carrie', 'long-distance race');
INSERT INTO `session` VALUES ('5', '4', '07 May 2014 - 14:50', 'Nanjing Olympic Sports Center field2', 'Bob', 'long-distance race');
INSERT INTO `session` VALUES ('6', '4', '06 June 2014 - 11:55', 'Nanjing Olympic Sports Center field3', 'Samara', 'long-distance race');
INSERT INTO `session` VALUES ('7', '5', '13 March 2014 - 14:50', 'Nanjing Olympic Sports Center field1', 'Adolf', 'badminton');
INSERT INTO `session` VALUES ('8', '5', '05 March 2014 - 19:55', 'Nanjing Olympic Sports Center field2', 'Carrie', 'badminton');
INSERT INTO `session` VALUES ('9', '6', '21 March 2014 - 10:50', 'Nanjing Olympic Sports Center field8', 'Adolf', 'Taekwondo');
INSERT INTO `session` VALUES ('10', '6', '20 March 2014 - 11:30', 'Nanjing Olympic Sports Center field5', 'Joy', 'Taekwondo');
INSERT INTO `session` VALUES ('11', '7', '18 April 2014 - 10:05', 'Nanjing Olympic Sports Center field6', 'Angelia', 'Pingpang');
INSERT INTO `session` VALUES ('12', '7', '26 March 2014 - 14:50', 'Nanjing Olympic Sports Center field7', 'Boris', 'Pingpang');
INSERT INTO `session` VALUES ('13', '7', '27 March 2014 - 15:55', 'Nanjing Olympic Sports Center field9', 'Aimee', 'Pingpang');
INSERT INTO `session` VALUES ('14', '8', '04 March 2014 - 09:30', 'Nanjing Olympic Sports Center field1', 'Boris', 'box');
INSERT INTO `session` VALUES ('15', '8', '07 March 2014 - 11:35', 'Nanjing Olympic Sports Center field9', 'Carrie', 'box');
INSERT INTO `session` VALUES ('16', '9', '06 March 2014 - 11:55', 'Nanjing Olympic Sports Center field5', 'Pandora', 'swim');
INSERT INTO `session` VALUES ('17', '9', '20 March 2014 - 10:35', 'Nanjing Olympic Sports Center field4', 'Bob', 'swim');
INSERT INTO `session` VALUES ('18', '10', '07 May 2014 - 10:35', 'Nanjing Olympic Sports Center field1', 'Carrie', 'aaass');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gender` varchar(20) NOT NULL DEFAULT 'Woman' COMMENT 'Woman；Man；Other',
  `birthday` date DEFAULT NULL,
  `address` varchar(50) NOT NULL,
  `picture` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'personal' COMMENT 'personal，family',
  `register_time` date DEFAULT NULL COMMENT '注册日期，精确到date，time忽略~',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示未激活；1表示已激活，但是欠费，欠费少于6月，会员记录暂停；2表示正常；3表示欠费，欠费超过6个月，会员记录停止；4表示已取消资格。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000045 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1000000', 'igoo', '881', 'igoo@gmail.com', 'Man', '1992-11-07', 'Nanjing University', 'member/images/picture/igoo.jpg', 'Personal', '2014-03-01', '1');
INSERT INTO `users` VALUES ('1000005', 'igoo2', '881', 'igoo@gmail.com', 'Man', '1992-10-13', 'nanjing', 'member/images/picture/igoo.jpg', 'Personal', '2014-03-03', '0');
INSERT INTO `users` VALUES ('1000006', 'igoo3', '881', 'igoo@gmail.com', 'Man', '1992-06-13', 'nanjing', 'member/images/picture/kaiji.png', 'Personal', '2014-03-03', '0');
INSERT INTO `users` VALUES ('1000009', 'igoo5', '881', 'igoo@gmail.com', 'Woman', '1992-10-13', 'nanjing', 'member/images/picture/igoo5.png', 'Personal', '2014-03-03', '0');
INSERT INTO `users` VALUES ('1000010', 'igoo6', '881', 'igoo@gmail.com', '0', '1992-10-05', 'nanjing', 'member/images/picture/igoo6.png', 'Family', '2014-03-03', '0');
INSERT INTO `users` VALUES ('1000011', 'igoo7', '881', 'igoo@gmail.com', 'Man', '1992-02-05', 'nanjing', 'member/images/picture/igoo7.png', 'Personal', '2014-03-03', '0');
INSERT INTO `users` VALUES ('1000012', 'igoo22', '881', 'igoo@gmail.com', 'Man', '1992-03-05', 'nanjing', 'member/images/picture/igoo22.png', 'Personal', '2014-03-03', '0');
INSERT INTO `users` VALUES ('1000013', 'igoo28', '881', 'igoo@gmail.com', 'Man', '1992-03-05', 'nanjing', 'member/images/picture/igoo28.png', 'Personal', '2014-03-03', '0');
INSERT INTO `users` VALUES ('1000016', 'igooo', '881', 'aaaa@gmail.com', 'Woman', '2014-03-06', 'nanjing', 'member/images/logo.png', 'Personal', '2014-03-11', '0');
INSERT INTO `users` VALUES ('1000017', 'igoo4', '881', 'igoo4@gmail.com', 'Man', '2014-03-04', 'nanjing', 'member/images/logo.png', 'Personal', '2014-03-11', '0');
INSERT INTO `users` VALUES ('1000025', 'igoo8', '881', 'igoo@gmail.com', 'Man', '2014-03-11', 'nanjing', 'member/images/logo.png', 'Personal', '2014-03-12', '0');
INSERT INTO `users` VALUES ('1000027', 'igoo11', '881', '12323@gamil.com', '0', '2014-03-12', 'nanjing', 'member/images/picture/igoo11.jpg', 'Family', '2014-03-12', '0');
INSERT INTO `users` VALUES ('1000028', 'igoo12', '881', '12323@gamil.com', '0', '2014-03-12', 'nanjing', 'member/images/logo.png', 'Family', '2014-03-12', '0');
INSERT INTO `users` VALUES ('1000029', 'igoo13', '881', 'igoo@gmail.com', 'Man', '2014-03-14', 'nanjing', 'member/images/logo.png', 'Personal', '2014-03-12', '0');
INSERT INTO `users` VALUES ('1000030', 'igoo14', '881', 'igoo@gmail.com', 'Man', '2014-03-14', 'nanjing', 'member/images/logo.png', 'Personal', '2014-03-12', '0');
INSERT INTO `users` VALUES ('1000031', 'igoo15', '881', '12323@gamil.com', '0', '2014-03-12', 'nanjing', 'member/images/logo.png', 'Family', '2014-03-12', '0');
INSERT INTO `users` VALUES ('1000032', 'igoo16', '881', 'igoo@gmail.com', 'Woman', '2014-03-04', 'nanjing', 'member/images/picture/igoo16.png', 'Personal', '2014-03-12', '0');
INSERT INTO `users` VALUES ('1000033', 'igoo17', '881', 'igoo@gmail.com', 'Man', '2014-03-05', 'nanjing', 'E:/workspace/JavaEE/HealthClub/WebContent/member/images/picture/igoo17.png', 'Personal', '2014-03-12', '0');
INSERT INTO `users` VALUES ('1000034', 'igoo18', '881', 'igoo@gmail.com', 'Man', '2014-03-01', 'nj', 'member/images/picture/igoo18.png', 'Personal', '2014-03-12', '0');
INSERT INTO `users` VALUES ('1000036', 'igoo20', '881', 'igoo@gmail.com', 'Woman', '2014-03-06', 'nj', 'member/images/picture/igoo20.png', 'Personal', '2014-03-12', '0');
INSERT INTO `users` VALUES ('1000037', 'igoo21', '881', '12323@gamil.com', '0', '2014-03-12', 'nj', 'member/images/picture/igoo21.png', 'Family', '2014-03-12', '0');
INSERT INTO `users` VALUES ('1000038', 'igoo10', '881', '12323@gamil.com', '0', '2014-03-12', 'nanjing', 'member/images/picture/igoo10.png', 'Family', '2014-03-12', '1');
INSERT INTO `users` VALUES ('1000039', 'igoo23', '881', 'igoo@gmail.com', 'Woman', '2014-03-13', 'nanjing', 'member/images/logo.png', 'Personal', '2014-03-12', '0');
INSERT INTO `users` VALUES ('1000041', 'igoo24', '881', 'igoo@gmail.com', 'Woman', '2014-03-12', 'nanjing', 'member/images/picture/igoo24.png', 'Personal', '2014-03-13', '0');
INSERT INTO `users` VALUES ('1000042', 'igoo29', '881', 'aa@qq.com', 'Man', '2014-03-05', 'nh', 'member/images/picture/igoo29.jpg', 'Personal', '2014-03-19', '0');
INSERT INTO `users` VALUES ('1000043', 'igoo30', '881', 'igoo@gmail.com', 'Man', '2014-02-05', 'Nanjing', 'member/images/picture/igoo30.jpg', 'Personal', '2014-03-19', '1');
INSERT INTO `users` VALUES ('1000044', 'igoo55', '881', '1012@gmail.com', '0', '2014-05-17', 'nj', 'member/images/picture/igoo55.png', 'Family', '2014-05-17', '1');

-- ----------------------------
-- Table structure for `waiters`
-- ----------------------------
DROP TABLE IF EXISTS `waiters`;
CREATE TABLE `waiters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT '0',
  `password` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of waiters
-- ----------------------------
INSERT INTO `waiters` VALUES ('10000', 'admin', '881');
INSERT INTO `waiters` VALUES ('10001', 'admin2', '881');
INSERT INTO `waiters` VALUES ('10002', 'admin3', '881');
