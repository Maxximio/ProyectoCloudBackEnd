# Utiliza la imagen base de Maven para compilar el proyecto
FROM maven:3.8.4-openjdk-21 AS build

# Copia el código fuente al contenedor
COPY pom.xml /project/usr/src/app/
COPY src /project/usr/src/app/src/

# Establece el directorio de trabajo en el código fuente
WORKDIR /project/usr/src/app

# Compila el proyecto y genera el JAR usando Maven
RUN mvn clean package

# Utiliza la imagen base de Java Temurin para ejecutar la aplicación
FROM openjdk:21-alpine

# Establece el directorio de trabajo en el directorio de la aplicación
WORKDIR /app

# Copia el JAR generado desde la fase anterior al contenedor actual
COPY --from=build /project/usr/src/app/target/ProyectoCloudBackEnd-0.0.1-SNAPSHOT.jar /app/app.jar

# Ejecuta la aplicación al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]