# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.example.sp-jpa-intro' is invalid and this project uses 'com.example.spjpaintro' instead.

# Getting Started

## Notes about the project
### Logging
* SQL logging
Setting at application.properties:
spring.jpa.show-sql=true
* Bind parameters
Helps in prevent SQL injection attacks
Building the SQL string from raw strings and concatenating strings together opens the door to sql injection.
Bind parameters as a technique to avoid that vuknerability.
* Show
spring.jpa.show-sql=true
spring.jpa.spring.jpa.show-sql=true
* Format 
spring.jpa.properties.hibernate.format_sql=true

* Trace - it's not recommended
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

* Logging JdbcTemplate Queries
To configure statement logging when using JdbcTemplate, we need the following properties:

logging.level.org.springframework.jdbc.core.JdbcTemplate=DEBUG
logging.level.org.springframework.jdbc.core.StatementCreatorUtils=TRACE

### H2
#### Accessing the H2 Console
spring.h2.console.enabled=true
will log the UUID, like:
o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:de598561-50bd-4fb0-9660-6acad9937e21'
For this particular example can be seen the Hibernate sequence and the Book Table.

#### Compatibility mode
see at application.properties:
spring.datasource.url=jdbc:h2:mem:testdb; ... ;MODE=MYSQL; ...
there are several maximum compatibility modes.

### Profiles
Two profiles are provided:
* default with H2.
* local with MySQL.

### MySQL
#### test Configuration
At MySQIntegrationTest not only JPA layer will be test but also should bring up local profile with MySQL connection.
AutoConfigureTestDatabase is used to avoid overriding of springboot. Sboot initialize with default configuration (with H2).
Check hibernate dialect and active profile in logs.
Check engine=InnoDB.

#### Schema initialization
Using a sequence for each table.
At schema.sql
with spring.jpa.defer-datasource-initialization=false will search this file.
Hib.6 uses only one sequence table causing contention in heavy DBs.
#### last config 
at app.properties:
spring.jpa.database=mysql
see that dialect is MySQL8.
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

