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

-- 导出  表 yxw.course 结构
CREATE TABLE IF NOT EXISTS `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `courseName` text,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.course 的数据：~0 rows (大约)
DELETE FROM `course`;
INSERT INTO `course` (`id`, `courseName`) VALUES
	(1, '教育部2018年第一批产学合作协同育人项目，“基于Python的程序设计课程教学改革”，2019.02-2020.02，项目负责人，排名：1/4'),
	(2, '浙江工业大学校级教学改革项目，“物联网工程专业国际化人才培养模式的创新与实践”，2015.08-2016.12，项目负责人，排名1/6；'),
	(3, '2018全国高校计算机教育大会优秀论文奖，“面向国际化人才培养的物联网工程专业课程体系改革探索-以浙江工业大学为例”，2018.04，教育部高等学校计算机类专业教学指导委员会，排名：1/4；');

-- 导出  表 yxw.course_textbox_map 结构
CREATE TABLE IF NOT EXISTS `course_textbox_map` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int DEFAULT NULL,
  `textbox_id` int DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.course_textbox_map 的数据：~0 rows (大约)
DELETE FROM `course_textbox_map`;
INSERT INTO `course_textbox_map` (`id`, `course_id`, `textbox_id`) VALUES
	(1, 1, 1005),
	(2, 2, 1005);

-- 导出  表 yxw.education 结构
CREATE TABLE IF NOT EXISTS `education` (
  `id` int NOT NULL AUTO_INCREMENT,
  `time` varchar(255) NOT NULL DEFAULT '',
  `experience` varchar(255) NOT NULL DEFAULT '',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.education 的数据：~2 rows (大约)
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
  `resume` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '简历',
  `society` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '社会服务',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '办公地址',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '电子邮件',
  `m_class` enum('teacher','master','doctor','graduate') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'teacher' COMMENT '类别  ',
  `prize` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '个人荣誉',
  `edu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '学历和头衔（博士，教授，博士研究生）',
  `pictureUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `m_p` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.member 的数据：~37 rows (大约)
DELETE FROM `member`;
INSERT INTO `member` (`id`, `name`, `job`, `pageUrl`, `research`, `resume`, `society`, `address`, `email`, `m_class`, `prize`, `edu`, `pictureUrl`) VALUES
	(1, '姚信威', '计算机科学与技术学院、软件学院', 'http://www.homepage.zjut.edu.cn/yxw/', '智能物联网、群智感知与协同、泛化人工智能', '姚信威，博士，1986年5月生，浙江诸暨人，现任浙江工业大学计算机科学与技术学院教授、博士生导师，浙江工业大学前沿交叉科学研究院副院长、浙江省杰青。分别于2008年和2013年在浙江工业大学机械学院和计算机科学与技术学院获得学士、博士学位，并获得浙江省优秀毕业生、浙江工业大学优秀博士学位论文。2012年至2013年，受浙江省“信息技术与处理”重中之重学科资助赴英国拉夫堡大学计算机系进行联合培养。2014年入选浙江工业大学首批“校聘副教授”和浙江工业大学“青年学术骨干海外培养计划”，于2015年至2016年作为访问教授赴美国纽约州立大学布法罗分校电子工程系进行学术访问。\r\n\r\n2016年入选浙江工业大学“优秀青年教师（青年英才支持计划）”。2020年6月入选杭州市十大青年科技英才（二年一届），2020年7月入选浙江省高校领军人才培养计划（5246人才工程）。2020年9月入选2020年度杭州市钱江特聘专家。2020年12月入选杭州市2020年度创新创业人物（仅四位）。2021年4月入选科创之江百人会ZAIL100青年委员（全省共7个青年委员）。2022年11月入选“科创中国”之江青年百人会。2022年11月获得浙江省杰出青年科学基金项目。\r\n\r\n担任中国人工智能学会自然计算与数字智能城市专委会常务副秘书长、浙江省（浙工大）国防科技成果转化中心主任、浙江省人工智能领域JMRH协同创新中心常务副主任、浙江省数字经济联合会副会长兼青年专家工作委员会主任、杭州市计算机学会执行秘书长、浙江省人工智能产业技术联盟副秘书长、浙江省公共政策研究院研究员、《中国制造与一带一路倡议》咨询项目组专家、中国智能制造百人会专家委员会委员、浙江卫视《今日评说》特约评论员、浙江省计算机学会人工智能专委会委员、杭州市计算机学会人工智能专委会委员、杭州市人工智能学会理事、国家自然科学基金委信息学部基金评议专家、浙江省科技专家库专家。\r\n\r\n主要研究领域为智能物联网、群智感知与协同、智能机器人等基础理论、核心技术及其综合解决方案，科研成果获全国吴文俊人工智能优秀青年奖（浙江省首位获奖人）、吴文俊人工智能科技进步一等奖、技术发明二等奖、浙江省技术发明二等奖、中国煤炭工业协会科学技术二等奖等7个省部级奖项，发表学术论文80多篇，包括IEEE TMC、IEEE TNNLS、IEEE IoT-J、IEEE TCAD等TOP期刊论文30多篇，1篇论文为期刊高被引论文，出版英文专著3部、3个章节，出版中文著作1部。获得授权国家发明专利20余项，软件著作权10多项。主持国家自然科学基金（青年项目、面上项目）、浙江省杰出青年科学基金、浙江省“尖兵”“领雁”项目、浙江省“揭榜挂帅”重大企业委托项目等30多个科研项目。担任多个国际期刊的编辑或客座编辑，多个国际会议主席或委员会委员；担任50多个国际顶级学术刊物审稿人和国际学术会议审稿人。同时，主持多个“智慧物联网综合平台”和“智能机器人系统”等重大横向项目，并成功应用于国家电网、杭州城市大脑、未来社区等实际场景中，产生重大经济效益和社会价值。', '浙江省数字经济联合会副会长，2019.12——至今；\r\n\r\n中国智能制造百人会专家委员，2019.01——至今；\r\n\r\n浙江省数字经济联合会数字经济青年专家委员会主任，2020.01——至今；\r\n\r\n浙江省人工智能产业技术联盟副秘书长，2020.12——至今；\r\n\r\n浙江省公共政策研究院研究员，2019.10——2022.10；', '计算机大楼B419', 'xwyao@zjut.edu.cn', 'teacher', '浙江省杰出青年科学基金，2022.11；\r\n\r\n杭州市十大青年科技英才，杭州市人才办/杭州市委组织部，2020.06；\r\n\r\n浙江省高校领军人才培养计划（“5246人才工程”）青年优秀人才，浙江省教育厅，2020.07；\r\n\r\n杭州市钱江特聘专家，杭州市人社局，2020.09；\r\n\r\n科创之江百人会ZAIL100青年委员（浙江省共7名青年委员），浙江省科协、浙江省委组织部、浙江省人社厅，2021.04；\r\n“科创中国”之江青年百人会会员，浙江省科学技术协会，2022.11；\r\n\r\n中国人工智能学会2020年度优秀会员，中国人工智能学会，2021.02；\r\n\r\n杭州市2020年度创新创业人物（2020杭州创业行业点评和改革传播活动十大现象），2020.12；', '博士 教授 博士生导师', 'server/src/main/resources/static/picture/d44caa60-2082-43b3-84e8-f72472c4ab98_s.jpg'),
	(2, '陈一玮', '', '', ' ', ' ', '', '', '', 'doctor', NULL, '', ''),
	(3, '王孝全', '', '', '', NULL, '', '', '', 'doctor', NULL, '', ''),
	(4, '吴佳程', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(5, '马煜皓', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(6, '李维财', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(7, '糜雨晗', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(8, '涂梓韬', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(9, '张恒聪', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(10, '刘俊', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(11, '何川', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(12, '袁知恒', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(13, '陆琦超', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(14, '周倩', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(15, '章锴杰', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(16, '林朗', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(17, '王鸣飞', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(18, '邢伟伟', '', '', '', NULL, '', '', '', 'doctor', NULL, '', ''),
	(19, '齐楚锋', '', '', '', NULL, '', '', '', 'doctor', NULL, '', ''),
	(20, '陈慧珍', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(21, '马进文', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(22, '张馨戈', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(23, '陈森杨', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(24, '杨烨栋', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(25, '杨啸天', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(26, '王佐响', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(27, '赵凯', '', '', '', NULL, '', '', '', 'graduate', NULL, '', ''),
	(28, '肯特', '', '', '', NULL, '', '', '', 'master', NULL, '', ''),
	(29, '王诗毅', '', '', '', NULL, '', '', '', 'graduate', NULL, '', ''),
	(30, '叶超', '', '', '', NULL, '', '', '', 'graduate', NULL, '', ''),
	(31, '倪方舟', '', '', '', NULL, '', '', '', 'graduate', NULL, '', ''),
	(32, '陈卓雅', '', '', '', NULL, '', '', '', 'graduate', NULL, '', ''),
	(1003, '张航杰', '', '', '', NULL, '', '', '', 'graduate', NULL, '', ''),
	(1004, '马得宝', '', '', '', NULL, '', '', '', 'graduate', NULL, '', ''),
	(1005, '章梦娜', '', '', '', NULL, '', '', '', 'graduate', NULL, '', ''),
	(1006, '吴叶晨歌', '', '', '', NULL, '', '', '', 'graduate', NULL, '', ''),
	(1007, '王思泰', '', '', '', NULL, '', '', '', 'graduate', NULL, '', '');

-- 导出  表 yxw.member_education_map 结构
CREATE TABLE IF NOT EXISTS `member_education_map` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_id` int NOT NULL DEFAULT '0',
  `education_id` int NOT NULL DEFAULT '0',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.member_education_map 的数据：~2 rows (大约)
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

