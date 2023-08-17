FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY musical-instruments.jar /app/musical-instruments.jar
EXPOSE 8081
ENTRYPOINT ["java", "-Dspring.profiles.active=production", "-jar", "app/musical-instruments.jar/musical-instruments.jar"]