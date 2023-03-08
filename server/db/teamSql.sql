-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.31 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 yxw 的数据库结构
CREATE DATABASE IF NOT EXISTS `yxw` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `yxw`;

-- 导出  表 yxw.education 结构
CREATE TABLE IF NOT EXISTS `education` (
  `id` int NOT NULL AUTO_INCREMENT,
  `time` varchar(255) NOT NULL DEFAULT '',
  `experience` varchar(255) NOT NULL DEFAULT '',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.education 的数据：~0 rows (大约)
DELETE FROM `education`;
INSERT INTO `education` (`id`, `time`, `experience`) VALUES
	(1, '2022-2023', 'aa'),
	(2, '2018-1290', 'bb');

-- 导出  表 yxw.member 结构
CREATE TABLE IF NOT EXISTS `member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `job` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '单位职务',
  `pageUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '主页url',
  `research` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '研究方向',
  `resume` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '简历',
  `society` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '社会服务',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '办公地址',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '电子邮件',
  `m_class` enum('teacher','master','doctor','graduate') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'teacher' COMMENT '类别  ',
  `prize` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '个人荣誉',
  `edu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '学历和头衔（博士，教授，博士研究生）',
  `pictureUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `m_p` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.member 的数据：~1 rows (大约)
DELETE FROM `member`;
INSERT INTO `member` (`id`, `name`, `job`, `pageUrl`, `research`, `resume`, `society`, `address`, `email`, `m_class`, `prize`, `edu`, `pictureUrl`) VALUES
	(1, '姚信威', '计算机科学与技术学院、软件学院', 'http://www.homepage.zjut.edu.cn/yxw/', '智能物联网、群智感知与协同、泛化人工智能', '姚信威，博士，1986年5月生，浙江诸暨人，现任浙江工业大学计算机科学与技术学院教授、博士生导师，浙江工业大学前沿交叉科学研究院副院长、浙江省杰青。分别于2008年和2013年在浙江工业大学机械学院和计算机科学与技术学院获得学士、博士学位，并获得浙江省优秀毕业生、浙江工业大学优秀博士学位论文。2012年至2013年，受浙江省“信息技术与处理”重中之重学科资助赴英国拉夫堡大学计算机系进行联合培养。2014年入选浙江工业大学首批“校聘副教授”和浙江工业大学“青年学术骨干海外培养计划”，于2015年至2016年作为访问教授赴美国纽约州立大学布法罗分校电子工程系进行学术访问。\r\n\r\n2016年入选浙江工业大学“优秀青年教师（青年英才支持计划）”。2020年6月入选杭州市十大青年科技英才（二年一届），2020年7月入选浙江省高校领军人才培养计划（5246人才工程）。2020年9月入选2020年度杭州市钱江特聘专家。2020年12月入选杭州市2020年度创新创业人物（仅四位）。2021年4月入选科创之江百人会ZAIL100青年委员（全省共7个青年委员）。2022年11月入选“科创中国”之江青年百人会。2022年11月获得浙江省杰出青年科学基金项目。\r\n\r\n担任中国人工智能学会自然计算与数字智能城市专委会常务副秘书长、浙江省（浙工大）国防科技成果转化中心主任、浙江省人工智能领域JMRH协同创新中心常务副主任、浙江省数字经济联合会副会长兼青年专家工作委员会主任、杭州市计算机学会执行秘书长、浙江省人工智能产业技术联盟副秘书长、浙江省公共政策研究院研究员、《中国制造与一带一路倡议》咨询项目组专家、中国智能制造百人会专家委员会委员、浙江卫视《今日评说》特约评论员、浙江省计算机学会人工智能专委会委员、杭州市计算机学会人工智能专委会委员、杭州市人工智能学会理事、国家自然科学基金委信息学部基金评议专家、浙江省科技专家库专家。\r\n\r\n主要研究领域为智能物联网、群智感知与协同、智能机器人等基础理论、核心技术及其综合解决方案，科研成果获全国吴文俊人工智能优秀青年奖（浙江省首位获奖人）、吴文俊人工智能科技进步一等奖、技术发明二等奖、浙江省技术发明二等奖、中国煤炭工业协会科学技术二等奖等7个省部级奖项，发表学术论文80多篇，包括IEEE TMC、IEEE TNNLS、IEEE IoT-J、IEEE TCAD等TOP期刊论文30多篇，1篇论文为期刊高被引论文，出版英文专著3部、3个章节，出版中文著作1部。获得授权国家发明专利20余项，软件著作权10多项。主持国家自然科学基金（青年项目、面上项目）、浙江省杰出青年科学基金、浙江省“尖兵”“领雁”项目、浙江省“揭榜挂帅”重大企业委托项目等30多个科研项目。担任多个国际期刊的编辑或客座编辑，多个国际会议主席或委员会委员；担任50多个国际顶级学术刊物审稿人和国际学术会议审稿人。同时，主持多个“智慧物联网综合平台”和“智能机器人系统”等重大横向项目，并成功应用于国家电网、杭州城市大脑、未来社区等实际场景中，产生重大经济效益和社会价值。', '浙江省数字经济联合会副会长，2019.12——至今；\r\n\r\n中国智能制造百人会专家委员，2019.01——至今；\r\n\r\n浙江省数字经济联合会数字经济青年专家委员会主任，2020.01——至今；\r\n\r\n浙江省人工智能产业技术联盟副秘书长，2020.12——至今；\r\n\r\n浙江省公共政策研究院研究员，2019.10——2022.10；', '计算机大楼B419', 'xwyao@zjut.edu.cn', 'teacher', '浙江省杰出青年科学基金，2022.11；\r\n\r\n杭州市十大青年科技英才，杭州市人才办/杭州市委组织部，2020.06；\r\n\r\n浙江省高校领军人才培养计划（“5246人才工程”）青年优秀人才，浙江省教育厅，2020.07；\r\n\r\n杭州市钱江特聘专家，杭州市人社局，2020.09；\r\n\r\n科创之江百人会ZAIL100青年委员（浙江省共7名青年委员），浙江省科协、浙江省委组织部、浙江省人社厅，2021.04；\r\n“科创中国”之江青年百人会会员，浙江省科学技术协会，2022.11；\r\n\r\n中国人工智能学会2020年度优秀会员，中国人工智能学会，2021.02；\r\n\r\n杭州市2020年度创新创业人物（2020杭州创业行业点评和改革传播活动十大现象），2020.12；', '博士 教授 博士生导师', 'server/src/main/resources/static/picture/d44caa60-2082-43b3-84e8-f72472c4ab98_s.jpg');

-- 导出  表 yxw.member_education_map 结构
CREATE TABLE IF NOT EXISTS `member_education_map` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_id` int NOT NULL DEFAULT '0',
  `education_id` int NOT NULL DEFAULT '0',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.member_education_map 的数据：~0 rows (大约)
DELETE FROM `member_education_map`;
INSERT INTO `member_education_map` (`id`, `member_id`, `education_id`) VALUES
	(1, 1, 1),
	(2, 1, 2);

-- 导出  表 yxw.member_paper_map 结构
CREATE TABLE IF NOT EXISTS `member_paper_map` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_id` int NOT NULL DEFAULT '0',
  `paper_id` int NOT NULL DEFAULT '0',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.member_paper_map 的数据：~0 rows (大约)
DELETE FROM `member_paper_map`;
INSERT INTO `member_paper_map` (`id`, `member_id`, `paper_id`) VALUES
	(1, 1, 1),
	(2, 1, 2);

-- 导出  表 yxw.outcome 结构
CREATE TABLE IF NOT EXISTS `outcome` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '作者',
  `date` char(50) NOT NULL DEFAULT '' COMMENT '时间',
  `perio` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '期刊',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '链接',
  `proposer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '申请人',
  `inventor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '发明人',
  `authorization` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '授权人',
  `pub` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '出版社',
  `pictureUrl` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '图片地址',
  `pClass` enum('论文','专利','专著') NOT NULL DEFAULT '论文' COMMENT '0 论文 1专利 2 专著',
  `fileUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.outcome 的数据：~9 rows (大约)
DELETE FROM `outcome`;
INSERT INTO `outcome` (`id`, `title`, `author`, `date`, `perio`, `url`, `proposer`, `inventor`, `authorization`, `pub`, `pictureUrl`, `pClass`, `fileUrl`) VALUES
	(1001, 'DRL-Based Offloading for Computation Delay Minimization in Wireless-Powered Multi-access Edge Computing”, IEEE Transactions on Communications, 2023, (to appear)', 'K.-C. Zheng, X.-Y. Liu, K.-K. Chi, X.-W. Yao', '2023-01-31', ' IEEE Transactions on Co', 'https://ieeexplore.ieee.org/abstract/document/10019272', ' ', ' ', ' ', ' ', ' ', '', ' '),
	(1002, '专利1', '张恒聪', '2023-03-07', ' ', ' ', '', '张恒聪', '张恒聪', ' ', ' ', '论文', ' '),
	(1003, '电磁纳米网络-基础理论及关键技术\r\n', '姚信威', '2021-01-01', ' ', ' ', '', '', '', '科学出版社', ' ', '专利', ' '),
	(1004, '未来服务——生活服务业的科技化变革\r\n', '姚信威', '2021-01-01', ' ', ' ', ' ', ' ', ' ', '浙江科学技术出版社', ' ', '专利', ' '),
	(1005, '智能解密：智能+场景应用案例解析\r\n', '姚信威', '2021-04-01', ' ', ' ', ' ', ' ', ' ', '电子工业出版社', ' ', '专利', ' '),
	(1006, 'Prime Archives in Sensors\r\n', '姚信威', '2020-10-01', ' ', ' ', ' ', ' ', ' ', 'Vide Leaf\r\n', ' ', '专利', ' '),
	(1007, 'Nano-Electromagnetic Communication at Terahertz: Principles and applications\r\n', '姚信威', '2020-11-01', '  ', ' ', ' ', ' ', ' ', 'IET Institution of Engineering and Technology\r\n', ' ', '专利', ' '),
	(1008, 'FGOR: Flow-Guided Opportunistic Routing for Intra-body Nanonetworks, IEEE Internet of Things Journal, 2022, DOI: 10.1109/JIOT.20 22. 3182142(中科院1区，JCR Q1区，IF：9.471）\r\n', 'Yao, X. W., Chen, Y. W., Wu, Y., Zhao, K., & Jornet, J. M.', '2022-09-21', ' IEEE Internet of Things Journal', 'https://ieeexplore.ieee.org/abstract/document/9795691', ' ', ' ', ' ', ' ', ' ', '专著', ' '),
	(1009, 'Joint Optimization of Latency and Energy Consumption for Mobile Edge Computing Based Proximity Detection in Road Networks”, China Communications, 2022, \r\n', 'Zhao, T., Liu, Y., Shou, G., & Yao, X', '2022-04-19', ' China Communications', 'https://ieeexplore.ieee.org/abstract/document/9762679', ' ', ' ', ' ', ' ', ' ', '专著', ' ');

-- 导出  表 yxw.paper 结构
CREATE TABLE IF NOT EXISTS `paper` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.paper 的数据：~0 rows (大约)
DELETE FROM `paper`;
INSERT INTO `paper` (`id`, `name`) VALUES
	(1, 'aaaa'),
	(2, 'bbb');

-- 导出  表 yxw.relation 结构
CREATE TABLE IF NOT EXISTS `relation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `pictureUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.relation 的数据：~1 rows (大约)
DELETE FROM `relation`;
INSERT INTO `relation` (`id`, `email`, `address`, `phone`, `pictureUrl`) VALUES
	(1, 'xwyao@zjut.edu.cn', '浙江工业大学(屏峰校区)，浙江省杭州市西湖区留和路288号', '123456789', ' ');

-- 导出  表 yxw.report 结构
CREATE TABLE IF NOT EXISTS `report` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `date` char(50) NOT NULL DEFAULT '',
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `r_class` enum('通知','动态','媒体','咨询') NOT NULL DEFAULT '通知' COMMENT '0通知 1动态 2媒体 3 咨询 4相关学术会议',
  `url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `picture_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.report 的数据：~2 rows (大约)
DELETE FROM `report`;
INSERT INTO `report` (`id`, `title`, `date`, `text`, `r_class`, `url`, `picture_url`) VALUES
	(1, '浙工大姚信威博士荣获“杭州市十大青年科技英才”称号！16年的梦想与坚持终会绽放！', '2020-06-22', '每一个80后都曾有过成为科学家的梦想，姚信威也不例外。《变形金刚》《哆啦a梦》，这些耳熟能详的动画是他童年的美好回忆，也在他心里种下了一个研究“机器人”的梦想。在这一梦想的驱动下，2004年， 18岁的姚信威考入了浙江工业大学机电工程学院（现机械工程学院）。\r\n\r\n图书馆、实验室，四年的光阴，姚信威的大部分课余时间都花在这两个地方，并且努力学习学科相关知识。大二那年，姚信威主动联系了学院老师加入科研团队。当年，他几乎把所有的课余时间花在了实验室里，学习相关的知识与操作。即使是一些杂活和整理工作，他也一丝不苟地完成并且乐在其中。当时认真负责的工作精神，也为日后姚信威博士带领团队攀登技术高峰打下了牢固的基础。', '通知', 'https://www.sohu.com/a/403540901_286785', 'server/src/main/resources/static/picture/b231c90a9a8543f387a7b4c1d7733a88.jpeg'),
	(2, '张恒聪获得硕士学位', '2022-09-01', '恭喜恭喜', '媒体', ' ', 'server/src/main/resources/static/picture/微信图片_20230305170123.png'),
	(3, '11', '2022-01-01', 'aaaa', '动态', 'https://www.sohu.com/a/403540901_286785', 'server/src/main/resources/static/picture/b231c90a9a8543f387a7b4c1d7733a88.jpeg');

-- 导出  表 yxw.textbox 结构
CREATE TABLE IF NOT EXISTS `textbox` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `fileUrl` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '文件地址',
  `tClass` enum('数据集','仿真工具','科研平台','课程教学','团队简介','在研项目','科研方向','联系方式') NOT NULL DEFAULT '数据集' COMMENT '0数据集 1 仿真工具 2科研平台 3课程教学 4团队简介 5在研项目 7科研方向 8联系方式',
  `pictureUrl` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `sDate` char(50) NOT NULL DEFAULT '',
  `eDate` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1031 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.textbox 的数据：~28 rows (大约)
DELETE FROM `textbox`;
INSERT INTO `textbox` (`id`, `title`, `text`, `fileUrl`, `tClass`, `pictureUrl`, `sDate`, `eDate`) VALUES
	(1001, '数据集1', '简介', 'server/src/main/resources/static/file/b.csv', '', '', '2023-03-05', '2023-03-07'),
	(1002, '仿真平台1', '简介', 'server/src/main/resources/static/file/aaaa.pdf', '数据集', NULL, '2023-03-05', '2023-03-07'),
	(1003, '浙工大九阳智慧家电重点实验室', '简介。。。', ' ', '仿真工具', 'server/src/main/resources/static/picture/微信图片_20230305170123.png', '2023-03-07', '2023-03-07'),
	(1004, '主讲：《人工智能导论》、《Principles of Computer Networks》（《计算机网络原理》留学生）、《计算机网络原理》、《无线传感器网络》《人工智能及其应用》、《Principles and Design of Wireless Sensor Networks》', '教育部2018年第一批产学合作协同育人项目，“基于Python的程序设计课程教学改革”，2019.02-2020.02，项目负责人，排名：1/4；\r\n\r\n浙江工业大学校级教学改革项目，“物联网工程专业国际化人才培养模式的创新与实践”，2015.08-2016.12，项目负责人，排名1/6；\r\n\r\n2018全国高校计算机教育大会优秀论文奖，“面向国际化人才培养的物联网工程专业课程体系改革探索-以浙江工业大学为例”，2018.04，教育部高等学校计算机类专业教学指导委员会，排名：1/4；浙江省“十四五”研究生课程思政示范课程，“人工智能及其应用”，2022.12，项目负责人，1/6；\r\n\r\n浙江工业大学校级研究生核心课程建设项目，“人工智能及其应用”，2022.11-2023.12，项目负责人，1/4；', ' ', '科研平台', NULL, '2023-03-07', '2023-03-07'),
	(1005, '团队简介', '主要研究领域为智能物联网、群智感知与协同、智能机器人等基础理论、核心技术及其综合解决方案，科研成果获全国吴文俊人工智能优秀青年奖（浙江省首位获奖人）、吴文俊人工智能科技进步一等奖、技术发明二等奖、浙江省技术发明二等奖、中国煤炭工业协会科学技术二等奖等7个省部级奖项，发表学术论文80多篇，包括IEEE TMC、IEEE TNNLS、IEEE IoT-J、IEEE TCAD等TOP期刊论文30多篇，1篇论文为期刊高被引论文，出版英文专著3部、3个章节，出版中文著作1部。获得授权国家发明专利20余项，软件著作权10多项。主持国家自然科学基金（青年项目、面上项目）、浙江省杰出青年科学基金、浙江省“尖兵”“领雁”项目、浙江省“揭榜挂帅”重大企业委托项目等30多个科研项目。担任多个国际期刊的编辑或客座编辑，多个国际会议主席或委员会委员；担任50多个国际顶级学术刊物审稿人和国际学术会议审稿人。同时，主持多个“智慧物联网综合平台”和“智能机器人系统”等重大横向项目，并成功应用于国家电网、杭州城市大脑、未来社区等实际场景中，产生重大经济效益和社会价值。\r\n\r\n', ' ', '课程教学', 'server/src/main/resources/static/picture/微信图片_20230305170123.png', '2023-03-07', '2023-03-07'),
	(1006, '浙江省杰出青年科学基金项目，“面向人体移动纳米物联网的通信建模及协议设计”，排名：1/1；', NULL, ' ', '团队简介', NULL, '2023-01-01', '2025-12-31'),
	(1008, '泛化人工智能', '智能物联网、群智感知与协同、泛化人工智能', ' ', '科研方向', NULL, '2023-03-07', '2023-03-07'),
	(1010, '浙江省重点研发“领雁”计划项目，“低碳运输碳排放智能感知与协同控制关键技术研究与应用示范”，排名：2/10；', NULL, ' ', '团队简介', NULL, '2023-01-01', '2025-12-29'),
	(1011, '杭州市人工智能领域JMRH发展路径研究', NULL, ' ', '团队简介', NULL, '2021-09-01', '2021-12-31'),
	(1012, '纳米传感网通信建模及跨层协议优化设计（61772471）', NULL, ' ', '团队简介', NULL, '2018-01-01', '2021-12-31'),
	(1013, '物联网中无线能量传输关键技术研发（2015C31007）', NULL, ' ', '团队简介', NULL, '2015-07-01', '2017-06-30'),
	(1014, '纳米传感网中太赫兹通信机制研究（61402414）', NULL, ' ', '团队简介', NULL, '2015-01-01', '2017-12-31'),
	(1015, '混杂多传感网协调通信层次结构建模与多级优化方法（61379123）', NULL, ' ', '团队简介', NULL, '2014-01-01', '2017-12-31'),
	(1016, '基于太赫兹频段的纳米通信技术（Y201431815）', NULL, ' ', '团队简介', NULL, '2014-06-01', '2016-05-01'),
	(1017, '智慧社区全域平台统一应用引擎UAE', NULL, ' ', '团队简介', NULL, '2020-06-01', '2023-05-30'),
	(1018, '智能网联——车路协同项目', NULL, ' ', '团队简介', NULL, '2022-10-01', '2022-12-31'),
	(1019, '圣奥智能办公物联网平台设计与研发', NULL, ' ', '团队简介', NULL, '2019-08-01', '2021-12-01'),
	(1020, '城市废弃物综合管理服务平台研发与设计', NULL, ' ', '团队简介', NULL, '2019-04-01', '2021-01-01'),
	(1021, '移动巡检操作机器人系统设计与研发', NULL, ' ', '团队简介', NULL, '2019-02-01', '2022-12-01'),
	(1022, '2020浙江省人工智能产业发展报告', NULL, ' ', '团队简介', NULL, '2021-01-01', '2021-05-01'),
	(1023, '通用型数据采集整编分析软件', NULL, ' ', '团队简介', ' ', '2019-10-01', '2021-11-01'),
	(1024, 'JMRH发展‘十四五’规划子课题——人工智能领域JMRH发展走在前列研究', NULL, ' ', '团队简介', ' ', '2020-07-01', '2020-12-01'),
	(1025, '新时代生活服务科技化发展趋势研究及规划', NULL, ' ', '团队简介', ' ', '2019-12-01', '2020-05-01'),
	(1026, '融物联网一体化平台关键技术研发', NULL, ' ', '团队简介', ' ', '2019-10-01', '2020-10-01'),
	(1027, '基于指纹仪的生物特征提取技术研究', NULL, ' ', '团队简介', ' ', '2018-10-01', '2018-12-01'),
	(1028, '无锡电力物资仓库盘点机器人盘点软件', NULL, ' ', '团队简介', ' ', '2018-10-01', '2019-05-01'),
	(1029, '园区信息可视化管理系统', NULL, ' ', '团队简介', ' ', '2018-06-01', '2018-12-01'),
	(1030, '丽水智能电缆盖板控制系统设计', NULL, ' ', '团队简介', ' ', '2017-08-01', '2018-07-01');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
