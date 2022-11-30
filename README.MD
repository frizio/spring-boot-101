# Spring Boot Project 101

## Run app from command line with Spring Boot Plugin

```console
mvn spring-boot:run
```

## Compile, Package and Run app from command line and jvm parameters

```console
mvn clean package
java -jar -Xms128m -Xmx1024m .	argetspring-boot-101-1.0.0.jar
```

## Run app from command line with Spring Boot Plugin and profiles

```console
mvn spring-boot:run "-Dspring-boot.run.profiles=EN,qa" 
```

## Compile, Package and Run app from command line with profiles in environment variable

```console
dir env:        
$env:SPRING_PROFILES_ACTIVE="ES,qa"
mvn clean package
java -jar .\target\spring-boot-101-1.0.0.jar
```

## Create docker image

```console
mvn clean package
docker build -t spring-boot-101:1.0.0 .
```
