# springboot-api-template
This projects aims to be a template for creating Microservices using Spring Boot Native. It's not meant to be packaged of features, rather being a minimal projects that ships with essential features like:

* Embedded Tomcat webserver
* Extensible API Exception handler with customizable error codes
* Built in OpenAPI 3 Swagger generation
* Being shipped with the latest LTS version of GraalVM-Java

## Prerequisites

* GraalVM Java 17 JDK
* Maven

## Building Docker image
Ensure your local Docker demon is running

```
mvn spring-boot:build-native
docker run --rm -p 8080:8080 springnativerest:0.0.1-SNAPSHOT
```



## Building Native Image

### *NIX
You may follow the [official Spring documentation](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/#_with_code_native_image_code).
### Windows

On Windows you need [GraalVM SDK](https://www.graalvm.org/) installed, this project has been tested over CE edition.

Furthermore, you will need Visual Studio Build Tools if you want to compile the jar into a local executable (.exe) file.

Windows Subsystem for Linux (WSL) is suggested for some inline shell scripting.

You can generate a native jar by simply using the

```
PS> mvn package
```

You will find your jar inside __target__ folder. Extract the jar file into a working directory __extracted_jar__.

```
PS> Expand-Archive -LiteralPath springnativerest-0.0.1-SNAPSHOT.jar -DestinationPath ./extracted_jar
PS> cd extracted_jar
PS> Xcopy /E /I META-INF\ BOOT-INF\classes\META-INF
PS> $pwd
```
Copy the current __working directory__, you will need this later.

Execute the __x64 Native Tools Command Prompt for VS 2019__
```
cmd> cd <previously_obtained_working_directory>
cmd> wsl -- find BOOT-INF/lib | wsl tr '\n' ';'
```

last command should output a full list of external jars ';' separated, copy this whole buffer aside.
The list should look like something like this:
```
BOOT-INF/lib;BOOT-INF/lib/classgraph-4.8.147.jar;BOOT-INF/lib/commons-lang3-3.12.0.jar;BOOT-INF/lib/jackson-annotations-2.13.3.jar;BOOT-INF/lib/jackson-core-2.13.3.jar;BOOT-INF/lib/jackson-databind-2.13.3.jar;BOOT-INF/lib/jackson-dataformat-yaml-2.13.3.jar;BOOT-INF/lib/jackson-datatype-jdk8-2.13.3.jar;BOOT-INF/lib/jackson-datatype-jsr310-2.13.3.jar;BOOT-INF/lib/jackson-module-parameter-names-2.13.3.jar;BOOT-INF/lib/jakarta.activation-api-1.2.2.jar;BOOT-INF/lib/jakarta.annotation-api-1.3.5.jar;BOOT-INF/lib/jakarta.validation-api-2.0.2.jar;BOOT-INF/lib/jakarta.xml.bind-api-2.3.3.jar;BOOT-INF/lib/jul-to-slf4j-1.7.36.jar;BOOT-INF/lib/log4j-api-2.17.2.jar;BOOT-INF/lib/log4j-to-slf4j-2.17.2.jar;BOOT-INF/lib/logback-classic-1.2.11.jar;BOOT-INF/lib/logback-core-1.2.11.jar;BOOT-INF/lib/slf4j-api-1.7.36.jar;BOOT-INF/lib/snakeyaml-1.30.jar;BOOT-INF/lib/spring-aop-5.3.22.jar;BOOT-INF/lib/spring-beans-5.3.22.jar;BOOT-INF/lib/spring-boot-2.7.2.jar;BOOT-INF/lib/spring-boot-autoconfigure-2.7.2.jar;BOOT-INF/lib/spring-boot-jarmode-layertools-2.7.2.jar;BOOT-INF/lib/spring-context-5.3.22.jar;BOOT-INF/lib/spring-core-5.3.22.jar;BOOT-INF/lib/spring-expression-5.3.22.jar;BOOT-INF/lib/spring-jcl-5.3.22.jar;BOOT-INF/lib/spring-native-0.12.1.jar;BOOT-INF/lib/spring-web-5.3.22.jar;BOOT-INF/lib/spring-webmvc-5.3.22.jar;BOOT-INF/lib/springdoc-openapi-common-1.6.9.jar;BOOT-INF/lib/springdoc-openapi-ui-1.6.9.jar;BOOT-INF/lib/springdoc-openapi-webmvc-core-1.6.9.jar;BOOT-INF/lib/swagger-annotations-2.2.0.jar;BOOT-INF/lib/swagger-core-2.2.0.jar;BOOT-INF/lib/swagger-models-2.2.0.jar;BOOT-INF/lib/swagger-ui-4.11.1.jar;BOOT-INF/lib/tomcat-embed-core-9.0.65.jar;BOOT-INF/lib/tomcat-embed-el-9.0.65.jar;BOOT-INF/lib/tomcat-embed-websocket-9.0.65.jar;BOOT-INF/lib/webjars-locator-core-0.50.jar;
```
You can now run the __native-image__ command:
```
cmd> native-image -H:Name=springnativerest -cp BOOT-INF/classes;`<previously_obtained_jars_list>`
```

## Known issues
The Exception handler doesn't resolve the exception response when it is compiled as native image.