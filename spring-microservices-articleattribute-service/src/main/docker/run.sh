#!/bin/sh
echo "********************************************************"
echo "Starting the articleattribute"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/articleattributeservice/@project.build.finalName@.jar
