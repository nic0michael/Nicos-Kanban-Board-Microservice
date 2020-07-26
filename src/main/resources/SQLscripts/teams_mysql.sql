DROP TABLE IF EXISTS team;

-- SHOW CREATE TABLE `team`;   
CREATE TABLE `team` (
  `team_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`team_id`),
  UNIQUE KEY `UK_g2l9qqsoeuynt4r5ofdt1x2td` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


INSERT INTO team(name, is_active,date_created) VALUES('Front-end developers','Y','2020-06-17T16:17:59.304');
INSERT INTO team(name, is_active,date_created) VALUES('Back-end developers','Y','2020-06-17T16:17:59.304');


