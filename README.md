# vaccnow
As a cautious action after Covid-19, VaccNow is an healthcare organization managing the process of Covid-19 vaccine to public, so that the VaccNow is planning to build multi their digital channels for consuming a modern API for basic features. This is planned to be API first approach, of well-tested functions and enabling agility of later modifications.

**Table of Contents**
1. [Class Diagram](#class-diagram)
2. [Data model diagram](#data-model)
3. [Api apecs](#api-specs)
4. [Prerequisites to Run the application](#prerequisites-to-run-the-application)
5. [Running the application](#running-the-application)
6. [Prerequisites for development system](#prerequisites-for-development-system)
7. [Running Application Locally](#running-application-locally)
8. [Running application in development and debug mode](#running-application-in-development-and-debug-mode)

## Class diagram
![class Diagram](https://github.com/ankitech/vaccnow/blob/master/class_diagram.png) 

## Data model
![data model](https://github.com/ankitech/vaccnow/blob/master/datamodel.png) 

## Api specs
![swagger1](https://github.com/ankitech/vaccnow/blob/master/swagger1.png) 
![swagger1](https://github.com/ankitech/vaccnow/blob/master/swagger2.png) 
![swagger1](https://github.com/ankitech/vaccnow/blob/master/swagger3.png) 

## Prerequisites to Run the application
- Docker
- Docker-compose

Steps to install (Steps are for aws-linux-EC2, steps for windows and mac can be googled ) :

1.Docker 
```shell script
sudo yum update -y
sudo amazon-linux-extras install docker
sudo service docker start
sudo usermod -a -G docker ec2-user
```
2.Docker-compose 
```shell script
sudo curl -L "https://github.com/docker/compose/releases/download/1.25.5/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose
```

## Running the application
>Note :To run the application you need to have access to image on docker hub.

Create a yaml file names `docker-compose.yaml` and paste the below content in it.
```yaml
version: '3'

services:
  mongo:
    image: mongo:4.0-xenial
    restart: always
    ports:
      - '27017:27017'

  vaccnow-api:
    image: vaccnow/vaccnowapi
    ports:
      - "8080:8080"
    restart: always
    depends_on:
      - mongo
    environment:
      SPRING_DATA_MONGODB_HOST: mongo
```
- Save the file. 
- Move to the directory where file is saved.
- Run the below command from the 
    - ``docker-compose up``
- This will down load mongo image and vaccnow image from docker hub and bring the application 
- You can access the application on [localhost:8080](http://localhost:8080)
- Swagger documentation will be available on [localhost:8080/swagger-ui.html#/](http://localhost:8080/swagger-ui.html#/)

## Prerequisites for development system
* Docker 
* Docker-compose 
* Java   (1.8 + )
* Git    
* Maven  (3.6.0 +) optional

1. Docker 
    - Follow steps here for system you are working on [Get Docker](https://docs.docker.com/get-docker/)
2. Docker-compose 
    - Follow steps here for system you are working on [Get docker compose](https://docs.docker.com/compose/install/)
3. java
    - Follow steps here for system you are working on [Install jdk](https://www.oracle.com/java/technologies/javase-downloads.html)
4. Git
    - Follow steps here for system you are working on [Install Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
5. Maven
    - Follow steps here for system you are working on [Install Maven](https://maven.apache.org/install.html)

## Running Application Locally
1. Clone the project locally
    - ``git clone https://github.com/ankitech/vaccnow.git ``
2. Move to project folder
    - ``cd vaccnow``
3. Build the project and generate image of the application
    - ``mvn clean install docker:build``
    >if maven was not installed, then maven wrapper can be used to build
    > - ``.\mvnw clean package docker:build``
4. To tun application using docker compose                                                                                                       
    - Create a yaml file names `docker-compose.yaml` and paste the below content in it.
```yaml
version: '3'

services:
  mongo:
    image: mongo:4.0-xenial
    restart: always
    ports:
      - '27017:27017'

  vaccnow-api:
    image: vaccnow/vaccnow
    ports:
      - "8080:8080"
    restart: always
    depends_on:
      - mongo
    environment:
      SPRING_DATA_MONGODB_HOST: mongo
```
- Save the file
- Move to the directory where file is saved.
- Run the below command from the 
    - ``docker-compose up``
- This will down load mongo image and vaccnow image from docker hub and bring the application
- You can access the application on [localhost:8080](http://localhost:8080)
- Swagger documentation will be available on [localhost:8080/swagger-ui.html#/](http://localhost:8080/swagger-ui.html#/)

## Running application in development and debug mode
1. To run the application in debug mode we require mongo to be running locally
    - This can be locally installed from [Install mongo](https://docs.mongodb.com/manual/installation/)
    - or
    - mongo cab be running in a container and expose the port `27017`
        - ``docker run --name mongo -p 27017:27017 -d mongo:4.0-xenial``
2. You can use any IDE to import the project 
    - use that to bring up the application as a java application
    - or
    - go to project folder and use ``mvn springboot:run`` to bring up the application
                                                                                                       
