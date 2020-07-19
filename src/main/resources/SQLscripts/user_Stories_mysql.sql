DROP TABLE IF EXISTS user_stories;

CREATE TABLE user_stories(
id INT PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(300) UNIQUE, 
description VARCHAR(500), 
customer_reference VARCHAR(300),  
status VARCHAR(20), 
customer_id INT, 
epic_id INT, 
assigned_to INT,
due_date datetime,
is_active CHAR(3),
created_at datetime);


INSERT INTO user_stories(name, is_active,customer_id,created_at) VALUES('Create new billing Service','Y',1,'2020-06-17T16:17:59.304');
INSERT INTO user_stories(name, is_active,customer_id,created_at) VALUES('Update Accounting System','Y',2,'2020-06-17T16:17:59.304');
INSERT INTO user_stories(name, is_active,customer_id,created_at) VALUES('Replace Billing System','Y',3,'2020-06-17T16:17:59.304');
INSERT INTO user_stories(name, is_active,customer_id,created_at) VALUES('James Bond','Y',4,'2020-06-17T16:17:59.304');
