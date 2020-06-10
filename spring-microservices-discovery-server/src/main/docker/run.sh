#!/bin/sh
echo "********************************************************"
echo "Starting the discovery-server"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/discoveryserver/@project.build.finalName@.jar
