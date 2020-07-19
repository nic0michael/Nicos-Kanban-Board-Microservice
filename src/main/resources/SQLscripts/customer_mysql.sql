DROP TABLE IF EXISTS customers;

CREATE TABLE customers(
id INT PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(100) UNIQUE, 
short_name VARCHAR(100) UNIQUE, 
customer_segment VARCHAR(255), 
telephone VARCHAR(12),
cellphone VARCHAR(12),
email VARCHAR(100),
is_active CHAR(3),
created_at datetime);


INSERT INTO customers(name, is_active,created_at) VALUES('IBM','Y','2020-06-17T16:17:59.304');
INSERT INTO customers(name, is_active,created_at) VALUES('ORACLE','Y','2020-06-17T16:17:59.304');
INSERT INTO customers(name, is_active,created_at) VALUES('DELL','Y','2020-06-17T16:17:59.304');
INSERT INTO customers(name, is_active,created_at) VALUES('ACME Laboratories','Y','2020-06-17T16:17:59.304');


