/*
Navicat MySQL Data Transfer

Source Server         : huishu_local
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : jdcrawler

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2017-02-24 20:25:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_id` varchar(64) NOT NULL COMMENT '图书id',
  `book_name` varchar(128) NOT NULL COMMENT '图书名称',
  `book_price` decimal(10,2) NOT NULL COMMENT '图书价格',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='图书信息表';

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('3', '11461683', 'Python基础教程（第2版 修订版）', '53.00', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('4', '11936238', 'Python核心编程（第3版）', '78.20', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('5', '11352441', '利用Python进行数据分析', '70.30', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('6', '11993134', 'Python编程 从入门到实践', '70.30', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('7', '11963485', '用Python写网络爬虫', '35.50', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('8', '10957017', 'O\'Reilly：深入浅出 Python（中文版）', '53.70', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('9', '10599758', 'O\'Reilly：Python学习手册（第4版）', '94.00', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('10', '11598704', 'Python编程（第4版 套装上下册）', '156.40', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('11', '11896401', 'Python网络数据采集', '46.30', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('12', '11848567', 'Python绝技：运用Python成为顶级黑客', '62.40', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('13', '11572056', '“笨办法”学Python（第3版 附光盘1张）', '38.70', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('14', '10062788', 'Python核心编程（第2版）', '70.30', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('15', '11841674', 'Python算法教程', '54.50', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('16', '11943853', 'Python编程快速上手 让繁琐工作自动化', '54.50', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('17', '12100422', '零起点Python大数据与量化交易', '84.20', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('18', '11821937', 'Python数据分析与挖掘实战', '54.50', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('19', '11666319', '贝叶斯思维 统计建模的Python学习法', '38.70', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('20', '12020697', 'Python机器学习 预测分析核心算法', '58.70', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('21', '11858013', 'Selenium 2自动化测试实战 基于Python语言', '46.60', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('22', '11571426', 'Python自动化运维：技术与最佳实践', '54.50', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('23', '11681561', 'Python Cookbook（第3版）中文版', '85.30', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('24', '12004711', 'Python零基础入门学习-水木书荟', '39.40', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('25', '11748995', 'Python 黑帽子：黑客与渗透测试编程之道', '43.40', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('26', '12099592', 'Python 网络爬虫实战', '50.20', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('27', '11996409', 'Python高效开发实战：Django、Tornado、Flask、Twisted', '70.70', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('28', '11487324', 'Python自然语言处理', '70.30', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('29', '11918059', 'Python科学计算(第2版)（附光盘）', '93.20', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('30', '12033222', 'Python Qt GUI快速编程：PyQt编程指南', '62.40', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('31', '11864820', 'Effective Python：编写高质量Python代码的59个有效方法', '47.30', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('32', '11875736', '跟老齐学Python：从入门到精通', '57.80', '2017-02-15 14:24:09', 'wjc', '2017-02-15 14:24:09', 'wjc');
INSERT INTO `t_book` VALUES ('33', '11985075', 'Java从入门到精通（第4版 附光盘）', '54.90', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('34', '10058164', 'Java编程思想（第4版） JAVA编程思想+算法导论（京东套装共2册） C++ Primer中文版 第5版+Java编程思想 第4版（京东套装共2册）', '71.30', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('35', '12037418', 'Java核心技术 卷I：基础知识（原书第10版）', '94.00', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('36', '11514816', '疯狂Java讲义（第3版 附光盘）', '86.10', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('37', '11252778', '深入理解Java虚拟机：JVM高级特性与最佳实践（第2版） Java高级主题：Java安全编码标准+深入理解Java虚拟机（第2版）（京东套装共2册）', '62.40', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('38', '10100190', 'O\'Reilly：Head First Java（中文版 第2版 涵盖Java5.0）', '54.30', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('39', '11409707', 'Java核心技术（卷2）：高级特性（原书第9版）', '109.80', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('40', '10058902', 'Effective Java中文版（第2版）', '41.00', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('41', '11886254', '数据结构与算法分析：Java语言描述（原书第3版）', '54.50', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('42', '11740734', 'Java并发编程的艺术', '46.60', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('43', '11520670', '深入分析Java Web技术内幕（修订版）', '62.40', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('44', '10922250', '华章专业开发者丛书·Java并发编程实战', '54.50', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('45', '11551720', 'Java程序员面试笔试宝典', '40.30', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('46', '11345721', 'Java核心技术（卷1）：基础知识（原书第9版）', '104.10', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('47', '11449803', '大型网站系统与Java中间件实践', '55.30', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('48', '11701869', 'Java核心技术系列：Java多线程编程核心技术', '54.50', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('49', '11559101', '轻量级Java EE企业应用实战：Struts2+Spring4+Hibernate整合开发（第4版 附CD光盘）', '85.30', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('50', '11078102', '软件开发视频大讲堂：Java从入门到精通（第3版 附光盘）', '47.20', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('51', '11078111', '软件开发视频大讲堂：Java Web从入门到精通（附光盘1张）', '55.10', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('52', '11478491', 'Java基础入门', '35.10', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('53', '10080294', 'Java Web整合开发王者归来（JSP+Servlet+Struts+Hibernate+Spring）（附光盘）', '78.80', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('54', '11741166', 'Java语言程序设计（基础篇 原书第10版）', '67.10', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('55', '11800589', '实战Java高并发程序设计', '57.80', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('56', '11899370', 'Spring实战（第4版）', '70.30', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('57', '11753276', '架构探险：从零开始写Java Web框架', '66.20', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('58', '1069428318', '深入理解JAVA虚拟机 JVM高级特性与最佳实践(第2版) 周志明 计算机与互联网 书籍', '47.30', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('59', '12000164', 'Java RESTful Web Service实战（第2版）', '46.60', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('60', '11965000', 'Java常用算法手册（第3版）（附光盘）', '48.60', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('61', '1027811599', 'Java编程思想(第4版) 教材教辅与参考书计算机与互联网 书籍 从入门到精通 计算机教', '64.60', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('62', '11917790', 'Java 8实战', '61.80', '2017-02-16 14:08:42', 'wjc', '2017-02-16 14:08:42', 'wjc');
INSERT INTO `t_book` VALUES ('63', '10064429', '鸟哥的Linux私房菜 （基础学习篇 第三版） 鸟哥的Linux私房菜（京东套装共2册）', '69.50', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('64', '12010266', 'Linux命令行与shell脚本编程大全（第3版）', '86.10', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('65', '11868199', '循序渐进Linux 第2版 基础知识 服务器搭建 系统管理 性能调优 虚拟化与集群应用', '84.20', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('66', '11018248', '鸟哥的Linux私房菜：服务器架设篇（第三版） 鸟哥的Linux私房菜（京东套装共2册）', '85.30', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('67', '11827284', 'Linux从入门到精通+Linux系统管理与网络管理+Shell从入门到精通+Linux Shell命令行及脚本编程（套装共4册）', '216.40', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('68', '10100237', 'O\'Reilly：深入理解LINUX内核（第3版）（涵盖2.6版）', '69.40', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('69', '10064468', '深入Linux内核架构', '126.70', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('70', '10664953', 'Linux内核设计与实现（原书第3版） Linux内核设计套装（京东套装共2册）', '54.50', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('71', '11891124', '跟老男孩学Linux运维：Web集群实战', '77.50', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('72', '11533366', '高性能Linux服务器构建实战：系统安全、故障排查、自动化运维与集群架构', '63.20', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('73', '1027878190', '鸟哥的Linux私房菜(第3版) 基础学习篇 鸟哥 计算机与互联网 书籍 服务器维护管理', '51.60', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('74', '12025874', 'Linux运维最佳实践', '60.40', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('75', '10064493', 'Linux程序设计（第4版）', '79.90', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('76', '10100144', 'O\'Reilly：LINUX设备驱动程序（第3版）', '54.50', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('77', '11752798', 'Linux设备驱动开发详解：基于最新的Linux 4.0内核', '70.30', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('78', '11354663', 'Linux系统命令及Shell脚本实践指南', '47.20', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('79', '11381298', 'LinuxShell脚本攻略 第2版', '47.60', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('80', '12015988', 'Linux运维之道（第2版）', '59.40', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('81', '11383763', 'Linux UNIX系统编程手册 套装上下册', '124.70', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('82', '11549569', '跟阿铭学Linux', '51.40', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('83', '11003166', 'UNIX/Linux 系统管理技术手册（第4版）', '121.60', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('84', '11397777', 'ARM嵌入式Linux系统开发详解（第2版）', '54.50', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('85', '11196146', 'Linux命令行大全', '55.70', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('86', '11075150', 'Linux命令行与shell脚本编程大全（第2版）', '88.40', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('87', '10062874', '嵌入式Linux应用开发完全手册（附CD光盘1张）', '58.70', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('88', '12099596', 'RHCSA/RHCE 红帽Linux认证学习指南（第7版）EX200 & EX300', '84.80', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('89', '12015632', 'Linux集群和自动化运维', '62.40', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('90', '11492112', 'Linux就是这个范儿', '80.80', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('91', '11243705', 'Linux内核设计的艺术：图解Linux操作系统架构设计与实现原理（第2版） Linux内核设计套装（京东套装共2册） Linux内核精髓：精通Linux内核必会的75个绝技+Linux内核设计的艺术（第2版）（京东套装共2册）', '71.20', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');
INSERT INTO `t_book` VALUES ('92', '10058764', 'Linux内核完全剖析：基于0.12内核', '78.70', '2017-02-16 19:43:18', 'wjc', '2017-02-16 19:43:18', 'wjc');

-- ----------------------------
-- Table structure for t_movie
-- ----------------------------
DROP TABLE IF EXISTS `t_movie`;
CREATE TABLE `t_movie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id，自增1',
  `movie_id` varchar(16) NOT NULL COMMENT '电影id',
  `url` varchar(255) NOT NULL COMMENT '电影url',
  `website` varchar(255) NOT NULL COMMENT '网站名称',
  `is_crawler` int(2) NOT NULL DEFAULT '0' COMMENT '爬虫是否已经抓取过数据，0：否；1：是',
  `title` varchar(64) NOT NULL COMMENT '电影名称',
  `prmovie_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=317 DEFAULT CHARSET=utf8 COMMENT='电影信息表';

-- ----------------------------
-- Records of t_movie
-- ----------------------------
INSERT INTO `t_movie` VALUES ('243', 'mtime10425', 'http://movie.mtime.com/10425/trailer.html', '时光网', '0', '大卫·戈尔的一生', null);
INSERT INTO `t_movie` VALUES ('244', 'mtime10825', 'http://movie.mtime.com/10825/trailer.html', '时光网', '0', '蝴蝶效应', null);
INSERT INTO `t_movie` VALUES ('245', 'mtime10882', 'http://movie.mtime.com/10882/trailer.html', '时光网', '0', '回到未来', null);
INSERT INTO `t_movie` VALUES ('246', 'mtime112197', 'http://movie.mtime.com/112197/trailer.html', '时光网', '0', '后人', null);
INSERT INTO `t_movie` VALUES ('247', 'mtime11271', 'http://movie.mtime.com/11271/trailer.html', '时光网', '0', '玛丽娅·布劳恩的婚姻', null);
INSERT INTO `t_movie` VALUES ('248', 'mtime11319', 'http://movie.mtime.com/11319/trailer.html', '时光网', '0', '美国往事', null);
INSERT INTO `t_movie` VALUES ('249', 'mtime12386', 'http://movie.mtime.com/12386/trailer.html', '时光网', '0', '妖型乐与怒', null);
INSERT INTO `t_movie` VALUES ('250', 'mtime125805', 'http://movie.mtime.com/125805/trailer.html', '时光网', '0', '极限特工：终极回归', null);
INSERT INTO `t_movie` VALUES ('251', 'mtime12631', 'http://movie.mtime.com/12631/trailer.html', '时光网', '0', '芝加哥', null);
INSERT INTO `t_movie` VALUES ('252', 'mtime13620', 'http://movie.mtime.com/13620/trailer.html', '时光网', '0', '喜剧之王', null);
INSERT INTO `t_movie` VALUES ('253', 'mtime147671', 'http://movie.mtime.com/147671/trailer.html', '时光网', '0', '艺术家', null);
INSERT INTO `t_movie` VALUES ('254', 'mtime150559', 'http://movie.mtime.com/150559/trailer.html', '时光网', '0', '逃离德黑兰', null);
INSERT INTO `t_movie` VALUES ('255', 'mtime15505', 'http://movie.mtime.com/15505/trailer.html', '时光网', '0', '新难兄难弟', null);
INSERT INTO `t_movie` VALUES ('256', 'mtime155497', 'http://movie.mtime.com/155497/trailer.html', '时光网', '0', '悲惨世界', null);
INSERT INTO `t_movie` VALUES ('257', 'mtime156390', 'http://movie.mtime.com/156390/trailer.html', '时光网', '0', '为奴十二年', null);
INSERT INTO `t_movie` VALUES ('258', 'mtime156682', 'http://movie.mtime.com/156682/trailer.html', '时光网', '0', '荒野猎人', null);
INSERT INTO `t_movie` VALUES ('259', 'mtime15711', 'http://movie.mtime.com/15711/trailer.html', '时光网', '0', '十月的天空', null);
INSERT INTO `t_movie` VALUES ('260', 'mtime163389', 'http://movie.mtime.com/163389/trailer.html', '时光网', '0', '时空恋旅人', null);
INSERT INTO `t_movie` VALUES ('261', 'mtime164260', 'http://movie.mtime.com/164260/trailer.html', '时光网', '0', '真探', null);
INSERT INTO `t_movie` VALUES ('262', 'mtime168210', 'http://movie.mtime.com/168210/trailer.html', '时光网', '0', '美国骗局', null);
INSERT INTO `t_movie` VALUES ('263', 'mtime17136', 'http://movie.mtime.com/17136/trailer.html', '时光网', '0', '第七封印', null);
INSERT INTO `t_movie` VALUES ('264', 'mtime181292', 'http://movie.mtime.com/181292/trailer.html', '时光网', '0', '布达佩斯大饭店', null);
INSERT INTO `t_movie` VALUES ('265', 'mtime18307', 'http://movie.mtime.com/18307/trailer.html', '时光网', '0', '六尺之下', null);
INSERT INTO `t_movie` VALUES ('266', 'mtime19337', 'http://movie.mtime.com/19337/trailer.html', '时光网', '0', '黑道家族', null);
INSERT INTO `t_movie` VALUES ('267', 'mtime194595', 'http://movie.mtime.com/194595/trailer.html', '时光网', '0', '生化危机：终章', null);
INSERT INTO `t_movie` VALUES ('268', 'mtime200149', 'http://movie.mtime.com/200149/trailer.html', '时光网', '0', '罪夜之奔', null);
INSERT INTO `t_movie` VALUES ('269', 'mtime200591', 'http://movie.mtime.com/200591/trailer.html', '时光网', '0', '刺客信条', null);
INSERT INTO `t_movie` VALUES ('270', 'mtime206966', 'http://movie.mtime.com/206966/trailer.html', '时光网', '0', '冰血暴', null);
INSERT INTO `t_movie` VALUES ('271', 'mtime208325', 'http://movie.mtime.com/208325/trailer.html', '时光网', '0', '西游伏妖篇', null);
INSERT INTO `t_movie` VALUES ('272', 'mtime208911', 'http://movie.mtime.com/208911/trailer.html', '时光网', '0', '罗曼蒂克消亡史', null);
INSERT INTO `t_movie` VALUES ('273', 'mtime209688', 'http://movie.mtime.com/209688/trailer.html', '时光网', '0', '金刚狼3：殊死一战', null);
INSERT INTO `t_movie` VALUES ('274', 'mtime214590', 'http://movie.mtime.com/214590/trailer.html', '时光网', '0', '舌尖上的新年', null);
INSERT INTO `t_movie` VALUES ('275', 'mtime215124', 'http://movie.mtime.com/215124/trailer.html', '时光网', '0', '上海王', null);
INSERT INTO `t_movie` VALUES ('276', 'mtime216036', 'http://movie.mtime.com/216036/trailer.html', '时光网', '0', '火星救援', null);
INSERT INTO `t_movie` VALUES ('277', 'mtime217896', 'http://movie.mtime.com/217896/trailer.html', '时光网', '0', '功夫瑜伽', null);
INSERT INTO `t_movie` VALUES ('278', 'mtime218530', 'http://movie.mtime.com/218530/trailer.html', '时光网', '0', '托尼·厄德曼', null);
INSERT INTO `t_movie` VALUES ('279', 'mtime218873', 'http://movie.mtime.com/218873/trailer.html', '时光网', '0', '她', null);
INSERT INTO `t_movie` VALUES ('280', 'mtime219784', 'http://movie.mtime.com/219784/trailer.html', '时光网', '0', '爱乐之城', null);
INSERT INTO `t_movie` VALUES ('281', 'mtime219939', 'http://movie.mtime.com/219939/trailer.html', '时光网', '0', '美国甜心', null);
INSERT INTO `t_movie` VALUES ('282', 'mtime220307', 'http://movie.mtime.com/220307/trailer.html', '时光网', '0', '雄狮', null);
INSERT INTO `t_movie` VALUES ('283', 'mtime220423', 'http://movie.mtime.com/220423/trailer.html', '时光网', '0', '海边的曼彻斯特', null);
INSERT INTO `t_movie` VALUES ('284', 'mtime220434', 'http://movie.mtime.com/220434/trailer.html', '时光网', '0', '国王的选择', null);
INSERT INTO `t_movie` VALUES ('285', 'mtime224688', 'http://movie.mtime.com/224688/trailer.html', '时光网', '0', '宁静的热情', null);
INSERT INTO `t_movie` VALUES ('286', 'mtime224924', 'http://movie.mtime.com/224924/trailer.html', '时光网', '0', '爱恋', null);
INSERT INTO `t_movie` VALUES ('287', 'mtime225288', 'http://movie.mtime.com/225288/trailer.html', '时光网', '0', '美国犯罪故事', null);
INSERT INTO `t_movie` VALUES ('288', 'mtime226517', 'http://movie.mtime.com/226517/trailer.html', '时光网', '0', '路边野餐', null);
INSERT INTO `t_movie` VALUES ('289', 'mtime228345', 'http://movie.mtime.com/228345/trailer.html', '时光网', '0', '湄公河行动', null);
INSERT INTO `t_movie` VALUES ('290', 'mtime229235', 'http://movie.mtime.com/229235/trailer.html', '时光网', '0', '月光男孩', null);
INSERT INTO `t_movie` VALUES ('291', 'mtime229728', 'http://movie.mtime.com/229728/trailer.html', '时光网', '0', '欢乐好声音', null);
INSERT INTO `t_movie` VALUES ('292', 'mtime230049', 'http://movie.mtime.com/230049/trailer.html', '时光网', '0', '地下', null);
INSERT INTO `t_movie` VALUES ('293', 'mtime230149', 'http://movie.mtime.com/230149/trailer.html', '时光网', '0', '公正裁决', null);
INSERT INTO `t_movie` VALUES ('294', 'mtime230201', 'http://movie.mtime.com/230201/trailer.html', '时光网', '0', '帕特森', null);
INSERT INTO `t_movie` VALUES ('295', 'mtime230245', 'http://movie.mtime.com/230245/trailer.html', '时光网', '0', '推销员', null);
INSERT INTO `t_movie` VALUES ('296', 'mtime230379', 'http://movie.mtime.com/230379/trailer.html', '时光网', '0', '否认', null);
INSERT INTO `t_movie` VALUES ('297', 'mtime230858', 'http://movie.mtime.com/230858/trailer.html', '时光网', '0', '卡推女王 ', null);
INSERT INTO `t_movie` VALUES ('298', 'mtime231218', 'http://movie.mtime.com/231218/trailer.html', '时光网', '0', '你会在那里吗？', null);
INSERT INTO `t_movie` VALUES ('299', 'mtime233521', 'http://movie.mtime.com/233521/trailer.html', '时光网', '0', '王者', null);
INSERT INTO `t_movie` VALUES ('300', 'mtime234954', 'http://movie.mtime.com/234954/trailer.html', '时光网', '0', '完美有多美', null);
INSERT INTO `t_movie` VALUES ('301', 'mtime235639', 'http://movie.mtime.com/235639/trailer.html', '时光网', '0', '成长边缘', null);
INSERT INTO `t_movie` VALUES ('302', 'mtime236067', 'http://movie.mtime.com/236067/trailer.html', '时光网', '0', '更美好的事', null);
INSERT INTO `t_movie` VALUES ('303', 'mtime236407', 'http://movie.mtime.com/236407/trailer.html', '时光网', '0', '伦敦生活', null);
INSERT INTO `t_movie` VALUES ('304', 'mtime236741', 'http://movie.mtime.com/236741/trailer.html', '时光网', '0', '驴得水', null);
INSERT INTO `t_movie` VALUES ('305', 'mtime237610', 'http://movie.mtime.com/237610/trailer.html', '时光网', '0', '生门', null);
INSERT INTO `t_movie` VALUES ('306', 'mtime237777', 'http://movie.mtime.com/237777/trailer.html', '时光网', '0', '三枪隐情', null);
INSERT INTO `t_movie` VALUES ('307', 'mtime240427', 'http://movie.mtime.com/240427/trailer.html', '时光网', '0', '金融决战', null);
INSERT INTO `t_movie` VALUES ('308', 'mtime24195', 'http://movie.mtime.com/24195/trailer.html', '时光网', '0', '双峰', null);
INSERT INTO `t_movie` VALUES ('309', 'mtime31431', 'http://movie.mtime.com/31431/trailer.html', '时光网', '0', '吉屋出租', null);
INSERT INTO `t_movie` VALUES ('310', 'mtime50695', 'http://movie.mtime.com/50695/trailer.html', '时光网', '0', '理发师陶德', null);
INSERT INTO `t_movie` VALUES ('311', 'mtime51503', 'http://movie.mtime.com/51503/trailer.html', '时光网', '0', '沉默', null);
INSERT INTO `t_movie` VALUES ('312', 'mtime62087', 'http://movie.mtime.com/62087/trailer.html', '时光网', '0', '时间旅行者的妻子', null);
INSERT INTO `t_movie` VALUES ('313', 'mtime67531', 'http://movie.mtime.com/67531/trailer.html', '时光网', '0', '广告狂人', null);
INSERT INTO `t_movie` VALUES ('314', 'mtime70362', 'http://movie.mtime.com/70362/trailer.html', '时光网', '0', '西部世界', null);
INSERT INTO `t_movie` VALUES ('315', 'mtime78590', 'http://movie.mtime.com/78590/trailer.html', '时光网', '0', '少年时代', null);
INSERT INTO `t_movie` VALUES ('316', 'mtime91873', 'http://movie.mtime.com/91873/trailer.html', '时光网', '0', '源代码', null);

-- ----------------------------
-- Table structure for t_movie_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_movie_comment`;
CREATE TABLE `t_movie_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增1',
  `comment_id` varchar(16) NOT NULL COMMENT '电影评论id',
  `prmoveid` varchar(16) NOT NULL COMMENT '电影预告片id',
  `comment` varchar(255) DEFAULT NULL COMMENT '电影评论',
  `time` varchar(32) NOT NULL COMMENT '评论时间',
  `yes_no` varchar(10) DEFAULT NULL,
  `prmovie_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电影评论信息表';

-- ----------------------------
-- Records of t_movie_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_movie_url
-- ----------------------------
DROP TABLE IF EXISTS `t_movie_url`;
CREATE TABLE `t_movie_url` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id，自增1',
  `prmovie_id` varchar(16) NOT NULL COMMENT '电影预告片id',
  `movie_id` varchar(16) NOT NULL COMMENT '电影id',
  `url` varchar(255) NOT NULL COMMENT '电影预告片url',
  `title` varchar(64) NOT NULL COMMENT '电影名称',
  `is_crawler` int(2) DEFAULT '0' COMMENT '爬虫是否已经抓取过数据，0：否；1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电影预告片信息表';

-- ----------------------------
-- Records of t_movie_url
-- ----------------------------
