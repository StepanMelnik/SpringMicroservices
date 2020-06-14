# Build docker file by maven:
## mvn clean package docker:build -DskipTests

# Docker commands to build and run docker image.

## Build (start in "target" folder)
### sudo docker build --no-cache -t "sme/micro-discovery-server:0.1" -f ./docker/Dockerfile .
### sudo docker images -a | grep sme/micro-discovery-server

## Check files in image
### sudo docker run --rm -it sme/micro-discovery-server:0.1 find /usr/local/discoveryserver

## Check java version
### sudo docker run --rm -it sme/micro-discovery-server:0.1 java -version

## Open image in bash and check all files
### sudo docker run --rm -it sme/micro-discovery-server:0.1 /bin/bash
### cd /usr/local/discoveryserver
### java -version
### exit

## Run
### sudo docker run -p 8761:8761 --rm -it sme/micro-discovery-server:0.2 ./run.sh
### open http://localhost:8761/ in browser
