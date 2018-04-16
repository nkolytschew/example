# Define the base image
## Use a tiny Linux distribution, in combination with JDK
FROM frolvlad/alpine-oraclejdk8:slim

# this is mandatory
## add TMP volume, which is needed(will be created) by Tomcat container
VOLUME /tmp

## navigate to Source artifact, add it to the container and rename it to app.jar
ADD target/example-0.0.1-SNAPSHOT.jar app.jar

## execute shell command and create an app.jar
# RUN sh -c 'touch /app.jar'

# ENTRYPOINT and CMD
## you have to provide at least one of them
## entrypoints and commands will be executed on container start-up
## CMD is used to define defaults for an ENTRYPOINT
## CMD commands can be overridden when running the container with alternative arguments
## ENTRYPOINT is immutable and cannot be overridden
## property "-Djava.security.egd=file:/dev/./urandom" reduces the tomcat startup time
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]