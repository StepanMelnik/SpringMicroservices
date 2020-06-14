#!/bin/sh

echo "********************************************************"
echo "Waiting for the discovery server to start  on port $DISCOVERYSERVER_PORT"
echo "********************************************************"
while ! `nc -z discoveryserver $DISCOVERYSERVER_PORT`; do sleep 5; done
echo "-----------> Discovery server started"

echo "********************************************************"
echo "Waiting for the config server to start  on port $CONFIGSERVER_PORT"
echo "********************************************************"
while ! `nc -z configserver $CONFIGSERVER_PORT`; do sleep 5; done
echo "-----------> Config server started"

echo "********************************************************"
echo "Starting the articlepriceservice"
echo "********************************************************"

# Run in debug mode, the Remote connector should be started
#java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=$DEBUG_PORT -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=$PROFILE -Dserver.port=$SERVER_PORT -Deureka.client.serviceUrl.defaultZone=$DISCOVERYSERVER_URI -Dspring.cloud.config.uri=$DISCOVERYSERVER_URI -jar /usr/local/articlepriceservice/@project.build.finalName@.jar

java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=$PROFILE -Dserver.port=$SERVER_PORT -Deureka.client.serviceUrl.defaultZone=$DISCOVERYSERVER_URI -Dspring.cloud.config.uri=$DISCOVERYSERVER_URI -jar /usr/local/articlepriceservice/@project.build.finalName@.jar