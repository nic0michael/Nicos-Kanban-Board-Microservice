mvn clean install
docker build -t yilmazchef/kaartje:latest .
docker run `
        --publish 3306:3306 `
        --env MYSQL_ROOT_PASSWORD=toor `
        --env MYSQL_USER=intec `
        --env MYSQL_PASSWORD=intec `
        --env MYSQL_DATABASE=db `
        --detach mysql:latest
docker run `
        --publish 8080:8080 `
        --env .\.env `
        --detach yilmazchef/kaartje:latest
