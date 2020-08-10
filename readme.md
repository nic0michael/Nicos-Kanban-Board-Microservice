# Kanban Board Spring Boot Microservice

## Beta Version 1.0.0B
This code is ready for trial usage

## Aim of this Project
To deliver a Spring Boot Microservice will provide the user with a comprehensive Kanban Board 
To run in the cloud

This project is an improvement of the Architect Nico Michael's GroovyGrails project
It is a new project and its being built one week at a time  
When this project is ready it will be delivered as a selt starting Java Archive (JAR) file 
to deploy on a webserver on the cloud. It is hoped to also deliver this as a Docker Project

We are not ready to accept developers to join this team yet, as we are still building the Master Branch.  

## Free Open Source FOS
This project is Free Open Source code FOS
It is provided free of chanrge and subjects to the terms of this project


## Legal Terms and conditions for use of this project
See seperate document terms_and_conditions.md

##User Agreememt 
By using this project you agree to the acceptance of the legal terms and conditions of this project.


## Database Support
MySQL ,MariaDB, and PerconaMySql are supported

### SQL Scripts provided
In the folder : **/src/main/resources/sql_scripts**
you will find these files : 

  * create_db_and_tables_4mysql.sql
  * insert_data_4mysql.sql

**The insert_data_4mysql.sql can save you time creating users **  
Please note the passwords are encrypted so dont set them in the query
You will need to edit and run the Insert Query at the bottom of this sql script 
to give your administrator user the needed logon credentials .




once you have lokked in with that employees user Id and password create another Employee with a diferent userId and password and assign the Admin role then delete the previous userID

### To use the SQL scripts provided to generate the tables

| We recomend that you create a Shell script : **mysql-terminal**|
|----------------------------------------------------------------|
| run the folowing command in the terminal:                      |
| sudo nano /usr/bin/mysql-terminal                              |
|                                                                |
| place the folowing code into this shell script:                |
| #!/bin/bash                                                    |
| sudo mysql -u root -pPasswordForRootUserOfMySqlServer          |


 
Now evertime you want open the MSQL terminal you you have a quicker way to get in
just open the bash terminal and run this command :
    **mysql-terminal**

## Programmers comments: 
Create file : schema.sql in /resources folder
Now add this to properties file
spring.jpa.hibernate.ddl-auto=none

# References
charts : [https://www.chartjs.org/](https://www.chartjs.org/)

security: [https://www.baeldung.com/spring-security-thymeleaf](https://www.baeldung.com/spring-security-thymeleaf)

ThtmeLeaf forms : [https://www.baeldung.com/thymeleaf-select-option](https://www.baeldung.com/thymeleaf-select-option)

SQL formatting : [http://www.dpriver.com/pp/sqlformat.htm](http://www.dpriver.com/pp/sqlformat.htm)

