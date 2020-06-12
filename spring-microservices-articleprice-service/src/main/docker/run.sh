#!/bin/sh
echo "********************************************************"
echo "Starting the articlepriceservice"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/articlepriceservice/@project.build.finalName@.jar
