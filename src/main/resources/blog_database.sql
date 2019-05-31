/*
Navicat MariaDB Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : 192.168.131.153:3306
Source Database       : blog_database

Target Server Type    : MariaDB
Target Server Version : 50560
File Encoding         : 65001

Date: 2019-04-25 16:07:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_aiticle
-- ----------------------------
DROP TABLE IF EXISTS `blog_aiticle`;
CREATE TABLE `blog_aiticle` (
  `article_id` varchar(32) NOT NULL DEFAULT '' COMMENT '文章id 唯一标识',
  `article_tile` varchar(200) DEFAULT NULL COMMENT '文章标题',
  `category` varchar(200) DEFAULT NULL COMMENT '分类',
  `tags` varchar(200) DEFAULT NULL COMMENT '标签逗号分隔',
  `slug` int(24) DEFAULT NULL COMMENT '文章url',
  `contents` text,
  `status` varchar(16) DEFAULT NULL COMMENT '文章状态（publish:发布；save:保存草稿）',
  `thumbImg` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `allow_comments` char(1) DEFAULT NULL COMMENT '允许评论留言（Y.是；N.否）',
  `allow_imgs` char(1) DEFAULT NULL COMMENT '允许附件（Y.是；N.否）',
  `type` varchar(16) DEFAULT NULL COMMENT '文章类型（origin:原创；reprint:转载）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(32) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_aiticle
-- ----------------------------

-- ----------------------------
-- Table structure for blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment` (
  `comment_id` varchar(32) NOT NULL,
  `article_id` varchar(32) DEFAULT NULL COMMENT '评论所属文章',
  `name` varchar(255) DEFAULT NULL COMMENT '留言评论者名称',
  `email` varchar(255) DEFAULT NULL COMMENT '留言者邮箱',
  `content` text,
  `type` varchar(16) DEFAULT NULL COMMENT '类型',
  `author_id` varchar(32) DEFAULT NULL COMMENT '备用（作者id）',
  `parent_comment_id` varchar(32) DEFAULT NULL COMMENT '父类评论id',
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_comment
-- ----------------------------

-- ----------------------------
-- Table structure for blog_file
-- ----------------------------
DROP TABLE IF EXISTS `blog_file`;
CREATE TABLE `blog_file` (
  `file_id` varchar(32) NOT NULL,
  `file_name` varchar(32) DEFAULT NULL COMMENT '上传后的文件名称',
  `origin_name` varchar(200) DEFAULT NULL COMMENT '原文件名称',
  `file_path` varchar(200) DEFAULT NULL COMMENT '文件路径',
  `file_suffix` char(6) DEFAULT NULL,
  `file_size` varchar(20) DEFAULT NULL COMMENT '文件大小',
  `file_md5` varchar(32) DEFAULT NULL COMMENT '文件MD5 备用',
  `uploader` varchar(32) DEFAULT NULL COMMENT '上传者',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_file
-- ----------------------------

-- ----------------------------
-- Table structure for blog_log
-- ----------------------------
DROP TABLE IF EXISTS `blog_log`;
CREATE TABLE `blog_log` (
  `log_id` varchar(32) NOT NULL COMMENT '日志id',
  `ip` varchar(200) DEFAULT NULL COMMENT '操作ip',
  `action` varchar(32) DEFAULT NULL COMMENT '操作类型（login;logout;）',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `operater` varchar(32) DEFAULT NULL COMMENT '操作人',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_log
-- ----------------------------

-- ----------------------------
-- Table structure for blog_metas
-- ----------------------------
DROP TABLE IF EXISTS `blog_metas`;
CREATE TABLE `blog_metas` (
  `cid` varchar(32) NOT NULL COMMENT '分类标签id',
  `name` varchar(64) NOT NULL COMMENT '分类名称，标签名称',
  `type` char(5) NOT NULL COMMENT '类别（tag:标签；category:分类）',
  `description` varchar(255) DEFAULT NULL,
  `sort` int(11) unsigned zerofill DEFAULT NULL COMMENT '排序',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父标签分类id',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_metas
-- ----------------------------

-- ----------------------------
-- Table structure for blog_place_on_file
-- ----------------------------
DROP TABLE IF EXISTS `blog_place_on_file`;
CREATE TABLE `blog_place_on_file` (
  `fid` varchar(32) NOT NULL,
  `name` varchar(16) DEFAULT NULL COMMENT '月份',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_place_on_file
-- ----------------------------

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `user_uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户id 唯一标识',
  `user_account` varchar(24) NOT NULL DEFAULT '' COMMENT '用户登录账号（最长24个字符）',
  `password` varchar(24) NOT NULL COMMENT '密码（MD5双层加密）',
  `user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名称（最长八个字）',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `sex` int(1) DEFAULT NULL COMMENT '性别（0.男，1.女）',
  `enable` char(1) DEFAULT NULL COMMENT '逻辑删除（Y.有效；N.失效）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_pwd_time` datetime DEFAULT NULL COMMENT '最后一次更新密码时间',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(32) DEFAULT NULL COMMENT ' 创建人',
  PRIMARY KEY (`user_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_user
-- ----------------------------
