DROP TABLE IF EXISTS contacts;

CREATE TABLE contacts(
id INT PRIMARY KEY AUTO_INCREMENT, 
fullname VARCHAR(300) UNIQUE, 
title VARCHAR(10), 
customer_id INT, 
land_line VARCHAR(12),
email VARCHAR(100),
phone VARCHAR(12),
is_active CHAR(3),
created_at datetime);

INSERT INTO contacts(fullname, is_active,customer_id,created_at) VALUES('Bill Gates','Y',1,'2020-06-17T16:17:59.304');
INSERT INTO contacts(fullname, is_active,customer_id,created_at) VALUES('Joe Soap','Y',2,'2020-06-17T16:17:59.304');
INSERT INTO contacts(fullname, is_active,customer_id,created_at) VALUES('Jane Doe','Y',3,'2020-06-17T16:17:59.304');
INSERT INTO contacts(fullname, is_active,customer_id,created_at) VALUES('James Bond','Y',4,'2020-06-17T16:17:59.304');


