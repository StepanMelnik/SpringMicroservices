FROM openjdk:8-jdk-alpine

LABEL maintainer="stepan.melnik@gmail.com"
LABEL version="0.1"
LABEL description="The Docker image to start articlename-service in spring-microservices project"

RUN  apk update && apk upgrade && apk add netcat-openbsd bash
RUN mkdir -p /usr/local/articlenameservice
ADD @project.build.finalName@.jar /usr/local/articlenameservice/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
