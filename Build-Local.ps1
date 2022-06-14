docker run --publish 3306:3306 --env MYSQL_ROOT_PASSWORD=toor --env MYSQL_USER=intec --env MYSQL_PASSWORD=intec --env MYSQL_DATABASE=db --detach mysql:latest
mvn clean install
mvn spring-boot:run