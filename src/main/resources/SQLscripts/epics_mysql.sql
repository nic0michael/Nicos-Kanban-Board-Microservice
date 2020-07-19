DROP TABLE IF EXISTS epics;

CREATE TABLE epics(
id INT PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(300) UNIQUE, 
description VARCHAR(500), 
customer_reference VARCHAR(300), 
customer_id INT, 
due_date datetime,
is_active CHAR(3),
created_at datetime);


INSERT INTO epics(name, is_active,customer_id,created_at) VALUES('Create new billing Service','Y',1,'2020-06-17T16:17:59.304');
INSERT INTO epics(name, is_active,customer_id,created_at) VALUES('Update Accounting System','Y',2,'2020-06-17T16:17:59.304');
INSERT INTO epics(name, is_active,customer_id,created_at) VALUES('Replace Billing System','Y',3,'2020-06-17T16:17:59.304');
INSERT INTO epics(name, is_active,customer_id,created_at) VALUES('James Bond','Y',4,'2020-06-17T16:17:59.304');


