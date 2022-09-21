-- 【LonelyBar資料庫SQL檔】 --
-- ----------------------建立資料庫----------------------
CREATE DATABASE IF NOT EXISTS lonelybar;
use lonelybar;

-- ----------------------清除舊表----------------------
-- ------ WeiWei10：討論區相關表格 ------
DROP TABLE IF EXISTS latest_news;
DROP TABLE IF EXISTS article_message_report;
DROP TABLE IF EXISTS article_message;
DROP TABLE IF EXISTS forum_article_report;
DROP TABLE IF EXISTS forum_article;
DROP TABLE IF EXISTS forum;

-- ------ InstallBlack26：活動相關表格 ------ 
DROP TABLE IF EXISTS push_ads;
DROP TABLE IF EXISTS ans_list;
DROP TABLE IF EXISTS question_list;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS firm_survey;
DROP TABLE IF EXISTS act_pic;
DROP TABLE IF EXISTS act_sign_up;
DROP TABLE IF EXISTS act;

-- ------ LucLin09：管理員相關表格 ------
DROP TABLE IF EXISTS customer_feedback;
DROP TABLE IF EXISTS customer_chat_room;
DROP TABLE IF EXISTS manager_auth;
DROP TABLE IF EXISTS manager_authfunc;
DROP TABLE IF EXISTS manager;

-- ------ RoySher37：商城相關表格 ------
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS order_detail;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS prod_pic;
DROP TABLE IF EXISTS prod;
DROP TABLE IF EXISTS prod_type;

-- ------ Arick34：酒吧相關表格 ------
DROP TABLE IF EXISTS pub_pics;
DROP TABLE IF EXISTS pub_rank;
DROP TABLE IF EXISTS pub_booking;
DROP TABLE IF EXISTS pub_reservation;
DROP TABLE IF EXISTS pub;

-- ------ Hsin08：會員相關表格 ------
DROP TABLE IF EXISTS mem_coupon;
DROP TABLE IF EXISTS coupon;
DROP TABLE IF EXISTS mem;

