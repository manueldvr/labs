# Migration Tools read me first

Tool for Schema management.

Migrations are the process of moving programming code from one system to another. This is fairly large and complex topic of maintaining computer applications.
DB migrations typically need to occur prior to, or in conjunction with application code. Can lead to run time errors if Db does not match what is expected.

## Intro

Managing many environments and DBs: Dev (H2), CI/CD, QA, UAT, Production.
Dev and CICD databases are easy, just rebuild each time.
QA, UAT, Prod are permanent DBs.

So there are many problem:
* what state are they in?
* Has a script been applied?
* how to create a new database to a release?
* or just prototyping a new type of database.

DB Migration tools can:
* create a new DB
* hold history of migrations
* have a reproducible state of the database
* help manage changes being applied to numerous database instances.

popular Open source DB migration tools:
* Liquibase
* Flyway

### Liquibase-Flyway
Common features:
* command line tools
* integration with Maven and Gradle
* Spring Boot integration
* use script files which can be versiones and tracked
* use DB table to track changes
* have commercial support

### Liquibase Best Practices
#### Terminology
* ChangeSet
* Change
* Changelog
* Preconditions
* Context
* ChangeLog Parameters
#### best practices
* Organizing Change Logs: create a master change log to organize Change Sets.
* One Change Per Change Set: allows for easier roolback if there is a failure.
* Never Modify a Change Set: changes should be additive.
* Use Meaningful Change Set Ids: some use a sequence number, other use a descriptive name.

## Maven plugin
pom definition
````
<plugin>
    <groupId>org.liquibase</groupId>
    <artifactId>liquibase-maven-plugin</artifactId>
    <version>4.2.2</version>
    <configuration>
        <url>jdbc:mysql://127.0.0.1:3306/bookdb?useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=UTC</url>
        <username>bookadmin</username>
        <password>password</password>
    </configuration>
    <dependencies>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>${mysql.version}</version>
        </dependency>
    </dependencies>
</plugin>
````
and inside configuration tag:
```
    ...
        <outputChangeLogFile>changelog.xml</outputChangeLogFile>
        <changeSetAuthor>MDVR</changeSetAuthor>
        <changelogSchemaName>bookdb</changelogSchemaName>
    ...
```

## SBoot Configuration to work with Lbase


## Initializing data with Spring


##  Task


### Guides
The following guides illustrate how to use some features concretely:

* [Maven generateChangeLog](https://docs.liquibase.com/tools-integrations/maven/commands/maven-generatechangelog.html)
