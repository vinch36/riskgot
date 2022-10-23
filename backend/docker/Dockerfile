FROM openjdk:17-jdk-alpine
ARG JAR_FILE=backend-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]