-- ----------------------表格建立區----------------------
-- 建立 會員 表格
CREATE TABLE `mem` (
  `mem_no` int NOT NULL AUTO_INCREMENT,
  `mem_account` varchar(20) NOT NULL,
  `mem_password` varchar(20) NOT NULL,
  `mem_gender` tinyint NOT NULL,
  `mem_last_name` varchar(10) NOT NULL,
  `mem_first_name` varchar(10) NOT NULL,
  `mem_nickname` varchar(10) DEFAULT NULL,
  `mem_tel_no` varchar(20) NOT NULL,
  `mem_cel_no` varchar(20) NOT NULL,
  `mem_email` varchar(50) NOT NULL,
  `mem_id` varchar(10) NOT NULL,
  `mem_birth` date NOT NULL,
  `mem_addr` varchar(50) NOT NULL,
  `mem_permission` tinyint NOT NULL,
  `status` tinyint NOT NULL DEFAULT '1',
  `mem_build_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mem_cert_status` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`mem_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 酒吧 表格
CREATE TABLE pub (
    pub_no INT AUTO_INCREMENT NOT NULL,
    mem_no INT NOT NULL,
    pub_status TINYINT NOT NULL DEFAULT '0',
    pub_nop INT NOT NULL,
    pub_rate_sum DOUBLE(2, 1),
    pub_ratetotal INT,
    pub_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    pub_application TINYINT NOT NULL DEFAULT '0',
    pub_address VARCHAR(200) NOT NULL,
    pub_open CHAR(168),
    pub_detail VARCHAR(500) NOT NULL,
    pub_name VARCHAR(100) NOT NULL,
    pub_lng DOUBLE,
    pub_lat DOUBLE,
    firm_name VARCHAR(20),
    firm_addr VARCHAR(50),
    firm_tel_no VARCHAR(20),
    firm_email VARCHAR(50),
    firm_tax_id VARCHAR(10),
	pub_application_M VARCHAR(200),
    CONSTRAINT pub_no_PK PRIMARY KEY (pub_no),
    CONSTRAINT `pub.mem_no_FK` FOREIGN KEY (mem_no) REFERENCES mem (mem_no)
);

-- 建立 酒吧照片 表格
CREATE TABLE `pub_pics` (
  `pub_pic_no` int NOT NULL AUTO_INCREMENT,
  `pub_no` int NOT NULL,
  `pub_pic` MediumBlob NOT NULL,
  PRIMARY KEY (`pub_pic_no`),
  KEY `pub_no_FK_idx` (`pub_no`),
  CONSTRAINT `pub_pics.pub_no_FK` FOREIGN KEY (`pub_no`) REFERENCES `pub` (`pub_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 酒吧評價 表格
CREATE TABLE `pub_rank` (
  `pub_no` int NOT NULL,
  `mem_no` int NOT NULL,
  `pub_rate` tinytext NOT NULL,
  `pub_comment` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`pub_no`,`mem_no`),
  KEY `mem_no_PK_FK_idx` (`mem_no`),
  CONSTRAINT `pub_rank.mem_no_PK_FK` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`),
  CONSTRAINT `pub_rank.pub_no_PK_FK` FOREIGN KEY (`pub_no`) REFERENCES `pub` (`pub_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 會員訂位 表格
CREATE TABLE `pub_booking` (
  `pub_booking_no` int NOT NULL AUTO_INCREMENT,
  `pub_no` int NOT NULL,
  `mem_no` int NOT NULL,
  `pub_booking_date` date ,
  `pub_booking_time` char(72),
  `pub_booking_status` tinyint NOT NULL,
  PRIMARY KEY (`pub_booking_no`),
  KEY `pub_no_FK_idx` (`pub_no`),
  KEY `mem_no_FK_idx` (`mem_no`),
  CONSTRAINT `pub_booking.mem_no_FK_1` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`),
  CONSTRAINT `pub_booking.pub_no_FK_1` FOREIGN KEY (`pub_no`) REFERENCES `pub` (`pub_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 酒吧訂位 表格
CREATE TABLE `pub_reservation` (
  `pub_reservation_no` int NOT NULL AUTO_INCREMENT,
  `pub_no` int NOT NULL,
  `pub_available` char(72) NOT NULL,
  `pub_reservation_date` date NOT NULL,
  PRIMARY KEY (`pub_reservation_no`),
  KEY `pub_reservation.pub_no_FK_idx` (`pub_no`),
  CONSTRAINT `pub_reservation.pub_no_FK` FOREIGN KEY (`pub_no`) REFERENCES `pub` (`pub_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 商品種類 表格
CREATE TABLE `prod_type` (
  `prod_type_no` int NOT NULL AUTO_INCREMENT,
  `prod_type_name` varchar(20) NOT NULL,
  PRIMARY KEY (`prod_type_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--  建立 商品 表格
CREATE TABLE `prod` (
  `prod_no` int NOT NULL AUTO_INCREMENT,
  `prod_type_no` int NOT NULL,
  `prod_name` varchar(100) NOT NULL,
  `prod_price` int NOT NULL,
  `prod_stock` int NOT NULL,
  `prod_status` tinyint NOT NULL DEFAULT '1',
  `launch_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  `off_time` timestamp DEFAULT NULL,
  `prod_detail` varchar(1000) NOT NULL,
  PRIMARY KEY (`prod_no`),
  KEY `prod_type_no_FK_idx` (`prod_type_no`),
  CONSTRAINT `prod_type_no_FK` FOREIGN KEY (`prod_type_no`) REFERENCES `lonelybar`.`prod_type` (`prod_type_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 商品照片 表格
CREATE TABLE `prod_pic` (
  `prod_pic_no` int NOT NULL AUTO_INCREMENT,
  `prod_no` int NOT NULL,
  `prod_pic` longblob,
  `prod_pic_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`prod_pic_no`),
  KEY `prod_no_idx` (`prod_no`),
  CONSTRAINT `prod_pic_prod_no_FK` FOREIGN KEY (`prod_no`) REFERENCES `prod` (`prod_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 優惠券 表格 
CREATE TABLE `coupon` (
  `coupon_no` int NOT NULL AUTO_INCREMENT,
  `coupon_name` varchar(20) NOT NULL,
  `coupon_code` varchar(10) NOT NULL,
  `coupon_content` varchar(100) NOT NULL,
  `coupon_discount` double NOT NULL,
  `coupon_amount` tinyint NOT NULL DEFAULT '0',
  `launch_time` timestamp DEFAULT NULL,
  `off_time` timestamp DEFAULT NULL,
  `coupon_build_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint NOT NULL,
  PRIMARY KEY (`coupon_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 商品訂單 表格
CREATE TABLE `order` (
  `order_no` int NOT NULL AUTO_INCREMENT,
  `mem_no` int NOT NULL,
  `coupon_no` int DEFAULT NULL,
  `order_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  `order_price_total` int NOT NULL,
  `dis_price_total` int NOT NULL,
  `order_status` tinyint NOT NULL DEFAULT '0',
  `payment_method` tinyint NOT NULL,
  `pickup_method` tinyint NOT NULL,
  `shipping_fee` tinyint NOT NULL,
  `receiver_name` varchar(15) NOT NULL,
  `receiver_address` varchar(100) NOT NULL,
  `receiver_phone` varchar(15) NOT NULL,
  PRIMARY KEY (`order_no`),
  KEY `mem_no_idx` (`mem_no`),
  KEY `coupon_no_idx` (`coupon_no`),
  CONSTRAINT `order_coupon_no_FK` FOREIGN KEY (`coupon_no`) REFERENCES `coupon` (`coupon_no`),
  CONSTRAINT `order_mem_no_FK` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 商品訂單明細 表格
CREATE TABLE `order_detail` (
  `order_no` int NOT NULL,
  `prod_no` int NOT NULL,
  `prod_qty` int DEFAULT NULL,
  `prod_price` int DEFAULT NULL,
  `mem_no` int NOT NULL,
  PRIMARY KEY (`order_no`,`prod_no`),
  KEY `prod_no_PK_FK_idx` (`prod_no`),
  CONSTRAINT `order_detail_order_no_PK_FK` FOREIGN KEY (`order_no`) REFERENCES `order` (`order_no`),
  CONSTRAINT `order_detail_prod_no_PK_FK` FOREIGN KEY (`prod_no`) REFERENCES `prod` (`prod_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 購物車 表格
CREATE TABLE `cart` (
  `mem_no` int NOT NULL,
  `prod_no` int NOT NULL,
  `prod_qty` int DEFAULT NULL,
  KEY `mem_no_idx` (`mem_no`),
  KEY `prod_no_idx` (`prod_no`),
  CONSTRAINT `cart_mem_no_FK` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`),
  CONSTRAINT `cart_prod_no_FK` FOREIGN KEY (`prod_no`) REFERENCES `prod` (`prod_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--  建立 管理員 表格
CREATE TABLE `manager` (
  `mng_no` int NOT NULL AUTO_INCREMENT,
  `mng_account` varchar(20) NOT NULL,
  `mng_password` varchar(20) NOT NULL,
  `mng_name` varchar(20) NOT NULL,
  `mng_phone` varchar(10) NOT NULL,
  `mng_pic` blob,
  `mng_status` tinyint NOT NULL,
  PRIMARY KEY (`mng_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--  建立 管理員權限 表格
CREATE TABLE `manager_authfunc` (
  `mng_authfunc_no` int NOT NULL AUTO_INCREMENT,
  `mng_authfunc_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`mng_authfunc_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--  建立 管理員明細 表格
CREATE TABLE `manager_auth` (
  `mng_no` int NOT NULL,
  `mng_authfunc_no` int NOT NULL,
  PRIMARY KEY (`mng_no`,`mng_authfunc_no`),
  KEY `manager_auth.mng_authfunc_no_PK_FK_idx` (`mng_authfunc_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--  建立 客服聊天室 表格
CREATE TABLE `customer_chat_room` (
  `SN` int NOT NULL AUTO_INCREMENT,
  `mng_no` int NOT NULL,
  `mem_no` int NOT NULL,
  `prod_no` int NOT NULL,
  `message` text,
  `mem_question_pic` blob,
  `message_chat_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `chat_direction` tinyint NOT NULL,
  PRIMARY KEY (`SN`),
  KEY `customer_chat_room_mng_no_idx` (`mng_no`),
  KEY `customer_chat_room_mem_no_idx` (`mem_no`),
  KEY `customer_chat_room_prod_no_idx` (`prod_no`),
  CONSTRAINT `customer_chat_room.mem_no_FK` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`),
  CONSTRAINT `customer_chat_room.mng_no_FK` FOREIGN KEY (`mng_no`) REFERENCES `manager` (`mng_no`),
  CONSTRAINT `customer_chat_room.prod_no_FK` FOREIGN KEY (`prod_no`) REFERENCES `prod` (`prod_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--  建立 問題回報 表格
CREATE TABLE `customer_feedback` (
  `SN` int NOT NULL AUTO_INCREMENT,
  `mem_no` int NOT NULL,
  `order_no` int DEFAULT NULL,
  `prod_no` int DEFAULT NULL,
  `pub_no` int DEFAULT NULL,
  `act_no` int DEFAULT NULL,
  `mng_no` int DEFAULT NULL,
  `feedback_status` tinyint NOT NULL,
  PRIMARY KEY (`SN`),
  KEY `customer_feedback_mem_no_FK_idx` (`mem_no`),
  KEY `customer_feedback_pub_no_FK_idx` (`pub_no`),
  KEY `customer_feedback_mng_no_FK_idx` (`mng_no`),
  KEY `customer_feedback_order_no_FK_idx` (`order_no`),
  KEY `customer_feedback_prod_no_FK_idx` (`prod_no`),
  CONSTRAINT `customer_feedback.mem_no_FK` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`),
  CONSTRAINT `customer_feedback.mng_no_FK` FOREIGN KEY (`mng_no`) REFERENCES `manager` (`mng_no`),
  CONSTRAINT `customer_feedback.order_no_FK` FOREIGN KEY (`order_no`) REFERENCES `order` (`order_no`),
  CONSTRAINT `customer_feedback.prod_no_FK` FOREIGN KEY (`prod_no`) REFERENCES `prod` (`prod_no`),
  CONSTRAINT `customer_feedback.pub_no_FK` FOREIGN KEY (`pub_no`) REFERENCES `pub` (`pub_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 活動 表格
CREATE TABLE `act` (
    `act_no` INT AUTO_INCREMENT NOT NULL,
    `pub_no` INT NOT NULL,
    `act_name` VARCHAR(50) NOT NULL,
    `act_detail` VARCHAR(500) NOT NULL,
    `act_loc` VARCHAR(100) NOT NULL,
    `act_launch_time` DATETIME NOT NULL,
    `act_off_time` DATETIME NOT NULL,
    `current_count` INT NOT NULL DEFAULT '0',
    `max_count` INT NOT NULL,
    `min_count` INT NOT NULL,
    `sign_up_begin_time` DATETIME NOT NULL,
    `sign_up_end_time` DATETIME NOT NULL,
    `act_start_time` DATETIME NOT NULL,
    `act_end_time` DATETIME NOT NULL,
    `act_status` TINYINT NOT NULL DEFAULT '0',
    `revise_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT `act_no_PK` PRIMARY KEY (`act_no`),
    CONSTRAINT `act.pub_no_FK` FOREIGN KEY (`pub_no`)
        REFERENCES `pub` (`pub_no`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 活動報名 表格
CREATE TABLE `act_sign_up` (
    `sign_up_no` INT AUTO_INCREMENT NOT NULL,
    `act_no` INT NOT NULL,
    `mem_no` INT NOT NULL,
    `sign_up_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `accompany_count` INT NOT NULL,
    `sign_up_status` TINYINT NOT NULL DEFAULT '0',

    CONSTRAINT `sign_up_no_PK` PRIMARY KEY (`sign_up_no`),
    CONSTRAINT `act_sign_up.act_no_FK` FOREIGN KEY (`act_no`)
        REFERENCES `act` (`act_no`),
	CONSTRAINT `act_sign_up.mem_no_FK` FOREIGN KEY (`mem_no`)
        REFERENCES `mem` (`mem_no`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 活動照片 表格
CREATE TABLE `act_pic` (
    `act_pic_no` INT AUTO_INCREMENT NOT NULL,
    `act_no` INT NOT NULL,
    `act_pic` LONGBLOB,
    `act_pic_name` VARCHAR(500),

    CONSTRAINT `act_pic_no_PK` PRIMARY KEY (`act_pic_no`),
    CONSTRAINT `act_pic.act_no_FK` FOREIGN KEY (`act_no`)
        REFERENCES `act` (`act_no`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 廠商問卷 表格
CREATE TABLE `firm_survey` (
    `firm_survey_no` INT AUTO_INCREMENT NOT NULL,
    `act_no` INT NOT NULL,
    `survey_build_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `survey_revise_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT `firm_survey_no_PK` PRIMARY KEY (`firm_survey_no`),
    CONSTRAINT `firm_survey.act_no_FK` FOREIGN KEY (`act_no`)
        REFERENCES `act` (`act_no`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 題目 表格
CREATE TABLE `question` (
    `question_no` INT AUTO_INCREMENT NOT NULL,
    `que` VARCHAR(300) NOT NULL,

    CONSTRAINT `question_no_PK` PRIMARY KEY (`question_no`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 題目清單 表格
CREATE TABLE `question_list` (
    `question_no` INT NOT NULL,
    `firm_survey_no` INT NOT NULL,

  PRIMARY KEY (`question_no`,`firm_survey_no`),
  CONSTRAINT `question_list_question_no_PK_FK` FOREIGN KEY (`question_no`) REFERENCES `question` (`question_no`),
  CONSTRAINT `question_list_firm_survey_no_PK_FK` FOREIGN KEY (`firm_survey_no`) REFERENCES `firm_survey` (`firm_survey_no`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 答案清單 表格
CREATE TABLE `ans_list` (
    `question_no` INT NOT NULL,
    `firm_survey_no` INT NOT NULL,
    `mem_no` INT NOT NULL,
    `ans` VARCHAR(500),

  PRIMARY KEY (`question_no`,`firm_survey_no`,`mem_no`),
  CONSTRAINT `ans_list_question_no_PK_FK` FOREIGN KEY (`question_no`) REFERENCES `question` (`question_no`),
  CONSTRAINT `ans_list_firm_survey_no_PK_FK` FOREIGN KEY (`firm_survey_no`) REFERENCES `firm_survey` (`firm_survey_no`),
  CONSTRAINT `ans_list_mem_no_PK_FK` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 討論區 表格
CREATE TABLE `forum` (
  `frm_no` int NOT NULL AUTO_INCREMENT,
  `frm_name_no` varchar(200) DEFAULT NULL,
  `frm_status` tinyint NOT NULL DEFAULT '1',
  `frm_img` longblob, 
  PRIMARY KEY (`frm_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 討論區文章 表格
CREATE TABLE `forum_article` (
  `frm_art_no` int NOT NULL AUTO_INCREMENT,
  `frm_no` int NOT NULL,
  `mem_no` int NOT NULL,
  `art_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `art_title` varchar(100) NOT NULL,
  `art_content` varchar(1000) NOT NULL,
  `art_img` blob,
  `art_status` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`frm_art_no`),
  KEY `frm_no_idx` (`frm_no`),
  CONSTRAINT `frm_no_FK` FOREIGN KEY (`frm_no`) REFERENCES `forum` (`frm_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 討論區文章檢舉 表格
CREATE TABLE `forum_article_report` (
  `frm_art_rpt_no` int NOT NULL AUTO_INCREMENT,
  `mem_no` int NOT NULL,
  `frm_art_no` int NOT NULL,
  `rpt_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `rpt_content` varchar(1000) NOT NULL,
  `mng_no` int DEFAULT NULL,
  `rpt_done_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `rpt_status` tinyint DEFAULT '0',
  `rpt_result` tinyint DEFAULT '0',
  `rpt_note` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`frm_art_rpt_no`),
  KEY `mem_no_FK_idx` (`mem_no`),
  KEY `frm_art_no_FK_idx` (`frm_art_no`),
  KEY `mng_no_idx` (`mng_no`),
  CONSTRAINT `frm_art_no_FK` FOREIGN KEY (`frm_art_no`) REFERENCES `forum_article` (`frm_art_no`),
  CONSTRAINT `mem_no_FK` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`),
  CONSTRAINT `mng_no_FK` FOREIGN KEY (`mng_no`) REFERENCES `manager` (`mng_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 文章留言 表格
CREATE TABLE `article_message` (
  `art_msg_no` int NOT NULL AUTO_INCREMENT,
  `mem_no` int NOT NULL,
  `frm_art_no` int NOT NULL,
  `msg_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `msg_content` varchar(1000) NOT NULL,
  PRIMARY KEY (`art_msg_no`),
  KEY `mem_no_FK_idx` (`mem_no`),
  KEY `frm_art_no_FK_idx` (`frm_art_no`),
  CONSTRAINT `art_msg_frm_art_no_FK` FOREIGN KEY (`frm_art_no`) REFERENCES `forum_article` (`frm_art_no`),
  CONSTRAINT `art_msg_mem_no_FK` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 文章留言檢舉 表格
CREATE TABLE `article_message_report` (
  `art_msg_rpt` int NOT NULL AUTO_INCREMENT,
  `mem_no` int NOT NULL,
  `art_msg_no` int NOT NULL,
  `rpt_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `rpt_msg_content` varchar(1000) NOT NULL,
  `mng_no` int DEFAULT NULL,
  `msg_done_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `msg_states` tinyint NOT NULL DEFAULT '0',
  `msg_result` tinyint NOT NULL DEFAULT '0',
  `msg_note` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`art_msg_rpt`),
  KEY `mem_no_idx` (`mem_no`),
  KEY `art_msg_no_idx` (`art_msg_no`),
  KEY `mng_no_idx` (`mng_no`),
  CONSTRAINT `art_msg_no` FOREIGN KEY (`art_msg_no`) REFERENCES `article_message` (`art_msg_no`),
  CONSTRAINT `mem_no` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`),
  CONSTRAINT `mng_no` FOREIGN KEY (`mng_no`) REFERENCES `manager` (`mng_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 最新消息 表格
CREATE TABLE `latest_news` (
  `latest_news_no` int NOT NULL AUTO_INCREMENT,
  `news_content` varchar(1000) NOT NULL,
  `news_status` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`latest_news_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 會員優惠券 表格
CREATE TABLE `mem_coupon` (
  `coupon_no` int NOT NULL,
  `mem_no` int NOT NULL,
  `remain_amount` int NOT NULL,
  PRIMARY KEY (`coupon_no`,`mem_no`),
  KEY `mem_no_idx` (`mem_no`),
  CONSTRAINT `coupon_no` FOREIGN KEY (`coupon_no`) REFERENCES `coupon` (`coupon_no`),
  CONSTRAINT `mem_no_PK_FK` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 建立 推播廣告 表格
CREATE TABLE `push_ads` (
  `ads_no` int NOT NULL AUTO_INCREMENT,
  `prod_no` int DEFAULT NULL,
  `ads_content` varchar(200) NOT NULL,
  `act_no` int DEFAULT NULL,
  `pub_no` int DEFAULT NULL,
  `ads_pic` blob NOT NULL,
  `weights` tinyint NOT NULL,
  PRIMARY KEY (`ads_no`),
  KEY `prod_no_idx` (`prod_no`),
  KEY `act_no_idx` (`act_no`),
  KEY `pub_no_idx` (`pub_no`),
  CONSTRAINT `act_no` FOREIGN KEY (`act_no`) REFERENCES `act` (`act_no`),
  CONSTRAINT `prod_no` FOREIGN KEY (`prod_no`) REFERENCES `prod` (`prod_no`),
  CONSTRAINT `pub_no1` FOREIGN KEY (`pub_no`) REFERENCES `pub` (`pub_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ----------------------假資料建立區----------------------
-- 建立 會員 假資料
insert into mem ( `mem_account`, `mem_password`, `mem_gender`,
 `mem_last_name`, `mem_first_name`, `mem_nickname`, `mem_tel_no`,
 `mem_cel_no`, `mem_email`, `mem_id`, `mem_birth`, `mem_addr`, `mem_permission`,
 `status`, `mem_cert_status`)
 values ('qwe123','asd321',1,'葉','柏宇','阿葉','02-12345678','0912345678','puvonote@altmails.com'
 ,'Z163574483','1992-01-11','新北市新莊區新豐街217號',0,0,1); 
 insert into mem ( `mem_account`, `mem_password`, `mem_gender`,
 `mem_last_name`, `mem_first_name`, `mem_nickname`, `mem_tel_no`,
 `mem_cel_no`, `mem_email`, `mem_id`, `mem_birth`, `mem_addr`, `mem_permission`,
 `status`, `mem_cert_status`)
 values ('1111586f','kgnwk3389g',0,'王','雅君','小君','02-37532145','0977351602','puxoriya@altmails.com'
 ,'F273145505','1994-11-25','台北市大安區安和路二段149巷10號7樓',1,0,0);
  insert into mem ( `mem_account`, `mem_password`, `mem_gender`,
 `mem_last_name`, `mem_first_name`, `mem_nickname`, `mem_tel_no`,
 `mem_cel_no`, `mem_email`, `mem_id`, `mem_birth`, `mem_addr`, `mem_permission`,
 `status`, `mem_cert_status`)
 values ('ee4225jpgj','gwklgj3532',2,'張','祐書','甲甲','02-47658769','0924678945','yuyaraza@altmails.com'
 ,'M190161355','1990-04-26','宜蘭縣宜蘭市東港路2段128巷10號',0,1,1);
 
-- 建立 優惠券 假資料
insert into coupon (`coupon_name`,`coupon_code`,`coupon_content`,`coupon_discount`,
`launch_time`,`off_time`,`status` )
VALUES ("半價優惠券", "ABCDE123", "針對香醇基酒全面半價",0.50, "2022-10-10 00:00:00", "2022-12-25 00:00:00", 0);
insert into coupon (`coupon_name`,`coupon_code`,`coupon_content`,`coupon_discount`,
`launch_time`,`off_time`,`status` )
VALUES ("85折優惠券", "ABCDE321", "針對調酒器材全面85折", 0.85, "2022-10-15 00:00:00", "2022-12-25 00:00:00", 0);
insert into coupon (`coupon_name`,`coupon_code`,`coupon_content`,`coupon_discount`,
`launch_time`,`off_time`,`status` )
VALUES ("90元優惠券", "ABCDE12345", "針對懶人包全面折90元", 90, "2022-10-20 00:00:00", "2022-12-25 00:00:00", 0);
-- 建立 會員優惠券 假資料
insert into mem_coupon (`coupon_no`, `mem_no`, `remain_amount`) values (1,1,2);
insert into mem_coupon (`coupon_no`, `mem_no`, `remain_amount`) values (2,2,4);
insert into mem_coupon (`coupon_no`, `mem_no`, `remain_amount`) values (3,3,1);

-- 建立 酒吧 假資料
INSERT INTO pub(mem_no, pub_status, pub_nop, pub_rate_sum, pub_ratetotal, pub_time, pub_application, pub_address, pub_open, pub_detail, pub_name, pub_lng, pub_lat, firm_name, firm_addr, firm_tel_no, firm_email, firm_tax_id, pub_application_M) 
VALUES ( '1', '0', '30', NULL, NULL, '2022-09-16 18:25:19', '0', '新北市新莊區中正路504號二樓', '000000000000000000001111000000000000000000001111000000000000000000001111000000000000000000001111000000000000000000001111000000000000000000001111000000000000000000000000', '酒吧X調酒X啤酒X炸物X消夜', '老地方236BAR', '1', '2', '老地方', '新北市新莊區中正路504號二樓', '0987654321', 'bar@gmail.com', '23225229', NULL);
INSERT INTO pub(mem_no, pub_status, pub_nop, pub_rate_sum, pub_ratetotal, pub_time, pub_application, pub_address, pub_open, pub_detail, pub_name, pub_lng, pub_lat, firm_name, firm_addr, firm_tel_no, firm_email, firm_tax_id, pub_application_M) 
VALUES ('1', '1', '55', NULL, NULL, '2022-09-17 00:00:00', '1', '台北市信義區忠孝東路五段372巷29弄2號', '000000000000000111111111000000000000000111111111000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111000000000000000111111111', 'Yup Cafe & Bistro 心創料理~座落於信義商圈與五分埔商圈交界，隱身在信義區安靜獨特的小巷弄中， 在被視為舊街區的巷弄裡，推廣歐式的餐點文化提供美味幸福的餐點給有個人特色與注重生活品質的人。堅持良心的飲食文化，追求傳統異國天然風味的烹調美食，每一道餐點都是現點現做細心烹調，主廚特調醬汁與料理完美地結合，料理充滿獨特多重口感。推薦西班牙海鮮燉飯、紅酒牛肉燉飯、明太子海鮮義大利麵、香辣墨魚義大利麵等以及各式排餐。特別推薦Yup拼盤 – 台灣特色鹹酥雞拼盤，讓庶民小吃也能在餐廳內享用!!', '聚序 Bar & Bistro', '1', '2', '聚序', '台北市信義區忠孝東路五段372巷29弄2號', '0911111222', 'twbar@gmail.com.tw', '23225229', '');
INSERT INTO pub(
mem_no, pub_status, pub_nop, pub_rate_sum, pub_ratetotal, pub_time, pub_application, pub_address, pub_open, pub_detail, pub_name, pub_lng, pub_lat, firm_name, firm_addr, firm_tel_no, firm_email, firm_tax_id, pub_application_M) 
VALUES ('1', '1', '70', NULL, NULL, '2022-09-17 00:00:00', '1', '桃園市中壢區大同路62號', '000000000001111111111110000000000001111111111110000000000001111111111110000000000000000000000000000000000001111111111110000000000001111111111110000000000001111111111110', '飛鏢酒吧,提供豐富的下午時光', '玖貳零920lounge bar', '1', '2', '玖貳零920lounge bar', '桃園市中壢區大同路62號', '0912345678', 'www@gmail.com.tw', '23225229', '');

-- 建立 酒吧照片 假資料
INSERT INTO pub_pics(
pub_no,
pub_pic) 
VALUES (1,'data:image/jpeg;base64,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');
INSERT INTO pub_pics(
pub_no,
pub_pic) 
VALUES (2,'data:image/jpeg;base64,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');
INSERT INTO pub_pics(
pub_no,
pub_pic) 
VALUES (3,'data:image/jpeg;base64,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');

-- 建立 商品種類 假資料
INSERT INTO prod_type (
prod_type_name)
VALUES ("香醇基酒");
INSERT INTO prod_type (
prod_type_name)
VALUES ("調酒器材");
INSERT INTO prod_type (
prod_type_name)
VALUES ("調酒懶人包");

-- 建立 商品 假資料
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (1, "麥卡倫威士忌", 6980, 20, null, "自始至終堅持培養自家雪莉桶的麥卡倫，不惜迢迢萬里路，堅持從西班牙製桶再將橡木桶運回蘇格蘭，顯然是對奢華有「絕對潔癖」的精神。我們也飛往西班牙抽絲剝繭追尋雪莉桶的價值，或許可找到「誰最珍貴」的正解。");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (1, "多利士紅酒", 1500, 30, "2023-01-01 08:10:10", "Miguel Torres Carbo (1909-1991) 對於品質的堅持與開拓國際市場的遠見都是讓TORRES(多利士)成功蛻變成為國際知名酒廠的大功臣之一。");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (1, "唐.胡立歐龍舌蘭", 1680, 20, "2024-01-01 08:10:10", "Don Julio 龍舌蘭酒是墨西哥頂級龍舌蘭酒的領導品牌，也是一位製酒大師60年來始終堅持完美的精心傑作。為了釀造滑順爽口的佳釀，從人工種植龍舌蘭到篩選陳年橡木桶，每個步驟都需嚴謹地遵循傳統。");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (1, "絕對伏特加", 680, 50, null, "Absolut Vodka在1979年於紐約問世，隨即便成為熱門話題，旋風橫掃美國，魅力風靡全球。但是，Absolut口感天然醇厚的秘密，其實已醞釀超過 30 載。");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (1, "高登琴酒", 880, 39, null, "Gordon’s Gin 高登琴酒主要原料為玉米與大麥，經過一次連續蒸餾後加入來自義大利托斯坎尼的高品質杜松子，胡荽籽與圓當歸根等慎選過後的香料做第二次的共同蒸餾，最後經過第三道蒸餾手續後加以稀釋在裝瓶。");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (1, "百加得蘭姆酒", 1280, 25, "2025-01-01 08:10:10", "這款酒使用獨家的木炭過濾法，再加上Facundo Bacardi 所研發的獨家配方，使得Bacardi較他牌蘭姆酒更加純淨 ，更具有獨特醇順口味。");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (2, "量酒器", 480, 80, null, "量酒器 Jigger 顧名思義就是用來測量倒入的液體份量，使用量酒器可以確保材料的比例精確，讓調酒品質穩定。");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (2, "隔冰器", 280, 100, null, "隔冰器一般可搭配 Boston Shaker 還有 Mixing Glass 使用，用以隔擋碎冰進入杯中。");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (2, "雪克杯", 2500, 56, null, "不銹鋼製、高質感的 YUKIWA 波士頓雪克杯，內部大空間可以容納各種酒液、水果、及其他材料，提供創意調飲的最大發揮空間。");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (2, "吧叉匙", 120, 120, null, "吧叉匙是用來攪拌混合酒液的必備道具，一般搭配 Mixing Glass 使用製作 Martini, Negroni 等調酒。");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (3, "蘭姆調酒懶人包", 3600, 30, null, "使用高品質百加得蘭姆酒再加上莓果、葡萄汁、青蘋果、檸檬，讓您不用去酒吧就能享受專業蘭姆調酒產品。(一份10入膠囊)");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (3, "龍舌蘭調酒懶人包", 3500, 20, null, "使用高品質唐.胡立歐龍舌蘭再加上鳳梨、百香果、檸檬，讓您不用去酒吧就能享受專業龍舌蘭調酒產品。(一份10入膠囊)");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (3, "威士忌調酒懶人包", 4200, 25, null, "使用高品質麥卡倫威士忌再加上濃縮咖啡、巧克力，讓您不用去酒吧就能享受專業威士忌調酒產品。(一份10入膠囊)");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (3, "琴酒調酒懶人包", 3600, 35, null, "使用高品質高登琴酒再加上橘子、葡萄柚口味苦精，讓您不用去酒吧就能享受專業琴酒調酒產品。(一份10入膠囊)");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (3, "伏特加調酒懶人包", 2600, 45, null, "使用高品質絕對伏特加再加上新鮮蘋果、肉桂，讓您不用去酒吧就能享受專業伏特加調酒產品。(一份10入膠囊)");

-- 建立 商品照片 假資料
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (1, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/whisky1.jpg"), "威士忌照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (1, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/whisky2.jpg"), "威士忌照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (1, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/whisky3.jpg"), "威士忌照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (2, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/wine1.jpg"), "紅酒照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (2, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/wine2.jpg"), "紅酒照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (2, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/wine3.jpg"), "紅酒照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (3, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/tequila1.jpg"), "龍舌蘭照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (3, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/tequila2.jpg"), "龍舌蘭照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (3, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/tequila3.jpg"), "龍舌蘭照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (4, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/vodka1.jpg"), "伏特加照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (4, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/vodka2.jpg"), "伏特加照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (4, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/vodka3.jpg"), "伏特加照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (5, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/gin1.jpg"), "琴酒照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (5, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/gin2.jpg"), "琴酒照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (5, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/gin3.jpg"), "琴酒照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (6, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/rum1.jpg"), "蘭姆酒照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (6, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/rum2.jpg"), "蘭姆酒照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (6, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/rum3.jpg"), "蘭姆酒照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (7, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/jigger1.jpg"), "量酒器照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (7, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/jigger2.jpg"), "量酒器照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (7, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/jigger3.jpg"), "量酒器照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (8, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/strainer1.jpg"), "隔冰器照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (8, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/strainer2.jpg"), "隔冰器照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (8, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/strainer3.jpg"), "隔冰器照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (9, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/shaker1.jpg"), "雪克杯照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (9, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/shaker2.jpg"), "雪克杯照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (9, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/shaker3.jpg"), "雪克杯照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (10, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/stirrer1.jpg"), "吧叉匙照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (10, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/stirrer2.jpg"), "吧叉匙照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (10, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/stirrer3.jpg"), "吧叉匙照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (11, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesRum1.png"), "蘭姆調酒懶人包照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (11, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesRum2.png"), "蘭姆調酒懶人包照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (11, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesRum3.png"), "蘭姆調酒懶人包照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (12, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesTeq1.png"), "龍舌蘭調酒懶人包照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (12, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesTeq2.png"), "龍舌蘭調酒懶人包照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (12, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesTeq3.png"), "龍舌蘭調酒懶人包照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (13, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesWh1.png"), "威士忌調酒懶人包照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (13, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesWh2.png"), "威士忌調酒懶人包照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (13, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesWh3.png"), "威士忌調酒懶人包照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (14, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesGin1.png"), "琴酒調酒懶人包照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (14, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesGin2.png"), "琴酒調酒懶人包照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (14, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesGin3.png"), "琴酒調酒懶人包照片3");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (15, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesVod1.png"), "伏特加調酒懶人包照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (15, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesVod2.png"), "伏特加調酒懶人包照片2");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (15, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/capsulesVod3.png"), "伏特加調酒懶人包照片3");


-- 建立 訂單 假資料
INSERT INTO `order` (
mem_no, 
coupon_no,
order_price_total,
dis_price_total,
payment_method,
pickup_method,
shipping_fee,
receiver_name,
receiver_address,
receiver_phone)
VALUES (1, 1, 6980, 3490, 0, 0, 0, "葉柏宇", "新北市新莊區新豐街217號", "0912345678");
INSERT INTO `order` (
mem_no, 
coupon_no,
order_price_total,
dis_price_total,
payment_method,
pickup_method,
shipping_fee,
receiver_name,
receiver_address,
receiver_phone)
VALUES (2, 2, 960, 816, 1, 1, 1, "王雅君", "台北市大安區安和路二段149巷10號7樓", "0977351602");
INSERT INTO `order` (
mem_no, 
coupon_no,
order_price_total,
dis_price_total,
payment_method,
pickup_method,
shipping_fee,
receiver_name,
receiver_address,
receiver_phone)
VALUES (3, 3, 3600, 3510, 0, 2, 0, "張祐書", "宜蘭縣宜蘭市東港路2段128巷10號", "0924678945");

-- 建立 訂單明細 假資料
INSERT INTO order_detail (
order_no,
prod_no,
prod_qty,
prod_price,
mem_no )
VALUES (1, 1, 1, 6980, 1);
INSERT INTO order_detail (
order_no,
prod_no,
prod_qty,
prod_price,
mem_no )
VALUES (2, 7, 2, 480, 2);
INSERT INTO order_detail (
order_no,
prod_no,
prod_qty,
prod_price,
mem_no )
VALUES (3, 11, 1, 3600, 3);

-- 建立 購物車 假資料
INSERT INTO cart (
mem_no,
prod_no,
prod_qty)
VALUES (1, 1, 1);
INSERT INTO cart (
mem_no,
prod_no,
prod_qty)
VALUES (2, 7, 2);
INSERT INTO cart (
mem_no,
prod_no,
prod_qty)
VALUES (3, 11, 1);

-- 建立 管理員 假資料
INSERT INTO manager(
mng_no,
mng_account,
mng_password,
mng_name,
mng_phone,
mng_pic,
mng_status)
VALUES(1, "manager1", "1234", "醉拳甘迺迪", "0910000001", null, 1);
INSERT INTO manager(
mng_no,
mng_account,
mng_password,
mng_name,
mng_phone,
mng_pic,
mng_status)
VALUES(2, "manager2", "2234", "古拉格斯", "0920000002", null, 0);
INSERT INTO manager(
mng_no,
mng_account,
mng_password,
mng_name,
mng_phone,
mng_pic,
mng_status)
VALUES(3, "manager3", "3234", "龍舌蘭姑娘", "0930000003", null, 1);

-- 建立 管理員權限 假資料
INSERT INTO manager_authfunc(
mng_authfunc_no,
mng_authfunc_name)
VALUE (1, "全部");
INSERT INTO manager_authfunc(
mng_authfunc_no,
mng_authfunc_name)
VALUE (2, "管理員資料管理");
INSERT INTO manager_authfunc(
mng_authfunc_no,
mng_authfunc_name)
VALUE (3, "前台網站管理");

-- 建立 權限明細 假資料
INSERT INTO manager_auth(
mng_no,
mng_authfunc_no)
VALUES(1, 1);
INSERT INTO manager_auth(
mng_no,
mng_authfunc_no)
VALUES(2, 2);
INSERT INTO manager_auth(
mng_no,
mng_authfunc_no)
VALUES(3, 3);

-- 建立 客服聊天室 假資料
INSERT INTO customer_chat_room(
SN,
mng_no,
mem_no,
prod_no,
message,
mem_question_pic,
message_chat_time,
chat_direction)
VALUES(1, 1, 1, 1, "假酒害人", null, now(), 0);
INSERT INTO customer_chat_room(
SN,
mng_no,
mem_no,
prod_no,
message,
mem_question_pic,
message_chat_time,
chat_direction)
VALUES(2, 2, 2, 2, "濃度太低", null, now(), 1);
INSERT INTO customer_chat_room(
SN,
mng_no,
mem_no,
prod_no,
message,
mem_question_pic,
message_chat_time,
chat_direction)
VALUES(3, 3, 3, 3, "推薦喝生命之水", null, now(), 0);

-- 建立 問題回報 假資料
INSERT INTO customer_feedback(
SN,
mem_no,
order_no,
prod_no,
pub_no,
act_no,
mng_no,
feedback_status)
VALUES(1, 1, 1, 1, 1, 1, 1, 0);
INSERT INTO customer_feedback(
SN,
mem_no,
order_no,
prod_no,
pub_no,
act_no,
mng_no,
feedback_status)
VALUES(2, 2, 2, 2, 2, 2, 2, 1);
INSERT INTO customer_feedback(
SN,
mem_no,
order_no,
prod_no,
pub_no,
act_no,
mng_no,
feedback_status)
VALUES(3, 3, 3, 3, 3, 3, 3, 1);

-- 建立 活動 假資料
INSERT INTO act(
pub_no, act_name, act_detail, act_loc, act_launch_time, act_off_time, max_count, min_count, sign_up_begin_time, sign_up_end_time, act_start_time, act_end_time
)values("1","調酒品嘗","先欣賞一下，看看雞尾酒的顏色與裝飾，猜想一下這杯調酒會有怎樣的口感？並在細聞香味後抱著迫不及待的心，品嘗一下酒在低溫時的口感。","桃園","2022-10-10 10:10:10","2022-11-11 11:11:11","60","20","2022-11-11 12:12:12","2022-11-11 13:13:13","2022-11-11 14:14:14","2022-11-11 15:15:15");
INSERT INTO act(
pub_no, act_name, act_detail, act_loc, act_launch_time, act_off_time, max_count, min_count, sign_up_begin_time, sign_up_end_time, act_start_time, act_end_time
)values("2","調酒教學","教學自己在家就能動手做的4款調酒，還有隱藏版柯夢波丹雞尾酒教學！","台北","2023-10-10 10:10:10","2023-11-11 11:11:11","30","10","2023-11-11 12:12:12","2023-11-11 13:13:13","2023-11-11 14:14:14","2023-11-11 15:15:15");
INSERT INTO act(
pub_no, act_name, act_detail, act_loc, act_launch_time, act_off_time, max_count, min_count, sign_up_begin_time, sign_up_end_time, act_start_time, act_end_time
)values("3","花式調酒","花式調酒是由調酒師利用酒瓶以及任何調酒器具、杯具做出絢麗動作演變而來。","高雄","2024-10-10 10:10:10","2024-11-11 11:11:11","1000","1","2024-11-11 12:12:12","2024-11-11 13:13:13","2024-11-11 14:14:14","2024-11-11 15:15:15");

-- 建立 活動照片 假資料
INSERT INTO act_pic(
act_no, act_pic, act_pic_name
)values(1,LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/1.png"),"調酒品嘗圖片1");
INSERT INTO act_pic(
act_no, act_pic, act_pic_name
)values(2,LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/2.png"),"調酒教學圖片1");
INSERT INTO act_pic(
act_no, act_pic, act_pic_name
)values(3,LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/3.png"),"花式調酒圖片1");

-- 建立 活動報名 假資料
INSERT INTO act_sign_up(
act_no, mem_no, accompany_count
)values(1,1,0);
INSERT INTO act_sign_up(
act_no, mem_no, accompany_count
)values(2,2,0);
INSERT INTO act_sign_up(
act_no, mem_no, accompany_count
)values(3,3,0);

-- 建立 廠商問卷 假資料
INSERT INTO firm_survey(
act_no
)values(1);
INSERT INTO firm_survey(
act_no
)values(2);
INSERT INTO firm_survey(
act_no
)values(3);

-- 建立 題目 假資料
INSERT INTO question(
que
)values("本次活動好玩嗎?");
INSERT INTO question(
que
)values("對本活動有任何感想嗎?");
INSERT INTO question(
que
)values("1~10分給本活動幾分?");

-- 建立 題目清單 假資料
INSERT INTO question_list(
question_no, firm_survey_no
)values(1,1);
INSERT INTO question_list(
question_no, firm_survey_no
)values(2,2);
INSERT INTO question_list(
question_no, firm_survey_no
)values(3,3);

-- 建立 答案清單 假資料
INSERT INTO ans_list(
question_no, firm_survey_no, mem_no, ans
)values(1,1,1,"還好");
INSERT INTO ans_list(
question_no, firm_survey_no, mem_no, ans
)values(2,2,2,"時間安排再加強");
INSERT INTO ans_list(
question_no, firm_survey_no, mem_no, ans
)values(3,3,3,"10分");

-- 建立 討論區 假資料
INSERT INTO forum(
frm_name_no,
frm_status,
frm_img
)values("活動討論區",1, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/pub-activity.jpeg"));
INSERT INTO forum(
frm_name_no,
frm_status,
frm_img
)values("揪團討論區",1, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/pub7.webp"));
INSERT INTO forum(
frm_name_no,
frm_status,
frm_img
)values("商品討論區",1, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/pub10.jpeg"));

-- 建立 討論區文章 假資料
INSERT INTO forum_article(
frm_no,
mem_no,
art_title,
art_content,
art_img,
art_status
)values(1,1,"夏日調酒節","XXXXXXXXXXXXXX","null",1);
INSERT INTO forum_article(
frm_no,
mem_no,
art_title,
art_content,
art_img,
art_status
)values(2,2,"春天調酒節","XXXXXXXXXXXXXX","null",1);
INSERT INTO forum_article(
frm_no,
mem_no,
art_title,
art_content,
art_img,
art_status
)values(3,3,"秋冬調酒節","XXXXXXXXXXXXXX","null",1);

-- 建立 討論區文章檢舉 假資料
INSERT INTO forum_article_report(
mem_no,
frm_art_no,
rpt_content,
mng_no,
rpt_status,
rpt_result,
rpt_note
)values(1,1,"文章內容涉及歧視",1,"1","1","內容違反相關規範");
INSERT INTO forum_article_report(
mem_no,
frm_art_no,
rpt_content,
mng_no,
rpt_status,
rpt_result,
rpt_note
)values(2,2,"文章內容涉及性騷擾",1,"1","1","內容違反相關規範");
INSERT INTO forum_article_report(
mem_no,
frm_art_no,
rpt_content,
mng_no,
rpt_status,
rpt_result,
rpt_note
)values(3,3,"文章內容涉及暴力",1,"1","1","內容違反相關規範");

-- 建立 文章留言 假資料
INSERT INTO article_message(
mem_no,
frm_art_no,
msg_content
) VALUES (1,1,"這個活動的小姐身材好好");
INSERT INTO article_message(
mem_no,
frm_art_no,
msg_content
) VALUES (2,2,"好好玩");
INSERT INTO article_message(
mem_no,
frm_art_no,
msg_content
) VALUES (3,3,"我好帥");

-- 建立 文章留言檢舉 假資料
INSERT INTO article_message_report(
mem_no,
art_msg_no,
rpt_msg_content,
mng_no,
msg_states,
msg_result,
msg_note
) VALUES (1,1,"涉及性騷擾",1,1,1,"符合檢舉");
INSERT INTO article_message_report(
mem_no,
art_msg_no,
rpt_msg_content,
mng_no,
msg_states,
msg_result,
msg_note
) VALUES (2,2,"涉及暴力",1,1,1,"符合檢舉");
INSERT INTO article_message_report(
mem_no,
art_msg_no,
rpt_msg_content,
mng_no,
msg_states,
msg_result,
msg_note
) VALUES (3,3,"垃圾訊息",1,1,1,"符合檢舉");

INSERT INTO latest_news(
news_content,
news_status
) VALUES ('揪團柬埔寨喝酒活動', 1);
INSERT INTO latest_news(
news_content,
news_status
) VALUES ('爸爸媽媽動起來', 1);
INSERT INTO latest_news(
news_content,
news_status
) VALUES ('搖起來搖起來', 1);

-- 建立 推播廣告 假資料
insert into push_ads (`prod_no`, `ads_content`, `ads_pic`, `weights`)
values ('1','商品','34gdfhrs3',0);
insert into push_ads ( `ads_content`, `act_no`, `ads_pic`, `weights`)
values ('活動',2,'38n82rfu982',5);
insert into push_ads ( `ads_content`, `pub_no`, `ads_pic`, `weights`)
values ('酒吧',3,'eff2j308y23',3);