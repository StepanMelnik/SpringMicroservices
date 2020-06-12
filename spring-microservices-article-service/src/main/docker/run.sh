#!/bin/sh
echo "********************************************************"
echo "Starting the articleservice"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/articleservice/@project.build.finalName@.jar
