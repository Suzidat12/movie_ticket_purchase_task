FROM adoptopenjdk/openjdk11:x86_64-alpine-jdk-11.0.14.1_1-slim
ENV APP_HOME=/zik
WORKDIR $APP_HOME
COPY build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]

#FROM openjdk:17
#EXPOSE 8080
#ADD target/movie-ticket-booking-0.0.1-SNAPSHOT.jar movie-ticket-booking-0.0.1-SNAPSHOT.jar
#ENTRYPOINT [ "java", "-jar", "/movie-ticket-booking-0.0.1-SNAPSHOT" ]
#
#FROM adoptopenjdk/openjdk11:alpine-jre
#
#ARG JAR_FILE=target/movie-ticket-booking-0.0.1-SNAPSHOT.jar
#
#WORKDIR /opt/app
#
#COPY ${JAR_FILE} app.jar
#
#ENTRYPOINT ["java", "-jar", "app.jar"]


