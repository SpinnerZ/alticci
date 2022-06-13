# Alticci Sequence

![](https://img.shields.io/docker/image-size/spinnerz/alticci?style=plastic)
![](https://img.shields.io/docker/automated/spinnerz/alticci?style=plastic)
![](https://img.shields.io/github/workflow/status/spinnerz/alticci/Build%20Gradle?label=gradle&style=plastic)
![](https://img.shields.io/github/workflow/status/spinnerz/alticci/Docker%20Image%20CI?label=docker%20workflow&style=plastic)
![](https://img.shields.io/github/languages/top/spinnerz/alticci?style=plastic)
![](https://img.shields.io/github/last-commit/spinnerz/alticci/main?style=plastic)

This software is a **REST API** to find the nth number from **Alticci sequence**.
It is defined by:
> n=0 => a(0) = 0  
> n=1 => a(1) = 1  
> n=2 => a(2) = 1  
> n>2 => a(n) = a(n-3) + a(n-2)

## Documentation

Made with OpenApi (Swagger):
> /swagger-ui/index.html

Endpoint:
> GET /alticci/<INDEX_NUMBER>

## Run instructions

+ With Docker

```bash
docker pull spinnerz/alticci
docker run -p <DESIRED_PORT>:8080 --name <CONTAINER_ALIAS> spinnerz/alticci
```

+ Without Docker

```bash
git clone https://github.com/SpinnerZ/alticci.git
cd alticci
./gradlew bootJar
cd build/libs
java -jar alticci.jar
```

### Technologies used

+ [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
+ [Spring Boot](https://spring.io/projects/spring-boot)
+ [Gradle](https://gradle.org/)
+ [Lombok](https://projectlombok.org/)
