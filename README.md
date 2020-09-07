# Spring Microservices example
The simple project to fetch Article and all Article properties using Spring Cloud. 

## Description

The project is based on SpringCloud framework.

In general we can use Shopcart, Order, Campaign, Article, Payments providers, etc microservices if we use e-shop implementation.

The current project divides Article module on microservices as an example.

Let's say if you decide to bind article and article properties in one place, for example in ElasticSearch, you can use the idea of project as example and do not separate article relation on microservices.

-------

The following important cases implemented in the current project:
* <a href="https://github.com/StepanMelnik/SpringMicroservices#article-services-relation">Article services relation</a> describes the relations between article services;
* <a href="https://github.com/StepanMelnik/SpringMicroservices#article-services-communication-with-configuration-server">Communication with Config server</a> shows how to load configuration of all services from Config server;
* <a href="https://github.com/StepanMelnik/SpringMicroservices#service-discovery">Discovery server</a> shows how all services communicate with Discovery server;
* <a href="https://github.com/StepanMelnik/SpringMicroservices#client-side-resiliency-hystrix-maintenance">Client side resiliency</a> demonstrates how to maintenance Client resiliency by Hystrix;
* <a href="https://github.com/StepanMelnik/SpringMicroservices#gateway-zuul">Proxy server</a> creates a proxy before services, works with correlation tag, etc;
* <a href="https://github.com/StepanMelnik/SpringMicroservices#security-oauth2">Security</a> based on OAuth2 implementation;
* <a href="https://github.com/StepanMelnik/SpringMicroservices#reactive-stream-flux">Reactive stream</a> shows how to work with Stream system based on ReactiveProject;
* TODO





### Article services relation

The project contains the following Article services:
* Article service
* ArticleName service
* ArticleAttribute service
* ArticlePrice service.

The services use the following relation:

