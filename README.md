# Spring Microservices example


## Description



## Build

Clone and install <a href="https://github.com/StepanMelnik/Parent.git">Parent</a> project before building.

	### Maven
		> mvn clean install
		> mvn -DskipTests package docker:build

	### Docker
		> TODO

	### Docker compose
      > TODO

	### Jenkins
		Check Jenkins file.


mvn clean package


docker:build

## Unit tests
All modules covered by unit tests.

JUpiter, Mock, SpringTests, MockServer used to perform unit tests.

Code coverage see in <a href="http://jenkins.sme.com:8080/job/SpringMicroservicesExample/">Jenkins</a> job.

## TODO
* Add UI
* Add Auth
* Add Log4j