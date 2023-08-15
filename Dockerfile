FROM openjdk:17-jdk-alpine
COPY ./build/libs/musical-instruments-0.0.1-SNAPSHOT.jar /usr/share/musical-instruments.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=production", "-jar", "musical-instruments.jar"]