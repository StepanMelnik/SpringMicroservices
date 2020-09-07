#!/bin/sh

#echo "********************************************************"
#echo "Waiting for the discovery server to start  on port $DISCOVERYSERVER_PORT"
#echo "********************************************************"
#while ! `nc -z discoveryserver $DISCOVERYSERVER_PORT`; do sleep 5; done
#echo "-----------> Discovery server started"

#!/bin/sh
echo "********************************************************"
echo "Starting the config-server"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Deureka.client.serviceUrl.defaultZone=$DISCOVERYSERVER_URI -jar /usr/local/configserver/@project.build.finalName@.jar
