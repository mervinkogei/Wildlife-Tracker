## Wildlife Tracker
* Wildlife Tracker is an application that allows Rangers to track wildlife sightings in the area.

#### Author:
By `Vincent K. Kogei`  Email `Vincentkogei@gmail.com`

## App Description
A java spark app for the Forest Service to conduct an environmental impact study and record number of animals listing whether they are endangered or not.

## Technologies and frameworks used
1. java 11
2. spark core version 2.6.0
3. Gradle 6.0
4. Spark Template Velocity
5. IntelliJ IDEA Community Edition
6. Postgres database

## Database setup.
In Postgres SQL:

* CREATE DATABASE wildlife_tracker;
* CREATE TABLE animals(id SERIAL PRIMARY KEY,name varchar, endangered boolean, age varchar);
* CREATE TABLE sightings(id SERIAL PRIMARY KEY, rangername varchar , location varchar, spotted timestamp, animalid int);
* CREATE DATABASE wildlife_tracker_test;

## Testing
Use junit testing framework with the command below:
* gradle test
## App setup Instructions
Follow the following instructions to run the application:
* clone this repository 'https://github.com/mervinkogei/Wildlife-Tracker'
* cd into the cloned directory
* Open with preferred java Intellij Community in case you are interested in making some modifications
* Run the application using gradle

## License
[MIT LICENCE](license) && Copyright &copy;2019
