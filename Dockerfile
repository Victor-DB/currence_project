FROM openjdk:12-jdk-alpine
COPY currence_project-0.0.1-SNAPSHOT.jar currence_project-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "currence_project-0.0.1-SNAPSHOT.jar"]