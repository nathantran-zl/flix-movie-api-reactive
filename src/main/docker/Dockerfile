FROM openjdk:8
MAINTAINER Steven Romero <mr.steven.romero@gmail.com>

VOLUME /tmp
COPY *.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]