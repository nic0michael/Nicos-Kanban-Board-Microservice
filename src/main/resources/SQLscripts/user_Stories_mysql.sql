-- SHOW CREATE TABLE `user_story`;
DROP TABLE IF EXISTS user_story;
CREATE TABLE `user_story` (
  `user_story_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `epic_id` bigint(20) DEFAULT NULL,
  `assigned_to` bigint(20) DEFAULT NULL,
  `stage` varchar(255) DEFAULT NULL,
  `customer_reference` varchar(255) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_story_id`),
  UNIQUE KEY `UK_5w32xyy51n1h2yesbawuntbo5` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


-- INSERT user_story 			
insert into user_story ( name, epic_id, assigned_to, stage, description, date_created) values ( 'Large Production Deploy',1,1, 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production','2020-06-17T16:17:59.304');
insert into user_story ( name, epic_id, assigned_to, stage, description, date_created) values ( 'New Employee Budget',2,2,  'COMPLETED', 'Decide on a new employee bonus budget for the year and figureout who will be promoted','2020-06-17T16:17:59.304');
insert into user_story ( name, epic_id, assigned_to, stage,  description, date_created) values ( 'Office Reconstruction',3,3, 'INPROGRESS', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed','2020-06-17T16:17:59.304');
insert into user_story ( name, epic_id, assigned_to, stage,  description, date_created) values ( 'Improve Intranet Security',4,4, 'INPROGRESS', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation','2020-06-17T16:17:59.304');

