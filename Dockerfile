FROM openjdk:17-jdk-alpine
COPY musical-instruments.jar /app/musical-instruments.jar
WORKDIR /app
EXPOSE 8081
ENTRYPOINT ["java", "-Dspring.profiles.active=production", "-jar", "musical-instruments.jar"]