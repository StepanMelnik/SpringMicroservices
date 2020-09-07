#!/bin/sh
echo "********************************************************"
echo "Starting the discovery-server"
echo "********************************************************"

#java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005 -Djava.security.egd=file:/dev/./urandom -jar /usr/local/discoveryserver/@project.build.finalName@.jar

java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/discoveryserver/@project.build.finalName@.jar