-- 正在导出表  yxw.member_paper_map 的数据：~2 rows (大约)
DELETE FROM `member_paper_map`;
INSERT INTO `member_paper_map` (`id`, `member_id`, `paper_id`) VALUES
	(1, 1, 1),
	(2, 1, 2);

-- 导出  表 yxw.noticefile 结构
CREATE TABLE IF NOT EXISTS `noticefile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `file_address` varchar(255) NOT NULL DEFAULT '',
  `title` varchar(255) NOT NULL DEFAULT '',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.noticefile 的数据：~2 rows (大约)
DELETE FROM `noticefile`;
INSERT INTO `noticefile` (`id`, `file_address`, `title`) VALUES
	(1, 'aa', 'aa'),
	(2, 'bb', 'aa');

-- 导出  表 yxw.noticefile_report_map 结构
CREATE TABLE IF NOT EXISTS `noticefile_report_map` (
  `id` int NOT NULL AUTO_INCREMENT,
  `noticefile_id` int NOT NULL DEFAULT '0',
  `report_id` int NOT NULL DEFAULT '0',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.noticefile_report_map 的数据：~2 rows (大约)
DELETE FROM `noticefile_report_map`;
INSERT INTO `noticefile_report_map` (`id`, `noticefile_id`, `report_id`) VALUES
	(1, 1, 1),
	(2, 2, 1);

-- 导出  表 yxw.outcome 结构
CREATE TABLE IF NOT EXISTS `outcome` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '作者',
  `date` char(50) NOT NULL DEFAULT '' COMMENT '时间',
  `perio` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '期刊',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '链接',
  `pub` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '出版社',
  `pictureUrl` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '图片地址',
  `p_class` enum('论文','专利','专著') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '论文' COMMENT '0 论文 1专利 2 专著',
  `fileUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1060 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.outcome 的数据：~57 rows (大约)
