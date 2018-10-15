/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-10-15 14:55:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jh_resources_info
-- ----------------------------
DROP TABLE IF EXISTS `jh_resources_info`;
CREATE TABLE `jh_resources_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `resUrl` varchar(255) DEFAULT NULL COMMENT '资源url',
  `type` int(11) DEFAULT NULL COMMENT '资源类型   1:菜单    2：按钮',
  `parentId` int(11) DEFAULT NULL COMMENT '父资源',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jh_resources_info
-- ----------------------------
INSERT INTO `jh_resources_info` VALUES ('1', '系统设置', '/system', '0', '0', '1');
INSERT INTO `jh_resources_info` VALUES ('2', '用户管理', '/usersPage', '1', '1', '2');
INSERT INTO `jh_resources_info` VALUES ('3', '角色管理', '/rolesPage', '1', '1', '3');
INSERT INTO `jh_resources_info` VALUES ('4', '资源管理', '/resourcesPage', '1', '1', '4');
INSERT INTO `jh_resources_info` VALUES ('5', '添加用户', '/users/add', '2', '2', '5');
INSERT INTO `jh_resources_info` VALUES ('6', '删除用户', '/users/delete', '2', '2', '6');
INSERT INTO `jh_resources_info` VALUES ('7', '添加角色', '/roles/add', '2', '3', '7');
INSERT INTO `jh_resources_info` VALUES ('8', '删除角色', '/roles/delete', '2', '3', '8');
INSERT INTO `jh_resources_info` VALUES ('9', '添加资源', '/resources/add', '2', '4', '9');
INSERT INTO `jh_resources_info` VALUES ('10', '删除资源', '/resources/delete', '2', '4', '10');
INSERT INTO `jh_resources_info` VALUES ('11', '分配角色', '/users/saveUserRoles', '2', '2', '11');
INSERT INTO `jh_resources_info` VALUES ('13', '分配权限', '/roles/saveRoleResources', '2', '3', '12');


/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-10-15 14:56:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jh_role_info
-- ----------------------------
DROP TABLE IF EXISTS `jh_role_info`;
CREATE TABLE `jh_role_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleDesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jh_role_info
-- ----------------------------
INSERT INTO `jh_role_info` VALUES ('1', '管理员');
INSERT INTO `jh_role_info` VALUES ('2', '普通用户');
INSERT INTO `jh_role_info` VALUES ('3', '超级管理员');

/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-10-15 14:56:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jh_role_resources
-- ----------------------------
DROP TABLE IF EXISTS `jh_role_resources`;
CREATE TABLE `jh_role_resources` (
  `roleId` int(11) NOT NULL,
  `resourcesId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`resourcesId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jh_role_resources
-- ----------------------------
INSERT INTO `jh_role_resources` VALUES ('1', '2');
INSERT INTO `jh_role_resources` VALUES ('1', '3');
INSERT INTO `jh_role_resources` VALUES ('1', '4');
INSERT INTO `jh_role_resources` VALUES ('1', '5');
INSERT INTO `jh_role_resources` VALUES ('1', '6');
INSERT INTO `jh_role_resources` VALUES ('1', '7');
INSERT INTO `jh_role_resources` VALUES ('1', '8');
INSERT INTO `jh_role_resources` VALUES ('1', '9');
INSERT INTO `jh_role_resources` VALUES ('1', '10');
INSERT INTO `jh_role_resources` VALUES ('1', '11');
INSERT INTO `jh_role_resources` VALUES ('1', '13');
INSERT INTO `jh_role_resources` VALUES ('2', '2');
INSERT INTO `jh_role_resources` VALUES ('2', '3');
INSERT INTO `jh_role_resources` VALUES ('2', '4');
INSERT INTO `jh_role_resources` VALUES ('2', '9');
INSERT INTO `jh_role_resources` VALUES ('3', '2');
INSERT INTO `jh_role_resources` VALUES ('3', '3');
INSERT INTO `jh_role_resources` VALUES ('3', '4');
INSERT INTO `jh_role_resources` VALUES ('3', '5');
INSERT INTO `jh_role_resources` VALUES ('3', '7');
INSERT INTO `jh_role_resources` VALUES ('3', '8');
INSERT INTO `jh_role_resources` VALUES ('3', '9');
INSERT INTO `jh_role_resources` VALUES ('3', '10');
INSERT INTO `jh_role_resources` VALUES ('9', '9');


/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-10-15 14:56:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jh_user_info
-- ----------------------------
DROP TABLE IF EXISTS `jh_user_info`;
CREATE TABLE `jh_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(33) DEFAULT NULL,
  `password` varchar(33) DEFAULT NULL,
  `enable` int(10) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jh_user_info
-- ----------------------------
INSERT INTO `jh_user_info` VALUES ('1', 'admin', '3ef7164d1f6167cb9f2658c07d3c2f0a', '1');
INSERT INTO `jh_user_info` VALUES ('2', 'user1', '90e66e36e3135a91d298177d4389851e', '1');
INSERT INTO `jh_user_info` VALUES ('3', 'user2', '121', '0');
INSERT INTO `jh_user_info` VALUES ('4', 'user3', 'user3', '1');
INSERT INTO `jh_user_info` VALUES ('5', 'user4', 'user4', '1');
INSERT INTO `jh_user_info` VALUES ('6', 'user5', 'user5', '1');
INSERT INTO `jh_user_info` VALUES ('7', 'user6', 'user6', '1');
INSERT INTO `jh_user_info` VALUES ('8', 'user7', 'user7', '1');
INSERT INTO `jh_user_info` VALUES ('9', 'user8', 'user8', '1');
INSERT INTO `jh_user_info` VALUES ('10', 'user9', 'user9', '1');
INSERT INTO `jh_user_info` VALUES ('11', 'user10', 'user10', '1');
INSERT INTO `jh_user_info` VALUES ('12', 'user11', 'user11', '1');
INSERT INTO `jh_user_info` VALUES ('13', 'user12', 'user12', '1');
INSERT INTO `jh_user_info` VALUES ('14', 'user13', 'user13', '1');
INSERT INTO `jh_user_info` VALUES ('15', 'user14', 'user14', '1');
INSERT INTO `jh_user_info` VALUES ('16', 'user15', 'user15', '1');
INSERT INTO `jh_user_info` VALUES ('17', 'user16', 'user16', '1');
INSERT INTO `jh_user_info` VALUES ('18', 'user17', 'user17', '1');
INSERT INTO `jh_user_info` VALUES ('19', 'user18', 'user18', '1');
INSERT INTO `jh_user_info` VALUES ('21', 'user20', 'user20', '1');

/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-10-15 14:56:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jh_user_role
-- ----------------------------
DROP TABLE IF EXISTS `jh_user_role`;
CREATE TABLE `jh_user_role` (
  `userId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jh_user_role
-- ----------------------------
INSERT INTO `jh_user_role` VALUES ('23', '2');
INSERT INTO `jh_user_role` VALUES ('1', '1');
INSERT INTO `jh_user_role` VALUES ('2', '2');
