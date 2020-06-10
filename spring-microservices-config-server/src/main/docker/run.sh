#!/bin/sh

echo "********************************************************"
echo "Waiting for the discovery server to start  on port TODO" (See docker compose)
echo "********************************************************"

echo "TODO"

#!/bin/sh
echo "********************************************************"
echo "Starting the config-server"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/configserver/@project.build.finalName@.jar