DELETE FROM `outcome`;
INSERT INTO `outcome` (`id`, `title`, `author`, `date`, `perio`, `url`, `pub`, `pictureUrl`, `p_class`, `fileUrl`) VALUES
	(1003, '电磁纳米网络-基础理论及关键技术\r\n', '姚信威', '2021-01-01', ' ', ' ', '科学出版社', ' ', '专著', ' '),
	(1004, '未来服务——生活服务业的科技化变革\r\n', '姚信威', '2021-01-01', ' ', ' ', '浙江科学技术出版社', ' ', '专著', ' '),
	(1005, '智能解密：智能+场景应用案例解析\r\n', '姚信威', '2021-04-01', ' ', ' ', '电子工业出版社', ' ', '专著', ' '),
	(1006, 'Prime Archives in Sensors\r\n', '姚信威', '2020-10-01', ' ', ' ', 'Vide Leaf\r\n', ' ', '专著', ' '),
	(1007, 'Nano-Electromagnetic Communication at Terahertz: Principles and applications\r\n', '姚信威', '2020-11-01', '  ', ' ', 'IET Institution of Engineering and Technology\r\n', ' ', '专著', ' '),
	(1008, 'FGOR: Flow-Guided Opportunistic Routing for Intra-body Nanonetworks, IEEE Internet of Things Journal, 2022, DOI: 10.1109/JIOT.20 22. 3182142(中科院1区，JCR Q1区，IF：9.471）\r\n', 'Yao, X. W., Chen, Y. W., Wu, Y., Zhao, K., & Jornet, J. M.', '2022-09-21', ' IEEE Internet of Things Journal', 'https://ieeexplore.ieee.org/abstract/document/9795691', ' ', ' ', '专著', ' '),
	(1009, 'Joint Optimization of Latency and Energy Consumption for Mobile Edge Computing Based Proximity Detection in Road Networks”, China Communications, 2022, \r\n', 'Zhao, T., Liu, Y., Shou, G., & Yao, X', '2022-04-19', ' China Communications', 'https://ieeexplore.ieee.org/abstract/document/9762679', ' ', ' ', '专著', ' '),
	(1010, 'DRL-Based Offloading for Computation Delay Minimization in Wireless-Powered Multi-access Edge Computing', 'K.-C. Zheng, X.-Y. Liu, K.-K. Chi, X.-W. Yao', '2023', 'IEEE Transactions on Communications', '', '', '', '论文', ''),
	(1011, 'Nighttime Image Dehazing Based on Point Light Sources', 'X.-W. Yao, X.-G. Zhang, Y.-C. Zhang, W.-W. Xing, X. Zhang', '2022-12-20', 'Applied Sciences', '', '', '', '论文', ''),
	(1012, 'Robustness-Based Transmission Strategy for Wireless-Powered Communication Networks', 'Xiaoying Liu, Aodi Wang, Bin Xu, Kechen Zheng, Xinwei Yao', '2022', '', '', '', '', '论文', ''),
	(1013, 'Gold nanostars combined with the searched antibody for targeted oral squamous cell carcinoma therapy', '', '2022', '', '', '', '', '论文', ''),
	(1014, 'Joint Optimization of Latency and Energy Consumption for Mobile Edge Computing Based Proximity Detection in Road Networks', '', '2022', '', '', '', '', '论文', ''),
	(1015, 'Adaptive diffusion pairwise fused lasso LMS algorithm over networks', '', '2022', '', '', '', '', '论文', ''),
	(1016, 'Optimization for sequential communication line attack in interdependent power-communication network', '', '2022', '', '', '', '', '论文', ''),
	(1017, '融合改进天牛须和正余弦的双重搜索优化算法', '', '2021', '', '', '', '', '论文', ''),
	(1018, 'Dense GAN and Multi-layer Attention based Lesion Segmentation Method for COVID-19 CT Images', '', '2021-08', '', '', '', '', '论文', ''),
	(1019, 'Robust variable kernel width for maximum correntropy criterion algorithm', '', '2021-05', '', '', '', '', '论文', ''),
	(1020, 'Multi-hop Deflection Routing Algorithm Based on Reinforcement Learning for Energy-Harvesting Nanonetworks', '', '2022-01', '', '', '', '', '论文', ''),
	(1021, 'G-SVD: 一种基于高斯卷积和 SVD的暗通道去雾算法', '', '2021', '', '', '', '', '论文', ''),
	(1022, 'Interference and Coverage Modeling for Indoor Terahertz Communications with Beamforming Antennas', '', '2020-10', '', '', '', '', '论文', ''),
	(1023, 'Diffusion fused sparse LMS algorithm over networks', '', '2020-06', '', '', '', '', '论文', ''),
	(1024, 'Slot Self-Allocation Based MAC Protocol for Energy Harvesting Nano-Networks', '', '2019-10', '', '', '', '', '论文', ''),
	(1025, 'Routing Techniques in Wireless Nanonetworks: A Survey', '', '2019-09', '', '', '', '', '论文', ''),
	(1026, 'ECP: A Probing-based Error Control Strategy for THz-based Nanonetworks with Energy Harvesting', '', '2019-02', '', '', '', '', '论文', ''),
	(1027, 'Component-wise variable step-size diffusion least mean square algorithm for distributed estimation', '', '2019-05', '', '', '', '', '论文', ''),
	(1028, 'MDA: A Reconfigurable Memristor-based Distance Accelerator for Time Series Mining on Data Centers', '', '2019-05', '', '', '', '', '论文', ''),
	(1029, 'Diffusion Robust Variable Step-size LMS Algorithm over Distributed Networks', '', '2018-10', '', '', '', '', '论文', ''),
	(1030, '基于混合储能和能量捕获的多接入信道容量建模与分析', '', '2018-08', '', '', '', '', '论文', ''),
	(1031, '基于能量捕获和混合储能的微观网络能量最优分配算法', '', '2018-08', '', '', '', '', '论文', ''),
	(1032, 'Selective CS: An Energy-Efficient Sensing Architecture for Wireless Implantable Neural Decoding', '', '2018-06', '', '', '', '', '论文', ''),
	(1033, '张行，姚信威，陈树，王杰，邢伟伟。一种基于3D投影的园区车位预定辅助系统及辅助方法，授权号：ZL202110876699.8（专利权人：浙江慧享信息科技有限公司，授权时间：2023.01.03）', '', '2023', '', '', '', '', '专利', ''),
	(1034, '张行，姚信威，陈树，梅江林，邢伟伟。一种基于蚁群算法的智能约梯方法、系统及设备，授权号：ZL202111468071.0（专利权人：浙江慧享信息科技有限公司，授权时间：2022.04.05）', '', '2022', '', '', '', '', '专利', ''),
	(1035, '姚信威, 赵凯, 陈一玮, 伍奕. 一种面向流引导纳米网络循环感知的机会路由方法, 受理号：202111475640.4', '', '2021', '', '', '', '', '专利', ''),
	(1036, 'On the Achievable Throughput of Energy-harvesting Nanonetworks in the Terahertz Band', '', '2018-01', '', '', '', '', '论文', ''),
	(1037, 'Accelerating Dynamic Time Warping with Memristor-based Customized Fabrics', '', '2018-04', '', '', '', '', '论文', ''),
	(1038, '基于混合储能结构的能量捕获无线通信信道容量分析', '', '2018-02', '', '', '', '', '论文', ''),
	(1039, 'MA-ADM: A Memory-Assisted Angular-Division-Multiplexing MAC Protocol in Terahertz Communication Networks', '', '2017-09', '', '', '', '', '论文', ''),
	(1040, 'Stochastic geometry analysis of interference and coverage in terahertz networks', '', '2017-07', '', '', '', '', '论文', ''),
	(1041, 'EOC: Energy Optimization Coding for Wireless Nanosensor Networks in the Terahertz Band', '', '2017-02', '', '', '', '', '论文', ''),
	(1042, 'Joint Throughput and Transmission Range Optimization for Triple-Hop Networks with Cognitive Relay', '', '2017-02', '', '', '', '', '论文', ''),
	(1043, '认知无线电中能效优化的子载波匹配策略', '', '2017-06', '', '', '', '', '论文', ''),
	(1044, 'TAB-MAC: Assisted Beamforming MAC Protocol for Terahertz Communication Networks', '', '2016-09', '', '', '', '', '论文', ''),
	(1045, 'Joint Parameter Optimization for Perpetual Nanonetworks and Maximum Network Capacity', '', '2015-12', '', '', '', '', '论文', ''),
	(1046, 'A Fast CU Depth Decision Mechanism for HEVC', '', '2015-09', '', '', '', '', '论文', ''),
	(1047, 'Bio-inspired self-adaptive rate control for multi-priority data transmission over WLANs', '', '2014-11', '', '', '', '', '论文', ''),
	(1048, 'IPB-frame Adaptive Mapping Mechanism for Video Transmission over IEEE 802.11e WLANs', '', '2014-04', '', '', '', '', '论文', ''),
	(1049, 'A Novel Hybrid Slot Allocation Mechanism for 802.11e EDCA Protocol', '', '2014-02', '', '', '', '', '论文', ''),
	(1050, 'SOBP: a Sender-Designated Opportunistic Broadcast Protocol for VANET', '', '2013-06', '', '', '', '', '论文', ''),
	(1051, 'PABM-EDCF: Parameter Adaptive Bi-directional Mapping Mechanism for Video Transmission over WSNs', '', '2013-04', '', '', '', '', '论文', ''),
	(1052, 'Video Streaming Transmission: Performance Modeling over WLANs Under Saturation Condition', '', '2012-02', '', '', '', '', '论文', ''),
	(1053, '吞吐量最大化的二维无线能量传输算法', '', '2015-11', '', '', '', '', '论文', ''),
	(1054, 'QoS区分的无线通信仿生建模', '', '2013-08', '', '', '', '', '论文', ''),
	(1055, '面向视频维护的拥塞感知自适应映射方法及其应用', '', '2011-01', '', '', '', '', '论文', ''),
	(1056, 'MOAMCA:基于增强虚拟力的自适应多障碍区域最大覆盖算法.', '', '2012-12', '', '', '', '', '论文', ''),
	(1057, '不同调制机制下无线传感网收发器能耗优化模型', '', '2013-08', '', '', '', '', '论文', ''),
	(1058, 'An adaptive and opportunistic broadcast protocol for vehicular ad hoc networks', '', '2012-04', '', '', '', '', '论文', ''),
	(1059, '结合极大似然距离估计的MDS-MAP节点定位算法', '', '2016-04', '', '', '', '', '论文', '');

