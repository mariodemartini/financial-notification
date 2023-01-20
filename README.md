# FINANCIAL-NOTIFICATION API
Project carried out as training in the Gerador de Devs.  
The API imports financial spreadsheets, and sends an email automatically when the balance of the month is negative.  

### Prerequisites
What do you need to install to run the project?

* [Gradle](https://gradle.org/)
* [Docker](https://www.docker.com/)
* [Docker-Compose](https://docs.docker.com/compose/)
* [JDK-17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [MySQL](https://www.mysql.com/)

### How to install the application
Clone the file using one of the options below:
#### SSH
```
git@github.com:mariodemartini/financial-notification.git
```  
#### HTTPS
```
https://github.com/mariodemartini/financial-notification.git
```  

### Code versioning best practices
* Using GitFlow
* Using semantic commit

### How to run the application?

Run the command below in the terminal:
```
sh docker-compose-dev.sh
```  

To use your own email change the email fields in resources/application.properties.   

### How to run unit tests?
Run the command below in the terminal
```
./gradlew test
```

### To access the Swagger API documentation
```
http://localhost:8080/swagger-ui.html
```

### Technologies used in the project
* [Gradle](https://gradle.org/) - From mobile apps to microservices, from small businesses to large enterprises, Gradle helps teams build, automate, and deliver better software, faster.
* [Spring Boot Web Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web) - Starter for building web, including RESTful apps, using Spring MVC. Uses Tomcat as the default embedded container.
* [Sprint Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test) - Starter for testing Spring Boot applications with libraries including JUnit, Hamcrest and Mockito.
* [Lombok](https://projectlombok.org/) - Project Lombok is a java library that automatically plugs into your editor and builds tools, spicing up your java. Never write another getter or equals method again, with an annotation your class has a full-featured constructor, automate your registry variables, and more.
* [Model Mapper](https://modelmapper.org/) - Applications often consist of similar but different object models, where the data in two models may be similar, but the structure and concerns of the models are different. Object mapping makes it easy to convert from one model to another, allowing separate models to remain segregated.
* [Swagger](https://swagger.io/) - Swagger is a set of tools that helps us design, that is, model, document and even generate code for API development.
* [Power Mock](https://powermock.github.io/) -  PowerMock is a framework that extends other mock libraries like EasyMock with more powerful features. PowerMock uses a custom class loader and bytecode handling to allow mocking static methods, constructors, final classes and methods, private methods, removing static initializers, and much more.
* [SonarQube](https://www.sonarsource.com/products/sonarqube/) - Developed by SonarSource, SonarQube is a code analysis tool that helps detect problems that may occur in the code, whether they are problems with code smells, security or bugs.