FROM openjdk:17-jdk-slim
VOLUME /tmp
WORKDIR /app

COPY target/*.jar app.jar
COPY src/main/resources/wallet /app/wallet

ENTRYPOINT ["java", "-jar", "app.jar"]
