# Utiliza la imagen base de Maven con Java 21 para compilar el proyecto
FROM maven:3.9.5-eclipse-temurin-21 AS build

# Copia el archivo pom.xml y el código fuente al contenedor
COPY project/pom.xml /usr/src/app/
COPY project /usr/src/app/project/

# Establece el directorio de trabajo en el código fuente
WORKDIR /usr/src/app/project

# Compila el proyecto y genera el JAR usando Maven
RUN mvn clean package

# Utiliza la imagen base de Java 21 para ejecutar la aplicación
FROM eclipse-temurin:21-jre-alpine

# Establece el directorio de trabajo en el directorio de la aplicación
WORKDIR /app

# Copia el JAR generado desde la fase anterior al contenedor actual
COPY --from=build /usr/src/app/project/target/ProyectoCloudBackEnd-0.0.1-SNAPSHOT.jar /app/app.jar

# Ejecuta la aplicación al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]
