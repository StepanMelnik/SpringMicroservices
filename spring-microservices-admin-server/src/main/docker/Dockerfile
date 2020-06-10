FROM openjdk:8-jdk-alpine

LABEL maintainer="stepan.melnik@gmail.com"
LABEL version="0.1"
LABEL description="The Docker image to start admin-server in spring-microservices project"

RUN  apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/adminserver
ADD @project.build.finalName@.jar /usr/local/adminserver/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