-- 导出  表 yxw.paper 结构
CREATE TABLE IF NOT EXISTS `paper` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.paper 的数据：~2 rows (大约)
DELETE FROM `paper`;
INSERT INTO `paper` (`id`, `name`) VALUES
	(1, 'aaaa'),
	(2, 'bbb');

-- 导出  表 yxw.project 结构
CREATE TABLE IF NOT EXISTS `project` (
  `id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) NOT NULL DEFAULT '',
  `responser` varchar(255) NOT NULL DEFAULT '',
  `project_type` varchar(255) NOT NULL DEFAULT '',
  `time` varchar(255) NOT NULL DEFAULT '',
  `project_info` text,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.project 的数据：~0 rows (大约)
DELETE FROM `project`;
INSERT INTO `project` (`id`, `project_name`, `responser`, `project_type`, `time`, `project_info`) VALUES
	(1, '面向人体移动纳米物联网的通信建模及协议设计', '姚信威', '浙江省杰出青年科学基金项目', '2023.01-2025.12', '浙江省杰出青年科学基金项目，“面向人体移动纳米物联网的通信建模及协议设计”，2023.01-2025.12，项目负责人，排名：1/1；'),
	(2, '低碳运输碳排放智能感知与协同控制关键技术研究与应用示范', '姚信威', '浙江省重点研发“领雁”计划项目', '2023.01-2025.12', '浙江省重点研发“领雁”计划项目，“低碳运输碳排放智能感知与协同控制关键技术研究与应用示范”，2023.01-2025.12，合作单位项目负责人，排名：2/10；');

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
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `r_class` enum('通知','动态','媒体','咨询') NOT NULL DEFAULT '通知' COMMENT '0通知 1动态 2媒体 3 咨询 4相关学术会议',
  `url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `picture_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `paper_name` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11130 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.report 的数据：~18 rows (大约)
DELETE FROM `report`;
INSERT INTO `report` (`id`, `title`, `date`, `text`, `r_class`, `url`, `picture_url`, `paper_name`) VALUES
	(1, '浙工大姚信威博士荣获“杭州市十大青年科技英才”称号！16年的梦想与坚持终会绽放！', '2020-06-22', '每一个80后都曾有过成为科学家的梦想，姚信威也不例外。《变形金刚》《哆啦a梦》，这些耳熟能详的动画是他童年的美好回忆，也在他心里种下了一个研究“机器人”的梦想。在这一梦想的驱动下，2004年， 18岁的姚信威考入了浙江工业大学机电工程学院（现机械工程学院）。\r\n\r\n图书馆、实验室，四年的光阴，姚信威的大部分课余时间都花在这两个地方，并且努力学习学科相关知识。大二那年，姚信威主动联系了学院老师加入科研团队。当年，他几乎把所有的课余时间花在了实验室里，学习相关的知识与操作。即使是一些杂活和整理工作，他也一丝不苟地完成并且乐在其中。当时认真负责的工作精神，也为日后姚信威博士带领团队攀登技术高峰打下了牢固的基础。', '通知', 'https://www.sohu.com/a/403540901_286785', 'server/src/main/resources/static/picture/b231c90a9a8543f387a7b4c1d7733a88.jpeg', ''),
	(2, '受邀接受第一财经记者（金叶子）采访“平台建设再提速，2020年人工智能区域联动怎么做？”', '2020-01-05', '恭喜恭喜', '媒体', ' ', 'server/src/main/resources/static/picture/微信图片_20230305170123.png', ''),
	(11114, '受邀参加2020人工智能与长三角协同创新高峰论坛暨上海人工智能发展联盟年会，并代表浙江省人工智能产业联盟出席“长三角人工智能发展联盟”成立仪式，作为圆桌嘉宾参加圆桌论坛。被上海东方卫视晚间新闻报道。', '2020-01-03', NULL, '媒体', NULL, NULL, ''),
	(11115, '“新一代人工智能浙江发展路径”，经贸实践', '2019-03-31', NULL, '媒体', NULL, NULL, ''),
	(11116, '5G来了  6G还远吗？  受邀接受国际商报记者（白舒婕）采访', '2019-11-19', NULL, '媒体', 'http://epaper.comnews.cn/xpaper/appnews/207/2767/13817-1.shtml', NULL, ''),
	(11117, '姚信威博士以科研成果获2018吴文俊人工智能科学技术奖优秀青年奖、第八届吴文俊人工智能技术发明二等奖', '2018-12-10', '姚信威博士以科研成果“多尺度网络智能感知与通信”获2018吴文俊人工智能科学技术奖优秀青年奖、以科研成果“基于网络智能的实时语音交互智能客服系统研制及应用”获第八届吴文俊人工智能技术发明二等奖（浙江工业大学为第一完成单位、姚信威博士排名第二）。获奖成果被中央电视台CCTV新闻频道《朝闻天下》、新华社、科学网、中新网、环球网、央广网、一点资讯、中国企业网、苏州卫视、经济日报、中国高新科技网、扬子晚报等70多家国内主流媒体报道。', '媒体', NULL, NULL, ''),
	(11118, '各国布局5G时代 中国有望领跑。', '2018-10-10', '受邀接受国际商报记者（白舒婕）采访，分析了5G产业蕴含的潜力和商机，并进一步阐述了中国5G发展的优势和建议，并被国际商报、中国商务新闻网第9075期（第2版要闻）刊载报道。', '媒体', 'http://epaper.comnews.cn/news.php?newsid=1202798', NULL, ''),
	(11119, '姚信威博士受邀参加浙江卫视《今日评说》', '2018-07-03', '我们需要什么样的“独角兽”？，观点：除了互联网、电子商务等领域，也渴望实体经济、新经济等领域的独角兽。新时代，在修筑“护城河”、占领“制高点”的同时，也要恪守9字真经“心要热、头要冷、步要稳”。', '媒体', 'http://www.cztv.com/videos/jrps?mType=Group', NULL, ''),
	(11120, '作为特邀嘉宾参加第二届云计算大数据产业推进大会“云助浙江  数赢未来”（浙江杭州），并作为主持人主持圆桌论坛对话：“直面云计算大数据”。', '2018-03-30', NULL, '媒体', NULL, NULL, ''),
	(11121, '受邀做《让制造业插上智能的“翅膀”》主题报告', '2018-03-28', '受苏州工业园区邀请参加“2018首期CAAI吴文俊人工智能科学技术奖前沿讲习班”作《让制造业插上智能的“翅膀”》主题报告。', '媒体', NULL, NULL, ''),
	(11122, '“走心”的中国手机赢得海外市场', '2018-02-25', '受邀接受国际商报记者（白舒婕）采访，阐述了中国智能手机在技术创新和知识产权保护等观点，并被国际商报第8926期（第1版要闻）刊载报道。', '媒体', 'http://epaper.comnews.cn/news.php?newsid=1187431', NULL, ''),
	(11123, '受浙江省永康市政府邀请参加“永康智能制造”论坛作《新一代人工智能发展变革》大会主题报告。', '2018-02-01', NULL, '媒体', NULL, NULL, ''),
	(11124, '参加“制造业拥抱数字经济”为主题的沙龙（由浙江省信息经济联合会主办），作为圆桌会议嘉宾发表演讲交流。', '2018-01-27', NULL, '媒体', NULL, NULL, ''),
	(11125, '“浙江工业大学姚信威：电视将成为智能家居显示终端”', '2017-08-10', '人工智能-智能家居；“浙江工业大学姚信威：电视将成为智能家居显示终端”。凤凰新闻网、新浪浙江、腾讯大浙网、中华网、网易新闻、中关村在线、太平洋电脑网、中国家电网、家电新闻网、三星公司、第三媒体、和讯网、东北新闻网、北方时空等20多家媒体报道。', '媒体', '中华网China.Com：http://finance.china.com/jykx/news/11179727/20170816/25106460.html;\r\n凤凰网：http://sn.ifeng.com/a/20170816/5918929_0.shtml;\r\n腾讯网：http://hn.qq.com/a/20170816/037537.htm;\r\n网易新闻：http://hebei.news.163.com/17/0816/15/CRVK8T8304159831.html;\r\n网易数码：http://digi.163.com/17/0816/15/CRVI38BN001680NS.html;\r\n赛迪网：http://www.ccidnet.com/2017/0816/10303186.shtml;\r\nPCHOME网：http://article.pchome.net/content-2022715.html;\r\n中关村在线：http://tv.zol.com.cn/651/6517592.html;\r\n第三媒体：http://lcdtv.thethirdmedia.com/article/201708/show395627c7p1.html;\r\n和讯网：http://tech.hexun.com/2017-08-16/190468444.html;\r\n北国网（辽宁新闻）：http://www.lnd.com.cn/htm/2017-08/11/content_4603666.html;\r\n家电消费网：http://www.jdxfw.com/html/2017/fangtan_0816/63001.html;\r\n太平洋电脑网：http://family.pconline.com.cn/979/9791386.html;\r\n爱活网：https://www.evolife.cn/av/93934.html;\r\n淘客帝国：http://www.spyb.cn/shuma/zhinengjiaju/201708/s1381890.html;\r\n泡泡网：http://www.pcpop.com/doc/4/4315/4315784.shtml;\r\n乐享资讯网：http://www.52video.org/news/2017/12/17/61238347.html;\r\n', NULL, ''),
	(11126, '受邀去阳煤集团（山西阳泉）给“百期万人”计划做大会报告“智能机器人的应用及其发展趋势”。', '2017-10-10', NULL, '媒体', NULL, NULL, ''),
	(11127, '受邀参加论坛“从阿尔法元完爆阿尔法狗看人工智能的未来”', '2017-10-15', '受邀参加论坛“从阿尔法元完爆阿尔法狗看人工智能的未来”（有问科技组织），并发表评论，被新华网、百度新闻、网易新闻、瞭望东方周刊、百度知道、人民风采网、西海都市报和重庆时报等10多家媒体报道。', '媒体', '新华网：http://www.zj.xinhuanet.com/2017-10/30/c_1121878003.htm;\r\n中国网：http://news.china.com.cn/2017-10/27/content_41804299.htm;\r\n参政消息：http://column.cankaoxiaoxi.com/2017/1030/2241096_2.shtml;\r\n网易新闻：http://news.163.com/17/1027/14/D1OS0GN500018AOQ.html;\r\n搜狐网：http://www.sohu.com/a/198953993_614076;\r\n东方财富网：http://guba.eastmoney.com/news,zf,737846295.html;\r\n百度百家号：https://baijiahao.baidu.com/s?id=1582716148631880925&wfr=spider&for=pc;\r\n百度知道：https://zhidao.baidu.com/question/1823554856765821388.html;\r\n百度贴吧：http://tieba.baidu.com/p/5465470222?traceid=;\r\n重庆时报：http://cqsb.cqtimes.cn/html/2017-10/31/content_365310.htm;\r\n今日惠州网：http://e.hznews.com/paper/djsb/20171028/A07/1/;\r\n中国教育云-浙江教育资源公共服务平台（朱晓月名师工作室）： http://yun.zjer.cn/index.php?r=studio/post/view&sid=767&id=412014;', NULL, ''),
	(11128, '“人工智能+物联网+智能家电”的大会报告', '2017-11-20', '受邀参加2017年中国热水器年会，并作“人工智能+物联网+智能家电”的大会报告，被环球家电网、中国家电网、万家资讯、每日科技网、同业网、九正建材网和浏阳之窗等10来家媒体报道。', '媒体', '搜狐网：http://www.sohu.com/a/207026298_268853\r\n环球家电网：http://www.cheari.com/page.html?id=118832\r\n人民网：http://homea.people.com.cn/n1/2017/1201/c41390-29678845.html\r\n中国家电网：http://wy.cheaa.com/2017/1130/523207.shtml\r\n中国家电研究院：http://www.cheari.org/News/ShowNews.aspx?id=173\r\n中国经济网：http://www.ce.cn/cysc/zgjd/kx/201712/01/t20171201_27061077.shtml\r\n新浪科技：http://tech.sina.com.cn/i/2017-12-04/doc-ifyphkhk9282082.shtml;\r\n家电联盟：https://www.jdbbs.com/jiaju/73221-1.html;\r\n千讯咨询：http://www.qianinfo.com/index/34/49/4559669.html;\r\n口碑家电网：http://kt.eapad.cn/news/171130021233.html;\r\n万维家电网：http://news.ea3w.com/154/1540831.html;\r\n宁德网：http://app.ndwww.cn/print.php?contentid=67123;\r\n中国甘肃网：http://energy.gscn.com.cn/system/2017/12/01/011859741.shtml;\r\n', NULL, ''),
	(11129, '受邀在南方科技大学计算机科学与工程系做学术报告《Electromagnetic Nanonetworks in the Terahertz Band》，（Host Professor: Shuang-Hua Yang）', '2017-06-08', NULL, '媒体', NULL, NULL, '');

-- 导出  表 yxw.textbox 结构
CREATE TABLE IF NOT EXISTS `textbox` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `fileUrl` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '文件地址',
  `tClass` enum('数据集','仿真工具','科研平台','课程教学','科研方向') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '数据集',
  `pictureUrl` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `sDate` char(50) NOT NULL DEFAULT '',
  `eDate` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1032 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  yxw.textbox 的数据：~28 rows (大约)
DELETE FROM `textbox`;
INSERT INTO `textbox` (`id`, `title`, `text`, `fileUrl`, `tClass`, `pictureUrl`, `sDate`, `eDate`) VALUES
	(1001, '数据集1', '简介', 'server/src/main/resources/static/file/b.csv', '数据集', '', '2023-03-05', '2023-03-07'),
	(1002, '仿真平台1', '简介', 'server/src/main/resources/static/file/aaaa.pdf', '仿真工具', NULL, '2023-03-05', '2023-03-07'),
	(1003, '浙工大九阳智慧家电重点实验室', '简介。。。', ' ', '科研平台', 'server/src/main/resources/static/picture/微信图片_20230305170123.png', '2023-03-07', '2023-03-07'),
	(1005, '本科生教学', '主讲：《人工智能导论》、《Principles of Computer Networks》（《计算机网络原理》留学生）、《计算机网络原理》、《无线传感器网络》', ' ', '课程教学', 'server/src/main/resources/static/picture/微信图片_20230305170123.png', '2023-03-07', '2023-03-07'),
	(1008, '泛化人工智能', '智能物联网、群智感知与协同、泛化人工智能', ' ', '科研方向', 'server/src/main/resources/static/picture/微信图片_20230305170123.png', '2023-03-07', '2023-03-07'),
	(1031, '平台2', '简介简介', 'server/src/main/resources/static/file/aaaa.pdf', '仿真工具', 'server/src/main/resources/static/picture/微信图片_20230305170123.png', '', '');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
