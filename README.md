# Spring Microservices example


## Description



## Build

Clone and install <a href="https://github.com/StepanMelnik/Parent.git">Parent</a> project before building.

Clone <a href="https://github.com/StepanMelnik/SpringMicroservices.git">SpringMicroservices Example</a> project.

	### Maven
		> mvn clean install
		> mvn clean package docker:build -DskipTests

	### Docker: list all created images
		> sudo docker images -a | grep sme/micro
			sme/micro-articleattribute-service              0.1
			sme/micro-article-service                       0.1
			sme/micro-articleprice-service                  0.1
			sme/micro-articlename-service                   0.1
			sme/micro-admin-server                          0.1
			sme/micro-config-server                         0.1
			sme/micro-discovery-server                      0.1
           ...

	### Docker compose
      > TODO


	### Docker cluster (Swarm):
		> sudo docker swarm init
		
		# List networks and Create network so services can ping each other
		> sudo docker network ls
		> sudo docker network create -d overlay micro_services_bridge
		
		# List all services
		> sudo docker service ls
		
		# Create "discovery" service to work with discovery server
		> sudo docker service create -d --name discovery --network micro_services_bridge --replicas 1 -p 8761:8761 sme/micro-discovery-server

		# Create "config" service to work with config server
		> sudo docker service create -d --name config --network micro_services_bridge --replicas 1 -p 8888:8888 sme/micro-config-server
		
		# Create "articlename-service" client
		> sudo docker service create -d --name articlename_service --network micro_services_bridge --replicas 1 -p 8010:8010 sme/micro-articlename-service
	    
	    # Register all other services!
	            
	### Docker: start all images step by step
		# Start discovery server and open in browser: http://micro.sme.com:8761/
		> sudo docker run -p 8761:8761 --rm -it sme/micro-discovery-server:0.1 ./run.sh           

		# Start config server and open in browser: http://micro.sme.com:8888/articleservice/default
		> sudo docker run -p 8888:8888 --rm -it sme/micro-config-server:0.1 ./run.sh
		
		# Start articlename-service and open in browser: http://micro.sme.com:8010/v1/articlenames/1
		> sudo docker run -p 8010:8010 --rm -it sme/micro-articlename-service:0.1 ./run.sh
		
		# Start admin server and open in browser: http://micro.sme.com:8898
		> sudo docker run -p 8898:8898 --rm -it sme/micro-admin-server:0.1 ./run.sh

		# Start all other services.

	### Jenkins
		Check Jenkins file


mvn clean package


docker:build

## Unit tests
All modules covered by unit tests.

JUpiter, Mock, SpringTests, MockServer used to perform unit tests.

Code coverage see in <a href="http://jenkins.sme.com:8080/job/SpringMicroservicesExample/">Jenkins</a> job.

## Tests
Run docker-compose and check the following services in browser:
* Discovery server contains all registered services: http://micro.sme.com:8761/
* Config server contains configuration properties of services. For example, articleprice configuration for Default profile: http://micro.sme.com:8888/articleservice/default
* ArticleName service: http://micro.sme.com:8010/v1/articlenames/1
* ArticlePrice service: http://micro.sme.com:8020/v1/articleprices/1/1/1/0
* ArticleAttribute service: http://micro.sme.com:8030/v1/articleattributes/1
* Artilce service: http://micro.sme.com:8040/v1/articles/1

## Debug
ArticleName service is running in debug mode to connect to JVM in Docker container.

## TODO
* Add UI
* Add Auth
* Add Log4j
* add kafka messaging
* add log tracing