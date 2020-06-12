#!/bin/sh
echo "********************************************************"
echo "Starting the articlenameservice"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/articlenameservice/@project.build.finalName@.jar
