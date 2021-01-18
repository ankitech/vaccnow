# vaccnow
As a cautious action after Covid-19, VaccNow is an healthcare organization managing the process of Covid-19 vaccine to public, so that the VaccNow is planning to build multi their digital channels for consuming a modern API for basic features. This is planned to be API first approach, of well-tested functions and enabling agility of later modifications.

Please note that a sample of schema and data is available in [schema.sql_backup](https://github.com/ankitech/vaccnow/blob/Mongo_implementation/src/main/resources/schema.sql_backup) and [data.sql_backup](https://github.com/ankitech/vaccnow/blob/Mongo_implementation/src/main/resources/data.sql_backup)
 
**Table of Contents**
1. [Class Diagram](#class-diagram)
2. [Data model diagram](#data-model)
3. [Api apecs](#api-specs)
4. [Running application in development and debug mode](#running-application-in-development-and-debug-mode)

## Class diagram
![class Diagram](https://github.com/ankitech/vaccnow/blob/master/class_diagram.png) 

## Data model
![data model](https://github.com/ankitech/vaccnow/blob/master/datamodel.png) 

## Api specs
![swagger1](https://github.com/ankitech/vaccnow/blob/master/swagger1.png) 
![swagger1](https://github.com/ankitech/vaccnow/blob/master/swagger2.png) 
![swagger1](https://github.com/ankitech/vaccnow/blob/master/swagger3.png) 

## Running application in development and debug mode
1. To run the application in debug mode Run th application as Spring application locally
    You can use any IDE to import the project 
    - use that to bring up the application as a java application
    - or
    - go to project folder and use ``mvn springboot:run`` to bring up the application
    
    Helpful Links when running locally:
    
    - You can access the application on [localhost:8080](http://localhost:8080)
    - Swagger documentation will be available on [localhost:8080/swagger-ui.html#/](http://localhost:8080/swagger-ui.html#/)
    - H2 in memory database will be available on [localhost:8080/h2-console/](http://localhost:8080/h2-console/)

    
                                                                                                       
