FROM openjdk:17-jdk-alpine
RUN mkdir /app
COPY /app/musical-instruments.jar /app/musical-instruments.jar
WORKDIR /app
EXPOSE 8081
ENTRYPOINT ["java", "-Dspring.profiles.active=production", "-jar", "/app/musical-instruments.jar"]