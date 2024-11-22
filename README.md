# streamby

## Summary

streamby

## How to 

Start environment

````bash
docker compose -f .\environment\docker-compose.yml up &
````

Build project

````bash
.\gradlew clean build
````

Run sonarqube

````bash
.\gradlew sonar -D sonar.login=<token>
````
Open swagger

````http://localhost:8080/q/swagger-ui````