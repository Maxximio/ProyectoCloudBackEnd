# Utiliza la imagen base de Maven para compilar el proyecto
FROM maven:3.8.4-openjdk-17 AS build

# Copia el archivo pom.xml y el código fuente al contenedor
COPY pom.xml /usr/project/src/app/
COPY project /usr/project/src/app/project/

# Establece el directorio de trabajo en el código fuente
WORKDIR /usr/project/src/app

# Compila el proyecto y genera el JAR usando Maven
RUN mvn clean package

# Utiliza la imagen base de Java Temurin para ejecutar la aplicación
FROM openjdk:17-alpine

# Establece el directorio de trabajo en el directorio de la aplicación
WORKDIR /app

# Copia el JAR generado desde la fase anterior al contenedor actual
COPY --from=build /usr/src/app/project/target/ProyectoCloudBackEnd-0.0.1-SNAPSHOT.jar /app/app.jar

# Ejecuta la aplicación al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]
