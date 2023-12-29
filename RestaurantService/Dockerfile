FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/RestaurantService-0.0.1-SNAPSHOT.jar app.jar
ENV SPRING_PROFILES_ACTIVE=dev

LABEL authors="gianfrancobonanno"

ENTRYPOINT ["java", "-jar","/app.jar"]