mvn clean install
docker build -t yilmazchef/kaartje:latest .
docker run `
        --publish 3306:3306 `
        --rm `
        --env MYSQL_ROOT_PASSWORD=toor `
        --env MYSQL_USER=intec `
        --env MYSQL_PASSWORD=intec `
        --env MYSQL_DATABASE=db `
        --detach mysql:latest
docker run `
        --publish 8888:8080 `
        --rm `
        --env SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/db?allowPublicKeyRetrieval=true `
        --env SPRING_DATASOURCE_USERNAME=intec `
        --env SPRING_DATASOURCE_PASSWORD=intec `
        --env SPRING_DATASOURCE_DRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver `
        --detach yilmazchef/kaartje:latest
