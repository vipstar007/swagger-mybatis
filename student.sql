/*
Navicat MySQL Data Transfer

Source Server         : danni
Source Server Version : 50624
Source Host           : 127.0.0.1:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-10-13 23:15:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(10) DEFAULT NULL,
  `adminpwd` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `did` int(10) NOT NULL AUTO_INCREMENT,
  `departname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `eid` int(10) NOT NULL AUTO_INCREMENT,
  `ename` varchar(10) DEFAULT NULL,
  `esex` varchar(1) DEFAULT NULL,
  `did` int(10) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `employee_ibfk_1` (`did`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;
