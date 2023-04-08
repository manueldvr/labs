# Hybernate Primary Keys read me first

## Numeric Primary Keys =surrogate key
```
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
```
__AUTO__ lets Hibernate pick a value.

__SEQUENCE__ use a database sequence, from Oracle, not a feature of MySQL.

__IDENTITY__ use auto-increment database columns. 

Its is going to be significantly more performant than running  from  the sequence tables, so its highly preferred in a MySqL environment.
see V4__ migration file:
```
alter table book change id id BIGINT auto_increment;
```
__TABLE__ use a database table to simulate  sequence.


## UUID Primary Keys =surrogate key

Stands for Universal Unique Identifier, a unique 128 bit value.
Better for big databases. Help in indexing. Downside: use more disk space.

### IETF RFC 4122
An international standrd for UUID generation. 
Hibernate by default implements a default custom generator. So can be configured to generate a IETF RFC 4122 compliant UUID.

## Natural Primary Keys

A unique value with business meaning outside the database.

## Which to Use?

__small tables__ ie, millions rows, Integer or Long.
__large tables__ ie, 10'of millons or billions, favor UUID, if disk space allows.

## Error case
An error exists when Tests run and try to load context:
```
ERROR 47480 --- [  main] o.h.engine.jdbc.spi.SqlExceptionHelper   : La columna "id" no permite valores nulos (NULL)
NULL not allowed for column "id"; SQL statement:
insert into book (author_id, isbn, publisher, title) values (?, ?, ?, ?) [23502-214]
```
A refactor of the database migration to a specific vendor is needed.
```
alter ... id BIGINT auto_increment;
```
this script run fine for MyS environment but not for H2.

### Solution
#### 1
The Spring Boot documentatio on Flyway talks about putting things into a specific folder.
so a new script for h2 is added to flyway migration:
```
V4.1__h2_auto.sql
```
But all scripts run ok for h2, but not for MyS.
Looks like something is out of order. Default configuration will take all subfolders

#### 2
in order to solve the order a refactor should be done. 2 folders are created:
```
db/migration/common
db/migration/h2
```
and at app.properties is clarified to check specific h2 issue:
```
spring.flyway.locations=classpath:db/migration/common
```

## UUID Implementation

First step: ```V5__ added``` to ```db/migration/common```. <br>
where id is a VARCHAR in this first example. There is a more efficient way in next part.

### References

* []()
