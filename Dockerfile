FROM openjdk:17-jdk-alpine
EXPOSE 8081:8081
RUN mkdir -p /app/
ADD build/libs/musical-instruments-0.0.1-SNAPSHOT.jar /app/musical-instruments.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=production", "-jar", "/app/musical-instruments.jar"]