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
INSERT INTO team(name, is_active,date_created) VALUES('Front-end developers','Y','2020-06-17T16:17:59.304');
INSERT INTO team(name, is_active,date_created) VALUES('Back-end developers','Y','2020-06-17T16:17:59.304');
	

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






