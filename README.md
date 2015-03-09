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

# Testing

The application has built-in unit tests that will run as part of the package phase of Maven.
There is a sample json file as per the assignment in ```src/test/resources/sampleCategorytoSubCategory.json```

In order to view the list of available categories point the browser to:

```http://localhost:8080/categories```

In order to add a new category you can send an HTTP POST request to 

```http://localhost:8080/categories```

With a body of:

```
{
    "name": "new category name"
}
```

Should you need to view an individual category you can access:

```http://localhost:8080/categories/{name}``` 

Where {name} is the name of the category you'd like to retrieve.

In order to scrub the data send an HTTP POST request to:

```http://localhost:8080/dataScrubber``` with a JSON payload as per the example file specified above.

The output will be JSON. An example of output based on the sample file specified above is:

```
{
"categoryToSubcategoryMappings":[
    {
        "category":{"name":"PERSON"},
        "subcategory":{"name":"Bob Jones"}
    },
    {
        "category":{"name":"PLACE"},
        "subcategory":{"name":"Washington"}
    },
    {
        "category":{"name":"PERSON"},
        "subcategory":{"name":"Mary"}
    },
    {
        "category":{"name":"COMPUTER"},
        "subcategory":{"name":"Mac"}
    },
    {
        "category":{"name":"OTHER"},
        "subcategory":{"name":"Tree"}
    },
    {
        "category":{"name":"ANIMAL"},
        "subcategory":{"name":"Dog"}
    },
    {
        "category":{"name":"PLACE"},
        "subcategory":{"name":"Texas"}
    },
    {
        "category":{"name":"ANIMAL"},
        "subcategory":{"name":"Cat"}
    }
],
"categoriesCount":
    {
        "PERSON":2,
        "PLACE":2,
        "COMPUTER":1,
        "OTHER":1,
        "ANIMAL":2}
    }
```

If I were to spend more time working on this application I would take advantage of Spring's Integration Testing
features that allow you to write integration tests for your MVC controllers without having the need to manually 
start up a servlet container. Spring's testing framework also allows you to make use of a nice fluent API that
makes setting expectations and then testing against them very easy.

# Deployment
This application is packaged as a standard WAR so can be deployed into any standard Servlet container. If I were
getting this application off the ground and wanted it to scalable I would deploy it via Elastic Beanstalk into
the Amazon infrastructure, this way the application and load balancers in front of it could be configured
to automatically scale based on any number of parameters that include, but are not limited to, CPU, memory, network
utilization, etc.

For monitoring I would use a product like New Relic that would give fairly deep near real-time visibility into
the health of the application. In conjunction with this I would make use of Amazon's Cloud Watch features.

