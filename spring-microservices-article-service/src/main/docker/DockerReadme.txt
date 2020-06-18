# Check created image
sudo docker exec --rm -it sme/micro-article-service:0.1 /bin/bash

# Start image in Docker
sudo docker run -p 8040:8040 --rm -it sme/micro-article-service:0.1 ./run.sh
sudo docker run -p 8040:8040 -v /var/log/microservices:/logs --rm -it sme/micro-article-service:0.1 ./run.sh

# Connect to image
sudo docker ps | grep article
sudo docker exec -it 018c944eb45f /bin/bash
top
ps aux | greo java
ip route list
route
netstat
exit