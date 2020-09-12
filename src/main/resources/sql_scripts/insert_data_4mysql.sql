USE kanban_board;				

-- INSERT customer
INSERT INTO customer(name, short_name, details, is_active,date_created) VALUES('IBM LTD','IBM','US It Firm','Y','2020-06-17T16:17:59.304');
INSERT INTO customer(name, short_name, details, is_active,date_created) VALUES('ORACLE LTD','ORACLE','US It Firm','Y','2020-06-17T16:17:59.304');
INSERT INTO customer(name, short_name, details, is_active,date_created) VALUES('DELL LTD','DELL','US It Firm','Y','2020-06-17T16:17:59.304');
INSERT INTO customer(name, short_name, details, is_active,date_created) VALUES('ACME Laboratories','ACME','SA Firm','Y','2020-06-17T16:17:59.304');

-- INSERT contact
INSERT INTO contact(fullname, customer_id, telephone, is_active,date_created) VALUES('Bill Gates',1,'+1-123-1234','Y','2020-06-17T16:17:59.304');
INSERT INTO contact(fullname, customer_id, telephone, is_active,date_created) VALUES('Joe Soap',2,'+271112124','Y','2020-06-17T16:17:59.304');
INSERT INTO contact(fullname, customer_id, telephone, is_active,date_created) VALUES('Jane Doe',3'+271112784','Y','2020-06-17T16:17:59.304');
INSERT INTO contact(fullname, customer_id, telephone, is_active,date_created) VALUES('James Bond',4,'+7-007-7000','Y','2020-06-17T16:17:59.304');


-- INSERT team
INSERT INTO team(name, description, is_active,date_created) VALUES('Front-end developers','FRONTDEVS','Y','2020-06-17T16:17:59.304');
INSERT INTO team(name, description, is_active,date_created) VALUES('Back-end developers','BACKDEVS','Y','2020-06-17T16:17:59.304');
	

-- INSERT employee			
insert into employee ( fullname, email,id_number,enabled) values ( 'John Warton', 'warton@gmail.com','001', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Mike Lanister', 'lanister@gmail.com','002', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Steve Reeves', 'Reeves@gmail.com','003', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Ronald Connor', 'connor@gmail.com','004', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Jim Salvator', 'Sal@gmail.com','005', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Peter Henley', 'henley@gmail.com','006', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Richard Carson', 'carson@gmail.com','007', 1);	

insert into employee ( fullname, email,id_number,enabled,user_id,authority,password) values ( 'Tony Roggers', 'roggers@gmail.com','009', 1,'user','ROLE_USER','$2a$10$8D29dyYhGe2Z8VPT3BV84eL6JptlMWgoFAJObP9Gq9IYG6Gc1DXSa');	
insert into employee ( fullname, email,id_number,enabled,user_id,authority,password) values ( 'Honor Miles', 'miles@gmail.com','008', 1,'admin','ROLE_ADMIN','$2a$10$XhADpGqFMvF33YzPmdV7JOTVbvRl9KqN5Tgxx3jHyOcVVxfRqPIwi');	
insert into employee ( fullname, email,id_number,enabled,user_id,authority,password) values ( 'Nicholas Michael', 'nmichael@gmail.com','1956', 1,'klidi','ROLE_ADMIN','$2a$10$r4325krPku2wNegHS5zLY.4PWtbc4Xz7Zu4NfS2AWaiNVNONtrt.2');	


INSERT INTO epic(name, customer_id, is_active,date_created) VALUES('Create new billing Service',1,'Y','2020-06-17T16:17:59.304');
INSERT INTO epic(name, customer_id, is_active,date_created) VALUES('Update Accounting System',2,'Y','2020-06-17T16:17:59.304');
INSERT INTO epic(name, customer_id, is_active,date_created) VALUES('Replace Billing System',3,'Y','2020-06-17T16:17:59.304');
INSERT INTO epic(name, customer_id, is_active,date_created) VALUES('Make gadget for James Bond',4,'Y','2020-06-17T16:17:59.304');


