Developer Setup

    Install JDK 1.8
        Set your JAVA_HOME system variable to point to the base directory of your new JDK install
        Add the path to your new JDK/bin directory to your PATH system variable
    Install Maven
        Set your M2_HOME system variable to point to the base directory of your new Maven install
        Add the path to your new Maven/bin directory to your PATH system variable
    Clone git repo
    Navigate to root of your new repository
    Run command mvn spring-boot:run
    Run command mvn -Dspring.profiles.active=dev spring-boot:run
    Access REST endpoints at localhost:8080


Configuration Settings

    application.properties file
        server.port leave as 8080

Spring Boot Actuator Endpoints

    Refer to Swagger URL - /swagger-ui.html