# Example
Contains the example, developed during the lecture.

Used to have a common base for further examples.

## Content
* Gradle and Maven sources; with focus on Maven. If you want to use Gradle instead, please add the corresponding dependencies to the Gradle build file.
* Spring Boot Web for REST
* Spring Boot Data for Database
* * JPA
* * MongoDB
* * embedded H2-Database

## Properties
Most of the used properties will be explained, when defined.
See [application.properties](src/main/resources/application.properties)

## Test
There are currently no unit-tests.

## NoSQL-Repository
We focus on MongoDB, so please make sure to have a local MongoDB-Server running on your local machine, if you want to experiment with CustomMongoRepository.

## Docker
You will find the [Dockerfile](Dockerfile) on the project root. This is due to easy execution and setup of the Dockerfile. Later on, when we are going to use a Docker-Plugin via Maaven or Gradle, we can place the Dockerfile in a separate directory, but for now it sufficient and easier to keep it on the project root.

### HowTo
Build your Image with
````docker build -t <image_name> .````

Start your Container with:
````docker run -p 8080:8080 -t <image_name>````
You can also change the port and start multiple containers.

List all active and running containers
````docker ps````

Check the URL of your host
````docker-machine url````
Access the application within your container via [http://192.168.99.100:8080/hello](http://192.168.99.100:8080/hello) (URL may differ on your machine)

Stop the container
````docker stop <container_name>```` 

Remove the container
````docker rm <container_name>````