![Relation between Article services](https://github.com/StepanMelnik/SpringMicroservices/blob/master/resources/images/ServicesRelation.png?raw=true)

Eureka server should have the information about all registered Article services:
![All registered Article services with Eureka](https://github.com/StepanMelnik/SpringMicroservices/blob/master/resources/images/RegisteredServicesWithEureka.png?raw=true)


### Article services communication with Configuration server

Article services locads config properties from Config server and communicates with Discovery server as follow:
![Article services communication with servers](https://github.com/StepanMelnik/SpringMicroservices/blob/master/resources/images/ArticleServiceServersCommunication.png?raw=true)


### Service discovery
Article service uses DiscoveryClient instance to connect to Eureka server and fetch all registered instances.

<a href="http://micro.sme.com:8040/v1/tools/eureka/services">http://micro.sme.com:8040/v1/tools/eureka/services</a> will return all registered services.

Let's say Article service uses ArtileName and ArticleAttribute services.
We should fetch all registered services from Discovery server and validate if a service is available before calling the depend on service.

### Client-side resiliency (Hystrix Maintenance)

TODO describe @HystrixCommand, Hystrix pool properties, timeout and Fallback processing. 

### Gateway (Zuul)

Zuuul Gateway communication with servers/services is described in the following diagram:
![Zuuul Gateway communication with servers/services](https://github.com/StepanMelnik/SpringMicroservices/blob/master/resources/images/ZuulProxy.png?raw=true)

Also Gateway application allows to track User context in Request/Response headers using ZuulServlet.
For example, ZuulTrackingFilter.java creates CorrelationId in the request headers and ZuulResponseFilter.java tracks response headers with CorrelationId.
 
Open the following requests to test services against Zuul proxy:
* http://micro.sme.com:5555/api/articleprice/v1/articleprices/1/1/1/0
* http://micro.sme.com:5555/api/article/v1/articles/1

### Security (OAuth2)

First of all see examples in <a href="https://github.com/StepanMelnik/Oauth2_Examples">https://github.com/StepanMelnik/Oauth2_Examples</a> project.

### Reactive stream (Flux)

To understand how reactive stream works in general, see unit tests in <a href="https://github.com/StepanMelnik/ProjectReactor_Examples">ProjectReactor_Examples</a>.

Also see <a href="https://github.com/StepanMelnik/SpringReactiveBackPressure_Examples">SpringReactiveBackPressure_Examples</a> to check how BackPressure works in WebFlux.


TODO Prepare two versions of rest controllers:
* based on tomcat (done).
* another version based on WebFlux (check how to create spring configuration to start Tomcat or Netty according to version)

### Operations
Operations part works with SpringBoot Admin Server and SpringBoot Activator. 

#### SpringBoot Admin Server
SpringBoot Admin Server configuration is described in <a href="https://github.com/StepanMelnik/SpringMicroservices/blob/master/spring-microservices-admin-server/src/main/resources/application.yml">application.yml</a> config.

The config contains the following useful properties:
  * admin client uri
  * end points management
  * logging
  * mail notification if a warning/error occurs with instances  
  * etc
  
Open http://localhost:8898/wallboard to see all registered instances in admin server. When you open any instance, you will have a possibility to see Details, Metrics, Environment, Config properties, Mappinfs, JVM, etc properties.

#### SpringBoot Actuator
Spring Actuator helps to monitor and manage the Spring Boot application.

Check application.yml in **spring-microservices-article-service** module to enable all Actuator properties.

Pay attention that **spring-microservices-article-service** module uses 8040 port and actuator uses 8041 port (let's say when application is overloaded or all threads busy in the connection pool, we still are able to monitor jvm, etc properties of the module.)

And check some of them in actuator endpoint:
  * http://localhost:8041/actuator/ <-- shows actuator end points
  * http://localhost:8041/actuator/health <-- health of module
  * http://localhost:8041/actuator/configprops <-- fetches all properties
  * http://localhost:8041/actuator/metrics/ <-- jvm, tomcat, etc metrics



## Build

Clone and install <a href="https://github.com/StepanMelnik/Parent.git">Parent</a> project before building.

Clone <a href="https://github.com/StepanMelnik/SpringMicroservices.git">SpringMicroservices Example</a> project.

### Maven
	> mvn clean install
	> mvn clean package docker:build -DskipTests -Ddocker.nocache=true

### Docker
Check a list of all created images:

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
Docker compose describes all docker services with configuration properties to start all spring cloud servers and services.

    > sudo docker-compose up
    > sudo docker service ls
      
When all services start, you can open Article properties in browser, check [Tests](#tests) section


### Docker cluster (Swarm)
Important to use docker-compose to start all services together.

But if you want to start all containers by hand, just init swarm cluster with own network properties.
 
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
	            
Start all images step by step

		# Start discovery server and open in browser: http://micro.sme.com:8761/
		> sudo docker run -p 8761:8761 --rm -it sme/micro-discovery-server:0.1 ./run.sh           

		# Start config server and open in browser: http://micro.sme.com:8888/articleservice/default
		> sudo docker run -p 8888:8888 --rm -it sme/micro-config-server:0.1 ./run.sh
		
		# Start articlename-service and open in browser: http://micro.sme.com:8010/v1/articlenames/1
		> sudo docker run -p 8010:8010 --rm -it sme/micro-articlename-service:0.1 ./run.sh
		
		# Start admin server and open in browser: http://micro.sme.com:8898
		> sudo docker run -p 8898:8898 --rm -it sme/micro-admin-server:0.1 ./run.sh

		# Start all other services.

### Kubernetes

This is another story.

The project supports Spring Cloud Netflix solution.
The project works in docker-compose container and communicates with Eureka server that provides service discovery and client-side load balancing by Ribbon.

Kubernetes works with service discovery and load balancing on its own. It means we should migrate the project to k8s cluster to get the project working.

There is a few solutions to do it:
  * disable Ribbon load balancer and move Eureka service to k8s Ingress controller to manage external access to the service in a cluster by load balancing
  * use Spring Cloud Kubernetes integration  

But this is out of scope of the project.

Anyway k8s scripts added to have a vision how it would work. 


#### Deploy ####


Kubernetes deployment configuration is described in **spring-microservices-*-[service|server]\src\main\k8s\spring-microservices-*-deployment.yaml** file per module.

Kubernetes service configuration is described in **spring-microservices-*-[service|server]\src\main\k8s\spring-microservices-*-service.yaml** file per module.

Check all commands to work with k8s cluster: https://kubernetes.io/docs/reference/kubectl/cheatsheet/

Use the following commands to deploy pods and create k8s services step by step:
  * create docker images: mvn clean package docker:build -DskipTests -Ddocker.nocache=true
  * docker images | grep sme/micro  <-- all mcro-* images should be created by maven
  * kubectl create namespace spring-microservices & sudo kubectl get namespace
  * start **discoveryserver**:
    * sudo kubectl apply -f spring-microservices-discovery-server/src/main/k8s/spring-microservices-discovery-server-deployment.yaml 	<-- deploy pod + replication controller
    * sudo kubectl get pods  <-- Ready with Status=Running
    * sudo kubectl describe pod spring-microservices-discovery-server  <-- no errors
    * sudo kubectl describe deployment spring-microservices-discovery-server
    * sudo kubectl apply -f spring-microservices-discovery-server/src/main/k8s/spring-microservices-discovery-server-service.yaml	<-- deploy service
    * sudo kubectl get services
    * sudo kubectl describe service spring-microservices-discovery-server
    * sudo kubectl logs spring-microservices-discovery-server-bbbc5c5fb-6r6k7  <-- check logs in pod
    * check logs on host: /var/log/microservices
  * start **configserver**:     
    * sudo kubectl apply -f spring-microservices-config-server/src/main/k8s/spring-microservices-config-server-deployment.yaml
    * sudo kubectl apply -f spring-microservices-config-server/src/main/k8s/spring-microservices-config-server-service.yaml
  * start **articlenameservice**:     
    * sudo kubectl apply -f spring-microservices-articlename-service/src/main/k8s/spring-microservices-articlename-service-deployment.yaml
    * sudo kubectl apply -f spring-microservices-articlename-service/src/main/k8s/spring-microservices-articlename-service-service.yaml
  * start **articlepriceservice**:     
    * sudo kubectl apply -f spring-microservices-articleprice-service/src/main/k8s/spring-microservices-articleprice-service-deployment.yaml
    * sudo kubectl apply -f spring-microservices-articleprice-service/src/main/k8s/spring-microservices-articleprice-service-service.yaml
  * start **articleattributeservice**:     
    * sudo kubectl apply -f spring-microservices-articleattribute-service/src/main/k8s/spring-microservices-articleattribute-service-deployment.yaml
    * sudo kubectl apply -f spring-microservices-articleattribute-service/src/main/k8s/spring-microservices-articleattribute-service-service.yaml
  * start **articleservice**:     
    * sudo kubectl apply -f spring-microservices-article-service/src/main/k8s/spring-microservices-article-service-deployment.yaml
    * sudo kubectl apply -f spring-microservices-article-service/src/main/k8s/spring-microservices-article-service-service.yaml


	-- start 
	sudo kubectl apply -f spring-microservices-discovery-server/src/main/k8s/spring-microservices-discovery-server-deployment.yaml
	sudo kubectl apply -f spring-microservices-discovery-server/src/main/k8s/spring-microservices-discovery-server-service.yaml
	
	sudo kubectl apply -f spring-microservices-config-server/src/main/k8s/spring-microservices-config-server-deployment.yaml
	sudo kubectl apply -f spring-microservices-config-server/src/main/k8s/spring-microservices-config-server-service.yaml
	
	-- check urls in minikube
	sudo minikube service configserver --url
	sudo minikube service discoveryserver --url
	
	-- check json configs
	sudo kubectl get service configserver -o json
	
	-- get endpoints
	sudo kubectl get endpoints configserver


#### Cleanup ####

	kubectl delete -f spring-microservices-discovery-server/src/main/k8s/spring-microservices-discovery-server-deployment.yaml
	kubectl delete -f spring-microservices-discovery-server/src/main/k8s/spring-microservices-discovery-server-service.yaml
	kubectl delete -f spring-microservices-config-server/src/main/k8s/spring-microservices-config-server-deployment.yaml
	kubectl delete -f spring-microservices-config-server/src/main/k8s/spring-microservices-config-server-service.yaml
	kubectl delete -f spring-microservices-articlename-service/src/main/k8s/spring-microservices-articlename-service-deployment.yaml
	kubectl delete -f spring-microservices-articlename-service/src/main/k8s/spring-microservices-articlename-service-service.yaml
	
	-- remove services
	sudo kubectl delete service spring-microservices-articlename-service
	
	sudo kubectl delete service configserver
	sudo kubectl delete service discoveryserver
	
	sudo kubectl get services
	
	-- remove pods
	sudo kubectl delete deployment spring-microservices-articlename-service
	sudo kubectl delete deployment configserver
	sudo kubectl delete deployment discoveryserver
	
	sudo kubectl delete pod spring-microservices-articlename-service-749dfc9686-lbzln


#### Problems ####

All pods use "restartPolicy: Always" property. But in general a pod may be failed for some reason.

Check a few cases as follow to check a reason:
  * sudo kubectl describe pod spring-microservices-discovery-server-bbbc5c5fb-6r6k7 <-- check State, Reason, Last State, Exit code
  * restart pod: sudo kubectl scale deployment spring-microservices-discovery-server --replicas=0 & sudo kubectl scale deployment spring-microservices-discovery-server --replicas=1
  * check a docker image in interactive mode:  docker run --rm -it sme/micro-discovery-server:0.1 bash

#### Debug by IDE ####

If you cannot resolve an issue in k8s kluster, you can connect to a docker container in a pod by IDE remote debugger.

Do the following to run java process in debug mode (for example, debug "spring-microservices-discovery-server" module):
  * open "spring-microservices-discovery-server\src\main\docker\run.sh" and add the following option in cmd line: -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005
  * open "spring-microservices-discovery-server\src\main\k8s\spring-microservices-discovery-server-service.yaml" and expose debug port:

	spec:
	  ports:
	    - name: debug
	      port: 5005
	      targetPort: 5005
	      protocol: TCP
  * deploy k8s pod and service
  * check endpoints in k8s:  sudo kubectl get endpoints discoveryserver
  * check services: sudo kubectl get services | grep discoveryserver
  * connect Remote application in IDE to the container in cluster: 10.96.249.97:5005  <-- you should be able to debug code 


#### Misc ####
Kubernetes config does not use Secret configs, Config Maps, DNS of LoadBalancer, etc. 


### Jenkins

Check Jenkins file

## Unit tests
All modules covered by unit tests.

JUpiter, Mock, SpringTests, MockServer used to perform unit tests.

Code coverage see in <a href="http://jenkins.sme.com:8080/job/SpringMicroservicesExample/">Jenkins</a> job.

## Integration/Loading tests
TODO

## Tests
Run [docker-compose](#docker-compose) and check the following services in browser:
* Discovery server contains all registered services: http://micro.sme.com:8761/
* Config server contains configuration properties of services. For example, articleprice configuration for Default profile: http://micro.sme.com:8888/articleservice/default
* ArticleName service: http://micro.sme.com:8010/v1/articlenames/1
* ArticlePrice service: http://micro.sme.com:8020/v1/articleprices/1/1/1/0
* ArticleAttribute service: http://micro.sme.com:8030/v1/articleattributes/1
* Artilce service: http://micro.sme.com:8040/v1/articles/1

## Debug
ArticleName service is running in debug mode to connect to JVM in Docker container.

## Branding
All of the containers use own spring branding logo.

## Logs
Modules use logback-spring.xml configuration file.

All log files shared in /var/log/microservices folder.

TODO share all events in Logstash.

## TODO
* Add UI
* Add Auth
* add event-driven patterns based on kafka SAGA, Command Query Responsibility Segregation (CQRS):  
* add log tracing