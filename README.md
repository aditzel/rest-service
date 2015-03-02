# Introduction
This application is a simple implementation of a REST service that uses various Spring related projects (e.g. Spring Boot and Spring Framework) as its foundation.

# Requirements

In order to build and run the project you will need to have the following installed:

* Java 7
* Maven 3.2+

# Building The Project

If you have Maven and Java set up correctly:

```
$ mvn clean package
```

The above will generate a file in `target` called `rest-service-0.0.1-SNAPSHOT.jar`.

# Running The Project

In order to run the project, navigate to the project's root directory and then:

```
$ mvn spring-boot:run
```