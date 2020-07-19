
To use SQL script to generate the tables 
I have created a script : mysql-terminal
sudo nano /usr/bin/mysql-terminal
#!/bin/bash
sudo mysql -u root -pPasswordForRootUserOfMySqlServer

sudo chmod 775 /usr/bin/mysql-terminal 

Create file : schema.sql in /resources folder
Now add this to properties file
spring.jpa.hibernate.ddl-auto=none

charts : https://www.chartjs.org/

security: https://www.baeldung.com/spring-security-thymeleaf
