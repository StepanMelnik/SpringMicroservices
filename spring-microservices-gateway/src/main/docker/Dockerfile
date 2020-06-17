FROM openjdk:8-jdk-alpine

LABEL maintainer="stepan.melnik@gmail.com"
LABEL version="0.1"
LABEL description="The Docker image to start gateway-service in spring-microservices project"

RUN  apk update && apk upgrade && apk add netcat-openbsd bash
RUN mkdir -p /usr/local/gatewayservice
ADD @project.build.finalName@.jar /usr/local/gatewayservice/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
