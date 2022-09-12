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
-- 會員
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
-- 酒吧
CREATE TABLE pub (
    pub_no INT AUTO_INCREMENT NOT NULL,
    mem_no INT NOT NULL,
    pub_status TINYINT NOT NULL DEFAULT '0',
    pub_nop INT NOT NULL,
    pub_rate_sum INT,
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
    CONSTRAINT pub_no_PK PRIMARY KEY (pub_no),
    CONSTRAINT `pub.mem_no_FK` FOREIGN KEY (mem_no)
        REFERENCES mem (mem_no)
);

-- 酒吧照片
CREATE TABLE `pub_pics` (
  `pub_pic_no` int NOT NULL AUTO_INCREMENT,
  `pub_no` int NOT NULL,
  `pub_pic` MediumBlob NOT NULL,
  PRIMARY KEY (`pub_pic_no`),
  KEY `pub_no_FK_idx` (`pub_no`),
  CONSTRAINT `pub_pics.pub_no_FK` FOREIGN KEY (`pub_no`) REFERENCES `pub` (`pub_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 酒吧評價
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

-- 會員訂位
CREATE TABLE `pub_booking` (
  `pub_booking_no` int NOT NULL AUTO_INCREMENT,
  `pub_no` int NOT NULL,
  `mem_no` int NOT NULL,
  `pub_booking_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `pub_booking_time` char(24),
  `pub_booking_status` tinyint NOT NULL,
  PRIMARY KEY (`pub_booking_no`),
  KEY `pub_no_FK_idx` (`pub_no`),
  KEY `mem_no_FK_idx` (`mem_no`),
  CONSTRAINT `pub_booking.mem_no_FK_1` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`),
  CONSTRAINT `pub_booking.pub_no_FK_1` FOREIGN KEY (`pub_no`) REFERENCES `pub` (`pub_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 酒吧訂位
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

-- 優惠券 
CREATE TABLE `coupon` (
  `coupon_no` int NOT NULL AUTO_INCREMENT,
  `coupon_name` varchar(20) NOT NULL,
  `coupon_code` varchar(10) NOT NULL,
  `coupon_content` varchar(100) NOT NULL,
  `coupon_discount` double NOT NULL,
  `coupon_amount` tinyint NOT NULL,
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
  `order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sold_time` timestamp,
  `order_price_total` int NOT NULL,
  `dis_price_total` int NOT NULL,
  `order_status` tinyint NOT NULL DEFAULT '0',
  `payment_method` tinyint NOT NULL,
  `pickup_method` tinyint NOT NULL,
  `shipping_fee` tinyint NOT NULL,
  `tracking_no` int NOT NULL,
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
  `comment_time` timestamp,
  `comment_star` tinyint DEFAULT NULL,
  `comment_content` varchar(100) DEFAULT NULL,
  `comment_pic` longblob,
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
    `current_count` INT NOT NULL,
    `max_count` INT NOT NULL,
    `min_count` INT NOT NULL,
    `sign_up_begin_time` DATETIME NOT NULL,
    `sign_up_end_time` DATETIME NOT NULL,
    `act_start_time` DATETIME NOT NULL,
    `act_end_time` DATETIME NOT NULL,
    `act_status` TINYINT NOT NULL DEFAULT '0',
    `apply_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `apply_status` TINYINT NOT NULL DEFAULT '0',

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
    `act_pic` BLOB,
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

-- 討論區
CREATE TABLE `forum` (
  `frm_no` int NOT NULL,
  `frm_name_no` varchar(200) DEFAULT NULL,
  `frm_status` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`frm_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 討論區文章
CREATE TABLE `forum_article` (
  `frm_art_no` int NOT NULL AUTO_INCREMENT,
  `frm_no` int NOT NULL,
  `mem_no` int NOT NULL,
  `art_time` datetime NOT NULL,
  `art_title` varchar(100) NOT NULL,
  `art_content` varchar(1000) NOT NULL,
  `art_img` blob,
  `art_status` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`frm_art_no`),
  KEY `frm_no_idx` (`frm_no`),
  CONSTRAINT `frm_no_FK` FOREIGN KEY (`frm_no`) REFERENCES `forum` (`frm_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 討論區文章檢舉
CREATE TABLE `forum_article_report` (
  `frm_art_rpt_no` int NOT NULL,
  `mem_no` int NOT NULL,
  `frm_art_no` int NOT NULL,
  `rpt_time` datetime NOT NULL,
  `rpt_content` varchar(1000) NOT NULL,
  `mng_no` int DEFAULT NULL,
  `rpt_done_time` datetime DEFAULT NULL,
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

-- 文章留言
CREATE TABLE `article_message` (
  `art_msg_no` int NOT NULL AUTO_INCREMENT,
  `mem_no` int NOT NULL,
  `frm_art_no` int NOT NULL,
  `msg_time` datetime NOT NULL,
  `msg_content` varchar(1000) NOT NULL,
  PRIMARY KEY (`art_msg_no`),
  KEY `mem_no_FK_idx` (`mem_no`),
  KEY `frm_art_no_FK_idx` (`frm_art_no`),
  CONSTRAINT `art_msg_frm_art_no_FK` FOREIGN KEY (`frm_art_no`) REFERENCES `forum_article` (`frm_art_no`),
  CONSTRAINT `art_msg_mem_no_FK` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 文章留言檢舉
CREATE TABLE `article_message_report` (
  `art_msg_rpt` int NOT NULL AUTO_INCREMENT,
  `mem_no` int NOT NULL,
  `art_msg_no` int NOT NULL,
  `rpt_time` datetime NOT NULL,
  `rpt_msg_content` varchar(1000) NOT NULL,
  `mng_no` int DEFAULT NULL,
  `msg_done_time` datetime DEFAULT NULL,
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

-- 最新消息
CREATE TABLE `latest_news` (
  `latest_news_no` int NOT NULL AUTO_INCREMENT,
  `news_content` varchar(1000) NOT NULL,
  `news_status` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`latest_news_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 會員優惠券
CREATE TABLE `mem_coupon` (
  `coupon_no` int NOT NULL,
  `mem_no` int NOT NULL,
  `remain_amount` int NOT NULL,
  PRIMARY KEY (`coupon_no`,`mem_no`),
  KEY `mem_no_idx` (`mem_no`),
  CONSTRAINT `coupon_no` FOREIGN KEY (`coupon_no`) REFERENCES `coupon` (`coupon_no`),
  CONSTRAINT `mem_no_PK_FK` FOREIGN KEY (`mem_no`) REFERENCES `mem` (`mem_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 推播廣告
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
`coupon_amount`,`launch_time`,`off_time`,`status` )
VALUES ("半價優惠券", "ABCDE123", "針對酒類商品全面半價",0.50, 50, "2022-10-10 00:00:00", "2022-12-25 00:00:00", 0);

insert into coupon (`coupon_name`,`coupon_code`,`coupon_content`,`coupon_discount`,
`coupon_amount`,`launch_time`,`off_time`,`status` )
VALUES ("85折優惠券", "ABCDE321", "針對調酒器材全面85折", 0.85, 50, "2022-10-15 00:00:00", "2022-12-25 00:00:00", 0);

insert into coupon (`coupon_name`,`coupon_code`,`coupon_content`,`coupon_discount`,
`coupon_amount`,`launch_time`,`off_time`,`status` )
VALUES ("90元優惠券", "ABCDE12345", "針對調酒材料全面折90元", 90, 50, "2022-10-20 00:00:00", "2022-12-25 00:00:00", 0);

-- 建立 會員優惠券 假資料
insert into mem_coupon (`coupon_no`, `mem_no`, `remain_amount`) values (1,1,2);
insert into mem_coupon (`coupon_no`, `mem_no`, `remain_amount`) values (2,3,4);
insert into mem_coupon (`coupon_no`, `mem_no`, `remain_amount`) values (3,2,1);

INSERT INTO pub(
mem_no,
pub_nop,
pub_address,
pub_open,
pub_detail,
pub_name,
pub_lng,
pub_lat) 
VALUES (1,'100',"新北市XXX","00000","喝酒","酒吧一號","123.222","111.222");
INSERT INTO pub(
mem_no,
pub_nop,
pub_address,
pub_open,
pub_detail,
pub_name,
pub_lng,
pub_lat) 
VALUES (2,'100',"桃園市XXX","00000","喝酒","酒吧二號","123.222","111.222");
INSERT INTO pub(
mem_no,
pub_nop,
pub_address,
pub_open,
pub_detail,
pub_name,
pub_lng,
pub_lat) 
VALUES (3,'100',"新竹市XXX","00000","喝酒","酒吧三號","123.222","111.222");

-- 酒吧照片
INSERT INTO pub_pics(
pub_no,
pub_pic) 
VALUES (1,'data:image/jpeg;base64,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');


INSERT INTO pub_pics(
pub_no,
pub_pic) 
VALUES (2,'data:image/png;base64,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');

INSERT INTO pub_pics(
pub_no,
pub_pic) 
VALUES (3,'data:image/png;base64,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');

-- 酒吧評價
INSERT INTO pub_rank(
pub_no,
mem_no,
pub_rate,
pub_comment) 
VALUES (1,1,10,"e04");


INSERT INTO pub_rank(
pub_no,
mem_no,
pub_rate,
pub_comment) 
VALUES (2,1,10,"su3");

INSERT INTO pub_rank(
pub_no,
mem_no,
pub_rate,
pub_comment) 
VALUES (3,1,10,"su;6");

INSERT INTO pub_booking(
pub_no,
mem_no,
pub_booking_time,
pub_booking_status) 
VALUES (1,1,"00000000110000000000",0);
INSERT INTO pub_booking(
pub_no,
mem_no,
pub_booking_time,
pub_booking_status) 
VALUES (2,2,"000000001100000000000000",0);
INSERT INTO pub_booking(
pub_no,
mem_no,
pub_booking_time,
pub_booking_status) 
VALUES (3,3,"000000001100000000000000",0);

INSERT INTO pub_reservation(
pub_no,
pub_available,
pub_reservation_date) 
VALUES (1,"00000000000000","2022-08-18");
INSERT INTO pub_reservation(
pub_no,
pub_available,
pub_reservation_date) 
VALUES (1,"00000000000000","2022-08-19");
INSERT INTO pub_reservation(
pub_no,
pub_available,
pub_reservation_date) 
VALUES (1,"00000000000000","2022-08-20");

-- 建立 商品種類 假資料
INSERT INTO prod_type (
prod_type_name)
VALUES ("威士忌");
INSERT INTO prod_type (
prod_type_name)
VALUES ("紅酒");
INSERT INTO prod_type (
prod_type_name)
VALUES ("調酒器材");

-- 建立 商品 假資料
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (1, "Macallan", 10000, 10, null, "自始至終堅持培養自家雪莉桶的麥卡倫，不惜迢迢萬里路，堅持從西班牙製桶再將橡木桶運回蘇格蘭，顯然是對奢華有「絕對潔癖」的精神。我們也飛往西班牙抽絲剝繭追尋雪莉桶的價值，或許可找到「誰最珍貴」的正解。來自蘇格蘭斯佩塞的經典風土，雪莉桶威士忌嚐來好似沉甸甸野餐籃裡的果乾、果醬與生薑巧克力，十足討人喜歡！當「雪莉桶風味」威士忌成為一種流行，麥卡倫的「正統」色彩便立於威士忌迷心中不可撼動的地位。");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (2, "Familia Torres", 5000, 6, "2023-01-01 08:10:10", "Miguel Torres Carbo (1909-1991) 對於品質的堅持與開拓國際市場的遠見都是讓TORRES成功蛻變成為國際知名酒廠的大功臣之一。他從幫忙送酒給餐廳的基層工作做起，經歷了西班牙內戰與二次世界大戰對酒廠造成的損害，1939年酒廠甚至受到了炸彈的攻擊，在一片殘破磚瓦當中Miguel Torres Carbo與妻子Dona Margarita一步一步讓TORRES酒廠重新振作。在Miguel Torres Carbo經營期間，他不但擴張了葡萄園的面積，也開始自己裝瓶，更創造了許多有名的系列像是Vina Sol、Gran Vina Sol、Sangre de Toro、Coronas 還有在台灣非常受到歡迎的Esmeralda。");
INSERT INTO prod (
prod_type_no,
prod_name,
prod_price,
prod_stock,
off_time,
prod_detail )
VALUES (3, "Leopold", 1000, 50, null, "Cocktail Kingdom offers their signature Leopold jiggers in two sizes and a number of different finishes. A one-ounce/two-ounce jigger is the go-to for many bartenders, so we’d recommend opting for the 30-milliliter/60-milliliter size.");

-- 建立 商品照片 假資料
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (1, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/cocktail.jpg"), "麥卡倫照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (2, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/wine.jpg"), "紅酒照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (3, LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/jigger.jpg"), "Jigger照片1");
INSERT INTO prod_pic (
prod_no,
prod_pic,
prod_pic_name )
VALUES (3, null, "無照片");

-- 建立 訂單 假資料
INSERT INTO `order` (
mem_no, 
coupon_no,
sold_time,
order_price_total,
dis_price_total,
order_status,
payment_method,
pickup_method,
shipping_fee,
tracking_no,
receiver_name,
receiver_address,
receiver_phone)
VALUES (1, 1, null, 1776, 888, 0, 1, 2, 0, 123456, "韋小寶", "鹿頂街38號", "091234567");
INSERT INTO `order` (
mem_no, 
coupon_no,
sold_time,
order_price_total,
dis_price_total,
order_status,
payment_method,
pickup_method,
shipping_fee,
tracking_no,
receiver_name,
receiver_address,
receiver_phone)
VALUES (2, 2, null, 17766, 8883, 0, 1, 2, 0, 123456, "韋大寶", "妳心裡", "097654321");
INSERT INTO `order` (
mem_no, 
coupon_no,
sold_time,
order_price_total,
dis_price_total,
order_status,
payment_method,
pickup_method,
shipping_fee,
tracking_no,
receiver_name,
receiver_address,
receiver_phone)
VALUES (3, 3, null, 17776, 8888, 0, 1, 2, 0, 123456, "你老婆", "隔壁小王的床上", "0988888888");

-- 建立 訂單明細 假資料
INSERT INTO order_detail (
order_no,
prod_no,
prod_qty,
prod_price,
mem_no,
comment_time,
comment_star,
comment_content,
comment_pic )
VALUES (1, 1, 10, 10000, 1, "2022-08-08 08:08:08", 5, "OMG太好喝了吧", LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/home.png"));
INSERT INTO order_detail (
order_no,
prod_no,
prod_qty,
prod_price,
mem_no,
comment_time,
comment_star,
comment_content,
comment_pic )
VALUES (2, 2, 100, 1000, 2, "2022-06-06 06:06:06", 2, "這什麼啦嘰東西啦！", LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/search2.png"));
INSERT INTO order_detail (
order_no,
prod_no,
prod_qty,
prod_price,
mem_no,
comment_time,
comment_star,
comment_content,
comment_pic )
VALUES (3, 3, 88888, 88888, 3, "2022-08-08 08:08:08", 3, "我就是土豪花錢不手軟，咬我啊！", LOAD_FILE("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/shopping-cart.png"));

-- 建立 購物車 假資料
INSERT INTO cart (
mem_no,
prod_no,
prod_qty)
VALUES (1, 1, 10);
INSERT INTO cart (
mem_no,
prod_no,
prod_qty)
VALUES (2, 2, 100);
INSERT INTO cart (
mem_no,
prod_no,
prod_qty)
VALUES (3, 3, 88888);

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
pub_no, act_name, act_detail, act_loc, act_launch_time, act_off_time, current_count, max_count, min_count, sign_up_begin_time, sign_up_end_time, act_start_time, act_end_time, act_status, apply_status
)values("1","我想死","揪團自殺","懸崖邊","2022-10-10 10:10:10","2022-11-11 11:11:11","0","60","20","2022-11-11 12:12:12","2022-11-11 13:13:13","2022-11-11 14:14:14","2022-11-11 15:15:15",0,0);
INSERT INTO act(
pub_no, act_name, act_detail, act_loc, act_launch_time, act_off_time, current_count, max_count, min_count, sign_up_begin_time, sign_up_end_time, act_start_time, act_end_time, act_status, apply_status
)values("2","我好累","天台集合","九樓","2023-10-10 10:10:10","2023-11-11 11:11:11","0","30","10","2023-11-11 12:12:12","2023-11-11 13:13:13","2023-11-11 14:14:14","2023-11-11 15:15:15",0,0);
INSERT INTO act(
pub_no, act_name, act_detail, act_loc, act_launch_time, act_off_time, current_count, max_count, min_count, sign_up_begin_time, sign_up_end_time, act_start_time, act_end_time, act_status, apply_status
)values("3","柬埔寨","詐騙集團","新園區","2024-10-10 10:10:10","2024-11-11 11:11:11","0","1000","1","2024-11-11 12:12:12","2024-11-11 13:13:13","2024-11-11 14:14:14","2024-11-11 15:15:15",0,0);

-- 建立 活動照片 假資料
INSERT INTO act_pic(
act_no, act_pic, act_pic_name
)values(1,null,"累");
INSERT INTO act_pic(
act_no, act_pic, act_pic_name
)values(2,null,"死");
INSERT INTO act_pic(
act_no, act_pic, act_pic_name
)values(3,null,"了");

-- 建立 活動報名 假資料
INSERT INTO act_sign_up(
act_no, mem_no, accompany_count, sign_up_status
)values(1,1,0,0);
INSERT INTO act_sign_up(
act_no, mem_no, accompany_count, sign_up_status
)values(2,2,0,0);
INSERT INTO act_sign_up(
act_no, mem_no, accompany_count, sign_up_status
)values(3,3,0,0);

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
)values("搞笑嗎");
INSERT INTO question(
que
)values("幾點了");
INSERT INTO question(
que
)values("柬埔寨好玩嗎");

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
)values(2,2,2,"十點");
INSERT INTO ans_list(
question_no, firm_survey_no, mem_no, ans
)values(3,3,3,"很好玩");

-- 建立 討論區 假資料
INSERT INTO forum(
frm_no,
frm_name_no,
frm_status
)values(1,"活動討論區",1);
INSERT INTO forum(
frm_no,
frm_name_no,
frm_status
)values(2,"商品討論區",1);
INSERT INTO forum(
frm_no,
frm_name_no,
frm_status
)values(3,"酒吧討論區",1);

-- 建立 討論區文章 假資料
INSERT INTO forum_article(
frm_no,
mem_no,
art_time,
art_title,
art_content,
art_img,
art_status
)values(1,1,"2023-11-11 11:11:11","夏日調酒節","XXXXXXXXXXXXXX","null",1);
INSERT INTO forum_article(
frm_no,
mem_no,
art_time,
art_title,
art_content,
art_img,
art_status
)values(2,2,"2024-11-11 11:11:11","夏日調酒節","XXXXXXXXXXXXXX","null",1);
INSERT INTO forum_article(
frm_no,
mem_no,
art_time,
art_title,
art_content,
art_img,
art_status
)values(3,3,"2025-11-11 11:11:11","夏日調酒節","XXXXXXXXXXXXXX","null",1);

-- 建立 討論區文章檢舉 假資料
INSERT INTO forum_article_report(
frm_art_rpt_no,
mem_no,
frm_art_no,
rpt_time,
rpt_content,
mng_no,
rpt_done_time,
rpt_status,
rpt_result,
rpt_note
)values(1,1,1,"2023-11-11 11:11:11","文章內容涉及歧視",1,"2023-11-11 11:11:11","1","1","內容違反相關規範");
INSERT INTO forum_article_report(
frm_art_rpt_no,
mem_no,
frm_art_no,
rpt_time,
rpt_content,
mng_no,
rpt_done_time,
rpt_status,
rpt_result,
rpt_note
)values(2,2,2,"2024-11-11 11:11:11","文章內容涉及歧視",1,"2024-11-11 11:11:11","1","1","內容違反相關規範");
INSERT INTO forum_article_report(
frm_art_rpt_no,
mem_no,
frm_art_no,
rpt_time,
rpt_content,
mng_no,
rpt_done_time,
rpt_status,
rpt_result,
rpt_note
)values(3,3,3,"2025-11-11 11:11:11","文章內容涉及歧視",1,"2025-11-11 11:11:11","1","1","內容違反相關規範");

-- 建立 文章留言 假資料
INSERT INTO article_message(
mem_no,
frm_art_no,
msg_time,
msg_content
) VALUES (1,1,"2023-11-11 11:11:11","這個活動的小姐身材好好");
INSERT INTO article_message(
mem_no,
frm_art_no,
msg_time,
msg_content
) VALUES (2,2,"2024-11-11 11:11:11","好好玩");
INSERT INTO article_message(
mem_no,
frm_art_no,
msg_time,
msg_content
) VALUES (3,3,"2025-11-11 11:11:11","我好帥");

-- 建立 文章留言檢舉 假資料
INSERT INTO article_message_report(
mem_no,
art_msg_no,
rpt_time,
rpt_msg_content,
mng_no,
msg_done_time,
msg_states,
msg_result,
msg_note
) VALUES (1,1,"2023-11-11 11:11:11","涉及性騷擾",1,"2023-11-11 11:11:11",1,1,"符合檢舉");
INSERT INTO article_message_report(
mem_no,
art_msg_no,
rpt_time,
rpt_msg_content,
mng_no,
msg_done_time,
msg_states,
msg_result,
msg_note
) VALUES (2,2,"2024-11-11 11:11:11","涉及暴力ˋ",1,"2024-11-11 11:11:11",1,1,"符合檢舉");
INSERT INTO article_message_report(
mem_no,
art_msg_no,
rpt_time,
rpt_msg_content,
mng_no,
msg_done_time,
msg_states,
msg_result,
msg_note
) VALUES (3,3,"2025-11-11 11:11:11","垃圾訊息",1,"2025-11-11 11:11:11",1,1,"符合檢舉");

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