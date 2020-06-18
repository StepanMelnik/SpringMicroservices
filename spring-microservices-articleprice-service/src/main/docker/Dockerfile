FROM openjdk:8-jdk-alpine

LABEL maintainer="stepan.melnik@gmail.com"
LABEL version="0.1"
LABEL description="The Docker image to start articlepriceservice in spring-microservices project"

RUN  apk update && apk upgrade && apk add netcat-openbsd bash
EXPOSE 5015
RUN mkdir -p /usr/local/articlepriceservice
ADD @project.build.finalName@.jar /usr/local/articlepriceservice/
VOLUME /usr/local/articlepriceservice/log
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
