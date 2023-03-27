FROM openjdk:17-jdk-alpine
ARG WAR_FILE=target/*.war
COPY target/YouBooking-0.0.1.war app.war
ENTRYPOINT ["java", "-jar","app.war"]