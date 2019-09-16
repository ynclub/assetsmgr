/*
 Navicat Premium Data Transfer

 Source Server         : localhost-mysql57
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : assetsdb

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 15/09/2019 23:28:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE  IF NOT EXISTS `assetsdb`;
USE `assetsdb`;

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of categories
-- ----------------------------
INSERT INTO `categories` VALUES (1, '服务器');
INSERT INTO `categories` VALUES (2, '机柜');
INSERT INTO `categories` VALUES (3, '有盘站');
INSERT INTO `categories` VALUES (4, '路由器');
INSERT INTO `categories` VALUES (5, '交换机');
INSERT INTO `categories` VALUES (6, '防火墙');
INSERT INTO `categories` VALUES (7, '磁盘阵列柜');
INSERT INTO `categories` VALUES (8, '其他存储设备');
INSERT INTO `categories` VALUES (9, '其他机房设备');
INSERT INTO `categories` VALUES (10, '便携计算机');

-- ----------------------------
-- Table structure for menus
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus`  (
  `mid` int(11) NOT NULL AUTO_INCREMENT COMMENT '资产ID',
  `cid` int(11) NULL DEFAULT NULL COMMENT '资产分类ID',
  `mname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产名称',
  `mtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格型号',
  `beginusedate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开始使用日期',
  `assetcoding` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产编码',
  `orivalue` float(11, 2) NULL DEFAULT NULL COMMENT '本币原值',
  `depreciation` float(11, 2) NULL DEFAULT NULL COMMENT '累计折旧',
  `netvalue` float(11, 2) NULL DEFAULT NULL COMMENT '净值',
  `person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用人',
  PRIMARY KEY (`mid`) USING BTREE,
  UNIQUE INDEX `id_UNIQUE`(`mid`) USING BTREE,
  INDEX `cid_idx`(`cid`) USING BTREE,
  CONSTRAINT `cid` FOREIGN KEY (`cid`) REFERENCES `categories` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES (1, 1, '笔记本电脑', 'rrr', '2019-09-20', '0101ZA01030365', 5853.44, 629.84, 5223.60, 'admin');
INSERT INTO `menus` VALUES (2, 3, '有盘站', 'test', '2019-09-15', '0150A01020028', 3900.00, 3783.00, 117.01, 'admin');

SET FOREIGN_KEY_CHECKS = 1;