-- INSERT user_story 			
insert into user_story ( name, epic_id, assigned_to, stage, description, date_created) values ( 'Large Production Deploy',1,1, 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production','2020-06-17T16:17:59.304');
insert into user_story ( name, epic_id, assigned_to, stage, description, date_created) values ( 'New Employee Budget',2,2,  'COMPLETED', 'Decide on a new employee bonus budget for the year and figureout who will be promoted','2020-06-17T16:17:59.304');
insert into user_story ( name, epic_id, assigned_to, stage,  description, date_created) values ( 'Office Reconstruction',3,3, 'INPROGRESS', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed','2020-06-17T16:17:59.304');
insert into user_story ( name, epic_id, assigned_to, stage,  description, date_created) values ( 'Improve Intranet Security',4,4, 'INPROGRESS', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation','2020-06-17T16:17:59.304');

-- INSERT task
insert into task (name,description) values ('Recreate that Bagdad Battery','This was first made in Mesopotamia' );

-- INSERT subtask

insert into subtask (name,description,story_points) values ('Design new Bagdad Battery','Design solution',3 );

-- TERSE VERSION OF THE STATUS VALUES
delete from status_value;
insert into status_value (sort_order,display_value,description) values (0,'UNASSIGNED','UNASSIGNED');
insert into status_value (sort_order,display_value,description) values (1,'DESIGN','DESIGN');
insert into status_value (sort_order,display_value,description) values (2,'DESIGN COMPLETED','DESIGN COMPLETED');
insert into status_value (sort_order,display_value,description) values (3,'DEVELOP','DEVELOP');
insert into status_value (sort_order,display_value,description) values (4,'DEVELOPMENT COMPLETED','DEVELOPMENT COMPLETED');
insert into status_value (sort_order,display_value,description) values (5,'DEPLOY TO DEV','DEPLOY TO DEVELOPMENT ENVIRONMENT');
insert into status_value (sort_order,display_value,description) values (6,'TEST IN DEV','TEST IN DEVELOPMENT ENVIRONMENT');
insert into status_value (sort_order,display_value,description) values (7,'TEST IN DEV COMPLETED','TEST IN DEVELOPMENT ENVIRONMENT COMPLETED');
insert into status_value (sort_order,display_value,description) values (8,'DEPLOY TO QA','DEPLOY TO QA ENVIRONMENT');
insert into status_value (sort_order,display_value,description) values (9,'TEST IN QA','TEST IN QA ENVIRONMENT');
insert into status_value (sort_order,display_value,description) values (10,'TEST IN QA COMPLETED','TEST IN QA ENVIRONMENT COMPLETED');
insert into status_value (sort_order,display_value,description) values (11,'DEPLOY TO PREPROD','DEPLOY TO PRE PRODUCTION ENVIRONMENT');
insert into status_value (sort_order,display_value,description) values (12,'TEST IN PREPROD','TEST IN PRE PRODUCTION ENVIRONMENT');
insert into status_value (sort_order,display_value,description) values (13,'TEST IN PREPROD COMPLETED','TEST IN PRE PRODUCTION ENVIRONMENT COMPLETED');
insert into status_value (sort_order,display_value,description) values (14,'UAT TEST','UAT TEST');
insert into status_value (sort_order,display_value,description) values (15,'UAT TEST COMPLETED','UAT TEST COMPLETED');
insert into status_value (sort_order,display_value,description) values (16,'READY FOR SIGNOFF','READY FOR BUSINESS SIGNOFF');
insert into status_value (sort_order,display_value,description) values (17,'BUSINESS SIGNOFF COMPLETED','BUSINESS SIGNOFF COMPLETED');
insert into status_value (sort_order,display_value,description) values (18,'DEPLOY TO PROD','DEPLOY TO PRODUCTION ENVIRONMENT');
insert into status_value (sort_order,display_value,description) values (19,'DEPLOYMENT TO PROD COMPLETED','DEPLOYMENT TO PRODUCTION ENVIRONMENT COMPLETED');
insert into status_value (sort_order,display_value,description) values (20,'COMPLETED','COMPLETED');

-- SHORTER VERSION OF THE STATUS VALUES

delete from status_value;
insert into status_value (sort_order,display_value,description) values (0,'UNPRIORITIZED','UNPRIORITIZED');
insert into status_value (sort_order,display_value,description) values (1,'PRIORITIZED','PRIORITIZED');
insert into status_value (sort_order,display_value,description) values (2,'DESIGNING','DESIGNING');
insert into status_value (sort_order,display_value,description) values (3,'DEVELOPING','DEVELOPING');
insert into status_value (sort_order,display_value,description) values (4,'TESTING','TESTING IN QA ENVIRONMENT');
insert into status_value (sort_order,display_value,description) values (5,'UAT TESTING','UAT TESTING');
insert into status_value (sort_order,display_value,description) values (6,'READY','READY TO DEPLOY TO PRODUCTION ENVIRONMENT');
insert into status_value (sort_order,display_value,description) values (7,'COMPLETED','COMPLETED');

-- =============================== CREATE ADMINISTRATOR USER SQL SCRIPT ==================================================================
--
--   set your administrator user 
--   with password = P@55w0rd 
--   and role as administrator 
--   and your logon user id
-
INSERT INTO employee 
            (fullname, 
             email, 
             id_number, 
             enabled, 
             user_id, 
             authority, 
             password) 
VALUES      ( 'Youe_administrators_fullname', 
              'your_email@gmail.com', 
              '123456', -- This is your identity number
              1, 
              'yourlogon_user_id', -- This is your logon user id
              'ROLE_ADMIN', 
              '$2a$10$r4325krPku2wNegHS5zLY.4PWtbc4Xz7Zu4NfS2AWaiNVNONtrt.2'); -- password = P@55w0rd
--              
-- =============================== END OF CREATE ADMINISTRATOR USER SQL SCRIPT ===========================================================

-- TASK-EMPLOYEE query -- TASK KANBAN BOARD
SELECT t.status as status,t.task_id as taskId, t.name as taskName,u.name as userStoryName,  e.fullname as assignedTo, t.due_date as dueDate
 FROM task t
 LEFT JOIN employee e ON t.assigned_to = e.employee_id 
 LEFT JOIN status_value s ON t.status = s.display_value
 LEFT JOIN user_story u ON u.user_story_id = t.user_story_id
 WHERE s.sort_order > 0
 ORDER BY s.sort_order, t.name,t.due_date;

-- SUBTASK-EMPLOYEE -- SUBTASK KANBAN BOARD
SELECT t.status as status,t.subtask_id as subtask_id, t.name as name,  e.fullname as assigned_to, t.due_date as due_date,s.sort_order
 FROM subtask t
 LEFT JOIN employee e 
 ON t.assigned_to = e.employee_id
 LEFT JOIN status_value s 
 ON t.status = s.display_value
 WHERE s.sort_order > 0
 ORDER BY s.sort_order, t.name,t.due_date;
              
-- USERSTORY-TEAM -- USERSTORY KANBAN BOARD 
SELECT t.status as status,t.user_story_id as user_story_id, t.name as name,  e.name as assigned_to, t.due_date as due_date
 FROM user_story t
 LEFT JOIN team e 
 ON t.assigned_to = e.team_id
 LEFT JOIN status_value s 
 ON t.status = s.display_value
 WHERE s.sort_order > 0
 ORDER BY s.sort_order, t.name,t.due_date;


-- EMPLOYEE-USERSTORY-COUNT
SELECT count(*) as userstoryCount, e.fullname as fullName
 FROM employee e 
 LEFT JOIN task t ON t.assigned_to = e.employee_id
 LEFT JOIN user_story u ON u.user_story_id = t.user_story_id
 WHERE t.task_id IS NOT NULL
 GROUP BY e.fullname
 ORDER BY userstoryCount desc;
 
