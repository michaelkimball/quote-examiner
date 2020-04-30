FROM openjdk:15-slim-buster
WORKDIR /etc/app
COPY mvnw mvnw.cmd pom.xml README.md ./
COPY .mvn ./.mvn
COPY src ./src
RUN ./mvnw package
ENTRYPOINT ["./mvnw", "spring-boot:run", "-Dspring-boot.run.profiles=containerized"]