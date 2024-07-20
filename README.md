<h1 align="center"> Tools API </h1>
<p align="center">
  <a href="#-tecnologies">Tecnologies</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-project">Project</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#memo-license">License</a>
  <p align="center">
  <img alt="License" src="https://img.shields.io/static/v1?label=license&message=MIT&color=49AA26&labelColor=000000">
</p>
</p>

<br>

## 🚀 Tecnologies

A simple project using docker and swagger to test endpoints.

- Java & Spring Boot
- MySQL
- Docker
- Swagger 
- Git & Github 

 <br>

## 💻 Project

This project simulates a basic API that allows users to manage tools with custom queries.

<br>

## :memo: License


This project is under license from MIT

<br>

## Endpoints 
<p>All endpoints are provided by swagger when you run the application. </p>

<br>

<p> Simply input your username, password, and database name in the compose.yaml file, and copy these configurations into the application.properties file. </p>

### Docker
 
```sh
version: "3"

services:
  mysql:
    image: mysql:latest
    container_name: mysql
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: <secret>
      MYSQL_DATABASE: <db_name>
      MYSQL_PASSWORD: <secret>
      MYSQL_USER: <user>
    ports:
      - '3306:3306'
    volumes:
      - db_data:/var/lib/mysql

volumes:
  db_data:
```

<p> And run on terminal: </p>

```sh
  docker compose up -d
```

<br>

### Application.properties
```sh
  spring.datasource.url=jdbc:mysql://localhost:3306/<db_name>
  spring.datasource.username=<user>
  spring.datasource.password=<secret>
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
  
  spring.jpa.hibernate.ddl-auto=create-drop
  spring.jpa.show-sql=true
```

<br>

### Application.properties

<p> Swagger port: </p>

```sh
http://localhost:8080/swagger-ui/index.html
```
<br>

<p>Thanks for your attention, see you next time 💜</p>

