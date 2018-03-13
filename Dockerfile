FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/mooring-ball-0.0.1-SNAPSHOT.jar target/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/app.jar"]