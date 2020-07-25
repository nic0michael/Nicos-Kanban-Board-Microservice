# Kanban Board Spring Boot Microservice
## Aim of this Project
To deliver a Spring Boot Microservice will provide the user with a comprehensive Kanban Board 
To run in the cloud

This project is an improvement of the Architect Nico Michael's GroovyGrails project
It is a new project and its being built one week at a time  
When this project is ready it will be delivered as a selt starting Java Archive (JAR) file 
to deploy on a webserver on the cloud. It is hoped to also deliver this as a Docker Project

We are not ready to accept developers to join this team yet, as we are still build the Master Branch.  

## Database Support
MySQL ,MariaDB, and PerconaMySql are supported



### SQL Scripts provided
In the folder : **/src/main/resources/sql_scripts**
you will find a file : data4mysql.sql  
This has all the create table SQL Scripts you will need as well as Sample Employee insert scripts  
You need to edit that and put your own employees there allocate the admin user id to one employee
allocate the manager user id to another employee so that you can login to the system.
###To use the SQL scripts provided to generate the tables
I recomend that you create a Shell script : **mysql-terminal**




run the folowing command in the terminal:
    sudo nano /usr/bin/mysql-terminal
place the folowing code into this shell script:
    #!/bin/bash
    sudo mysql -u root -pPasswordForRootUserOfMySqlServer

run the folowing command in the terminal:
    sudo chmod 775 /usr/bin/mysql-terminal
 
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


