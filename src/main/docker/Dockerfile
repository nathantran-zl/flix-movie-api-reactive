FROM openjdk:8
MAINTAINER Steven Romero <mr.steven.romero@gmail.com>

ENV CLOUD_CONFIG_NAME tagxleconfig
ENV CLOUD_CONFIG_PASSWORD 9gryF6TzXPt9
ENV CLOUD_CONFIG_SYMMETRIC_KEY 074PGqmmdBPc0VRljizXSfxc5P
ENV EUREKA_USER_PASSWORD wOxYQesxp3HfGcZO
ENV JWT_SIGNING_KEY NUzCDDaXxZId8iuXml7RaahiCVEpdxsRfQhJ

VOLUME /tmp
COPY *.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]