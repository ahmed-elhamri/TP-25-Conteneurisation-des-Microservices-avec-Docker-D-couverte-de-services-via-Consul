FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app
COPY ./src ./src
COPY ./pom.xml .
RUN mvn clean package

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} gateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/gateway-0.0.1-SNAPSHOT.jar"]