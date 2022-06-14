mvn clean install
docker run `
        --publish "3306:3306" `
        --rm `
        --env MYSQL_ROOT_PASSWORD=toor `
        --env MYSQL_USER=intec `
        --env MYSQL_PASSWORD=intec `
        --env MYSQL_DATABASE=db `
        --detach mysql:latest
java -jar target/kaartje.jar --server.port=8081