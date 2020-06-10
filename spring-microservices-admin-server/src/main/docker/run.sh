#!/bin/sh
echo "********************************************************"
echo "Starting the admin-server"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/adminserver/@project.build.finalName@.jar
