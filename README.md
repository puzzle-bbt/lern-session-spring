# Example Spring Boot WebApp

## Build and start the WebApp from the console
First start the PostgreSql from the docker. Go into the docker folder and execute:

    docker-compose up

Build the Webapp:

    mvn clean package

Start the Webapp:

    mvn spring-boot:run

Start the Webapp and overwrite the `example.application-name` configuration property:

    mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dexample.application-name=NewApp"
